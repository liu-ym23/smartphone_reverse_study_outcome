package com.obric.server.security.audit;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.obric.security.agentmanager.AgentManager;
import com.obric.security.audit.IObricAuditManager;
import com.obric.security.robots.RobotsProtocolHelper;
import com.obric.server.security.guard.ObricSecurityGuardUtils;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SecurityAuditManagerService extends IObricAuditManager.Stub {
    private static final long AGENT_UUID_REFRESH_MIN_INTERVAL_MS = 60000;
    private static final String DIGEST_ALGORITHM = "SHA-256";
    private static final String EXPORT_DIR = "/data/system/security_audit/export";
    private static final long EXPORT_MAX_BYTES = 209715200;
    private static final int EXPORT_PAGE_SIZE = 2000;
    private static final long EXPORT_RETENTION_MS = 86400000;
    private static final String JSON_KEY_AGENT_NAME = "agent_name";
    private static final String JSON_KEY_LOG_SOURCE = "log_source";
    private static final String JSON_KEY_PAYLOAD_ENCRYPTED = "payload_encrypted";
    private static final String JSON_KEY_PAYLOAD_MODE = "payload_mode";
    private static final String JSON_KEY_PAYLOAD_RAW_ENABLED = "payload_raw_enabled";
    private static final String KEY_SECURITY_LOG_ENABLED = "security_log_enabled";
    private static final String LOG_SOURCE_FRAMEWORK = "framework";
    private static final int SECURITY_LOG_ENABLED = 1;
    private static final String TAG = "SecurityAuditManagerService";
    private volatile ActiveSession mActiveSession;
    private String mAndroidRootCertHashUpper;
    private final Context mContext;
    private long mLastAgentUuidRefreshElapsed;
    private final Object mLock;
    private final RobotsLog mLogHandler;
    private final PackageManager mPackageManager;
    private Set<String> mRegisteredAgentUuids;
    private final AuditRepository mRepository;
    private final Map<Integer, AppIdentity> mUidIdentityCache;
    private final Handler mWorkerHandler;

    private static final class ActiveSession {
        final int agentUid;
        final long expireAtElapsed;
        final String sessionId;

        ActiveSession(String sessionId, int agentUid, long expireAtElapsed) {
            this.sessionId = sessionId;
            this.agentUid = agentUid;
            this.expireAtElapsed = expireAtElapsed;
        }
    }

    private static final class AppIdentity {
        final String packageName;
        final String rootCertHashUpper;

        AppIdentity(String packageName, String rootCertHashUpper) {
            this.packageName = packageName;
            this.rootCertHashUpper = rootCertHashUpper;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRepository, reason: not valid java name */
    static /* bridge */ /* synthetic */ AuditRepository m89$$Nest$fgetmRepository(SecurityAuditManagerService r0) {
        return r0.mRepository;
    }

    /* JADX INFO: renamed from: -$$Nest$mcleanupExportDir, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m90$$Nest$mcleanupExportDir(SecurityAuditManagerService r0) {
        r0.cleanupExportDir();
    }

    /* JADX INFO: renamed from: -$$Nest$mensureExportDir, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m91$$Nest$mensureExportDir(SecurityAuditManagerService r0) {
        return r0.ensureExportDir();
    }

    public SecurityAuditManagerService(Context context, AuditRepository repository, Handler workerHandler) {
        this.mLock = new Object();
        this.mUidIdentityCache = new HashMap();
        this.mLogHandler = new RobotsLog();
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
        this.mRepository = repository;
        this.mWorkerHandler = workerHandler;
    }

    public int recordAuditWithResult(String json) throws RemoteException {
        int uid = Binder.getCallingUid();
        Log.d(TAG, "recordAuditWithResult from uid=" + uid);
        if (TextUtils.isEmpty(json) == false) goto L5;
    L49:
        Log.w(TAG, "recordAuditWithResult: invalid payload for uid=" + uid);
        return 4;
    L5:
        if (this.mLogHandler.isValidPayload(json) == false) goto L49;
        int preCheck = checkCallerAndBuildContext(uid, json);
        if (preCheck == 0) goto L11;
        Log.w(TAG, "recordAuditWithResult preCheck denied for uid=" + uid + ", result=" + preCheck);
        return preCheck;
    L11:
        Log.d(TAG, "recordAuditWithResult allowed for uid=" + uid + ", result=" + preCheck);
        String instructionId = resolveActiveSessionId();
        final AuditLogEntry entry = this.mLogHandler.buildEntry(System.currentTimeMillis(), instructionId, json);
        boolean robotsEnabled = isRobotsProtocolEnabled();
        boolean securityLogEnabled = isSecurityLogEnabled();
        if (robotsEnabled == true) goto L17;
        if (securityLogEnabled == true) goto L17;
        Log.i(TAG, "recordAuditWithResult: robots and security log disabled, reject write");
        return -10;
    L17:
        if (robotsEnabled == true) goto L19;
        entry.payloadRaw = null;
    L19:
        if (securityLogEnabled == false) goto L21;
        maybeFillFrameworkPayloadEncrypted(uid, entry, json);
    L23:
        if (entry.payloadRaw != null) goto L29;
        if (entry.payloadEncrypted != null) goto L29;
        Log.i(TAG, "recordAuditWithResult: no payload to persist after switch filtering");
        return 0;
    L29:
        if (securityLogEnabled == true) goto L31;
    L33:
        boolean r12 = false;
    L34:
        entry.uploadEnabled = r12;
        final int[] resultHolder = {100};
        final CountDownLatch latch = new CountDownLatch(SECURITY_LOG_ENABLED);
        this.mWorkerHandler.post(new AnonymousClass1(this, resultHolder, entry, latch));
        int r16 = 7;
    L43:
        e = e;
    L47:
        Thread.currentThread().interrupt();
        Log.w(TAG, "recordAuditWithResult: interrupted", e);
        return r16;
    L38:
        if (latch.await(2, TimeUnit.SECONDS) == true) goto L41;
        Log.w(TAG, "recordAuditWithResult: db write timeout for uid=" + uid);     // Catch: InterruptedException -> L43
        return 7;
    L41:
        int result = resultHolder[0];
        Log.d(TAG, "recordAuditWithResult finished for uid=" + uid + ", result=" + result);
        return result;
    L45:
        e = e;
        r16 = 7;
        goto L47
    L31:
        if (entry.payloadEncrypted == null) goto L33;
        r12 = SECURITY_LOG_ENABLED;
        goto L34
    L21:
        entry.payloadEncrypted = null;
        goto L23
    }

    public List<String> queryLogs(final long startTimeMs, final long endTimeMs, final String targetIntent, final String targetActivity) throws RemoteException {
        int uid = Binder.getCallingUid();
        String callerPackage = ObricSecurityGuardUtils.getCallingPackageName(this.mContext);
        if (TextUtils.isEmpty(callerPackage) == true) goto L31;
    L13:
        String callerPackage2 = callerPackage;
    L15:
        if (TextUtils.isEmpty(callerPackage2) == false) goto L18;
        Log.w(TAG, "queryLogs: no package for uid=" + uid);
        return new ArrayList();
    L18:
        final String finalCallerPackage = callerPackage2;
        final List<String>[] resultHolder = new List[SECURITY_LOG_ENABLED];
        final CountDownLatch latch = new CountDownLatch(SECURITY_LOG_ENABLED);
        this.mWorkerHandler.post(new AnonymousClass2(this, resultHolder, startTimeMs, endTimeMs, finalCallerPackage, targetIntent, targetActivity, latch));
    L28:
        e = move-exception;
        Thread.currentThread().interrupt();
        Log.w(TAG, "queryLogs interrupted", e);
        return new ArrayList();
    L20:
        if (latch.await(5, TimeUnit.SECONDS) == true) goto L24;
        Log.w(TAG, "queryLogs timeout");     // Catch: InterruptedException -> L28
        return new ArrayList();
    L24:
        if (resultHolder[0] == null) goto L27;
        return resultHolder[0];
    L27:
        return new ArrayList();
    L31:
        PackageManager pm = this.mPackageManager;     // Catch: RuntimeException -> L11
        String[] pkgs = pm.getPackagesForUid(uid);     // Catch: RuntimeException -> L11
        if (pkgs != null) goto L7;
    L10:
        callerPackage2 = callerPackage;
        goto L15
    L7:
        if (pkgs.length <= 0) goto L10;
        callerPackage = pkgs[0];     // Catch: RuntimeException -> L11
    L11:
        e = move-exception;
        Log.w(TAG, "queryLogs: getPackagesForUid failed for uid=" + uid, e);
        goto L13
    }

    public ParcelFileDescriptor exportAllLogs(final long startTimeMs, final long endTimeMs, final boolean gzip) throws RemoteException {
        int uid = Binder.getCallingUid();
        Log.d(TAG, "exportAllLogs request from uid=" + uid + ", startTimeMs=" + startTimeMs + ", endTimeMs=" + endTimeMs + ", gzip=" + gzip);
        if (isCallerAllowedForExport(uid) == true) goto L6;
        Log.w(TAG, "exportAllLogs denied for uid=" + uid);
        return null;
    L6:
        final ParcelFileDescriptor[] resultHolder = new ParcelFileDescriptor[SECURITY_LOG_ENABLED];
        final CountDownLatch latch = new CountDownLatch(SECURITY_LOG_ENABLED);
        this.mWorkerHandler.post(new AnonymousClass3(this, resultHolder, gzip, startTimeMs, endTimeMs, latch));
    L13:
        e = move-exception;
        Thread.currentThread().interrupt();
        Log.w(TAG, "exportAllLogs: interrupted", e);
        return null;
    L8:
        if (latch.await(5, TimeUnit.MINUTES) == true) goto L12;
        Log.w(TAG, "exportAllLogs: timeout for uid=" + uid);     // Catch: InterruptedException -> L13
        return null;
    L12:
        return resultHolder[0];
    }

    private int checkCallerAndBuildContext(int uid, String json) {
        if (uid != 1000) goto L6;
        Log.d(TAG, "recordAudit allow: system uid=" + uid);
        return 0;
    L6:
        String agentName = extractAgentName(json);
        if (TextUtils.isEmpty(agentName) == false) goto L10;
        Log.w(TAG, "recordAudit deny: missing agent_name for uid=" + uid);
        return 5;
    L10:
        AppIdentity identity = getOrResolveAppIdentity(uid);
        if (identity != null) goto L13;
    L27:
        Log.w(TAG, "recordAudit deny: failed to resolve AppIdentity for uid=" + uid);
        return 3;
    L13:
        if (TextUtils.isEmpty(identity.packageName) == true) goto L27;
        if (TextUtils.isEmpty(identity.rootCertHashUpper) == true) goto L27;
        String agentUuid = computeAgentUuid(agentName, identity.packageName, identity.rootCertHashUpper);
        Log.d(TAG, "recordAudit: uid=" + uid + ", agentName=" + agentName + ", pkg=" + identity.packageName + ", rootCertHashUpper=" + identity.rootCertHashUpper + ", computedUuid=" + agentUuid);
        if (TextUtils.isEmpty(agentUuid) == false) goto L21;
        Log.w(TAG, "recordAudit deny: computed agentUuid is empty for uid=" + uid);
        return 4;
    L21:
        boolean allowed = isAgentUuidAllowed(agentUuid);
        if (allowed == false) goto L25;
        Log.d(TAG, "recordAudit allow: agentUuid is registered for uid=" + uid);
        return 0;
    L25:
        Log.w(TAG, "recordAudit deny: agentUuid not registered for uid=" + uid);
        return 3;
    }

    private String extractAgentName(String json) {
        if (TextUtils.isEmpty(json) == false) goto L13;
        return null;
    L13:
        JSONObject object = new JSONObject(json);     // Catch: JSONException -> L10
        String agentName = optNullableString(object, "agent_name");     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(agentName) == false) goto L9;
        Log.w(TAG, "extractAgentName: agent_name missing in json");     // Catch: JSONException -> L10
        return null;
    L9:
        return agentName;
    L10:
        e = move-exception;
        Log.w(TAG, "extractAgentName: invalid json", e);
        return null;
    }

    private AppIdentity getOrResolveAppIdentity(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AppIdentity cached = this.mUidIdentityCache.get(Integer.valueOf(uid));     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        if (cached == null) goto L9;
        Log.d(TAG, "getOrResolveAppIdentity: cache hit for uid=" + uid + ", pkg=" + cached.packageName);
        return cached;
    L9:
        Log.d(TAG, "getOrResolveAppIdentity: cache miss for uid=" + uid + ", resolving via PMS");
        AppIdentity resolved = resolveAppIdentityFromPms(uid);
        if (resolved != null) goto L13;
        return null;
    L13:
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mUidIdentityCache.put(Integer.valueOf(uid), resolved);     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
        return resolved;
    L18:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        throw th;
    }

    private AppIdentity resolveAppIdentityFromPms(int uid) {
        PackageManager pm = this.mPackageManager;
        String[] pkgs = null;
        pkgs = pm.getPackagesForUid(uid);     // Catch: RuntimeException -> L5
    L8:
        if (pkgs != null) goto L10;
    L31:
        Log.w(TAG, "resolveAppIdentityFromPms: no packages for uid=" + uid);
        return null;
    L10:
        if (pkgs.length == 0) goto L31;
        String pkgName = pkgs[0];
        PackageInfo info = pm.getPackageInfo(pkgName, 134217728);     // Catch: RuntimeException -> L26 PackageManager.NameNotFoundException -> L28
        SigningInfo signingInfo = info.signingInfo;     // Catch: RuntimeException -> L26 PackageManager.NameNotFoundException -> L28
        if (signingInfo != null) goto L17;
        Log.w(TAG, "resolveAppIdentityFromPms: no SigningInfo for pkg=" + pkgName);     // Catch: RuntimeException -> L26 PackageManager.NameNotFoundException -> L28
        return null;
    L17:
        Signature[] signers = signingInfo.getApkContentsSigners();     // Catch: RuntimeException -> L26 PackageManager.NameNotFoundException -> L28
        if (signers != null) goto L20;
    L24:
        Log.w(TAG, "resolveAppIdentityFromPms: no signatures for pkg=" + pkgName);     // Catch: RuntimeException -> L26 PackageManager.NameNotFoundException -> L28
        return null;
    L20:
        if (signers.length == 0) goto L24;
        Signature root = signers[0];     // Catch: RuntimeException -> L26 PackageManager.NameNotFoundException -> L28
        String rootCertHashUpper = sha256Hex(root.toByteArray());     // Catch: RuntimeException -> L26 PackageManager.NameNotFoundException -> L28
        Log.d(TAG, "resolveAppIdentityFromPms: uid=" + uid + ", pkg=" + pkgName + ", rootCertHashUpper=" + rootCertHashUpper);     // Catch: RuntimeException -> L26 PackageManager.NameNotFoundException -> L28
        return new AppIdentity(pkgName, rootCertHashUpper);
    L28:
        e = move-exception;
        Log.w(TAG, "resolveAppIdentityFromPms: package not found for uid=" + uid + ", pkg=" + pkgName, e);
    L30:
        return null;
    L26:
        e = move-exception;
        Log.w(TAG, "resolveAppIdentityFromPms: unexpected exception for uid=" + uid + ", pkg=" + pkgName, e);
    L5:
        e = move-exception;
        Log.w(TAG, "resolveAppIdentityFromPms: getPackagesForUid failed for uid=" + uid, e);
        goto L8
    }

    private boolean isAgentUuidAllowed(String agentUuid) {
        boolean allowed = false;
        if (TextUtils.isEmpty(agentUuid) == false) goto L5;
        return false;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L45:
        th = move-exception;
        throw th;
    L8:
        if (this.mRegisteredAgentUuids != null) goto L10;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L45
        Log.d(TAG, "isAgentUuidAllowed: cache miss for agentUuid=" + agentUuid + ", refreshing from AgentManager");
        long nowElapsed = SystemClock.elapsedRealtime();
        Object r2 = this.mLock;
        monitor-enter(r2);
    L42:
        th = move-exception;
        throw th;
    L18:
        if ((nowElapsed - this.mLastAgentUuidRefreshElapsed) < AGENT_UUID_REFRESH_MIN_INTERVAL_MS) goto L20;
        boolean shouldRefresh = SECURITY_LOG_ENABLED;
    L21:
        if (shouldRefresh == false) goto L23;
        this.mLastAgentUuidRefreshElapsed = nowElapsed;     // Catch: Throwable -> L42
    L23:
        monitor-exit(r2);     // Catch: Throwable -> L42
        if (shouldRefresh == true) goto L26;
        Log.d(TAG, "isAgentUuidAllowed: skip refresh due to rate limit");
    L27:
        Object r6 = this.mLock;
        monitor-enter(r6);
    L39:
        th = move-exception;
        throw th;
    L30:
        if (this.mRegisteredAgentUuids != null) goto L32;
    L34:
        if (allowed == false) goto L36;
        Log.d(TAG, "isAgentUuidAllowed: allowed after refresh for agentUuid=" + agentUuid);     // Catch: Throwable -> L39
    L37:
        monitor-exit(r6);     // Catch: Throwable -> L39
        return allowed;
    L36:
        Log.d(TAG, "isAgentUuidAllowed: still not found after refresh for agentUuid=" + agentUuid);     // Catch: Throwable -> L39
        goto L37
    L32:
        if (this.mRegisteredAgentUuids.contains(agentUuid) == false) goto L34;
        allowed = SECURITY_LOG_ENABLED;
        goto L34
    L26:
        refreshAgentUuidCache();
        goto L27
    L20:
        shouldRefresh = false;
        goto L21
    L10:
        if (this.mRegisteredAgentUuids.contains(agentUuid) == false) goto L14;
        Log.d(TAG, "isAgentUuidAllowed: cache hit for agentUuid=" + agentUuid);     // Catch: Throwable -> L45
        monitor-exit(r0);     // Catch: Throwable -> L45
        return true;
    }

    private void refreshAgentUuidCache() {
        List<String> list = null;
        list = AgentManager.getInstance().listRegisteredAgents();     // Catch: RuntimeException -> L5
    L7:
        if (list != null) goto L10;
        Log.w(TAG, "refreshAgentUuidCache: listRegisteredAgents returned null");
        return;
    L10:
        Set<String> newSet = new HashSet();
        Iterator<String> r2 = list.iterator();
    L12:
        if (r2.hasNext() == false) goto L17;
        String uuid = r2.next();
        if (TextUtils.isEmpty(uuid) == true) goto L12;
        newSet.add(uuid);
        goto L12
    L17:
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mRegisteredAgentUuids = newSet;     // Catch: Throwable -> L23
        monitor-exit(r3);     // Catch: Throwable -> L23
        Log.d(TAG, "refreshAgentUuidCache: size=" + newSet.size());
        return;
    L23:
        th = move-exception;
        throw th;
    L5:
        e = move-exception;
        Log.w(TAG, "refreshAgentUuidCache: listRegisteredAgents threw exception", e);
        goto L7
    }

    private String computeAgentUuid(String agentName, String pkgName, String rootCertHashUpper) {
        if (agentName == null) goto L10;
        if (pkgName == null) goto L12;
        if (rootCertHashUpper == null) goto L13;
        String material = agentName + pkgName + rootCertHashUpper;
        String agentUuid = sha256Hex(material);
        if (agentUuid != null) goto L9;
        Log.w(TAG, "computeAgentUuid: failed to compute SHA-256");
    L9:
        return agentUuid;
    L13:
        return null;
    L12:
        return null;
    L10:
        return null;
    }

    private boolean isCallerAllowedForExport(int uid) {
        if (uid != 1000) goto L6;
        Log.d(TAG, "exportAllLogs allow: system uid=" + uid);
        return true;
    L6:
        AppIdentity identity = getOrResolveAppIdentity(uid);
        if (identity != null) goto L9;
    L27:
        Log.w(TAG, "isCallerAllowedForExport: failed to resolve identity for uid=" + uid);
        return false;
    L9:
        if (TextUtils.isEmpty(identity.packageName) == true) goto L27;
        if (TextUtils.isEmpty(identity.rootCertHashUpper) == true) goto L27;
        if (isExportPackageWhitelisted(identity.packageName) == true) goto L17;
        Log.w(TAG, "isCallerAllowedForExport: pkg not in export whitelist, uid=" + uid + ", pkg=" + identity.packageName);
        return false;
    L17:
        String androidRootHash = getAndroidRootCertHashUpper();
        if (TextUtils.isEmpty(androidRootHash) == false) goto L22;
        Log.w(TAG, "isCallerAllowedForExport: android root hash empty");
        return false;
    L22:
        if (androidRootHash.equals(identity.rootCertHashUpper) == true) goto L25;
        Log.w(TAG, "isCallerAllowedForExport: root cert mismatch for uid=" + uid + ", pkg=" + identity.packageName + ", callerRoot=" + identity.rootCertHashUpper + ", androidRoot=" + androidRootHash);
        return false;
    L25:
        Log.d(TAG, "isCallerAllowedForExport: allowed uid=" + uid + ", pkg=" + identity.packageName);
        return true;
    }

    private boolean isExportPackageWhitelisted(String pkg) {
        if (TextUtils.isEmpty(pkg) == false) goto L5;
        return false;
    L5:
        String[] whitelist = {"com.obric.security.audit.maintainer"};
        int r2 = whitelist.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        String allow = whitelist[r3];
        if (pkg.equals(allow) == true) goto L9;
        r3 = r3 + SECURITY_LOG_ENABLED;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private String getAndroidRootCertHashUpper() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(this.mAndroidRootCertHashUpper) == true) goto L9;
        String r1 = this.mAndroidRootCertHashUpper;     // Catch: Throwable -> L36
        monitor-exit(r0);     // Catch: Throwable -> L36
        return r1;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L36
        PackageManager pm = this.mPackageManager;
        PackageInfo info = pm.getPackageInfo("android", 134217728);     // Catch: RuntimeException -> L31 PackageManager.NameNotFoundException -> L33
        SigningInfo signingInfo = info.signingInfo;     // Catch: RuntimeException -> L31 PackageManager.NameNotFoundException -> L33
        if (signingInfo != null) goto L15;
        Log.w(TAG, "getAndroidRootCertHashUpper: no SigningInfo for android");     // Catch: RuntimeException -> L31 PackageManager.NameNotFoundException -> L33
        return null;
    L15:
        Signature[] signers = signingInfo.getApkContentsSigners();     // Catch: RuntimeException -> L31 PackageManager.NameNotFoundException -> L33
        if (signers != null) goto L18;
    L29:
        Log.w(TAG, "getAndroidRootCertHashUpper: no signatures for android");     // Catch: RuntimeException -> L31 PackageManager.NameNotFoundException -> L33
        return null;
    L18:
        if (signers.length == 0) goto L29;
        Signature root = signers[0];     // Catch: RuntimeException -> L31 PackageManager.NameNotFoundException -> L33
        String hash = sha256Hex(root.toByteArray());     // Catch: RuntimeException -> L31 PackageManager.NameNotFoundException -> L33
        Object r7 = this.mLock;     // Catch: RuntimeException -> L31 PackageManager.NameNotFoundException -> L33
        monitor-enter(r7);     // Catch: RuntimeException -> L31 PackageManager.NameNotFoundException -> L33
        this.mAndroidRootCertHashUpper = hash;     // Catch: Throwable -> L26
        monitor-exit(r7);     // Catch: Throwable -> L26
        Log.d(TAG, "getAndroidRootCertHashUpper: " + hash);     // Catch: RuntimeException -> L31 PackageManager.NameNotFoundException -> L33
        return hash;
    L26:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L31 PackageManager.NameNotFoundException -> L33
    L33:
        e = move-exception;
        Log.w(TAG, "getAndroidRootCertHashUpper: android package not found", e);
    L35:
        return null;
    L31:
        e = move-exception;
        Log.w(TAG, "getAndroidRootCertHashUpper: unexpected exception", e);
        goto L35
    }

    private File ensureExportDir() {
        File dir = new File(EXPORT_DIR);
        if (dir.exists() == true) goto L9;
        if (dir.mkdirs() == true) goto L9;
        Log.e(TAG, "ensureExportDir: failed to create /data/system/security_audit/export");
        return null;
    L9:
        if (dir.isDirectory() == true) goto L12;
        Log.e(TAG, "ensureExportDir: not a directory /data/system/security_audit/export");
        return null;
    L12:
        return dir;
    }

    private void cleanupExportDir() {
        File dir = new File(EXPORT_DIR);
        if (dir.exists() == false) goto L49;
        if (dir.isDirectory() == false) goto L64;
        File[] files = dir.listFiles();
        if (files == null) goto L47;
        if (files.length == 0) goto L63;
        long now = System.currentTimeMillis();
        List<File> candidates = new ArrayList();
        long totalBytes = 0;
        int r7 = files.length;
        int r8 = 0;
    L14:
        if (r8 >= r7) goto L25;
        File f = files[r8];
        if (f == null) goto L24;
        if (f.isFile() == false) goto L24;
        long age = now - f.lastModified();
        if (age <= EXPORT_RETENTION_MS) goto L23;
        boolean deleted = f.delete();
        Log.d(TAG, "cleanupExportDir: delete expired file " + f.getName() + ", deleted=" + deleted);
        goto L24
    L23:
        candidates.add(f);
        totalBytes = totalBytes + f.length();
    L24:
        r8 = r8 + SECURITY_LOG_ENABLED;
        goto L14
    L25:
        long r9 = EXPORT_MAX_BYTES;
        if (totalBytes <= EXPORT_MAX_BYTES) goto L45;
        if (candidates.isEmpty() == true) goto L62;
        candidates.sort(new AnonymousClass4(this));
        int remaining = candidates.size();
        Iterator<File> r12 = candidates.iterator();
    L32:
        if (r12.hasNext() == false) goto L43;
        File f2 = r12.next();
        if (totalBytes <= r9) goto L60;
        if (remaining <= SECURITY_LOG_ENABLED) goto L61;
        long len = f2.length();
        boolean deleted2 = f2.delete();
        if (deleted2 == false) goto L41;
        totalBytes = totalBytes - len;
        Log.d(TAG, "cleanupExportDir: delete old file " + f2.getName() + ", size=" + len + ", remainBytes=" + totalBytes);
    L42:
        remaining = remaining - 1;
        r9 = EXPORT_MAX_BYTES;
        goto L32
    L41:
        Log.w(TAG, "cleanupExportDir: failed to delete " + f2.getName());
        goto L42
    L61:
        return;
    L60:
        return;
    L43:
        return;
    L62:
        return;
    L45:
        return;
    L63:
        return;
    L47:
        return;
    L64:
        return;
    }

    private static String sha256Hex(String input) {
        if (input != null) goto L6;
        return null;
    L6:
        return sha256Hex(input.getBytes(StandardCharsets.UTF_8));
    }

    private static String sha256Hex(byte[] data) {
        if (data != null) goto L14;
        return null;
    L14:
        MessageDigest md = MessageDigest.getInstance(DIGEST_ALGORITHM);     // Catch: NoSuchAlgorithmException -> L11
        byte[] digest = md.digest(data);     // Catch: NoSuchAlgorithmException -> L11
        char[] HEX = "0123456789ABCDEF".toCharArray();     // Catch: NoSuchAlgorithmException -> L11
        char[] out = new char[digest.length * 2];     // Catch: NoSuchAlgorithmException -> L11
        int i = 0;
    L7:
        if (i >= digest.length) goto L9;
        int v = digest[i] & 255;     // Catch: NoSuchAlgorithmException -> L11
        out[i * 2] = HEX[v >>> 4];     // Catch: NoSuchAlgorithmException -> L11
        out[(i * 2) + SECURITY_LOG_ENABLED] = HEX[v & 15];     // Catch: NoSuchAlgorithmException -> L11
        i = i + SECURITY_LOG_ENABLED;     // Catch: NoSuchAlgorithmException -> L11
        goto L7
    L9:
        return new String(out);
    L11:
        e = move-exception;
        Log.w(TAG, "sha256Hex: SHA-256 not supported", e);
        return null;
    }

    public int setActiveSession(String sessionId, long ttlMs) throws RemoteException {
        int uid = Binder.getCallingUid();
        if (TextUtils.isEmpty(sessionId) == false) goto L7;
        return 4;
    L7:
        if (uid == 1000) goto L22;
        AppIdentity identity = getOrResolveAppIdentity(uid);
        if (identity != null) goto L11;
    L19:
        Log.w(TAG, "setActiveSession: cannot resolve identity for uid=" + uid);
        return 3;
    L11:
        if (TextUtils.isEmpty(identity.packageName) == true) goto L19;
        String androidRootHash = getAndroidRootCertHashUpper();
        if (androidRootHash != null) goto L16;
    L17:
        Log.w(TAG, "setActiveSession: not platform-signed, uid=" + uid + ", pkg=" + identity.packageName);
        return 3;
    L16:
        if (androidRootHash.equals(identity.rootCertHashUpper) == false) goto L17;
    L22:
        if (ttlMs <= 0) goto L24;
        long effectiveTtlMs = ttlMs;
    L25:
        this.mActiveSession = new ActiveSession(sessionId, uid, SystemClock.elapsedRealtime() + effectiveTtlMs);
        Log.d(TAG, "setActiveSession: sessionId=" + sessionId + ", ttlMs=" + effectiveTtlMs + ", uid=" + uid);
        return 0;
    L24:
        effectiveTtlMs = 600000;
        goto L25
    }

    public void clearActiveSession(String sessionId) throws RemoteException {
        int uid = Binder.getCallingUid();
        ActiveSession current = this.mActiveSession;
        if (current != null) goto L6;
        return;
    L6:
        if (SystemClock.elapsedRealtime() <= current.expireAtElapsed) goto L10;
        this.mActiveSession = null;
        return;
    L10:
        if (uid != 1000) goto L12;
    L15:
        if (sessionId != null) goto L17;
    L19:
        this.mActiveSession = null;
        Log.d(TAG, "clearActiveSession: cleared sessionId=" + current.sessionId + ", uid=" + uid);
        return;
    L17:
        if (sessionId.equals(current.sessionId) == true) goto L19;
        return;
    L12:
        if (uid == current.agentUid) goto L15;
        Log.w(TAG, "clearActiveSession: permission denied, uid=" + uid + ", owner=" + current.agentUid);
    }

    public int getPendingUploadCount() throws RemoteException {
        enforceSecurityServerCaller();
        if (isSecurityLogEnabled() == true) goto L5;
        return 0;
    L5:
        final int[] resultHolder = new int[SECURITY_LOG_ENABLED];
        final CountDownLatch latch = new CountDownLatch(SECURITY_LOG_ENABLED);
        this.mWorkerHandler.post(new AnonymousClass5(this, resultHolder, latch));
        if (latch.await(2, TimeUnit.SECONDS) == true) goto L10;
        return 0;
    L10:
        return resultHolder[0];
    L12:
        Thread.currentThread().interrupt();
        return 0;
    }

    public String getPendingUploadReport(final int maxCount, final int maxBytes) throws RemoteException {
        enforceSecurityServerCaller();
        if (isSecurityLogEnabled() == true) goto L5;
        return null;
    L5:
        final String[] resultHolder = new String[SECURITY_LOG_ENABLED];
        final CountDownLatch latch = new CountDownLatch(SECURITY_LOG_ENABLED);
        this.mWorkerHandler.post(new AnonymousClass6(this, resultHolder, maxCount, maxBytes, latch));
        if (latch.await(5, TimeUnit.SECONDS) == true) goto L10;
        return null;
    L10:
        return resultHolder[0];
    L12:
        Thread.currentThread().interrupt();
        return null;
    }

    public int confirmUploadSuccess(final String batchId) throws RemoteException {
        enforceSecurityServerCaller();
        final int[] resultHolder = new int[SECURITY_LOG_ENABLED];
        final CountDownLatch latch = new CountDownLatch(SECURITY_LOG_ENABLED);
        this.mWorkerHandler.post(new AnonymousClass7(this, resultHolder, batchId, latch));
        if (latch.await(2, TimeUnit.SECONDS) == true) goto L7;
        return 7;
    L7:
        return resultHolder[0];
    L9:
        Thread.currentThread().interrupt();
        return 7;
    }

    public int confirmUploadFailure(final String batchId, final int errorCode, String errorMessage) throws RemoteException {
        enforceSecurityServerCaller();
        final int[] resultHolder = new int[SECURITY_LOG_ENABLED];
        final CountDownLatch latch = new CountDownLatch(SECURITY_LOG_ENABLED);
        this.mWorkerHandler.post(new AnonymousClass8(this, resultHolder, batchId, errorCode, latch));
        if (latch.await(2, TimeUnit.SECONDS) == true) goto L7;
        return 7;
    L7:
        return resultHolder[0];
    L9:
        Thread.currentThread().interrupt();
        return 7;
    }

    private void maybeFillFrameworkPayloadEncrypted(int uid, AuditLogEntry entry, String originalJson) {
        if (entry != null) goto L4;
        return;
    L4:
        if (entry.payloadEncrypted == null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(originalJson) == false) goto L9;
        return;
    L9:
        if (uid == 1000) goto L11;
        return;
    L11:
        if ("framework".equals(entry.logSource) == false) goto L26;
        JSONObject uploadPayload = new JSONObject(originalJson);     // Catch: JSONException -> L18
        if ("framework".equals(optNullableString(uploadPayload, "log_source")) == true) goto L16;
        return;
    L16:
        uploadPayload.remove(JSON_KEY_PAYLOAD_ENCRYPTED);     // Catch: JSONException -> L18
        uploadPayload.remove(JSON_KEY_PAYLOAD_MODE);     // Catch: JSONException -> L18
        uploadPayload.remove(JSON_KEY_PAYLOAD_RAW_ENABLED);     // Catch: JSONException -> L18
        entry.payloadEncrypted = uploadPayload.toString().getBytes(StandardCharsets.UTF_8);     // Catch: JSONException -> L18
        return;
    L18:
        e = move-exception;
        Log.w(TAG, "maybeFillFrameworkPayloadEncrypted: invalid framework payload", e);
        return;
    }

    private static String optNullableString(JSONObject object, String key) {
        if (object != null) goto L4;
        return null;
    L4:
        if (object.has(key) == true) goto L6;
        return null;
    L6:
        if (object.isNull(key) == false) goto L9;
        return null;
    L9:
        return object.optString(key, "");
    }

    private boolean isSecurityLogEnabled() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), KEY_SECURITY_LOG_ENABLED, SECURITY_LOG_ENABLED) == SECURITY_LOG_ENABLED) goto L13;
        return false;
    L13:
        return true;
    L8:
        e = move-exception;
        Log.w(TAG, "isSecurityLogEnabled failed, default enabled", e);
        return true;
    }

    private boolean isRobotsProtocolEnabled() {
        return RobotsProtocolHelper.isRobotsEnabled(this.mContext);
    }

    private String resolveActiveSessionId() {
        ActiveSession session = this.mActiveSession;
        if (session != null) goto L6;
        return null;
    L6:
        if (SystemClock.elapsedRealtime() <= session.expireAtElapsed) goto L9;
        this.mActiveSession = null;
        return null;
    L9:
        int callingUid = Binder.getCallingUid();
        if (callingUid == 1000) goto L16;
        if (callingUid == session.agentUid) goto L16;
        Log.w(TAG, "resolveActiveSessionId: uid mismatch, calling=" + callingUid + ", session owner=" + session.agentUid);
        return null;
    L16:
        return session.sessionId;
    }

    private void enforceSecurityServerCaller() {
        int uid = Binder.getCallingUid();
        String[] packages = this.mPackageManager.getPackagesForUid(uid);
        if (packages == null) goto L25;
        boolean found = false;
        int r3 = packages.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L11;
        String pkg = packages[r4];
        if ("com.bytedance.securityserver".equals(pkg) == true) goto L9;
        r4 = r4 + SECURITY_LOG_ENABLED;
        goto L6
    L9:
        found = true;
    L11:
        if (found == false) goto L23;
        if (isSystemApp("com.bytedance.securityserver") == false) goto L15;
        return;
    L15:
        String certDigest = getSigningCertDigest("com.bytedance.securityserver");
        if (certDigest != null) goto L18;
    L20:
        Log.e(TAG, "enforceSecurityServerCaller: signature mismatch for uid=" + uid);
        throw new SecurityException("SecurityServer signature mismatch");
    L18:
        if (certDigest.equals("F3A54A8B336759BD84C3305FA995E249F198FD6B6430209FA12256C6C7C61B03") == false) goto L20;
        return;
    L23:
        throw new SecurityException("caller is not SecurityServer: uid=" + uid);
    L25:
        throw new SecurityException("caller is not SecurityServer: no packages for uid=" + uid);
    }

    private String getSigningCertDigest(String packageName) {
        PackageInfo info = this.mPackageManager.getPackageInfo(packageName, 134217728);     // Catch: Exception -> L14
        SigningInfo signingInfo = info.signingInfo;     // Catch: Exception -> L14
        if (signingInfo != null) goto L6;
        return null;
    L6:
        Signature[] signers = signingInfo.getApkContentsSigners();     // Catch: Exception -> L14
        if (signers != null) goto L9;
    L13:
        return null;
    L9:
        if (signers.length == 0) goto L13;
        return sha256Hex(signers[0].toByteArray());
    L14:
        e = move-exception;
        Log.w(TAG, "getSigningCertDigest: failed for pkg=" + packageName, e);
        return null;
    }

    private boolean isSystemApp(String packageName) {
        ApplicationInfo appInfo = this.mPackageManager.getApplicationInfo(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L8
        if ((appInfo.flags & SECURITY_LOG_ENABLED) != 0) goto L7;
        return false;
    L7:
        return true;
    L9:
        Log.w(TAG, "isSystemApp: package not found: " + packageName);
        return false;
    }
}

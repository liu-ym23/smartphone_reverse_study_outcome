package com.bytedance.securityserver.robotspolicy;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.SigningInfo;
import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.securityserver.adapter.SecurityLibFactory;
import com.bytedance.securityserver.adapter.TypeDetector;
import com.bytedance.securityserver.adapter.api.IAgentManager;
import com.bytedance.securityserver.adapter.assistant.AssistantAgentManagerAdapter;
import com.bytedance.securityserver.adapter.obric.ObricAgentManagerAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RobotsAgentAuthUtils {
    private static final String TAG = "RobotsAgentAuthUtils";
    private static final Map<String, AgentInfo> sAgentCache = null;

    public static class AgentInfo {
        String agentName;
        String packageName;
        String signatureHash;

        private AgentInfo() {
        }

        public /* synthetic */ AgentInfo(int r1) {
            this();
        }
    }

    static {
        sAgentCache = new ConcurrentHashMap();
    }

    public RobotsAgentAuthUtils() {
    }

    public static boolean checkAgentAuth(Context r4, String r5) {
        if (r5 == null) goto L27;
        PackageManager r6 = r4.getPackageManager();
        if (r6.checkSignatures(Binder.getCallingUid(), 1000) != 0) goto L6;
        return true;
    L6:
        String r7 = getSignatureHash(r6, r5);
        if (isMatchInCache(r5, r7) == false) goto L10;
        return true;
    L10:
        monitor-enter(RobotsAgentAuthUtils.class);
    L15:
        th = move-exception;
        throw th;
    L12:
        if (isMatchInCache(r5, r7) == false) goto L28;
        monitor-exit(RobotsAgentAuthUtils.class);     // Catch: Throwable -> L15
        return true;
    L28:
        refreshAgentCache();     // Catch: Throwable -> L15 Exception -> L19
    L21:
        monitor-exit(RobotsAgentAuthUtils.class);     // Catch: Throwable -> L15
        return isMatchInCache(r5, r7);
    L19:
        e = move-exception;
        Log.e(TAG, "Agent cache refresh failed, auth may be based on stale data.", e);     // Catch: Throwable -> L15
        goto L21
    L27:
        throw new SecurityException("Access denied: Cannot determine calling package.");
    }

    public static void checkInternalCallerOrThrow() {
        if (isInternalCaller() == false) goto L6;
        return;
    L6:
        throw new SecurityException("Access denied: only internal or system callers allowed for this operation.");
    }

    private static String getSignatureHash(PackageManager r4, String r5) {
        PackageInfo r6 = r4.getPackageInfo(r5, 134217728);     // Catch: NoSuchAlgorithmException -> L8
        SigningInfo r7 = r6.signingInfo;     // Catch: NoSuchAlgorithmException -> L8
        int r0 = 0;
        if (r7 != null) goto L6;
        byte[] r8 = null;
    L12:
        if (r8 == null) goto L18;
        byte[] r9 = MessageDigest.getInstance("SHA-256").digest(r8);     // Catch: NoSuchAlgorithmException -> L8
        StringBuilder r10 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L8
        int r1 = r9.length;     // Catch: NoSuchAlgorithmException -> L8
    L14:
        if (r0 >= r1) goto L16;
        r10.append(String.format("%02x", new Object[]{Byte.valueOf(r9[r0])}));     // Catch: NoSuchAlgorithmException -> L8
        r0 = r0 + 1;     // Catch: NoSuchAlgorithmException -> L8
        goto L14
    L16:
        return r10.toString();
    L18:
        return "";
    L6:
        if (r7.hasMultipleSigners() == false) goto L10;
        r8 = r6.signingInfo.getApkContentsSigners()[0].toByteArray();     // Catch: NoSuchAlgorithmException -> L8
        goto L12
    L10:
        r8 = r6.signingInfo.getSigningCertificateHistory()[0].toByteArray();     // Catch: NoSuchAlgorithmException -> L8
    L8:
        e = move-exception;
        throw new RuntimeException("SHA-256 algorithm not found", e);
    }

    public static boolean isInternalCaller() {
        int r0 = Binder.getCallingUid();
        if (r0 != Process.myUid()) goto L5;
    L9:
        return true;
    L5:
        if (r0 == 1000) goto L9;
        if (r0 == 0) goto L9;
        return false;
    }

    private static boolean isMatchInCache(String r3, String r4) {
        Iterator<AgentInfo> r0 = sAgentCache.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        AgentInfo r1 = r0.next();
        if (TextUtils.equals(r1.packageName, r3) == false) goto L4;
        String r2 = r1.signatureHash;
        if (r2 == null) goto L4;
        if (r2.equalsIgnoreCase(r4) == false) goto L4;
        return true;
    L13:
        return false;
    }

    private static void refreshAgentCache() {
        monitor-enter(SecurityLibFactory.class);
        IAgentManager r1 = SecurityLibFactory.f41a;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(SecurityLibFactory.class);
    L18:
        if (r1 != null) goto L21;
        Log.w(TAG, "AgentManager unavailable (securitylib framework not detected), skip cache refresh");
        return;
    L21:
        List r0 = r1.b();
        if (r0 == null) goto L40;
        ConcurrentHashMap r2 = new ConcurrentHashMap();
        Iterator r3 = r0.iterator();
    L25:
        if (r3.hasNext() == false) goto L29;
        String r4 = (String) r3.next();
        String r5 = r1.a(r4);
        if (TextUtils.isEmpty(r5) == true) goto L25;
        JSONObject r6 = new JSONObject(r5);
        AgentInfo r7 = new AgentInfo(0);
        r7.agentName = r6.optString("agentName");
        r7.packageName = r6.optString("packageName");
        r7.signatureHash = r6.optString("signatureHash");
        r2.put(r4, r7);
        goto L25
    L29:
        Map<String, AgentInfo> r8 = sAgentCache;
        r8.clear();
        r8.putAll(r2);
        return;
    L40:
        return;
    L8:
        int r9 = TypeDetector.a();     // Catch: Throwable -> L11
        if (r9 != 1) goto L14;
        SecurityLibFactory.f41a = new ObricAgentManagerAdapter();     // Catch: Throwable -> L11
    L16:
        r1 = SecurityLibFactory.f41a;     // Catch: Throwable -> L11
        monitor-exit(SecurityLibFactory.class);
        goto L18
    L14:
        if (r9 != 2) goto L16;
        SecurityLibFactory.f41a = new AssistantAgentManagerAdapter();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}

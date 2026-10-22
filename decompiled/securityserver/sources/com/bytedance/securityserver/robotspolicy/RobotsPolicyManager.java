package com.bytedance.securityserver.robotspolicy;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class RobotsPolicyManager {
    public static final String META_DATA_KEY = "com.obric.agentrobots.POLICY_JSON";
    private static final String TAG = "RobotsPolicyManager";
    private Context mAppContext;
    private LauncherApps mLauncherApps;
    private final LauncherApps.Callback mLauncherCallback;
    private final ExecutorService mWriteExecutor;

    public static class Holder {
        private static final RobotsPolicyManager INSTANCE = null;

        static {
            INSTANCE = new RobotsPolicyManager(0);
        }

        private Holder() {
        }

        public static /* bridge */ /* synthetic */ RobotsPolicyManager a() {
            return INSTANCE;
        }
    }

    public /* synthetic */ RobotsPolicyManager(int r1) {
        this();
    }

    public static /* bridge */ /* synthetic */ Context a(RobotsPolicyManager r0) {
        return r0.mAppContext;
    }

    private void applyBatch(Context r2, List<ContentProviderOperation> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == true) goto L14;
        r2.getContentResolver().applyBatch(RobotsPolicyContract.AUTHORITY, new ArrayList(r3));     // Catch: Throwable -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "applyBatch failed", e);
        return;
    }

    public static /* bridge */ /* synthetic */ void b(RobotsPolicyManager r0, Context r1, ArrayList r2) {
        r0.applyBatch(r1, r2);
    }

    public static RobotsPolicyManager getInstance() {
        return Holder.a();
    }

    private String readInputStream(InputStream r8) {
        BufferedReader r0 = new BufferedReader(new InputStreamReader(r8, StandardCharsets.UTF_8));     // Catch: Exception -> L24
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L12
        char[] r1 = new char[1024];     // Catch: Throwable -> L12
        long r2 = 0;
    L5:
        int r4 = r0.read(r1);     // Catch: Throwable -> L12
        if (r4 == (-1)) goto L16;
        r2 = r2 + ((long) r4);     // Catch: Throwable -> L12
        if (r2 > RobotsPolicyValidator.MAX_POLICY_SIZE) goto L9;
        r9.append(r1, 0, r4);     // Catch: Throwable -> L12
        goto L5
    L9:
        Log.w(TAG, "Policy file too large");     // Catch: Throwable -> L12
        r0.close();     // Catch: Exception -> L24
        return null;
    L16:
        String r10 = r9.toString();     // Catch: Throwable -> L12
        r0.close();     // Catch: Exception -> L24
        return r10;
    L12:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: Exception -> L24
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L24
    L24:
        return null;
    }

    public void handlePackageChanged(final String r3) {
        Log.d(TAG, "handlePackageChanged " + r3);
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L9:
        Log.w(TAG, "Invalid packageName or mAppContext");
        return;
    L5:
        if (this.mAppContext == null) goto L9;
        this.mWriteExecutor.execute(new AnonymousClass2(this, r3));
    }

    public void handlePackageDeleted(final String r3) {
        Log.d(TAG, "handlePackageDeleted " + r3);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (this.mAppContext == null) goto L10;
        this.mWriteExecutor.execute(new AnonymousClass3(this, r3));
        return;
    }

    public void loadPolicyEntry(Context r7, PackageInfo r8, List<ContentProviderOperation> r9) {
        if (r8 == null) goto L47;
        ApplicationInfo r3 = r8.applicationInfo;
        if (r3 == null) goto L48;
        Bundle r4 = r3.metaData;
        if (r4 == null) goto L49;
        if (r9 != null) goto L11;
        return;
    L11:
        if (r4.containsKey(META_DATA_KEY) == true) goto L44;
        return;
    L44:
        int r5 = r4.getInt(META_DATA_KEY, 0);     // Catch: Exception -> L21
        if (r5 != 0) goto L45;
    L23:
        String r6 = null;
    L25:
        if (TextUtils.isEmpty(r6) == false) goto L42;
        return;
    L42:
        JSONObject r2 = new JSONObject(r6);     // Catch: Exception -> L34
        if (RobotsPolicyValidator.isInvalidPolicy(r2, r8.packageName) == false) goto L30;
        return;
    L30:
        int r10 = r2.getInt(RobotsPolicyValidator.KEY_POLICY_VERSION);     // Catch: Exception -> L34
        if (RobotsPolicyValidator.isPolicyExpired(r7, r8.packageName, r10) == false) goto L36;
        Log.w(TAG, "Policy version " + r10 + " for " + r8.packageName + " is lower than existing version, skipping");     // Catch: Exception -> L34
        return;
    L36:
        ContentValues r11 = new ContentValues();
        r11.put("package_name", r8.packageName);
        r11.put("policy", r6);
        r11.put(RobotsPolicyContract.COL_VERSION, Integer.valueOf(r10));
        r9.add(ContentProviderOperation.newInsert(RobotsPolicyContract.POLICY_URI).withValues(r11).withYieldAllowed(true).build());
        return;
    L34:
        e = move-exception;
        Log.e(TAG, "Error parsing JSON for " + r8.packageName, e);
        return;
    L45:
        r6 = readInputStream(r7.getPackageManager().getResourcesForApplication(r8.applicationInfo).openRawResource(r5));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Log.w(TAG, "Failed to read policy from resource for " + r8.packageName, e);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        Log.e(TAG, "Error parsing meta-data for " + r8.packageName, e);
        return;
    L49:
        return;
    L48:
        return;
    }

    public void refreshPolicyCache(Context r4) {
        Log.d(TAG, "RobotsPolicyManager triggerPolicy refresh");
        List<PackageInfo> r0 = r4.getPackageManager().getInstalledPackages(128);
        ArrayList r1 = new ArrayList();
        Iterator<PackageInfo> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        loadPolicyEntry(r4, r2.next(), r1);
        goto L4
    L6:
        applyBatch(r4, r1);
    }

    public void removePolicyEntry(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (this.mAppContext == null) goto L10;
        ContentResolver r2 = this.mAppContext.getContentResolver();
        r2.delete(RobotsPolicyContract.buildPolicyUri(), "package_name=?", new String[]{r3});
        return;
    }

    public void setup(Context r5) {
        if (RobotsPolicyUtils.isRobotsEnbled(r5) == true) goto L6;
        Log.e(TAG, "Robots policy is disabled");
        return;
    L6:
        Log.d(TAG, "RobotsPolicyManager setup");
        Context r6 = r5.getApplicationContext();
        this.mAppContext = r6;
        LauncherApps r7 = (LauncherApps) r6.getSystemService(LauncherApps.class);
        this.mLauncherApps = r7;
        if (r7 != null) goto L14;
    L12:
        triggerManualReparse(this.mAppContext);
        return;
    L14:
        r7.registerCallback(this.mLauncherCallback, new Handler(Looper.getMainLooper()));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e(TAG, "Failed to register LauncherApps callback", e);
        goto L12
    }

    public void teardown() {
        Log.d(TAG, "RobotsPolicyManager teardown");
        LauncherApps r0 = this.mLauncherApps;
        if (r0 == null) goto L12;
        r0.unregisterCallback(this.mLauncherCallback);     // Catch: IllegalArgumentException -> L6
    L8:
        this.mLauncherApps = null;
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "Failed to unregister LauncherApps callback", e);
        goto L8
    }

    public void triggerManualReparse(final Context r3) {
        this.mWriteExecutor.execute(new AnonymousClass1(this, r3));
    }

    private RobotsPolicyManager() {
        this.mWriteExecutor = Executors.newSingleThreadExecutor();
        this.mLauncherCallback = new AnonymousClass4(this);
    }
}

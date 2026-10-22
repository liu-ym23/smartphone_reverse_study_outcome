package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.preference.PreferenceManager;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.build.BuildConfig;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("base::android")
public class ContextUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    private static final String TAG = "ContextUtils";
    private static Context sApplicationContext;

    private static class Holder {
        private static SharedPreferences sSharedPreferences;

        private Holder() {
        }

        static /* synthetic */ SharedPreferences access$100() {
            return sSharedPreferences;
        }

        static /* synthetic */ SharedPreferences access$102(SharedPreferences r0) {
            sSharedPreferences = r0;
            return r0;
        }

        static {
            sSharedPreferences = ContextUtils.access$000();
        }
    }

    static {
    }

    public ContextUtils() {
    }

    static /* synthetic */ SharedPreferences access$000() {
        return fetchAppSharedPreferences();
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static void initApplicationContext(Context r0) {
        initJavaSideApplicationContext(r0);
    }

    private static SharedPreferences fetchAppSharedPreferences() {
        StrictModeContext r0 = StrictModeContext.allowDiskWrites();
        SharedPreferences r1 = PreferenceManager.getDefaultSharedPreferences(sApplicationContext);     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (r0 != null) goto L16;
    L13:
        throw th;
    L16:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static SharedPreferences getAppSharedPreferences() {
        return Holder.access$100();
    }

    public static void initApplicationContextForTests(Context r0) {
        initJavaSideApplicationContext(r0);
        Holder.access$102(fetchAppSharedPreferences());
    }

    public static void clearApplicationContextForTests() {
        sApplicationContext = null;
        Holder.access$102(null);
    }

    private static void initJavaSideApplicationContext(Context r1) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
    L7:
        sApplicationContext = r1;
        return;
    L5:
        if ((r1 instanceof Application) == false) goto L7;
        r1 = new ContextWrapper(r1);
        goto L7
    }

    public static AssetManager getApplicationAssets() {
        Context r0 = getApplicationContext();
    L4:
        if ((r0 instanceof ContextWrapper) == false) goto L7;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L4
    L7:
        return r0.getAssets();
    }

    public static boolean isIsolatedProcess() {
        return Process.isIsolated();
    }

    public static boolean isSdkSandboxProcess() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        return Process.isSdkSandbox();
    }

    public static String getProcessName() {
        return ApiCompatibilityUtils.getProcessName();
    }

    public static boolean isProcess64Bit() {
        return ApiHelperForM.isProcess64Bit();
    }

    public static Activity activityFromContext(Context r1) {
    L3:
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        if ((r1 instanceof Activity) == true) goto L7;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L3
    L7:
        return (Activity) r1;
    L9:
        return null;
    }

    public static Intent registerExportedBroadcastReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8, String r9) {
        return registerBroadcastReceiver(r6, r7, r8, r9, null, 2);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8) {
        return registerBroadcastReceiver(r6, r7, r8, null, null, 4);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8, Handler r9) {
        return registerBroadcastReceiver(r6, r7, r8, null, r9, 4);
    }

    private static Intent registerBroadcastReceiver(Context r0, BroadcastReceiver r1, IntentFilter r2, String r3, Handler r4, int r5) {
        return ApiHelperForO.registerReceiver(r0, r1, r2, r3, r4, r5);
    }
}

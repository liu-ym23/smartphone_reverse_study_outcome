package com.android.settingslib.wifi;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.HandlerThread;
import com.GlobalProxyLancet;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class WifiStateWorker {
    private static final String TAG = "WifiStateWorker";
    private static WifiStateWorker sInstance;
    private static final Object sLock = null;
    private static Map<Context, WifiStateWorker> sTestInstances;
    static WifiManager sWifiManager;
    private static int sWifiState;
    private static HandlerThread sWorkerThread;

    /* JADX INFO: renamed from: com.android.settingslib.wifi.WifiStateWorker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class IntentReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settingslib_wifi_WifiStateWorker$IntentReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private IntentReceiver() {
        }

        /* synthetic */ IntentReceiver(AnonymousClass1 r1) {
            this();
        }

        public void com_android_settingslib_wifi_WifiStateWorker$IntentReceiver__onReceive$___twin___(Context r1, Intent r2) {
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r2.getAction()) == false) goto L6;
            WifiStateWorker.access$102(r2.getIntExtra("wifi_state", 1));
            return;
        }

        @Insert("onReceive")
        public static void com_android_settingslib_wifi_WifiStateWorker$IntentReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(IntentReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            IntentReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settingslib_wifi_WifiStateWorker$IntentReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settingslib_wifi_WifiStateWorker$IntentReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settingslib_wifi_WifiStateWorker$IntentReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settingslib_wifi_WifiStateWorker$IntentReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    public WifiStateWorker() {
    }

    static /* synthetic */ int access$102(int r0) {
        sWifiState = r0;
        return r0;
    }

    static {
        sLock = new Object();
    }

    public static WifiStateWorker getInstance(final Context r4) {
        Object r2 = sLock;
        monitor-enter(r2);
        Map<Context, WifiStateWorker> r3 = sTestInstances;     // Catch: Throwable -> L18
        if (r3 != null) goto L7;
    L11:
        WifiStateWorker r0 = sInstance;     // Catch: Throwable -> L18
        if (r0 == null) goto L15;
        monitor-exit(r2);     // Catch: Throwable -> L18
        return r0;
    L15:
        sInstance = new WifiStateWorker();     // Catch: Throwable -> L18
        HandlerThread r1 = new HandlerThread("WifiStateWorker:{" + r4.getApplicationInfo().className + VectorFormat.DEFAULT_SUFFIX, -4);     // Catch: Throwable -> L18
        sWorkerThread = r1;     // Catch: Throwable -> L18
        r1.start();     // Catch: Throwable -> L18
        sWorkerThread.getThreadHandler().post(new WifiStateWorker$$ExternalSyntheticLambda0(r4));     // Catch: Throwable -> L18
        WifiStateWorker r5 = sInstance;     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return r5;
    L7:
        if (r3.containsKey(r4) == false) goto L11;
        WifiStateWorker r6 = sTestInstances.get(r4);     // Catch: Throwable -> L18
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "The context owner try to use a test instance:" + r6);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return r6;
    L18:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void lambda$getInstance$0(Context r0) {
        init(r0);
    }

    public static void setTestInstance(Context r4, WifiStateWorker r5) {
        Object r1 = sLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sTestInstances != null) goto L7;
        sTestInstances = new ConcurrentHashMap();     // Catch: Throwable -> L10
    L7:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Try to set a test instance by context:" + r4);     // Catch: Throwable -> L10
        sTestInstances.put(r4, r5);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
    }

    private static void init(Context r4) {
        Context r5 = r4.getApplicationContext();
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r5, new IntentReceiver(null), new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"), null, sWorkerThread.getThreadHandler());
        sWifiManager = (WifiManager) r5.getSystemService(WifiManager.class);
        refresh();
    }

    public static void refresh() {
        if (sWifiManager != null) goto L5;
        return;
    L5:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Start calling WifiManager#getWifiState.");
        sWifiState = sWifiManager.getWifiState();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "WifiManager#getWifiState return state:" + sWifiState);
    }

    public int getWifiState() {
        return sWifiState;
    }

    public boolean isWifiEnabled() {
        if (sWifiState != 3) goto L5;
        return true;
    L5:
        return false;
    }
}

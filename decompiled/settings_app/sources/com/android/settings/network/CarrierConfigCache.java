package com.android.settings.network;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PersistableBundle;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
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

/* JADX INFO: loaded from: classes2.dex */
public class CarrierConfigCache {
    private static final String TAG = "CarrConfCache";
    protected static CarrierConfigManager sCarrierConfigManager;
    protected static final Map<Integer, PersistableBundle> sCarrierConfigs = null;
    private static CarrierConfigCache sInstance;
    private static final Object sInstanceLock = null;
    private static Map<Context, CarrierConfigCache> sTestInstances;

    /* JADX INFO: renamed from: com.android.settings.network.CarrierConfigCache$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class CarrierConfigChangeReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_network_CarrierConfigCache$CarrierConfigChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private CarrierConfigChangeReceiver() {
        }

        /* synthetic */ CarrierConfigChangeReceiver(AnonymousClass1 r1) {
            this();
        }

        public void com_android_settings_network_CarrierConfigCache$CarrierConfigChangeReceiver__onReceive$___twin___(Context r1, Intent r2) {
            if ("android.telephony.action.CARRIER_CONFIG_CHANGED".equals(r2.getAction()) == true) goto L5;
            return;
        L5:
            int r0 = r2.getIntExtra("android.telephony.extra.SUBSCRIPTION_INDEX", -1);
            Map<Integer, PersistableBundle> r3 = CarrierConfigCache.sCarrierConfigs;
            monitor-enter(r3);
        L13:
            th = move-exception;
            throw th;
        L8:
            if (SubscriptionManager.isValidSubscriptionId(r0) == false) goto L10;
            CarrierConfigCache.sCarrierConfigs.remove(Integer.valueOf(r0));     // Catch: Throwable -> L13
        L11:
            monitor-exit(r3);     // Catch: Throwable -> L13
            return;
        L10:
            CarrierConfigCache.sCarrierConfigs.clear();     // Catch: Throwable -> L13
            goto L11
        }

        @Insert("onReceive")
        public static void com_android_settings_network_CarrierConfigCache$CarrierConfigChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(CarrierConfigChangeReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            CarrierConfigChangeReceiver r1 = r7;
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
            r7.com_android_settings_network_CarrierConfigCache$CarrierConfigChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_network_CarrierConfigCache$CarrierConfigChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_network_CarrierConfigCache$CarrierConfigChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_network_CarrierConfigCache$CarrierConfigChangeReceiver__onReceive$___twin___(r8, r9);
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

    static {
        sInstanceLock = new Object();
        sCarrierConfigs = new ConcurrentHashMap();
    }

    public static CarrierConfigCache getInstance(Context r4) {
        Object r1 = sInstanceLock;
        monitor-enter(r1);
        Map<Context, CarrierConfigCache> r2 = sTestInstances;     // Catch: Throwable -> L18
        if (r2 != null) goto L7;
    L11:
        CarrierConfigCache r0 = sInstance;     // Catch: Throwable -> L18
        if (r0 == null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r0;
    L15:
        sInstance = new CarrierConfigCache();     // Catch: Throwable -> L18
        CarrierConfigChangeReceiver r3 = new CarrierConfigChangeReceiver(null);     // Catch: Throwable -> L18
        Context r5 = r4.getApplicationContext();     // Catch: Throwable -> L18
        sCarrierConfigManager = (CarrierConfigManager) r5.getSystemService(CarrierConfigManager.class);     // Catch: Throwable -> L18
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r5, r3, new IntentFilter("android.telephony.action.CARRIER_CONFIG_CHANGED"), 2);     // Catch: Throwable -> L18
        CarrierConfigCache r6 = sInstance;     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r6;
    L7:
        if (r2.containsKey(r4) == false) goto L11;
        CarrierConfigCache r7 = sTestInstances.get(r4);     // Catch: Throwable -> L18
        OLog.w(TAG, "The context owner try to use a test instance:" + r7);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r7;
    L18:
        th = move-exception;
        throw th;
    }

    public static void setTestInstance(Context r4, CarrierConfigCache r5) {
        Object r1 = sInstanceLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sTestInstances != null) goto L7;
        sTestInstances = new ConcurrentHashMap();     // Catch: Throwable -> L10
    L7:
        OLog.w(TAG, "Try to set a test instance by context:" + r4);     // Catch: Throwable -> L10
        sTestInstances.put(r4, r5);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
    }

    private CarrierConfigCache() {
    }

    public boolean hasCarrierConfigManager() {
        if (sCarrierConfigManager == null) goto L5;
        return true;
    L5:
        return false;
    }

    public PersistableBundle getConfigForSubId(int r5) {
        if (sCarrierConfigManager != null) goto L5;
        return null;
    L5:
        Map<Integer, PersistableBundle> r0 = sCarrierConfigs;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L8:
        if (r0.containsKey(Integer.valueOf(r5)) == false) goto L12;
        PersistableBundle r4 = r0.get(Integer.valueOf(r5));     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r4;
    L12:
        PersistableBundle r2 = sCarrierConfigManager.getConfigForSubId(r5);     // Catch: Throwable -> L20
        if (r2 != null) goto L17;
        OLog.e(TAG, "Could not get carrier config, subId:" + r5);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return null;
    L17:
        r0.put(Integer.valueOf(r5), r2);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return r2;
    }

    public PersistableBundle getConfig() {
        if (sCarrierConfigManager != null) goto L7;
        return null;
    L7:
        return getConfigForSubId(SubscriptionManager.getDefaultSubscriptionId());
    }
}

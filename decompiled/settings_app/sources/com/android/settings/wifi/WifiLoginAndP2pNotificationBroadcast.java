package com.android.settings.wifi;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import bytedanceos.util.DeviceType;
import com.android.settings.HandleEventService;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.WifiConfigurationSmtOnly;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes.dex */
public class WifiLoginAndP2pNotificationBroadcast extends BroadcastReceiver {
    private static final boolean DEBUG = true;
    private static final String OTA_COMPLETED_ACTION = "android.intent.action.PRE_BOOT_COMPLETED";
    private static final String TAG = "WifiLoginAndP2pNotificationBroadcast";
    private static final DeviceType[] UNUSED_DEVICE_TYPES = null;

    public static final class Processor {
        private Context mContext;

        public Processor(Context r1) {
            this.mContext = r1;
        }

        public void process(Intent r6) {
            Context r0 = this.mContext;
            String r1 = r6.getAction();
            OLog.d(WifiLoginAndP2pNotificationBroadcast.TAG, "Action = " + r1);
            if (WifiLoginAndP2pNotificationBroadcast.OTA_COMPLETED_ACTION.equals(r1) == false) goto L6;
            OLog.d(WifiLoginAndP2pNotificationBroadcast.TAG, "OTA completed, move auth records: " + WifiAuthorizeUtils.moveDatabase2ProviderForOta(r0) + ", delete auth database: " + WifiAuthorizeUtils.deleteDatabaseForOta(r0) + ", move data from sharePreference count: " + WifiAuthorizeUtils.movePreferenceData2ProviderForOta(r0) + ", delete sharePreference: " + WifiAuthorizeUtils.deleteSharePreferenceForOta(r0));
            return;
        L6:
            if ("android.net.wifi.WIFI_AP_STATE_CHANGED".equals(r1) == false) goto L16;
            int r2 = r6.getIntExtra("wifi_state", 11);
            handleWifiApStateChanged(r0, r2);
            if (WifiLoginAndP2pNotificationBroadcast.access$000() == false) goto L11;
            return;
        L11:
            if (r2 != 13) goto L40;
            Intent r5 = new Intent(r6);
            r5.setClass(r0, WifiApService.class);
            if (r0.startService(r5) != null) goto L41;
            OLog.e(WifiLoginAndP2pNotificationBroadcast.TAG, "Can't start WifiApService");
            return;
        L41:
            return;
        L40:
            return;
        L16:
            if ("bytedanceos.net.conn.CONNECTIVITY_CHANGE".equals(r1) == false) goto L43;
            NetworkInfo r7 = (NetworkInfo) r6.getParcelableExtra("networkInfo");
            if (r7 == null) goto L44;
            boolean r3 = true;
            if (r7.getType() == 0) goto L27;
            if (r7.getType() == 5) goto L27;
            if (r7.getType() == 1) goto L27;
            return;
        L27:
            if (r7.isConnected() == true) goto L29;
        L35:
            r3 = false;
        L36:
            if (r3 == true) goto L45;
            Utils.storeLastDataUsage(r0, Utils.getDataUsage(r0));
            return;
        L45:
            return;
        L29:
            if (r7.getType() == 0) goto L36;
            if (r7.getType() == 5) goto L36;
            if (r7.getType() != 1) goto L35;
        L44:
            return;
        }

        private void updateNeedLoginConfig(Context r2, android.net.wifi.WifiInfo r3) {
            WifiManager r4 = (WifiManager) r2.getSystemService("wifi");
            WifiConfiguration r1 = getCurrenWifiConfiguration(r4, r3);
            if (r1 != null) goto L5;
            return;
        L5:
            if (WifiConfigurationSmtOnly.get_needLogin(r1) == true) goto L9;
            WifiConfigurationSmtOnly.set_needLogin(r1, true);
            r4.save(r1, null);
            return;
        }

        private WifiConfiguration getCurrenWifiConfiguration(WifiManager r3, android.net.wifi.WifiInfo r4) {
            if (r3 == null) goto L26;
            if (r4 == null) goto L29;
            int r5 = r4.getNetworkId();
            List<WifiConfiguration> r6 = r3.getConfiguredNetworks();     // Catch: RuntimeException -> L9
        L11:
            if (r6 != null) goto L13;
            return null;
        L13:
            if (r5 == (-1)) goto L28;
            Iterator<WifiConfiguration> r7 = r6.iterator();
        L16:
            if (r7.hasNext() == false) goto L30;
            WifiConfiguration r0 = r7.next();
            if (r0.networkId != r5) goto L16;
            return r0;
        L30:
            return null;
        L28:
            return null;
        L9:
            e = move-exception;
            e.printStackTrace();
            r6 = null;
            goto L11
        L29:
            return null;
        L26:
            return null;
        }

        private void handleWifiApStateChanged(Context r5, int r6) {
            if (r6 == 11) goto L18;
            if (r6 == 13) goto L14;
            if (r6 == 14) goto L10;
            return;
        L10:
            if (Utils.isSoftApConfigChanged() == false) goto L12;
            Utils.resetChangeSoftApConfig();
        L12:
            Utils.storeStartUpDataUsage(r5, 0);
            Utils.storeLastDataUsage(r5, 0);
            return;
        L14:
            if (Utils.isSoftApConfigChanged() == false) goto L16;
            Utils.resetChangeSoftApConfig();
            return;
        L16:
            Utils.storeStartUpDataUsage(r5, Utils.getDataUsage(r5));
            Utils.storeLastDataUsage(r5, 0);
            return;
        L18:
            if (Utils.isSoftApConfigChanged() == true) goto L24;
            Utils.storeStartUpDataUsage(r5, 0);
            Utils.storeLastDataUsage(r5, 0);
            return;
        }
    }

    private static boolean unUsedType() {
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_wifi_WifiLoginAndP2pNotificationBroadcast_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public WifiLoginAndP2pNotificationBroadcast() {
    }

    static /* synthetic */ boolean access$000() {
        return unUsedType();
    }

    static {
        UNUSED_DEVICE_TYPES = new DeviceType[]{DeviceType.TRIDENT, DeviceType.OCEAN, DeviceType.DELTA, DeviceType.DARWIN};
    }

    public void com_android_settings_wifi_WifiLoginAndP2pNotificationBroadcast__onReceive$___twin___(Context r3, Intent r4) {
        OLog.d(TAG, "receive action : " + r4.getAction());     // Catch: Exception -> L5
        r4.setClass(r3, HandleEventService.class);     // Catch: Exception -> L5
        r4.putExtra("type", 10);     // Catch: Exception -> L5
        r3.startService(r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Insert("onReceive")
    public static void com_android_settings_wifi_WifiLoginAndP2pNotificationBroadcast_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(WifiLoginAndP2pNotificationBroadcast r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        WifiLoginAndP2pNotificationBroadcast r1 = r7;
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
        r7.com_android_settings_wifi_WifiLoginAndP2pNotificationBroadcast__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_wifi_WifiLoginAndP2pNotificationBroadcast__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_wifi_WifiLoginAndP2pNotificationBroadcast__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_wifi_WifiLoginAndP2pNotificationBroadcast__onReceive$___twin___(r8, r9);
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

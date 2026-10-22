package com.android.settings.vpn2;

import android.app.ActivityOptions;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.VpnManager;
import android.security.LegacyVpnProfileStore;
import com.android.internal.net.VpnProfile;
import com.android.internal.util.ArrayUtils;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.ToastUtils;
import com.android.settings.utils.NullSafe;
import com.google.android.collect.Lists;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class VpnReceiver extends BroadcastReceiver {
    private static final String TAG = "VpnReceiver";
    private static String VPN_CONFIG = "com.android.server.connectivity.VPN_CONFIG";
    private static String VPN_CONFIG_EXTRA = "config";
    private static String VPN_DISCONNECT_REASON = "disconnect_reason";
    private static String VPN_STATE_CHANGE = "com.android.server.connectivity.VPN_STATE_CHANGE";
    private static String VPN_STATE_EXTRA_INT = "state";
    private static int VPN_STATE_NONE = -1;
    private static int VPN_STATE_OFF = 0;
    private static int VPN_STATE_ON = 1;
    private static int mLastNetworkType = -1;
    private static boolean mManulDisconnect = true;
    private final String LAUNCH_VPN_SETTINGS_INTENT;
    private VpnManager mVpnManager;
    private String unspecifiedIpsecUserCert;

    static {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_vpn2_VpnReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public VpnReceiver() {
        this.LAUNCH_VPN_SETTINGS_INTENT = "com.bytedanceos.LAUNCH_VPN_SETTINGS";
        this.unspecifiedIpsecUserCert = "";
    }

    static /* synthetic */ List access$000(VpnReceiver r0, int[] r1) {
        return r0.loadVpnProfiles(r1);
    }

    static /* synthetic */ String access$100(VpnReceiver r0, Context r1) {
        return r0.getLastVpnKey(r1);
    }

    static /* synthetic */ String access$1000() {
        return VPN_STATE_EXTRA_INT;
    }

    static /* synthetic */ int access$1100() {
        return VPN_STATE_NONE;
    }

    static /* synthetic */ int access$1200() {
        return VPN_STATE_OFF;
    }

    static /* synthetic */ String access$1300() {
        return VPN_DISCONNECT_REASON;
    }

    static /* synthetic */ int access$1400() {
        return VPN_STATE_ON;
    }

    static /* synthetic */ String access$1500() {
        return VPN_CONFIG;
    }

    static /* synthetic */ String access$1600() {
        return VPN_CONFIG_EXTRA;
    }

    static /* synthetic */ void access$1700(VpnReceiver r0, Context r1, String r2) {
        r0.updateLastVpnKey(r1, r2);
    }

    static /* synthetic */ boolean access$200(VpnReceiver r0, String r1, String r2) {
        return r0.certificatesValid(r1, r2);
    }

    static /* synthetic */ VpnManager access$300(VpnReceiver r0) {
        return r0.mVpnManager;
    }

    static /* synthetic */ void access$400(VpnReceiver r0, Context r1, VpnProfile r2) {
        r0.connect(r1, r2);
    }

    static /* synthetic */ void access$500(VpnReceiver r0, Context r1) {
        r0.startVpnSetting(r1);
    }

    static /* synthetic */ boolean access$600() {
        return mManulDisconnect;
    }

    static /* synthetic */ boolean access$602(boolean r0) {
        mManulDisconnect = r0;
        return r0;
    }

    static /* synthetic */ int access$700() {
        return mLastNetworkType;
    }

    static /* synthetic */ int access$702(int r0) {
        mLastNetworkType = r0;
        return r0;
    }

    static /* synthetic */ void access$800(VpnReceiver r0, Context r1, VpnProfile r2) {
        r0.showRetryDialog(r1, r2);
    }

    static /* synthetic */ String access$900() {
        return VPN_STATE_CHANGE;
    }

    public void com_android_settings_vpn2_VpnReceiver__onReceive$___twin___(final Context r2, final Intent r3) {
        this.mVpnManager = (VpnManager) r2.getSystemService("vpn_management");
        new AnonymousClass1(this, r3, r2).execute(new Object[1]);
    }

    private List<VpnProfile> loadVpnProfiles(int... r7) {
        ArrayList r0 = Lists.newArrayList();
        String[] r1 = LegacyVpnProfileStore.list("VPN_");     // Catch: NullPointerException -> L17
        if (r1 != null) goto L6;
        return r0;
    L6:
        int r2 = r1.length;     // Catch: NullPointerException -> L17
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L19;
        String r4 = r1[r3];     // Catch: NullPointerException -> L17
        if (LegacyVpnProfileStore.get("VPN_" + r4) == null) goto L16;
        VpnProfile r5 = VpnProfile.decode(r4, (byte[]) NullSafe.nonNull(LegacyVpnProfileStore.get("VPN_" + r4)));     // Catch: NullPointerException -> L17
        if (r5 == null) goto L16;
        if (ArrayUtils.contains(r7, r5.type) == true) goto L16;
        r0.add(r5);     // Catch: NullPointerException -> L17
    L16:
        r3 = r3 + 1;
    L19:
        return r0;
    L17:
        e = move-exception;
        OLog.e(TAG, "e" + e);
        goto L19
    }

    private void connect(Context r1, VpnProfile r2) {
        this.mVpnManager.startLegacyVpn(r2);     // Catch: IllegalStateException -> L4 Exception -> L6
        goto L10
    L9:
        return;
    L4:
        ToastUtils.show(r1, R.string.vpn_no_network);
        return;
    }

    private void updateLastVpnKey(Context r2, String r3) {
        SharedPreferences.Editor r1 = r2.getSharedPreferences(VpnSettings.LAST_VALID_VPN_KEY, 0).edit();
        r1.putString(VpnSettings.LAST_VALID_VPN_KEY, r3);
        r1.apply();
    }

    private String getLastVpnKey(Context r2) {
        return r2.getSharedPreferences(VpnSettings.LAST_VALID_VPN_KEY, 0).getString(VpnSettings.LAST_VALID_VPN_KEY, null);
    }

    private void startVpnSetting(Context r3) {
        Intent r2 = new Intent("android.net.vpn.SETTINGS");     // Catch: ActivityNotFoundException -> L4
        r2.addCategory("android.intent.category.DEFAULT");     // Catch: ActivityNotFoundException -> L4
        r2.addFlags(268435456);     // Catch: ActivityNotFoundException -> L4
        r3.startActivity(r2, ActivityOptions.makeCustomAnimation(r3, R.anim.pop_up_in, R.anim.fake_anim).toBundle());     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void showRetryDialog(Context r2, VpnProfile r3) {
        Intent r1 = new Intent("com.android.settings.action.VpnReconnectDialog");
        r1.putExtra("vpnProfile", r3);
        r1.addFlags(268435456);
        r1.putExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID", new int[]{0, R.anim.fake_anim});
        r2.startActivity(r1);
    }

    private boolean certificatesValid(String r4, String r5) {
        String[] r6 = LegacyVpnProfileStore.list(r4);
        if (r6 != null) goto L5;
    L8:
        String[] r2 = {this.unspecifiedIpsecUserCert};
    L9:
        int r3 = 1;
    L11:
        if (r3 >= r2.length) goto L17;
        if (r2[r3].equals(r5) == true) goto L20;
        r3 = r3 + 1;
        goto L11
    L20:
        return true;
    L17:
        return false;
    L5:
        if (r6.length == 0) goto L8;
        r2 = new String[r6.length + 1];
        r2[0] = this.unspecifiedIpsecUserCert;
        System.arraycopy(r6, 0, r2, 1, r6.length);
        goto L9
    }

    @Insert("onReceive")
    public static void com_android_settings_vpn2_VpnReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(VpnReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        VpnReceiver r1 = r7;
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
        r7.com_android_settings_vpn2_VpnReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_vpn2_VpnReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_vpn2_VpnReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_vpn2_VpnReceiver__onReceive$___twin___(r8, r9);
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

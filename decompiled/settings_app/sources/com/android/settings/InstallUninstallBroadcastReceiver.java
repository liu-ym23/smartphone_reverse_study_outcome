package com.android.settings;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.text.TextUtils;
import com.android.settings.doppelganger.DoppelgangerManagerHelper;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.textboom.AppInfoDataLoader;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class InstallUninstallBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "InstallUninstallBroadcastReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_InstallUninstallBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public InstallUninstallBroadcastReceiver() {
    }

    public void com_android_settings_InstallUninstallBroadcastReceiver__onReceive$___twin___(Context r9, Intent r10) {
        String r0 = r10.getAction();
        boolean r1 = r10.getBooleanExtra("android.intent.extra.REPLACING", false);
        if ("android.intent.action.PACKAGE_ADDED".equals(r0) == false) goto L18;
        if (r1 == true) goto L18;
        String r2 = r10.getDataString().split(":")[1];
        int r3 = UserHandle.getUserId(r10.getIntExtra("android.intent.extra.UID", 0));
        PreferenceMgr r4 = PreferenceMgr.getInstance(r9);
        if (Utils.array2List(r9.getResources().getStringArray(R.array.game_side_bar_recommend_add_app)).contains(r2) == true) goto L8;
    L16:
        AppInfoDataLoader.getInstance(r9).clearCache();
    L29:
        updateGoogleServiceSettingItemSearchable(r9, r10);
        return;
    L8:
        if (Constants.PKG_MMS.equals(r2) == true) goto L16;
        if (r4.getBoolean(r2, true) == false) goto L16;
        if (r3 != 0) goto L16;
        StringBuffer r5 = new StringBuffer();
        String r6 = Utils.getSideBarEnabledApp(r9);
        r5.append(r6);
        if (TextUtils.isEmpty(r6) == true) goto L15;
        r5.append(";");
    L15:
        r5.append(r2 + ":0");
        Utils.updateSideBarEnabledApp(r9, r5.toString());
        r4.putBoolean(r2, false);
    L18:
        if ("android.intent.action.PACKAGE_REMOVED".equals(r0) == false) goto L21;
        if (r1 == true) goto L21;
    L23:
        if ("android.intent.action.PACKAGE_REMOVED".equals(r0) == false) goto L27;
        String r7 = r10.getDataString().split(":")[1];
        int r8 = UserHandle.getUserId(r10.getIntExtra("android.intent.extra.UID", 0));
        if (Utils.isNfcSupport(r9) == false) goto L28;
        setNFCDefaultPay(r7, r9);
    L28:
        AppInfoDataLoader.getInstance(r9).clearCache();
        Utils.updateSideBarEnabledApp(r9, Utils.removePackageNameAndUserId(Utils.getSideBarEnabledApp(r9), r7 + ":" + r8));
        goto L29
    L27:
        r7 = r10.getStringExtra(DoppelgangerManagerHelper.EXTRA_PACKAGENAME);
        r8 = r10.getIntExtra(DoppelgangerManagerHelper.EXTRA_USERID, 10);
    L21:
        if ("com.settings.action.DOPPELGANGER_REMOVED".equals(r0) == false) goto L29;
        goto L29
    }

    private void updateGoogleServiceSettingItemSearchable(Context r3, Intent r4) {
        String r0 = r4.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(r0) == false) goto L5;
    L13:
    L10:
        e = move-exception;
        OLog.e(TAG, "updateGoogleServiceSettingItemSearchable error", e);
        return;
    L7:
        if (r4.getDataString().split(":")[1].equals("com.google.android.gms") == false) goto L16;
        OLog.i(TAG, "updateGoogleServiceSettingItemSearchable start");     // Catch: Exception -> L10
        DatabaseHelper.getInstance(r3).updateGoogleServiceSettingItemSearchable();     // Catch: Exception -> L10
        return;
    L16:
        return;
    L5:
        if ("android.intent.action.PACKAGE_REMOVED".equals(r0) == true) goto L13;
    }

    private void setNFCDefaultPay(String r2, Context r3) {
        OLog.i(TAG, "packageName:" + r2);
        String r1 = android.provider.Settings.Secure.getString(r3.getContentResolver(), "nfc_payment_default_component");
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.startsWith(r2) == false) goto L9;
        android.provider.Settings.Secure.putString(r3.getContentResolver(), "nfc_payment_default_component", null);
        return;
    }

    @Insert("onReceive")
    public static void com_android_settings_InstallUninstallBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(InstallUninstallBroadcastReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        InstallUninstallBroadcastReceiver r1 = r7;
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
        r7.com_android_settings_InstallUninstallBroadcastReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_InstallUninstallBroadcastReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_InstallUninstallBroadcastReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_InstallUninstallBroadcastReceiver__onReceive$___twin___(r8, r9);
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

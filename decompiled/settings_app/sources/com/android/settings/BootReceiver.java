package com.android.settings;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.nfc.NfcAdapter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemProperties;
import com.android.settings.applications.PreferredSettingsUtils;
import com.android.settings.fingerprint.FingerprintHelper;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.sidedial.SideDialHelper;
import com.android.settings.utils.ThreadUtils;
import com.bytedance.security.keymanager.KeyManagerConst;
import com.bytedance.sremlib.LibUtil;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = "BootReceiver";
    private final Configuration mCurConfig;
    private List<String> whiteApps;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_BootReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public BootReceiver() {
        this.mCurConfig = new Configuration();
        this.whiteApps = Arrays.asList(new String[]{"com.android.settings", "com.android.systemui"});
    }

    public void com_android_settings_BootReceiver__onReceive$___twin___(final Context r7, Intent r8) {
        String r0 = r8.getAction();
        OLog.d(TAG, "BootReceiver action " + r0 + ", flags=" + String.format("%o", new Object[]{Integer.valueOf(r8.getFlags())}));
        if (Utils.isStopedIntent(r8) == false) goto L6;
        return;
    L6:
        if (LibUtil.ACTION_BOOT_COMPLETELY.equals(r0) == false) goto L21;
        if (android.provider.Settings.Global.getInt(r7.getContentResolver(), "default_browser_setting_done", 0) != 0) goto L10;
        DefaultBrowserSetter.start(r7);
    L10:
        OLog.d(TAG, "BootReceiver USER_SETUP_COMPLETE =  " + android.provider.Settings.Secure.getInt(r7.getContentResolver(), "user_setup_complete", -1));
        if (Build.IS_DEBUGGABLE == true) goto L13;
        check(r7);
    L13:
        resetScreenRecorderStatus(r7);
        resetCleanProcessTime(r7);
        ContentResolver r9 = r7.getContentResolver();
        if (android.provider.Settings.Secure.isLocationProviderEnabled(r9, "gps") == android.provider.Settings.Secure.isLocationProviderEnabled(r9, "network")) goto L16;
        android.provider.Settings.Secure.setLocationProviderEnabled(r9, "network", false);
        android.provider.Settings.Secure.setLocationProviderEnabled(r9, "gps", false);
    L16:
        resetOTABadgeFlag(r7);
        final NfcAdapter r10 = NfcAdapter.getDefaultAdapter(r7);
        if (r10 == null) goto L19;
        ThreadUtils.postOnBackgroundThread(new AnonymousClass1(this, r7, r10));
    L19:
        OLog.d(TAG, "call saveCurrentVersionAndUpdateDefaultSetter ACTION_BOOT_COMPLETED");
        PreferredSettingsUtils.saveCurrentVersionAndUpdateDefaultSetter(r7);
        showSmartScreenNotification(r7);
        return;
    L21:
        if ("android.intent.action.PRE_BOOT_COMPLETED".equals(r0) == false) goto L26;
        if (Utils.isDeviceSetupComplete(r7) == false) goto L26;
        Intent r6 = new Intent("com.bytedanceos.action.settings.HandleEventService");
        r6.putExtra("type", 5);
        r6.setPackage("com.android.settings");
        r7.startService(r6);
        return;
    L26:
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(r0) == false) goto L29;
        DatabaseHelper.getInstance(r7).handleBluetoothStateChanged(r8.getIntExtra("android.bluetooth.adapter.extra.STATE", 10));
        return;
    L29:
        if ("android.intent.action.LOCKED_BOOT_COMPLETED".equals(r0) == false) goto L47;
        int r11 = Utils.getPreviousColorMode(r7);     // Catch: Exception -> L40
        if (r11 == 0) goto L33;
        Calibration.setColorMode(r11);     // Catch: Exception -> L40
    L33:
        FingerprintHelper.updateGestureModeIfNeed(r7);     // Catch: Exception -> L40
        if (SettingsFeature.isDarwin() == false) goto L37;
        FingerprintHelper.updateFodModeIfNeed(r7);     // Catch: Exception -> L40
    L37:
        if (SettingsFeature.isSupportSideDialKey() == false) goto L48;
        SideDialHelper.sideDialStateChangedAfterBoot(r7);     // Catch: Exception -> L40
        return;
    L48:
        return;
    L40:
        OLog.d(TAG, "service call error");
        return;
    }

    private void handlePhoneCase(Context r12, Intent r13) {
        if (SettingsFeature.hasMultiCustomKey() == true) goto L5;
        return;
    L5:
        BluetoothDevice r1 = (BluetoothDevice) r13.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int r2 = r13.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", 0);
        int r4 = r13.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", 0);
        int r5 = r13.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
        int r6 = r13.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", Integer.MIN_VALUE);
        String r7 = r13.getStringExtra(KeyManagerConst.PKG_NAME);
        String r8 = r13.getAction();
        OLog.d(TAG, "onReceive:" + r8 + ", preState:" + r4 + ", newState:" + r2 + ", device:" + r1 + ", adapterStatePre:" + r6 + ", adapterState:" + r5 + ", stateChangedBy:" + r7);
        if (MultiSDKAdapter.ACTION_CONNECTION_STATE_CHANGED.equals(r8) == false) goto L18;
        int r3 = r13.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        int r9 = r13.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", 0);
        BluetoothDevice r14 = (BluetoothDevice) r13.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        String r0 = this.whiteApps.get(0);
        StringBuilder r10 = new StringBuilder("CONNECTION_STATE_CHANGED:, preState:").append(r9).append(", newState:").append(r3).append(", ");
        if (r14 != null) goto L10;
        String r15 = "";
    L11:
        OLog.d(TAG, r10.append(r15).toString());
        if (r3 != 0) goto L14;
        disablePhoneCase(r12, r0);
        return;
    L14:
        if (r3 != 2) goto L33;
        enablePhoneCase(r12, r0);
        return;
    L33:
        return;
    L10:
        r15 = r14.getName();
        goto L11
    L18:
        if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(r8) == false) goto L26;
        String r16 = this.whiteApps.get(0);
        if (r2 != 0) goto L22;
        disablePhoneCase(r12, r16);
        return;
    L22:
        if (r2 != 2) goto L35;
        enablePhoneCase(r12, r16);
        return;
    L35:
        return;
    L26:
        if (r5 != 13) goto L29;
        OLog.d(TAG, "onReceive: adapter STATE_OFF, disableBy:" + r7);
        disablePhoneCase(r12, r7);
        return;
    L29:
        if (r5 != 11) goto L37;
        OLog.d(TAG, "onReceive: adapter STATE_ON, enableBy:" + r7);
        enablePhoneCase(r12, r7);
        return;
    }

    private void disablePhoneCase(Context r6, String r7) {
        int r0 = android.provider.Settings.Global.getInt(r6.getContentResolver(), PreferenceMgr.KEY_PHONE_CASE_STATE, 0);
        OLog.d(TAG, "will disable phone case, reason:" + r7 + ", currentState:" + r0);
        if (r0 != 0) goto L5;
        return;
    L5:
        android.provider.Settings.Global.putInt(r6.getContentResolver(), PreferenceMgr.KEY_PHONE_CASE_STATE, 0);
        PreferenceMgr.getInstance(r6).putInt(PreferenceMgr.KEY_PHONE_CASE_STATE, r0);
        if (this.whiteApps.contains(r7) == false) goto L9;
        Intent r5 = new Intent(r6, DialogActivity.class);
        r5.putExtra(DialogActivity.DIALOG_TYPE, 7);
        r6.startActivity(r5);
        return;
    }

    private void enablePhoneCase(Context r6, String r7) {
        PreferenceMgr r5 = PreferenceMgr.getInstance(r6);
        int r2 = r5.getInt(PreferenceMgr.KEY_PHONE_CASE_STATE, -1);
        OLog.d(TAG, "will enable phone case, reason:" + r7 + ", restoreState:" + r2);
        if (r2 == (-1)) goto L6;
        android.provider.Settings.Global.putInt(r6.getContentResolver(), PreferenceMgr.KEY_PHONE_CASE_STATE, r2);
        r5.remove(PreferenceMgr.KEY_PHONE_CASE_STATE);
        return;
    }

    private void resetCleanProcessTime(final Context r2) {
        AsyncTask.execute(new AnonymousClass2(this, r2));
    }

    private void resetScreenRecorderStatus(Context r3) {
        android.provider.Settings.Global.putInt(r3.getContentResolver(), "screen_recorder_status", 0);
        android.provider.Settings.Global.putInt(r3.getContentResolver(), "screen_recorder_show_status", 0);
    }

    private void resetOTABadgeFlag(Context r1) {
        PreferenceMgr.getInstance(r1).remove(BytedanceEventReceiver.KEY_SHOW_OTA_UPDATABLE_BADGE);
    }

    private void showSmartScreenNotification(Context r9) {
        if (SettingsFeature.isSupportSmartScreenProtection() == true) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (android.provider.Settings.Global.getInt(r9.getContentResolver(), SettingsSwitchKeyUtil.SMART_SCREEN_PROTECTOR, 0) != 1) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L11;
        Utils.showNotification(r9, 203, R.drawable.ic_launcher_settings, r9.getString(R.string.notification_using_smart_screen), r9.getString(R.string.click_to_setting), new Intent(r9, Settings.SmartScreenActivity.class));
        return;
    }

    private void check(Context r5) {
        ContentResolver r4 = r5.getContentResolver();
        boolean r0 = false;
        if (SystemProperties.getInt(Constants.PROP_DEVICE_PROVISIONED, 0) != 1) goto L5;
        boolean r6 = true;
    L7:
        if (android.provider.Settings.Global.getInt(r4, "device_provisioned", 0) != 1) goto L9;
        r0 = true;
    L9:
        if (r6 == false) goto L13;
        if (r0 == true) goto L14;
        OLog.e(TAG, "ERROR: settings config xml lose, force correct provision settings.");
        android.provider.Settings.Global.putInt(r4, "device_provisioned", 1);
        android.provider.Settings.Secure.putInt(r4, "user_setup_complete", 1);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r6 = false;
        goto L7
    }

    @Insert("onReceive")
    public static void com_android_settings_BootReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(BootReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        BootReceiver r1 = r7;
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
        r7.com_android_settings_BootReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_BootReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_BootReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_BootReceiver__onReceive$___twin___(r8, r9);
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

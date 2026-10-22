package com.android.settings;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import bytedanceos.util.DeviceType;
import bytedanceos.util.SettingsUtil;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.applications.IconUpdateReceiver;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.utils.HardwareDetailInfo;
import com.android.settings.wifi.WifiLoginAndP2pNotificationBroadcast;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.olog.OLog;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class HandleEventService extends IntentService {
    private static final long KB = 1048576;
    private static final String TAG = "HandleEventService";
    public static final int TYPE_APP_STATUS_RECEIVER_EVENT = 8;
    public static final int TYPE_COLLECT_LOGS = 6;
    public static final int TYPE_DISABLE_ACCESSIBILITY = 7;
    public static final int TYPE_ICON_UPDATE_EVENT = 9;
    public static final int TYPE_RESET_PASSWORD_RECEIVER_EVENT = -1000;
    private static final int TYPE_SETUPWIZARD_END = 2;
    private static final int TYPE_SETUPWIZARD_START = 1;
    public static final int TYPE_SHUTDOWN_WIZARD = 4;
    public static final int TYPE_SYSTEM_UPDATED = 5;
    public static final int TYPE_WIFI_NOTIFICATION_RECEIVER_EVENT = 10;
    private Context mContext;

    public HandleEventService() {
        super(TAG);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent r4) {
        this.mContext = getApplicationContext();
        if (r4 != null) goto L5;
        return;
    L5:
        int r0 = r4.getIntExtra("type", 0);
        OLog.d(TAG, "type " + r0);
        if (r0 != (-1000)) goto L8;
        new ResetPasswordReceiver.Processor().process(this.mContext, r4);
        return;
    L8:
        if (r0 != 1) goto L10;
        handleSetupWizardStart();
        return;
    L10:
        if (r0 != 2) goto L12;
        handleSetupWizardEnd();
        return;
    L12:
        if (r0 == 4) goto L23;
        if (r0 == 5) goto L21;
        switch(r0) {
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L38;
        };
    L17:
        new WifiLoginAndP2pNotificationBroadcast.Processor(this.mContext).process(r4);
        return;
    L18:
        new IconUpdateReceiver.Processor(this.mContext).process(r4);
        return;
    L19:
        new AppStatusReceiver.Processor(this.mContext).process(r4);
        return;
    L20:
        disableAccessibilityService(this.mContext);
        return;
    L38:
        return;
    L21:
        handleSystemUpdate();
        return;
    L23:
        if (SettingsApplication.needMonitorWizardNoOperation(this.mContext) == false) goto L34;
        shutDown(this.mContext);
        return;
    }

    private void handleSetupWizardStart() {
        OLog.d(TAG, "handleSetupWizardStart");
        PreferenceMgr.getInstance(this).putBoolean(Constants.KEY_NEED_PROMPT_LAUNCHER_CHOOSE, false);
        PreferenceMgr.getInstance(this).putBoolean(PreferenceMgr.KEY_PROMPT_SETUP_IDEA_PILLS_SHORTCUT, false);
        if (DeviceType.is(DeviceType.ODIN) == true) goto L5;
        SystemProperties.set(Constants.PROP_DEVICE_PROVISIONED, "0");
    L5:
        check(this.mContext);
        disableNFCRelativeAppsIfNeeded();
    }

    private void handleSetupWizardEnd() {
        OLog.d(TAG, "handleSetupWizardEnd");
        SystemProperties.set(Constants.PROP_DEVICE_PROVISIONED, "1");
        initHardwareInfoIfNeeded();
        DatabaseHelper.getInstance(this.mContext).recreate();
        DefaultBrowserSetter.start(this.mContext);
        Bundle r0 = new Bundle();
        r0.putString(SetupDefaultAppService.EXTRA_EVENT_TYPE, SetupDefaultAppService.EVENT_FOR_FINISH_WIZARD);
        SetupDefaultAppService.start(this.mContext, r0);
        Intent r1 = new Intent("com.bytedanceos.action.WIDGET_BUTTONS_CHANGED");
        r1.setPackage("com.android.systemui");
        sendBroadcast(r1);
    }

    private void disableNFCRelativeAppsIfNeeded() {
        if (Utils.isNfcSupport(this.mContext) == true) goto L6;
        OLog.d(TAG, "disableNFCRelativeAppsIfNeeded");
        setApplicationEnabledSetting("com.bytedanceos.wallet", 2, 0);
        setApplicationEnabledSetting("com.unionpay.tsmservice", 2, 0);
        setApplicationEnabledSetting("com.android.nfc", 2, 0);
        this.mContext.getPackageManager().setComponentEnabledSetting(new ComponentName("com.android.settings", "com.android.settings.NfcSettingsActivity"), 2, 1);
        return;
    }

    private void setApplicationEnabledSetting(String r1, int r2, int r3) {
        PackageManager r0 = this.mContext.getPackageManager();     // Catch: IllegalArgumentException -> L6
        if (r0 == null) goto L11;
        r0.setApplicationEnabledSetting(r1, r2, r3);     // Catch: IllegalArgumentException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        OLog.d(TAG, "setApplicationEnabledSetting failed", e);
    }

    private void initHardwareInfoIfNeeded() {
        if (Utils.isCtaTestModeOn() == false) goto L5;
        return;
    L5:
        ExecutorManager.execute(new HardwareDetailInfo(this.mContext));
    }

    private static void shutDown(Context r2) {
        OLog.d(TAG, "shutdown");
        ((PowerManager) r2.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).shutdown(false, "setupWizard shutdown for no operation", false);
    }

    private void handleSystemUpdate() {
        promptSetupthinkboostShortcut();
        reSavePinLength();
    }

    private void promptSetupthinkboostShortcut() {
        boolean r0 = PreferenceMgr.getInstance(this.mContext).getBoolean(PreferenceMgr.KEY_PROMPT_SETUP_IDEA_PILLS_SHORTCUT, true);
        OLog.d(TAG, "thinkboostNotice " + r0);
        if (r0 == false) goto L24;
        PreferenceMgr.getInstance(this).putBoolean(PreferenceMgr.KEY_PROMPT_SETUP_IDEA_PILLS_SHORTCUT, false);
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), SettingsSwitchKeyUtil.VOICE_INPUT, 0) != 1) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        return;
    L11:
        if (SettingsFeature.hasNoPowerKey() == false) goto L14;
        Intent r9 = new Intent(this.mContext, Settings.OppositeKeyOptionsActivity.class);
        r9.putExtra("scroll", true);
        r9.setFlags(805306368);
        Utils.showNotification(this.mContext, 200, R.drawable.ic_launcher_settings, R.string.notification_idea_pills_shortcut_title, R.string.click_for_more_details, r9);
        return;
    L14:
        if (DeviceType.is(DeviceType.U1) == false) goto L26;
        Intent r10 = new Intent(this.mContext, DialogActivity.class);
        r10.putExtra(DialogActivity.DIALOG_TYPE, 1);
        r10.setFlags(805306368);
        if (android.provider.Settings.Global.getInt(getContentResolver(), "volume_key", 1) != 1) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == false) goto L21;
        int r3 = R.string.volume_key_left;
    L22:
        String r7 = getString(R.string.notification_set_sidekey_title, new Object[]{getString(r3)});
        Context r4 = this.mContext;
        Utils.showNotification(r4, 201, R.drawable.ic_launcher_settings, r7, r4.getString(R.string.click_for_more_details), r10);
        return;
    L21:
        r3 = R.string.volume_key_right;
        goto L22
    L18:
        r2 = false;
        goto L19
    L26:
        return;
    L7:
        r1 = false;
        goto L8
    }

    private void notifythinkboostBeFormalVersion() {
        boolean r2 = true;
        boolean r0 = PreferenceMgr.getInstance(this.mContext).getBoolean(PreferenceMgr.KEY_FORMAL_IDEA_PILLS_APP_NOTIFICATION, true);
        OLog.d(TAG, "notifyFormalthinkboost " + r0);
        if (r0 == true) goto L5;
        return;
    L5:
        PreferenceMgr.getInstance(this).putBoolean(PreferenceMgr.KEY_FORMAL_IDEA_PILLS_APP_NOTIFICATION, false);
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), SettingsSwitchKeyUtil.VOICE_INPUT, 0) == 1) goto L9;
        r2 = false;
    L9:
        if (r2 == true) goto L12;
        Intent r8 = new Intent();
        r8.setComponent(new ComponentName("com.bytedanceos.sara", "com.bytedanceos.sara.bubble.SettingActivity"));
        r8.setFlags(805306368);
        Utils.showNotification(this.mContext, 202, R.drawable.sara, R.string.notification_formal_idea_pills, R.string.click_for_more_details, r8);
        return;
    }

    private void check(Context r3) {
        AirplaneModeEnablerEx r2 = new AirplaneModeEnablerEx(r3);
        if (android.provider.Settings.Global.getInt(r3.getContentResolver(), "airplane_mode_on", 0) == 0) goto L6;
        OLog.w(TAG, "check airplane mode enabled abnormally, close it now!");
        r2.setAirplaneModeOn(false);
        return;
    }

    private void reSavePinLength() {
        int r1 = android.provider.Settings.System.getInt(this.mContext.getContentResolver(), "pin_password_length_type");     // Catch: android.provider.Settings.SettingNotFoundException -> L9
        OLog.d(TAG, "reSavePinLength " + r1);
        if (r1 != 6) goto L7;
        LockPatternUtilsOnly.setPasswordLengthBytedance(new LockPatternUtils(this.mContext), r1, UserHandle.myUserId());
    L7:
        android.provider.Settings.System.putString(this.mContext.getContentResolver(), "pin_password_length_type", null);
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    private static String getNowTimeText() {
        Context r0 = SettingsApplication.getContext();
        if (r0 != null) goto L7;
        return System.currentTimeMillis() + "";
    L7:
        return DateUtils.formatDateTime(r0, System.currentTimeMillis(), 17);
    }

    private void disableAccessibilityService(Context r3) {
        if (SettingsUtil.isAccessibilityEnabled(r3, Constants.PKG_TALK_BACK) == false) goto L5;
        String r2 = "com.google.android.marvin.talkback/com.google.android.marvin.talkback.TalkBackService";
    L7:
        if (SettingsUtil.isAccessibilityEnabled(r3, Constants.PKG_BYYT_VOICE_BACK) == false) goto L10;
        r2 = "com.bjbyhd.voiceback/com.bjbyhd.voiceback.BoyhoodVoiceBackService";
    L10:
        if (SettingsUtil.isAccessibilityEnabled(r3, Constants.PKG_DM_VOICE_BACK) == false) goto L13;
        r2 = "com.dianming.phoneapp/com.dianming.phoneapp.MyAccessibilityService";
    L13:
        if (SettingsUtil.isAccessibilityEnabled(r3, Constants.PKG_DM_VOICE_BACK) == false) goto L16;
        r2 = "com.lvtech.ydcenter/com.lvtech.ydserver.accessibility.AccessibleService";
    L16:
        if (TextUtils.isEmpty(r2) == true) goto L19;
        Utils.enableAccessibilityService(r3, r2, false);
        return;
    L19:
        return;
    L5:
        r2 = null;
        goto L7
    }
}

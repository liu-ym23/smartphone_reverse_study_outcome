package com.android.settings.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.IWindowManager;
import com.android.settings.AdaptConstants;
import com.android.settings.Constants;
import com.android.settings.PreferenceMgr;
import com.android.settings.SoundSettingsFragment;
import com.android.settings.Utils;
import com.android.settings.sidedial.SideDialHelper;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.olog.OLog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsProviderUtils {
    public static final String SIDE_DIAL_CAR_MODE_SWITCH_TMP = "side_dial_car_mode_switch_tmp";
    public static final String SIDE_DIAL_CUSTOM_MODE_SWITCH = "side_dial_custom_mode_switch";
    public static final String SIDE_DIAL_CUSTOM_MODE_SWITCH_TMP = "side_dial_custom_mode_switch_tmp";
    public static final String WLAN_SECURITY_CHECK = "wlan_security_check";

    private static int getSwitchValue(boolean r0) {
        return r0 ? 1 : 0;
    }

    public SettingsProviderUtils() {
    }

    public static void setStayOnAllTimeEnable(Context r3, boolean r4) {
        if (r4 != isStayOnAllTimeEnable(r3)) goto L5;
        return;
    L5:
        Settings.Global.putInt(r3.getContentResolver(), "stay_on_alltime", getSwitchValue(r4));
        if (r4 == true) goto L11;
        PowerManager r5 = (PowerManager) r3.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if (r5 == null) goto L12;
        r5.userActivity(SystemClock.uptimeMillis(), false);
        return;
    L12:
        return;
    }

    public static boolean isStayOnAllTimeEnable(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "stay_on_alltime", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static void setAccelerometerRotation(Context r3, boolean r4) {
        if (r4 != isAccelerometerRotation(r3)) goto L13;
        return;
    L13:
        IWindowManager r0 = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));     // Catch: RemoteException -> L11
        if (r4 == false) goto L8;
        r0.thawRotation(r3.getPackageName());     // Catch: RemoteException -> L11
    L12:
        goto L9
    L8:
        r0.freezeRotation(0, r3.getPackageName());     // Catch: RemoteException -> L11
    L9:
        Settings.System.putInt(r3.getContentResolver(), "accelerometer_rotation", getSwitchValue(r4));
    }

    public static boolean isAccelerometerRotation(Context r2) {
        if (Settings.System.getInt(r2.getContentResolver(), "accelerometer_rotation", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static void setAutoBrightness(Context r1, boolean r2) {
        if (r2 != isAutoBrightness(r1)) goto L5;
        return;
    L5:
        Settings.System.putInt(r1.getContentResolver(), "screen_brightness_mode", r2 ? 1 : 0);
    }

    public static boolean isAutoBrightness(Context r2) {
        int r3 = Settings.System.getInt(r2.getContentResolver(), "screen_brightness_mode");     // Catch: Settings.SettingNotFoundException -> L5
    L7:
        if (r3 == 1) goto L9;
        return false;
    L9:
        return true;
    L5:
        r3 = 0;
        goto L7
    }

    public static boolean isProtectEyes(Context r2) {
        if (Settings.Secure.getInt(r2.getContentResolver(), "night_display_activated", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static void setReadMode(Context r7, boolean r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r8 == isReadMode(r7)) goto L24;
        HashMap r0 = (HashMap) Utils.fromJson(getSideDialCustomModeSwitch(r7), SideDialHelper.TYPE_TOKEN);
        if (r0.containsKey(Constants.SIDE_DIAL_CUSTOM_MODE_PROTECT_EYES) == false) goto L13;
        if ("1".equals(r0.get(Constants.SIDE_DIAL_CUSTOM_MODE_PROTECT_EYES)) == true) goto L13;
    L13:
        if (r0.containsKey(Constants.SIDE_DIAL_CUSTOM_MODE_READ_MODE) == false) goto L18;
        if ("1".equals(r0.get(Constants.SIDE_DIAL_CUSTOM_MODE_READ_MODE)) == true) goto L18;
    L18:
        isProtectEyes(r7);
        if (Settings.Global.getInt(r7.getContentResolver(), Constants.SIDE_DIAL_CUSTOM_PROTECT_NEED_IGNORE, 0) == 0) goto L21;
        Settings.Global.putInt(r7.getContentResolver(), Constants.SIDE_DIAL_CUSTOM_PROTECT_NEED_IGNORE, 0);
    L21:
        Settings.Global.putInt(r7.getContentResolver(), "read_mode_enable", r8 ? 1 : 0);
        return;
    }

    public static boolean isReadMode(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "read_mode_enable", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static void setMute(Context r1, boolean r2) {
        if (r2 != isMute(r1)) goto L5;
        return;
    L5:
        Settings.System.putInt(r1.getContentResolver(), "volume_panel_mute_enable", r2 ? 1 : 0);
    }

    public static boolean isMute(Context r2) {
        if (Settings.System.getInt(r2.getContentResolver(), "volume_panel_mute_enable", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static void setTelephonyVibrate(Context r1, boolean r2) {
        Settings.Global.putInt(r1.getContentResolver(), "telephony_vibration_enabled", r2 ? 1 : 0);
    }

    public static boolean isTelephonyVibrate(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "telephony_vibration_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void setFeedbackVibration(Context r1, boolean r2) {
        Settings.System.putInt(r1.getContentResolver(), "haptic_feedback_enabled", r2 ? 1 : 0);
    }

    public static boolean isFeedbackVibration(Context r2) {
        if (Settings.System.getInt(r2.getContentResolver(), "haptic_feedback_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void setGlobalVibration(Context r2, boolean r3) {
        PreferenceMgr.getInstance(r2).putInt(PreferenceMgr.KEY_GLOBAL_VIBRATION_ENABLED_USER, r3 ? 1 : 0);
        Settings.Global.putInt(r2.getContentResolver(), SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED, r3 ? 1 : 0);
    }

    public static boolean isGlobalVibration(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void setWirelessTntAuto(Context r1, boolean r2) {
        Settings.Global.putInt(r1.getContentResolver(), "wireless_tnt_auto", getSwitchValue(r2));
    }

    public static boolean isFeaturePhoneMode(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "feature_phone_mode", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isSideDialEnable(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "side_dial_enable", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static int getSideDialType(Context r2) {
        return Settings.Global.getInt(r2.getContentResolver(), "side_dial_type", 1);
    }

    public static void setSideDialType(Context r2, int r3) {
        if (r3 != (-1)) goto L5;
    L6:
        OLog.d("SettingsProviderUtils", "type = " + r3 + ";for 0466383");
    L7:
        Settings.Global.putInt(r2.getContentResolver(), "side_dial_type", r3);
        return;
    L5:
        if (r3 != 3) goto L7;
        goto L6
    }

    public static String getSideDialCarModeSwitch(Context r1) {
        String r2 = Settings.Global.getString(r1.getContentResolver(), "side_dial_car_mode_switch");
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return Constants.SIDE_DIAL_CAR_MODE_DEFAULT;
    L6:
        return r2;
    }

    public static void setSideDialCarModeSwitch(Context r1, String r2) {
        Settings.Global.putString(r1.getContentResolver(), "side_dial_car_mode_switch", r2);
    }

    public static String getSideDialCustomModeSwitch(Context r1) {
        String r2 = Settings.Global.getString(r1.getContentResolver(), SIDE_DIAL_CUSTOM_MODE_SWITCH);
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return Constants.SIDE_DIAL_CUSTOM_MODE_DEFAULT;
    L6:
        return r2;
    }

    public static void setSideDialCustomModeSwitch(Context r1, String r2) {
        Settings.Global.putString(r1.getContentResolver(), SIDE_DIAL_CUSTOM_MODE_SWITCH, r2);
    }

    public static String getSideDialCustomModeSwitchTmp(Context r1) {
        return Settings.Global.getString(r1.getContentResolver(), SIDE_DIAL_CUSTOM_MODE_SWITCH_TMP);
    }

    public static void setSideDialCustomModeSwitchTmp(Context r1, String r2) {
        Settings.Global.putString(r1.getContentResolver(), SIDE_DIAL_CUSTOM_MODE_SWITCH_TMP, r2);
    }

    public static String getSideDialCarModeSwitchTmp(Context r1) {
        return Settings.Global.getString(r1.getContentResolver(), SIDE_DIAL_CAR_MODE_SWITCH_TMP);
    }

    public static void setSideDialCarModeSwitchTmp(Context r1, String r2) {
        Settings.Global.putString(r1.getContentResolver(), SIDE_DIAL_CAR_MODE_SWITCH_TMP, r2);
    }

    public static float getSystemScreenBrightness(Context r1) {
        return Settings.System.getFloat(r1.getContentResolver(), AdaptConstants.SCREEN_BRIGHTNESS);
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0.0f;
    }

    public static boolean isWlanSecurityCheckSwitchEnabled(Context r1) {
        String r2 = Settings.Global.getString(r1.getContentResolver(), WLAN_SECURITY_CHECK);
        if (r2 != null) goto L5;
    L8:
        return true;
    L5:
        if (r2.equals("1") == true) goto L8;
        return false;
    }
}

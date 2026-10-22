package com.android.settings.sidedial;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.android.settings.Constants;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.bluetooth.LocalBluetoothAdapter;
import com.android.settings.utils.SettingsProviderUtils;
import com.google.gson.reflect.TypeToken;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class SideDialHelper {
    private static final String TAG = "SideDialHelper";
    public static final TypeToken<HashMap<String, String>> TYPE_TOKEN = null;

    public SideDialHelper() {
    }

    static {
        TYPE_TOKEN = new AnonymousClass1();
    }

    public static void recoveryMode(Context r1, int r2) {
        if (r2 != 2) goto L5;
        SettingsProviderUtils.setWirelessTntAuto(r1, false);
        return;
    L5:
        if (r2 != 4) goto L7;
        recoveryCarMode(r1);
        return;
    L7:
        if (r2 != 5) goto L15;
        recoveryCustomMode(r1);
        return;
    }

    public static void enterMode(Context r1, int r2) {
        if (r2 != 2) goto L5;
        SettingsProviderUtils.setWirelessTntAuto(r1, true);
        return;
    L5:
        if (r2 != 4) goto L7;
        enterCarMode(r1);
        return;
    L7:
        if (r2 != 5) goto L15;
        enterCustomMode(r1);
        return;
    }

    public static String getCarSummary(Context r8) {
        Resources r0 = r8.getResources();
        String r1 = r0.getString(R.string.side_dial_switch_enable);
        String r2 = r0.getString(R.string.side_dial_switch_disable);
        HashMap<String, String> r3 = getCarModeSwitchMap(r8);
        StringBuilder r4 = new StringBuilder();
        if (r3.get(Constants.SIDE_DIAL_CAR_MODE_BLUETOOTH).equals("1") == false) goto L5;
        String r5 = r1;
    L6:
        r4.append(r5);
        r4.append(r0.getString(R.string.bluetooth));
        r4.append("、");
        if (r3.get(Constants.SIDE_DIAL_CAR_MODE_ALWAYS_ON_SCREEN).equals("1") == false) goto L9;
        String r7 = r1;
    L10:
        r4.append(r7);
        r4.append(r0.getString(R.string.side_dial_screen_always_on));
        r4.append("、");
        r4.append(r0.getString(R.string.auto_rotation_header_title));
        if (r3.get(Constants.SIDE_DIAL_CAR_MODE_SCREEN_ROTATION).equals("1") == true) goto L14;
        r1 = r2;
    L14:
        r4.append(r1);
        String r6 = getNavigationAppName(r8, r3.get(Constants.SIDE_DIAL_CAR_MODE_NAVIGATION));
        if (r8.getString(R.string.car_mode_navigation_no).equals(r6) == true) goto L18;
        r4.append("、");
        r4.append(r0.getString(R.string.car_mode_navigation_summary));
        r4.append(r6);
    L18:
        return r4.toString();
    L9:
        r7 = r2;
        goto L10
    L5:
        r5 = r2;
        goto L6
    }

    public static String getCustomSummary(Context r5) {
        Resources r0 = r5.getResources();
        String r1 = r0.getString(R.string.side_dial_switch_enable);
        HashMap<String, String> r6 = getCustomModeSwitchMap(r5);
        ArrayList r2 = new ArrayList();
        if (r6.get(Constants.SIDE_DIAL_CUSTOM_MODE_SCREEN_ROTATION).equals("1") == false) goto L6;
        r2.add(r0.getString(R.string.side_dial_custom_auto_rotation));
    L6:
        if (r6.get(Constants.SIDE_DIAL_CUSTOM_MODE_AUTO_BRIGHTNESS).equals("1") == false) goto L9;
        r2.add(r0.getString(R.string.side_dial_custom_brightness_auto_switch));
    L9:
        if (r6.get(Constants.SIDE_DIAL_CUSTOM_MODE_ALWAYS_ON_SCREEN).equals("1") == false) goto L12;
        r2.add(r0.getString(R.string.side_dial_screen_always_on));
    L12:
        if (r6.get(Constants.SIDE_DIAL_CUSTOM_MODE_PROTECT_EYES).equals("1") == false) goto L15;
        r2.add(r0.getString(R.string.side_dial_custom_protect_eyes));
    L15:
        if (r6.get(Constants.SIDE_DIAL_CUSTOM_MODE_READ_MODE).equals("1") == false) goto L18;
        r2.add(r0.getString(R.string.side_dial_custom_read_mode));
    L18:
        if (r6.get(Constants.SIDE_DIAL_CUSTOM_MODE_MUTE).equals("1") == false) goto L21;
        r2.add(r0.getString(R.string.side_dial_mute_title));
    L21:
        if (r6.get(Constants.SIDE_DIAL_CUSTOM_MODE_TELEPHONY_VIBRATE).equals("1") == false) goto L24;
        r2.add(r0.getString(R.string.side_dial_custom_telephony_vibrate));
    L24:
        if (r6.get(Constants.SIDE_DIAL_CUSTOM_MODE_FEEDBACK_VIBRATION).equals("1") == false) goto L27;
        r2.add(r0.getString(R.string.side_dial_custom_navigationbar_gesture_vibration));
    L27:
        if (r6.get(Constants.SIDE_DIAL_CUSTOM_MODE_GLOBAL_VIBRATE).equals("1") == false) goto L29;
        r2.add(r0.getString(R.string.global_vibrate_title));
    L29:
        StringBuilder r7 = new StringBuilder();
        Iterator r3 = r2.iterator();
    L31:
        if (r3.hasNext() == false) goto L36;
        String r4 = (String) r3.next();
        r7.append(r1).append(r4);
        if (r3.hasNext() == false) goto L31;
        r7.append("、");
        goto L31
    L36:
        return r7.toString();
    }

    public static String getNavigationAppName(Context r3, String r4) {
        PackageManager r0 = r3.getPackageManager();
        PackageInfo r1 = r0.getPackageInfo(r4, 1);     // Catch: PackageManager.NameNotFoundException -> L5
    L8:
        if ("".equals(r4) == true) goto L14;
        if (r1 == null) goto L14;
        return r1.applicationInfo.loadLabel(r0).toString();
    L14:
        return r3.getString(R.string.car_mode_navigation_no);
    L5:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L8
    }

    private static void enterCarMode(Context r11) {
        PreferenceMgr r0 = PreferenceMgr.getInstance(r11);
        String r1 = SettingsProviderUtils.getSideDialCarModeSwitch(r11);
        String r2 = SettingsProviderUtils.getSideDialCarModeSwitchTmp(r11);
        String r3 = SettingsProviderUtils.getSideDialCarModeSwitch(r11);
        TypeToken<HashMap<String, String>> r4 = TYPE_TOKEN;
        HashMap r5 = (HashMap) Utils.fromJson(r3, r4);
        HashMap r6 = new HashMap();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r6 = (HashMap) Utils.fromJson(r2, r4);
    L5:
        String r7 = "0";
        if (SettingsProviderUtils.isStayOnAllTimeEnable(r11) == false) goto L8;
        Object r8 = "0";
    L10:
        if (SettingsProviderUtils.isAccelerometerRotation(r11) == false) goto L12;
        Object r9 = "0";
    L13:
        int r10 = getBluetoothState();
        if (r10 != 11) goto L16;
    L19:
        Iterator r12 = r5.keySet().iterator();
    L21:
        if (r12.hasNext() == false) goto L27;
        String r13 = (String) r12.next();
        if (Objects.equals(r6.get(r13), r5.get(r13)) == true) goto L21;
        putSetting(r11, r13, (String) r5.get(r13), true);
        goto L21
    L27:
        if (r5.containsKey(Constants.SIDE_DIAL_CAR_MODE_NAVIGATION) == false) goto L29;
        launchAppIfNeed(r11, (String) r5.get(Constants.SIDE_DIAL_CAR_MODE_NAVIGATION));
    L29:
        SettingsProviderUtils.setSideDialCarModeSwitchTmp(r11, r1);
        if (r0.getBoolean(Constants.IS_SIDE_DIAL_DETAIL_PAGE_MODIFY, false) == false) goto L33;
        r0.putBoolean(Constants.IS_SIDE_DIAL_DETAIL_PAGE_MODIFY, false);
        return;
    L33:
        r5.put(Constants.SIDE_DIAL_CAR_MODE_ALWAYS_ON_SCREEN, r8);
        r5.put(Constants.SIDE_DIAL_CAR_MODE_SCREEN_ROTATION, r9);
        r5.put(Constants.SIDE_DIAL_CAR_MODE_BLUETOOTH, r7);
        r0.putString(Constants.SIDE_DIAL_CAR_MODE_BLUETOOTH, r7);
        String r14 = Utils.toJson(r5);
        OLog.d(TAG, "enterCarMode: switch : " + r14);
        r0.putString(Constants.SIDE_DIAL_MODE_SWITCH_CURRENT, r14);
        return;
    L16:
        if (r10 == 12) goto L19;
        r7 = "1";
        goto L19
    L12:
        r9 = "1";
        goto L13
    L8:
        r8 = "1";
        goto L10
    }

    private static void recoveryCarMode(Context r6) {
        String r0 = PreferenceMgr.getInstance(r6).getString(Constants.SIDE_DIAL_MODE_SWITCH_CURRENT, null);
        OLog.d(TAG, "recoveryCarMode: switch : " + r0);
        HashMap r1 = (HashMap) Utils.fromJson(r0, TYPE_TOKEN);
        if (r1 != null) goto L5;
        return;
    L5:
        Iterator r2 = r1.keySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        String r3 = (String) r2.next();
        putSetting(r6, r3, (String) r1.get(r3), false);
        goto L7
    L9:
        SettingsProviderUtils.setSideDialCarModeSwitchTmp(r6, "");
        PreferenceMgr.getInstance(r6).putString(Constants.SIDE_DIAL_MODE_SWITCH_CURRENT, "");
    }

    private static void enterCustomMode(Context r18) {
        PreferenceMgr r1 = PreferenceMgr.getInstance(r18);
        String r2 = SettingsProviderUtils.getSideDialCustomModeSwitch(r18);
        String r3 = SettingsProviderUtils.getSideDialCustomModeSwitchTmp(r18);
        String r4 = SettingsProviderUtils.getSideDialCustomModeSwitch(r18);
        TypeToken<HashMap<String, String>> r5 = TYPE_TOKEN;
        HashMap r6 = (HashMap) Utils.fromJson(r4, r5);
        HashMap r7 = new HashMap();
        if (TextUtils.isEmpty(r3) == true) goto L5;
        r7 = (HashMap) Utils.fromJson(r3, r5);
    L5:
        String r8 = "0";
        if (SettingsProviderUtils.isStayOnAllTimeEnable(r18) == false) goto L8;
        Object r9 = "0";
    L10:
        if (SettingsProviderUtils.isAccelerometerRotation(r18) == false) goto L12;
        Object r10 = "0";
    L14:
        if (SettingsProviderUtils.isAutoBrightness(r18) == false) goto L16;
        Object r11 = "0";
    L18:
        if (SettingsProviderUtils.isProtectEyes(r18) == false) goto L20;
        Object r12 = "0";
    L22:
        if (SettingsProviderUtils.isReadMode(r18) == false) goto L24;
        Object r13 = "0";
    L26:
        if (SettingsProviderUtils.isMute(r18) == false) goto L28;
        Object r14 = "0";
    L30:
        if (SettingsProviderUtils.isTelephonyVibrate(r18) == false) goto L32;
        Object r15 = "0";
    L34:
        if (SettingsProviderUtils.isFeedbackVibration(r18) == false) goto L36;
        Object r16 = "0";
    L38:
        if (SettingsProviderUtils.isGlobalVibration(r18) == true) goto L41;
        r8 = "1";
    L41:
        Iterator r17 = r6.keySet().iterator();
    L43:
        if (r17.hasNext() == false) goto L49;
        String r19 = (String) r17.next();
        Iterator r110 = r17;
        HashMap r111 = r7;
        if (Objects.equals(r7.get(r19), r6.get(r19)) == true) goto L48;
        putSetting(r18, r19, (String) r6.get(r19), true);
    L48:
        r17 = r110;
        r7 = r111;
        goto L43
    L49:
        SettingsProviderUtils.setSideDialCustomModeSwitchTmp(r18, r2);
        if (r1.getBoolean(Constants.IS_SIDE_DIAL_CUSTOM_PAGE_MODIFY, false) == false) goto L53;
        r1.putBoolean(Constants.IS_SIDE_DIAL_CUSTOM_PAGE_MODIFY, false);
        return;
    L53:
        r6.put(Constants.SIDE_DIAL_CUSTOM_MODE_SCREEN_ROTATION, r10);
        r6.put(Constants.SIDE_DIAL_CUSTOM_MODE_AUTO_BRIGHTNESS, r11);
        r6.put(Constants.SIDE_DIAL_CUSTOM_MODE_ALWAYS_ON_SCREEN, r9);
        r6.put(Constants.SIDE_DIAL_CUSTOM_MODE_READ_MODE, r13);
        r6.put(Constants.SIDE_DIAL_CUSTOM_MODE_PROTECT_EYES, r12);
        r6.put(Constants.SIDE_DIAL_CUSTOM_MODE_MUTE, r14);
        r6.put(Constants.SIDE_DIAL_CUSTOM_MODE_TELEPHONY_VIBRATE, r15);
        r6.put(Constants.SIDE_DIAL_CUSTOM_MODE_FEEDBACK_VIBRATION, r16);
        r6.put(Constants.SIDE_DIAL_CUSTOM_MODE_GLOBAL_VIBRATE, r8);
        r1.putString(Constants.SIDE_DIAL_MODE_CUSTOM_SWITCH_CURRENT, Utils.toJson(r6));
        return;
    L36:
        r16 = "1";
        goto L38
    L32:
        r15 = "1";
        goto L34
    L28:
        r14 = "1";
        goto L30
    L24:
        r13 = "1";
        goto L26
    L20:
        r12 = "1";
        goto L22
    L16:
        r11 = "1";
        goto L18
    L12:
        r10 = "1";
        goto L14
    L8:
        r9 = "1";
        goto L10
    }

    private static void recoveryCustomMode(Context r6) {
        HashMap r0 = (HashMap) Utils.fromJson(PreferenceMgr.getInstance(r6).getString(Constants.SIDE_DIAL_MODE_CUSTOM_SWITCH_CURRENT, null), TYPE_TOKEN);
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator r1 = r0.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        String r3 = (String) r1.next();
        putSetting(r6, r3, (String) r0.get(r3), false);
        goto L7
    L9:
        SettingsProviderUtils.setSideDialCustomModeSwitchTmp(r6, "");
        PreferenceMgr.getInstance(r6).putString(Constants.SIDE_DIAL_MODE_CUSTOM_SWITCH_CURRENT, "");
    }

    public static void putSetting(Context r4, String r5, String r6, boolean r7) {
        String r0 = "1";
        byte r1 = 1;
        if (r7 != "1".equals(r6)) goto L5;
        boolean r8 = true;
    L6:
        OLog.d(TAG, "putSetting: enable : " + r8 + " , local key" + r5);
        r5.hashCode();
        switch(r5.hashCode()) {
            case -1324066458: goto L49;
            case -1203607823: goto L46;
            case -749051652: goto L42;
            case -536967900: goto L38;
            case -36802707: goto L34;
            case 95302135: goto L30;
            case 643245038: goto L26;
            case 771083239: goto L22;
            case 1010087916: goto L18;
            case 1205475432: goto L14;
            case 1987823763: goto L10;
            default: goto L8;
        };
    L8:
        r1 = -1;
    L52:
        switch(r1) {
            case 0: goto L68;
            case 1: goto L68;
            case 2: goto L67;
            case 3: goto L60;
            case 4: goto L59;
            case 5: goto L58;
            case 6: goto L57;
            case 7: goto L67;
            case 8: goto L56;
            case 9: goto L55;
            case 10: goto L54;
            default: goto L90;
        };
    L54:
        SettingsProviderUtils.setTelephonyVibrate(r4, r8);
        return;
    L55:
        SettingsProviderUtils.setGlobalVibration(r4, r8);
        return;
    L56:
        SettingsProviderUtils.setAutoBrightness(r4, r8);
        return;
    L57:
        SettingsProviderUtils.setMute(r4, r8);
        return;
    L58:
        SettingsProviderUtils.setReadMode(r4, r8);
        return;
    L59:
        SettingsProviderUtils.setFeedbackVibration(r4, r8);
        return;
    L60:
        PreferenceMgr r9 = PreferenceMgr.getInstance(r4);
        int r2 = r9.getInt(Constants.SIDE_DIAL_MODE_SWITCH_CURRENT_BLUETOOTH, -1);
        if (r8 == true) goto L64;
        r0 = "0";
    L64:
        r9.putIntSync(Constants.SIDE_DIAL_MODE_SWITCH_CURRENT_BLUETOOTH, Integer.parseInt(r0));
        if (r2 != (-1)) goto L87;
        setBluetoothEnable(r4, r8);
        return;
    L87:
        return;
    L67:
        SettingsProviderUtils.setAccelerometerRotation(r4, r8);
        return;
    L68:
        SettingsProviderUtils.setStayOnAllTimeEnable(r4, r8);
        return;
    L90:
        return;
    L10:
        if (r5.equals(Constants.SIDE_DIAL_CUSTOM_MODE_TELEPHONY_VIBRATE) == false) goto L70;
        r1 = 10;
        goto L52
    L70:
        r1 = -1;
        goto L52
    L14:
        if (r5.equals(Constants.SIDE_DIAL_CUSTOM_MODE_GLOBAL_VIBRATE) == false) goto L71;
        r1 = 9;
        goto L52
    L71:
        r1 = -1;
        goto L52
    L18:
        if (r5.equals(Constants.SIDE_DIAL_CUSTOM_MODE_AUTO_BRIGHTNESS) == false) goto L72;
        r1 = 8;
        goto L52
    L72:
        r1 = -1;
        goto L52
    L22:
        if (r5.equals(Constants.SIDE_DIAL_CAR_MODE_SCREEN_ROTATION) == false) goto L73;
        r1 = 7;
        goto L52
    L73:
        r1 = -1;
        goto L52
    L26:
        if (r5.equals(Constants.SIDE_DIAL_CUSTOM_MODE_MUTE) == false) goto L74;
        r1 = 6;
        goto L52
    L74:
        r1 = -1;
        goto L52
    L30:
        if (r5.equals(Constants.SIDE_DIAL_CUSTOM_MODE_READ_MODE) == false) goto L75;
        r1 = 5;
        goto L52
    L75:
        r1 = -1;
        goto L52
    L34:
        if (r5.equals(Constants.SIDE_DIAL_CUSTOM_MODE_FEEDBACK_VIBRATION) == false) goto L76;
        r1 = 4;
        goto L52
    L76:
        r1 = -1;
        goto L52
    L38:
        if (r5.equals(Constants.SIDE_DIAL_CAR_MODE_BLUETOOTH) == false) goto L77;
        r1 = 3;
        goto L52
    L77:
        r1 = -1;
        goto L52
    L42:
        if (r5.equals(Constants.SIDE_DIAL_CUSTOM_MODE_SCREEN_ROTATION) == false) goto L78;
        r1 = 2;
        goto L52
    L78:
        r1 = -1;
        goto L52
    L46:
        if (r5.equals(Constants.SIDE_DIAL_CUSTOM_MODE_ALWAYS_ON_SCREEN) == true) goto L52;
        r1 = -1;
        goto L52
    L49:
        if (r5.equals(Constants.SIDE_DIAL_CAR_MODE_ALWAYS_ON_SCREEN) == false) goto L80;
        r1 = 0;
        goto L52
    L80:
        r1 = -1;
        goto L52
    L5:
        r8 = false;
        goto L6
    }

    public static void setBluetoothEnable(Context r3, boolean r4) {
        LocalBluetoothAdapter r0 = LocalBluetoothAdapter.getInstance();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getBluetoothState();
        if (r1 != 12) goto L9;
        if (r4 == false) goto L9;
    L11:
        PreferenceMgr.getInstance(r3).putIntSync(Constants.SIDE_DIAL_MODE_SWITCH_CURRENT_BLUETOOTH, -1);
        return;
    L9:
        if (r1 != 10) goto L13;
        if (r4 == false) goto L11;
    L13:
        r0.setBluetoothEnabled(r4);
    }

    public static int getBluetoothState() {
        LocalBluetoothAdapter r0 = LocalBluetoothAdapter.getInstance();
        if (r0 != null) goto L7;
        return Integer.MIN_VALUE;
    L7:
        return r0.getBluetoothState();
    }

    private static void launchAppIfNeed(Context r5, String r6) {
        PreferenceMgr r0 = PreferenceMgr.getInstance(r5);
        if (SettingsProviderUtils.getSideDialType(r5) != 5) goto L5;
        String r1 = r0.getString(Constants.SIDE_DIAL_MODE_CUSTOM_SWITCH_CURRENT, "");
    L6:
        HashMap r2 = (HashMap) Utils.fromJson(r1, TYPE_TOKEN);
        if (r2 != null) goto L11;
        launchApp(r5, r6);
        return;
    L11:
        if (r6.equals(r2.get(Constants.SIDE_DIAL_CAR_MODE_NAVIGATION)) == false) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r6) == true) goto L15;
        launchApp(r5, r6);
    L15:
        r2.put(Constants.SIDE_DIAL_CAR_MODE_NAVIGATION, r6);
        r0.putString(Constants.SIDE_DIAL_MODE_SWITCH_CURRENT, Utils.toJson(r2));
        return;
    L5:
        r1 = r0.getString(Constants.SIDE_DIAL_MODE_SWITCH_CURRENT, "");
        goto L6
    }

    public static void launchApp(Context r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        Intent r3 = r1.getPackageManager().getLaunchIntentForPackage(r2);
        if (r3 != null) goto L8;
        return;
    L8:
        r3.setFlags(268435456);
        r1.startActivity(r3);
    }

    public static HashMap<String, String> getCarModeSwitchMap(Context r1) {
        return (HashMap) Utils.fromJson(SettingsProviderUtils.getSideDialCarModeSwitch(r1), TYPE_TOKEN);
    }

    public static HashMap<String, String> getCustomModeSwitchMap(Context r1) {
        return (HashMap) Utils.fromJson(SettingsProviderUtils.getSideDialCustomModeSwitch(r1), TYPE_TOKEN);
    }

    public static void removeCurrentCarModeSwitch(Context r1, String r2) {
        HashMap<String, String> r0 = getCurrentModeSwitchMap(r1);
        if (r0 == null) goto L6;
        r0.remove(r2);
        PreferenceMgr.getInstance(r1).putString(Constants.SIDE_DIAL_MODE_SWITCH_CURRENT, Utils.toJson(r0));
        return;
    }

    public static void removeCurrentCustomModeSwitch(Context r1, String r2) {
        HashMap<String, String> r0 = getCurrentModeCustomSwitchMap(r1);
        if (r0 == null) goto L6;
        r0.remove(r2);
        PreferenceMgr.getInstance(r1).putString(Constants.SIDE_DIAL_MODE_CUSTOM_SWITCH_CURRENT, Utils.toJson(r0));
        return;
    }

    public static void removeCurrentCarMadeSwitchIfNeed(Context r2, String r3, boolean r4) {
        HashMap<String, String> r0 = getCarModeSwitchMap(r2);
        if (r0.containsKey(r3) == true) goto L5;
        return;
    L5:
        if (r0.get(r3).equals("1") != r4) goto L7;
        return;
    L7:
        removeCurrentCarModeSwitch(r2, r3);
    }

    public static void removeCurrentCustomMadeSwitchIfNeed(Context r2, String r3, boolean r4) {
        if (SettingsProviderUtils.isFeaturePhoneMode(r2) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r0 = getCustomModeSwitchMap(r2);
        if (r0.containsKey(r3) == true) goto L8;
        return;
    L8:
        if (r0.get(r3).equals("1") != r4) goto L10;
        return;
    L10:
        removeCurrentCustomModeSwitch(r2, r3);
    }

    public static void handleEyesProtectionAutoChange(Context r4, String r5) {
        if (SettingsProviderUtils.isSideDialEnable(r4) == true) goto L5;
        return;
    L5:
        if (SettingsProviderUtils.getSideDialType(r4) != 5) goto L14;
        PreferenceMgr r6 = PreferenceMgr.getInstance(r4);
        HashMap r0 = (HashMap) Utils.fromJson(r6.getString(Constants.SIDE_DIAL_MODE_CUSTOM_SWITCH_CURRENT, null), TYPE_TOKEN);
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.containsKey(Constants.SIDE_DIAL_CUSTOM_MODE_PROTECT_EYES) == false) goto L11;
        r0.put(Constants.SIDE_DIAL_CUSTOM_MODE_PROTECT_EYES, r5);
    L11:
        r6.putString(Constants.SIDE_DIAL_MODE_CUSTOM_SWITCH_CURRENT, Utils.toJson(r0));
        return;
    }

    public static HashMap<String, String> getCurrentModeSwitchMap(Context r2) {
        return (HashMap) Utils.fromJson(PreferenceMgr.getInstance(r2).getString(Constants.SIDE_DIAL_MODE_SWITCH_CURRENT, null), TYPE_TOKEN);
    }

    public static HashMap<String, String> getCurrentModeCustomSwitchMap(Context r2) {
        return (HashMap) Utils.fromJson(PreferenceMgr.getInstance(r2).getString(Constants.SIDE_DIAL_MODE_CUSTOM_SWITCH_CURRENT, null), TYPE_TOKEN);
    }

    public static void handleSideDialStateChanged(Context r2) {
        OLog.d(TAG, "handleSideDialStateChanged: ");
        int r0 = SettingsProviderUtils.getSideDialType(r2);
        if (SettingsProviderUtils.isFeaturePhoneMode(r2) == false) goto L6;
        return;
    L6:
        if (SettingsProviderUtils.isSideDialEnable(r2) == false) goto L8;
        enterMode(r2, r0);
        return;
    L8:
        recoveryMode(r2, r0);
    }

    public static void sideDialStateChangedAfterBoot(Context r2) {
        if (SettingsProviderUtils.isFeaturePhoneMode(r2) == false) goto L6;
        return;
    L6:
        if (getCurrentModeSwitchMap(r2) == null) goto L8;
    L12:
        int r0 = SettingsProviderUtils.getSideDialType(r2);
        if (r0 != 4) goto L16;
        removeCurrentCarModeSwitch(r2, Constants.SIDE_DIAL_CAR_MODE_BLUETOOTH);
    L16:
        if (SettingsProviderUtils.isSideDialEnable(r2) == true) goto L19;
        recoveryMode(r2, r0);
        return;
    L19:
        return;
    L8:
        if (getCurrentModeCustomSwitchMap(r2) != null) goto L12;
        handleSideDialStateChanged(r2);
    }

    public static void setSideDialDetailPageModify(Context r2) {
        if (SettingsProviderUtils.isSideDialEnable(r2) == false) goto L6;
        PreferenceMgr.getInstance(r2).putBoolean(Constants.IS_SIDE_DIAL_DETAIL_PAGE_MODIFY, true);
        return;
    }

    public static void setSideDialCustomPageModify(Context r2) {
        if (SettingsProviderUtils.isSideDialEnable(r2) == false) goto L6;
        PreferenceMgr.getInstance(r2).putBoolean(Constants.IS_SIDE_DIAL_CUSTOM_PAGE_MODIFY, true);
        return;
    }
}

package com.obric.settingcommon;

import android.content.Context;
import android.text.TextUtils;
import bytedanceos.app.settings.search.SearchResultItem;
import bytedanceos.app.settings.search.SwitchItemValue;
import com.android.settings.BrightnessSettingsFragment;
import com.obric.oui.oswitch.OSwitch;
import java.util.ArrayList;
import java.util.List;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public class EnablerFactory {
    private static final List<String> OPPOSITE_KEYS = null;
    private static final List<String> PASSWORD_REQUIRED_KEYS = null;

    static {
        ArrayList r0 = new ArrayList();
        PASSWORD_REQUIRED_KEYS = r0;
        ArrayList r1 = new ArrayList();
        OPPOSITE_KEYS = r1;
        r0.add("enable_oaid");
        r0.add("faceid_enable");
        r0.add("face_data_enable_when_notification_turn_on_screen");
        r0.add("stay_in_locked_screen_when_face_recognized");
        r0.add("pickup_show_fp_icon");
        r0.add("use_fingerprint_when_screenoff");
        r1.add("stay_in_locked_screen_when_face_recognized");
    }

    public EnablerFactory() {
    }

    public static SettingsEnabler createSettingsEnabler(Context r2, SearchResultItem r3, boolean r4) {
        String r0 = r3.mSpecailKey;
        if (r4 == false) goto L8;
        if (TextUtils.isEmpty(r0) == true) goto L8;
        SettingsEnabler r5 = createSpecailClient(r2, r0, null);
    L11:
        r5.setSearchItem(r3);
        return r5;
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r5 = createNormal(r2, r3, null);
        goto L11
    L10:
        r5 = createSpecail(r2, r0, null);
        goto L11
    }

    public static SettingsEnabler createSettingsEnabler(Context r1, OSwitch r2, SearchResultItem r3) {
        return createSettingsEnabler(r1, r2, r3, true);
    }

    public static SettingsEnabler createSettingsEnabler(Context r4, OSwitch r5, SearchResultItem r6, boolean r7) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r6 != null) goto L9;
        r5.setVisibility(8);
        return null;
    L9:
        String r2 = r6.mIsSwitch;
    L29:
        r5.setVisibility(8);
        return null;
    L11:
        if (TextUtils.isEmpty(r2) == false) goto L13;
    L27:
        r5.setVisibility(8);     // Catch: NumberFormatException -> L29
        return null;
    L13:
        if (Integer.parseInt(r2) == 0) goto L27;
        r5.setVisibility(0);     // Catch: NumberFormatException -> L29
        r5.setEnabled(true);     // Catch: NumberFormatException -> L29
        String r0 = r6.mSpecailKey;
        if (r7 == false) goto L22;
        if (TextUtils.isEmpty(r0) == true) goto L22;
        SettingsEnabler r8 = createSpecailClient(r4, r0, r5);
    L25:
        r8.setSearchItem(r6);
        return r8;
    L22:
        if (TextUtils.isEmpty(r0) == false) goto L24;
        r8 = createNormal(r4, r6, r5);
        goto L25
    L24:
        r8 = createSpecail(r4, r0, r5);
        goto L25
    }

    private static SettingsEnabler createNormal(Context r3, SearchResultItem r4, OSwitch r5) {
        SwitchItemValue r0 = new SwitchItemValue(r4);
        if ("airplane_mode_on".equals(r0.mKey) == false) goto L7;
        return new AirplaneModeEnablerSearch(r3, r5);
    L7:
        if (SettingsSwitchKeyUtil.EYES_PROTECTION_ENABLE.equals(r0.mKey) == false) goto L11;
        return new EyesProtectionEnablerSearch(r3, r5);
    L11:
        if ("incall_power_button_behavior".equals(r0.mKey) == false) goto L15;
        return new PowerButtonEndsCallEnabler(r3, r5, r0);
    L15:
        if ("ota_enable_auto_download".equals(r0.mKey) == false) goto L19;
        return new OtaAutoInstallSettingsEnabler(r3, r5);
    L19:
        if (BrightnessSettingsFragment.DC_DIMMING.equals(r0.mKey) == false) goto L23;
        return new DcDimmingEnabler(r3, r5, r0);
    L23:
        if ("oaid_status_open".equals(r0.mKey) == false) goto L27;
        return new DefaultSettingsEnabler(r3, r5, r0, true);
    L27:
        if (PASSWORD_REQUIRED_KEYS.contains(r0.mKey) == false) goto L34;
        if (OPPOSITE_KEYS.contains(r0.mKey) == false) goto L32;
        return new PasswordRequirementEnabler(r3, r5, r0, true);
    L32:
        return new PasswordRequirementEnabler(r3, r5, r0);
    L34:
        return new DefaultSettingsEnabler(r3, r5, r0);
    }

    private static SettingsEnabler createSpecail(Context r1, String r2, OSwitch r3) {
        if ("wifi".equals(r2) == false) goto L7;
        return new WifiEnabler(r1, r3);
    L7:
        if (r2.equals("multi_wifi") == false) goto L11;
        return new MultiWifiEnabler(r1, r3);
    L11:
        if ("wifi_ap".equals(r2) == false) goto L15;
        return new WifiApEnabler(r1, r3);
    L15:
        if ("bluetooth".equals(r2) == false) goto L19;
        return new BluetoothSettingsEnabler(r1, r3);
    L19:
        if (SettingsSwitchKeyUtil.NFC.equals(r2) == false) goto L23;
        return new NfcEnablerSearch(r1, r3);
    L23:
        if ("rotation".equals(r2) == false) goto L27;
        return new AutoRotationEnablerSearch(r1, r3);
    L27:
        if (SettingsSwitchKeyUtil.PHONE_MOBILE_DATA_SWITCH.equals(r2) == false) goto L31;
        return new PhoneMobileDataEnabler(r1, r3);
    L31:
        if (SettingsSwitchKeyUtil.PHONE_MOBILE_DATA_ROAMING_SWITCH.equals(r2) == false) goto L35;
        return new PhoneMobileDataRoamingEnabler(r1, r3);
    L35:
        if (SettingsSwitchKeyUtil.HIDE_LOCK_PATTERN_TRACK.equals(r2) == false) goto L39;
        return new HideLockscreenPatternTrackEnabler(r1, r3);
    L39:
        if (SettingsSwitchKeyUtil.NETWORK_AVOID_BAD_WIFI.equals(r2) == false) goto L43;
        return new NetworkAvoidBadWifiEnabler(r1, r3);
    L43:
        if (SettingsSwitchKeyUtil.BLUETOOTH_VISIBILITY.equals(r2) == false) goto L47;
        return new BluetoothVisibilityEnabler(r1, r3);
    L47:
        if ("time_12_24".equals(r2) == false) goto L51;
        return new TimeFormatEnabler(r1, r3);
    L51:
        if (r2.equals(SettingsSwitchKeyUtil.SILENT_MODE) == false) goto L55;
        return new SilentEnabler(r1, r3);
    L55:
        if (r2.equals("browser_sync") == true) goto L81;
        if (r2.equals("contacts_sync") == true) goto L81;
        if (r2.equals("notes_sync") == true) goto L81;
        if (r2.equals("notes_sync_using_mobile_data") == true) goto L81;
        if (r2.equals(SettingsSwitchKeyUtil.OTG) == false) goto L68;
        return new OTGEnabler(r1, r3);
    L68:
        if (r2.equals(SettingsSwitchKeyUtil.CLICK_WAKE_SCREEN) == false) goto L72;
        return new ClickWakeScreenEnabler(r1, r3);
    L72:
        if (r2.equals(SettingsSwitchKeyUtil.AUTO_DARK_MODE) == false) goto L76;
        return new AutoDarkModeEnabler(r1, r3);
    L76:
        if ("location".equals(r2) == false) goto L79;
        new LocationServiceEnabler(r1, r3);
    L79:
        return new SettingsEnabler(r1, r3);
    L81:
        return new CloudServiceEnabler(r1, r3, r2);
    }

    private static SettingsEnabler createSpecailClient(Context r1, String r2, OSwitch r3) {
        if (r2.equals(SettingsSwitchKeyUtil.SILENT_MODE) == false) goto L7;
        return new SilentModeEnablerClient(r1, r3, r2);
    L7:
        if (r2.equals(SettingsSwitchKeyUtil.OTG) == false) goto L11;
        return new OTGEnabler(r1, r3);
    L11:
        if (r2.equals(SettingsSwitchKeyUtil.CLICK_WAKE_SCREEN) == false) goto L15;
        return new ClickWakeScreenEnabler(r1, r3);
    L15:
        if (SettingsSwitchKeyUtil.HIDE_LOCK_PATTERN_TRACK.equals(r2) == false) goto L19;
        return new HideLockscreenPatternTrackEnablerClient(r1, r3, r2);
    L19:
        if (r2.equals("browser_sync") == true) goto L30;
        if (r2.equals("contacts_sync") == true) goto L30;
        if (r2.equals("notes_sync") == true) goto L30;
        if (r2.equals("notes_sync_using_mobile_data") == true) goto L30;
        return new SettingsEnablerClient(r1, r3, r2);
    L30:
        return new CloudServiceEnabler(r1, r3, r2);
    }
}

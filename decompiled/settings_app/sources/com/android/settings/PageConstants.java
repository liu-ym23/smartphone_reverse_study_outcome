package com.android.settings;

import com.android.settings.applications.PreferredActivityCategoryFragment;
import com.android.settings.applications.PreferredActivityDetails;
import com.android.settings.bluetooth.BluetoothSettingsFragment;
import com.android.settings.eyesprotection.EyesProtectionFragment;
import com.android.settings.revone.DockSettingsFragment;
import com.android.settings.revone.KeyboardSettingsFragment;
import com.android.settings.revone.TNTSoundSettingsFragment;
import com.android.settings.revone.TabletWallpaperSettings;
import com.android.settings.revone.TntAssistFragment;
import com.android.settings.revone.boston.BostonSettingsFragment;
import com.android.settings.vpn2.VpnSettingsFragment;
import com.android.settings.wfd.WifiDisplaySettingsFragment;
import com.android.settings.wifi.WifiSettings;

/* JADX INFO: loaded from: classes2.dex */
public class PageConstants {
    public static final String LAUNCH_PAGE_BLUETOOTH = "bluetooth";
    public static final String LAUNCH_PAGE_BOSTON = "boston";
    public static final String LAUNCH_PAGE_DOCK = "dock";
    public static final String LAUNCH_PAGE_EYES = "eyes";
    public static final String LAUNCH_PAGE_KEYBOARD = "keyboard";
    public static final String LAUNCH_PAGE_NETWORK = "network";
    public static final String LAUNCH_PAGE_NOTIFICATION = "notification";
    public static final String LAUNCH_PAGE_PREFERRED = "preferred";
    public static final String LAUNCH_PAGE_READ_MODE = "read_mode";
    public static final String LAUNCH_PAGE_SCREEN = "screen";
    public static final String LAUNCH_PAGE_SCREEN_OFF_TIMEOUT = "screen_off_timeout";
    public static final String LAUNCH_PAGE_SOUND = "sound";
    public static final String LAUNCH_PAGE_SYSTEM_NOTIFICATION_BANNER = "system_notification_banner";
    public static final String LAUNCH_PAGE_VPN = "vpn";
    public static final String LAUNCH_PAGE_WALLPAPER = "wallpaper";
    public static final String LAUNCH_PAGE_WIFI = "wifi";
    public static final String LAUNCH_PAGE_WIFI_AP = "wifi_ap";
    public static final String LAUNCH_PAGE_WIFI_DISPLAY = "wifi_display";
    public static final String PAGE_CATEGORY_PREFERRED = null;
    public static final String PAGE_PREFERRED = null;
    public static final String PAGE_TNT_BLUETOOTH_SETTINGS = null;
    public static final String PAGE_TNT_BOSTON_SETTINGS = null;
    public static final String PAGE_TNT_BYTEDANCE_SETTINGS = null;
    public static final String PAGE_TNT_DOCK_SETTINGS = null;
    public static final String PAGE_TNT_EYES_PROTECTION = null;
    public static final String PAGE_TNT_KEYBOARD_SETTINGS = null;
    public static final String PAGE_TNT_NETWORK_SETTINGS = null;
    public static final String PAGE_TNT_NOTIFICATION_SETTINGS = null;
    public static final String PAGE_TNT_SCREEN_OFF_TIMEOUT_SETTINGS = null;
    public static final String PAGE_TNT_SOUND_SETTINGS = null;
    public static final String PAGE_TNT_SYSTEM_NOTIFICATION_BANNER_SETTINGS = null;
    public static final String PAGE_TNT_VPN_SETTINGS = null;
    public static final String PAGE_TNT_WALLPAPER_SETTINGS = null;
    public static final String PAGE_TNT_WIFI_AP_SETTINGS = null;
    public static final String PAGE_TNT_WIFI_DISPLAY_SETTINGS = null;
    public static final String PAGE_TNT_WIFI_SETTINGS = null;

    public PageConstants() {
    }

    static {
        PAGE_TNT_EYES_PROTECTION = EyesProtectionFragment.class.getName();
        PAGE_TNT_SOUND_SETTINGS = TNTSoundSettingsFragment.class.getName();
        PAGE_TNT_BLUETOOTH_SETTINGS = BluetoothSettingsFragment.class.getName();
        PAGE_TNT_NETWORK_SETTINGS = NetworkSettingsFragment.class.getName();
        PAGE_TNT_KEYBOARD_SETTINGS = KeyboardSettingsFragment.class.getName();
        PAGE_TNT_SCREEN_OFF_TIMEOUT_SETTINGS = ScreenOffTimeoutFragment.class.getName();
        PAGE_TNT_WIFI_SETTINGS = WifiSettings.class.getName();
        PAGE_TNT_VPN_SETTINGS = VpnSettingsFragment.class.getName();
        PAGE_TNT_WIFI_AP_SETTINGS = WifiApSettingFragment.class.getName();
        PAGE_TNT_WIFI_DISPLAY_SETTINGS = WifiDisplaySettingsFragment.class.getName();
        PAGE_TNT_BOSTON_SETTINGS = BostonSettingsFragment.class.getName();
        PAGE_TNT_BYTEDANCE_SETTINGS = TntAssistFragment.class.getName();
        PAGE_TNT_WALLPAPER_SETTINGS = TabletWallpaperSettings.class.getName();
        PAGE_TNT_DOCK_SETTINGS = DockSettingsFragment.class.getName();
        PAGE_TNT_NOTIFICATION_SETTINGS = NotificationSettingsFragment.class.getName();
        PAGE_PREFERRED = PreferredActivityDetails.class.getName();
        PAGE_TNT_SYSTEM_NOTIFICATION_BANNER_SETTINGS = SystemNotificationBannerFragment.class.getName();
        PAGE_CATEGORY_PREFERRED = PreferredActivityCategoryFragment.class.getName();
    }
}

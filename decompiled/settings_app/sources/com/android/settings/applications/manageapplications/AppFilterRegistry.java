package com.android.settings.applications.manageapplications;

import com.android.settings.R;
import com.android.settings.applications.AppStateAlarmsAndRemindersBridge;
import com.android.settings.applications.AppStateInstallAppsBridge;
import com.android.settings.applications.AppStateInteractAcrossProfilesBridge;
import com.android.settings.applications.AppStateManageExternalStorageBridge;
import com.android.settings.applications.AppStateMediaManagementAppsBridge;
import com.android.settings.applications.AppStateNotificationBridge;
import com.android.settings.applications.AppStateOverlayBridge;
import com.android.settings.applications.AppStateTurnScreenOnBridge;
import com.android.settings.applications.AppStateUsageBridge;
import com.android.settings.applications.AppStateWriteSettingsBridge;
import com.android.settings.nfc.AppStateNfcTagAppsBridge;
import com.android.settings.wifi.AppStateChangeWifiStateBridge;
import com.android.settingslib.applications.ApplicationsState;

/* JADX INFO: loaded from: classes2.dex */
public class AppFilterRegistry {
    public static final int FILTER_ALARMS_AND_REMINDERS = 18;
    public static final int FILTER_APPS_ALL = 4;
    public static final int FILTER_APPS_BATTERY_OPTIMIZED = 22;
    public static final int FILTER_APPS_BATTERY_RESTRICTED = 23;
    public static final int FILTER_APPS_BATTERY_UNRESTRICTED = 21;
    public static final int FILTER_APPS_BLOCKED = 16;
    public static final int FILTER_APPS_CLONE = 25;
    public static final int FILTER_APPS_DISABLED = 7;
    public static final int FILTER_APPS_ENABLED = 5;
    public static final int FILTER_APPS_FREQUENT = 3;
    public static final int FILTER_APPS_INSTALL_SOURCES = 13;
    public static final int FILTER_APPS_INSTANT = 6;
    public static final int FILTER_APPS_LOCALE = 20;
    public static final int FILTER_APPS_MEDIA_MANAGEMENT = 19;
    public static final int FILTER_APPS_NFC_TAG = 26;
    public static final int FILTER_APPS_PERSONAL = 8;
    public static final int FILTER_APPS_POWER_ALLOWLIST = 0;
    public static final int FILTER_APPS_POWER_ALLOWLIST_ALL = 1;
    public static final int FILTER_APPS_RECENT = 2;
    public static final int FILTER_APPS_TURN_SCREEN_ON = 27;
    public static final int FILTER_APPS_USAGE_ACCESS = 10;
    public static final int FILTER_APPS_WITH_OVERLAY = 11;
    public static final int FILTER_APPS_WORK = 9;
    public static final int FILTER_APPS_WRITE_SETTINGS = 12;
    public static final int FILTER_APP_CAN_CHANGE_WIFI_STATE = 15;
    public static final int FILTER_INTERACT_ACROSS_PROFILES = 28;
    public static final int FILTER_LONG_BACKGROUND_TASKS = 24;
    public static final int FILTER_MANAGE_EXTERNAL_STORAGE = 17;
    private static final int NUM_FILTER_ENTRIES = 29;
    private static AppFilterRegistry sRegistry;
    private final AppFilterItem[] mFilters;

    @interface FilterType {
    }

    public int getDefaultFilterType(int r1) {
        switch(r1) {
            case 1: goto L37;
            case 2: goto L3;
            case 3: goto L3;
            case 4: goto L35;
            case 5: goto L33;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L3;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L7;
            case 20: goto L3;
            case 21: goto L5;
            default: goto L3;
        };
    L3:
        return 4;
    L5:
        return 28;
    L7:
        return 27;
    L9:
        return 26;
    L11:
        return 25;
    L13:
        return 24;
    L15:
        return 22;
    L17:
        return 20;
    L19:
        return 19;
    L21:
        return 18;
    L23:
        return 17;
    L25:
        return 15;
    L27:
        return 13;
    L29:
        return 12;
    L31:
        return 11;
    L33:
        return 0;
    L35:
        return 10;
    L37:
        return 2;
    }

    private AppFilterRegistry() {
        AppFilterItem[] r0 = new AppFilterItem[29];
        this.mFilters = r0;
        r0[1] = new AppFilterItem(new ApplicationsState.CompoundFilter(ApplicationsState.FILTER_WITHOUT_DISABLED_UNTIL_USED, ApplicationsState.FILTER_ALL_ENABLED), 1, R.string.filter_all_apps);
        r0[4] = new AppFilterItem(ApplicationsState.FILTER_EVERYTHING, 4, R.string.filter_all_apps);
        r0[5] = new AppFilterItem(ApplicationsState.FILTER_ALL_ENABLED, 5, R.string.filter_enabled_apps);
        r0[7] = new AppFilterItem(ApplicationsState.FILTER_DISABLED, 7, R.string.filter_apps_disabled);
        r0[8] = new AppFilterItem(ApplicationsState.FILTER_PERSONAL, 8, R.string.category_personal);
        r0[9] = new AppFilterItem(ApplicationsState.FILTER_WORK, 9, R.string.category_work);
        r0[10] = new AppFilterItem(AppStateUsageBridge.FILTER_APP_USAGE, 10, R.string.filter_all_apps);
        r0[11] = new AppFilterItem(AppStateOverlayBridge.FILTER_SYSTEM_ALERT_WINDOW, 11, R.string.filter_overlay_apps);
        r0[12] = new AppFilterItem(AppStateWriteSettingsBridge.FILTER_WRITE_SETTINGS, 12, R.string.filter_write_settings_apps);
        r0[13] = new AppFilterItem(AppStateInstallAppsBridge.FILTER_APP_SOURCES, 13, R.string.filter_install_sources_apps);
        r0[15] = new AppFilterItem(AppStateChangeWifiStateBridge.FILTER_CHANGE_WIFI_STATE, 15, R.string.filter_write_settings_apps);
        r0[16] = new AppFilterItem(AppStateNotificationBridge.FILTER_APP_NOTIFICATION_BLOCKED, 16, R.string.filter_notif_blocked_apps);
        r0[17] = new AppFilterItem(AppStateManageExternalStorageBridge.FILTER_MANAGE_EXTERNAL_STORAGE, 17, R.string.filter_manage_external_storage);
        r0[18] = new AppFilterItem(AppStateAlarmsAndRemindersBridge.FILTER_CLOCK_APPS, 18, R.string.alarms_and_reminders_title);
        r0[19] = new AppFilterItem(AppStateMediaManagementAppsBridge.FILTER_MEDIA_MANAGEMENT_APPS, 19, R.string.media_management_apps_title);
        r0[26] = new AppFilterItem(AppStateNfcTagAppsBridge.FILTER_APPS_NFC_TAG, 26, R.string.change_nfc_tag_apps_title);
        r0[27] = new AppFilterItem(AppStateTurnScreenOnBridge.FILTER_TURN_SCREEN_ON_APPS, 27, R.string.turn_screen_on_title);
        r0[28] = new AppFilterItem(AppStateInteractAcrossProfilesBridge.FILTER_INTERACT_ACROSS_PROFILES, 28, R.string.interact_across_profiles_title);
    }

    public static AppFilterRegistry getInstance() {
        if (sRegistry != null) goto L6;
        sRegistry = new AppFilterRegistry();
    L6:
        return sRegistry;
    }

    public AppFilterItem get(int r1) {
        return this.mFilters[r1];
    }
}

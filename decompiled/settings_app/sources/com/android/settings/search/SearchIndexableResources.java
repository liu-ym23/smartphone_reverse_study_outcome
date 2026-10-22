package com.android.settings.search;

import android.provider.SearchIndexableResource;
import com.android.settings.DevelopmentSettings;
import com.android.settings.PrivacySettings;
import com.android.settings.R;
import com.android.settings.ScreenPinningSettings;
import com.android.settings.SecuritySettings;
import com.android.settings.WallpaperTypeSettings;
import com.android.settings.accessibility.AccessibilitySettings;
import com.android.settings.accounts.AccountSettings;
import com.android.settings.bluetooth.BluetoothSettings;
import com.android.settings.display.ScreenZoomSettings;
import com.android.settings.inputmethod.InputMethodAndLanguageSettings;
import com.android.settings.notification.ConfigureNotificationSettings;
import com.android.settings.notification.OtherSoundSettings;
import com.android.settings.notification.SoundSettings;
import com.android.settings.wifi.SavedAccessPointsWifiSettings;
import com.android.settings.wifi.WifiSettings;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class SearchIndexableResources {
    public static int NO_DATA_RES_ID;
    private static HashMap<String, SearchIndexableResource> sResMap;

    static {
        HashMap<String, SearchIndexableResource> r0 = new HashMap();
        sResMap = r0;
        r0.put(WifiSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(WifiSettings.class.getName()), NO_DATA_RES_ID, WifiSettings.class.getName(), R.drawable.setting_item_icon_wifi));
        sResMap.put(SavedAccessPointsWifiSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(SavedAccessPointsWifiSettings.class.getName()), R.xml.wifi_display_saved_access_points, SavedAccessPointsWifiSettings.class.getName(), R.drawable.setting_item_icon_wifi));
        sResMap.put(BluetoothSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(BluetoothSettings.class.getName()), NO_DATA_RES_ID, BluetoothSettings.class.getName(), R.drawable.ic_settings_bluetooth));
        sResMap.put(ScreenZoomSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(ScreenZoomSettings.class.getName()), NO_DATA_RES_ID, ScreenZoomSettings.class.getName(), R.drawable.ic_settings_display));
        sResMap.put(WallpaperTypeSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(WallpaperTypeSettings.class.getName()), NO_DATA_RES_ID, WallpaperTypeSettings.class.getName(), R.drawable.ic_settings_display));
        sResMap.put(ConfigureNotificationSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(ConfigureNotificationSettings.class.getName()), R.xml.configure_notification_settings, ConfigureNotificationSettings.class.getName(), R.drawable.ic_settings_notifications));
        sResMap.put(SoundSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(SoundSettings.class.getName()), NO_DATA_RES_ID, SoundSettings.class.getName(), R.drawable.ic_settings_sound));
        sResMap.put(OtherSoundSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(OtherSoundSettings.class.getName()), NO_DATA_RES_ID, OtherSoundSettings.class.getName(), R.drawable.ic_settings_sound));
        sResMap.put(SecuritySettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(SecuritySettings.class.getName()), NO_DATA_RES_ID, SecuritySettings.class.getName(), R.drawable.setting_item_icon_safe));
        sResMap.put(ScreenPinningSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(ScreenPinningSettings.class.getName()), NO_DATA_RES_ID, ScreenPinningSettings.class.getName(), R.drawable.ic_settings_security));
        sResMap.put(AccountSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(AccountSettings.class.getName()), NO_DATA_RES_ID, AccountSettings.class.getName(), R.drawable.ic_settings_accounts));
        sResMap.put(InputMethodAndLanguageSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(InputMethodAndLanguageSettings.class.getName()), NO_DATA_RES_ID, InputMethodAndLanguageSettings.class.getName(), R.drawable.setting_item_icon_advanced));
        sResMap.put(PrivacySettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(PrivacySettings.class.getName()), NO_DATA_RES_ID, PrivacySettings.class.getName(), R.drawable.setting_item_icon_advanced));
        sResMap.put(AccessibilitySettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(AccessibilitySettings.class.getName()), NO_DATA_RES_ID, AccessibilitySettings.class.getName(), R.drawable.setting_item_icon_advanced));
        sResMap.put(DevelopmentSettings.class.getName(), new SearchIndexableResource(Ranking.getRankForClassName(DevelopmentSettings.class.getName()), NO_DATA_RES_ID, DevelopmentSettings.class.getName(), R.drawable.setting_item_icon_advanced));
    }

    private SearchIndexableResources() {
    }

    public static int size() {
        return sResMap.size();
    }

    public static SearchIndexableResource getResourceByName(String r1) {
        return sResMap.get(r1);
    }

    public static Collection<SearchIndexableResource> values() {
        return sResMap.values();
    }
}

package com.android.settings.search;

import com.android.settings.ChooseLockGeneric;
import com.android.settings.DevelopmentSettings;
import com.android.settings.LegalSettings;
import com.android.settings.PrivacySettings;
import com.android.settings.ScreenPinningSettings;
import com.android.settings.SecuritySettings;
import com.android.settings.WallpaperTypeSettings;
import com.android.settings.accessibility.AccessibilitySettings;
import com.android.settings.accounts.AccountSettings;
import com.android.settings.applications.AdvancedAppSettings;
import com.android.settings.applications.SpecialAccessSettings;
import com.android.settings.bluetooth.BluetoothSettings;
import com.android.settings.deviceinfo.StorageSettings;
import com.android.settings.inputmethod.InputMethodAndLanguageSettings;
import com.android.settings.location.LocationSettings;
import com.android.settings.location.ScanningSettings;
import com.android.settings.notification.ConfigureNotificationSettings;
import com.android.settings.notification.OtherSoundSettings;
import com.android.settings.notification.SoundSettings;
import com.android.settings.print.PrintSettingsFragment;
import com.android.settings.users.UserSettings;
import com.android.settings.wifi.SavedAccessPointsWifiSettings;
import com.android.settings.wifi.WifiSettings;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class Ranking {
    public static final int BASE_RANK_DEFAULT = 2048;
    public static final int RANK_ACCESSIBILITY = 20;
    public static final int RANK_ACCOUNT = 16;
    public static final int RANK_APPS = 10;
    public static final int RANK_BT = 2;
    public static final int RANK_DATA_USAGE = 4;
    public static final int RANK_DATE_TIME = 19;
    public static final int RANK_DEVELOPEMENT = 22;
    public static final int RANK_DEVICE_INFO = 23;
    public static final int RANK_DISPLAY = 6;
    public static final int RANK_IME = 17;
    public static final int RANK_LOCATION = 14;
    public static final int RANK_NOTIFICATIONS = 8;
    public static final int RANK_OTHERS = 1024;
    public static final int RANK_POWER_USAGE = 12;
    public static final int RANK_PRINTING = 21;
    public static final int RANK_PRIVACY = 18;
    public static final int RANK_SECURITY = 15;
    public static final int RANK_SIM = 3;
    public static final int RANK_SOUND = 9;
    public static final int RANK_STORAGE = 11;
    public static final int RANK_UNDEFINED = -1;
    public static final int RANK_USERS = 13;
    public static final int RANK_WALLPAPER = 7;
    public static final int RANK_WIFI = 1;
    public static final int RANK_WIRELESS = 5;
    private static HashMap<String, Integer> sBaseRankMap = null;
    public static int sCurrentBaseRank = 2048;
    private static HashMap<String, Integer> sRankMap;

    public Ranking() {
    }

    static {
        sRankMap = new HashMap();
        sBaseRankMap = new HashMap();
        sRankMap.put(WifiSettings.class.getName(), 1);
        sRankMap.put(SavedAccessPointsWifiSettings.class.getName(), 1);
        sRankMap.put(BluetoothSettings.class.getName(), 2);
        sRankMap.put(WallpaperTypeSettings.class.getName(), 7);
        sRankMap.put(SoundSettings.class.getName(), 9);
        sRankMap.put(ConfigureNotificationSettings.class.getName(), 8);
        sRankMap.put(OtherSoundSettings.class.getName(), 8);
        sRankMap.put(StorageSettings.class.getName(), 11);
        sRankMap.put(AdvancedAppSettings.class.getName(), 10);
        sRankMap.put(SpecialAccessSettings.class.getName(), 10);
        sRankMap.put(UserSettings.class.getName(), 13);
        sRankMap.put(LocationSettings.class.getName(), 14);
        sRankMap.put(ScanningSettings.class.getName(), 14);
        sRankMap.put(SecuritySettings.class.getName(), 15);
        sRankMap.put(ChooseLockGeneric.ChooseLockGenericFragment.class.getName(), 15);
        sRankMap.put(ScreenPinningSettings.class.getName(), 15);
        sRankMap.put(AccountSettings.class.getName(), 16);
        sRankMap.put(InputMethodAndLanguageSettings.class.getName(), 17);
        sRankMap.put(PrivacySettings.class.getName(), 18);
        sRankMap.put(AccessibilitySettings.class.getName(), 20);
        sRankMap.put(PrintSettingsFragment.class.getName(), 21);
        sRankMap.put(DevelopmentSettings.class.getName(), 22);
        sRankMap.put(LegalSettings.class.getName(), 23);
        sBaseRankMap.put("com.android.settings", 0);
    }

    public static int getRankForClassName(String r1) {
        Integer r2 = sRankMap.get(r1);
        if (r2 != null) goto L7;
        return 1024;
    L7:
        return r2.intValue();
    }

    public static int getBaseRankForAuthority(String r3) {
        HashMap<String, Integer> r0 = sBaseRankMap;
        monitor-enter(r0);
        Integer r1 = sBaseRankMap.get(r3);     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        int r4 = r1.intValue();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L9:
        int r2 = sCurrentBaseRank + 1;     // Catch: Throwable -> L12
        sCurrentBaseRank = r2;     // Catch: Throwable -> L12
        sBaseRankMap.put(r3, Integer.valueOf(r2));     // Catch: Throwable -> L12
        int r5 = sCurrentBaseRank;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r5;
    L12:
        th = move-exception;
        throw th;
    }
}

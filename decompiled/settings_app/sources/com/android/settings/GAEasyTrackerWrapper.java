package com.android.settings;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public class GAEasyTrackerWrapper {
    public static void activityStart(Activity r0) {
    }

    public static void activityStop(Activity r0) {
    }

    private static void sendEvent(String r0, String r1, String r2, Long r3) {
    }

    public GAEasyTrackerWrapper() {
    }

    public static void traceWallpaperChoosed(int r3) {
        sendEvent("WallpaperSettings", "WallpaperChoose", "WallpaperIndex_" + (r3 + 1), 1L);
    }

    public static void traceObsessionSwitch(String r2, boolean r3) {
        sendEvent("Obsessions", "Switch", r2 + "_" + r3, 1L);
    }

    public static void traceLanguageQuickSetting() {
        sendEvent("LanguageSettings", "Click", "LanguageQuickSettingsEntry", 1L);
    }

    public static void traceAutoBrightnessSwitch(boolean r3) {
        sendEvent("BrightnessSettings", "Switch", "AutoBrightness_" + r3, 1L);
    }
}

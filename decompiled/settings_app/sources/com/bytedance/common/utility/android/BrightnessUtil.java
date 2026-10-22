package com.bytedance.common.utility.android;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;
import android.view.WindowManager;
import com.android.settings.AdaptConstants;

/* JADX INFO: loaded from: classes3.dex */
public final class BrightnessUtil {
    private static final float BRIGHT_SCALE = 0.003921569f;

    private BrightnessUtil() {
    }

    public static boolean isAutoBrightness(Activity r2) {
        if (r2 != null) goto L12;
        return false;
    L12:
        if (Settings.System.getInt(r2.getContentResolver(), "screen_brightness_mode") == 1) goto L15;
        return false;
    L15:
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static float getScreenBrightness(Activity r1) {
        if (r1 != null) goto L8;
        return 0.0f;
    L8:
        return r1.getWindow().getAttributes().screenBrightness;
    L10:
        return 0.0f;
    }

    public static void setScreenBrightness(Activity r2, int r3) {
        if (r2 != null) goto L7;
        return;
    L7:
        WindowManager.LayoutParams r0 = r2.getWindow().getAttributes();     // Catch: Exception -> L6
        r0.screenBrightness = Float.valueOf(r3).floatValue() * BRIGHT_SCALE;     // Catch: Exception -> L6
        r2.getWindow().setAttributes(r0);     // Catch: Exception -> L6
        return;
    }

    public static int getBrightness(Activity r2) {
        if (r2 != null) goto L10;
        return 0;
    L10:
        return Settings.System.getInt(r2.getContentResolver(), AdaptConstants.SCREEN_BRIGHTNESS);
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static void stopAutoBrightness(Activity r2) {
        Settings.System.putInt(r2.getContentResolver(), "screen_brightness_mode", 0);
    }

    public static void startAutoBrightness(Activity r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Settings.System.putInt(r2.getContentResolver(), "screen_brightness_mode", 1);
    }

    public static void saveBrightness(Activity r2, int r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        Uri r1 = Settings.System.getUriFor(AdaptConstants.SCREEN_BRIGHTNESS);
        ContentResolver r4 = r2.getContentResolver();
        Settings.System.putInt(r4, AdaptConstants.SCREEN_BRIGHTNESS, r3);
        r4.notifyChange(r1, null);
    }
}

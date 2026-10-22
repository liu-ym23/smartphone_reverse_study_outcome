package com.android.settings.eldership;

import android.content.Context;
import android.provider.Settings;
import bytedanceos.util.DeviceType;
import com.android.settings.LauncherChooseActivity;
import com.android.settings.LauncherSettingsFragment;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class EldershipUtils {
    public static final int LAUNCHER_THEME_CLASSIC = 0;
    public static final int LAUNCHER_THEME_TRANSPARENT = 1;
    public static final int SCREEN_ZOOM_LARGE = 640;
    public static final int SCREEN_ZOOM_NORMAL = 560;

    public static boolean isTransparentLauncherTheme(int r1) {
        if (r1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public EldershipUtils() {
    }

    public static int getDefaultEldershipLauncherMode() {
        if (SettingsFeature.isLauncher12GridsSupport() == false) goto L6;
        return 12;
    L6:
        return 9;
    }

    public static float getDefaultEldershipFontSize(Context r1) {
        return r1.getResources().getInteger(R.integer.bigger_font_size_value) / 10.0f;
    }

    public static String getLauncherSettingSubTitle(Context r2, int r3, int r4) {
        String r1 = null;
        if (r3 != 9) goto L5;
        String r5 = r2.getString(R.string.launcher_mode_number_9);
    L15:
        if (r5 == null) goto L18;
        r1 = r2.getString(R.string.grids, new Object[]{r5});
    L18:
        if (r4 != 0) goto L20;
        int r6 = R.string.material_theme;
    L21:
        String r7 = r2.getString(r6);
        if (r1 != null) goto L25;
        return r7;
    L25:
        return r1 + " + " + r7;
    L20:
        r6 = R.string.transparent_theme;
        goto L21
    L5:
        if (r3 != 12) goto L7;
        r5 = r2.getString(R.string.launcher_mode_number_12);
        goto L15
    L7:
        if (r3 != 16) goto L9;
        r5 = r2.getString(R.string.launcher_mode_number_16);
        goto L15
    L9:
        if (r3 == 20) goto L11;
        r5 = null;
        goto L15
    L11:
        r5 = r2.getString(R.string.launcher_mode_number_20);
        goto L15
    }

    public static void saveFontSize(Context r1, float r2) {
        Settings.System.putFloat(r1.getContentResolver(), "font_scale", r2);
    }

    public static void saveLauncherSettings(Context r3, int r4, int r5) {
        int r0 = Utils.getCurrentLauncherMode(r3);
        boolean r1 = true;
        if (r0 == r4) goto L5;
        LauncherSettingsFragment.setDefaultBytedanceLauncher(r3, r0, r4);
        boolean r2 = true;
    L7:
        if (Utils.getCurrentLauncherTheme(r3) == r5) goto L9;
        Settings.Global.putInt(r3.getContentResolver(), "launcher_grid_theme", r5);
    L10:
        if (r1 == false) goto L13;
        LauncherSettingsFragment.resetThumbMode(r3);
        LauncherChooseActivity.notifyLauncherModeChanged(r3, r4);
        LauncherSettingsFragment.killLauncher(r3);
        return;
    L13:
        return;
    L9:
        r1 = r2;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    public static boolean isLowConfigDevice() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.T1, DeviceType.T2, DeviceType.U1, DeviceType.OSCAR});
    }
}

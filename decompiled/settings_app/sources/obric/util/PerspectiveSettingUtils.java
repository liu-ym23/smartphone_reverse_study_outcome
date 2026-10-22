package obric.util;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes5.dex */
public class PerspectiveSettingUtils {
    public static final int CAMERA_ZOOM_SWITCH_DEFAULT_VALUE = 0;
    public static final int COMBINE_KEY_SWITCH_DEFAULT_VALUE = 0;
    public static final int GALLERY_SUPPORT_SWITCH_DEFAULT_VALUE = 0;
    public static final int GAODE_MAP_SUPPORT_SWITCH_DEFAULT_VALUE = 0;
    private static final String KEY_NAVBAR_TRIGGER_MODE_BACKUP = "perspective_switch_navbar_trigger_mode_backup";
    public static final int OFF = 0;
    public static final int ON = 1;
    public static final int SWITCH_DEFAULT_VALUE = 0;
    private static final String TAG = "PerspectiveSettingUtils";
    public static final int TASK_FOCUS_STYLE_SCALED_DEFAULT_VALUE = 0;

    public static void backupRestoreNavbarTriggerMode(Context r0, boolean r1) {
    }

    public PerspectiveSettingUtils() {
    }

    public static boolean isSettingEnable(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "perspective_switch", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isSqueezeSmartAndPowerkeyEnabled(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "squeeze_with_power_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isCombineKeySwitchEnable(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "perspective_combine_key_switch", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isCameraZoomEnable(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "perspective_camera_zoom_switch", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isTaskFocusStyleScaled(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "perspective_task_focus_style_switch", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isGalleryPerspectiveSupport(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "perspective_gallery_support_switch", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isGaodePerspectiveSupport(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "perspective_gaode_map_support_switch", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static void setSettingEnable(Context r2, boolean r3) {
        Settings.Global.putInt(r2.getApplicationContext().getContentResolver(), "perspective_switch", r3 ? 1 : 0);
        backupRestoreNavbarTriggerMode(r2, r3);
    }
}

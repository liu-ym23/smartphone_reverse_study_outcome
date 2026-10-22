package com.android.settings;

import android.util.SparseIntArray;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class Calibration {
    private static final SparseIntArray COLOR_MODES = null;
    private static final int EYES_PROTECTION_CLOSE_VALUE = 18;
    private static final int EYES_PROTECTION_DEFAULT_VALUE = 10;
    private static final int EYES_PROTECTION_FLAG = 100;
    private static final int FACEID_DISABLED = 110;
    private static final int FACEID_ENABLED = 111;
    private static final int FORCE_TOUCH_OFF = 270;
    private static final int FORCE_TOUCH_ON = 271;
    private static final int GESTURE_NAVBAR_MODE_OFF = 280;
    private static final int GESTURE_NAVBAR_MODE_ON = 281;
    private static final int GLOVE_OFF = 260;
    private static final int GLOVE_ON = 261;
    private static final int NON_ZERO = 1;
    private static final int REDUCE_SCREEN_STROBE_CLOSE_VALUE = 21;
    private static final int REDUCE_SCREEN_STROBE_OPEN_VALUE = 20;
    private static final String TAG = "Calibration";
    private static final int TOUCHSCREEN_SET_FOD_DISABLE = 264;
    private static final int TOUCHSCREEN_SET_FOD_ENABLE = 265;
    private static final int TOUCHSCREEN_SET_GESTURE_DISABLE = 262;
    private static final int TOUCHSCREEN_SET_GESTURE_ENABLE = 263;
    private static final int TOUCHSCREEN_SET_ICON_DISABLE = 268;
    private static final int TOUCHSCREEN_SET_ICON_ENABLE = 269;

    public static void setColorTemperature(int r0, int r1) {
    }

    public Calibration() {
    }

    static {
        SparseIntArray r0 = new SparseIntArray();
        COLOR_MODES = r0;
        r0.put(0, 200);
        r0.put(1, 201);
        r0.put(2, 202);
    }

    public static void setColorTemperatureValue(int r0, int r1) {
        AdaptUtils.setColorTemperatureValue(r0, r1);
    }

    public static void setEyesProtectionEnable(boolean r2) {
        OLog.d(TAG, "setEyesProtectionEnable " + r2);
        if (r2 == false) goto L5;
        int r3 = 10;
    L6:
        setColorTemperatureValue(r3, 100);
        return;
    L5:
        r3 = 18;
        goto L6
    }

    public static void setFaceRecognitionUnlockScreenEnable(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 111;
    L5:
        setColorTemperatureValue(r2, 100);
        return;
    L4:
        r2 = 110;
        goto L5
    }

    public static void setGloveMode(boolean r2) {
        OLog.d(TAG, "setGloveMode " + r2);
        if (r2 == false) goto L5;
        int r3 = 261;
    L6:
        setColorTemperatureValue(r3, 1);
        return;
    L5:
        r3 = 260;
        goto L6
    }

    public static void setForceTouchEnable(boolean r2) {
        OLog.d(TAG, "setForceTouchEnable " + r2);
        if (r2 == false) goto L5;
        int r3 = 271;
    L6:
        setColorTemperatureValue(r3, 1);
        return;
    L5:
        r3 = 270;
        goto L6
    }

    public static void setGestureNavBarModeEnable(boolean r2) {
        OLog.d(TAG, "setGestureNavBarModeEnabled " + r2);
        if (r2 == false) goto L5;
        int r3 = 281;
    L6:
        setColorTemperatureValue(r3, 1);
        return;
    L5:
        r3 = 280;
        goto L6
    }

    public static void setColorMode(int r2) {
        OLog.d(TAG, "setColorMode : " + r2);
        SparseIntArray r0 = COLOR_MODES;
        if (r0.indexOfKey(r2) >= 0) goto L5;
        r2 = 0;
    L5:
        setColorTemperatureValue(r0.valueAt(r2), 1);
    }

    public static void setReduceScreenStrobeEnable(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 20;
    L5:
        setColorTemperatureValue(r2, 100);
        return;
    L4:
        r2 = 21;
        goto L5
    }

    public static void setGestureMode(boolean r2) {
        OLog.d(TAG, "setGestureMode " + r2);
        if (r2 == false) goto L5;
        int r3 = 262;
    L6:
        setColorTemperatureValue(r3, 1);
        return;
    L5:
        r3 = 263;
        goto L6
    }

    public static void setFodMode(boolean r2) {
        OLog.d(TAG, "setFodMode " + r2);
        if (r2 == false) goto L5;
        int r3 = 264;
    L6:
        setColorTemperatureValue(r3, 1);
        return;
    L5:
        r3 = 265;
        goto L6
    }

    public static void setFingerprintIcon(boolean r2) {
        OLog.d(TAG, "setFingerprintIcon " + r2);
        if (r2 == false) goto L5;
        int r3 = 268;
    L6:
        setColorTemperatureValue(r3, 1);
        return;
    L5:
        r3 = 269;
        goto L6
    }
}

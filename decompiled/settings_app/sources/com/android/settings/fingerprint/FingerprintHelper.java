package com.android.settings.fingerprint;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import bytedanceos.util.DeviceType;
import com.android.settings.Calibration;
import com.android.settings.SettingsFeature;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintHelper {
    private static final int MAX_FINGERPRINT_PER_USER_IN_DELTA = 5;

    public FingerprintHelper() {
    }

    public static int getMaxFingerprintPerUser(Resources r3) {
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN, DeviceType.UNKNOWN}) == false) goto L7;
        return 5;
    L7:
        return r3.getInteger(R.integer.config_jobSchedulerInactivityIdleThresholdOnStablePower);
    }

    public static void updateGestureModeIfNeed(Context r0) {
        setGestureMode(shouldCloseGestureMode(r0));
    }

    private static void setGestureMode(boolean r1) {
        if (SettingsFeature.isSupportFrontFP() == true) goto L5;
        return;
    L5:
        Calibration.setGestureMode(r1);
    }

    private static boolean shouldCloseGestureMode(Context r4) {
        ContentResolver r5 = r4.getContentResolver();
        if (getGlobalSettingsValue(r5, "click_enable_screen_on") != 1) goto L5;
        boolean r0 = true;
    L7:
        if (SettingsFeature.isDarwin() == false) goto L11;
        return !r0;
    L11:
        if (getGlobalSettingsValue(r5, "use_fingerprint_when_screenoff") != 1) goto L13;
        boolean r6 = true;
    L14:
        if (r0 == true) goto L18;
        if (r6 == false) goto L17;
        return false;
    L17:
        return true;
    L18:
        return false;
    L13:
        r6 = false;
        goto L14
    L5:
        r0 = false;
        goto L7
    }

    private static int getGlobalSettingsValue(ContentResolver r0, String r1) {
        return Settings.Global.getInt(r0, r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static void updateFodModeIfNeed(Context r0) {
        setFodMode(shouldCloseFodMode(r0));
    }

    private static void setFodMode(boolean r1) {
        if (SettingsFeature.isSupportFrontFP() == true) goto L5;
        return;
    L5:
        Calibration.setFodMode(r1);
    }

    private static boolean shouldCloseFodMode(Context r1) {
        if (getGlobalSettingsValue(r1.getContentResolver(), "use_fingerprint_when_screenoff") != 1) goto L5;
        boolean r2 = true;
    L7:
        return !r2;
    L5:
        r2 = false;
        goto L7
    }

    public static void updateFingerprintIconIfNeed(Context r0) {
        setFingerprintIcon(shouldCloseFingerprintIcon(r0));
    }

    private static boolean shouldCloseFingerprintIcon(Context r1) {
        if (getGlobalSettingsValue(r1.getContentResolver(), "pickup_show_fp_icon") != 1) goto L5;
        boolean r2 = true;
    L7:
        return !r2;
    L5:
        r2 = false;
        goto L7
    }

    private static void setFingerprintIcon(boolean r1) {
        if (SettingsFeature.isDarwin() == true) goto L5;
        return;
    L5:
        Calibration.setFingerprintIcon(r1);
    }
}

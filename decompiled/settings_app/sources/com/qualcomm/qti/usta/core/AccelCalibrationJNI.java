package com.qualcomm.qti.usta.core;

import com.android.settings.AdaptConstants;

/* JADX INFO: loaded from: classes5.dex */
public class AccelCalibrationJNI {
    public static native String getAccelCalFromNative();

    public static native int prxCalibrateCT();

    public static native int prxCalibrateFar();

    public static native int prxCalibrateNear();

    public static native int prxCalibrateOnlyCT();

    public static native int prxGetCalibrateInfo(float[] r0, int r1);

    public static native int startCalibration();

    public static native void stopCalibration();

    public AccelCalibrationJNI() {
    }

    static {
        System.loadLibrary(AdaptConstants.SMT_SENSOR_CAL_LIB_NATIVE);
    }
}

package com.android.settings.devicecredential;

import com.obric.olog.OLog;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class BiometricFlagsReflectionUtils {
    private static final String FLAGS_CLASS_NAME = "android.hardware.biometrics.Flags";
    private static final String MANDATORY_BIOMETRICS_METHOD_NAME = "mandatoryBiometrics";
    private static final String PRIVATE_SPACE_BP_METHOD_NAME = "privateSpaceBp";
    private static final String TAG = "BiometricFlagsReflectionUtils";

    public BiometricFlagsReflectionUtils() {
    }

    public static boolean mandatoryBiometrics() {
        Method r2 = Class.forName(FLAGS_CLASS_NAME).getMethod(MANDATORY_BIOMETRICS_METHOD_NAME, new Class[0]);     // Catch: Exception -> L5 NoSuchMethodException -> L7 ClassNotFoundException -> L9
        r2.setAccessible(true);     // Catch: Exception -> L5 NoSuchMethodException -> L7 ClassNotFoundException -> L9
        return ((Boolean) r2.invoke(null, new Object[0])).booleanValue();
    L9:
        e = move-exception;
        OLog.e(TAG, "Flags class not found: " + e.getMessage());
    L11:
        return false;
    L7:
        e = move-exception;
        OLog.e(TAG, "Method mandatoryBiometrics not found: " + e.getMessage());
    L5:
        e = move-exception;
        OLog.e(TAG, "Failed to invoke mandatoryBiometrics: " + e.getMessage());
        goto L11
    }

    public static boolean privateSpaceBp() {
        Method r2 = Class.forName(FLAGS_CLASS_NAME).getMethod(PRIVATE_SPACE_BP_METHOD_NAME, new Class[0]);     // Catch: Exception -> L5 NoSuchMethodException -> L7 ClassNotFoundException -> L9
        r2.setAccessible(true);     // Catch: Exception -> L5 NoSuchMethodException -> L7 ClassNotFoundException -> L9
        return ((Boolean) r2.invoke(null, new Object[0])).booleanValue();
    L9:
        e = move-exception;
        OLog.e(TAG, "Flags class not found: " + e.getMessage());
    L11:
        return false;
    L7:
        e = move-exception;
        OLog.e(TAG, "Method privateSpaceBp not found: " + e.getMessage());
    L5:
        e = move-exception;
        OLog.e(TAG, "Failed to invoke privateSpaceBp: " + e.getMessage());
        goto L11
    }

    public static boolean isBiometricFlagsClassAvailable() {
        Class.forName(FLAGS_CLASS_NAME);     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        OLog.w(TAG, "android.hardware.biometrics.Flags class is not available");
        return false;
    }
}

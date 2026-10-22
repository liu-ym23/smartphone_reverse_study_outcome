package com.android.settings.utils;

import com.obric.olog.OLog;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class FlagsReflectionUtils {
    private static final String EXTEND_ECM_METHOD_NAME = "extendEcmToAllSettings";
    private static final String FLAGS_CLASS_NAME = "android.security.Flags";
    private static final String TAG = "FlagsReflectionUtils";

    public FlagsReflectionUtils() {
    }

    public static boolean extendEcmToAllSettings() {
        Method r2 = Class.forName(FLAGS_CLASS_NAME).getMethod(EXTEND_ECM_METHOD_NAME, new Class[0]);     // Catch: Exception -> L5 NoSuchMethodException -> L7 ClassNotFoundException -> L9
        r2.setAccessible(true);     // Catch: Exception -> L5 NoSuchMethodException -> L7 ClassNotFoundException -> L9
        return ((Boolean) r2.invoke(null, new Object[0])).booleanValue();
    L9:
        e = move-exception;
        OLog.e(TAG, "Flags class not found: " + e.getMessage());
    L11:
        return false;
    L7:
        e = move-exception;
        OLog.e(TAG, "Method extendEcmToAllSettings not found: " + e.getMessage());
    L5:
        e = move-exception;
        OLog.e(TAG, "Failed to invoke extendEcmToAllSettings: " + e.getMessage());
        goto L11
    }

    public static boolean aapmApi() {
        Method r2 = Class.forName(FLAGS_CLASS_NAME).getMethod("aapmApi", new Class[0]);     // Catch: Exception -> L5 NoSuchMethodException -> L7 ClassNotFoundException -> L9
        r2.setAccessible(true);     // Catch: Exception -> L5 NoSuchMethodException -> L7 ClassNotFoundException -> L9
        return ((Boolean) r2.invoke(null, new Object[0])).booleanValue();
    L9:
        e = move-exception;
        OLog.e(TAG, "Flags class not found: " + e.getMessage());
    L11:
        return false;
    L7:
        e = move-exception;
        OLog.e(TAG, "Method extendEcmToAllSettings not found: " + e.getMessage());
    L5:
        e = move-exception;
        OLog.e(TAG, "Failed to invoke extendEcmToAllSettings: " + e.getMessage());
        goto L11
    }

    public static boolean isFlagsClassAvailable() {
        Class.forName(FLAGS_CLASS_NAME);     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        OLog.w(TAG, "android.security.Flags class is not available");
        return false;
    }
}

package com.android.settingslib.widget.theme.flags;

import com.obric.olog.OLog;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class Flags {
    private static final String FLAGS_CLASS_NAME = "android.app.supervision.flags.Flags";
    private static final String TAG = "ThemeFlagsRef";

    public Flags() {
    }

    public static boolean isExpressiveDesignEnabled() {
        Method r2 = Class.forName(FLAGS_CLASS_NAME).getMethod("isExpressiveDesignEnabled", new Class[0]);     // Catch: Exception -> L5 NoSuchMethodException -> L7 ClassNotFoundException -> L9
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
}

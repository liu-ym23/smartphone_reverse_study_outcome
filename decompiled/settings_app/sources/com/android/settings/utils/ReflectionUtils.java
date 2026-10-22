package com.android.settings.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    public ReflectionUtils() {
    }

    public static boolean hasMethod(String r1, String r2, Class[] r3) {
        Class<?> r4 = Class.forName(r1);     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        r4.getMethod(r2, r3);     // Catch: Throwable -> L9
    L7:
        return true;
    L6:
        r4.getMethod(r2, new Class[0]);     // Catch: Throwable -> L9
        goto L7
    L11:
        return false;
    }

    public static Method getMethod(String r0, String r1, Class[] r2) {
        return Class.forName(r0).getDeclaredMethod(r1, r2);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Field getField(String r0, String r1) {
        return Class.forName(r0).getDeclaredField(r1);
    L4:
        return null;
    }
}

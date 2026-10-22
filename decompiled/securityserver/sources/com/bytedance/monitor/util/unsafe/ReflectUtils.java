package com.bytedance.monitor.util.unsafe;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ReflectUtils {
    private static ReflectUtils sInstance;

    private ReflectUtils() {
    }

    public static ReflectUtils getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new ReflectUtils();
    L6:
        return sInstance;
    }

    public Method getMethod(Class<?> r1, String r2, Class<?>... r3) {
        Method r0 = null;
        if (r3 == null) goto L7;
        r0 = r1.getDeclaredMethod(r2, r3);     // Catch: NoSuchMethodException -> L5
    L11:
    L10:
        return r0;
    L7:
        r0 = r1.getDeclaredMethod(r2, null);     // Catch: NoSuchMethodException -> L5
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public Object getUnsafe(Class<?> r4) {
        return invokeStaticMethod(getMethod(r4, "getUnsafe", new Class[0]), new Object[0]);
    }

    public Object invokeMethod(Method r1, Object r2, Object... r3) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.invoke(r2, r3);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public Object invokeStaticMethod(Method r2, Object... r3) {
        return invokeMethod(r2, null, r3);
    }
}

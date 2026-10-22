package com.bytedance.monitor.util.unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class UnsafeProxy {
    private static Object sUnsafe;
    private static Class sUnsafeClass;
    private static ReflectUtils sUtils;

    static {
        sUtils = ReflectUtils.getInstance();     // Catch: ClassNotFoundException -> L4
        Class<?> r0 = Class.forName("sun.misc.Unsafe");     // Catch: ClassNotFoundException -> L4
        sUnsafeClass = r0;     // Catch: ClassNotFoundException -> L4
        sUnsafe = sUtils.getUnsafe(r0);     // Catch: ClassNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public UnsafeProxy() {
    }

    public static long objectFieldOffset(Field r4) {
        Method r0 = sUtils.getMethod(sUnsafeClass, "objectFieldOffset", new Class[]{Field.class});
        Object r5 = sUtils.invokeMethod(r0, sUnsafe, new Object[]{r4});
        if (r5 != null) goto L6;
        return 0;
    L6:
        return ((Long) r5).longValue();
    }

    public static long putObject(Object r4, long r5, Object r7) {
        Method r0 = sUtils.getMethod(sUnsafeClass, "putObject", new Class[]{Object.class, Long.TYPE, Object.class});
        Object r6 = sUtils.invokeMethod(r0, sUnsafe, new Object[]{r4, Long.valueOf(r5), r7});
        if (r6 != null) goto L6;
        return 0;
    L6:
        return ((Long) r6).longValue();
    }
}

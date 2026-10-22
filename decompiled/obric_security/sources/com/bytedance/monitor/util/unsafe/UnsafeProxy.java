package com.bytedance.monitor.util.unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class UnsafeProxy {
    private static Object sUnsafe;
    private static Class sUnsafeClass;
    private static ReflectUtils sUtils;

    public UnsafeProxy() {
    }

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

    public static long objectFieldOffset(Field r6) {
        Method r0 = sUtils.getMethod(sUnsafeClass, "objectFieldOffset", new Class[]{Field.class});
        Object r7 = sUtils.invokeMethod(r0, sUnsafe, new Object[]{r6});
        if (r7 != null) goto L6;
        return 0;
    L6:
        return ((Long) r7).longValue();
    }

    public static long putObject(Object r8, long r9, Object r11) {
        Method r0 = sUtils.getMethod(sUnsafeClass, "putObject", new Class[]{Object.class, Long.TYPE, Object.class});
        Object r10 = sUtils.invokeMethod(r0, sUnsafe, new Object[]{r8, Long.valueOf(r9), r11});
        if (r10 != null) goto L6;
        return 0;
    L6:
        return ((Long) r10).longValue();
    }
}

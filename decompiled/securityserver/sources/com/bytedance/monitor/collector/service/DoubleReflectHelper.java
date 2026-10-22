package com.bytedance.monitor.collector.service;

import com.bytedance.monitor.util.FieldUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class DoubleReflectHelper {
    private DoubleReflectHelper() {
    }

    public static Field getField(Class<?> r1, String r2) {
        if (isAndroidPHigher() == false) goto L9;
        return getFieldInner(r1, r2);
    L6:
        return null;
    L9:
        return FieldUtils.getField(r1, r2);
    }

    public static Field getFieldInner(Class<?> r3, String r4) {
        Field r5 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r3, new Object[]{r4});     // Catch: Throwable -> L4
        r5.setAccessible(true);     // Catch: Throwable -> L4
        return r5;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Method getMethodInner(Class<?> r4, String r5, Class<?>... r6) {
        Method r7 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r4, new Object[]{r5, r6});     // Catch: Throwable -> L4
        r7.setAccessible(true);     // Catch: Throwable -> L4
        return r7;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static boolean isAndroidPHigher() {
        return true;
    }

    public static Object readField(Object r1, String r2) {
        return getField(r1.getClass(), r2).get(r1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}

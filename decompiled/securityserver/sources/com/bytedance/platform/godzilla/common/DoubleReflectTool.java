package com.bytedance.platform.godzilla.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class DoubleReflectTool {
    private DoubleReflectTool() {
    }

    public static Field getField(Class<?> r3, String r4) {
        Field r5 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r3, new Object[]{r4});     // Catch: Throwable -> L4
        r5.setAccessible(true);     // Catch: Throwable -> L4
        return r5;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Method getMethod(Class<?> r4, String r5, Class<?>... r6) {
        Method r7 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r4, new Object[]{r5, r6});     // Catch: Throwable -> L4
        r7.setAccessible(true);     // Catch: Throwable -> L4
        return r7;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}

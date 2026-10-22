package com.loc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class w4 {
    private static Object a(Class<?> r0, String r1, Object[] r2, Class<?>[] r3) {
        Method r4 = r0.getDeclaredMethod(r1, r3);
        if (r4.isAccessible() == true) goto L6;
        r4.setAccessible(true);
    L6:
        return r4.invoke(null, r2);
    }

    public static Object b(Object r5, Class<?> r6, String r7, Object... r8) {
        Class<?>[] r0 = new Class[r8.length];
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        r0[r2] = r8[r2].getClass();
        if (r0[r2] != Integer.class) goto L8;
        r0[r2] = Integer.TYPE;
    L8:
        if (r0[r2] != Boolean.class) goto L11;
        r0[r2] = Boolean.TYPE;
    L11:
        if (r0[r2] != Double.class) goto L13;
        r0[r2] = Double.TYPE;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        Method r9 = r6.getDeclaredMethod(r7, r0);
        if (r9.isAccessible() == true) goto L26;
        r9.setAccessible(true);
    L26:
        return r9.invoke(r5, r8);
    L20:
        th = move-exception;
        if ((th instanceof InvocationTargetException) == false) goto L33;
        s4.h(th.getTargetException(), "Reflect", "invokeMethod ".concat(String.valueOf(r7)));     // Catch: Throwable -> L25
        return null;
    L33:
        return null;
    L35:
        return null;
    }

    public static Object c(Object r1, String r2, Object... r3) {
        return b(r1, r1.getClass(), r2, r3);
    L4:
        return null;
    }

    public static Object d(String r1, String r2) {
        Class<?> r3 = Class.forName(r1);
        Field r4 = r3.getField(r2);
        r4.setAccessible(true);
        return r4.get(r3);
    }

    public static Object e(String r0, String r1, Object[] r2, Class<?>[] r3) {
        return a(Class.forName(r0), r1, r2, r3);
    }

    public static int f(Object r0, String r1, Object... r2) {
        return ((Integer) c(r0, r1, r2)).intValue();
    }

    public static int g(String r0, String r1) {
        return ((Integer) d(r0, r1)).intValue();
    }
}

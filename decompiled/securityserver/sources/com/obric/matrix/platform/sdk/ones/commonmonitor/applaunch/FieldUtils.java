package com.obric.matrix.platform.sdk.ones.commonmonitor.applaunch;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class FieldUtils {
    private static final Map<String, Field> FIELD_CACHE = null;

    static {
        FIELD_CACHE = new HashMap();
    }

    private FieldUtils() {
    }

    public static Field getField(Class<?> r4, String r5) {
        String r0 = getKey(r4, r5);
        Map<String, Field> r1 = FIELD_CACHE;
        monitor-enter(r1);
        Field r2 = r1.get(r0);     // Catch: Throwable -> L27
        monitor-exit(r1);     // Catch: Throwable -> L27
        if (r2 != null) goto L9;
    L12:
        if (r4 == null) goto L25;
        Field r3 = r4.getDeclaredField(r5);     // Catch: NoSuchFieldException -> L24
        if (r3.isAccessible() == true) goto L16;
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L24
    L16:
        Map<String, Field> r6 = FIELD_CACHE;     // Catch: NoSuchFieldException -> L24
        monitor-enter(r6);     // Catch: NoSuchFieldException -> L24
        r6.put(r0, r3);     // Catch: Throwable -> L21
        monitor-exit(r6);     // Catch: Throwable -> L21
    L20:
        return r3;
    L21:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L24
    L24:
        r4 = r4.getSuperclass();
        goto L12
    L25:
        return null;
    L9:
        if (r2.isAccessible() == true) goto L11;
        r2.setAccessible(true);
    L11:
        return r2;
    L27:
        th = move-exception;
        throw th;
    }

    private static String getKey(Class<?> r1, String r2) {
        return r1.toString() + "#" + r2;
    }

    public static Object readField(Field r1, Object r2) {
        if (r1.isAccessible() == true) goto L6;
        r1.setAccessible(true);
    L6:
        return r1.get(r2);
    }

    public static Object readStaticField(Field r1) {
        return readField(r1, null);
    }

    public static void writeField(Field r1, Object r2, Object r3) {
        if (r1.isAccessible() == true) goto L5;
        r1.setAccessible(true);
    L5:
        r1.set(r2, r3);
    }

    public static void writeStaticField(Field r1, Object r2) {
        writeField(r1, null, r2);
    }

    public static Object readStaticField(Class<?> r0, String r1) {
        Field r2 = getField(r0, r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return readStaticField(r2);
    }

    public static void writeStaticField(Class<?> r0, String r1, Object r2) {
        Field r3 = getField(r0, r1);
        if (r3 == null) goto L6;
        writeStaticField(r3, r2);
        return;
    }

    public static Object readField(Object r1, String r2) {
        Field r3 = getField(r1.getClass(), r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return readField(r3, r1);
    }

    public static void writeField(Object r1, String r2, Object r3) {
        Field r4 = getField(r1.getClass(), r2);
        if (r4 == null) goto L6;
        writeField(r4, r1, r3);
        return;
    }
}

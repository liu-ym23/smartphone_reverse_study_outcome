package com.bytedance.platform.godzilla.utils;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class FieldUtils {
    private static final Map<String, Field> FIELD_CACHE = null;

    static {
        FIELD_CACHE = new HashMap();
    }

    private FieldUtils() {
    }

    private static String getKey(Class<?> r2, String r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.toString()).append("#").append(r3);
        return r0.toString();
    }

    public static Field getField(Class<?> r4, String r5) {
        Class<?> r6 = (Class) Preconditions.checkNotNull(r4, "The class must not be null");
        Preconditions.checkTrue(!TextUtils.isEmpty(r5), "The field name must not be blank");
        String r0 = getKey(r6, r5);
        Map<String, Field> r2 = FIELD_CACHE;
        monitor-enter(r2);
        Field r3 = r2.get(r0);     // Catch: Throwable -> L36
        monitor-exit(r2);     // Catch: Throwable -> L36
        if (r3 != null) goto L8;
    L11:
        if (r6 == null) goto L34;
    L33:
        r6 = r6.getSuperclass();
        goto L11
    L13:
        if (OSUtil.isAndroidPHigher() == true) goto L15;
    L19:
        Field r7 = r6.getDeclaredField(r5);     // Catch: NoSuchFieldException -> L33
    L20:
        if (r7 == null) goto L32;
        if (r7.isAccessible() == true) goto L24;
        r7.setAccessible(true);     // Catch: NoSuchFieldException -> L33
    L24:
        Map<String, Field> r8 = FIELD_CACHE;     // Catch: NoSuchFieldException -> L33
        monitor-enter(r8);     // Catch: NoSuchFieldException -> L33
        r8.put(r0, r7);     // Catch: Throwable -> L29
        monitor-exit(r8);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L33
    L32:
        return r7;
    L15:
        if (HackHelper.getInstance() == null) goto L19;
        r7 = HackHelper.getInstance().getField(r6, r5);     // Catch: NoSuchFieldException -> L33
        if (r7 != null) goto L20;
        r7 = r6.getDeclaredField(r5);     // Catch: NoSuchFieldException -> L33
        goto L20
    L34:
        return null;
    L8:
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3;
    L36:
        th = move-exception;
        throw th;
    }

    public static Object readField(Field r3, Object r4) throws IllegalAccessException {
        if (r3 == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "The field must not be null");
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3.get(r4);
    L5:
        r1 = false;
        goto L6
    }

    public static void writeField(Field r1, Object r2, Object r3) throws IllegalAccessException {
        Field r4 = (Field) Preconditions.checkNotNull(r1, "The field must not be null");
        if (r4.isAccessible() == true) goto L5;
        r4.setAccessible(true);
    L5:
        r4.set(r2, r3);
    }

    public static Object readField(Object r1, String r2) throws IllegalAccessException {
        Object r3 = Preconditions.checkNotNull(r1, "target object must not be null");
        Field r4 = getField(r3.getClass(), r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return readField(r4, r3);
    }

    public static void writeField(Object r1, String r2, Object r3) throws IllegalAccessException {
        Object r4 = Preconditions.checkNotNull(r1, "target object must not be null");
        Field r5 = getField(r4.getClass(), r2);
        if (r5 == null) goto L6;
        writeField(r5, r4, r3);
        return;
    }

    public static Object readStaticField(Field r1) throws IllegalAccessException {
        return readField((Field) Preconditions.checkNotNull(r1, "The field must not be null"), null);
    }

    public static Object readStaticField(Class<?> r0, String r1) throws IllegalAccessException {
        Field r2 = getField(r0, r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return readStaticField(r2);
    }

    public static void writeStaticField(Field r1, Object r2) throws IllegalAccessException {
        writeField((Field) Preconditions.checkNotNull(r1, "The field must not be null"), null, r2);
    }

    public static void writeStaticField(Class<?> r0, String r1, Object r2) throws IllegalAccessException {
        Field r3 = getField(r0, r1);
        if (r3 == null) goto L6;
        writeStaticField(r3, r2);
        return;
    }
}

package com.bytedance.feedbackerlib.m;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Field> f4258a = null;

    static {
        f4258a = new HashMap();
    }

    public static Field a(Class<?> r4, String r5) {
        m.b(r4, "The class must not be null");
        m.c(!TextUtils.isEmpty(r5), "The field name must not be blank");
        String r0 = b(r4, r5);
        Map<String, Field> r2 = f4258a;
        monitor-enter(r2);
        Field r3 = r2.get(r0);     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        if (r3 != null) goto L8;
    L11:
        if (r4 == null) goto L24;
        Field r6 = r4.getDeclaredField(r5);     // Catch: NoSuchFieldException -> L23
        if (r6.isAccessible() == true) goto L15;
        r6.setAccessible(true);     // Catch: NoSuchFieldException -> L23
    L15:
        Map<String, Field> r7 = f4258a;     // Catch: NoSuchFieldException -> L23
        monitor-enter(r7);     // Catch: NoSuchFieldException -> L23
        r7.put(r0, r6);     // Catch: Throwable -> L20
        monitor-exit(r7);     // Catch: Throwable -> L20
    L19:
        return r6;
    L20:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L23
    L23:
        r4 = r4.getSuperclass();
        goto L11
    L24:
        return null;
    L8:
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3;
    L26:
        th = move-exception;
        throw th;
    }

    private static String b(Class<?> r1, String r2) {
        return r1.toString() + "#" + r2;
    }

    public static Object c(Object r1, String r2) {
        m.b(r1, "target object must not be null");
        Field r3 = a(r1.getClass(), r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return d(r3, r1);
    }

    public static Object d(Field r3, Object r4) {
        if (r3 == null) goto L5;
        boolean r1 = true;
    L6:
        m.a(r1, "The field must not be null");
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3.get(r4);
    L5:
        r1 = false;
        goto L6
    }

    public static void e(Object r1, String r2, Object r3) {
        m.b(r1, "target object must not be null");
        Field r4 = a(r1.getClass(), r2);
        if (r4 == null) goto L6;
        f(r4, r1, r3);
        return;
    }

    public static void f(Field r1, Object r2, Object r3) {
        m.b(r1, "The field must not be null");
        if (r1.isAccessible() == true) goto L5;
        r1.setAccessible(true);
    L5:
        r1.set(r2, r3);
    }
}

package com.bytedance.platform.godzilla.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class GUtils {
    public static final Class<?>[] EMPTY_CLASS_ARRAY = null;
    public static final Object[] EMPTY_OBJECT_ARRAY = null;
    private static final String TAG = "GUtils";

    static {
        EMPTY_OBJECT_ARRAY = new Object[0];
        EMPTY_CLASS_ARRAY = new Class[0];
    }

    private GUtils() {
    }

    public static boolean isSameLength(Object[] r1, Object[] r2) {
        if (r1 != null) goto L6;
        if (r2 == null) goto L6;
        if (r2.length <= 0) goto L6;
    L15:
        return false;
    L6:
        if (r2 != null) goto L10;
        if (r1 == null) goto L10;
        if (r1.length > 0) goto L15;
    L10:
        if (r1 == null) goto L16;
        if (r2 == null) goto L16;
        if (r1.length != r2.length) goto L15;
    L16:
        return true;
    }

    public static Class<?>[] toClass(Object... r3) {
        if (r3 == null) goto L15;
        if (r3.length == 0) goto L15;
        Class<?>[] r0 = new Class[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L13;
        Object r2 = r3[r1];
        if (r2 != null) goto L11;
        Class<?> r4 = null;
    L12:
        r0[r1] = r4;
        r1 = r1 + 1;
        goto L7
    L11:
        r4 = r2.getClass();
        goto L12
    L13:
        return r0;
    L15:
        return EMPTY_CLASS_ARRAY;
    }

    public static Class<?>[] nullToEmpty(Class<?>[] r1) {
        if (r1 == null) goto L7;
        if (r1.length == 0) goto L7;
        return r1;
    L7:
        return EMPTY_CLASS_ARRAY;
    }

    public static Object[] nullToEmpty(Object[] r1) {
        if (r1 == null) goto L7;
        if (r1.length == 0) goto L7;
        return r1;
    L7:
        return EMPTY_OBJECT_ARRAY;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        LinkedHashSet r0 = new LinkedHashSet();
        getAllInterfaces(r1, r0);
        return new ArrayList(r0);
    }

    private static void getAllInterfaces(Class<?> r5, HashSet<Class<?>> r6) {
    L2:
        if (r5 == null) goto L10;
        Class<?>[] r0 = r5.getInterfaces();
        int r1 = r0.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        Class<?> r3 = r0[r2];
        if (r6.add(r3) == false) goto L8;
        getAllInterfaces(r3, r6);
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        r5 = r5.getSuperclass();
        goto L2
    }
}

package com.bytedance.platform.godzilla.utils;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MethodUtils {
    private static final HashMap<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_MAP = null;
    private static Map<String, Method> sMethodCache;

    static {
        sMethodCache = new HashMap();
        HashMap<Class<?>, Class<?>> r0 = new HashMap();
        PRIMITIVE_TO_WRAPPER_MAP = r0;
        r0.put(Boolean.TYPE, Boolean.class);
        r0.put(Byte.TYPE, Byte.class);
        r0.put(Character.TYPE, Character.class);
        r0.put(Short.TYPE, Short.class);
        r0.put(Integer.TYPE, Integer.class);
        r0.put(Long.TYPE, Long.class);
        r0.put(Double.TYPE, Double.class);
        r0.put(Float.TYPE, Float.class);
        r0.put(Void.TYPE, Void.class);
    }

    private MethodUtils() {
    }

    private static String getCachedKey(Class<?> r3, String r4, Class... r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.toString()).append("#").append(r4);
        if (r5 != null) goto L5;
    L9:
        r0.append(Void.class.toString());
    L11:
        return r0.toString();
    L5:
        if (r5.length <= 0) goto L9;
        int r6 = r5.length;
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L11;
        r0.append(r5[r7].toString()).append("#");
        r7 = r7 + 1;
        goto L7
    }

    public static Method getAccessibleMethod(Class<?> r13, String r14, Class... r15) {
        Preconditions.checkNotNull(r13, "The class must not be null");
        Preconditions.checkTrue(!TextUtils.isEmpty(r14), "The method name must not be blank");
        String r0 = getCachedKey(r13, r14, r15);
        Map<String, Method> r2 = sMethodCache;
        monitor-enter(r2);
        Method r3 = sMethodCache.get(r0);     // Catch: Throwable -> L55
        monitor-exit(r2);     // Catch: Throwable -> L55
        if (r3 != null) goto L8;
    L11:
        if (r13 == null) goto L53;
        if (OSUtil.isAndroidPHigher() == true) goto L15;
    L19:
        r3 = r13.getDeclaredMethod(r14, r15);     // Catch: NoSuchMethodException -> L58
        goto L20
    L15:
        if (HackHelper.getInstance() == null) goto L19;
        r3 = HackHelper.getInstance().getMethod(r13, r14, r15);     // Catch: NoSuchMethodException -> L58
        if (r3 != null) goto L20;
        r3 = r13.getDeclaredMethod(r14, r15);     // Catch: NoSuchMethodException -> L58
    L20:
        if (r3 != null) goto L43;
        Method[] r4 = r13.getDeclaredMethods();
        if (r4 == null) goto L43;
        int r5 = r4.length;
        int r6 = 0;
    L24:
        if (r6 >= r5) goto L43;
        Method r7 = r4[r6];
        if (r7 == null) goto L42;
        if (TextUtils.equals(r7.getName(), r14) == false) goto L42;
        Class<?>[] r8 = r7.getParameterTypes();
        if (r15 == null) goto L42;
        if (r15.length != r8.length) goto L42;
        boolean r10 = true;
        int r9 = 0;
    L35:
        if (r9 >= r15.length) goto L40;
        if (isAssignableFrom(r15[r9], r8[r9]) == true) goto L39;
        r10 = false;
    L39:
        r9 = r9 + 1;
        goto L35
    L40:
        if (r10 == false) goto L42;
        r3 = r7;
    L42:
        r6 = r6 + 1;
    L43:
        if (r3 != null) goto L44;
        r13 = r13.getSuperclass();
        goto L11
    L44:
        r3.setAccessible(true);
        Map<String, Method> r11 = sMethodCache;
        monitor-enter(r11);
        sMethodCache.put(r0, r3);     // Catch: Throwable -> L49
        monitor-exit(r11);     // Catch: Throwable -> L49
        return r3;
    L49:
        th = move-exception;
        throw th;
    L53:
        return null;
    L8:
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3;
    L55:
        th = move-exception;
        throw th;
    }

    public static boolean isAssignableFrom(Class<?> r1, Class<?> r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r1 != null) goto L9;
        return !r2.isPrimitive();
    L9:
        if (r1.isPrimitive() == false) goto L14;
        if (r2.isPrimitive() == true) goto L14;
        r1 = PRIMITIVE_TO_WRAPPER_MAP.get(r1);
    L14:
        if (r2.isPrimitive() == false) goto L19;
        if (r1.isPrimitive() == true) goto L19;
        r2 = PRIMITIVE_TO_WRAPPER_MAP.get(r2);
    L19:
        return r2.isAssignableFrom(r1);
    }

    private static Object invokeStaticMethod(Class r0, String r1, Object[] r2, Class<?>[] r3) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] r4 = GUtils.nullToEmpty(r3);
        Object[] r5 = GUtils.nullToEmpty(r2);
        Method r6 = getAccessibleMethod(r0, r1, r4);
        if (r6 != null) goto L5;
        return null;
    L5:
        return r6.invoke(null, r5);
    }

    public static Object invokeStaticMethod(Class r1, String r2, Object... r3) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] r4 = GUtils.nullToEmpty(r3);
        return invokeStaticMethod(r1, r2, r4, GUtils.toClass(r4));
    }
}

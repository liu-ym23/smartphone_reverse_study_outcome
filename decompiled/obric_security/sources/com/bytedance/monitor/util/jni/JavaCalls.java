package com.bytedance.monitor.util.jni;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class JavaCalls {
    private static final String LOG_TAG = "JavaCalls";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP = null;

    public static class JavaParam<T> {
        public final Class<? extends T> clazz;
        public final T obj;

        public JavaParam(Class<? extends T> r1, T r2) {
            this.clazz = r1;
            this.obj = r2;
        }
    }

    public JavaCalls() {
    }

    static {
        HashMap r0 = new HashMap();
        PRIMITIVE_MAP = r0;
        r0.put(Boolean.class, Boolean.TYPE);
        r0.put(Byte.class, Byte.TYPE);
        r0.put(Character.class, Character.TYPE);
        r0.put(Short.class, Short.TYPE);
        r0.put(Integer.class, Integer.TYPE);
        r0.put(Float.class, Float.TYPE);
        r0.put(Long.class, Long.TYPE);
        r0.put(Double.class, Double.TYPE);
        r0.put(Boolean.TYPE, Boolean.TYPE);
        r0.put(Byte.TYPE, Byte.TYPE);
        r0.put(Character.TYPE, Character.TYPE);
        r0.put(Short.TYPE, Short.TYPE);
        r0.put(Integer.TYPE, Integer.TYPE);
        r0.put(Float.TYPE, Float.TYPE);
        r0.put(Long.TYPE, Long.TYPE);
        r0.put(Double.TYPE, Double.TYPE);
    }

    public static <T> T getField(Object r0, String r1) {
        return (T) getFieldOrThrow(r0, r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static <T> T getFieldOrThrow(Object r3, String r4) throws NoSuchFieldException, IllegalAccessException {
        Class<?> r0 = r3.getClass();
        Field r1 = null;
    L4:
        if (r1 != null) goto L12;
        r1 = r0.getDeclaredField(r4);     // Catch: NoSuchFieldException -> L7
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L8:
        if (r0 != null) goto L4;
        throw new NoSuchFieldException();
    L7:
        r0 = r0.getSuperclass();
        goto L8
    L12:
        r1.setAccessible(true);
        return (T) r1.get(r3);
    }

    public static void setField(Object r0, String r1, Object r2) {
        setFieldOrThrow(r0, r1, r2);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
    L12:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setFieldOrThrow(Object r2, String r3, Object r4) throws NoSuchFieldException, IllegalAccessException {
        Class<?> r0 = r2.getClass();
        Field r1 = null;
    L3:
        if (r1 != null) goto L11;
        r1 = r0.getDeclaredField(r3);     // Catch: NoSuchFieldException -> L6
    L7:
        if (r0 != null) goto L3;
        throw new NoSuchFieldException();
    L6:
        r0 = r0.getSuperclass();
        goto L7
    L11:
        r1.setAccessible(true);
        r1.set(r2, r4);
    }

    public static <T> T callMethod(Object r2, String r3, Object... r4) {
        return (T) callMethodOrThrow(r2, r3, r4);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Meet exception when call Method '" + r3 + "' in " + r2, e);
        return null;
    }

    public static <T> T callMethodOrThrow(Object r2, String r3, Object... r4) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return (T) getDeclaredMethod(r2.getClass(), r3, getParameterTypes(r4)).invoke(r2, getParameters(r4));
    }

    public static <T> T callStaticMethod(String r2, String r3, Object... r4) {
        return (T) callStaticMethodOrThrow(Class.forName(r2), r3, r4);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Meet exception when call Method '" + r3 + "' in " + r2, e);
        return null;
    }

    private static Method getDeclaredMethod(Class<?> r1, String r2, Class<?>... r3) throws NoSuchMethodException, SecurityException {
        Method r0 = findMethodByName(r1.getDeclaredMethods(), r2, r3);
        if (r0 == null) goto L5;
        r0.setAccessible(true);
        return r0;
    L5:
        if (r1.getSuperclass() == null) goto L9;
        return getDeclaredMethod(r1.getSuperclass(), r2, r3);
    L9:
        throw new NoSuchMethodException();
    }

    private static Method findMethodByName(Method[] r4, String r5, Class<?>[] r6) {
        if (r5 == null) goto L14;
        int r0 = r4.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L11;
        Method r2 = r4[r1];
        if (r2.getName().equals(r5) == false) goto L10;
        if (compareClassLists(r2.getParameterTypes(), r6) == false) goto L10;
        return r2;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return null;
    L14:
        throw new NullPointerException("Method name must not be null.");
    }

    private static boolean compareClassLists(Class<?>[] r6, Class<?>[] r7) {
        if (r6 != null) goto L10;
        if (r7 != null) goto L6;
        return true;
    L6:
        if (r7.length != 0) goto L9;
        return true;
    L9:
        return false;
    L10:
        if (r7 != null) goto L17;
        if (r6.length != 0) goto L15;
        return true;
    L15:
        return false;
    L17:
        if (r6.length == r7.length) goto L19;
        return false;
    L19:
        int r2 = 0;
    L21:
        if (r2 >= r6.length) goto L30;
        if (r6[r2].isAssignableFrom(r7[r2]) == true) goto L29;
        Map<Class<?>, Class<?>> r3 = PRIMITIVE_MAP;
        if (r3.containsKey(r6[r2]) == false) goto L28;
        if (r3.get(r6[r2]).equals(r3.get(r7[r2])) == true) goto L29;
    L28:
        return false;
    L29:
        r2 = r2 + 1;
        goto L21
    L30:
        return true;
    }

    public static <T> T callStaticMethodOrThrow(String r1, String r2, Object... r3) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        return (T) getDeclaredMethod(Class.forName(r1), r2, getParameterTypes(r3)).invoke(null, getParameters(r3));
    }

    public static <T> T callStaticMethodOrThrow(Class<?> r1, String r2, Object... r3) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return (T) getDeclaredMethod(r1, r2, getParameterTypes(r3)).invoke(null, getParameters(r3));
    }

    public static <T> T newInstance(Class<?> r2, Object... r3) {
        return (T) newInstanceOrThrow(r2, r3);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Meet exception when make instance as a " + r2.getSimpleName(), e);
        return null;
    }

    public static <T> T newEmptyInstance(Class<?> r3) {
        return (T) newEmptyInstanceOrThrow(r3);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Meet exception when make instance as a " + r3.getSimpleName(), e);
        return null;
    }

    public static <T> T newEmptyInstanceOrThrow(Class<?> r4) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Constructor<?>[] r0 = r4.getDeclaredConstructors();
        if (r0 == null) goto L20;
        if (r0.length == 0) goto L20;
        int r5 = 0;
        Constructor<?> r1 = r0[0];
        r1.setAccessible(true);
        Class<?>[] r2 = r1.getParameterTypes();
        if (r2 == null) goto L18;
        if (r2.length == 0) goto L18;
        Object[] r3 = new Object[r2.length];
    L13:
        if (r5 >= r2.length) goto L16;
        r3[r5] = getDefaultValue(r2[r5]);
        r5 = r5 + 1;
        goto L13
    L16:
        return (T) r1.newInstance(r3);
    L18:
        return (T) r1.newInstance(new Object[0]);
    L20:
        throw new IllegalArgumentException("Can't get even one available constructor for " + r4);
    }

    private static Object getDefaultValue(Class<?> r2) {
        if (Integer.TYPE.equals(r2) == true) goto L44;
        if (Integer.class.equals(r2) == true) goto L44;
        if (Byte.TYPE.equals(r2) == true) goto L44;
        if (Byte.class.equals(r2) == true) goto L44;
        if (Short.TYPE.equals(r2) == true) goto L44;
        if (Short.class.equals(r2) == true) goto L44;
        if (Long.TYPE.equals(r2) == true) goto L44;
        if (Long.class.equals(r2) == true) goto L44;
        if (Double.TYPE.equals(r2) == true) goto L44;
        if (Double.class.equals(r2) == true) goto L44;
        if (Float.TYPE.equals(r2) == true) goto L44;
        if (Float.class.equals(r2) == true) goto L44;
        if (Boolean.TYPE.equals(r2) == true) goto L42;
        if (Boolean.class.equals(r2) == true) goto L42;
        if (Character.TYPE.equals(r2) == true) goto L40;
        if (Character.class.equals(r2) == true) goto L40;
        return null;
    L40:
        return (char) 0;
    L42:
        return false;
    L44:
        return 0;
    }

    public static <T> T newInstanceOrThrow(Class<?> r1, Object... r2) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return (T) r1.getConstructor(getParameterTypes(r2)).newInstance(getParameters(r2));
    }

    public static Object newInstance(String r2, Object... r3) {
        return newInstanceOrThrow(r2, r3);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Meet exception when make instance as a " + r2, e);
        return null;
    }

    public static Object newInstanceOrThrow(String r0, Object... r1) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        return newInstanceOrThrow(Class.forName(r0), getParameters(r1));
    }

    private static Class<?>[] getParameterTypes(Object... r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.length <= 0) goto L25;
        Class<?>[] r1 = new Class[r5.length];
        int r2 = 0;
    L8:
        if (r2 >= r5.length) goto L20;
        Object r3 = r5[r2];
        if (r3 != null) goto L12;
    L14:
        if (r3 != null) goto L16;
        Class<?> r4 = null;
    L17:
        r1[r2] = r4;
    L18:
        r2 = r2 + 1;
        goto L8
    L16:
        r4 = r3.getClass();
        goto L17
    L12:
        if ((r3 instanceof JavaParam) == false) goto L14;
        r1[r2] = ((JavaParam) r3).clazz;
        goto L18
    L20:
        return r1;
    L25:
        return null;
    }

    private static Object[] getParameters(Object... r4) {
        if (r4 != null) goto L4;
    L15:
        return null;
    L4:
        if (r4.length <= 0) goto L15;
        Object[] r0 = new Object[r4.length];
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L20;
        Object r2 = r4[r1];
        if (r2 != null) goto L11;
    L13:
        r0[r1] = r2;
    L14:
        r1 = r1 + 1;
        goto L7
    L11:
        if ((r2 instanceof JavaParam) == false) goto L13;
        r0[r1] = ((JavaParam) r2).obj;
        goto L14
    L20:
        return r0;
    }
}

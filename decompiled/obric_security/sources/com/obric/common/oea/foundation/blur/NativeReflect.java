package com.obric.common.oea.foundation.blur;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class NativeReflect {
    private static final NativeReflect instance = null;

    public native Constructor getDeclaredConstructorNative(Class<?> r1, Class<?>[] r2);

    public native Field getDeclaredFieldNative(Class<?> r1, String r2);

    public native Method getDeclaredMethodNative(Class<?> r1, String r2, Class<?>[] r3);

    static {
        instance = new NativeReflect();
    }

    private NativeReflect() {
    }

    public static NativeReflect getInstance() {
        return instance;
    }

    public static Method getDeclaredMethod(Class<?> r0, String r1, Class<?>[] r2) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return r0.getDeclaredMethod(r1, r2);
    }

    public static Field getDeclaredField(Class<?> r0, String r1) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        return r0.getDeclaredField(r1);
    }

    public static Constructor getDeclaredConstructor(Class<?> r0, Class<?>[] r1) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return r0.getDeclaredConstructor(r1);
    }
}

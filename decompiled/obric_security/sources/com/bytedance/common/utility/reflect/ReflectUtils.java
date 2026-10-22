package com.bytedance.common.utility.reflect;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    private ReflectUtils() {
    }

    public static Method getMethod(Class<?> r0, String r1, Class<?>[] r2) {
        return com.bytedance.android.standard.tools.reflect.ReflectUtils.getMethod(r0, r1, r2);
    }

    public static Object invokeMethod(Class<?> r0, String r1, Object... r2) {
        return com.bytedance.android.standard.tools.reflect.ReflectUtils.invokeMethod(r0, r1, r2);
    }

    public static Object invokeMethod(Class<?> r0, String r1, Class<?>[] r2, Object[] r3, Object... r4) {
        return com.bytedance.android.standard.tools.reflect.ReflectUtils.invokeMethod(r0, r1, r2, r3, r4);
    }

    public static Object getFiledValue(Object r0, Class<?> r1) {
        return com.bytedance.android.standard.tools.reflect.ReflectUtils.getFiledValue(r0, r1);
    }
}

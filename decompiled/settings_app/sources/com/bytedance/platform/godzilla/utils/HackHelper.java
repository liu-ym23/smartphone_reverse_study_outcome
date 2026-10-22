package com.bytedance.platform.godzilla.utils;

import com.bytedance.platform.godzilla.common.IReflectHackHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class HackHelper {
    private static IReflectHackHelper sInstance;

    private HackHelper() {
    }

    public static void init(IReflectHackHelper r0) {
        sInstance = r0;
    }

    public static IReflectHackHelper getInstance() {
        return sInstance;
    }

    public static Field getField(Class<?> r1, String r2) {
        checkInit();
        return sInstance.getField(r1, r2);
    }

    public static Method getMethod(Class<?> r1, String r2, Class... r3) {
        checkInit();
        return sInstance.getMethod(r1, r2, r3);
    }

    private static void checkInit() {
        if (sInstance == null) goto L6;
        return;
    L6:
        throw new NullPointerException("please call Godzilla.init method pass in a IReflectHackHelper instance");
    }
}

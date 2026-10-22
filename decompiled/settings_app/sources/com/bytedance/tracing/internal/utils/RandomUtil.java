package com.bytedance.tracing.internal.utils;

import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class RandomUtil {
    private static final ThreadLocal<Random> threadLocal = null;

    public RandomUtil() {
    }

    public static long uniqueId() {
        long r2 = 0;
    L4:
        if (r2 != 0) goto L7;
        r2 = current().nextLong();
        goto L4
    L7:
        return Math.abs(r2);
    }

    static {
        threadLocal = new AnonymousClass1();
    }

    public static Random current() {
        return threadLocal.get();
    }
}

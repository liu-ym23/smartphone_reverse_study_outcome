package com.bytedance.feedbackerlib.model.e;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f4613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f4614b;

    static {
    }

    public static int a() {
        return f4613a;
    }

    public static int b() {
        return f4614b;
    }

    public static void c(int r0) {
    }

    public static void d(int r0) {
        f4613a = r0;
    }

    public static void e(int r0) {
        f4614b = r0;
    }
}

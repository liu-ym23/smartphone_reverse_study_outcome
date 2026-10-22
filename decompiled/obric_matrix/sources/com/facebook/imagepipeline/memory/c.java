package com.facebook.imagepipeline.memory;

import com.facebook.infer.annotation.ThreadSafe;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6679a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f6680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f6681c;

    static {
        f6679a = b();
        f6680b = 384;
    }

    public c() {
    }

    @ThreadSafe
    public static b a() {
        if (f6681c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6681c != null) goto L9;
        f6681c = new b(f6680b, f6679a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f6681c;
    }

    private static int b() {
        int r0 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (r0 <= 16777216) goto L7;
        return (r0 / 4) * 3;
    L7:
        return r0 / 2;
    }
}

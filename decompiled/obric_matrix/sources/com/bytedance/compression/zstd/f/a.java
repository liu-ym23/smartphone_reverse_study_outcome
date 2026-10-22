package com.bytedance.compression.zstd.f;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3826a = false;

    static {
    }

    public static synchronized void a() {
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f3826a == false) goto L8;
        monitor-exit(a.class);
        return;
    L8:
        System.loadLibrary("bdzstd");     // Catch: Throwable -> L11
        f3826a = true;     // Catch: Throwable -> L11
        monitor-exit(a.class);
    }
}

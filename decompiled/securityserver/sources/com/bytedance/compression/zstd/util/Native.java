package com.bytedance.compression.zstd.util;

/* JADX INFO: loaded from: classes.dex */
public class Native {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5a = false;

    public static synchronized void a() {
        monitor-enter(Native.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f5a == false) goto L8;
        monitor-exit(Native.class);
        return;
    L8:
        System.loadLibrary("bdzstd");     // Catch: Throwable -> L11
        f5a = true;     // Catch: Throwable -> L11
        monitor-exit(Native.class);
    }
}

package com.bytedance.applog.util;

/* JADX INFO: loaded from: classes.dex */
public class BlockHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2416a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f2417b;

    static {
    }

    public BlockHelper() {
    }

    private static void a() {
        if (f2416a == true) goto L14;
        f2417b = 0;
        return;
    L14:
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (f2417b >= 100) goto L7;
        Thread.sleep(100);     // Catch: InterruptedException -> L10
    L8:
        f2417b++;     // Catch: InterruptedException -> L10
        return;
    L7:
        f2416a = false;     // Catch: InterruptedException -> L10
        goto L8
    }

    public static void beginBlock() {
        f2416a = true;
        f2417b = 0;
    }

    public static void endBlock() {
        f2416a = false;
        f2417b = 0;
    }

    public static void tryBlock() {
    L3:
        if (f2416a == false) goto L5;
        a();
        goto L3
    }
}

package com.bytedance.feedbackerlib.m;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f4319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExecutorService f4320b;

    static {
        f4319a = new Handler(Looper.getMainLooper());
    }

    public t() {
    }

    public static void a(Runnable r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L8;
        r2.run();
        return;
    L8:
        f4319a.post(r2);
    }

    public static void b(Runnable r1, Context r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L7;
        a(r1);
        return;
    L7:
        String r3 = n.a(r2);
        if (r3 != null) goto L10;
    L13:
        a(r1);
        return;
    L10:
        if (r3.endsWith(":feedbacker") == false) goto L13;
        r1.run();
    }

    public static void c(Runnable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        e();
        f4320b.execute(r1);
    }

    public static ExecutorService d() {
        e();
        return f4320b;
    }

    private static void e() {
        if (f4320b == null) goto L5;
        return;
    L5:
        monitor-enter(t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4320b != null) goto L9;
        f4320b = Executors.newFixedThreadPool(8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L11
    }
}

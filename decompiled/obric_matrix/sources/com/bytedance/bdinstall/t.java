package com.bytedance.bdinstall;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Executor f2874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ExecutorService f2875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Looper f2876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.bytedance.bdinstall.d1.n<Handler> f2877d = null;

    class a extends com.bytedance.bdinstall.d1.n<Handler> {
        a() {
        }

        @Override // com.bytedance.bdinstall.d1.n
        protected /* bridge */ /* synthetic */ Handler a(Object[] r1) {
            return c(r1);
        }

        protected Handler c(Object... r1) {
            return new Handler(t.c());
        }
    }

    static {
        f2877d = new a();
    }

    public t() {
    }

    public static Handler a() {
        return f2877d.b(new Object[0]);
    }

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService b() {
        if (f2875b != null) goto L15;
        monitor-enter(t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2875b != null) goto L9;
        f2875b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5, TimeUnit.SECONDS, new SynchronousQueue());     // Catch: Throwable -> L11
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L11
    L15:
        return f2875b;
    }

    public static Looper c() {
        if (f2876c != null) goto L17;
        monitor-enter(t.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (f2876c == null) goto L18;
    L11:
        monitor-exit(t.class);     // Catch: Throwable -> L13
        goto L17
    L18:
        HandlerThread r1 = new HandlerThread("bd_install");     // Catch: Exception -> L10 Throwable -> L13
        r1.start();     // Catch: Exception -> L10 Throwable -> L13
        f2876c = r1.getLooper();     // Catch: Exception -> L10 Throwable -> L13
    L10:
        f2876c = Looper.getMainLooper();     // Catch: Throwable -> L13
    L17:
        return f2876c;
    }

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static Executor d() {
        if (f2874a != null) goto L15;
        monitor-enter(t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2874a != null) goto L9;
        f2874a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue());     // Catch: Throwable -> L11
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L11
    L15:
        return f2874a;
    }

    public static void e(Runnable r2) {
        if (Looper.myLooper() != c()) goto L5;
        r2.run();
        return;
    L5:
        f2877d.b(new Object[0]).post(r2);
    }

    public static void f(Runnable r1) {
        b().execute(r1);
    }

    public static void g(Runnable r1) {
        d().execute(r1);
    }

    static void h(s r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Executor r0 = r2.f2864a;
        if (f2874a != null) goto L8;
        if (r0 == null) goto L8;
        f2874a = r0;
    L8:
        ExecutorService r1 = r2.f2865b;
        if (f2875b != null) goto L12;
        if (r1 == null) goto L12;
        f2875b = r1;
    L12:
        Looper r3 = r2.f2866c;
        if (f2876c != null) goto L17;
        if (r3 == null) goto L18;
        f2876c = r3;
        return;
    L18:
        return;
    }

    public static <T> Future<T> i(Callable<T> r1) {
        return b().submit(r1);
    }
}

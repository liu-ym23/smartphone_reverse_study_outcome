package com.ss.android.m.a.a;

import android.os.Build;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class a extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile Field f12090g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private k f12091f;

    a(k r9, int r10, int r11, long r12, TimeUnit r14, BlockingQueue<Runnable> r15, ThreadFactory r16) {
        super(r10, r11, r12, r14, r15, r16);
        this.f12091f = r9;
    }

    a(k r10, int r11, int r12, long r13, TimeUnit r15, BlockingQueue<Runnable> r16, ThreadFactory r17, RejectedExecutionHandler r18) {
        super(r11, r12, r13, r15, r16, r17, r18);
        this.f12091f = r10;
    }

    private void a() {
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (f12090g == null) goto L5;
    L19:
        f12090g.set(Thread.currentThread(), null);     // Catch: Exception -> L21
        Log.d("ThreadPool-Executor", "cleanThreadLocals: ");     // Catch: Exception -> L21
        return;
    L5:
        monitor-enter(a.class);     // Catch: Exception -> L21
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L21
    L7:
        if (f12090g == null) goto L9;
    L14:
        monitor-exit(a.class);     // Catch: Throwable -> L16
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L12;
        Field r0 = Thread.class.getDeclaredField("threadLocals");     // Catch: Throwable -> L16
    L11:
        f12090g = r0;     // Catch: Throwable -> L16
        f12090g.setAccessible(true);     // Catch: Throwable -> L16
        goto L14
    L12:
        r0 = Thread.class.getDeclaredField("localValues");     // Catch: Throwable -> L16
        goto L11
    }

    private boolean c() {
        return f.c().a().contains(this.f12091f);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable r1, Throwable r2) {
        super.afterExecute(r1, r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (Looper.myLooper() == null) goto L12;
        a();     // Catch: Exception -> L7
        return;
    }

    k b() {
        return this.f12091f;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r2) {
        if (c() == false) goto L5;
        super.execute(new b(r2, this));
        return;
    L5:
        super.execute(r2);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if (f.j(this) == false) goto L5;
        return;
    L5:
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if (f.j(this) == false) goto L7;
        return Collections.emptyList();
    L7:
        return super.shutdownNow();
    }
}

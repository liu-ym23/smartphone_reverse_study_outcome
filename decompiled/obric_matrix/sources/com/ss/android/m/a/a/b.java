package com.ss.android.m.a.a;

import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable, Comparable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f12092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f12093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f12094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Thread f12095i;

    b(Runnable r1, a r2) {
        this.f12092f = r1;
        this.f12093g = r2;
        this.f12094h = SystemClock.uptimeMillis();
    }

    long b() {
        return this.f12094h;
    }

    a c() {
        return this.f12093g;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r2) {
        Runnable r1 = this.f12092f;
        if ((r1 instanceof Comparable) == true) goto L5;
        return 0;
    L5:
        if ((r2 instanceof b) == true) goto L7;
        return 0;
    L7:
        return ((Comparable) r1).compareTo(((b) r2).g());
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof b) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f12092f.equals(((b) r2).g()) == false) goto L7;
        return true;
    }

    Runnable g() {
        return this.f12092f;
    }

    public int hashCode() {
        return this.f12092f.hashCode();
    }

    public Thread j() {
        return this.f12095i;
    }

    @Override // java.lang.Runnable
    public void run() {
        long r2 = SystemClock.uptimeMillis();
        this.f12095i = Thread.currentThread();     // Catch: Throwable -> L32
        Object r0 = null;
        if (l.h(this.f12092f) == true) goto L6;
    L10:
        e.e().i(this);     // Catch: Throwable -> L32
        long r11 = r2 - this.f12094h;     // Catch: Throwable -> L32
        if (r11 < f.c().e()) goto L21;
        if (f.h().d() == false) goto L21;
        Log.w("ThreadPool-DelegateRunnable", String.format("Task<%s> target=%s dispatch time cost: %d ms", new Object[]{Thread.currentThread().getName(), this.f12092f, Long.valueOf(r11)}));     // Catch: Throwable -> L32
        e r6 = e.e();     // Catch: Throwable -> L32
        if (r0 == null) goto L18;
        Object r7 = r0;
    L19:
        r6.h(r7, this.f12093g.b().name(), this.f12093g.getPoolSize(), this.f12093g.getQueue().size(), r11);     // Catch: Throwable -> L32
        goto L21
    L18:
        r7 = this.f12092f;     // Catch: Throwable -> L32
    L21:
        this.f12092f.run();     // Catch: Throwable -> L32
        long r22 = SystemClock.uptimeMillis() - r2;     // Catch: Throwable -> L32
        if (r22 >= f.c().d()) goto L24;
    L30:
        e.e().j(this);
        return;
    L24:
        if (f.h().a() == false) goto L30;
        Log.w("ThreadPool-DelegateRunnable", String.format("Task<%s> target=%s execute cost %d ms !!!", new Object[]{Thread.currentThread().getName(), this.f12092f, Long.valueOf(r22)}));     // Catch: Throwable -> L32
        e r17 = e.e();     // Catch: Throwable -> L32
        if (r0 != null) goto L29;
        r0 = this.f12092f;     // Catch: Throwable -> L32
    L29:
        r17.f(r0, this.f12093g.b().name(), this.f12093g.getPoolSize(), this.f12093g.getQueue().size(), r22);     // Catch: Throwable -> L32
        goto L30
    L6:
        if (f.h().d() == false) goto L8;
    L9:
        r0 = (Callable) l.a(this.f12092f);     // Catch: Throwable -> L32
        goto L10
    L8:
        if (f.h().a() == false) goto L10;
    L32:
        th = move-exception;
        e.e().j(this);
        throw th;
    }
}

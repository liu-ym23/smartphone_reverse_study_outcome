package com.bytedance.common.wschannel.u;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static d f3811d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f3812e = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f3813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<e, ScheduledFuture> f3814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<e, Runnable> f3815c;

    static /* synthetic */ class a {
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private e f3816f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f3817g;

        private b(d r1, e r2) {
            this.f3817g = r1;
            this.f3816f = r2;
        }

        /* synthetic */ b(d r1, e r2, a r3) {
            this(r1, r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L8
            this.f3816f.run();     // Catch: Throwable -> L8
            if (Logger.debug() == false) goto L6;
            Logger.d(d.a(), "Task execute time: " + (System.currentTimeMillis() - r0));     // Catch: Throwable -> L8
        L6:
            if (this.f3816f.d() == true) goto L13;
        L7:
            d.b(this.f3817g).remove(this.f3816f);
            d.c(this.f3817g).remove(this.f3816f);
            return;
        L13:
            return;
        L8:
            th = move-exception;
            Logger.e(d.a(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L14
            if (this.f3816f.d() == false) goto L7;
            return;
        L14:
            th = move-exception;
            if (this.f3816f.d() == true) goto L18;
            d.b(this.f3817g).remove(this.f3816f);
            d.c(this.f3817g).remove(this.f3816f);
        L18:
            throw th;
        }
    }

    static {
    }

    private d() {
        this.f3814b = new ConcurrentHashMap();
        this.f3815c = new ConcurrentHashMap();
        this.f3813a = new ScheduledThreadPoolExecutor(1, new f("frontier"));
    }

    static /* synthetic */ String a() {
        return f3812e;
    }

    static /* synthetic */ ConcurrentHashMap b(d r0) {
        return r0.f3814b;
    }

    static /* synthetic */ ConcurrentHashMap c(d r0) {
        return r0.f3815c;
    }

    public static d d() {
        if (f3811d != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3811d != null) goto L9;
        f3811d = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f3811d;
    }

    public void e(e r9) {
        if (r9 != null) goto L13;
        return;
    L13:
        b r7 = new b(this, r9, null);     // Catch: Throwable -> L10
        if (r9.d() == false) goto L7;
        ScheduledFuture<?> r0 = this.f3813a.scheduleWithFixedDelay(r7, r9.b(), r9.c(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.f3815c.put(r9, r7);     // Catch: Throwable -> L10
        this.f3814b.put(r9, r0);     // Catch: Throwable -> L10
        return;
    L7:
        r0 = this.f3813a.schedule(r7, r9.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(f3812e, "sendTask failed.", th);
    }
}

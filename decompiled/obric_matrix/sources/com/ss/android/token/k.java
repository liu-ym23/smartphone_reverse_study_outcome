package com.ss.android.token;

import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.i0.m0;
import kotlin.n0.d.e0;
import kotlin.n0.d.y;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements d.b.s.a.q.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l[] f12223f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicReference<a> f12224g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicLong f12225h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final AtomicReference<ScheduledFuture<?>> f12226i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicBoolean f12227j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final kotlin.h f12228k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ThreadPoolExecutor f12229l = null;
    public static final k m = null;

    private static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f12230f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f12231g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f12232h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f12233i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f12234j = null;

        static {
            a r1 = new a("STOPPED", 0);
            f12230f = r1;
            a r2 = new a("STARTING", 1);
            f12231g = r2;
            a r3 = new a("RUNNING", 2);
            f12232h = r3;
            a r4 = new a("STOPPING", 3);
            f12233i = r4;
            f12234j = new a[]{r1, r2, r3, r4};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f12234j.clone();
        }
    }

    static final class b implements RejectedExecutionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12235a = null;

        static {
            f12235a = new b();
        }

        b() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r1, ThreadPoolExecutor r2) {
            d.b.s.a.a0.a.h("SecTimeUpdater", "Task rejected: executor is busy");
        }
    }

    static final class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f12236f = null;

        static final class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f12237f = null;

            static {
                f12237f = new a();
            }

            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                k r3 = k.m;
                if (k.b(r3).compareAndSet(true, false) == false) goto L5;
                String r0 = "boot";
            L6:
                k.c(r3, r0);
                return;
            L5:
                r0 = "periodic";
                goto L6
            }
        }

        static {
            f12236f = new c();
        }

        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.a(k.m).submit(a.f12237f);     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            d.b.s.a.a0.a.i("SecTimeUpdater", "Task submission rejected", e);
        }
    }

    static final class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f12238f;

        d(String r1) {
            this.f12238f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.c(k.m, this.f12238f);
        }
    }

    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.a<ScheduledExecutorService> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f12239f = null;

        static final class a implements ThreadFactory {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f12240f = null;

            static {
                f12240f = new a();
            }

            a() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable r2) {
                Thread r1 = new Thread(r2, "UpdateSecTimeThread");
                r1.setDaemon(true);
                return r1;
            }
        }

        static {
            f12239f = new e();
        }

        e() {
            super(0);
        }

        public final ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(a.f12240f);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ScheduledExecutorService invoke() {
            return a();
        }
    }

    static {
        f12223f = new kotlin.s0.l[]{e0.g(new y(e0.b(k.class), "updateSecTimeExecutor", "getUpdateSecTimeExecutor()Ljava/util/concurrent/ScheduledExecutorService;"))};
        m = new k();
        f12224g = new AtomicReference(a.f12230f);
        f12225h = new AtomicLong(0);
        f12226i = new AtomicReference(null);
        f12227j = new AtomicBoolean(true);
        f12228k = kotlin.i.b(e.f12239f);
        f12229l = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), b.f12235a);
    }

    private k() {
    }

    public static final /* synthetic */ ThreadPoolExecutor a(k r0) {
        return f12229l;
    }

    public static final /* synthetic */ AtomicBoolean b(k r0) {
        return f12227j;
    }

    public static final /* synthetic */ void c(k r0, String r1) {
        r0.l(r1);
    }

    private final boolean e(Context r7) {
        j r6 = i.f12216c.b(r7);
        long r0 = com.bytedance.sdk.account.ticketguard.f.f();
        if (r0 >= 0) goto L5;
        return false;
    L5:
        if (r6 == null) goto L7;
        Boolean r8 = Boolean.valueOf(r6.e(r7, r0 * 1000));
    L9:
        if (kotlin.n0.d.o.a(r8, Boolean.TRUE) == true) goto L11;
        if (r6 == null) goto L11;
        return false;
    L11:
        return true;
    L7:
        r8 = null;
        goto L9
    }

    private final String f() {
        com.ss.android.d r0 = com.ss.android.i.j.l();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    private final ScheduledExecutorService g() {
        kotlin.h r2 = f12228k;
        kotlin.s0.l r0 = f12223f[0];
        return (ScheduledExecutorService) r2.getValue();
    }

    private final boolean h() {
        com.ss.android.d r1 = com.ss.android.i.j.l();
        if (r1 == null) goto L9;
        Context r2 = r1.e();
        if (r2 == null) goto L9;
        if (w.j(r2) != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final void l(String r6) {
        d.b.s.a.a0.a.d("SecTimeUpdater", "tryUpdateSecTimeSync, scene: " + r6);
        String r5 = f();
        if (r5 != null) goto L18;
        String r7 = "tryUpdateSecTimeSync, host is null";
    L5:
        d.b.s.a.a0.a.b("SecTimeUpdater", r7);
        return;
    L18:
        com.ss.android.h r8 = d.b.s.a.l0.l.d(Integer.MAX_VALUE, "https://" + r5 + "/passport/user_info/get_sec_ts/?update_scene=" + r6, m0.h(), kotlin.i0.r.g(), 0);     // Catch: Exception -> L10
    L12:
        if (r8 != null) goto L14;
    L17:
        r7 = "tryUpdateSecTime, scene: " + r6 + ", network error";
        goto L5
    L14:
        if (r8.f() == false) goto L17;
        return;
    L10:
        e = move-exception;
        d.b.s.a.a0.a.c("SecTimeUpdater", "tryUpdateSecTime error", e);
        r8 = null;
        goto L12
    }

    @Override // d.b.s.a.q.c
    public void F(d.b.s.a.q.b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.f14879a == 1) goto L6;
        return;
    L6:
        if (h() == false) goto L11;
        d.b.s.a.a0.a.d("SecTimeUpdater", "Logout, restart update sec time");
        j(true);
        return;
    }

    public final void d(Context r10, String r11) {
        kotlin.n0.d.o.g(r10, "context");
        kotlin.n0.d.o.g(r11, "scene");
        long r0 = System.currentTimeMillis();
        AtomicLong r2 = f12225h;
        long r3 = r2.get();
        long r5 = com.bytedance.sdk.account.ticketguard.f.g() * 1000;
        if ((r0 - r3) >= r5) goto L5;
        return;
    L5:
        if (r5 >= 0) goto L8;
        return;
    L8:
        if (r2.compareAndSet(r3, r0) == true) goto L11;
        return;
    L11:
        if (e(r10) == false) goto L15;
        m(r11);
        return;
    }

    public final void i(Context r2) {
        kotlin.n0.d.o.g(r2, "context");
        com.bytedance.sdk.account.impl.g.d(r2).b(this);
    }

    public final void j(boolean r10) {
        d.b.s.a.a0.a.d("SecTimeUpdater", "startUpdateSecTime");
        long r6 = com.bytedance.sdk.account.ticketguard.f.e();
        if (r6 > 0) goto L9;
        if (r10 == true) goto L9;
        d.b.s.a.a0.a.h("SecTimeUpdater", "startUpdateSecTime: interval <= 0");
        Context r9 = com.ss.android.i.j.j();
        if (r9 == null) goto L24;
        m.d(r9, "boot_check");
        return;
    L24:
        return;
    L9:
        AtomicReference<a> r11 = f12224g;
        a r1 = a.f12230f;
        if (r11.compareAndSet(r1, a.f12231g) == true) goto L14;
        d.b.s.a.a0.a.h("SecTimeUpdater", "startUpdateSecTime: already starting or running");
        return;
    L14:
        if (g().isShutdown() == false) goto L22;
        r11.set(r1);
        return;
    L22:
        ScheduledFuture<?> r12 = g().scheduleWithFixedDelay(c.f12236f, 0, r6, TimeUnit.SECONDS);     // Catch: Exception -> L19
        f12226i.set(r12);     // Catch: Exception -> L19
        r11.set(a.f12232h);     // Catch: Exception -> L19
        d.b.s.a.a0.a.d("SecTimeUpdater", "startUpdateSecTime: started successfully");     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        d.b.s.a.a0.a.c("SecTimeUpdater", "startUpdateSecTime error", e);
        f12224g.set(a.f12230f);
        f12226i.set(null);
    }

    public final void k() {
        d.b.s.a.a0.a.d("SecTimeUpdater", "stopUpdateSecTime");
        AtomicReference<a> r1 = f12224g;
        a r2 = r1.get();
        a r3 = a.f12230f;
        if (r2 == r3) goto L23;
        a r4 = a.f12233i;
        if (r2 != r4) goto L8;
        return;
    L8:
        if (r1.compareAndSet(r2, r4) == true) goto L24;
        return;
    L24:
        ScheduledFuture<?> r5 = f12226i.getAndSet(null);     // Catch: Throwable -> L15 Exception -> L17
        if (r5 == null) goto L13;
        r5.cancel(false);     // Catch: Throwable -> L15 Exception -> L17
    L13:
        r1.set(r3);
    L14:
        d.b.s.a.a0.a.d("SecTimeUpdater", "stopUpdateSecTime: stopped successfully");
        return;
    L17:
        e = move-exception;
        d.b.s.a.a0.a.c("SecTimeUpdater", "Error cancelling scheduled task", e);     // Catch: Throwable -> L15
        f12224g.set(a.f12230f);
    L15:
        th = move-exception;
        f12224g.set(a.f12230f);
        d.b.s.a.a0.a.d("SecTimeUpdater", "stopUpdateSecTime: stopped successfully");
        throw th;
    }

    public final void m(String r3) {
        kotlin.n0.d.o.g(r3, "scene");
        d.b.s.a.a0.a.d("SecTimeUpdater", "start update timestamp");
        f12229l.submit(new d(r3));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        d.b.s.a.a0.a.i("SecTimeUpdater", "updateOnce: task rejected", e);
    }
}

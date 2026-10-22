package com.ss.android.m.a.a;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class d implements i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f12096a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicInteger f12097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12098c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f12099d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f12100e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f12101f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ExecutorService f12102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ExecutorService f12103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f12104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f12105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f12106k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static RejectedExecutionHandler f12107l;
    private static RejectedExecutionHandler m;

    static class a implements RejectedExecutionHandler {
        a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r7, ThreadPoolExecutor r8) {
            Log.d("ThreadPool-NewInstanceFactory", String.format("sIORejectHandler: runnable=%s, executor=%s", new Object[]{r7, r8}));
            d.b().execute(r7);
            long r0 = SystemClock.elapsedRealtime();
            long r2 = r0 - d.c();
            long r4 = d.e();
            d.d(r0);
            if (r2 < r4) goto L6;
            e.e().g(r7, r8);
            return;
        }
    }

    static class b implements RejectedExecutionHandler {
        b() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r7, ThreadPoolExecutor r8) {
            Log.d("ThreadPool-NewInstanceFactory", String.format("sDefaultRejectHandler: runnable=%s, executor=%s", new Object[]{r7, r8}));
            d.f().execute(r7);
            long r0 = SystemClock.elapsedRealtime();
            if ((r0 - d.g()) < d.e()) goto L5;
        L8:
            d.h(r0);
            e.e().g(r7, r8);
            return;
        L5:
            if (f.c().f() == true) goto L8;
            d.h(r0);
        }
    }

    static class c implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f12108f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f12109g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f12110h;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Runnable f12111f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ c f12112g;

            a(c r1, Runnable r2) {
                this.f12112g = r1;
                this.f12111f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.i(this.f12112g.f12108f);
                this.f12111f.run();
            }
        }

        c(int r1, String r2, boolean r3) {
            this.f12108f = r1;
            this.f12109g = r2;
            this.f12110h = r3;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r3) {
            Thread r0 = new Thread(new a(this, r3));
            r0.setName(this.f12109g + "-" + d.j().incrementAndGet());
            r0.setDaemon(this.f12110h);
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.m.a.a.d$d, reason: collision with other inner class name */
    static /* synthetic */ class C0316d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12113a = null;

        static {
            int[] r0 = new int[k.values().length];
            f12113a = r0;
            r0[k.f12171f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f12113a[k.f12172g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f12113a[k.f12173h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f12113a[k.f12174i.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f12113a[k.f12175j.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f12113a[k.f12176k.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        f12096a = r0;
        f12097b = new AtomicInteger(0);
        int r1 = r0 + 1;
        f12098c = r1;
        int r2 = Math.max(2, Math.min(r0 - 1, 6)) * 2;
        f12099d = r2;
        int r3 = Math.max(2, Math.min(r0 - 1, 4));
        f12100e = r3;
        f12101f = (r3 * 2) + 1;
        f12102g = o(r2, k.f12171f, "tp-reject");
        f12103h = o(r1, k.f12172g, "tp-default-reject");
        f12106k = TimeUnit.SECONDS.toMillis(3);
        f12107l = new a();
        m = new b();
    }

    d() {
    }

    static /* synthetic */ ExecutorService b() {
        return f12102g;
    }

    static /* synthetic */ long c() {
        return f12104i;
    }

    static /* synthetic */ long d(long r0) {
        f12104i = r0;
        return r0;
    }

    static /* synthetic */ long e() {
        return f12106k;
    }

    static /* synthetic */ ExecutorService f() {
        return f12103h;
    }

    static /* synthetic */ long g() {
        return f12105j;
    }

    static /* synthetic */ long h(long r0) {
        f12105j = r0;
        return r0;
    }

    static /* synthetic */ void i(int r0) {
        r(r0);
    }

    static /* synthetic */ AtomicInteger j() {
        return f12097b;
    }

    private ExecutorService k() {
        return new com.ss.android.m.a.a.a(k.f12173h, 0, 3, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(128), s("tp-background", true, 10), m);
    }

    private ExecutorService l() {
        com.ss.android.m.a.a.a r10 = new com.ss.android.m.a.a.a(k.f12172g, f12100e, f12101f, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(128), s("tp-default", false, 0), m);
        r10.allowCoreThreadTimeOut(true);
        return r10;
    }

    private ExecutorService m(h r12) {
        String r11 = r12.f12153b;
        if (r11 != null) goto L6;
        r11 = "tp-fixed";
    L6:
        ThreadFactory r13 = s(r11, false, 0);
        k r1 = k.f12176k;
        int r3 = r12.f12154c;
        long r4 = r12.f12157f;
        if (r4 >= 0) goto L10;
        r4 = 30;
    L10:
        TimeUnit r6 = TimeUnit.SECONDS;
        BlockingQueue r0 = r12.f12155d;
        if (r0 != null) goto L14;
        r0 = new LinkedBlockingQueue();
    L14:
        BlockingQueue r7 = r0;
        ThreadFactory r2 = r12.f12158g;
        if (r2 == null) goto L17;
        ThreadFactory r8 = r2;
    L18:
        RejectedExecutionHandler r14 = r12.f12156e;
        if (r14 != null) goto L22;
        r14 = new ThreadPoolExecutor.AbortPolicy();
    L22:
        com.ss.android.m.a.a.a r10 = new com.ss.android.m.a.a.a(r1, r3, r3, r4, r6, r7, r8, r14);
        r10.allowCoreThreadTimeOut(true);
        return r10;
    L17:
        r8 = r13;
        goto L18
    }

    private ExecutorService n() {
        return new com.ss.android.m.a.a.a(k.f12171f, 0, 128, 30, TimeUnit.SECONDS, new SynchronousQueue(), s("tp-io", false, 0), f12107l);
    }

    private static ExecutorService o(int r10, k r11, String r12) {
        com.ss.android.m.a.a.a r9 = new com.ss.android.m.a.a.a(r11, r10, r10, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), s(r12, false, 0));
        r9.allowCoreThreadTimeOut(true);
        return r9;
    }

    private ExecutorService p(h r4) {
        String r3 = r4.f12153b;
        if (r3 != null) goto L6;
        r3 = "tp-scheduled";
    L6:
        ThreadFactory r5 = s(r3, false, 0);
        int r1 = r4.f12154c;
        ThreadFactory r2 = r4.f12158g;
        if (r2 == null) goto L9;
        r5 = r2;
    L9:
        ScheduledThreadPoolExecutor r0 = new ScheduledThreadPoolExecutor(r1, r5);
        long r6 = r4.f12157f;
        if (r6 >= 0) goto L13;
        r6 = 15;
    L13:
        r0.setKeepAliveTime(r6, TimeUnit.SECONDS);
        r0.allowCoreThreadTimeOut(true);
        return r0;
    }

    private ExecutorService q(h r12) {
        String r11 = r12.f12153b;
        if (r11 != null) goto L6;
        r11 = "tp-serial";
    L6:
        ThreadFactory r13 = s(r11, false, 0);
        k r1 = k.f12175j;
        long r4 = r12.f12157f;
        if (r4 >= 0) goto L10;
        r4 = 30;
    L10:
        TimeUnit r6 = TimeUnit.SECONDS;
        BlockingQueue r0 = r12.f12155d;
        if (r0 != null) goto L14;
        r0 = new LinkedBlockingQueue();
    L14:
        BlockingQueue r7 = r0;
        ThreadFactory r2 = r12.f12158g;
        if (r2 == null) goto L17;
        ThreadFactory r8 = r2;
    L18:
        RejectedExecutionHandler r14 = r12.f12156e;
        if (r14 != null) goto L22;
        r14 = new ThreadPoolExecutor.AbortPolicy();
    L22:
        com.ss.android.m.a.a.a r10 = new com.ss.android.m.a.a.a(r1, 1, 1, r4, r6, r7, r8, r14);
        r10.allowCoreThreadTimeOut(true);
        return r10;
    L17:
        r8 = r13;
        goto L18
    }

    private static void r(int r0) {
        Process.setThreadPriority(r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private static ThreadFactory s(String r1, boolean r2, int r3) {
        return new c(r3, r1, r2);
    }

    @Override // com.ss.android.m.a.a.i.b
    public ExecutorService a(h r4) {
        Log.d("ThreadPool-NewInstanceFactory", String.format("create: taskType=%s", new Object[]{r4.f12152a}));
        switch(C0316d.f12113a[r4.f12152a.ordinal()]) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        return n();
    L7:
        return m(r4);
    L9:
        return q(r4);
    L11:
        return p(r4);
    L13:
        return k();
    L15:
        return l();
    L17:
        return n();
    }
}

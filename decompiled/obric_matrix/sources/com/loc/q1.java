package com.loc;

import android.text.TextUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class q1 implements ThreadFactory {
    private static final int p = 0;
    private static final int q = 0;
    private static final int r = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicLong f7620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ThreadFactory f7621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f7622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f7623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Integer f7624j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Boolean f7625k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f7626l;
    private final int m;
    private final BlockingQueue<Runnable> n;
    private final int o;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadFactory f7627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f7628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f7629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f7630d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Boolean f7631e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f7632f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f7633g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private BlockingQueue<Runnable> f7634h;

        public a() {
            this.f7632f = q1.e();
            q1.f();
            this.f7633g = 30;
        }

        static /* synthetic */ ThreadFactory c(a r0) {
            return r0.f7627a;
        }

        static /* synthetic */ int d(a r0) {
            return r0.f7632f;
        }

        private void e() {
            this.f7627a = null;
            this.f7628b = null;
            this.f7629c = null;
            this.f7630d = null;
            this.f7631e = null;
        }

        static /* synthetic */ int f(a r0) {
            return r0.f7633g;
        }

        static /* synthetic */ BlockingQueue g(a r0) {
            return r0.f7634h;
        }

        static /* synthetic */ String h(a r0) {
            return r0.f7629c;
        }

        static /* synthetic */ Integer i(a r0) {
            return r0.f7630d;
        }

        static /* synthetic */ Boolean j(a r0) {
            return r0.f7631e;
        }

        static /* synthetic */ Thread.UncaughtExceptionHandler k(a r0) {
            return r0.f7628b;
        }

        public final a a(String r1) {
            this.f7629c = r1;
            return this;
        }

        public final q1 b() {
            q1 r0 = new q1(this, 0);
            e();
            return r0;
        }
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        p = r0;
        q = Math.max(2, Math.min(r0 - 1, 4));
        r = (r0 * 2) + 1;
    }

    private q1(a r3) {
        if (a.c(r3) != null) goto L5;
        ThreadFactory r0 = Executors.defaultThreadFactory();
    L6:
        this.f7621g = r0;
        int r1 = a.d(r3);
        this.f7626l = r1;
        int r2 = r;
        this.m = r2;
        if (r2 < r1) goto L19;
        this.o = a.f(r3);
        if (a.g(r3) != null) goto L11;
        BlockingQueue<Runnable> r4 = new LinkedBlockingQueue(256);
    L12:
        this.n = r4;
        if (TextUtils.isEmpty(a.h(r3)) == false) goto L15;
        String r5 = "amap-threadpool";
    L16:
        this.f7623i = r5;
        this.f7624j = a.i(r3);
        this.f7625k = a.j(r3);
        this.f7622h = a.k(r3);
        this.f7620f = new AtomicLong();
        return;
    L15:
        r5 = a.h(r3);
        goto L16
    L11:
        r4 = a.g(r3);
        goto L12
    L19:
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    L5:
        r0 = a.c(r3);
        goto L6
    }

    /* synthetic */ q1(a r1, byte r2) {
        this(r1);
    }

    static /* synthetic */ int e() {
        return q;
    }

    static /* synthetic */ int f() {
        return r;
    }

    private ThreadFactory g() {
        return this.f7621g;
    }

    private String h() {
        return this.f7623i;
    }

    private Boolean i() {
        return this.f7625k;
    }

    private Integer j() {
        return this.f7624j;
    }

    private Thread.UncaughtExceptionHandler k() {
        return this.f7622h;
    }

    public final int a() {
        return this.f7626l;
    }

    public final int b() {
        return this.m;
    }

    public final BlockingQueue<Runnable> c() {
        return this.n;
    }

    public final int d() {
        return this.o;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        Thread r6 = g().newThread(r5);
        if (h() == null) goto L6;
        r6.setName(String.format(h() + "-%d", new Object[]{Long.valueOf(this.f7620f.incrementAndGet())}));
    L6:
        if (k() == null) goto L9;
        r6.setUncaughtExceptionHandler(k());
    L9:
        if (j() == null) goto L12;
        r6.setPriority(j().intValue());
    L12:
        if (i() == null) goto L14;
        r6.setDaemon(i().booleanValue());
    L14:
        return r6;
    }
}

package com.loc;

import android.content.Context;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends s implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ExecutorService f7872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Set<Integer> f7873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static WeakReference<Context> f7874g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f7875d;

    final class a extends s1 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ t5 f7876g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f7877h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ v f7878i;

        a(v r1, t5 r2, boolean r3) {
            this.f7878i = r1;
            this.f7876g = r2;
            this.f7877h = r3;
        }

        @Override // com.loc.s1
        public final void b() {
            Looper r0 = Looper.getMainLooper();     // Catch: Throwable -> L13
            monitor-enter(r0);     // Catch: Throwable -> L13
            t.f(this.f7876g);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
        L7:
            if (this.f7877h == false) goto L19;
            w.d(v.f(this.f7878i));     // Catch: Throwable -> L13
            return;
        L19:
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.printStackTrace();
        }
    }

    final class b implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicInteger f7879f;

        final class a extends Thread {
            a(b r1, Runnable r2, String r3) {
                super(r2, r3);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                super.run();     // Catch: Throwable -> L4
                return;
            }
        }

        b() {
            this.f7879f = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r4) {
            return new a(this, r4, "pama#" + this.f7879f.getAndIncrement());
        }
    }

    static {
        f7873f = Collections.synchronizedSet(new HashSet());
        new b();
    }

    private v(Context r4) {
        this.f7875d = r4;
        Thread.UncaughtExceptionHandler r5 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L17
        this.f7747a = r5;     // Catch: Throwable -> L17
        if (r5 != null) goto L7;
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.f7748b = true;     // Catch: Throwable -> L17
        return;
    L7:
        String r6 = r5.toString();     // Catch: Throwable -> L17
        if (r6.startsWith("com.amap.apis.utils.core.dynamiccore") == false) goto L10;
    L15:
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.f7748b = true;     // Catch: Throwable -> L17
        return;
    L10:
        if (r6.indexOf("com.amap.api") == (-1)) goto L12;
    L13:
        this.f7748b = false;     // Catch: Throwable -> L17
        return;
    L12:
        if (r6.indexOf("com.loc") == (-1)) goto L15;
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    static /* synthetic */ Context f(v r0) {
        return r0.f7875d;
    }

    public static synchronized v g(Context r3, t5 r4) {
        monitor-enter(v.class);
        if (r4 == null) goto L30;
        if (r4.a() == null) goto L26;
        if ("".equals(r4.a()) == true) goto L26;
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L27
    L22:
        v r5 = (v) s.f7746c;     // Catch: Throwable -> L27
        monitor-exit(v.class);
        return r5;
    L10:
        if (f7873f.add(Integer.valueOf(r4.hashCode())) == true) goto L14;
        v r6 = (v) s.f7746c;     // Catch: Throwable -> L20
        monitor-exit(v.class);
        return r6;
    L14:
        s r1 = s.f7746c;     // Catch: Throwable -> L20
        if (r1 != null) goto L17;
        s.f7746c = new v(r3);     // Catch: Throwable -> L20
    L18:
        s r7 = s.f7746c;     // Catch: Throwable -> L20
        r7.c(r4, r7.f7748b);     // Catch: Throwable -> L20
        goto L22
    L17:
        r1.f7748b = false;     // Catch: Throwable -> L20
    L26:
        throw new h5("sdk name is invalid");     // Catch: Throwable -> L27
    L30:
        throw new h5("sdk info is null");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public static void h(t5 r6, String r7, h5 r8) {
        if (r8 == null) goto L5;
        j(r6, r7, r8.e(), r8.f(), r8.g(), r8.d());
        return;
    }

    public static void i(t5 r6, String r7, String r8, String r9, String r10) {
        j(r6, r7, r8, r9, "", r10);
    }

    public static void j(t5 r2, String r3, String r4, String r5, String r6, String r7) {
        if (s.f7746c == null) goto L9;
        s.f7746c.b(r2, "path:" + r3 + ",type:" + r4 + ",gsid:" + r5 + ",csid:" + r6 + ",code:" + r7, "networkError");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static synchronized void k() {
        monitor-enter(v.class);
        ExecutorService r1 = f7872e;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.shutdown();     // Catch: Throwable -> L9
    L7:
        l0.l();     // Catch: Throwable -> L9
    L29:
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        return;
    L12:
        if (s.f7746c == null) goto L18;
        Thread.UncaughtExceptionHandler r2 = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L21
        s r3 = s.f7746c;     // Catch: Throwable -> L21
        if (r2 != r3) goto L18;
        Thread.UncaughtExceptionHandler r4 = r3.f7747a;     // Catch: Throwable -> L21
        if (r4 == null) goto L18;
        Thread.setDefaultUncaughtExceptionHandler(r4);     // Catch: Throwable -> L21
    L18:
        s.f7746c = null;     // Catch: Throwable -> L21
        monitor-exit(v.class);
        return;
    L25:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        goto L29
    }

    public static void l(t5 r1, String r2, String r3) {
        s r0 = s.f7746c;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.b(r1, r2, r3);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void m(Throwable r2, String r3, String r4) {
        s r0 = s.f7746c;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.d(r2, 1, r3, r4);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void n() {
        WeakReference<Context> r0 = f7874g;
        if (r0 != null) goto L5;
    L8:
        s r1 = s.f7746c;
        if (r1 == null) goto L12;
        r1.a();
        return;
    L12:
        return;
    L5:
        if (r0.get() == null) goto L8;
        t.d(f7874g.get());
    }

    @Override // com.loc.s
    protected final void a() {
        t.d(this.f7875d);
    }

    @Override // com.loc.s
    protected final void b(t5 r1, String r2, String r3) {
        w.h(r1, this.f7875d, r3, r2);
    }

    @Override // com.loc.s
    protected final void c(t5 r3, boolean r4) {
        r1.f().d(new a(this, r3, r4));     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.loc.s
    protected final void d(Throwable r1, int r2, String r3, String r4) {
        w.g(this.f7875d, r1, r2, r3, r4);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r3, Throwable r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        d(r4, 0, null, null);
        Thread.UncaughtExceptionHandler r0 = this.f7747a;
        if (r0 == null) goto L12;
        Thread.setDefaultUncaughtExceptionHandler(r0);     // Catch: Throwable -> L9
    L7:
        this.f7747a.uncaughtException(r3, r4);
        return;
    }
}

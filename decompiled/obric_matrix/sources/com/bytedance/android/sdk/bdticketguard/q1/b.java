package com.bytedance.android.sdk.bdticketguard.q1;

import com.bytedance.android.sdk.bdticketguard.c0;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.q;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f1051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f1053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f1054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f1056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l<Integer, T> f1057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final q<v<? extends T>, Integer, Boolean, f0> f1058h;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f1059f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f1060g;

        a(b r1, int r2) {
            this.f1059f = r1;
            this.f1060g = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.a(this.f1059f, this.f1060g + 1);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.q1.b$b, reason: collision with other inner class name */
    static final class RunnableC0036b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f1061f;

        RunnableC0036b(b r1) {
            this.f1061f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.a(this.f1061f, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(long r2, int r4, long r5, l<? super Integer, ? extends T> r7, q<? super v<? extends T>, ? super Integer, ? super Boolean, f0> r8) {
        o.g(r7, "task");
        this.f1054d = r2;
        this.f1055e = r4;
        this.f1056f = r5;
        this.f1057g = r7;
        this.f1058h = r8;
        ScheduledExecutorService r9 = Executors.newSingleThreadScheduledExecutor();
        o.b(r9, "Executors.newSingleThreadScheduledExecutor()");
        this.f1051a = r9;
        boolean r3 = true;
        if (r2 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L22;
        if (r4 <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L20;
        if (r5 >= 0) goto L15;
        r3 = false;
    L15:
        if (r3 == false) goto L18;
        return;
    L18:
        throw new IllegalArgumentException("Retry interval must be non-negative".toString());
    L20:
        throw new IllegalArgumentException("Max attempts must be positive".toString());
    L9:
        r6 = false;
        goto L10
    L22:
        throw new IllegalArgumentException("Initial delay must be non-negative".toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final /* synthetic */ void a(b r0, int r1) {
        r0.b(r1);
    }

    private final synchronized void b(int r6) {
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L4:
        if (this.f1053c == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        boolean r0 = true;
        this.f1052b = true;     // Catch: Throwable -> L35
        v.a r1 = v.f21457g;     // Catch: Throwable -> L11
        Object r2 = this.f1057g.invoke(Integer.valueOf(r6));     // Catch: Throwable -> L11
        v.b(r2);     // Catch: Throwable -> L11
    L14:
        if (v.g(r2) == false) goto L19;
        q<v<? extends T>, Integer, Boolean, f0> r3 = this.f1058h;     // Catch: Throwable -> L35
        if (r3 == null) goto L18;
        f0 r7 = r3.f(v.a(r2), Integer.valueOf(r6), Boolean.TRUE);     // Catch: Throwable -> L35
    L18:
        d();     // Catch: Throwable -> L35
    L33:
        monitor-exit(this);
        return;
    L19:
        Throwable r4 = v.d(r2);     // Catch: Throwable -> L35
        if (r4 == null) goto L22;
        boolean r5 = !(r4 instanceof c0);     // Catch: Throwable -> L35
    L23:
        if (r5 == true) goto L25;
    L28:
        q<v<? extends T>, Integer, Boolean, f0> r8 = this.f1058h;     // Catch: Throwable -> L35
        if (r8 == null) goto L31;
        f0 r9 = r8.f(v.a(r2), Integer.valueOf(r6), Boolean.valueOf(r0));     // Catch: Throwable -> L35
    L31:
        if (r0 == true) goto L18;
        this.f1051a.schedule(new a(this, r6), this.f1056f, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L35
        goto L33
    L25:
        if (r6 >= (this.f1055e - 1)) goto L28;
        r0 = false;
        goto L28
    L22:
        r5 = true;
    L11:
        th = move-exception;
        v.a r10 = v.f21457g;     // Catch: Throwable -> L35
        r2 = w.a(th);     // Catch: Throwable -> L35
        v.b(r2);     // Catch: Throwable -> L35
        goto L14
    }

    public final boolean c() {
        return this.f1051a.isTerminated();
    }

    public final void d() {
        this.f1051a.shutdown();
    }

    public final boolean e() {
        monitor-enter(this);
        boolean r1 = true;
        if (this.f1052b == false) goto L6;
    L9:
        r1 = false;
    L10:
        monitor-exit(this);
        return r1;
    L6:
        if (this.f1053c == true) goto L9;
        this.f1053c = true;     // Catch: Throwable -> L12
        this.f1051a.shutdownNow();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public final void f() {
        this.f1051a.schedule(new RunnableC0036b(this), this.f1054d, TimeUnit.MILLISECONDS);
    }
}

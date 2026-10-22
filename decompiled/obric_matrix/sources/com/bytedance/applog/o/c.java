package com.bytedance.applog.o;

import com.bytedance.applog.util.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final long[] f2258g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f2259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile boolean f2261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f2262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected long f2264f;

    static {
        f2258g = new long[]{180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};
    }

    public c(e r1) {
        this.f2259a = r1;
    }

    c(e r1, long r2) {
        this(r1);
        this.f2262d = r2;
    }

    private long b() {
        long r0 = i();
        if (h() == false) goto L8;
        if (com.bytedance.common.utility.i.p(this.f2259a.r()) == true) goto L8;
        n.e("checkWorkTime, " + e() + ", network not available");
        b.f(com.bytedance.applog.r.b.a.n, com.bytedance.applog.r.b.d.M, 1);
    L14:
        return this.f2262d + r0;
    L8:
        if (this.f2261c == false) goto L10;
        this.f2262d = 0;
        this.f2261c = false;
        r0 = 0;
        goto L14
    L10:
        int r2 = this.f2260b;
        if (r2 <= 0) goto L14;
        r0 = d(r2 - 1);
        goto L14
    }

    private long d(int r2) {
        long[] r1 = f();
        return r1[r2 % r1.length];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized long l(int r5) {
        monitor-enter(this);
        boolean r0 = 0;
        r0 = 0;
        boolean r6 = c(r5);     // Catch: Throwable -> L14 Exception -> L16
        this.f2262d = System.currentTimeMillis();     // Catch: Throwable -> L12
        if (r6 == false) goto L8;
        this.f2260b = 0;     // Catch: Throwable -> L12
    L9:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L12
        r1.append(e());     // Catch: Throwable -> L12
        r1.append(" worked:");     // Catch: Throwable -> L12
        r1.append(r6);     // Catch: Throwable -> L12
        String r7 = r1.toString();     // Catch: Throwable -> L12
        r0 = r1;
    L10:
        n.f(r7, null);     // Catch: Throwable -> L12
        long r2 = b();     // Catch: Throwable -> L12
        monitor-exit(this);
        return r2;
    L8:
        this.f2260b++;     // Catch: Throwable -> L12
        goto L9
    L16:
        e = move-exception;
        n.f("work", e);     // Catch: Throwable -> L14
        this.f2262d = System.currentTimeMillis();     // Catch: Throwable -> L12
        this.f2260b++;     // Catch: Throwable -> L12
        r7 = e() + " worked:false";     // Catch: Throwable -> L12
    L14:
        th = move-exception;
        this.f2262d = System.currentTimeMillis();     // Catch: Throwable -> L12
        this.f2260b++;     // Catch: Throwable -> L12
        n.f(e() + " worked:" + r0, null);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    final long a(int r5) {
        long r0 = b();
        if (r0 <= System.currentTimeMillis()) goto L5;
        return r0;
    L5:
        return l(r5);
    }

    protected abstract boolean c(int r1);

    protected abstract String e();

    protected abstract long[] f();

    boolean g() {
        return this.f2263e;
    }

    protected abstract boolean h();

    protected abstract long i();

    /* JADX WARN: Multi-variable type inference failed */
    <T extends c> T j() {
        n.e("setImmediately, " + e());
        this.f2261c = true;
        return this;
    }

    public void k(boolean r1) {
        this.f2263e = r1;
    }
}

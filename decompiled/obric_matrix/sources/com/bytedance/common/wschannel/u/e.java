package com.bytedance.common.wschannel.u;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f3818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f3820h;

    public e() {
        this(0);
    }

    public e(long r3) {
        this(r3, 0);
    }

    public e(long r1, long r3) {
        this.f3818f = r1;
        this.f3820h = r3;
        if (r3 <= 0) goto L6;
        this.f3819g = true;
        return;
    }

    public final long b() {
        return this.f3818f;
    }

    public final long c() {
        return this.f3820h;
    }

    public final boolean d() {
        return this.f3819g;
    }
}

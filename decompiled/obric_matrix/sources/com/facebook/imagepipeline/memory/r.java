package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public class r implements d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final c0<Bitmap> f6737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f6738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final g0 f6740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6741j;

    public r(int r2, int r3, g0 r4) {
        this.f6737f = new e();
        this.f6738g = r2;
        this.f6739h = r3;
        this.f6740i = r4;
    }

    private Bitmap b(int r2) {
        this.f6740i.a(r2);
        return Bitmap.createBitmap(1, r2, Bitmap.Config.ALPHA_8);
    }

    private synchronized void e(int r3) {
        monitor-enter(this);
    L15:
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f6741j <= r3) goto L10;
        Bitmap r0 = this.f6737f.pop();     // Catch: Throwable -> L12
        if (r0 == null) goto L10;
        int r1 = this.f6737f.a(r0);     // Catch: Throwable -> L12
        this.f6741j -= r1;     // Catch: Throwable -> L12
        this.f6740i.e(r1);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    @Override // d.c.c.g.c
    public void a(d.c.c.g.b r7) {
        e((int) (((double) this.f6738g) * (1.0d - r7.a())));
    }

    public synchronized Bitmap c(int r3) {
        monitor-enter(this);
        int r0 = this.f6741j;     // Catch: Throwable -> L14
        int r1 = this.f6738g;     // Catch: Throwable -> L14
        if (r0 <= r1) goto L6;
        e(r1);     // Catch: Throwable -> L14
    L6:
        Bitmap r2 = this.f6737f.get(r3);     // Catch: Throwable -> L14
        if (r2 == null) goto L11;
        int r4 = this.f6737f.a(r2);     // Catch: Throwable -> L14
        this.f6741j -= r4;     // Catch: Throwable -> L14
        this.f6740i.b(r4);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r2;
    L11:
        Bitmap r5 = b(r3);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r5;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void d(Bitmap r3) {
        monitor-enter(this);
        int r0 = this.f6737f.a(r3);     // Catch: Throwable -> L8
        if (r0 > this.f6739h) goto L6;
        this.f6740i.g(r0);     // Catch: Throwable -> L8
        this.f6737f.put(r3);     // Catch: Throwable -> L8
        this.f6741j += r0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // d.c.c.g.f
    public /* bridge */ /* synthetic */ Bitmap get(int r1) {
        return c(r1);
    }

    @Override // d.c.c.g.f, d.c.c.h.c
    public /* bridge */ /* synthetic */ void release(Object r1) {
        d((Bitmap) r1);
    }
}

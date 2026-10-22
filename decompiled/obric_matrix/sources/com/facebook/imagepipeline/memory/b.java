package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.c.c.h.c<Bitmap> f6676e;

    class a implements d.c.c.h.c<Bitmap> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f6677f;

        a(b r1) {
            this.f6677f = r1;
        }

        public void a(Bitmap r1) {
            this.f6677f.a(r1);     // Catch: Throwable -> L5
            r1.recycle();
            return;
        L5:
            th = move-exception;
            r1.recycle();
            throw th;
        }

        @Override // d.c.c.h.c
        public /* bridge */ /* synthetic */ void release(Bitmap r1) {
            a(r1);
        }
    }

    public b(int r4, int r5) {
        boolean r0 = true;
        if (r4 <= 0) goto L5;
        boolean r2 = true;
    L6:
        d.c.c.d.i.b(r2);
        if (r5 > 0) goto L10;
        r0 = false;
    L10:
        d.c.c.d.i.b(r0);
        this.f6674c = r4;
        this.f6675d = r5;
        this.f6676e = new a(this);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public synchronized void a(Bitmap r10) {
        monitor-enter(this);
        int r11 = com.facebook.imageutils.b.e(r10);     // Catch: Throwable -> L14
        if (this.f6672a <= 0) goto L6;
        boolean r0 = true;
    L7:
        d.c.c.d.i.c(r0, "No bitmaps registered.");     // Catch: Throwable -> L14
        long r3 = r11;
        if (r3 > this.f6673b) goto L10;
        boolean r1 = true;
    L11:
        d.c.c.d.i.d(r1, "Bitmap size bigger than the total registered size: %d, %d", new Object[]{Integer.valueOf(r11), Long.valueOf(this.f6673b)});     // Catch: Throwable -> L14
        this.f6673b -= r3;     // Catch: Throwable -> L14
        this.f6672a--;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        r1 = false;
        goto L11
    L6:
        r0 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized int b() {
        monitor-enter(this);
        int r0 = this.f6672a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int c() {
        monitor-enter(this);
        int r0 = this.f6674c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int d() {
        monitor-enter(this);
        int r0 = this.f6675d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public d.c.c.h.c<Bitmap> e() {
        return this.f6676e;
    }

    public synchronized long f() {
        monitor-enter(this);
        long r0 = this.f6673b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean g(Bitmap r10) {
        monitor-enter(this);
        int r11 = com.facebook.imageutils.b.e(r10);     // Catch: Throwable -> L14
        int r0 = this.f6672a;     // Catch: Throwable -> L14
        if (r0 >= this.f6674c) goto L12;
        long r1 = this.f6673b;     // Catch: Throwable -> L14
        long r3 = r11;
        if ((r1 + r3) > this.f6675d) goto L12;
        this.f6672a = r0 + 1;     // Catch: Throwable -> L14
        this.f6673b = r1 + r3;     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L12:
        monitor-exit(this);
        return false;
    L14:
        th = move-exception;
        throw th;
    }
}

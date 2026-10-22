package d.c.g.a.b.d;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.c.g.a.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.c.g.a.b.b.a f15771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.c.c.h.a<Bitmap> f15772c;

    public b() {
        this.f15770a = -1;
    }

    private synchronized void g() {
        monitor-enter(this);
        d.c.g.a.b.b.a r0 = this.f15771b;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        int r2 = this.f15770a;     // Catch: Throwable -> L11
        if (r2 == (-1)) goto L8;
        r0.a(this, r2);     // Catch: Throwable -> L11
    L8:
        d.c.c.h.a.L(this.f15772c);     // Catch: Throwable -> L11
        this.f15772c = null;     // Catch: Throwable -> L11
        this.f15770a = -1;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // d.c.g.a.b.b
    public synchronized d.c.c.h.a<Bitmap> a(int r1, int r2, int r3) {
        monitor-enter(this);
        d.c.c.h.a<Bitmap> r4 = d.c.c.h.a.E(this.f15772c);     // Catch: Throwable -> L7
        g();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r4;
    L10:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        g();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    }

    @Override // d.c.g.a.b.b
    public void b(int r1, d.c.c.h.a<Bitmap> r2, int r3) {
    }

    @Override // d.c.g.a.b.b
    public synchronized boolean c(int r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r2 != this.f15770a) goto L8;
        if (d.c.c.h.a.S(this.f15772c) == false) goto L8;
        boolean r3 = true;
    L9:
        monitor-exit(this);
        return r3;
    L8:
        r3 = false;
        goto L9
    }

    @Override // d.c.g.a.b.b
    public synchronized void clear() {
        monitor-enter(this);
        g();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.g.a.b.b
    public synchronized d.c.c.h.a<Bitmap> d(int r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f15770a != r2) goto L9;
        d.c.c.h.a<Bitmap> r3 = d.c.c.h.a.E(this.f15772c);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3;
    L9:
        monitor-exit(this);
        return null;
    }

    @Override // d.c.g.a.b.b
    public synchronized void e(int r3, d.c.c.h.a<Bitmap> r4, int r5) {
        monitor-enter(this);
        if (r4 != null) goto L24;
    L10:
        d.c.c.h.a.L(this.f15772c);     // Catch: Throwable -> L21
        d.c.g.a.b.b.a r6 = this.f15771b;     // Catch: Throwable -> L21
        if (r6 == null) goto L15;
        int r0 = this.f15770a;     // Catch: Throwable -> L21
        if (r0 == (-1)) goto L15;
        r6.a(this, r0);     // Catch: Throwable -> L21
    L15:
        this.f15772c = d.c.c.h.a.E(r4);     // Catch: Throwable -> L21
        d.c.g.a.b.b.a r7 = this.f15771b;     // Catch: Throwable -> L21
        if (r7 == null) goto L18;
        r7.b(this, r3);     // Catch: Throwable -> L21
    L18:
        this.f15770a = r3;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    L24:
        if (this.f15772c == null) goto L10;
        if (r4.N().equals(this.f15772c.N()) == false) goto L10;
        monitor-exit(this);
    }

    @Override // d.c.g.a.b.b
    public synchronized d.c.c.h.a<Bitmap> f(int r1) {
        monitor-enter(this);
        d.c.c.h.a<Bitmap> r2 = d.c.c.h.a.E(this.f15772c);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }
}

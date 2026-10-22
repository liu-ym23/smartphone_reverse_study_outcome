package d.c.g.a.b.d;

import android.graphics.Bitmap;
import android.util.SparseArray;
import d.c.c.d.i;
import d.c.i.l.d;
import d.c.i.l.g;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.c.g.a.b.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Class<?> f15764f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.c.c.c f15765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray<d.c.c.h.a<d.c.i.l.c>> f15767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.c.c.h.a<d.c.i.l.c> f15768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15769e;

    static {
        f15764f = a.class;
    }

    public a(d.c.i.c.c.c r2, boolean r3) {
        this.f15769e = -1;
        this.f15765a = r2;
        this.f15766b = r3;
        this.f15767c = new SparseArray();
    }

    static d.c.c.h.a<Bitmap> g(d.c.c.h.a<d.c.i.l.c> r1) {
    L13:
        th = move-exception;
        d.c.c.h.a.L(r1);
        throw th;
    L3:
        if (d.c.c.h.a.S(r1) == true) goto L5;
    L11:
        d.c.c.h.a.L(r1);
        return null;
    L5:
        if ((r1.N() instanceof d) == false) goto L11;
        d r0 = (d) r1.N();     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        d.c.c.h.a<Bitmap> r2 = r0.F();     // Catch: Throwable -> L13
        d.c.c.h.a.L(r1);
        return r2;
    }

    private static d.c.c.h.a<d.c.i.l.c> h(d.c.c.h.a<Bitmap> r3) {
        return d.c.c.h.a.V(new d(r3, g.f16188d, 0));
    }

    private synchronized void i(int r4) {
        monitor-enter(this);
        d.c.c.h.a<d.c.i.l.c> r0 = this.f15767c.get(r4);     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        this.f15767c.delete(r4);     // Catch: Throwable -> L8
        d.c.c.h.a.L(r0);     // Catch: Throwable -> L8
        d.c.c.e.a.t(f15764f, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(r4), this.f15767c);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // d.c.g.a.b.b
    public synchronized d.c.c.h.a<Bitmap> a(int r1, int r2, int r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f15766b == false) goto L6;
        d.c.c.h.a<Bitmap> r4 = g(this.f15765a.f());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    L6:
        monitor-exit(this);
        return null;
    }

    @Override // d.c.g.a.b.b
    public synchronized void b(int r3, d.c.c.h.a<Bitmap> r4, int r5) {
        monitor-enter(this);
        i.g(r4);     // Catch: Throwable -> L22
        d.c.c.h.a<d.c.i.l.c> r6 = h(r4);     // Catch: Throwable -> L19
        if (r6 != null) goto L10;
        d.c.c.h.a.L(r6);     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L10:
        d.c.c.h.a<d.c.i.l.c> r7 = this.f15765a.b(r3, r6);     // Catch: Throwable -> L19
        if (d.c.c.h.a.S(r7) == false) goto L14;
        d.c.c.h.a<d.c.i.l.c> r0 = this.f15767c.get(r3);     // Catch: Throwable -> L19
    L13:
        d.c.c.h.a.L(r0);     // Catch: Throwable -> L19
        this.f15767c.put(r3, r7);     // Catch: Throwable -> L19
        d.c.c.e.a.t(f15764f, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(r3), this.f15767c);     // Catch: Throwable -> L19
        d.c.c.h.a.L(r6);     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L14:
        r7 = r6.a();     // Catch: Throwable -> L19
        r0 = this.f15767c.get(r3);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        d.c.c.h.a.L(null);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    @Override // d.c.g.a.b.b
    public synchronized boolean c(int r2) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f15765a.d(r2) == true) goto L9;
        if (this.f15767c.get(r2) != null) goto L9;
        boolean r3 = false;
    L10:
        monitor-exit(this);
        return r3;
    L9:
        r3 = true;
        goto L10
    }

    @Override // d.c.g.a.b.b
    public synchronized void clear() {
        monitor-enter(this);
        d.c.c.h.a.L(this.f15768d);     // Catch: Throwable -> L13
        this.f15765a.c(this.f15769e);     // Catch: Throwable -> L13
        this.f15768d = null;     // Catch: Throwable -> L13
        this.f15769e = -1;     // Catch: Throwable -> L13
        int r0 = 0;
    L5:
        if (r0 >= this.f15767c.size()) goto L10;
        d.c.c.h.a<d.c.i.l.c> r1 = this.f15767c.valueAt(r0);     // Catch: Throwable -> L13
        if (r1 == null) goto L9;
        d.c.c.h.a.L(r1);     // Catch: Throwable -> L13
        this.f15765a.c(this.f15767c.keyAt(r0));     // Catch: Throwable -> L13
    L9:
        r0 = r0 + 1;     // Catch: Throwable -> L13
        goto L5
    L10:
        this.f15767c.clear();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
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
        if (this.f15765a.d(r2) == false) goto L8;
        d.c.c.h.a<Bitmap> r3 = g(this.f15765a.e(r2));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3;
    L8:
        d.c.c.h.a<Bitmap> r4 = g(d.c.c.h.a.E(this.f15767c.get(r2)));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    }

    @Override // d.c.g.a.b.b
    public synchronized void e(int r1, d.c.c.h.a<Bitmap> r2, int r3) {
        monitor-enter(this);
        i.g(r2);     // Catch: Throwable -> L14
        i(r1);     // Catch: Throwable -> L14
        d.c.c.h.a<d.c.i.l.c> r4 = null;
        r4 = h(r2);     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        d.c.c.h.a.L(this.f15768d);     // Catch: Throwable -> L11
        this.f15768d = this.f15765a.b(r1, r4);     // Catch: Throwable -> L11
        this.f15769e = r1;     // Catch: Throwable -> L11
    L8:
        d.c.c.h.a.L(r4);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        d.c.c.h.a.L(r4);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // d.c.g.a.b.b
    public synchronized d.c.c.h.a<Bitmap> f(int r1) {
        monitor-enter(this);
        d.c.c.h.a<Bitmap> r2 = g(d.c.c.h.a.E(this.f15768d));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }
}

package d.c.i.l;

import android.graphics.Bitmap;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
public class d extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d.c.c.h.a<Bitmap> f16173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile Bitmap f16174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final i f16175j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f16176k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f16177l;
    private final Rect m;
    private final Rect n;
    private final int o;

    public d(Bitmap r7, d.c.c.h.c<Bitmap> r8, i r9, int r10) {
        this(r7, r8, r9, r10, 0);
    }

    public d(Bitmap r10, d.c.c.h.c<Bitmap> r11, i r12, int r13, int r14) {
        this(r10, r11, r12, r13, r14, null, null, -1);
    }

    public d(Bitmap r1, d.c.c.h.c<Bitmap> r2, i r3, int r4, int r5, Rect r6, Rect r7, int r8) {
        d.c.c.d.i.g(r1);
        this.f16174i = r1;
        Bitmap r9 = this.f16174i;
        d.c.c.d.i.g(r2);
        this.f16173h = d.c.c.h.a.X(r9, r2);
        this.f16175j = r3;
        this.f16176k = r4;
        this.f16177l = r5;
        this.m = r6;
        this.n = r7;
        this.o = r8;
    }

    public d(d.c.c.h.a<Bitmap> r2, i r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public d(d.c.c.h.a<Bitmap> r9, i r10, int r11, int r12) {
        this(r9, r10, r11, r12, null, null, -1);
    }

    public d(d.c.c.h.a<Bitmap> r1, i r2, int r3, int r4, Rect r5, Rect r6, int r7) {
        d.c.c.h.a<Bitmap> r8 = r1.C();
        d.c.c.d.i.g(r8);
        d.c.c.h.a<Bitmap> r9 = r8;
        this.f16173h = r9;
        this.f16174i = r9.N();
        this.f16175j = r2;
        this.f16176k = r3;
        this.f16177l = r4;
        this.m = r5;
        this.n = r6;
        this.o = r7;
    }

    public d(d.c.c.h.a<Bitmap> r1, i r2, int r3, int r4, Rect r5, Rect r6, int r7, d.c.h.d r8) {
        d.c.c.h.a<Bitmap> r9 = r1.C();
        d.c.c.d.i.g(r9);
        d.c.c.h.a<Bitmap> r10 = r9;
        this.f16173h = r10;
        this.f16174i = r10.N();
        this.f16175j = r2;
        this.f16176k = r3;
        this.f16177l = r4;
        this.m = r5;
        this.n = r6;
        this.o = r7;
        this.f16171f = r8;
    }

    private synchronized d.c.c.h.a<Bitmap> L() {
        monitor-enter(this);
        d.c.c.h.a<Bitmap> r0 = this.f16173h;     // Catch: Throwable -> L6
        this.f16173h = null;     // Catch: Throwable -> L6
        this.f16174i = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private static int M(Bitmap r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getHeight();
    }

    private static int N(Bitmap r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getWidth();
    }

    @Override // d.c.i.l.b
    public Bitmap E() {
        return this.f16174i;
    }

    public synchronized d.c.c.h.a<Bitmap> F() {
        monitor-enter(this);
        d.c.c.h.a<Bitmap> r0 = d.c.c.h.a.E(this.f16173h);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int O() {
        return this.f16177l;
    }

    public Rect Q() {
        return this.m;
    }

    public int S() {
        return this.f16176k;
    }

    public int V() {
        return this.o;
    }

    public Rect X() {
        return this.n;
    }

    @Override // d.c.i.l.f
    public int b() {
        return 1;
    }

    @Override // d.c.i.l.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d.c.c.h.a<Bitmap> r0 = L();
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    @Override // d.c.i.l.f
    public int getHeight() {
        if ((this.f16176k % 180) != 0) goto L12;
        int r0 = this.f16177l;
        if (r0 == 5) goto L12;
        if (r0 == 7) goto L12;
        return M(this.f16174i);
    L12:
        return N(this.f16174i);
    }

    @Override // d.c.i.l.f
    public int getWidth() {
        if ((this.f16176k % 180) != 0) goto L12;
        int r0 = this.f16177l;
        if (r0 == 5) goto L12;
        if (r0 == 7) goto L12;
        return N(this.f16174i);
    L12:
        return M(this.f16174i);
    }

    @Override // d.c.i.l.c
    public synchronized boolean isClosed() {
        monitor-enter(this);
        if (this.f16173h != null) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // d.c.i.l.c
    public i s() {
        return this.f16175j;
    }

    @Override // d.c.i.l.c
    public int x() {
        return com.facebook.imageutils.b.e(this.f16174i);
    }
}

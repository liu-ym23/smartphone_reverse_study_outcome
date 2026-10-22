package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes2.dex */
public class y extends d.c.c.g.k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final u f6748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.c.c.h.a<t> f6749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6750h;

    public static class a extends RuntimeException {
        public a() {
            super("OutputStream no longer valid");
        }
    }

    public y(u r2) {
        this(r2, r2.B());
    }

    public y(u r3, int r4) {
        if (r4 <= 0) goto L5;
        boolean r1 = true;
    L6:
        d.c.c.d.i.b(r1);
        d.c.c.d.i.g(r3);
        u r5 = r3;
        this.f6748f = r5;
        this.f6750h = 0;
        this.f6749g = d.c.c.h.a.X(r5.get(r4), r5);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void b() {
        if (d.c.c.h.a.S(this.f6749g) == false) goto L6;
        return;
    L6:
        throw new a();
    }

    @Override // d.c.c.g.k
    public /* bridge */ /* synthetic */ d.c.c.g.h a() {
        return l();
    }

    @Override // d.c.c.g.k, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d.c.c.h.a.L(this.f6749g);
        this.f6749g = null;
        this.f6750h = -1;
        super.close();
    }

    void g(int r4) {
        b();
        if (r4 > this.f6749g.N().a()) goto L5;
        return;
    L5:
        t r5 = this.f6748f.get(r4);
        this.f6749g.N().g(0, r5, 0, this.f6750h);
        this.f6749g.close();
        this.f6749g = d.c.c.h.a.X(r5, this.f6748f);
    }

    public w l() {
        b();
        return new w(this.f6749g, this.f6750h);
    }

    @Override // d.c.c.g.k
    public int size() {
        return this.f6750h;
    }

    @Override // java.io.OutputStream
    public void write(int r3) {
        write(new byte[]{(byte) r3});
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3, int r4, int r5) {
        if (r4 < 0) goto L9;
        if (r5 < 0) goto L9;
        if ((r4 + r5) > r3.length) goto L9;
        b();
        g(this.f6750h + r5);
        this.f6749g.N().l(this.f6750h, r3, r4, r5);
        this.f6750h += r5;
        return;
    L9:
        throw new ArrayIndexOutOfBoundsException("length=" + r3.length + "; regionStart=" + r4 + "; regionLength=" + r5);
    }
}

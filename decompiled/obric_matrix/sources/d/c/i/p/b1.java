package d.c.i.p;

/* JADX INFO: loaded from: classes2.dex */
public class b1 implements k0<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c1<d.c.i.l.e>[] f16221a;

    private class a extends n<d.c.i.l.e, d.c.i.l.e> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final l0 f16222c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f16223d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d.c.i.f.f f16224e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b1 f16225f;

        public a(b1 r1, k<d.c.i.l.e> r2, l0 r3, int r4) {
            this.f16225f = r1;
            super(r2);
            this.f16222c = r3;
            this.f16223d = r4;
            this.f16224e = r3.c().r();
        }

        @Override // d.c.i.p.n, d.c.i.p.b
        protected void h(Throwable r5) {
            if (b1.c(this.f16225f, this.f16223d + 1, p(), this.f16222c) == true) goto L6;
            p().a(r5);
            return;
        }

        @Override // d.c.i.p.b
        protected /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            q((d.c.i.l.e) r1, r2);
        }

        protected void q(d.c.i.l.e r4, int r5) {
            if (r4 == null) goto L9;
            if (b.f(r5) == false) goto L6;
        L7:
            p().d(r4, r5);
            return;
        L6:
            if (d1.c(r4, this.f16224e) == true) goto L7;
        L9:
            if (b.e(r5) == false) goto L15;
            d.c.i.l.e.g(r4);
            if (b1.c(this.f16225f, this.f16223d + 1, p(), this.f16222c) == true) goto L16;
            p().d(null, 1);
            return;
        L16:
            return;
        }
    }

    public b1(c1<d.c.i.l.e>... r1) {
        d.c.c.d.i.g(r1);
        c1<d.c.i.l.e>[] r2 = r1;
        this.f16221a = r2;
        d.c.c.d.i.e(0, r2.length);
    }

    static /* synthetic */ boolean c(b1 r0, int r1, k r2, l0 r3) {
        return r0.e(r1, r2, r3);
    }

    private int d(int r3, d.c.i.f.f r4) {
    L2:
        c1<d.c.i.l.e>[] r0 = this.f16221a;
        if (r3 >= r0.length) goto L8;
        if (r0[r3].a(r4) == true) goto L6;
        r3 = r3 + 1;
        goto L2
    L6:
        return r3;
    L8:
        return -1;
    }

    private boolean e(int r3, k<d.c.i.l.e> r4, l0 r5) {
        int r6 = d(r3, r5.c().r());
        if (r6 != (-1)) goto L6;
        return false;
    L6:
        this.f16221a[r6].b(new a(this, r4, r5, r6), r5);
        return true;
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r4, l0 r5) {
        if (r5.c().r() != null) goto L6;
    L4:
        r4.d(null, 1);
        return;
    L6:
        if (e(0, r4, r5) == false) goto L4;
    }
}

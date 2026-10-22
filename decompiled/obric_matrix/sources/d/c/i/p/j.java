package d.c.i.p;

/* JADX INFO: loaded from: classes2.dex */
public class j implements k0<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k0<d.c.i.l.e> f16307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k0<d.c.i.l.e> f16308b;

    static /* synthetic */ class a {
    }

    private class b extends n<d.c.i.l.e, d.c.i.l.e> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private l0 f16309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ j f16310d;

        private b(j r1, k<d.c.i.l.e> r2, l0 r3) {
            this.f16310d = r1;
            super(r2);
            this.f16309c = r3;
        }

        /* synthetic */ b(j r1, k r2, l0 r3, a r4) {
            this(r1, r2, r3);
        }

        @Override // d.c.i.p.n, d.c.i.p.b
        protected void h(Throwable r2) {
            j.c(this.f16310d).b(p(), this.f16309c);
        }

        @Override // d.c.i.p.b
        protected /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            q((d.c.i.l.e) r1, r2);
        }

        protected void q(d.c.i.l.e r4, int r5) {
            d.c.i.q.b r0 = this.f16309c.c();
            boolean r1 = d.c.i.p.b.e(r5);
            boolean r2 = d1.c(r4, r0.r());
            if (r4 == null) goto L12;
            if (r2 == false) goto L6;
        L7:
            if (r1 == false) goto L10;
            if (r2 == false) goto L10;
        L11:
            p().d(r4, r5);
        L10:
            r5 = d.c.i.p.b.o(r5, 1);
            goto L11
        L6:
            if (r0.h() == true) goto L7;
        L12:
            if (r1 == false) goto L16;
            if (r2 == true) goto L17;
            d.c.i.l.e.g(r4);
            j.c(this.f16310d).b(p(), this.f16309c);
            return;
        L17:
            return;
        }
    }

    public j(k0<d.c.i.l.e> r1, k0<d.c.i.l.e> r2) {
        this.f16307a = r1;
        this.f16308b = r2;
    }

    static /* synthetic */ k0 c(j r0) {
        return r0.f16308b;
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r3, l0 r4) {
        b r0 = new b(this, r3, r4, null);
        this.f16307a.b(r0, r4);
    }
}

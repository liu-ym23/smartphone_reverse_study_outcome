package d.c.i.p;

/* JADX INFO: loaded from: classes2.dex */
public class a implements k0<d.c.i.l.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k0<d.c.i.l.e> f16206a;

    /* JADX INFO: renamed from: d.c.i.p.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0430a {
    }

    private static class b extends n<d.c.i.l.e, d.c.i.l.e> {
        private b(k<d.c.i.l.e> r1) {
            super(r1);
        }

        /* synthetic */ b(k r1, C0430a r2) {
            this(r1);
        }

        @Override // d.c.i.p.b
        protected /* bridge */ /* synthetic */ void i(Object r1, int r2) {
            q((d.c.i.l.e) r1, r2);
        }

        protected void q(d.c.i.l.e r2, int r3) {
            if (r2 != null) goto L7;
            k<d.c.i.l.e> r1 = p();
            r2 = null;
        L4:
            r1.d(r2, r3);
            return;
        L7:
            if (d.c.i.l.e.n0(r2) == true) goto L9;
            r2.r0();
        L9:
            r1 = p();
            goto L4
        }
    }

    public a(k0<d.c.i.l.e> r1) {
        this.f16206a = r1;
    }

    @Override // d.c.i.p.k0
    public void b(k<d.c.i.l.e> r3, l0 r4) {
        this.f16206a.b(new b(r3, null), r4);
    }
}

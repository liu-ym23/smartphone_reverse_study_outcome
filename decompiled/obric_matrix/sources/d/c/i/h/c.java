package d.c.i.h;

import d.c.i.p.k0;
import d.c.i.p.t0;

/* JADX INFO: loaded from: classes2.dex */
public class c<T> extends a<d.c.c.h.a<T>> {
    private c(k0<d.c.c.h.a<T>> r1, t0 r2, d.c.i.m.d r3) {
        super(r1, r2, r3);
    }

    public static <T> d.c.d.c<d.c.c.h.a<T>> B(k0<d.c.c.h.a<T>> r1, t0 r2, d.c.i.m.d r3) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("CloseableProducerToDataSourceAdapter#create");
    L5:
        c r0 = new c(r1, r2, r3);
        if (d.c.i.r.b.d() == false) goto L8;
        d.c.i.r.b.b();
    L8:
        return r0;
    }

    protected void A(d.c.c.h.a<T> r1) {
        d.c.c.h.a.L(r1);
    }

    public d.c.c.h.a<T> C() {
        return d.c.c.h.a.E((d.c.c.h.a) super.e());
    }

    protected void D(d.c.c.h.a<T> r1, int r2) {
        super.z(d.c.c.h.a.E(r1), r2);
    }

    @Override // d.c.d.a, d.c.d.c
    public /* bridge */ /* synthetic */ Object e() {
        return C();
    }

    @Override // d.c.d.a
    protected /* bridge */ /* synthetic */ void g(Object r1) {
        A((d.c.c.h.a) r1);
    }

    @Override // d.c.i.h.a
    protected /* bridge */ /* synthetic */ void z(Object r1, int r2) {
        D((d.c.c.h.a) r1, r2);
    }
}

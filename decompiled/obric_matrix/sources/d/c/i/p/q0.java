package d.c.i.p;

import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public class q0 extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.c.i.e.f f16396d;

    public q0(d.c.i.e.f r1, k0 r2) {
        super(r1, r2);
        this.f16396d = r1;
    }

    private String k(l0 r1) {
        if (r1.c().A() == true) goto L7;
        return r1.getId();
    L7:
        return String.valueOf(r1.h().b());
    }

    @Override // d.c.i.p.r, d.c.i.p.e0
    protected /* bridge */ /* synthetic */ Pair<d.c.b.a.d, String> i(l0 r1) {
        return m(r1);
    }

    @Override // d.c.i.p.r
    protected Pair<d.c.b.a.d, String> m(l0 r4) {
        d.c.i.q.b r0 = r4.c();
        return Pair.create(this.f16396d.b(r0, r4.a()), k(r4));
    }
}

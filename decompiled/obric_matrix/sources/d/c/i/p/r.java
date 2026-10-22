package d.c.i.p;

import android.util.Pair;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public class r extends e0<Pair<d.c.b.a.d, String>, d.c.i.l.e> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.c.i.e.f f16397c;

    public r(d.c.i.e.f r1, k0 r2) {
        super(r2);
        this.f16397c = r1;
    }

    private String k(l0 r1) {
        if (r1.c().A() == true) goto L7;
        return r1.getId();
    L7:
        return String.valueOf(r1.h().b());
    }

    @Override // d.c.i.p.e0
    public /* bridge */ /* synthetic */ Closeable f(Closeable r1) {
        return l((d.c.i.l.e) r1);
    }

    @Override // d.c.i.p.e0
    protected /* bridge */ /* synthetic */ Pair<d.c.b.a.d, String> i(l0 r1) {
        return m(r1);
    }

    public d.c.i.l.e l(d.c.i.l.e r1) {
        return d.c.i.l.e.b(r1);
    }

    protected Pair<d.c.b.a.d, String> m(l0 r4) {
        return Pair.create(this.f16397c.e(r4.c(), r4.a()), k(r4));
    }
}

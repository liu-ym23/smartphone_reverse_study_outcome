package l.b.g.a;

import l.b.a.c1;
import l.b.a.t;
import l.b.a.u;

/* JADX INFO: loaded from: classes2.dex */
public class h extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final l.b.a.l f21954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l.b.a.v2.a f21955g;

    private h(u r2) {
        this.f21954f = l.b.a.l.w(r2.y(0));
        this.f21955g = l.b.a.v2.a.o(r2.y(1));
    }

    public h(l.b.a.v2.a r4) {
        this.f21954f = new l.b.a.l(0);
        this.f21955g = r4;
    }

    public static final h n(Object r1) {
        if ((r1 instanceof h) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new h(u.w(r1));
    L5:
        return (h) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        r0.a(this.f21954f);
        r0.a(this.f21955g);
        return new c1(r0);
    }

    public l.b.a.v2.a o() {
        return this.f21955g;
    }
}

package l.b.g.a;

import l.b.a.c1;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.a.y0;

/* JADX INFO: loaded from: classes2.dex */
public class b extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final l.b.g.d.a.a f21917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final l.b.a.v2.a f21918i;

    public b(int r1, int r2, l.b.g.d.a.a r3, l.b.a.v2.a r4) {
        this.f21915f = r1;
        this.f21916g = r2;
        this.f21917h = new l.b.g.d.a.a(r3.c());
        this.f21918i = r4;
    }

    private b(u r3) {
        this.f21915f = ((l.b.a.l) r3.y(0)).B();
        this.f21916g = ((l.b.a.l) r3.y(1)).B();
        this.f21917h = new l.b.g.d.a.a(((p) r3.y(2)).y());
        this.f21918i = l.b.a.v2.a.o(r3.y(3));
    }

    public static b p(Object r1) {
        if ((r1 instanceof b) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new b(u.w(r1));
    L5:
        return (b) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        r0.a(new l.b.a.l(this.f21915f));
        r0.a(new l.b.a.l(this.f21916g));
        r0.a(new y0(this.f21917h.c()));
        r0.a(this.f21918i);
        return new c1(r0);
    }

    public l.b.a.v2.a n() {
        return this.f21918i;
    }

    public l.b.g.d.a.a o() {
        return this.f21917h;
    }

    public int q() {
        return this.f21915f;
    }

    public int r() {
        return this.f21916g;
    }
}

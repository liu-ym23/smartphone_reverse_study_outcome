package l.b.g.a;

import l.b.a.c1;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.a.y0;

/* JADX INFO: loaded from: classes2.dex */
public class d extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final l.b.g.d.a.a f21928h;

    public d(int r1, int r2, l.b.g.d.a.a r3) {
        this.f21926f = r1;
        this.f21927g = r2;
        this.f21928h = new l.b.g.d.a.a(r3);
    }

    private d(u r3) {
        this.f21926f = ((l.b.a.l) r3.y(0)).B();
        this.f21927g = ((l.b.a.l) r3.y(1)).B();
        this.f21928h = new l.b.g.d.a.a(((p) r3.y(2)).y());
    }

    public static d o(Object r1) {
        if ((r1 instanceof d) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new d(u.w(r1));
    L5:
        return (d) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        r0.a(new l.b.a.l(this.f21926f));
        r0.a(new l.b.a.l(this.f21927g));
        r0.a(new y0(this.f21928h.c()));
        return new c1(r0);
    }

    public l.b.g.d.a.a n() {
        return new l.b.g.d.a.a(this.f21928h);
    }

    public int p() {
        return this.f21926f;
    }

    public int q() {
        return this.f21927g;
    }
}

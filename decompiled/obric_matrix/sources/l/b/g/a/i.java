package l.b.g.a;

import l.b.a.c1;
import l.b.a.t;
import l.b.a.u;

/* JADX INFO: loaded from: classes2.dex */
public class i extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final l.b.a.l f21956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final l.b.a.v2.a f21958h;

    public i(int r4, l.b.a.v2.a r5) {
        this.f21956f = new l.b.a.l(0);
        this.f21957g = r4;
        this.f21958h = r5;
    }

    private i(u r2) {
        this.f21956f = l.b.a.l.w(r2.y(0));
        this.f21957g = l.b.a.l.w(r2.y(1)).B();
        this.f21958h = l.b.a.v2.a.o(r2.y(2));
    }

    public static i o(Object r1) {
        if ((r1 instanceof i) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new i(u.w(r1));
    L5:
        return (i) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        r0.a(this.f21956f);
        r0.a(new l.b.a.l(this.f21957g));
        r0.a(this.f21958h);
        return new c1(r0);
    }

    public int n() {
        return this.f21957g;
    }

    public l.b.a.v2.a p() {
        return this.f21958h;
    }
}

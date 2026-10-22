package l.b.g.a;

import l.b.a.c1;
import l.b.a.t;
import l.b.a.u;

/* JADX INFO: loaded from: classes2.dex */
public class j extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final l.b.a.l f21959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f21961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final l.b.a.v2.a f21962i;

    public j(int r4, int r5, l.b.a.v2.a r6) {
        this.f21959f = new l.b.a.l(0);
        this.f21960g = r4;
        this.f21961h = r5;
        this.f21962i = r6;
    }

    private j(u r2) {
        this.f21959f = l.b.a.l.w(r2.y(0));
        this.f21960g = l.b.a.l.w(r2.y(1)).B();
        this.f21961h = l.b.a.l.w(r2.y(2)).B();
        this.f21962i = l.b.a.v2.a.o(r2.y(3));
    }

    public static j o(Object r1) {
        if ((r1 instanceof j) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new j(u.w(r1));
    L5:
        return (j) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        r0.a(this.f21959f);
        r0.a(new l.b.a.l(this.f21960g));
        r0.a(new l.b.a.l(this.f21961h));
        r0.a(this.f21962i);
        return new c1(r0);
    }

    public int n() {
        return this.f21960g;
    }

    public int p() {
        return this.f21961h;
    }

    public l.b.a.v2.a q() {
        return this.f21962i;
    }
}

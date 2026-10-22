package l.b.a.v2;

import l.b.a.c1;
import l.b.a.n;
import l.b.a.o;
import l.b.a.p;
import l.b.a.t;

/* JADX INFO: loaded from: classes2.dex */
public class c extends n {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final o f21773i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private o f21774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f21775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private p f21776h;

    static {
        new o("2.5.29.9").C();
        new o("2.5.29.14").C();
        new o("2.5.29.15").C();
        new o("2.5.29.16").C();
        new o("2.5.29.17").C();
        new o("2.5.29.18").C();
        f21773i = new o("2.5.29.19").C();
        new o("2.5.29.20").C();
        new o("2.5.29.21").C();
        new o("2.5.29.23").C();
        new o("2.5.29.24").C();
        new o("2.5.29.27").C();
        new o("2.5.29.28").C();
        new o("2.5.29.29").C();
        new o("2.5.29.30").C();
        new o("2.5.29.31").C();
        new o("2.5.29.32").C();
        new o("2.5.29.33").C();
        new o("2.5.29.35").C();
        new o("2.5.29.36").C();
        new o("2.5.29.37").C();
        new o("2.5.29.46").C();
        new o("2.5.29.54").C();
        new o("1.3.6.1.5.5.7.1.1").C();
        new o("1.3.6.1.5.5.7.1.11").C();
        new o("1.3.6.1.5.5.7.1.12").C();
        new o("1.3.6.1.5.5.7.1.2").C();
        new o("1.3.6.1.5.5.7.1.3").C();
        new o("1.3.6.1.5.5.7.1.4").C();
        new o("2.5.29.56").C();
        new o("2.5.29.55").C();
        new o("2.5.29.60").C();
    }

    public c(o r1, boolean r2, p r3) {
        this.f21774f = r1;
        this.f21775g = r2;
        this.f21776h = r3;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f(3);
        r0.a(this.f21774f);
        if (this.f21775g == false) goto L5;
        r0.a(l.b.a.c.x(true));
    L5:
        r0.a(this.f21776h);
        return new c1(r0);
    }

    @Override // l.b.a.n
    public boolean equals(Object r4) {
        if ((r4 instanceof c) == true) goto L5;
        return false;
    L5:
        c r5 = (c) r4;
        if (r5.n().r(n()) == true) goto L8;
        return false;
    L8:
        if (r5.o().r(o()) == true) goto L10;
        return false;
    L10:
        if (r5.p() != p()) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // l.b.a.n
    public int hashCode() {
        if (p() == false) goto L6;
        int r0 = o().hashCode();
        return n().hashCode() ^ r0;
    L6:
        int r1 = o().hashCode();
        return ~(n().hashCode() ^ r1);
    }

    public o n() {
        return this.f21774f;
    }

    public p o() {
        return this.f21776h;
    }

    public boolean p() {
        return this.f21775g;
    }
}

package l.b.a.r2;

import java.math.BigInteger;
import l.b.a.a0;
import l.b.a.c1;
import l.b.a.f1;
import l.b.a.l;
import l.b.a.n;
import l.b.a.t;
import l.b.a.u;
import l.b.a.w0;

/* JADX INFO: loaded from: classes2.dex */
public class f extends n {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l.b.a.v2.a f21698j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l.b.a.v2.a f21699k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final l f21700l = null;
    public static final l m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l.b.a.v2.a f21701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l.b.a.v2.a f21702g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private l f21703h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private l f21704i;

    static {
        l.b.a.v2.a r0 = new l.b.a.v2.a(l.b.a.q2.a.f21665a, w0.f21794f);
        f21698j = r0;
        f21699k = new l.b.a.v2.a(d.f21687g, r0);
        f21700l = new l(20);
        m = new l(1);
    }

    public f() {
        this.f21701f = f21698j;
        this.f21702g = f21699k;
        this.f21703h = f21700l;
        this.f21704i = m;
    }

    private f(u r6) {
        this.f21701f = f21698j;
        this.f21702g = f21699k;
        this.f21703h = f21700l;
        this.f21704i = m;
        int r0 = 0;
    L4:
        if (r0 == r6.size()) goto L19;
        a0 r1 = (a0) r6.y(r0);
        int r2 = r1.y();
        if (r2 == 0) goto L17;
        if (r2 != 1) goto L9;
        this.f21702g = l.b.a.v2.a.p(r1, true);
    L18:
        r0 = r0 + 1;
        goto L4
    L9:
        if (r2 != 2) goto L11;
        this.f21703h = l.x(r1, true);
        goto L18
    L11:
        if (r2 != 3) goto L14;
        this.f21704i = l.x(r1, true);
        goto L18
    L14:
        throw new IllegalArgumentException("unknown tag");
    L17:
        this.f21701f = l.b.a.v2.a.p(r1, true);
        goto L18
    }

    public f(l.b.a.v2.a r1, l.b.a.v2.a r2, l r3, l r4) {
        this.f21701f = r1;
        this.f21702g = r2;
        this.f21703h = r3;
        this.f21704i = r4;
    }

    public static f o(Object r1) {
        if ((r1 instanceof f) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new f(u.w(r1));
    L5:
        return (f) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f(4);
        if (this.f21701f.equals(f21698j) == true) goto L6;
        r0.a(new f1(true, 0, this.f21701f));
    L6:
        if (this.f21702g.equals(f21699k) == true) goto L9;
        r0.a(new f1(true, 1, this.f21702g));
    L9:
        if (this.f21703h.r(f21700l) == true) goto L12;
        r0.a(new f1(true, 2, this.f21703h));
    L12:
        if (this.f21704i.r(m) == true) goto L15;
        r0.a(new f1(true, 3, this.f21704i));
    L15:
        return new c1(r0);
    }

    public l.b.a.v2.a n() {
        return this.f21701f;
    }

    public l.b.a.v2.a p() {
        return this.f21702g;
    }

    public BigInteger q() {
        return this.f21703h.y();
    }
}

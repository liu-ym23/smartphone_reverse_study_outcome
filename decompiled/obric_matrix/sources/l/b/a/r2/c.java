package l.b.a.r2;

import java.util.Enumeration;
import l.b.a.c1;
import l.b.a.f1;
import l.b.a.l;
import l.b.a.n;
import l.b.a.t;
import l.b.a.w;

/* JADX INFO: loaded from: classes2.dex */
public class c extends n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    l f21676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    l.b.a.u2.c f21677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    l.b.a.v2.f f21678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    w f21679i;

    public c(l.b.a.u2.c r4, l.b.a.v2.f r5, w r6) {
        this.f21676f = new l(0);
        this.f21679i = null;
        if (r4 == null) goto L8;
        if (r5 == null) goto L8;
        n(r6);
        this.f21677g = r4;
        this.f21678h = r5;
        this.f21679i = r6;
        return;
    L8:
        throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
    }

    private static void n(w r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Enumeration r4 = r3.A();
    L6:
        if (r4.hasMoreElements() == false) goto L14;
        a r0 = a.p(r4.nextElement());
        if (r0.n().r(d.y) == false) goto L6;
        if (r0.o().size() == 1) goto L6;
        throw new IllegalArgumentException("challengePassword attribute must have one value");
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f(4);
        r0.a(this.f21676f);
        r0.a(this.f21677g);
        r0.a(this.f21678h);
        w r3 = this.f21679i;
        if (r3 == null) goto L6;
        r0.a(new f1(false, 0, r3));
    L6:
        return new c1(r0);
    }
}

package l.b.a.v2;

import java.util.Enumeration;
import l.b.a.c1;
import l.b.a.n;
import l.b.a.p0;
import l.b.a.t;
import l.b.a.u;

/* JADX INFO: loaded from: classes2.dex */
public class f extends n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f21781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private p0 f21782g;

    public f(u r3) {
        if (r3.size() != 2) goto L7;
        Enumeration r4 = r3.z();
        this.f21781f = a.o(r4.nextElement());
        this.f21782g = p0.A(r4.nextElement());
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r3.size());
    }

    public f(a r2, l.b.a.e r3) {
        this.f21782g = new p0(r3);
        this.f21781f = r2;
    }

    public f(a r2, byte[] r3) {
        this.f21782g = new p0(r3);
        this.f21781f = r2;
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
        l.b.a.f r0 = new l.b.a.f(2);
        r0.a(this.f21781f);
        r0.a(this.f21782g);
        return new c1(r0);
    }

    public a n() {
        return this.f21781f;
    }

    public p0 p() {
        return this.f21782g;
    }

    public t q() {
        return t.s(this.f21782g.y());
    }
}

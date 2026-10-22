package l.b.g.a;

import java.math.BigInteger;
import l.b.a.c1;
import l.b.a.p;
import l.b.a.t;
import l.b.a.u;
import l.b.a.y0;

/* JADX INFO: loaded from: classes2.dex */
public class n extends l.b.a.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f21979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f21980g;

    private n(u r4) {
        if (l.b.a.l.w(r4.y(0)).z(BigInteger.valueOf(0)) == false) goto L7;
        this.f21979f = l.b.h.a.d(p.w(r4.y(1)).y());
        this.f21980g = l.b.h.a.d(p.w(r4.y(2)).y());
        return;
    L7:
        throw new IllegalArgumentException("unknown version of sequence");
    }

    public n(byte[] r1, byte[] r2) {
        this.f21979f = l.b.h.a.d(r1);
        this.f21980g = l.b.h.a.d(r2);
    }

    public static n n(Object r1) {
        if ((r1 instanceof n) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new n(u.w(r1));
    L5:
        return (n) r1;
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f();
        r0.a(new l.b.a.l(0));
        r0.a(new y0(this.f21979f));
        r0.a(new y0(this.f21980g));
        return new c1(r0);
    }

    public byte[] o() {
        return l.b.h.a.d(this.f21979f);
    }

    public byte[] p() {
        return l.b.h.a.d(this.f21980g);
    }
}

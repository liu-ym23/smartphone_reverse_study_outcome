package l.b.a.r2;

import java.math.BigInteger;
import java.util.Enumeration;
import l.b.a.a0;
import l.b.a.c1;
import l.b.a.f1;
import l.b.a.l;
import l.b.a.n;
import l.b.a.p;
import l.b.a.p0;
import l.b.a.t;
import l.b.a.u;
import l.b.a.w;
import l.b.a.y0;

/* JADX INFO: loaded from: classes2.dex */
public class e extends n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l f21693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l.b.a.v2.a f21694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private p f21695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private w f21696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private l.b.a.b f21697j;

    private e(u r6) {
        Enumeration r7 = r6.z();
        l r0 = l.w(r7.nextElement());
        this.f21693f = r0;
        int r1 = r(r0);
        this.f21694g = l.b.a.v2.a.o(r7.nextElement());
        this.f21695h = p.w(r7.nextElement());
        int r2 = -1;
    L4:
        if (r7.hasMoreElements() == false) goto L21;
        a0 r3 = (a0) r7.nextElement();
        int r4 = r3.y();
        if (r4 <= r2) goto L20;
        if (r4 != 0) goto L10;
        this.f21696i = w.y(r3, false);
    L18:
        r2 = r4;
        goto L4
    L10:
        if (r4 != 1) goto L16;
        if (r1 < 1) goto L14;
        this.f21697j = p0.B(r3, false);
        goto L18
    L14:
        throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
    L16:
        throw new IllegalArgumentException("unknown optional field in private key info");
    L20:
        throw new IllegalArgumentException("invalid optional field in private key info");
    }

    public e(l.b.a.v2.a r2, l.b.a.e r3) {
        this(r2, r3, null, null);
    }

    public e(l.b.a.v2.a r2, l.b.a.e r3, w r4) {
        this(r2, r3, r4, null);
    }

    public e(l.b.a.v2.a r3, l.b.a.e r4, w r5, byte[] r6) {
        if (r6 == null) goto L5;
        BigInteger r1 = l.b.h.b.f22286b;
    L6:
        this.f21693f = new l(r1);
        this.f21694g = r3;
        this.f21695h = new y0(r4);
        this.f21696i = r5;
        if (r6 != null) goto L9;
        p0 r7 = null;
    L10:
        this.f21697j = r7;
        return;
    L9:
        r7 = new p0(r6);
        goto L10
    L5:
        r1 = l.b.h.b.f22285a;
        goto L6
    }

    public static e o(Object r1) {
        if ((r1 instanceof e) == true) goto L5;
        if (r1 != null) goto L8;
        return null;
    L8:
        return new e(u.w(r1));
    L5:
        return (e) r1;
    }

    private static int r(l r1) {
        int r2 = r1.B();
        if (r2 < 0) goto L8;
        if (r2 > 1) goto L8;
        return r2;
    L8:
        throw new IllegalArgumentException("invalid version for private key info");
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f(5);
        r0.a(this.f21693f);
        r0.a(this.f21694g);
        r0.a(this.f21695h);
        w r1 = this.f21696i;
        if (r1 == null) goto L5;
        r0.a(new f1(false, 0, r1));
    L5:
        l.b.a.b r4 = this.f21697j;
        if (r4 == null) goto L9;
        r0.a(new f1(false, 1, r4));
    L9:
        return new c1(r0);
    }

    public w n() {
        return this.f21696i;
    }

    public l.b.a.v2.a p() {
        return this.f21694g;
    }

    public l.b.a.b q() {
        return this.f21697j;
    }

    public l.b.a.e s() {
        return t.s(this.f21695h.y());
    }
}

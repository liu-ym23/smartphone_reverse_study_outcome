package l.b.g.c.a.c;

import l.b.a.w0;

/* JADX INFO: loaded from: classes2.dex */
class g {
    static l.b.a.v2.a a(String r3) {
        if (r3.equals("SHA-1") == false) goto L7;
        return new l.b.a.v2.a(l.b.a.q2.a.f21665a, w0.f21794f);
    L7:
        if (r3.equals("SHA-224") == false) goto L11;
        return new l.b.a.v2.a(l.b.a.o2.a.f21652f, w0.f21794f);
    L11:
        if (r3.equals("SHA-256") == false) goto L15;
        return new l.b.a.v2.a(l.b.a.o2.a.f21649c, w0.f21794f);
    L15:
        if (r3.equals("SHA-384") == false) goto L19;
        return new l.b.a.v2.a(l.b.a.o2.a.f21650d, w0.f21794f);
    L19:
        if (r3.equals("SHA-512") == false) goto L23;
        return new l.b.a.v2.a(l.b.a.o2.a.f21651e, w0.f21794f);
    L23:
        throw new IllegalArgumentException("unrecognised digest algorithm: " + r3);
    }

    static l.b.b.a b(l.b.a.v2.a r3) {
        if (r3.n().r(l.b.a.q2.a.f21665a) == false) goto L7;
        return l.b.b.e.a.a();
    L7:
        if (r3.n().r(l.b.a.o2.a.f21652f) == false) goto L11;
        return l.b.b.e.a.b();
    L11:
        if (r3.n().r(l.b.a.o2.a.f21649c) == false) goto L15;
        return l.b.b.e.a.c();
    L15:
        if (r3.n().r(l.b.a.o2.a.f21650d) == false) goto L19;
        return l.b.b.e.a.d();
    L19:
        if (r3.n().r(l.b.a.o2.a.f21651e) == false) goto L23;
        return l.b.b.e.a.e();
    L23:
        throw new IllegalArgumentException("unrecognised OID in digest algorithm identifier: " + r3.n());
    }
}

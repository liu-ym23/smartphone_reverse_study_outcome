package l.b.g.b.g;

import java.util.HashMap;
import java.util.Map;
import l.b.a.o;
import l.b.b.c.f;
import l.b.b.c.h;
import l.b.b.c.i;

/* JADX INFO: loaded from: classes2.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final l.b.a.v2.a f22074a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final l.b.a.v2.a f22075b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final l.b.a.v2.a f22076c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final l.b.a.v2.a f22077d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final l.b.a.v2.a f22078e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final l.b.a.v2.a f22079f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final l.b.a.v2.a f22080g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final l.b.a.v2.a f22081h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final Map f22082i = null;

    static {
        o r1 = l.b.g.a.e.q;
        f22074a = new l.b.a.v2.a(r1);
        o r2 = l.b.g.a.e.r;
        f22075b = new l.b.a.v2.a(r2);
        f22076c = new l.b.a.v2.a(l.b.a.o2.a.f21655i);
        f22077d = new l.b.a.v2.a(l.b.a.o2.a.f21653g);
        f22078e = new l.b.a.v2.a(l.b.a.o2.a.f21649c);
        f22079f = new l.b.a.v2.a(l.b.a.o2.a.f21651e);
        f22080g = new l.b.a.v2.a(l.b.a.o2.a.f21658l);
        f22081h = new l.b.a.v2.a(l.b.a.o2.a.m);
        HashMap r0 = new HashMap();
        f22082i = r0;
        r0.put(r1, l.b.h.d.a(5));
        r0.put(r2, l.b.h.d.a(6));
    }

    static l.b.b.a a(o r3) {
        if (r3.r(l.b.a.o2.a.f21649c) == false) goto L7;
        return new f();
    L7:
        if (r3.r(l.b.a.o2.a.f21651e) == false) goto L11;
        return new h();
    L11:
        if (r3.r(l.b.a.o2.a.f21658l) == false) goto L15;
        return new i(128);
    L15:
        if (r3.r(l.b.a.o2.a.m) == false) goto L19;
        return new i(256);
    L19:
        throw new IllegalArgumentException("unrecognized digest OID: " + r3);
    }

    static l.b.a.v2.a b(int r3) {
        if (r3 == 5) goto L11;
        if (r3 != 6) goto L9;
        return f22075b;
    L9:
        throw new IllegalArgumentException("unknown security category: " + r3);
    L11:
        return f22074a;
    }

    static int c(l.b.a.v2.a r1) {
        return ((Integer) f22082i.get(r1.n())).intValue();
    }

    static l.b.a.v2.a d(String r3) {
        if (r3.equals("SHA3-256") == false) goto L7;
        return f22076c;
    L7:
        if (r3.equals("SHA-512/256") == false) goto L11;
        return f22077d;
    L11:
        throw new IllegalArgumentException("unknown tree digest: " + r3);
    }

    static String e(l.b.g.a.h r3) {
        l.b.a.v2.a r4 = r3.o();
        if (r4.n().r(f22076c.n()) == false) goto L7;
        return "SHA3-256";
    L7:
        if (r4.n().r(f22077d.n()) == false) goto L11;
        return "SHA-512/256";
    L11:
        throw new IllegalArgumentException("unknown tree digest: " + r4.n());
    }

    static l.b.a.v2.a f(String r3) {
        if (r3.equals("SHA-256") == false) goto L7;
        return f22078e;
    L7:
        if (r3.equals("SHA-512") == false) goto L11;
        return f22079f;
    L11:
        if (r3.equals("SHAKE128") == false) goto L15;
        return f22080g;
    L15:
        if (r3.equals("SHAKE256") == false) goto L19;
        return f22081h;
    L19:
        throw new IllegalArgumentException("unknown tree digest: " + r3);
    }
}

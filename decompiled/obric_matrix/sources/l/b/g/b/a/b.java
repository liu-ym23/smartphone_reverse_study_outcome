package l.b.g.b.a;

import java.util.HashMap;
import java.util.Map;
import l.b.a.o;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, o> f21982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<o, String> f21983b;

    static {
        f21982a = new HashMap();
        f21983b = new HashMap();
        Map<String, o> r0 = f21982a;
        o r1 = l.b.a.o2.a.f21649c;
        r0.put("SHA-256", r1);
        Map<String, o> r2 = f21982a;
        o r3 = l.b.a.o2.a.f21651e;
        r2.put("SHA-512", r3);
        Map<String, o> r4 = f21982a;
        o r5 = l.b.a.o2.a.f21658l;
        r4.put("SHAKE128", r5);
        Map<String, o> r6 = f21982a;
        o r7 = l.b.a.o2.a.m;
        r6.put("SHAKE256", r7);
        f21983b.put(r1, "SHA-256");
        f21983b.put(r3, "SHA-512");
        f21983b.put(r5, "SHAKE128");
        f21983b.put(r7, "SHAKE256");
    }

    static l.b.b.a a(o r3) {
        if (r3.r(l.b.a.o2.a.f21649c) == false) goto L7;
        return new l.b.b.c.f();
    L7:
        if (r3.r(l.b.a.o2.a.f21651e) == false) goto L11;
        return new l.b.b.c.h();
    L11:
        if (r3.r(l.b.a.o2.a.f21658l) == false) goto L15;
        return new l.b.b.c.i(128);
    L15:
        if (r3.r(l.b.a.o2.a.m) == false) goto L19;
        return new l.b.b.c.i(256);
    L19:
        throw new IllegalArgumentException("unrecognized digest OID: " + r3);
    }
}

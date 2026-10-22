package l.b.g.b.h;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, l.b.a.o> f22107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<l.b.a.o, String> f22108b;

    static {
        f22107a = new HashMap();
        f22108b = new HashMap();
        Map<String, l.b.a.o> r0 = f22107a;
        l.b.a.o r1 = l.b.a.o2.a.f21649c;
        r0.put("SHA-256", r1);
        Map<String, l.b.a.o> r2 = f22107a;
        l.b.a.o r3 = l.b.a.o2.a.f21651e;
        r2.put("SHA-512", r3);
        Map<String, l.b.a.o> r4 = f22107a;
        l.b.a.o r5 = l.b.a.o2.a.f21658l;
        r4.put("SHAKE128", r5);
        Map<String, l.b.a.o> r6 = f22107a;
        l.b.a.o r7 = l.b.a.o2.a.m;
        r6.put("SHAKE256", r7);
        f22108b.put(r1, "SHA-256");
        f22108b.put(r3, "SHA-512");
        f22108b.put(r5, "SHAKE128");
        f22108b.put(r7, "SHAKE256");
    }

    static l.b.b.a a(l.b.a.o r3) {
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

    static String b(l.b.a.o r3) {
        String r0 = f22108b.get(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("unrecognized digest oid: " + r3);
    }

    static l.b.a.o c(String r3) {
        l.b.a.o r0 = f22107a.get(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("unrecognized digest name: " + r3);
    }
}

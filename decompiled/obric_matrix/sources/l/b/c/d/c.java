package l.b.c.d;

import java.util.HashMap;
import java.util.Map;
import l.b.a.o;
import l.b.a.r2.d;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<o, String> f21872a;

    static {
        HashMap r0 = new HashMap();
        f21872a = r0;
        r0.put(d.s, "MD2");
        f21872a.put(d.t, "MD4");
        f21872a.put(d.u, "MD5");
        f21872a.put(l.b.a.q2.a.f21665a, "SHA-1");
        f21872a.put(l.b.a.o2.a.f21652f, "SHA-224");
        f21872a.put(l.b.a.o2.a.f21649c, "SHA-256");
        f21872a.put(l.b.a.o2.a.f21650d, "SHA-384");
        f21872a.put(l.b.a.o2.a.f21651e, "SHA-512");
        f21872a.put(l.b.a.t2.a.f21721c, "RIPEMD-128");
        f21872a.put(l.b.a.t2.a.f21720b, "RIPEMD-160");
        f21872a.put(l.b.a.t2.a.f21722d, "RIPEMD-128");
        f21872a.put(l.b.a.l2.a.f21620d, "RIPEMD-128");
        f21872a.put(l.b.a.l2.a.f21619c, "RIPEMD-160");
        f21872a.put(l.b.a.f2.a.f21566b, "GOST3411");
        f21872a.put(l.b.a.j2.a.f21607a, "Tiger");
        f21872a.put(l.b.a.l2.a.f21621e, "Whirlpool");
        f21872a.put(l.b.a.o2.a.f21654h, "SHA3-224");
        f21872a.put(l.b.a.o2.a.f21655i, "SHA3-256");
        f21872a.put(l.b.a.o2.a.f21656j, "SHA3-384");
        f21872a.put(l.b.a.o2.a.f21657k, "SHA3-512");
        f21872a.put(l.b.a.i2.a.f21602c, "SM3");
    }

    public static String a(o r1) {
        String r0 = f21872a.get(r1);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return r1.A();
    }
}

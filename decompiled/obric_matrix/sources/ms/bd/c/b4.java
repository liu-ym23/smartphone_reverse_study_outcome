package ms.bd.c;

import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b4 {
    static {
        String r0 = (String) m.a(16777217, 0, 0, "513820", new byte[]{16, 7, 110, 73, 25, 5, 57, 20, 123, 69, 43, 55, 73, 74, 4, 34, 36});
    }

    public static d.b.r.h0.c a(d.b.r.h0.c r20, Map<String, String> r21) {
        if (r21.size() <= 0) goto L34;
        if (((String) m.a(16777217, 0, 0, "da6f6e", new byte[]{101, 108, 86, 6})).equalsIgnoreCase(r20.y()) == false) goto L34;
        if (r20.D() != null) goto L11;
        p000j.e0 r2 = c(r20);     // Catch: Exception -> L36
    L12:
        String r3 = r2.b().e();     // Catch: Exception -> L36
        long r4 = r20.s().length();     // Catch: Exception -> L36
        if (r3.contains((String) m.a(16777217, 0, 0, "5c579e", new byte[]{46, 114, 73, 77})) == false) goto L25;
        JSONObject r5 = new JSONObject(b(r2));     // Catch: Exception -> L35
        Iterator<String> r1 = r21.keySet().iterator();     // Catch: Exception -> L35
    L19:
        if (r1.hasNext() == false) goto L21;
        String r6 = r1.next();     // Catch: Exception -> L35
        r5.put(r6, r21.get(r6));     // Catch: Exception -> L35
        goto L19
    L21:
        p000j.e0 r0 = p000j.e0.c(r2.b(), r5.toString());     // Catch: Exception -> L35
    L22:
        r2 = r0;
    L28:
        if (r2 == null) goto L34;
        if (r2.a() < r4) goto L34;
        d.b.r.h0.c.a r7 = r20.O();     // Catch: Exception -> L36
        r7.d(d.b.r.f0.c(r2));     // Catch: Exception -> L36
        return r7.a();
    L25:
        if (r3.contains((String) m.a(16777217, 0, 0, "0f1550", new byte[]{39, 107, 80, 76, 71, 50, 33, 75, 101, 107, 34, 107, 70, 68, 14})) == false) goto L27;
        r0 = d(r2, r21);     // Catch: Exception -> L36
        goto L22
    L27:
        r2 = null;
        goto L28
    L11:
        r2 = r20.D();     // Catch: Exception -> L36
    L34:
        return r20;
    }

    public static String b(p000j.e0 r1) {
        k.e r0 = new k.e();     // Catch: Exception -> L8
        if (r1 == null) goto L6;
        r1.f(r0);     // Catch: Exception -> L8
        return r0.i0();
    L6:
        return "";
    }

    private static p000j.e0 c(d.b.r.h0.c r11) {
        d.b.r.k0.j r12 = r11.s();
        if (r12 != null) goto L11;
    L8:
        return null;
    L11:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Exception -> L10
        r12.b(r0);     // Catch: Exception -> L10
        return p000j.e0.c(p000j.y.d(r12.a()), new String(r0.toByteArray(), (String) m.a(16777217, 0, 0, "c5412a", new byte[]{71, 3, 97, 8, 85})));
    }

    private static p000j.e0 d(p000j.e0 r16, Map<String, String> r17) {
        String r0 = b(r16);     // Catch: Exception -> L16
        Iterator<String> r1 = r17.keySet().iterator();     // Catch: Exception -> L16
        j.t.a r2 = new j.t.a();     // Catch: Exception -> L16
    L4:
        if (r1.hasNext() == false) goto L10;
        String r3 = r1.next();     // Catch: Exception -> L16
        r2.a(r3, r17.get(r3).replaceAll((String) m.a(16777217, 0, 0, "c67806", new byte[]{41}), (String) m.a(16777217, 0, 0, "4905c4", new byte[]{96, 104, 97})));     // Catch: Exception -> L16
        goto L4
    L10:
        p000j.t r4 = r2.b();     // Catch: Exception -> L16
        StringBuilder r5 = new StringBuilder(r0);     // Catch: Exception -> L16
        if (r0.length() > 0) goto L13;
    L14:
        r5.append(b(r4));     // Catch: Exception -> L16
        return p000j.e0.c(r16.b(), r5.toString());
    L13:
        r5.append((String) m.a(16777217, 0, 0, "508b0b", new byte[]{98}));     // Catch: Exception -> L16
    L17:
        return r16;
    }
}

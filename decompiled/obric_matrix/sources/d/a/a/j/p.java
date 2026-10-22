package d.a.a.j;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class p implements t {
    public p() {
    }

    @Override // d.a.a.j.t
    public void b(m r12, Object r13, Object r14, Type r15) {
        z r11 = r12.f12492b;
        if (r13 != null) goto L6;
        r11.Q();
        return;
    L6:
        Map r16 = (Map) r13;
        Class<?> r0 = r16.getClass();
        if (r0 == d.a.a.e.class) goto L13;
        if (r0 == HashMap.class) goto L13;
        if (r0 == LinkedHashMap.class) goto L13;
    L15:
        boolean r1 = false;
    L17:
        if ((r11.f12526h & a0.q.f12471f) != 0) goto L19;
    L24:
        IdentityHashMap<Object, w> r2 = r12.f12502l;
        if (r2 != null) goto L27;
    L30:
        w r3 = r12.m;
        r12.p(r3, r13, r14, 0);
        r11.write(123);     // Catch: Throwable -> L84
        r12.l();     // Catch: Throwable -> L84
        if ((r11.f12526h & a0.t.f12471f) == 0) goto L35;
        if (r1 == true) goto L35;
        r11.F(r12.f12491a.f12519b, false);     // Catch: Throwable -> L84
        r11.S(r13.getClass().getName());     // Catch: Throwable -> L84
        boolean r17 = false;
    L36:
        Iterator r4 = r16.entrySet().iterator();     // Catch: Throwable -> L84
        Class<?> r5 = null;
        t r6 = null;
    L37:
        if (r4.hasNext() == false) goto L77;
        Map.Entry r7 = (Map.Entry) r4.next();     // Catch: Throwable -> L84
        Object r8 = r7.getValue();     // Catch: Throwable -> L84
        Object r9 = r7.getKey();     // Catch: Throwable -> L84
        if (r12.b(r13, r9) == false) goto L37;
        if (r12.a(r13, r9, r8) == false) goto L37;
        Object r10 = r12.n(r13, r9, r8);     // Catch: Throwable -> L84
        Object r18 = m.o(r12, r13, r10, r8);     // Catch: Throwable -> L84
        if (r18 != null) goto L51;
        if ((r11.f12526h & a0.f12467i.f12471f) == 0) goto L37;
    L51:
        if ((r10 instanceof String) == false) goto L59;
        String r19 = (String) r10;     // Catch: Throwable -> L84
        if (r17 == true) goto L56;
        r11.write(44);     // Catch: Throwable -> L84
    L56:
        if ((r11.f12526h & a0.s.f12471f) == 0) goto L58;
        r12.m();     // Catch: Throwable -> L84
    L58:
        r11.F(r19, true);     // Catch: Throwable -> L84
    L69:
        if (r18 != null) goto L72;
        r11.Q();     // Catch: Throwable -> L84
    L71:
        r17 = false;
        goto L37
    L72:
        Class<?> r110 = r18.getClass();     // Catch: Throwable -> L84
        if (r110 != r5) goto L75;
        r6.b(r12, r18, r10, null);     // Catch: Throwable -> L84
        goto L71
    L75:
        t r20 = r12.f12491a.a(r110);     // Catch: Throwable -> L84
        r20.b(r12, r18, r10, null);     // Catch: Throwable -> L84
        r6 = r20;
        r5 = r110;
        goto L71
    L59:
        if (r17 == true) goto L61;
        r11.write(44);     // Catch: Throwable -> L84
    L61:
        int r111 = r11.f12526h;     // Catch: Throwable -> L84
        if ((a0.w.f12471f & r111) == 0) goto L64;
    L67:
        r12.s(d.a.a.a.q(r10));     // Catch: Throwable -> L84
    L68:
        r11.write(58);     // Catch: Throwable -> L84
        goto L69
    L64:
        if ((r111 & a0.B.f12471f) != 0) goto L67;
        r12.r(r10);     // Catch: Throwable -> L84
        goto L68
    L77:
        r12.m = r3;
        r12.d();
        if ((r11.f12526h & a0.s.f12471f) != 0) goto L80;
    L82:
        r11.write(125);
        return;
    L80:
        if (r16.size() <= 0) goto L82;
        r12.m();
    L35:
        r17 = true;
    L84:
        th = move-exception;
        r12.m = r3;
        throw th;
    L27:
        if (r2.containsKey(r13) == false) goto L30;
        r12.t(r13);
        return;
    L19:
        if ((r16 instanceof SortedMap) == true) goto L24;
        if ((r16 instanceof LinkedHashMap) == true) goto L24;
        r16 = new TreeMap(r16);     // Catch: Exception -> L87
    L13:
        if (r16.containsKey("@type") == false) goto L15;
        r1 = true;
        goto L17
    }
}

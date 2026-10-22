package kotlin.s0.w.d.l0.g;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20270a = null;

        static {
            int[] r0 = new int[k.values().length];
            r0[k.f20295f.ordinal()] = 1;
            r0[k.f20297h.ordinal()] = 2;
            r0[k.f20296g.ordinal()] = 3;
            f20270a = r0;
        }
    }

    public static final <V> V a(c r5, Map<c, ? extends V> r6) {
        o.f(r5, "<this>");
        o.f(r6, "values");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<c, ? extends V>> r7 = r6.entrySet().iterator();
    L3:
        boolean r2 = true;
        if (r7.hasNext() == false) goto L14;
        Map.Entry<c, ? extends V> r1 = r7.next();
        c r3 = r1.getKey();
        if (o.a(r5, r3) == false) goto L8;
    L11:
        if (r2 == false) goto L3;
        r0.put(r1.getKey(), r1.getValue());
        goto L3
    L8:
        if (b(r5, r3) == true) goto L11;
        r2 = false;
        goto L11
    L14:
        if ((!r0.isEmpty()) == true) goto L17;
        r0 = null;
    L17:
        if (r0 != null) goto L19;
        return null;
    L19:
        Iterator r8 = r0.entrySet().iterator();
        if (r8.hasNext() == true) goto L22;
        Object r4 = null;
    L31:
        Map.Entry r9 = (Map.Entry) r4;
        if (r9 != null) goto L34;
        return null;
    L34:
        return (V) r9.getValue();
    L22:
        r4 = r8.next();
        if (r8.hasNext() == false) goto L31;
        int r10 = g((c) ((Map.Entry) r4).getKey(), r5).b().length();
    L26:
        Object r11 = r8.next();
        int r12 = g((c) ((Map.Entry) r11).getKey(), r5).b().length();
        if (r10 <= r12) goto L30;
        r4 = r11;
        r10 = r12;
    L30:
        if (r8.hasNext() == true) goto L26;
        goto L31
    }

    public static final boolean b(c r1, c r2) {
        o.f(r1, "<this>");
        o.f(r2, "packageName");
        return o.a(f(r1), r2);
    }

    private static final boolean c(String r3, String r4) {
        if (kotlin.u0.k.A(r3, r4, false, 2, null) == true) goto L5;
        return false;
    L5:
        if (r3.charAt(r4.length()) != '.') goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean d(c r2, c r3) {
        o.f(r2, "<this>");
        o.f(r3, "packageName");
        if (o.a(r2, r3) == false) goto L6;
        return true;
    L6:
        if (r3.d() == true) goto L11;
        String r4 = r2.b();
        o.e(r4, "this.asString()");
        String r5 = r3.b();
        o.e(r5, "packageName.asString()");
        return c(r4, r5);
    L11:
        return true;
    }

    public static final boolean e(String r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        k r1 = k.f20295f;
        int r2 = 0;
    L7:
        if (r2 >= r7.length()) goto L27;
        char r3 = r7.charAt(r2);
        int r5 = a.f20270a[r1.ordinal()];
        if (r5 == 1) goto L22;
        if (r5 == 2) goto L22;
        if (r5 != 3) goto L25;
        if (r3 != '.') goto L19;
        r1 = k.f20297h;
        goto L25
    L19:
        if (Character.isJavaIdentifierPart(r3) == true) goto L25;
        return false;
    L25:
        r2 = r2 + 1;
    L22:
        if (Character.isJavaIdentifierPart(r3) == false) goto L23;
        r1 = k.f20296g;
        goto L25
    L23:
        return false;
    L27:
        if (r1 != k.f20297h) goto L29;
        return false;
    L29:
        return true;
    }

    public static final c f(c r1) {
        o.f(r1, "<this>");
        if (r1.d() == false) goto L6;
        return null;
    L6:
        return r1.e();
    }

    public static final c g(c r2, c r3) {
        o.f(r2, "<this>");
        o.f(r3, "prefix");
        if (d(r2, r3) == true) goto L5;
        return r2;
    L5:
        if (r3.d() == false) goto L8;
        return r2;
    L8:
        if (o.a(r2, r3) == false) goto L10;
        c r4 = c.f20260c;
        o.e(r4, "ROOT");
        return r4;
    L10:
        String r5 = r2.b();
        o.e(r5, "asString()");
        String r6 = r5.substring(r3.b().length() + 1);
        o.e(r6, "this as java.lang.String).substring(startIndex)");
        return new c(r6);
    }
}

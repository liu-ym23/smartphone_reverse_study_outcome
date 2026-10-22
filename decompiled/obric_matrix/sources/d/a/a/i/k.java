package d.a.a.i;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
class k implements d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f12438a;

    static {
        f12438a = new k();
    }

    k() {
    }

    public static Object c(b r16, Map<Object, Object> r17, Type r18, Type r19, Object r20) {
        e r4 = r16.f12388j;
        int r5 = r4.f12404a;
        int r6 = 16;
        if (r5 == 12) goto L8;
        if (r5 == 16) goto L8;
        throw new d.a.a.d("syntax error, expect {, actual " + f.a(r5));
    L8:
        d.a.a.i.q.f r7 = r16.f12385g.c(r18);
        d.a.a.i.q.f r8 = r16.f12385g.c(r19);
        r4.s();
        l r9 = r16.f12389k;
    L71:
        int r10 = r4.f12404a;     // Catch: Throwable -> L68
        if (r10 == 13) goto L11;
        if (r10 != 4) goto L45;
        if (r4.f12411h != 4) goto L45;
        if (r4.q.startsWith("$ref", r4.f12414k + 1) == false) goto L45;
        if (r4.m(d.v) == true) goto L45;
        r4.u(':');     // Catch: Throwable -> L68
        if (r4.f12404a != 4) goto L43;
        String r0 = r4.X();     // Catch: Throwable -> L68
        if ("..".equals(r0) == false) goto L29;
        l r1 = r9.f12440b;     // Catch: Throwable -> L68
    L27:
        Object r12 = r1.f12439a;     // Catch: Throwable -> L68
    L35:
        r4.t(13);     // Catch: Throwable -> L68
        if (r4.f12404a != 13) goto L41;
        r4.t(16);     // Catch: Throwable -> L68
        r16.k0(r9);
        return r12;
    L41:
        throw new d.a.a.d("illegal ref");     // Catch: Throwable -> L68
    L29:
        if ("$".equals(r0) == false) goto L34;
        r1 = r9;
    L31:
        l r2 = r1.f12440b;     // Catch: Throwable -> L68
        if (r2 == null) goto L27;
        r1 = r2;
        goto L31
    L34:
        r16.b(new b.a(r9, r0));     // Catch: Throwable -> L68
        r16.o = 1;     // Catch: Throwable -> L68
        r12 = null;
        goto L35
    L43:
        throw new d.a.a.d("illegal ref, " + f.a(r10));     // Catch: Throwable -> L68
    L45:
        if (r17.size() != 0) goto L57;
        if (r10 != 4) goto L57;
        if ("@type".equals(r4.X()) == false) goto L57;
        if (r4.m(d.v) == true) goto L57;
        r4.u(':');     // Catch: Throwable -> L68
        r4.t(16);     // Catch: Throwable -> L68
        if (r4.f12404a == 13) goto L53;
        r4.s();     // Catch: Throwable -> L68
        goto L57
    L53:
        r4.s();     // Catch: Throwable -> L68
        r16.k0(r9);
        return r17;
    L57:
        Object r11 = r7.a(r16, r18, null);     // Catch: Throwable -> L68
        if (r4.f12404a != 17) goto L67;
        r4.s();     // Catch: Throwable -> L68
        Object r13 = r8.a(r16, r19, r11);     // Catch: Throwable -> L68
        if (r16.o != 1) goto L62;
        r16.l(r17, r11);     // Catch: Throwable -> L68
    L62:
        r17.put(r11, r13);     // Catch: Throwable -> L68
        if (r4.f12404a != 16) goto L65;
        r4.s();     // Catch: Throwable -> L68
    L65:
        r6 = 16;
        goto L71
    L67:
        throw new d.a.a.d("syntax error, expect :, actual " + r4.f12404a);     // Catch: Throwable -> L68
    L11:
        r4.t(r6);     // Catch: Throwable -> L68
        r16.k0(r9);
        return r17;
    L68:
        th = move-exception;
        r16.k0(r9);
        throw th;
    }

    public static Map d(b r9, Map<String, Object> r10, Type r11, Object r12) {
        e r0 = r9.f12388j;
        if (r0.f12404a != 12) goto L74;
        l r1 = r9.f12389k;
    L75:
        r0.W();     // Catch: Throwable -> L70
    L6:
        char r2 = r0.f12407d;     // Catch: Throwable -> L70
        if (r2 != ',') goto L11;
        r0.q();     // Catch: Throwable -> L70
        r0.W();     // Catch: Throwable -> L70
        goto L6
    L11:
        if (r2 != '\"') goto L18;
        String r3 = r0.S(r9.f12384f, '\"');     // Catch: Throwable -> L70
        r0.W();     // Catch: Throwable -> L70
        if (r0.f12407d != ':') goto L16;
    L31:
        r0.q();     // Catch: Throwable -> L70
        r0.W();     // Catch: Throwable -> L70
        char r4 = r0.f12407d;     // Catch: Throwable -> L70
        r0.f12411h = 0;     // Catch: Throwable -> L70
        if (r3 != "@type") goto L50;
        if (r0.m(d.v) == true) goto L50;
        Class<?> r5 = d.a.a.k.d.C(r0.S(r9.f12384f, '\"'), r9.f12385g.f12447c);     // Catch: Throwable -> L70
        if (r5 != r10.getClass()) goto L42;
        r0.t(16);     // Catch: Throwable -> L70
        if (r0.f12404a != 13) goto L75;
        r0.t(16);     // Catch: Throwable -> L70
        r9.k0(r1);
        return r10;
    L42:
        d.a.a.i.q.f r13 = r9.f12385g.c(r5);     // Catch: Throwable -> L70
        r0.t(16);     // Catch: Throwable -> L70
        r9.o = 2;     // Catch: Throwable -> L70
        if (r1 != null) goto L45;
    L47:
        Map r14 = (Map) r13.a(r9, r5, r12);     // Catch: Throwable -> L70
        r9.k0(r1);
        return r14;
    L45:
        if ((r12 instanceof Integer) == true) goto L47;
        r9.i0();     // Catch: Throwable -> L70
    L50:
        r0.s();     // Catch: Throwable -> L70
        r9.k0(r1);     // Catch: Throwable -> L70
        if (r0.f12404a != 8) goto L53;
        Object r6 = null;
        r0.s();     // Catch: Throwable -> L70
    L54:
        r10.put(r3, r6);     // Catch: Throwable -> L70
        if (r9.o != 1) goto L57;
        r9.l(r10, r3);     // Catch: Throwable -> L70
    L57:
        r9.j0(r1, r6, r3);     // Catch: Throwable -> L70
        int r7 = r0.f12404a;     // Catch: Throwable -> L70
        if (r7 == 20) goto L66;
        if (r7 == 15) goto L66;
        if (r7 != 13) goto L75;
        r0.s();     // Catch: Throwable -> L70
        r9.k0(r1);
        return r10;
    L66:
        r9.k0(r1);
        return r10;
    L53:
        r6 = r9.Y(r11, r3);     // Catch: Throwable -> L70
        goto L54
    L16:
        throw new d.a.a.d("syntax error, " + r0.i());     // Catch: Throwable -> L70
    L18:
        if (r2 == '}') goto L19;
        if (r2 != '\'') goto L29;
        r3 = r0.S(r9.f12384f, '\'');     // Catch: Throwable -> L70
        r0.W();     // Catch: Throwable -> L70
        if (r0.f12407d == ':') goto L31;
        throw new d.a.a.d("syntax error, " + r0.i());     // Catch: Throwable -> L70
    L29:
        r3 = r0.T(r9.f12384f);     // Catch: Throwable -> L70
        r0.W();     // Catch: Throwable -> L70
        char r8 = r0.f12407d;     // Catch: Throwable -> L70
        if (r8 == ':') goto L31;
        throw new d.a.a.d("expect ':' at " + r0.f12405b + ", actual " + r8);     // Catch: Throwable -> L70
    L19:
        r0.q();     // Catch: Throwable -> L70
        r0.f12411h = 0;     // Catch: Throwable -> L70
        r0.t(16);     // Catch: Throwable -> L70
        r9.k0(r1);
        return r10;
    L70:
        th = move-exception;
        r9.k0(r1);
        throw th;
    L74:
        throw new d.a.a.d("syntax error, expect {, actual " + r0.f12404a);
    }

    @Override // d.a.a.i.q.f
    public <T> T a(b r4, Type r5, Object r6) {
        if (r5 == d.a.a.e.class) goto L5;
    L8:
        e r0 = r4.f12388j;
        if (r0.f12404a != 8) goto L12;
        r0.t(16);
        return null;
    L12:
        Map<?, ?> r3 = b(r5);
        l r1 = r4.f12389k;
        r4.j0(r1, r3, r6);     // Catch: Throwable -> L26
        if ((r5 instanceof ParameterizedType) == false) goto L23;
        ParameterizedType r7 = (ParameterizedType) r5;     // Catch: Throwable -> L26
        Type r2 = r7.getActualTypeArguments()[0];     // Catch: Throwable -> L26
        Type r8 = r7.getActualTypeArguments()[1];     // Catch: Throwable -> L26
        if (String.class != r2) goto L20;
        T r9 = (T) d(r4, r3, r8, r6);
        r4.k0(r1);
        return r9;
    L20:
        T r10 = (T) c(r4, r3, r2, r8, r6);
        r4.k0(r1);
        return r10;
    L23:
        T r11 = (T) r4.d0(r3, r6);
        r4.k0(r1);
        return r11;
    L26:
        th = move-exception;
        r4.k0(r1);
        throw th;
    L5:
        if (r4.r != null) goto L8;
        return (T) r4.S();
    }

    protected Map<?, ?> b(Type r4) {
        if (r4 != Properties.class) goto L7;
        return new Properties();
    L7:
        if (r4 != Hashtable.class) goto L11;
        return new Hashtable();
    L11:
        if (r4 != IdentityHashMap.class) goto L15;
        return new IdentityHashMap();
    L15:
        if (r4 == SortedMap.class) goto L59;
        if (r4 == TreeMap.class) goto L59;
        if (r4 == ConcurrentMap.class) goto L57;
        if (r4 == ConcurrentHashMap.class) goto L57;
        if (r4 == Map.class) goto L55;
        if (r4 == HashMap.class) goto L55;
        if (r4 != LinkedHashMap.class) goto L34;
        return new LinkedHashMap();
    L34:
        if (r4 != d.a.a.e.class) goto L38;
        return new d.a.a.e();
    L38:
        if ((r4 instanceof ParameterizedType) == false) goto L45;
        ParameterizedType r5 = (ParameterizedType) r4;
        Type r0 = r5.getRawType();
        if (EnumMap.class.equals(r0) == false) goto L44;
        return new EnumMap((Class) r5.getActualTypeArguments()[0]);
    L44:
        return b(r0);
    L45:
        Class r3 = (Class) r4;
        if (r3.isInterface() == true) goto L53;
        return (Map) r3.newInstance();
    L49:
        e = move-exception;
        throw new d.a.a.d("unsupport type " + r4, e);
    L53:
        throw new d.a.a.d("unsupport type " + r4);
    L55:
        return new HashMap();
    L57:
        return new ConcurrentHashMap();
    L59:
        return new TreeMap();
    }
}

package kotlin.s0.w.d.l0.e.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.i0.m0;
import kotlin.i0.t0;

/* JADX INFO: loaded from: classes2.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19266a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a.C0508a> f19267b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f19268c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<a.C0508a, c> f19269d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, c> f19270e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set<kotlin.s0.w.d.l0.g.f> f19271f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<String> f19272g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a.C0508a f19273h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Map<a.C0508a, kotlin.s0.w.d.l0.g.f> f19274i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<String, kotlin.s0.w.d.l0.g.f> f19275j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final List<kotlin.s0.w.d.l0.g.f> f19276k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.g.f> f19277l = null;

    public static final class a {

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.h0$a$a, reason: collision with other inner class name */
        public static final class C0508a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final kotlin.s0.w.d.l0.g.f f19278a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f19279b;

            public C0508a(kotlin.s0.w.d.l0.g.f r2, String r3) {
                kotlin.n0.d.o.f(r2, "name");
                kotlin.n0.d.o.f(r3, "signature");
                this.f19278a = r2;
                this.f19279b = r3;
            }

            public final kotlin.s0.w.d.l0.g.f a() {
                return this.f19278a;
            }

            public final String b() {
                return this.f19279b;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0508a) == true) goto L8;
                return false;
            L8:
                C0508a r6 = (C0508a) r5;
                if (kotlin.n0.d.o.a(this.f19278a, r6.f19278a) == true) goto L12;
                return false;
            L12:
                if (kotlin.n0.d.o.a(this.f19279b, r6.f19279b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f19278a.hashCode() * 31) + this.f19279b.hashCode();
            }

            public String toString() {
                return "NameAndSignature(name=" + this.f19278a + ", signature=" + this.f19279b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public static final /* synthetic */ C0508a a(a r0, String r1, String r2, String r3, String r4) {
            return r0.m(r1, r2, r3, r4);
        }

        private final C0508a m(String r4, String r5, String r6, String r7) {
            kotlin.s0.w.d.l0.g.f r0 = kotlin.s0.w.d.l0.g.f.k(r5);
            kotlin.n0.d.o.e(r0, "identifier(name)");
            return new C0508a(r0, kotlin.s0.w.d.l0.e.b.x.f19797a.k(r4, r5 + '(' + r6 + ')' + r7));
        }

        public final kotlin.s0.w.d.l0.g.f b(kotlin.s0.w.d.l0.g.f r2) {
            kotlin.n0.d.o.f(r2, "name");
            return f().get(r2);
        }

        public final List<String> c() {
            return h0.a();
        }

        public final Set<kotlin.s0.w.d.l0.g.f> d() {
            return h0.b();
        }

        public final Set<String> e() {
            return h0.c();
        }

        public final Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.g.f> f() {
            return h0.d();
        }

        public final List<kotlin.s0.w.d.l0.g.f> g() {
            return h0.e();
        }

        public final C0508a h() {
            return h0.f();
        }

        public final Map<String, c> i() {
            return h0.g();
        }

        public final Map<String, kotlin.s0.w.d.l0.g.f> j() {
            return h0.h();
        }

        public final boolean k(kotlin.s0.w.d.l0.g.f r2) {
            kotlin.n0.d.o.f(r2, "<this>");
            return g().contains(r2);
        }

        public final b l(String r2) {
            kotlin.n0.d.o.f(r2, "builtinSignature");
            if (c().contains(r2) == false) goto L7;
            return b.f19280f;
        L7:
            if (((c) m0.i(i(), r2)) != c.f19284g) goto L10;
            return b.f19282h;
        L10:
            return b.f19281g;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f19280f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f19281g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f19282h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ b[] f19283i = null;

        static {
            f19280f = new b("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
            f19281g = new b("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
            f19282h = new b("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);
            f19283i = a();
        }

        private b(String r1, int r2, String r3, boolean r4) {
            super(r1, r2);
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{f19280f, f19281g, f19282h};
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f19283i.clone();
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f19284g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f19285h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f19286i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final c f19287j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ c[] f19288k = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object f19289f;

        static final class a extends c {
            a(String r2, int r3) {
                kotlin.n0.d.g r0 = null;
                super(r2, r3, r0, r0);
            }
        }

        static {
            f19284g = new c("NULL", 0, null);
            f19285h = new c("INDEX", 1, -1);
            f19286i = new c("FALSE", 2, Boolean.FALSE);
            f19287j = new a("MAP_GET_OR_DEFAULT", 3);
            f19288k = a();
        }

        private c(String r1, int r2, Object r3) {
            super(r1, r2);
            this.f19289f = r3;
        }

        public /* synthetic */ c(String r1, int r2, Object r3, kotlin.n0.d.g r4) {
            this(r1, r2, r3);
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{f19284g, f19285h, f19286i, f19287j};
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f19288k.clone();
        }
    }

    static {
        f19266a = new a(null);
        Set r0 = t0.e(new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = (String) r2.next();
        a r5 = f19266a;
        String r6 = kotlin.s0.w.d.l0.k.u.e.f20606j.g();
        kotlin.n0.d.o.e(r6, "BOOLEAN.desc");
        r1.add(a.a(r5, "java/util/Collection", r3, "Ljava/util/Collection;", r6));
        goto L4
    L6:
        f19267b = r1;
        ArrayList r4 = new ArrayList(kotlin.i0.r.q(r1, 10));
        Iterator r7 = r1.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r4.add(((a.C0508a) r7.next()).b());
        goto L8
    L10:
        f19268c = r4;
        List<a.C0508a> r8 = f19267b;
        ArrayList r9 = new ArrayList(kotlin.i0.r.q(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        r9.add(((a.C0508a) r10.next()).a().b());
        goto L12
    L14:
        kotlin.s0.w.d.l0.e.b.x r11 = kotlin.s0.w.d.l0.e.b.x.f19797a;
        a r12 = f19266a;
        String r13 = r11.i("Collection");
        kotlin.s0.w.d.l0.k.u.e r14 = kotlin.s0.w.d.l0.k.u.e.f20606j;
        String r15 = r14.g();
        kotlin.n0.d.o.e(r15, "BOOLEAN.desc");
        a.C0508a r16 = a.a(r12, r13, "contains", "Ljava/lang/Object;", r15);
        c r17 = c.f19286i;
        String r18 = r11.i("Collection");
        String r19 = r14.g();
        kotlin.n0.d.o.e(r19, "BOOLEAN.desc");
        String r110 = r11.i("Map");
        String r111 = r14.g();
        kotlin.n0.d.o.e(r111, "BOOLEAN.desc");
        String r112 = r11.i("Map");
        String r113 = r14.g();
        kotlin.n0.d.o.e(r113, "BOOLEAN.desc");
        String r114 = r11.i("Map");
        String r20 = r14.g();
        kotlin.n0.d.o.e(r20, "BOOLEAN.desc");
        a.C0508a r21 = a.a(r12, r11.i("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        c r115 = c.f19284g;
        String r116 = r11.i("List");
        kotlin.s0.w.d.l0.k.u.e r117 = kotlin.s0.w.d.l0.k.u.e.n;
        String r22 = r117.g();
        kotlin.n0.d.o.e(r22, "INT.desc");
        a.C0508a r23 = a.a(r12, r116, "indexOf", "Ljava/lang/Object;", r22);
        c r24 = c.f19285h;
        String r25 = r11.i("List");
        String r26 = r117.g();
        kotlin.n0.d.o.e(r26, "INT.desc");
        Map<a.C0508a, c> r27 = m0.k(new kotlin.u[]{kotlin.a0.a(r16, r17), kotlin.a0.a(a.a(r12, r18, "remove", "Ljava/lang/Object;", r19), r17), kotlin.a0.a(a.a(r12, r110, "containsKey", "Ljava/lang/Object;", r111), r17), kotlin.a0.a(a.a(r12, r112, "containsValue", "Ljava/lang/Object;", r113), r17), kotlin.a0.a(a.a(r12, r114, "remove", "Ljava/lang/Object;Ljava/lang/Object;", r20), r17), kotlin.a0.a(a.a(r12, r11.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.f19287j), kotlin.a0.a(r21, r115), kotlin.a0.a(a.a(r12, r11.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), r115), kotlin.a0.a(r23, r24), kotlin.a0.a(a.a(r12, r25, "lastIndexOf", "Ljava/lang/Object;", r26), r24)});
        f19269d = r27;
        LinkedHashMap r28 = new LinkedHashMap(m0.d(r27.size()));
        Iterator<T> r29 = r27.entrySet().iterator();
    L16:
        if (r29.hasNext() == false) goto L18;
        Map.Entry r30 = (Map.Entry) r29.next();
        r28.put(((a.C0508a) r30.getKey()).b(), r30.getValue());
        goto L16
    L18:
        f19270e = r28;
        Set r31 = t0.h(f19269d.keySet(), f19267b);
        ArrayList r32 = new ArrayList(kotlin.i0.r.q(r31, 10));
        Iterator r33 = r31.iterator();
    L20:
        if (r33.hasNext() == false) goto L22;
        r32.add(((a.C0508a) r33.next()).a());
        goto L20
    L22:
        f19271f = kotlin.i0.r.D0(r32);
        ArrayList r34 = new ArrayList(kotlin.i0.r.q(r31, 10));
        Iterator r35 = r31.iterator();
    L24:
        if (r35.hasNext() == false) goto L26;
        r34.add(((a.C0508a) r35.next()).b());
        goto L24
    L26:
        f19272g = kotlin.i0.r.D0(r34);
        a r36 = f19266a;
        kotlin.s0.w.d.l0.k.u.e r37 = kotlin.s0.w.d.l0.k.u.e.n;
        String r38 = r37.g();
        kotlin.n0.d.o.e(r38, "INT.desc");
        a.C0508a r39 = a.a(r36, "java/util/List", "removeAt", r38, "Ljava/lang/Object;");
        f19273h = r39;
        kotlin.s0.w.d.l0.e.b.x r40 = kotlin.s0.w.d.l0.e.b.x.f19797a;
        String r118 = r40.h("Number");
        String r119 = kotlin.s0.w.d.l0.k.u.e.f20608l.g();
        kotlin.n0.d.o.e(r119, "BYTE.desc");
        String r41 = r40.h("Number");
        String r120 = kotlin.s0.w.d.l0.k.u.e.m.g();
        kotlin.n0.d.o.e(r120, "SHORT.desc");
        String r42 = r40.h("Number");
        String r43 = r37.g();
        kotlin.n0.d.o.e(r43, "INT.desc");
        String r44 = r40.h("Number");
        String r45 = kotlin.s0.w.d.l0.k.u.e.p.g();
        kotlin.n0.d.o.e(r45, "LONG.desc");
        String r46 = r40.h("Number");
        String r47 = kotlin.s0.w.d.l0.k.u.e.o.g();
        kotlin.n0.d.o.e(r47, "FLOAT.desc");
        String r48 = r40.h("Number");
        String r49 = kotlin.s0.w.d.l0.k.u.e.q.g();
        kotlin.n0.d.o.e(r49, "DOUBLE.desc");
        String r50 = r40.h("CharSequence");
        String r51 = r37.g();
        kotlin.n0.d.o.e(r51, "INT.desc");
        String r52 = kotlin.s0.w.d.l0.k.u.e.f20607k.g();
        kotlin.n0.d.o.e(r52, "CHAR.desc");
        Map<a.C0508a, kotlin.s0.w.d.l0.g.f> r53 = m0.k(new kotlin.u[]{kotlin.a0.a(a.a(r36, r118, "toByte", "", r119), kotlin.s0.w.d.l0.g.f.k("byteValue")), kotlin.a0.a(a.a(r36, r41, "toShort", "", r120), kotlin.s0.w.d.l0.g.f.k("shortValue")), kotlin.a0.a(a.a(r36, r42, "toInt", "", r43), kotlin.s0.w.d.l0.g.f.k("intValue")), kotlin.a0.a(a.a(r36, r44, "toLong", "", r45), kotlin.s0.w.d.l0.g.f.k("longValue")), kotlin.a0.a(a.a(r36, r46, "toFloat", "", r47), kotlin.s0.w.d.l0.g.f.k("floatValue")), kotlin.a0.a(a.a(r36, r48, "toDouble", "", r49), kotlin.s0.w.d.l0.g.f.k("doubleValue")), kotlin.a0.a(r39, kotlin.s0.w.d.l0.g.f.k("remove")), kotlin.a0.a(a.a(r36, r50, "get", r51, r52), kotlin.s0.w.d.l0.g.f.k("charAt"))});
        f19274i = r53;
        LinkedHashMap r54 = new LinkedHashMap(m0.d(r53.size()));
        Iterator<T> r55 = r53.entrySet().iterator();
    L28:
        if (r55.hasNext() == false) goto L30;
        Map.Entry r56 = (Map.Entry) r55.next();
        r54.put(((a.C0508a) r56.getKey()).b(), r56.getValue());
        goto L28
    L30:
        f19275j = r54;
        Set<a.C0508a> r57 = f19274i.keySet();
        ArrayList r58 = new ArrayList(kotlin.i0.r.q(r57, 10));
        Iterator<T> r59 = r57.iterator();
    L32:
        if (r59.hasNext() == false) goto L34;
        r58.add(((a.C0508a) r59.next()).a());
        goto L32
    L34:
        f19276k = r58;
        Set<Map.Entry<a.C0508a, kotlin.s0.w.d.l0.g.f>> r60 = f19274i.entrySet();
        ArrayList r61 = new ArrayList(kotlin.i0.r.q(r60, 10));
        Iterator<T> r62 = r60.iterator();
    L36:
        if (r62.hasNext() == false) goto L38;
        Map.Entry r63 = (Map.Entry) r62.next();
        r61.add(new kotlin.u(((a.C0508a) r63.getKey()).a(), r63.getValue()));
        goto L36
    L38:
        LinkedHashMap r64 = new LinkedHashMap(kotlin.r0.e.c(m0.d(kotlin.i0.r.q(r61, 10)), 16));
        Iterator r65 = r61.iterator();
    L40:
        if (r65.hasNext() == false) goto L42;
        kotlin.u r66 = (kotlin.u) r65.next();
        r64.put((kotlin.s0.w.d.l0.g.f) r66.d(), (kotlin.s0.w.d.l0.g.f) r66.c());
        goto L40
    L42:
        f19277l = r64;
    }

    public h0() {
    }

    public static final /* synthetic */ List a() {
        return f19268c;
    }

    public static final /* synthetic */ Set b() {
        return f19271f;
    }

    public static final /* synthetic */ Set c() {
        return f19272g;
    }

    public static final /* synthetic */ Map d() {
        return f19277l;
    }

    public static final /* synthetic */ List e() {
        return f19276k;
    }

    public static final /* synthetic */ a.C0508a f() {
        return f19273h;
    }

    public static final /* synthetic */ Map g() {
        return f19270e;
    }

    public static final /* synthetic */ Map h() {
        return f19275j;
    }
}

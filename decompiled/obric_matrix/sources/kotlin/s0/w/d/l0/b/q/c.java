package kotlin.s0.w.d.l0.b.q;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.b.k;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f18771a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f18772b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f18773c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f18774d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f18775e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.b f18776f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.c f18777g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.b f18778h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HashMap<kotlin.s0.w.d.l0.g.d, kotlin.s0.w.d.l0.g.b> f18779i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final HashMap<kotlin.s0.w.d.l0.g.d, kotlin.s0.w.d.l0.g.b> f18780j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final HashMap<kotlin.s0.w.d.l0.g.d, kotlin.s0.w.d.l0.g.c> f18781k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final HashMap<kotlin.s0.w.d.l0.g.d, kotlin.s0.w.d.l0.g.c> f18782l = null;
    private static final HashMap<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.g.b> m = null;
    private static final HashMap<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.g.b> n = null;
    private static final List<a> o = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.g.b f18783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.g.b f18784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.g.b f18785c;

        public a(kotlin.s0.w.d.l0.g.b r2, kotlin.s0.w.d.l0.g.b r3, kotlin.s0.w.d.l0.g.b r4) {
            o.f(r2, "javaClass");
            o.f(r3, "kotlinReadOnly");
            o.f(r4, "kotlinMutable");
            this.f18783a = r2;
            this.f18784b = r3;
            this.f18785c = r4;
        }

        public final kotlin.s0.w.d.l0.g.b a() {
            return this.f18783a;
        }

        public final kotlin.s0.w.d.l0.g.b b() {
            return this.f18784b;
        }

        public final kotlin.s0.w.d.l0.g.b c() {
            return this.f18785c;
        }

        public final kotlin.s0.w.d.l0.g.b d() {
            return this.f18783a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (o.a(this.f18783a, r6.f18783a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f18784b, r6.f18784b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f18785c, r6.f18785c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f18783a.hashCode() * 31) + this.f18784b.hashCode()) * 31) + this.f18785c.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.f18783a + ", kotlinReadOnly=" + this.f18784b + ", kotlinMutable=" + this.f18785c + ')';
        }
    }

    static {
        c r0 = new c();
        f18771a = r0;
        StringBuilder r1 = new StringBuilder();
        kotlin.s0.w.d.l0.b.p.c r2 = kotlin.s0.w.d.l0.b.p.c.f18757i;
        r1.append(r2.c().toString());
        r1.append('.');
        r1.append(r2.b());
        f18772b = r1.toString();
        StringBuilder r3 = new StringBuilder();
        kotlin.s0.w.d.l0.b.p.c r4 = kotlin.s0.w.d.l0.b.p.c.f18759k;
        r3.append(r4.c().toString());
        r3.append('.');
        r3.append(r4.b());
        f18773c = r3.toString();
        StringBuilder r5 = new StringBuilder();
        kotlin.s0.w.d.l0.b.p.c r6 = kotlin.s0.w.d.l0.b.p.c.f18758j;
        r5.append(r6.c().toString());
        r5.append('.');
        r5.append(r6.b());
        f18774d = r5.toString();
        StringBuilder r7 = new StringBuilder();
        kotlin.s0.w.d.l0.b.p.c r8 = kotlin.s0.w.d.l0.b.p.c.f18760l;
        r7.append(r8.c().toString());
        r7.append('.');
        r7.append(r8.b());
        f18775e = r7.toString();
        kotlin.s0.w.d.l0.g.b r9 = kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("kotlin.jvm.functions.FunctionN"));
        o.e(r9, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f18776f = r9;
        kotlin.s0.w.d.l0.g.c r10 = r9.b();
        o.e(r10, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f18777g = r10;
        kotlin.s0.w.d.l0.g.i r11 = kotlin.s0.w.d.l0.g.i.f20282a;
        f18778h = r11.i();
        r11.h();
        r0.g(Class.class);
        f18779i = new HashMap();
        f18780j = new HashMap();
        f18781k = new HashMap();
        f18782l = new HashMap();
        m = new HashMap();
        n = new HashMap();
        kotlin.s0.w.d.l0.g.b r12 = kotlin.s0.w.d.l0.g.b.m(k.a.C);
        o.e(r12, "topLevel(FqNames.iterable)");
        kotlin.s0.w.d.l0.g.c r13 = k.a.K;
        kotlin.s0.w.d.l0.g.c r14 = r12.h();
        kotlin.s0.w.d.l0.g.c r15 = r12.h();
        o.e(r15, "kotlinReadOnly.packageFqName");
        kotlin.s0.w.d.l0.g.c r16 = kotlin.s0.w.d.l0.g.e.g(r13, r15);
        int r17 = 0;
        kotlin.s0.w.d.l0.g.b r18 = new kotlin.s0.w.d.l0.g.b(r14, r16, false);
        kotlin.s0.w.d.l0.g.b r19 = kotlin.s0.w.d.l0.g.b.m(k.a.B);
        o.e(r19, "topLevel(FqNames.iterator)");
        kotlin.s0.w.d.l0.g.c r20 = k.a.f18717J;
        kotlin.s0.w.d.l0.g.c r21 = r19.h();
        kotlin.s0.w.d.l0.g.c r22 = r19.h();
        o.e(r22, "kotlinReadOnly.packageFqName");
        kotlin.s0.w.d.l0.g.b r23 = new kotlin.s0.w.d.l0.g.b(r21, kotlin.s0.w.d.l0.g.e.g(r20, r22), false);
        kotlin.s0.w.d.l0.g.b r24 = kotlin.s0.w.d.l0.g.b.m(k.a.D);
        o.e(r24, "topLevel(FqNames.collection)");
        kotlin.s0.w.d.l0.g.c r25 = k.a.L;
        kotlin.s0.w.d.l0.g.c r26 = r24.h();
        kotlin.s0.w.d.l0.g.c r27 = r24.h();
        o.e(r27, "kotlinReadOnly.packageFqName");
        kotlin.s0.w.d.l0.g.b r28 = new kotlin.s0.w.d.l0.g.b(r26, kotlin.s0.w.d.l0.g.e.g(r25, r27), false);
        kotlin.s0.w.d.l0.g.b r29 = kotlin.s0.w.d.l0.g.b.m(k.a.E);
        o.e(r29, "topLevel(FqNames.list)");
        kotlin.s0.w.d.l0.g.c r30 = k.a.M;
        kotlin.s0.w.d.l0.g.c r31 = r29.h();
        kotlin.s0.w.d.l0.g.c r32 = r29.h();
        o.e(r32, "kotlinReadOnly.packageFqName");
        kotlin.s0.w.d.l0.g.b r33 = new kotlin.s0.w.d.l0.g.b(r31, kotlin.s0.w.d.l0.g.e.g(r30, r32), false);
        kotlin.s0.w.d.l0.g.b r34 = kotlin.s0.w.d.l0.g.b.m(k.a.G);
        o.e(r34, "topLevel(FqNames.set)");
        kotlin.s0.w.d.l0.g.c r35 = k.a.O;
        kotlin.s0.w.d.l0.g.c r36 = r34.h();
        kotlin.s0.w.d.l0.g.c r37 = r34.h();
        o.e(r37, "kotlinReadOnly.packageFqName");
        kotlin.s0.w.d.l0.g.b r38 = new kotlin.s0.w.d.l0.g.b(r36, kotlin.s0.w.d.l0.g.e.g(r35, r37), false);
        kotlin.s0.w.d.l0.g.b r39 = kotlin.s0.w.d.l0.g.b.m(k.a.F);
        o.e(r39, "topLevel(FqNames.listIterator)");
        kotlin.s0.w.d.l0.g.c r40 = k.a.N;
        kotlin.s0.w.d.l0.g.c r41 = r39.h();
        kotlin.s0.w.d.l0.g.c r42 = r39.h();
        o.e(r42, "kotlinReadOnly.packageFqName");
        kotlin.s0.w.d.l0.g.b r43 = new kotlin.s0.w.d.l0.g.b(r41, kotlin.s0.w.d.l0.g.e.g(r40, r42), false);
        kotlin.s0.w.d.l0.g.c r44 = k.a.H;
        kotlin.s0.w.d.l0.g.b r45 = kotlin.s0.w.d.l0.g.b.m(r44);
        o.e(r45, "topLevel(FqNames.map)");
        kotlin.s0.w.d.l0.g.c r46 = k.a.P;
        kotlin.s0.w.d.l0.g.c r47 = r45.h();
        kotlin.s0.w.d.l0.g.c r110 = r45.h();
        o.e(r110, "kotlinReadOnly.packageFqName");
        kotlin.s0.w.d.l0.g.b r48 = new kotlin.s0.w.d.l0.g.b(r47, kotlin.s0.w.d.l0.g.e.g(r46, r110), false);
        kotlin.s0.w.d.l0.g.b r49 = kotlin.s0.w.d.l0.g.b.m(r44).d(k.a.I.g());
        o.e(r49, "topLevel(FqNames.map).cr…mes.mapEntry.shortName())");
        kotlin.s0.w.d.l0.g.c r50 = k.a.Q;
        kotlin.s0.w.d.l0.g.c r51 = r49.h();
        kotlin.s0.w.d.l0.g.c r52 = r49.h();
        o.e(r52, "kotlinReadOnly.packageFqName");
        List<a> r53 = r.j(new a[]{new a(r0.g(Iterable.class), r12, r18), new a(r0.g(Iterator.class), r19, r23), new a(r0.g(Collection.class), r24, r28), new a(r0.g(List.class), r29, r33), new a(r0.g(Set.class), r34, r38), new a(r0.g(ListIterator.class), r39, r43), new a(r0.g(Map.class), r45, r48), new a(r0.g(Map.Entry.class), r49, new kotlin.s0.w.d.l0.g.b(r51, kotlin.s0.w.d.l0.g.e.g(r50, r52), false))});
        o = r53;
        r0.f(Object.class, k.a.f18719b);
        r0.f(String.class, k.a.f18724g);
        r0.f(CharSequence.class, k.a.f18723f);
        r0.e(Throwable.class, k.a.f18729l);
        r0.f(Cloneable.class, k.a.f18721d);
        r0.f(Number.class, k.a.f18727j);
        r0.e(Comparable.class, k.a.m);
        r0.f(Enum.class, k.a.f18728k);
        r0.e(Annotation.class, k.a.t);
        Iterator<a> r54 = r53.iterator();
    L4:
        if (r54.hasNext() == false) goto L6;
        f18771a.d(r54.next());
        goto L4
    L6:
        kotlin.s0.w.d.l0.k.u.e[] r55 = kotlin.s0.w.d.l0.k.u.e.values();
        int r56 = r55.length;
        int r57 = 0;
    L7:
        if (r57 >= r56) goto L9;
        kotlin.s0.w.d.l0.k.u.e r58 = r55[r57];
        c r59 = f18771a;
        kotlin.s0.w.d.l0.g.b r60 = kotlin.s0.w.d.l0.g.b.m(r58.l());
        o.e(r60, "topLevel(jvmType.wrapperFqName)");
        kotlin.s0.w.d.l0.b.i r61 = r58.k();
        o.e(r61, "jvmType.primitiveType");
        kotlin.s0.w.d.l0.g.b r62 = kotlin.s0.w.d.l0.g.b.m(k.c(r61));
        o.e(r62, "topLevel(StandardNames.g…e(jvmType.primitiveType))");
        r59.a(r60, r62);
        r57 = r57 + 1;
        goto L7
    L9:
        Iterator<kotlin.s0.w.d.l0.g.b> r63 = kotlin.s0.w.d.l0.b.c.f18671a.a().iterator();
    L11:
        if (r63.hasNext() == false) goto L13;
        kotlin.s0.w.d.l0.g.b r64 = r63.next();
        c r65 = f18771a;
        kotlin.s0.w.d.l0.g.b r66 = kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("kotlin.jvm.internal." + r64.j().b() + "CompanionObject"));
        o.e(r66, "topLevel(FqName(\"kotlin.…g() + \"CompanionObject\"))");
        kotlin.s0.w.d.l0.g.b r67 = r64.d(kotlin.s0.w.d.l0.g.h.f20276c);
        o.e(r67, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
        r65.a(r66, r67);
        goto L11
    L13:
        int r68 = 0;
    L15:
        if (r68 >= 23) goto L18;
        c r69 = f18771a;
        kotlin.s0.w.d.l0.g.b r70 = kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("kotlin.jvm.functions.Function" + r68));
        o.e(r70, "topLevel(FqName(\"kotlin.…m.functions.Function$i\"))");
        r69.a(r70, k.a(r68));
        r69.c(new kotlin.s0.w.d.l0.g.c(f18773c + r68), f18778h);
        r68 = r68 + 1;
    L18:
        if (r17 >= 22) goto L20;
        kotlin.s0.w.d.l0.b.p.c r71 = kotlin.s0.w.d.l0.b.p.c.f18760l;
        String r72 = r71.c().toString() + '.' + r71.b();
        f18771a.c(new kotlin.s0.w.d.l0.g.c(r72 + r17), f18778h);
        r17 = r17 + 1;
        goto L18
    L20:
        c r73 = f18771a;
        kotlin.s0.w.d.l0.g.c r74 = k.a.f18720c.l();
        o.e(r74, "nothing.toSafe()");
        r73.c(r74, r73.g(Void.class));
    }

    private c() {
    }

    private final void a(kotlin.s0.w.d.l0.g.b r2, kotlin.s0.w.d.l0.g.b r3) {
        b(r2, r3);
        kotlin.s0.w.d.l0.g.c r4 = r3.b();
        o.e(r4, "kotlinClassId.asSingleFqName()");
        c(r4, r2);
    }

    private final void b(kotlin.s0.w.d.l0.g.b r2, kotlin.s0.w.d.l0.g.b r3) {
        HashMap<kotlin.s0.w.d.l0.g.d, kotlin.s0.w.d.l0.g.b> r1 = f18779i;
        kotlin.s0.w.d.l0.g.d r4 = r2.b().j();
        o.e(r4, "javaClassId.asSingleFqName().toUnsafe()");
        r1.put(r4, r3);
    }

    private final void c(kotlin.s0.w.d.l0.g.c r2, kotlin.s0.w.d.l0.g.b r3) {
        HashMap<kotlin.s0.w.d.l0.g.d, kotlin.s0.w.d.l0.g.b> r1 = f18780j;
        kotlin.s0.w.d.l0.g.d r4 = r2.j();
        o.e(r4, "kotlinFqNameUnsafe.toUnsafe()");
        r1.put(r4, r3);
    }

    private final void d(a r5) {
        kotlin.s0.w.d.l0.g.b r0 = r5.a();
        kotlin.s0.w.d.l0.g.b r1 = r5.b();
        kotlin.s0.w.d.l0.g.b r6 = r5.c();
        a(r0, r1);
        kotlin.s0.w.d.l0.g.c r2 = r6.b();
        o.e(r2, "mutableClassId.asSingleFqName()");
        c(r2, r0);
        m.put(r6, r1);
        n.put(r1, r6);
        kotlin.s0.w.d.l0.g.c r4 = r1.b();
        o.e(r4, "readOnlyClassId.asSingleFqName()");
        kotlin.s0.w.d.l0.g.c r3 = r6.b();
        o.e(r3, "mutableClassId.asSingleFqName()");
        HashMap<kotlin.s0.w.d.l0.g.d, kotlin.s0.w.d.l0.g.c> r7 = f18781k;
        kotlin.s0.w.d.l0.g.d r8 = r6.b().j();
        o.e(r8, "mutableClassId.asSingleFqName().toUnsafe()");
        r7.put(r8, r4);
        HashMap<kotlin.s0.w.d.l0.g.d, kotlin.s0.w.d.l0.g.c> r9 = f18782l;
        kotlin.s0.w.d.l0.g.d r10 = r4.j();
        o.e(r10, "readOnlyFqName.toUnsafe()");
        r9.put(r10, r3);
    }

    private final void e(Class<?> r2, kotlin.s0.w.d.l0.g.c r3) {
        kotlin.s0.w.d.l0.g.b r4 = g(r2);
        kotlin.s0.w.d.l0.g.b r5 = kotlin.s0.w.d.l0.g.b.m(r3);
        o.e(r5, "topLevel(kotlinFqName)");
        a(r4, r5);
    }

    private final void f(Class<?> r2, kotlin.s0.w.d.l0.g.d r3) {
        kotlin.s0.w.d.l0.g.c r4 = r3.l();
        o.e(r4, "kotlinFqName.toSafe()");
        e(r2, r4);
    }

    private final kotlin.s0.w.d.l0.g.b g(Class<?> r2) {
        if (r2.isPrimitive() == true) goto L5;
        r2.isArray();
    L5:
        Class<?> r0 = r2.getDeclaringClass();
        if (r0 != null) goto L8;
        kotlin.s0.w.d.l0.g.b r1 = kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c(r2.getCanonicalName()));
        String r3 = "topLevel(FqName(clazz.canonicalName))";
    L9:
        o.e(r1, r3);
        return r1;
    L8:
        r1 = g(r0).d(kotlin.s0.w.d.l0.g.f.k(r2.getSimpleName()));
        r3 = "classId(outer).createNes…tifier(clazz.simpleName))";
        goto L9
    }

    private final boolean j(kotlin.s0.w.d.l0.g.d r4, String r5) {
        String r3 = r4.b();
        o.e(r3, "kotlinFqName.asString()");
        String r6 = kotlin.u0.k.w0(r3, r5, "");
        if (r6.length() <= 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == true) goto L8;
    L16:
        return false;
    L8:
        if (kotlin.u0.k.s0(r6, '0', false, 2, null) == true) goto L16;
        Integer r8 = kotlin.u0.k.i(r6);
        if (r8 == null) goto L15;
        if (r8.intValue() < 23) goto L15;
        return true;
    L15:
        return false;
    L5:
        r7 = false;
        goto L6
    }

    public final kotlin.s0.w.d.l0.g.c h() {
        return f18777g;
    }

    public final List<a> i() {
        return o;
    }

    public final boolean k(kotlin.s0.w.d.l0.g.d r1) {
        return f18781k.containsKey(r1);
    }

    public final boolean l(kotlin.s0.w.d.l0.g.d r1) {
        return f18782l.containsKey(r1);
    }

    public final kotlin.s0.w.d.l0.g.b m(kotlin.s0.w.d.l0.g.c r1) {
        o.f(r1, "fqName");
        return f18779i.get(r1.j());
    }

    public final kotlin.s0.w.d.l0.g.b n(kotlin.s0.w.d.l0.g.d r2) {
        o.f(r2, "kotlinFqName");
        if (j(r2, f18772b) == false) goto L6;
    L16:
        return f18776f;
    L6:
        if (j(r2, f18774d) == true) goto L16;
        if (j(r2, f18773c) == false) goto L12;
    L17:
        return f18778h;
    L12:
        if (j(r2, f18775e) == true) goto L17;
        return f18780j.get(r2);
    }

    public final kotlin.s0.w.d.l0.g.c o(kotlin.s0.w.d.l0.g.d r1) {
        return f18781k.get(r1);
    }

    public final kotlin.s0.w.d.l0.g.c p(kotlin.s0.w.d.l0.g.d r1) {
        return f18782l.get(r1);
    }
}

package kotlin.s0.w.d.l0.n;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f20991a = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f20992f = null;

        static {
            f20992f = new a();
        }

        a() {
            super(1);
        }

        public final Void a(kotlin.s0.w.d.l0.n.t1.g r1) {
            kotlin.n0.d.o.f(r1, "<anonymous parameter 0>");
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((kotlin.s0.w.d.l0.n.t1.g) r1);
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m0 f20993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e1 f20994b;

        public b(m0 r1, e1 r2) {
            this.f20993a = r1;
            this.f20994b = r2;
        }

        public final m0 a() {
            return this.f20993a;
        }

        public final e1 b() {
            return this.f20994b;
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.n.t1.g, m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e1 f20995f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List<g1> f20996g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a1 f20997h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f20998i;

        /* JADX WARN: Multi-variable type inference failed */
        c(e1 r1, List<? extends g1> r2, a1 r3, boolean r4) {
            this.f20995f = r1;
            this.f20996g = r2;
            this.f20997h = r3;
            this.f20998i = r4;
            super(1);
        }

        public final m0 a(kotlin.s0.w.d.l0.n.t1.g r4) {
            kotlin.n0.d.o.f(r4, "refiner");
            b r0 = f0.a(f0.f20991a, this.f20995f, r4, this.f20996g);
            if (r0 != null) goto L6;
            return null;
        L6:
            m0 r1 = r0.a();
            if (r1 == null) goto L9;
            return r1;
        L9:
            a1 r2 = this.f20997h;
            e1 r3 = r0.b();
            kotlin.n0.d.o.c(r3);
            return f0.h(r2, r3, this.f20996g, this.f20998i, r4);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ m0 invoke(kotlin.s0.w.d.l0.n.t1.g r1) {
            return a(r1);
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.n.t1.g, m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e1 f20999f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List<g1> f21000g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a1 f21001h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f21002i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.k.w.h f21003j;

        /* JADX WARN: Multi-variable type inference failed */
        d(e1 r1, List<? extends g1> r2, a1 r3, boolean r4, kotlin.s0.w.d.l0.k.w.h r5) {
            this.f20999f = r1;
            this.f21000g = r2;
            this.f21001h = r3;
            this.f21002i = r4;
            this.f21003j = r5;
            super(1);
        }

        public final m0 a(kotlin.s0.w.d.l0.n.t1.g r4) {
            kotlin.n0.d.o.f(r4, "kotlinTypeRefiner");
            b r5 = f0.a(f0.f20991a, this.f20999f, r4, this.f21000g);
            if (r5 != null) goto L6;
            return null;
        L6:
            m0 r0 = r5.a();
            if (r0 == null) goto L9;
            return r0;
        L9:
            a1 r1 = this.f21001h;
            e1 r6 = r5.b();
            kotlin.n0.d.o.c(r6);
            return f0.j(r1, r6, this.f21000g, this.f21002i, this.f21003j);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ m0 invoke(kotlin.s0.w.d.l0.n.t1.g r1) {
            return a(r1);
        }
    }

    static {
        f20991a = new f0();
        a r0 = a.f20992f;
    }

    private f0() {
    }

    public static final /* synthetic */ b a(f0 r0, e1 r1, kotlin.s0.w.d.l0.n.t1.g r2, List r3) {
        return r0.f(r1, r2, r3);
    }

    public static final m0 b(kotlin.s0.w.d.l0.c.e1 r3, List<? extends g1> r4) {
        kotlin.n0.d.o.f(r3, "<this>");
        kotlin.n0.d.o.f(r4, "arguments");
        return new v0(x0.a.f21192a, false).i(w0.f21177e.a(null, r3, r4), a1.f20943g.h());
    }

    private final kotlin.s0.w.d.l0.k.w.h c(e1 r3, List<? extends g1> r4, kotlin.s0.w.d.l0.n.t1.g r5) {
        kotlin.s0.w.d.l0.c.h r2 = r3.d();
        if ((r2 instanceof kotlin.s0.w.d.l0.c.f1) == false) goto L6;
        return ((kotlin.s0.w.d.l0.c.f1) r2).s().q();
    L6:
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L14;
        if (r5 != null) goto L9;
        r5 = kotlin.s0.w.d.l0.k.t.a.k(kotlin.s0.w.d.l0.k.t.a.l(r2));
    L9:
        kotlin.s0.w.d.l0.c.e r6 = (kotlin.s0.w.d.l0.c.e) r2;
        if (r4.isEmpty() == false) goto L25;
        return kotlin.s0.w.d.l0.c.q1.u.b(r6, r5);
    L25:
        return kotlin.s0.w.d.l0.c.q1.u.a(r6, f1.f21004b.b(r3, r4), r5);
    L14:
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e1) == false) goto L18;
        kotlin.s0.w.d.l0.n.u1.g r7 = kotlin.s0.w.d.l0.n.u1.g.f21144j;
        String r8 = ((kotlin.s0.w.d.l0.c.e1) r2).getName().toString();
        kotlin.n0.d.o.e(r8, "descriptor.name.toString()");
        return kotlin.s0.w.d.l0.n.u1.k.a(r7, true, new String[]{r8});
    L18:
        if ((r3 instanceof d0) == false) goto L22;
        return ((d0) r3).g();
    L22:
        throw new IllegalStateException("Unsupported classifier: " + r2 + " for constructor: " + r3);
    }

    public static final q1 d(m0 r1, m0 r2) {
        kotlin.n0.d.o.f(r1, "lowerBound");
        kotlin.n0.d.o.f(r2, "upperBound");
        if (kotlin.n0.d.o.a(r1, r2) == false) goto L6;
        return r1;
    L6:
        return new z(r1, r2);
    }

    public static final m0 e(a1 r4, kotlin.s0.w.d.l0.k.r.n r5, boolean r6) {
        kotlin.n0.d.o.f(r4, "attributes");
        kotlin.n0.d.o.f(r5, "constructor");
        return j(r4, r5, kotlin.i0.r.g(), r6, kotlin.s0.w.d.l0.n.u1.k.a(kotlin.s0.w.d.l0.n.u1.g.f21142h, true, new String[]{"unknown integer literal type"}));
    }

    private final b f(e1 r2, kotlin.s0.w.d.l0.n.t1.g r3, List<? extends g1> r4) {
        kotlin.s0.w.d.l0.c.h r1 = r2.d();
        if (r1 == null) goto L13;
        kotlin.s0.w.d.l0.c.h r5 = r3.f(r1);
        if (r5 == null) goto L13;
        if ((r5 instanceof kotlin.s0.w.d.l0.c.e1) == true) goto L10;
        e1 r6 = r5.k().c(r3);
        kotlin.n0.d.o.e(r6, "descriptor.typeConstruct…refine(kotlinTypeRefiner)");
        return new b(null, r6);
    L10:
        return new b(b((kotlin.s0.w.d.l0.c.e1) r5, r4), null);
    L13:
        return null;
    }

    public static final m0 g(a1 r8, kotlin.s0.w.d.l0.c.e r9, List<? extends g1> r10) {
        kotlin.n0.d.o.f(r8, "attributes");
        kotlin.n0.d.o.f(r9, "descriptor");
        kotlin.n0.d.o.f(r10, "arguments");
        e1 r2 = r9.k();
        kotlin.n0.d.o.e(r2, "descriptor.typeConstructor");
        return i(r8, r2, r10, false, null, 16, null);
    }

    public static final m0 h(a1 r7, e1 r8, List<? extends g1> r9, boolean r10, kotlin.s0.w.d.l0.n.t1.g r11) {
        kotlin.n0.d.o.f(r7, "attributes");
        kotlin.n0.d.o.f(r8, "constructor");
        kotlin.n0.d.o.f(r9, "arguments");
        if (r7.isEmpty() == false) goto L12;
        if (r9.isEmpty() == false) goto L12;
        if (r10 == true) goto L12;
        if (r8.d() == null) goto L12;
        kotlin.s0.w.d.l0.c.h r12 = r8.d();
        kotlin.n0.d.o.c(r12);
        m0 r13 = r12.s();
        kotlin.n0.d.o.e(r13, "constructor.declarationDescriptor!!.defaultType");
        return r13;
    L12:
        return k(r7, r8, r9, r10, f20991a.c(r8, r9, r11), new c(r8, r9, r7, r10));
    }

    public static /* synthetic */ m0 i(a1 r0, e1 r1, List r2, boolean r3, kotlin.s0.w.d.l0.n.t1.g r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L6;
        r4 = null;
    L6:
        return h(r0, r1, r2, r3, r4);
    }

    public static final m0 j(a1 r8, e1 r9, List<? extends g1> r10, boolean r11, kotlin.s0.w.d.l0.k.w.h r12) {
        kotlin.n0.d.o.f(r8, "attributes");
        kotlin.n0.d.o.f(r9, "constructor");
        kotlin.n0.d.o.f(r10, "arguments");
        kotlin.n0.d.o.f(r12, "memberScope");
        n0 r0 = new n0(r9, r10, r11, r12, new d(r9, r10, r8, r11, r12));
        if (r8.isEmpty() == false) goto L6;
        return r0;
    L6:
        return new o0(r0, r8);
    }

    public static final m0 k(a1 r7, e1 r8, List<? extends g1> r9, boolean r10, kotlin.s0.w.d.l0.k.w.h r11, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.n.t1.g, ? extends m0> r12) {
        kotlin.n0.d.o.f(r7, "attributes");
        kotlin.n0.d.o.f(r8, "constructor");
        kotlin.n0.d.o.f(r9, "arguments");
        kotlin.n0.d.o.f(r11, "memberScope");
        kotlin.n0.d.o.f(r12, "refinedTypeFactory");
        n0 r0 = new n0(r8, r9, r10, r11, r12);
        if (r7.isEmpty() == false) goto L6;
        return r0;
    L6:
        return new o0(r0, r7);
    }
}

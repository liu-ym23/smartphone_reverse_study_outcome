package kotlin.s0.w.d.l0.n;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f21173c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x0 f21174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f21175b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public static final /* synthetic */ void a(a r0, int r1, kotlin.s0.w.d.l0.c.e1 r2) {
            r0.b(r1, r2);
        }

        private final void b(int r2, kotlin.s0.w.d.l0.c.e1 r3) {
            if (r2 > 100) goto L6;
            return;
        L6:
            throw new AssertionError("Too deep recursion while expanding type alias " + r3.getName());
        }
    }

    static {
        f21173c = new a(null);
        new v0(x0.a.f21192a, false);
    }

    public v0(x0 r2, boolean r3) {
        kotlin.n0.d.o.f(r2, "reportStrategy");
        this.f21174a = r2;
        this.f21175b = r3;
    }

    private final void a(kotlin.s0.w.d.l0.c.o1.g r3, kotlin.s0.w.d.l0.c.o1.g r4) {
        HashSet r0 = new HashSet();
        Iterator<kotlin.s0.w.d.l0.c.o1.c> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(r5.next().e());
        goto L4
    L6:
        Iterator<kotlin.s0.w.d.l0.c.o1.c> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        kotlin.s0.w.d.l0.c.o1.c r7 = r6.next();
        if (r0.contains(r7.e()) == false) goto L8;
        this.f21174a.a(r7);
        goto L8
    }

    private final void b(e0 r9, e0 r10) {
        l1 r0 = l1.f(r10);
        kotlin.n0.d.o.e(r0, "create(substitutedType)");
        Iterator<T> r11 = r10.M0().iterator();
        int r1 = 0;
    L4:
        if (r11.hasNext() == false) goto L17;
        Object r2 = r11.next();
        int r3 = r1 + 1;
        if (r1 < 0) goto L15;
        g1 r4 = (g1) r2;
        if (r4.d() == true) goto L14;
        e0 r5 = r4.b();
        kotlin.n0.d.o.e(r5, "substitutedArgument.type");
        if (kotlin.s0.w.d.l0.n.x1.a.d(r5) == true) goto L14;
        g1 r6 = r9.M0().get(r1);
        kotlin.s0.w.d.l0.c.f1 r7 = r9.O0().getParameters().get(r1);
        if (this.f21175b == false) goto L14;
        x0 r8 = this.f21174a;
        e0 r12 = r6.b();
        kotlin.n0.d.o.e(r12, "unsubstitutedArgument.type");
        e0 r13 = r4.b();
        kotlin.n0.d.o.e(r13, "substitutedArgument.type");
        kotlin.n0.d.o.e(r7, "typeParameter");
        r8.c(r0, r12, r13, r7);
    L14:
        r1 = r3;
        goto L4
    L15:
        kotlin.i0.r.p();
        throw null;
    }

    private final v c(v r1, a1 r2) {
        return r1.b1(h(r1, r2));
    }

    private final m0 d(m0 r2, a1 r3) {
        if (g0.a(r2) == false) goto L6;
        return r2;
    L6:
        return k1.f(r2, null, h(r2, r3), 1, null);
    }

    private final m0 e(m0 r1, e0 r2) {
        m0 r0 = n1.r(r1, r2.P0());
        kotlin.n0.d.o.e(r0, "makeNullableIfNeeded(thi…romType.isMarkedNullable)");
        return r0;
    }

    private final m0 f(m0 r1, e0 r2) {
        return d(e(r1, r2), r2.N0());
    }

    private final m0 g(w0 r2, a1 r3, boolean r4) {
        e1 r1 = r2.b().k();
        kotlin.n0.d.o.e(r1, "descriptor.typeConstructor");
        return f0.j(r3, r1, r2.a(), r4, kotlin.s0.w.d.l0.k.w.h.b.f20650b);
    }

    private final a1 h(e0 r1, a1 r2) {
        if (g0.a(r1) == false) goto L7;
        return r1.N0();
    L7:
        return r2.l(r1.N0());
    }

    private final g1 j(g1 r13, w0 r14, int r15) {
        q1 r0 = r13.b().R0();
        if (w.a(r0) == false) goto L5;
        return r13;
    L5:
        m0 r1 = k1.a(r0);
        if (g0.a(r1) == false) goto L8;
        return r13;
    L8:
        if (kotlin.s0.w.d.l0.n.x1.a.x(r1) == false) goto L38;
        e1 r2 = r1.O0();
        kotlin.s0.w.d.l0.c.h r3 = r2.d();
        r2.getParameters().size();
        r1.M0().size();
        if ((r3 instanceof kotlin.s0.w.d.l0.c.f1) == false) goto L14;
        return r13;
    L14:
        if ((r3 instanceof kotlin.s0.w.d.l0.c.e1) == false) goto L32;
        kotlin.s0.w.d.l0.c.e1 r4 = (kotlin.s0.w.d.l0.c.e1) r3;
        int r5 = 0;
        if (r14.d(r4) == false) goto L19;
        this.f21174a.d(r4);
        r1 r16 = r1.f21065h;
        kotlin.s0.w.d.l0.n.u1.j r17 = kotlin.s0.w.d.l0.n.u1.j.x;
        String r6 = r4.getName().toString();
        kotlin.n0.d.o.e(r6, "typeDescriptor.name.toString()");
        return new i1(r16, kotlin.s0.w.d.l0.n.u1.k.d(r17, new String[]{r6}));
    L19:
        List<g1> r7 = r1.M0();
        ArrayList r8 = new ArrayList(kotlin.i0.r.q(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L21:
        if (r9.hasNext() == false) goto L27;
        Object r10 = r9.next();
        int r11 = r5 + 1;
        if (r5 < 0) goto L25;
        r8.add(l((g1) r10, r14, r2.getParameters().get(r5), r15 + 1));
        r5 = r11;
        goto L21
    L25:
        kotlin.i0.r.p();
        throw null;
    L27:
        m0 r12 = k(w0.f21177e.a(r14, r4, r8), r1.N0(), r1.P0(), r15 + 1, false);
        m0 r18 = m(r1, r14, r15);
        if (w.a(r12) == true) goto L31;
        r12 = q0.j(r12, r18);
    L31:
        i1 r19 = new i1(r13.a(), r12);
    L34:
        return r19;
    L32:
        m0 r110 = m(r1, r14, r15);
        b(r1, r110);
        r19 = new i1(r13.a(), r110);
        goto L34
    L38:
        return r13;
    }

    private final m0 k(w0 r4, a1 r5, boolean r6, int r7, boolean r8) {
        g1 r9 = l(new i1(r1.f21065h, r4.b().g0()), r4, null, r7);
        e0 r0 = r9.b();
        kotlin.n0.d.o.e(r0, "expandedProjection.type");
        m0 r1 = k1.a(r0);
        if (g0.a(r1) == false) goto L5;
        return r1;
    L5:
        r9.a();
        a(r1.getAnnotations(), k.a(r5));
        m0 r10 = n1.r(d(r1, r5), r6);
        kotlin.n0.d.o.e(r10, "expandedType.combineAttr…fNeeded(it, isNullable) }");
        if (r8 == true) goto L8;
        return r10;
    L8:
        return q0.j(r10, g(r4, r5, r6));
    }

    private final g1 l(g1 r4, w0 r5, kotlin.s0.w.d.l0.c.f1 r6, int r7) {
        a.a(f21173c, r7, r5.b());
        if (r4.d() == false) goto L6;
    L4:
        kotlin.n0.d.o.c(r6);
        g1 r3 = n1.s(r6);
        kotlin.n0.d.o.e(r3, "makeStarProjection(typeParameterDescriptor!!)");
        return r3;
    L6:
        e0 r0 = r4.b();
        kotlin.n0.d.o.e(r0, "underlyingProjection.type");
        g1 r2 = r5.c(r0.O0());
        if (r2 != null) goto L11;
        return j(r4, r5, r7);
    L11:
        if (r2.d() == true) goto L4;
        q1 r8 = r2.b().R0();
        r1 r1 = r2.a();
        kotlin.n0.d.o.e(r1, "argument.projectionKind");
        r1 r9 = r4.a();
        kotlin.n0.d.o.e(r9, "underlyingProjection.projectionKind");
        if (r9 == r1) goto L22;
        r1 r10 = r1.f21065h;
        if (r9 == r10) goto L22;
        if (r1 != r10) goto L21;
        r1 = r9;
        goto L22
    L21:
        this.f21174a.b(r5.b(), r6, r8);
    L22:
        if (r6 == null) goto L25;
        r1 r11 = r6.n();
        if (r11 == null) goto L25;
    L26:
        kotlin.n0.d.o.e(r11, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
        if (r11 == r1) goto L35;
        r1 r12 = r1.f21065h;
        if (r11 == r12) goto L35;
        if (r1 != r12) goto L34;
        r1 = r12;
        goto L35
    L34:
        this.f21174a.b(r5.b(), r6, r8);
    L35:
        a(r0.getAnnotations(), r8.getAnnotations());
        if ((r8 instanceof v) == false) goto L38;
        e0 r13 = c((v) r8, r0.N0());
    L40:
        return new i1(r1, r13);
    L38:
        r13 = f(k1.a(r8), r0);
    L25:
        r11 = r1.f21065h;
        goto L26
    }

    private final m0 m(m0 r9, w0 r10, int r11) {
        e1 r0 = r9.O0();
        List<g1> r1 = r9.M0();
        ArrayList r2 = new ArrayList(kotlin.i0.r.q(r1, 10));
        Iterator<T> r3 = r1.iterator();
        int r4 = 0;
    L4:
        if (r3.hasNext() == false) goto L15;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 < 0) goto L12;
        g1 r7 = (g1) r5;
        g1 r8 = l(r7, r10, r0.getParameters().get(r4), r11 + 1);
        if (r8.d() == true) goto L11;
        r8 = new i1(r8.a(), n1.q(r8.b(), r7.b().P0()));
    L11:
        r2.add(r8);
        r4 = r6;
        goto L4
    L12:
        kotlin.i0.r.p();
        throw null;
    L15:
        return k1.f(r9, r2, null, 2, null);
    }

    public final m0 i(w0 r8, a1 r9) {
        kotlin.n0.d.o.f(r8, "typeAliasExpansion");
        kotlin.n0.d.o.f(r9, "attributes");
        return k(r8, r9, false, 0, true);
    }
}

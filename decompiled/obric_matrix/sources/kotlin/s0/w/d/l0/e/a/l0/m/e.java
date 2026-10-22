package kotlin.s0.w.d.l0.e.a.l0.m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a0;
import kotlin.i0.r;
import kotlin.m;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.b.h;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.e.a.j0.k;
import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.b0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.g0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.j1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.s0.w.d.l0.n.u1.j;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends j1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.e.a.l0.m.a f19506c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.e.a.l0.m.a f19507d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f19508b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19509a = null;

        static {
            int[] r0 = new int[kotlin.s0.w.d.l0.e.a.l0.m.b.values().length];
            r0[kotlin.s0.w.d.l0.e.a.l0.m.b.f19494h.ordinal()] = 1;
            r0[kotlin.s0.w.d.l0.e.a.l0.m.b.f19493g.ordinal()] = 2;
            r0[kotlin.s0.w.d.l0.e.a.l0.m.b.f19492f.ordinal()] = 3;
            f19509a = r0;
        }
    }

    static final class b extends q implements l<kotlin.s0.w.d.l0.n.t1.g, m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.e f19510f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f19511g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ m0 f19512h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.m.a f19513i;

        b(kotlin.s0.w.d.l0.c.e r1, e r2, m0 r3, kotlin.s0.w.d.l0.e.a.l0.m.a r4) {
            this.f19510f = r1;
            this.f19511g = r2;
            this.f19512h = r3;
            this.f19513i = r4;
            super(1);
        }

        public final m0 a(kotlin.s0.w.d.l0.n.t1.g r4) {
            o.f(r4, "kotlinTypeRefiner");
            kotlin.s0.w.d.l0.c.e r0 = this.f19510f;
            if ((r0 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L18;
            kotlin.s0.w.d.l0.g.b r1 = kotlin.s0.w.d.l0.k.t.a.g(r0);
            if (r1 == null) goto L18;
            kotlin.s0.w.d.l0.c.e r5 = r4.b(r1);
            if (r5 != null) goto L14;
            return null;
        L14:
            if (o.a(r5, this.f19510f) == false) goto L17;
            return null;
        L17:
            return (m0) e.i(this.f19511g, this.f19512h, r5, this.f19513i).c();
        L18:
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ m0 invoke(kotlin.s0.w.d.l0.n.t1.g r1) {
            return a(r1);
        }
    }

    static {
        k r0 = k.f19333g;
        f19506c = d.d(r0, false, null, 3, null).i(kotlin.s0.w.d.l0.e.a.l0.m.b.f19494h);
        f19507d = d.d(r0, false, null, 3, null).i(kotlin.s0.w.d.l0.e.a.l0.m.b.f19493g);
    }

    public e(g r1) {
        if (r1 != null) goto L5;
        r1 = new g(this);
    L5:
        this.f19508b = r1;
    }

    public /* synthetic */ e(g r1, int r2, kotlin.n0.d.g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public static final /* synthetic */ u i(e r0, m0 r1, kotlin.s0.w.d.l0.c.e r2, kotlin.s0.w.d.l0.e.a.l0.m.a r3) {
        return r0.l(r1, r2, r3);
    }

    public static /* synthetic */ g1 k(e r0, f1 r1, kotlin.s0.w.d.l0.e.a.l0.m.a r2, e0 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0.f19508b.c(r1, true, r2);
        o.e(r3, "typeParameterUpperBoundE…eter, isRaw = true, attr)");
    L6:
        return r0.j(r1, r2, r3);
    }

    private final u<m0, Boolean> l(m0 r13, kotlin.s0.w.d.l0.c.e r14, kotlin.s0.w.d.l0.e.a.l0.m.a r15) {
        Boolean r0 = Boolean.FALSE;
        if (r13.O0().getParameters().isEmpty() == false) goto L7;
        return a0.a(r13, r0);
    L7:
        if (h.c0(r13) == false) goto L11;
        g1 r16 = r13.M0().get(0);
        r1 r2 = r16.a();
        e0 r17 = r16.b();
        o.e(r17, "componentTypeProjection.type");
        return a0.a(f0.i(r13.N0(), r13.O0(), r.d(new i1(r2, m(r17, r15))), r13.P0(), null, 16, null), r0);
    L11:
        if (g0.a(r13) == true) goto L13;
        kotlin.s0.w.d.l0.k.w.h r4 = r14.a0(this);
        o.e(r4, "declaration.getMemberScope(this)");
        a1 r1 = r13.N0();
        e1 r3 = r14.k();
        o.e(r3, "declaration.typeConstructor");
        List<f1> r5 = r14.k().getParameters();
        o.e(r5, "declaration.typeConstructor.parameters");
        ArrayList r6 = new ArrayList(r.q(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L16:
        if (r7.hasNext() == false) goto L19;
        f1 r8 = (f1) r7.next();
        o.e(r8, "parameter");
        r6.add(k(this, r8, r15, null, 4, null));
        goto L16
    L19:
        return a0.a(f0.k(r1, r3, r6, r13.P0(), r4, new b(r14, this, r13, r15)), Boolean.TRUE);
    L13:
        return a0.a(kotlin.s0.w.d.l0.n.u1.k.d(j.P, new String[]{r13.O0().toString()}), r0);
    }

    private final e0 m(e0 r4, kotlin.s0.w.d.l0.e.a.l0.m.a r5) {
        kotlin.s0.w.d.l0.c.h r0 = r4.O0().d();
        if ((r0 instanceof f1) == false) goto L6;
        e0 r6 = this.f19508b.c((f1) r0, true, r5);
        o.e(r6, "typeParameterUpperBoundE…tion, isRaw = true, attr)");
        return m(r6, r5);
    L6:
        if ((r0 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L19;
        kotlin.s0.w.d.l0.c.h r7 = b0.d(r4).O0().d();
        if ((r7 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L17;
        u<m0, Boolean> r1 = l(b0.c(r4), (kotlin.s0.w.d.l0.c.e) r0, f19506c);
        m0 r2 = r1.a();
        boolean r3 = r1.b().booleanValue();
        u<m0, Boolean> r8 = l(b0.d(r4), (kotlin.s0.w.d.l0.c.e) r7, f19507d);
        m0 r9 = r8.a();
        boolean r10 = r8.b().booleanValue();
        if (r3 == true) goto L15;
        if (r10 == true) goto L15;
        return f0.d(r2, r9);
    L15:
        return new f(r2, r9);
    L17:
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + r7 + "\" while for lower it's \"" + r0 + '\"').toString());
    L19:
        throw new IllegalStateException(("Unexpected declaration kind: " + r0).toString());
    }

    static /* synthetic */ e0 n(e r8, e0 r9, kotlin.s0.w.d.l0.e.a.l0.m.a r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L6;
        r10 = new kotlin.s0.w.d.l0.e.a.l0.m.a(k.f19333g, null, false, null, null, 30, null);
    L6:
        return r8.m(r9, r10);
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public /* bridge */ /* synthetic */ g1 e(e0 r1) {
        return o(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public boolean f() {
        return false;
    }

    public final g1 j(f1 r3, kotlin.s0.w.d.l0.e.a.l0.m.a r4, e0 r5) {
        o.f(r3, "parameter");
        o.f(r4, "attr");
        o.f(r5, "erasedUpperBound");
        int r2 = a.f19509a[r4.d().ordinal()];
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L12;
        throw new m();
    L12:
        if (r3.n().b() == false) goto L20;
        List<f1> r6 = r5.O0().getParameters();
        o.e(r6, "erasedUpperBound.constructor.parameters");
        if ((!r6.isEmpty()) == false) goto L22;
        return new i1(r1.f21067j, r5);
    L22:
        return d.b(r3, r4);
    L20:
        return new i1(r1.f21065h, kotlin.s0.w.d.l0.k.t.a.f(r3).H());
    L19:
        return new i1(r1.f21065h, r5);
    }

    public i1 o(e0 r4) {
        o.f(r4, "key");
        return new i1(n(this, r4, null, 2, null));
    }
}

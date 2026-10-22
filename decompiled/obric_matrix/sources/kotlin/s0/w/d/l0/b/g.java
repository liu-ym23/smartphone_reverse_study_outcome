package kotlin.s0.w.d.l0.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.s0.w.d.l0.k.r.v;
import kotlin.s0.w.d.l0.n.b1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.g1;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final int a(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.s0.w.d.l0.c.o1.c r2 = r1.getAnnotations().i(k.a.r);
        if (r2 != null) goto L6;
        return 0;
    L6:
        kotlin.s0.w.d.l0.k.r.g r3 = (kotlin.s0.w.d.l0.k.r.g) m0.i(r2.a(), k.f18708d);
        kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((kotlin.s0.w.d.l0.k.r.m) r3).b().intValue();
    }

    public static final kotlin.s0.w.d.l0.n.m0 b(h r6, kotlin.s0.w.d.l0.c.o1.g r7, e0 r8, List<? extends e0> r9, List<? extends e0> r10, List<kotlin.s0.w.d.l0.g.f> r11, e0 r12, boolean r13) {
        kotlin.n0.d.o.f(r6, "builtIns");
        kotlin.n0.d.o.f(r7, "annotations");
        kotlin.n0.d.o.f(r9, "contextReceiverTypes");
        kotlin.n0.d.o.f(r10, "parameterTypes");
        kotlin.n0.d.o.f(r12, "returnType");
        List<g1> r14 = g(r8, r9, r10, r11, r12, r6);
        int r15 = r10.size() + r9.size();
        if (r8 != null) goto L5;
        int r0 = 0;
    L6:
        kotlin.s0.w.d.l0.c.e r16 = f(r6, r15 + r0, r13);
        if (r8 == null) goto L10;
        r7 = t(r7, r6);
    L10:
        if ((!r9.isEmpty()) == false) goto L13;
        r7 = s(r7, r6, r9.size());
    L13:
        return f0.g(b1.b(r7), r16, r14);
    L5:
        r0 = 1;
        goto L6
    }

    public static /* synthetic */ kotlin.s0.w.d.l0.n.m0 c(h r9, kotlin.s0.w.d.l0.c.o1.g r10, e0 r11, List r12, List r13, List r14, e0 r15, boolean r16, int r17, Object r18) {
        if ((r17 & 128) == 0) goto L5;
        boolean r8 = false;
    L7:
        return b(r9, r10, r11, r12, r13, r14, r15, r8);
    L5:
        r8 = r16;
        goto L7
    }

    public static final kotlin.s0.w.d.l0.g.f d(e0 r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        kotlin.s0.w.d.l0.c.o1.c r3 = r2.getAnnotations().i(k.a.s);
        if (r3 != null) goto L5;
        return null;
    L5:
        Object r4 = r.p0(r3.a().values());
        if ((r4 instanceof v) == false) goto L8;
        v r5 = (v) r4;
    L9:
        if (r5 == null) goto L19;
        String r6 = r5.b();
        if (r6 == null) goto L19;
        if (kotlin.s0.w.d.l0.g.f.m(r6) == true) goto L16;
        r6 = null;
    L16:
        if (r6 == null) goto L19;
        return kotlin.s0.w.d.l0.g.f.k(r6);
    L19:
        return null;
    L8:
        r5 = null;
        goto L9
    }

    public static final List<e0> e(e0 r3) {
        kotlin.n0.d.o.f(r3, "<this>");
        o(r3);
        int r0 = a(r3);
        if (r0 == 0) goto L12;
        List<g1> r4 = r3.M0().subList(0, r0);
        ArrayList r1 = new ArrayList(r.q(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L10;
        e0 r2 = ((g1) r5.next()).b();
        kotlin.n0.d.o.e(r2, "it.type");
        r1.add(r2);
        goto L7
    L10:
        return r1;
    L12:
        return r.g();
    }

    public static final kotlin.s0.w.d.l0.c.e f(h r1, int r2, boolean r3) {
        kotlin.n0.d.o.f(r1, "builtIns");
        if (r3 == false) goto L5;
        kotlin.s0.w.d.l0.c.e r4 = r1.X(r2);
    L6:
        kotlin.n0.d.o.e(r4, "if (isSuspendFunction) b…tFunction(parameterCount)");
        return r4;
    L5:
        r4 = r1.C(r2);
        goto L6
    }

    public static final List<g1> g(e0 r8, List<? extends e0> r9, List<? extends e0> r10, List<kotlin.s0.w.d.l0.g.f> r11, e0 r12, h r13) {
        kotlin.n0.d.o.f(r9, "contextReceiverTypes");
        kotlin.n0.d.o.f(r10, "parameterTypes");
        kotlin.n0.d.o.f(r12, "returnType");
        kotlin.n0.d.o.f(r13, "builtIns");
        int r1 = r10.size() + r9.size();
        int r2 = 0;
        if (r8 == null) goto L5;
        int r4 = 1;
    L6:
        ArrayList r0 = new ArrayList((r1 + r4) + 1);
        ArrayList r3 = new ArrayList(r.q(r9, 10));
        Iterator<T> r14 = r9.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r3.add(kotlin.s0.w.d.l0.n.x1.a.a((e0) r14.next()));
        goto L8
    L10:
        r0.addAll(r3);
        if (r8 == null) goto L13;
        g1 r15 = kotlin.s0.w.d.l0.n.x1.a.a(r8);
    L14:
        kotlin.s0.w.d.l0.p.a.a(r0, r15);
        Iterator<T> r16 = r10.iterator();
    L16:
        if (r16.hasNext() == false) goto L32;
        Object r17 = r16.next();
        int r5 = r2 + 1;
        if (r2 < 0) goto L30;
        e0 r18 = (e0) r17;
        if (r11 == null) goto L26;
        kotlin.s0.w.d.l0.g.f r6 = r11.get(r2);
        if (r6 == null) goto L26;
        if (r6.l() == true) goto L26;
    L27:
        if (r6 == null) goto L29;
        kotlin.s0.w.d.l0.g.c r7 = k.a.s;
        kotlin.s0.w.d.l0.g.f r19 = kotlin.s0.w.d.l0.g.f.k("name");
        String r20 = r6.b();
        kotlin.n0.d.o.e(r20, "name.asString()");
        r18 = kotlin.s0.w.d.l0.n.x1.a.u(r18, kotlin.s0.w.d.l0.c.o1.g.f18919b.a(r.j0(r18.getAnnotations(), new kotlin.s0.w.d.l0.c.o1.j(r13, r7, m0.e(a0.a(r19, new v(r20)))))));
    L29:
        r0.add(kotlin.s0.w.d.l0.n.x1.a.a(r18));
        r2 = r5;
    L26:
        r6 = null;
        goto L27
    L30:
        r.p();
        throw null;
    L32:
        r0.add(kotlin.s0.w.d.l0.n.x1.a.a(r12));
        return r0;
    L13:
        r15 = null;
        goto L14
    L5:
        r4 = 0;
        goto L6
    }

    public static final kotlin.s0.w.d.l0.b.p.c h(kotlin.s0.w.d.l0.c.m r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L6;
        return null;
    L6:
        if (h.A0(r2) == true) goto L9;
        return null;
    L9:
        return i(kotlin.s0.w.d.l0.k.t.a.i(r2));
    }

    private static final kotlin.s0.w.d.l0.b.p.c i(kotlin.s0.w.d.l0.g.d r3) {
        if (r3.f() == true) goto L5;
        return null;
    L5:
        if (r3.e() == true) goto L11;
        kotlin.s0.w.d.l0.b.p.c.a r0 = kotlin.s0.w.d.l0.b.p.c.f18756h;
        String r1 = r3.i().b();
        kotlin.n0.d.o.e(r1, "shortName().asString()");
        kotlin.s0.w.d.l0.g.c r4 = r3.l().e();
        kotlin.n0.d.o.e(r4, "toSafe().parent()");
        return r0.b(r1, r4);
    L11:
        return null;
    }

    public static final e0 j(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        o(r1);
        if (r(r1) == true) goto L6;
        return null;
    L6:
        int r0 = a(r1);
        return r1.M0().get(r0).b();
    }

    public static final e0 k(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        o(r1);
        e0 r2 = ((g1) r.b0(r1.M0())).b();
        kotlin.n0.d.o.e(r2, "arguments.last().type");
        return r2;
    }

    public static final List<g1> l(e0 r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        o(r2);
        List<g1> r0 = r2.M0();
        return r0.subList(a(r2) + (m(r2) ? 1 : 0), r0.size() - 1);
    }

    public static final boolean m(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        if (o(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (r(r1) == false) goto L7;
        return true;
    }

    public static final boolean n(kotlin.s0.w.d.l0.c.m r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.s0.w.d.l0.b.p.c r2 = h(r1);
        if (r2 != kotlin.s0.w.d.l0.b.p.c.f18757i) goto L5;
    L8:
        return true;
    L5:
        if (r2 == kotlin.s0.w.d.l0.b.p.c.f18758j) goto L8;
        return false;
    }

    public static final boolean o(e0 r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        kotlin.s0.w.d.l0.c.h r3 = r2.O0().d();
        if (r3 == null) goto L8;
        if (n(r3) != true) goto L8;
        return true;
    L8:
        return false;
    }

    public static final boolean p(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.s0.w.d.l0.c.h r2 = r1.O0().d();
        if (r2 == null) goto L5;
        kotlin.s0.w.d.l0.b.p.c r3 = h(r2);
    L7:
        if (r3 != kotlin.s0.w.d.l0.b.p.c.f18757i) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean q(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.s0.w.d.l0.c.h r2 = r1.O0().d();
        if (r2 == null) goto L5;
        kotlin.s0.w.d.l0.b.p.c r3 = h(r2);
    L7:
        if (r3 != kotlin.s0.w.d.l0.b.p.c.f18758j) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    private static final boolean r(e0 r1) {
        if (r1.getAnnotations().i(k.a.q) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final kotlin.s0.w.d.l0.c.o1.g s(kotlin.s0.w.d.l0.c.o1.g r5, h r6, int r7) {
        kotlin.n0.d.o.f(r5, "<this>");
        kotlin.n0.d.o.f(r6, "builtIns");
        kotlin.s0.w.d.l0.g.c r0 = k.a.r;
        if (r5.k(r0) == false) goto L6;
        return r5;
    L6:
        return kotlin.s0.w.d.l0.c.o1.g.f18919b.a(r.j0(r5, new kotlin.s0.w.d.l0.c.o1.j(r6, r0, m0.e(a0.a(k.f18708d, new kotlin.s0.w.d.l0.k.r.m(r7))))));
    }

    public static final kotlin.s0.w.d.l0.c.o1.g t(kotlin.s0.w.d.l0.c.o1.g r4, h r5) {
        kotlin.n0.d.o.f(r4, "<this>");
        kotlin.n0.d.o.f(r5, "builtIns");
        kotlin.s0.w.d.l0.g.c r0 = k.a.q;
        if (r4.k(r0) == false) goto L6;
        return r4;
    L6:
        return kotlin.s0.w.d.l0.c.o1.g.f18919b.a(r.j0(r4, new kotlin.s0.w.d.l0.c.o1.j(r5, r0, m0.h())));
    }
}

package kotlin.s0.w.d.l0.n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 {
    public static final a a(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        q1 r2 = r1.R0();
        if ((r2 instanceof a) == true) goto L7;
        return null;
    L7:
        return (a) r2;
    }

    public static final m0 b(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        a r2 = a(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a1();
    }

    public static final boolean c(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return r1.R0() instanceof p;
    }

    private static final d0 d(d0 r8) {
        Collection<e0> r0 = r8.a();
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r0, 10));
        Iterator<T> r2 = r0.iterator();
        boolean r3 = false;
    L3:
        e0 r6 = null;
        if (r2.hasNext() == false) goto L9;
        e0 r4 = (e0) r2.next();
        if (n1.l(r4) == false) goto L8;
        r4 = f(r4.R0(), false, 1, null);
        r3 = true;
    L8:
        r1.add(r4);
        goto L3
    L9:
        if (r3 == false) goto L22;
        e0 r9 = r8.i();
        if (r9 == null) goto L18;
        if (n1.l(r9) == false) goto L16;
        r9 = f(r9.R0(), false, 1, null);
    L16:
        r6 = r9;
    L18:
        return new d0(r1).m(r6);
    L22:
        return null;
    }

    public static final q1 e(q1 r1, boolean r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        p r3 = p.f21058i.b(r1, r2);
        if (r3 != null) goto L10;
        m0 r4 = g(r1);
        if (r4 == null) goto L9;
        return r4;
    L9:
        return r1.S0(false);
    L10:
        return r3;
    }

    public static /* synthetic */ q1 f(q1 r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return e(r0, r1);
    }

    private static final m0 g(e0 r2) {
        e1 r3 = r2.O0();
        if ((r3 instanceof d0) == false) goto L5;
        d0 r4 = (d0) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        d0 r5 = d(r4);
        if (r5 != null) goto L12;
        return null;
    L12:
        return r5.h();
    L5:
        r4 = null;
        goto L6
    }

    public static final m0 h(m0 r1, boolean r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        p r3 = p.f21058i.b(r1, r2);
        if (r3 != null) goto L10;
        m0 r4 = g(r1);
        if (r4 == null) goto L8;
        return r4;
    L8:
        return r1.V0(false);
    L10:
        return r3;
    }

    public static /* synthetic */ m0 i(m0 r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return h(r0, r1);
    }

    public static final m0 j(m0 r1, m0 r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "abbreviatedType");
        if (g0.a(r1) == false) goto L6;
        return r1;
    L6:
        return new a(r1, r2);
    }

    public static final kotlin.s0.w.d.l0.n.t1.i k(kotlin.s0.w.d.l0.n.t1.i r8) {
        kotlin.n0.d.o.f(r8, "<this>");
        return new kotlin.s0.w.d.l0.n.t1.i(r8.X0(), r8.Y0(), r8.Z0(), r8.N0(), r8.P0(), true);
    }
}

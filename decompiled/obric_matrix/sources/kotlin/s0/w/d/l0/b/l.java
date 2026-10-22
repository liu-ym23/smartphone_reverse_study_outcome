package kotlin.s0.w.d.l0.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.e0;
import kotlin.s0.w.d.l0.c.q1.k0;
import kotlin.s0.w.d.l0.c.q1.y;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final y f18730a = null;

    static {
        kotlin.s0.w.d.l0.c.q1.m r1 = new kotlin.s0.w.d.l0.c.q1.m(kotlin.s0.w.d.l0.n.u1.k.f21165a.i(), k.f18709e);
        kotlin.s0.w.d.l0.c.f r2 = kotlin.s0.w.d.l0.c.f.f18866g;
        kotlin.s0.w.d.l0.g.f r5 = k.f18710f.g();
        a1 r6 = a1.f18847a;
        kotlin.s0.w.d.l0.m.n r9 = kotlin.s0.w.d.l0.m.f.f20912e;
        y r8 = new y(r1, r2, false, false, r5, r6, r9);
        r8.N0(e0.f18863j);
        r8.P0(t.f19163e);
        r8.O0(r.d(k0.S0(r8, kotlin.s0.w.d.l0.c.o1.g.f18919b.b(), false, r1.f21066i, kotlin.s0.w.d.l0.g.f.k("T"), 0, r9)));
        r8.L0();
        f18730a = r8;
    }

    public static final m0 a(kotlin.s0.w.d.l0.n.e0 r13) {
        kotlin.n0.d.o.f(r13, "suspendFunType");
        g.q(r13);
        h r1 = kotlin.s0.w.d.l0.n.x1.a.h(r13);
        kotlin.s0.w.d.l0.c.o1.g r2 = r13.getAnnotations();
        kotlin.s0.w.d.l0.n.e0 r3 = g.j(r13);
        List<kotlin.s0.w.d.l0.n.e0> r4 = g.e(r13);
        List<g1> r0 = g.l(r13);
        ArrayList r5 = new ArrayList(r.q(r0, 10));
        Iterator<T> r6 = r0.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.add(((g1) r6.next()).b());
        goto L4
    L6:
        kotlin.s0.w.d.l0.n.a1 r7 = kotlin.s0.w.d.l0.n.a1.f20943g.h();
        e1 r8 = f18730a.k();
        kotlin.n0.d.o.e(r8, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
        List r9 = r.l0(r5, f0.i(r7, r8, r.d(kotlin.s0.w.d.l0.n.x1.a.a(g.k(r13))), false, null, 16, null));
        m0 r10 = kotlin.s0.w.d.l0.n.x1.a.h(r13).I();
        kotlin.n0.d.o.e(r10, "suspendFunType.builtIns.nullableAnyType");
        return g.c(r1, r2, r3, r4, r9, null, r10, false, 128, null).V0(r13.P0());
    }
}

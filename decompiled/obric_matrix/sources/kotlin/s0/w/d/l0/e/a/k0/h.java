package kotlin.s0.w.d.l0.e.a.k0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.q1.l0;
import kotlin.s0.w.d.l0.e.a.l0.l.k;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final List<j1> a(Collection<? extends e0> r16, Collection<? extends j1> r17, kotlin.s0.w.d.l0.c.a r18) {
        o.f(r16, "newValueParameterTypes");
        o.f(r17, "oldValueParameters");
        o.f(r18, "newOwner");
        r16.size();
        r17.size();
        List r0 = r.G0(r16, r17);
        ArrayList r14 = new ArrayList(r.q(r0, 10));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        u r2 = (u) r1.next();
        e0 r7 = (e0) r2.a();
        j1 r3 = (j1) r2.b();
        int r4 = r3.j();
        kotlin.s0.w.d.l0.c.o1.g r5 = r3.getAnnotations();
        kotlin.s0.w.d.l0.g.f r6 = r3.getName();
        o.e(r6, "oldParameter.name");
        boolean r8 = r3.u0();
        boolean r9 = r3.b0();
        boolean r10 = r3.X();
        if (r3.l0() == null) goto L8;
        e0 r11 = kotlin.s0.w.d.l0.k.t.a.l(r18).o().k(r7);
    L9:
        a1 r12 = r3.getSource();
        o.e(r12, "oldParameter.source");
        r14.add(new l0(r18, null, r4, r5, r6, r7, r8, r9, r10, r11, r12));
        goto L4
    L8:
        r11 = null;
        goto L9
    L10:
        return r14;
    }

    public static final k b(kotlin.s0.w.d.l0.c.e r3) {
        o.f(r3, "<this>");
        kotlin.s0.w.d.l0.c.e r4 = kotlin.s0.w.d.l0.k.t.a.p(r3);
        k r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        kotlin.s0.w.d.l0.k.w.h r1 = r4.R();
        if ((r1 instanceof k) == false) goto L8;
        r0 = (k) r1;
    L8:
        if (r0 == null) goto L10;
        return r0;
    L10:
        return b(r4);
    }
}

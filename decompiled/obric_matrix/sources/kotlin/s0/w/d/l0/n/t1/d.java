package kotlin.s0.w.d.l0.n.t1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.n.b0;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.g0;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final q1 a(List<? extends q1> r9) {
        kotlin.n0.d.o.f(r9, "types");
        int r0 = r9.size();
        if (r0 == 0) goto L43;
        if (r0 == 1) goto L41;
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r9, 10));
        Iterator<T> r3 = r9.iterator();
        boolean r5 = false;
        boolean r6 = false;
    L8:
        if (r3.hasNext() == false) goto L28;
        q1 r7 = (q1) r3.next();
        if (r5 == false) goto L12;
    L15:
        r5 = true;
    L17:
        if ((r7 instanceof m0) == false) goto L20;
        m0 r8 = (m0) r7;
    L25:
        r1.add(r8);
        goto L8
    L20:
        if ((r7 instanceof kotlin.s0.w.d.l0.n.y) == false) goto L27;
        if (kotlin.s0.w.d.l0.n.w.a(r7) == true) goto L23;
        r8 = ((kotlin.s0.w.d.l0.n.y) r7).W0();
        r6 = true;
        goto L25
    L23:
        return r7;
    L27:
        throw new kotlin.m();
    L12:
        if (g0.a(r7) == true) goto L15;
        r5 = false;
        goto L17
    L28:
        if (r5 == true) goto L30;
        if (r6 == false) goto L33;
        ArrayList r2 = new ArrayList(kotlin.i0.r.q(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L36:
        if (r10.hasNext() == false) goto L38;
        r2.add(b0.d((q1) r10.next()));
        goto L36
    L38:
        w r11 = w.f21111a;
        return f0.d(r11.c(r1), r11.c(r2));
    L33:
        return w.f21111a.c(r1);
    L30:
        return kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.A0, new String[]{r9.toString()});
    L41:
        return (q1) kotlin.i0.r.o0(r9);
    L43:
        throw new IllegalStateException("Expected some types".toString());
    }
}

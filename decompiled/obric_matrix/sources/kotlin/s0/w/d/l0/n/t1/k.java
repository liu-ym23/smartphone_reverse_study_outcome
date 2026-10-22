package kotlin.s0.w.d.l0.n.t1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.q1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    private static final List<g1> a(q1 r12, kotlin.s0.w.d.l0.n.w1.b r13) {
        if (r12.M0().size() == r12.O0().getParameters().size()) goto L5;
        return null;
    L5:
        List<g1> r0 = r12.M0();
        int r3 = 0;
        boolean r4 = true;
        if ((r0 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L19;
        if (((g1) r1.next()).a() != r1.f21065h) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == true) goto L12;
        r4 = false;
        goto L19
    L16:
        r5 = false;
    L19:
        if (r4 == false) goto L21;
        return null;
    L21:
        List<f1> r2 = r12.O0().getParameters();
        kotlin.n0.d.o.e(r2, "type.constructor.parameters");
        List r6 = kotlin.i0.r.G0(r0, r2);
        ArrayList r7 = new ArrayList(kotlin.i0.r.q(r6, 10));
        Iterator r8 = r6.iterator();
    L23:
        if (r8.hasNext() == false) goto L35;
        kotlin.u r9 = (kotlin.u) r8.next();
        g1 r10 = (g1) r9.a();
        f1 r11 = (f1) r9.b();
        if (r10.a() == r1.f21065h) goto L34;
        if (r10.d() == false) goto L30;
    L32:
        q1 r14 = null;
    L33:
        kotlin.n0.d.o.e(r11, "parameter");
        r10 = kotlin.s0.w.d.l0.n.x1.a.a(new i(r13, r14, r10, r11));
        goto L34
    L30:
        if (r10.a() != r1.f21066i) goto L32;
        r14 = r10.b().R0();
    L34:
        r7.add(r10);
        goto L23
    L35:
        l1 r15 = kotlin.s0.w.d.l0.n.f1.f21004b.b(r12.O0(), r7).c();
        int r16 = r0.size();
    L36:
        if (r3 >= r16) goto L51;
        g1 r17 = r0.get(r3);
        g1 r18 = (g1) r7.get(r3);
        if (r17.a() == r1.f21065h) goto L50;
        List<e0> r19 = r12.O0().getParameters().get(r3).getUpperBounds();
        kotlin.n0.d.o.e(r19, "type.constructor.parameters[index].upperBounds");
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r19.iterator();
    L41:
        if (r21.hasNext() == false) goto L44;
        r20.add(f.a.f21079a.b(r15.n((e0) r21.next(), r1.f21065h).R0()));
        goto L41
    L44:
        if (r17.d() == false) goto L46;
    L48:
        q1 r22 = null;
    L49:
        e0 r23 = r18.b();
        kotlin.n0.d.o.d(r23, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
        ((i) r23).Y0().j(r22, r20);
        goto L50
    L46:
        if (r17.a() != r1.f21067j) goto L48;
        r22 = f.a.f21079a.b(r17.b().R0());
    L50:
        r3 = r3 + 1;
        goto L36
    L51:
        return r7;
    L8:
        if (r0.isEmpty() == false) goto L10;
        goto L10
    }

    public static final m0 b(m0 r1, kotlin.s0.w.d.l0.n.w1.b r2) {
        kotlin.n0.d.o.f(r1, WsConstants.KEY_CONNECTION_TYPE);
        kotlin.n0.d.o.f(r2, "status");
        List<g1> r3 = a(r1, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return c(r1, r3);
    }

    private static final m0 c(q1 r7, List<? extends g1> r8) {
        return f0.i(r7.N0(), r7.O0(), r8, r7.P0(), null, 16, null);
    }
}

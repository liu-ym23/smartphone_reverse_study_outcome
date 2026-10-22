package kotlin.s0.w.d.l0.e.b;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.n.m1;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {
    public static final <T> T a(m<T> r1, T r2, boolean r3) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "possiblyPrimitiveType");
        if (r3 == true) goto L5;
        return r2;
    L5:
        return r1.d(r2);
    }

    public static final <T> T b(m1 r5, kotlin.s0.w.d.l0.n.w1.i r6, m<T> r7, a0 r8) {
        kotlin.n0.d.o.f(r5, "<this>");
        kotlin.n0.d.o.f(r6, WsConstants.KEY_CONNECTION_TYPE);
        kotlin.n0.d.o.f(r7, "typeFactory");
        kotlin.n0.d.o.f(r8, "mode");
        kotlin.s0.w.d.l0.n.w1.n r0 = r5.w(r6);
        if (r5.V(r0) == true) goto L5;
        return null;
    L5:
        kotlin.s0.w.d.l0.b.i r1 = r5.i0(r0);
        boolean r3 = true;
        if (r1 == null) goto L15;
        T r9 = r7.f(r1);
        if (r5.p0(r6) == true) goto L14;
        if (kotlin.s0.w.d.l0.e.a.o0.s.c(r5, r6) == true) goto L14;
        r3 = false;
    L14:
        return (T) a(r7, r9, r3);
    L15:
        kotlin.s0.w.d.l0.b.i r10 = r5.l(r0);
        if (r10 == null) goto L20;
        return r7.b('[' + kotlin.s0.w.d.l0.k.u.e.c(r10).g());
    L20:
        if (r5.i(r0) == false) goto L42;
        kotlin.s0.w.d.l0.g.d r11 = r5.K(r0);
        if (r11 == null) goto L24;
        kotlin.s0.w.d.l0.g.b r12 = kotlin.s0.w.d.l0.b.q.c.f18771a.n(r11);
    L25:
        if (r12 == null) goto L42;
        if (r8.a() == true) goto L40;
        List<kotlin.s0.w.d.l0.b.q.c.a> r13 = kotlin.s0.w.d.l0.b.q.c.f18771a.i();
        if ((r13 instanceof Collection) == true) goto L31;
    L33:
        Iterator<T> r14 = r13.iterator();
    L35:
        if (r14.hasNext() == false) goto L32;
        if (kotlin.n0.d.o.a(((kotlin.s0.w.d.l0.b.q.c.a) r14.next()).d(), r12) == false) goto L35;
    L38:
        if (r3 == false) goto L40;
        return null;
    L32:
        r3 = false;
        goto L38
    L31:
        if (r13.isEmpty() == false) goto L33;
    L40:
        String r15 = kotlin.s0.w.d.l0.k.u.d.b(r12).f();
        kotlin.n0.d.o.e(r15, "byClassId(classId).internalName");
        return r7.c(r15);
    L24:
        r12 = null;
    L42:
        return null;
    }
}

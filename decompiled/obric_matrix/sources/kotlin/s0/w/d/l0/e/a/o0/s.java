package kotlin.s0.w.d.l0.e.a.o0;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.i0.t0;
import kotlin.s0.w.d.l0.e.a.a0;
import kotlin.s0.w.d.l0.n.m1;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static final e a(e r6, Collection<e> r7, boolean r8, boolean r9, boolean r10) {
        kotlin.n0.d.o.f(r6, "<this>");
        kotlin.n0.d.o.f(r7, "superQualifiers");
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r7.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        h r2 = b((e) r1.next());
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        h r3 = e(kotlin.i0.r.D0(r0), b(r6), r8);
        if (r3 != null) goto L17;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r7.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        h r11 = ((e) r5.next()).d();
        if (r11 == null) goto L12;
        r4.add(r11);
        goto L12
    L16:
        h r12 = e(kotlin.i0.r.D0(r4), r6.d(), r8);
    L18:
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r7.iterator();
    L20:
        if (r14.hasNext() == false) goto L24;
        f r15 = ((e) r14.next()).c();
        if (r15 == null) goto L20;
        r13.add(r15);
        goto L20
    L24:
        f r16 = (f) d(kotlin.i0.r.D0(r13), f.f19556g, f.f19555f, r6.c(), r8);
        h r17 = null;
        boolean r18 = true;
        if (r12 == null) goto L36;
        if (r10 == true) goto L32;
        if (r9 == true) goto L29;
    L31:
        boolean r19 = false;
    L33:
        if (r19 == true) goto L36;
        r17 = r12;
        goto L36
    L29:
        if (r12 != h.f19560g) goto L31;
    L32:
        r19 = true;
    L36:
        if (r17 == h.f19561h) goto L38;
    L50:
        boolean r20 = false;
    L51:
        if (r17 == null) goto L54;
        if (r3 == r12) goto L54;
    L56:
        return new e(r17, r16, r20, r18);
    L54:
        r18 = false;
        goto L56
    L38:
        if (r6.b() == false) goto L40;
    L49:
        r20 = true;
        goto L51
    L40:
        if (r7.isEmpty() == false) goto L42;
    L41:
        boolean r21 = false;
    L48:
        if (r21 == false) goto L50;
    L42:
        Iterator<T> r22 = r7.iterator();
    L44:
        if (r22.hasNext() == false) goto L41;
        if (((e) r22.next()).b() == false) goto L44;
        r21 = true;
        goto L48
    L17:
        r12 = r3;
        goto L18
    }

    private static final h b(e r1) {
        if (r1.e() == false) goto L6;
        return null;
    L6:
        return r1.d();
    }

    public static final boolean c(m1 r2, kotlin.s0.w.d.l0.n.w1.i r3) {
        kotlin.n0.d.o.f(r2, "<this>");
        kotlin.n0.d.o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
        kotlin.s0.w.d.l0.g.c r0 = a0.p;
        kotlin.n0.d.o.e(r0, "ENHANCED_NULLABILITY_ANNOTATION");
        return r2.l0(r3, r0);
    }

    private static final <T> T d(Set<? extends T> r1, T r2, T r3, T r4, boolean r5) {
        if (r5 == true) goto L4;
        if (r4 == null) goto L24;
        Set<? extends T> r6 = kotlin.i0.r.D0(t0.i(r1, r4));
        if (r6 == null) goto L24;
        r1 = r6;
    L24:
        return (T) kotlin.i0.r.p0(r1);
    L4:
        if (r1.contains(r2) == false) goto L7;
        T r7 = r2;
    L11:
        if (kotlin.n0.d.o.a(r7, r2) == true) goto L13;
    L15:
        if (r4 == null) goto L17;
        return r4;
    L17:
        return r7;
    L13:
        if (kotlin.n0.d.o.a(r4, r3) == false) goto L15;
        return null;
    L7:
        if (r1.contains(r3) == false) goto L9;
        r7 = r3;
        goto L11
    L9:
        r7 = null;
        goto L11
    }

    private static final h e(Set<? extends h> r2, h r3, boolean r4) {
        h r0 = h.f19559f;
        if (r3 != r0) goto L6;
        return r0;
    L6:
        return (h) d(r2, h.f19561h, h.f19560g, r3, r4);
    }
}

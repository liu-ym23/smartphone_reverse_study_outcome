package kotlin.s0.w.d.l0.n.t1;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f1;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    private static final e0 a(e0 r0) {
        return kotlin.s0.w.d.l0.n.y1.b.a(r0).d();
    }

    private static final String b(e1 r4) {
        StringBuilder r0 = new StringBuilder();
        c("type: " + r4, r0);
        c("hashCode: " + r4.hashCode(), r0);
        c("javaClass: " + r4.getClass().getCanonicalName(), r0);
        kotlin.s0.w.d.l0.c.m r5 = r4.d();
    L3:
        if (r5 == null) goto L5;
        c("fqName: " + kotlin.s0.w.d.l0.j.c.f20438b.q(r5), r0);
        c("javaClass: " + r5.getClass().getCanonicalName(), r0);
        r5 = r5.c();
        goto L3
    L5:
        String r6 = r0.toString();
        kotlin.n0.d.o.e(r6, "StringBuilder().apply(builderAction).toString()");
        return r6;
    }

    private static final StringBuilder c(String r1, StringBuilder r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        r2.append(r1);
        kotlin.n0.d.o.e(r2, "append(value)");
        r2.append('\n');
        kotlin.n0.d.o.e(r2, "append('\\n')");
        return r2;
    }

    public static final e0 d(e0 r9, e0 r10, v r11) {
        kotlin.n0.d.o.f(r9, "subtype");
        kotlin.n0.d.o.f(r10, "supertype");
        kotlin.n0.d.o.f(r11, "typeCheckingProcedureCallbacks");
        ArrayDeque r0 = new ArrayDeque();
        r0.add(new s(r9, null));
        e1 r12 = r10.O0();
    L4:
        if (r0.isEmpty() == true) goto L43;
        s r13 = (s) r0.poll();
        e0 r1 = r13.b();
        e1 r3 = r1.O0();
        if (r11.a(r3, r12) == true) goto L7;
        Iterator<e0> r2 = r3.a().iterator();
    L41:
        if (r2.hasNext() == false) goto L4;
        e0 r4 = r2.next();
        kotlin.n0.d.o.e(r4, "immediateSupertype");
        r0.add(new s(r4, r13));
        goto L41
    L7:
        boolean r5 = r1.P0();
    L8:
        r13 = r13.a();
        if (r13 == null) goto L33;
        e0 r6 = r13.b();
        List<g1> r7 = r6.M0();
        if ((r7 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r8 = r7.iterator();
    L17:
        if (r8.hasNext() == false) goto L14;
        if (((g1) r8.next()).a() == r1.f21065h) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L17;
        boolean r15 = true;
    L24:
        if (r15 == false) goto L26;
        e0 r16 = kotlin.s0.w.d.l0.k.q.a.d.f(f1.f21004b.a(r6), false, 1, null).c().n(r1, r1.f21065h);
        kotlin.n0.d.o.e(r16, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
        r1 = a(r16);
    L27:
        if (r5 == true) goto L32;
        if (r6.P0() == true) goto L32;
        r5 = false;
    L32:
        r5 = true;
        goto L8
    L26:
        r1 = f1.f21004b.a(r6).c().n(r1, r1.f21065h);
        kotlin.n0.d.o.e(r1, "{\n                    Ty…ARIANT)\n                }");
        goto L27
    L21:
        r14 = false;
    L14:
        r15 = false;
        goto L24
    L13:
        if (r7.isEmpty() == false) goto L15;
    L33:
        e1 r17 = r1.O0();
        if (r11.a(r17, r12) == false) goto L38;
        return n1.p(r1, r5);
    L38:
        throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(r17) + ", \n\nsupertype: " + b(r12) + " \n" + r11.a(r17, r12));
    L43:
        return null;
    }
}

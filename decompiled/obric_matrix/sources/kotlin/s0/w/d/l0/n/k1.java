package kotlin.s0.w.d.l0.n;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 {
    public static final m0 a(e0 r3) {
        kotlin.n0.d.o.f(r3, "<this>");
        q1 r0 = r3.R0();
        if ((r0 instanceof m0) == false) goto L5;
        m0 r1 = (m0) r0;
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new IllegalStateException(("This is should be simple type: " + r3).toString());
    L5:
        r1 = null;
        goto L6
    }

    public static final e0 b(e0 r7, List<? extends g1> r8, kotlin.s0.w.d.l0.c.o1.g r9) {
        kotlin.n0.d.o.f(r7, "<this>");
        kotlin.n0.d.o.f(r8, "newArguments");
        kotlin.n0.d.o.f(r9, "newAnnotations");
        return e(r7, r8, r9, null, 4, null);
    }

    public static final e0 c(e0 r2, List<? extends g1> r3, kotlin.s0.w.d.l0.c.o1.g r4, List<? extends g1> r5) {
        kotlin.n0.d.o.f(r2, "<this>");
        kotlin.n0.d.o.f(r3, "newArguments");
        kotlin.n0.d.o.f(r4, "newAnnotations");
        kotlin.n0.d.o.f(r5, "newArgumentsForUpperBound");
        if (r3.isEmpty() == true) goto L7;
        if (r3 == r2.M0()) goto L7;
    L9:
        a1 r0 = r2.N0();
        if ((r4 instanceof kotlin.s0.w.d.l0.c.o1.l) == true) goto L12;
    L14:
        a1 r6 = b1.a(r0, r4);
        q1 r7 = r2.R0();
        if ((r7 instanceof y) == false) goto L18;
        y r8 = (y) r7;
        return f0.d(d(r8.W0(), r3, r6), d(r8.X0(), r5, r6));
    L18:
        if ((r7 instanceof m0) == false) goto L22;
        return d((m0) r7, r3, r6);
    L22:
        throw new kotlin.m();
    L12:
        if (r4.isEmpty() == false) goto L14;
        r4 = kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
    L7:
        if (r4 != r2.getAnnotations()) goto L9;
        return r2;
    }

    public static final m0 d(m0 r7, List<? extends g1> r8, a1 r9) {
        kotlin.n0.d.o.f(r7, "<this>");
        kotlin.n0.d.o.f(r8, "newArguments");
        kotlin.n0.d.o.f(r9, "newAttributes");
        if (r8.isEmpty() == false) goto L8;
        if (r9 != r7.N0()) goto L8;
        return r7;
    L8:
        if (r8.isEmpty() == false) goto L12;
        return r7.W0(r9);
    L12:
        return f0.i(r9, r7.O0(), r8, r7.P0(), null, 16, null);
    }

    public static /* synthetic */ e0 e(e0 r0, List r1, kotlin.s0.w.d.l0.c.o1.g r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.M0();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getAnnotations();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r1;
    L12:
        return c(r0, r1, r2, r3);
    }

    public static /* synthetic */ m0 f(m0 r0, List r1, a1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.M0();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.N0();
    L9:
        return d(r0, r1, r2);
    }
}

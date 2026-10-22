package kotlin.s0.w.d.l0.n;

import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class x {
    public static final kotlin.s0.w.d.l0.n.w1.i a(m1 r1, kotlin.s0.w.d.l0.n.w1.i r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "inlineClassType");
        return b(r1, r2, new HashSet());
    }

    private static final kotlin.s0.w.d.l0.n.w1.i b(m1 r3, kotlin.s0.w.d.l0.n.w1.i r4, HashSet<kotlin.s0.w.d.l0.n.w1.n> r5) {
        kotlin.s0.w.d.l0.n.w1.n r0 = r3.w(r4);
        if (r5.add(r0) == true) goto L5;
        return null;
    L5:
        kotlin.s0.w.d.l0.n.w1.o r1 = r3.F(r0);
        if (r1 == null) goto L35;
        kotlin.s0.w.d.l0.n.w1.i r2 = r3.m(r1);
        kotlin.s0.w.d.l0.n.w1.i r6 = b(r3, r2, r5);
        if (r6 == null) goto L56;
        if (r3.a0(r3.w(r2)) == false) goto L12;
    L17:
        boolean r7 = true;
    L19:
        if ((r6 instanceof kotlin.s0.w.d.l0.n.w1.k) == false) goto L27;
        if (r3.E0((kotlin.s0.w.d.l0.n.w1.k) r6) == false) goto L27;
        if (r3.p0(r4) == false) goto L27;
        if (r7 == false) goto L27;
        kotlin.s0.w.d.l0.n.w1.i r8 = r3.C0(r2);
    L55:
        return r8;
    L27:
        if (r3.p0(r6) == true) goto L58;
        if (r3.o0(r4) == false) goto L58;
        r8 = r3.C0(r6);
    L58:
        return r6;
    L12:
        if ((r2 instanceof kotlin.s0.w.d.l0.n.w1.k) == true) goto L14;
    L16:
        r7 = false;
        goto L19
    L14:
        if (r3.E0((kotlin.s0.w.d.l0.n.w1.k) r2) == false) goto L16;
    L56:
        return null;
    L35:
        if (r3.a0(r0) == false) goto L57;
        kotlin.s0.w.d.l0.n.w1.i r9 = r3.b0(r4);
        if (r9 != null) goto L39;
        return null;
    L39:
        r6 = b(r3, r9, r5);
        if (r6 != null) goto L43;
        return null;
    L43:
        if (r3.p0(r4) == false) goto L58;
        if (r3.p0(r6) == false) goto L49;
        return r4;
    L49:
        if ((r6 instanceof kotlin.s0.w.d.l0.n.w1.k) == false) goto L54;
        if (r3.E0((kotlin.s0.w.d.l0.n.w1.k) r6) == false) goto L54;
        return r4;
    L54:
        return r3.C0(r6);
    L57:
        return r4;
    }
}

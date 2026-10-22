package kotlin.s0.w.d.l0.n.t1;

import kotlin.s0.w.d.l0.n.d1;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final d1 a(boolean r8, boolean r9, b r10, f r11, g r12) {
        kotlin.n0.d.o.f(r10, "typeSystemContext");
        kotlin.n0.d.o.f(r11, "kotlinTypePreparator");
        kotlin.n0.d.o.f(r12, "kotlinTypeRefiner");
        return new d1(r8, r9, true, r10, r11, r12);
    }

    public static /* synthetic */ d1 b(boolean r0, boolean r1, b r2, f r3, g r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r1 = true;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r2 = q.f21107a;
    L9:
        if ((r5 & 8) == 0) goto L12;
        r3 = f.a.f21079a;
    L12:
        if ((r5 & 16) == 0) goto L15;
        r4 = g.a.f21080a;
    L15:
        return a(r0, r1, r2, r3, r4);
    }
}

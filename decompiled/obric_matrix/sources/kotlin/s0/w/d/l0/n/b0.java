package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {
    public static final y a(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        q1 r2 = r1.R0();
        kotlin.n0.d.o.d(r2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (y) r2;
    }

    public static final boolean b(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return r1.R0() instanceof y;
    }

    public static final m0 c(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        q1 r2 = r1.R0();
        if ((r2 instanceof y) == false) goto L6;
        return ((y) r2).W0();
    L6:
        if ((r2 instanceof m0) == false) goto L10;
        return (m0) r2;
    L10:
        throw new kotlin.m();
    }

    public static final m0 d(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        q1 r2 = r1.R0();
        if ((r2 instanceof y) == false) goto L6;
        return ((y) r2).X0();
    L6:
        if ((r2 instanceof m0) == false) goto L10;
        return (m0) r2;
    L10:
        throw new kotlin.m();
    }
}

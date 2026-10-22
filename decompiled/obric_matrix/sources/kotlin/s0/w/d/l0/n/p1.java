package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final e0 a(e0 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        if ((r1 instanceof o1) == true) goto L7;
        return null;
    L7:
        return ((o1) r1).F();
    }

    public static final q1 b(q1 r1, e0 r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "origin");
        return d(r1, a(r2));
    }

    public static final q1 c(q1 r1, e0 r2, kotlin.n0.c.l<? super e0, ? extends e0> r3) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "origin");
        kotlin.n0.d.o.f(r3, "transform");
        e0 r4 = a(r2);
        if (r4 == null) goto L5;
        e0 r5 = r3.invoke(r4);
    L7:
        return d(r1, r5);
    L5:
        r5 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final q1 d(q1 r1, e0 r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        if ((r1 instanceof o1) == true) goto L5;
        if (r2 != null) goto L8;
    L19:
        return r1;
    L8:
        if (kotlin.n0.d.o.a(r2, r1) == true) goto L19;
        if ((r1 instanceof m0) == false) goto L14;
        return new p0((m0) r1, r2);
    L14:
        if ((r1 instanceof y) == false) goto L18;
        return new a0((y) r1, r2);
    L18:
        throw new kotlin.m();
    L5:
        return d(((o1) r1).F0(), r2);
    }
}

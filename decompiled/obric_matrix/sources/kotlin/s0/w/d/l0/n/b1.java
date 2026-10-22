package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 {
    public static final a1 a(a1 r1, kotlin.s0.w.d.l0.c.o1.g r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "newAnnotations");
        if (k.a(r1) != r2) goto L5;
        return r1;
    L5:
        j r0 = k.b(r1);
        if (r0 == null) goto L12;
        a1 r3 = r1.p(r0);
        if (r3 == null) goto L12;
        r1 = r3;
    L12:
        if (r2.iterator().hasNext() == true) goto L17;
        if (r2.isEmpty() == false) goto L17;
        return r1;
    L17:
        return r1.o(new j(r2));
    }

    public static final a1 b(kotlin.s0.w.d.l0.c.o1.g r7) {
        kotlin.n0.d.o.f(r7, "<this>");
        return z0.a.a(o.f21056a, r7, null, null, 6, null);
    }
}

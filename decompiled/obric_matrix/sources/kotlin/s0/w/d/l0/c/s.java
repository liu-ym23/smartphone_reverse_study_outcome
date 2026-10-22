package kotlin.s0.w.d.l0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static final h a(m r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        m r0 = r2.c();
        if (r0 != null) goto L5;
        return null;
    L5:
        if ((r2 instanceof l0) == false) goto L8;
        return null;
    L8:
        if (b(r0) == true) goto L11;
        return a(r0);
    L11:
        if ((r0 instanceof h) == true) goto L13;
        return null;
    L13:
        return (h) r0;
    }

    public static final boolean b(m r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return r1.c() instanceof l0;
    }

    public static final e c(h0 r5, kotlin.s0.w.d.l0.g.c r6, kotlin.s0.w.d.l0.d.b.b r7) {
        kotlin.n0.d.o.f(r5, "<this>");
        kotlin.n0.d.o.f(r6, "fqName");
        kotlin.n0.d.o.f(r7, "lookupLocation");
        if (r6.d() == false) goto L5;
        return null;
    L5:
        kotlin.s0.w.d.l0.g.c r0 = r6.e();
        kotlin.n0.d.o.e(r0, "fqName.parent()");
        kotlin.s0.w.d.l0.k.w.h r1 = r5.N(r0).q();
        kotlin.s0.w.d.l0.g.f r3 = r6.g();
        kotlin.n0.d.o.e(r3, "fqName.shortName()");
        h r2 = r1.f(r3, r7);
        if ((r2 instanceof e) == false) goto L8;
        e r4 = (e) r2;
    L9:
        if (r4 == null) goto L11;
        return r4;
    L11:
        kotlin.s0.w.d.l0.g.c r8 = r6.e();
        kotlin.n0.d.o.e(r8, "fqName.parent()");
        e r9 = c(r5, r8, r7);
        if (r9 == null) goto L16;
        kotlin.s0.w.d.l0.k.w.h r10 = r9.y0();
        if (r10 == null) goto L16;
        kotlin.s0.w.d.l0.g.f r11 = r6.g();
        kotlin.n0.d.o.e(r11, "fqName.shortName()");
        h r12 = r10.f(r11, r7);
    L18:
        if ((r12 instanceof e) == true) goto L20;
        return null;
    L20:
        return (e) r12;
    L16:
        r12 = null;
        goto L18
    L8:
        r4 = null;
        goto L9
    }
}

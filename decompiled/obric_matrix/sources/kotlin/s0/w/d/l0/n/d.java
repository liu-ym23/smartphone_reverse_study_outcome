package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f20949a = null;

    static {
        f20949a = new d();
    }

    private d() {
    }

    private final boolean a(kotlin.s0.w.d.l0.n.w1.p r9, kotlin.s0.w.d.l0.n.w1.k r10, kotlin.s0.w.d.l0.n.w1.k r11) {
        if (r9.j(r10) == r9.j(r11)) goto L5;
    L36:
        return false;
    L5:
        if (r9.W(r10) != r9.W(r11)) goto L36;
        if (r9.s0(r10) != null) goto L9;
        boolean r0 = true;
    L11:
        if (r9.s0(r11) != null) goto L13;
        boolean r3 = true;
    L14:
        if (r0 != r3) goto L36;
        if (r9.A0(r9.c(r10), r9.c(r11)) == false) goto L36;
        if (r9.t0(r10, r11) == false) goto L21;
        return true;
    L21:
        int r1 = r9.j(r10);
        int r4 = 0;
    L22:
        if (r4 >= r1) goto L35;
        kotlin.s0.w.d.l0.n.w1.m r5 = r9.g0(r10, r4);
        kotlin.s0.w.d.l0.n.w1.m r6 = r9.g0(r11, r4);
        if (r9.L(r5) != r9.L(r6)) goto L25;
        if (r9.L(r5) == true) goto L34;
        if (r9.j0(r5) != r9.j0(r6)) goto L30;
        if (c(r9, r9.x0(r5), r9.x0(r6)) == true) goto L34;
        return false;
    L30:
        return false;
    L34:
        r4 = r4 + 1;
        goto L22
    L25:
        return false;
    L35:
        return true;
    L13:
        r3 = false;
        goto L14
    L9:
        r0 = false;
        goto L11
    }

    private final boolean c(kotlin.s0.w.d.l0.n.w1.p r5, kotlin.s0.w.d.l0.n.w1.i r6, kotlin.s0.w.d.l0.n.w1.i r7) {
        if (r6 != r7) goto L5;
        return true;
    L5:
        kotlin.s0.w.d.l0.n.w1.k r1 = r5.a(r6);
        kotlin.s0.w.d.l0.n.w1.k r2 = r5.a(r7);
        if (r1 == null) goto L10;
        if (r2 == null) goto L10;
        return a(r5, r1, r2);
    L10:
        kotlin.s0.w.d.l0.n.w1.g r8 = r5.M(r6);
        kotlin.s0.w.d.l0.n.w1.g r9 = r5.M(r7);
        if (r8 == null) goto L20;
        if (r9 == null) goto L20;
        if (a(r5, r5.g(r8), r5.g(r9)) == false) goto L19;
        if (a(r5, r5.e(r8), r5.e(r9)) == false) goto L19;
        return true;
    L19:
        return false;
    L20:
        return false;
    }

    public final boolean b(kotlin.s0.w.d.l0.n.w1.p r2, kotlin.s0.w.d.l0.n.w1.i r3, kotlin.s0.w.d.l0.n.w1.i r4) {
        kotlin.n0.d.o.f(r2, "context");
        kotlin.n0.d.o.f(r3, "a");
        kotlin.n0.d.o.f(r4, "b");
        return c(r2, r3, r4);
    }
}

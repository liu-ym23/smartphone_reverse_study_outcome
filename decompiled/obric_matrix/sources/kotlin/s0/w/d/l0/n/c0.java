package kotlin.s0.w.d.l0.n;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends j1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.f1[] f20946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g1[] f20947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f20948d;

    public c0(List<? extends kotlin.s0.w.d.l0.c.f1> r9, List<? extends g1> r10) {
        kotlin.n0.d.o.f(r9, "parameters");
        kotlin.n0.d.o.f(r10, "argumentsList");
        Object[] r11 = r9.toArray(new kotlin.s0.w.d.l0.c.f1[0]);
        kotlin.n0.d.o.d(r11, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        kotlin.s0.w.d.l0.c.f1[] r3 = (kotlin.s0.w.d.l0.c.f1[]) r11;
        Object[] r12 = r10.toArray(new g1[0]);
        kotlin.n0.d.o.d(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this(r3, (g1[]) r12, false, 4, null);
    }

    public c0(kotlin.s0.w.d.l0.c.f1[] r2, g1[] r3, boolean r4) {
        kotlin.n0.d.o.f(r2, "parameters");
        kotlin.n0.d.o.f(r3, "arguments");
        this.f20946b = r2;
        this.f20947c = r3;
        this.f20948d = r4;
        int r1 = r2.length;
        int r5 = r3.length;
    }

    public /* synthetic */ c0(kotlin.s0.w.d.l0.c.f1[] r1, g1[] r2, boolean r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public boolean b() {
        return this.f20948d;
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public g1 e(e0 r5) {
        kotlin.n0.d.o.f(r5, "key");
        kotlin.s0.w.d.l0.c.h r6 = r5.O0().d();
        if ((r6 instanceof kotlin.s0.w.d.l0.c.f1) == false) goto L5;
        kotlin.s0.w.d.l0.c.f1 r7 = (kotlin.s0.w.d.l0.c.f1) r6;
    L6:
        if (r7 != null) goto L8;
        return null;
    L8:
        int r0 = r7.j();
        kotlin.s0.w.d.l0.c.f1[] r2 = this.f20946b;
        if (r0 < r2.length) goto L11;
    L14:
        return null;
    L11:
        if (kotlin.n0.d.o.a(r2[r0].k(), r7.k()) == false) goto L14;
        return this.f20947c[r0];
    L5:
        r7 = null;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public boolean f() {
        if (this.f20947c.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final g1[] i() {
        return this.f20947c;
    }

    public final kotlin.s0.w.d.l0.c.f1[] j() {
        return this.f20946b;
    }
}

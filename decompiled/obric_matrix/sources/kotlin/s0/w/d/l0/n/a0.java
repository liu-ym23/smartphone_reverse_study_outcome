package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends y implements o1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final y f20941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final e0 f20942j;

    public a0(y r3, e0 r4) {
        kotlin.n0.d.o.f(r3, "origin");
        kotlin.n0.d.o.f(r4, "enhancement");
        super(r3.W0(), r3.X0());
        this.f20941i = r3;
        this.f20942j = r4;
    }

    @Override // kotlin.s0.w.d.l0.n.o1
    public e0 F() {
        return this.f20942j;
    }

    @Override // kotlin.s0.w.d.l0.n.o1
    public /* bridge */ /* synthetic */ q1 F0() {
        return Z0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return a1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public q1 S0(boolean r2) {
        return p1.d(Z0().S0(r2), F().R0().S0(r2));
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return a1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public q1 U0(a1 r2) {
        kotlin.n0.d.o.f(r2, "newAttributes");
        return p1.d(Z0().U0(r2), F());
    }

    @Override // kotlin.s0.w.d.l0.n.y
    public m0 V0() {
        return Z0().V0();
    }

    @Override // kotlin.s0.w.d.l0.n.y
    public String Y0(kotlin.s0.w.d.l0.j.c r2, kotlin.s0.w.d.l0.j.f r3) {
        kotlin.n0.d.o.f(r2, "renderer");
        kotlin.n0.d.o.f(r3, "options");
        if (r3.f() == false) goto L7;
        return r2.w(F());
    L7:
        return Z0().Y0(r2, r3);
    }

    public y Z0() {
        return this.f20941i;
    }

    public a0 a1(kotlin.s0.w.d.l0.n.t1.g r4) {
        kotlin.n0.d.o.f(r4, "kotlinTypeRefiner");
        e0 r1 = r4.h(Z0());
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return new a0((y) r1, r4.h(F()));
    }

    @Override // kotlin.s0.w.d.l0.n.y
    public String toString() {
        return "[@EnhancedForWarnings(" + F() + ")] " + Z0();
    }
}

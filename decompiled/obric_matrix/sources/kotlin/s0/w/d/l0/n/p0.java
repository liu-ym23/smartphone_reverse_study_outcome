package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 extends r implements o1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0 f21061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e0 f21062h;

    public p0(m0 r2, e0 r3) {
        kotlin.n0.d.o.f(r2, "delegate");
        kotlin.n0.d.o.f(r3, "enhancement");
        this.f21061g = r2;
        this.f21062h = r3;
    }

    @Override // kotlin.s0.w.d.l0.n.o1
    public e0 F() {
        return this.f21062h;
    }

    @Override // kotlin.s0.w.d.l0.n.o1
    public /* bridge */ /* synthetic */ q1 F0() {
        return a1();
    }

    @Override // kotlin.s0.w.d.l0.n.r, kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return b1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.r, kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return b1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 V0(boolean r2) {
        q1 r1 = p1.d(a1().V0(r2), F().R0().S0(r2));
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (m0) r1;
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 W0(a1 r2) {
        kotlin.n0.d.o.f(r2, "newAttributes");
        q1 r1 = p1.d(a1().W0(r2), F());
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (m0) r1;
    }

    @Override // kotlin.s0.w.d.l0.n.r
    protected m0 X0() {
        return this.f21061g;
    }

    @Override // kotlin.s0.w.d.l0.n.r
    public /* bridge */ /* synthetic */ m0 Y0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return b1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.r
    public /* bridge */ /* synthetic */ r Z0(m0 r1) {
        return c1(r1);
    }

    public m0 a1() {
        return X0();
    }

    public p0 b1(kotlin.s0.w.d.l0.n.t1.g r4) {
        kotlin.n0.d.o.f(r4, "kotlinTypeRefiner");
        e0 r1 = r4.h(X0());
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new p0((m0) r1, r4.h(F()));
    }

    public p0 c1(m0 r2) {
        kotlin.n0.d.o.f(r2, "delegate");
        return new p0(r2, F());
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public String toString() {
        return "[@EnhancedForWarnings(" + F() + ")] " + a1();
    }
}

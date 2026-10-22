package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0 f20939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m0 f20940h;

    public a(m0 r2, m0 r3) {
        kotlin.n0.d.o.f(r2, "delegate");
        kotlin.n0.d.o.f(r3, "abbreviation");
        this.f20939g = r2;
        this.f20940h = r3;
    }

    @Override // kotlin.s0.w.d.l0.n.r, kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return c1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0, kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 S0(boolean r1) {
        return b1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.r, kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return c1(r1);
    }

    public final m0 V() {
        return X0();
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public /* bridge */ /* synthetic */ m0 V0(boolean r1) {
        return b1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 W0(a1 r3) {
        kotlin.n0.d.o.f(r3, "newAttributes");
        return new a(X0().W0(r3), this.f20940h);
    }

    @Override // kotlin.s0.w.d.l0.n.r
    protected m0 X0() {
        return this.f20939g;
    }

    @Override // kotlin.s0.w.d.l0.n.r
    public /* bridge */ /* synthetic */ m0 Y0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return c1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.r
    public /* bridge */ /* synthetic */ r Z0(m0 r1) {
        return d1(r1);
    }

    public final m0 a1() {
        return this.f20940h;
    }

    public a b1(boolean r3) {
        return new a(X0().V0(r3), this.f20940h.V0(r3));
    }

    public a c1(kotlin.s0.w.d.l0.n.t1.g r4) {
        kotlin.n0.d.o.f(r4, "kotlinTypeRefiner");
        e0 r1 = r4.h(X0());
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        e0 r3 = r4.h(this.f20940h);
        kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new a((m0) r1, (m0) r3);
    }

    public a d1(m0 r2) {
        kotlin.n0.d.o.f(r2, "delegate");
        return new a(r2, this.f20940h);
    }
}

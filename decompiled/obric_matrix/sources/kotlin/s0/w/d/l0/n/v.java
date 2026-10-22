package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends y implements kotlin.s0.w.d.l0.n.w1.f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a1 f21172i;

    public v(kotlin.s0.w.d.l0.b.h r3, a1 r4) {
        kotlin.n0.d.o.f(r3, "builtIns");
        kotlin.n0.d.o.f(r4, "attributes");
        m0 r0 = r3.H();
        kotlin.n0.d.o.e(r0, "builtIns.nothingType");
        m0 r5 = r3.I();
        kotlin.n0.d.o.e(r5, "builtIns.nullableAnyType");
        super(r0, r5);
        this.f21172i = r4;
    }

    @Override // kotlin.s0.w.d.l0.n.y, kotlin.s0.w.d.l0.n.e0
    public a1 N0() {
        return this.f21172i;
    }

    @Override // kotlin.s0.w.d.l0.n.y, kotlin.s0.w.d.l0.n.e0
    public boolean P0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        a1(r1);
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 S0(boolean r1) {
        Z0(r1);
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
        a1(r1);
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 U0(a1 r1) {
        return b1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.y
    public m0 V0() {
        return X0();
    }

    @Override // kotlin.s0.w.d.l0.n.y
    public String Y0(kotlin.s0.w.d.l0.j.c r1, kotlin.s0.w.d.l0.j.f r2) {
        kotlin.n0.d.o.f(r1, "renderer");
        kotlin.n0.d.o.f(r2, "options");
        return "dynamic";
    }

    public v Z0(boolean r1) {
        return this;
    }

    public v a1(kotlin.s0.w.d.l0.n.t1.g r2) {
        kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
        return this;
    }

    public v b1(a1 r2) {
        kotlin.n0.d.o.f(r2, "newAttributes");
        return new v(kotlin.s0.w.d.l0.n.x1.a.h(V0()), r2);
    }
}

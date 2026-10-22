package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s extends r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0 f21071g;

    public s(m0 r2) {
        kotlin.n0.d.o.f(r2, "delegate");
        this.f21071g = r2;
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 V0(boolean r2) {
        if (r2 != P0()) goto L6;
        return this;
    L6:
        return X0().V0(r2).W0(N0());
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 W0(a1 r2) {
        kotlin.n0.d.o.f(r2, "newAttributes");
        if (r2 != N0()) goto L5;
        return this;
    L5:
        return new o0(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.n.r
    protected m0 X0() {
        return this.f21071g;
    }
}

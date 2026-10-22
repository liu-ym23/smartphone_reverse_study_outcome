package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
final class o0 extends s {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a1 f21057h;

    public o0(m0 r2, a1 r3) {
        kotlin.n0.d.o.f(r2, "delegate");
        kotlin.n0.d.o.f(r3, "attributes");
        super(r2);
        this.f21057h = r3;
    }

    @Override // kotlin.s0.w.d.l0.n.r, kotlin.s0.w.d.l0.n.e0
    public a1 N0() {
        return this.f21057h;
    }

    @Override // kotlin.s0.w.d.l0.n.r
    public /* bridge */ /* synthetic */ r Z0(m0 r1) {
        return a1(r1);
    }

    public o0 a1(m0 r2) {
        kotlin.n0.d.o.f(r2, "delegate");
        return new o0(r2, N0());
    }
}

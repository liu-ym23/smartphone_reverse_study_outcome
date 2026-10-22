package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends s1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.n f21023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.n0.c.a<e0> f21024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i<e0> f21025i;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.n.t1.g f21026f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ h0 f21027g;

        a(kotlin.s0.w.d.l0.n.t1.g r1, h0 r2) {
            this.f21026f = r1;
            this.f21027g = r2;
            super(0);
        }

        public final e0 a() {
            return this.f21026f.h((kotlin.s0.w.d.l0.n.w1.i) h0.U0(this.f21027g).invoke());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ e0 invoke() {
            return a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h0(kotlin.s0.w.d.l0.m.n r2, kotlin.n0.c.a<? extends e0> r3) {
        kotlin.n0.d.o.f(r2, "storageManager");
        kotlin.n0.d.o.f(r3, "computation");
        this.f21023g = r2;
        this.f21024h = r3;
        this.f21025i = r2.d(r3);
    }

    public static final /* synthetic */ kotlin.n0.c.a U0(h0 r0) {
        return r0.f21024h;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return V0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.s1
    protected e0 S0() {
        return this.f21025i.invoke();
    }

    @Override // kotlin.s0.w.d.l0.n.s1
    public boolean T0() {
        return this.f21025i.e();
    }

    public h0 V0(kotlin.s0.w.d.l0.n.t1.g r4) {
        kotlin.n0.d.o.f(r4, "kotlinTypeRefiner");
        return new h0(this.f21023g, new a(r4, this));
    }
}

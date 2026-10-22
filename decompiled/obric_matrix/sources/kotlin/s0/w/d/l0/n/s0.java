package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 extends h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.f1 f21072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.h f21073b;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ s0 f21074f;

        a(s0 r1) {
            this.f21074f = r1;
            super(0);
        }

        public final e0 a() {
            return t0.b(s0.e(this.f21074f));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ e0 invoke() {
            return a();
        }
    }

    public s0(kotlin.s0.w.d.l0.c.f1 r2) {
        kotlin.n0.d.o.f(r2, "typeParameter");
        this.f21072a = r2;
        this.f21073b = kotlin.i.a(kotlin.l.f18418g, new a(this));
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.f1 e(s0 r0) {
        return r0.f21072a;
    }

    private final e0 f() {
        return (e0) this.f21073b.getValue();
    }

    @Override // kotlin.s0.w.d.l0.n.g1
    public r1 a() {
        return r1.f21067j;
    }

    @Override // kotlin.s0.w.d.l0.n.g1
    public e0 b() {
        return f();
    }

    @Override // kotlin.s0.w.d.l0.n.g1
    public g1 c(kotlin.s0.w.d.l0.n.t1.g r2) {
        kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.g1
    public boolean d() {
        return true;
    }
}

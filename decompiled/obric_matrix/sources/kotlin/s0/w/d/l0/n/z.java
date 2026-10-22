package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends y implements n {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f21204j;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f21205i;

    static {
    }

    public z(m0 r2, m0 r3) {
        kotlin.n0.d.o.f(r2, "lowerBound");
        kotlin.n0.d.o.f(r3, "upperBound");
        super(r2, r3);
    }

    private final void a1() {
        if (f21204j == true) goto L5;
        return;
    L5:
        if (this.f21205i == true) goto L10;
        this.f21205i = true;
        b0.b(W0());
        b0.b(X0());
        kotlin.n0.d.o.a(W0(), X0());
        kotlin.s0.w.d.l0.n.t1.e.f21078a.d(W0(), X0());
        return;
    }

    @Override // kotlin.s0.w.d.l0.n.n
    public boolean A0() {
        if ((W0().O0().d() instanceof kotlin.s0.w.d.l0.c.f1) == true) goto L5;
    L7:
        return false;
    L5:
        if (kotlin.n0.d.o.a(W0().O0(), X0().O0()) == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.n.n
    public e0 J(e0 r2) {
        kotlin.n0.d.o.f(r2, "replacement");
        q1 r1 = r2.R0();
        if ((r1 instanceof y) == false) goto L6;
        q1 r3 = r1;
    L9:
        return p1.b(r3, r1);
    L6:
        if ((r1 instanceof m0) == false) goto L11;
        m0 r4 = (m0) r1;
        r3 = f0.d(r4, r4.V0(true));
        goto L9
    L11:
        throw new kotlin.m();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return Z0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public q1 S0(boolean r2) {
        return f0.d(W0().V0(r2), X0().V0(r2));
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return Z0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public q1 U0(a1 r2) {
        kotlin.n0.d.o.f(r2, "newAttributes");
        return f0.d(W0().W0(r2), X0().W0(r2));
    }

    @Override // kotlin.s0.w.d.l0.n.y
    public m0 V0() {
        a1();
        return W0();
    }

    @Override // kotlin.s0.w.d.l0.n.y
    public String Y0(kotlin.s0.w.d.l0.j.c r2, kotlin.s0.w.d.l0.j.f r3) {
        kotlin.n0.d.o.f(r2, "renderer");
        kotlin.n0.d.o.f(r3, "options");
        if (r3.n() == false) goto L7;
        return '(' + r2.w(W0()) + ".." + r2.w(X0()) + ')';
    L7:
        return r2.t(r2.w(W0()), r2.w(X0()), kotlin.s0.w.d.l0.n.x1.a.h(this));
    }

    public y Z0(kotlin.s0.w.d.l0.n.t1.g r4) {
        kotlin.n0.d.o.f(r4, "kotlinTypeRefiner");
        e0 r1 = r4.h(W0());
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        e0 r3 = r4.h(X0());
        kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new z((m0) r1, (m0) r3);
    }

    @Override // kotlin.s0.w.d.l0.n.y
    public String toString() {
        return '(' + W0() + ".." + X0() + ')';
    }
}

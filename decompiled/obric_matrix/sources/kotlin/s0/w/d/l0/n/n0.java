package kotlin.s0.w.d.l0.n;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class n0 extends m0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e1 f21046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<g1> f21047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f21048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.k.w.h f21049j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final kotlin.n0.c.l<kotlin.s0.w.d.l0.n.t1.g, m0> f21050k;

    /* JADX WARN: Multi-variable type inference failed */
    public n0(e1 r2, List<? extends g1> r3, boolean r4, kotlin.s0.w.d.l0.k.w.h r5, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.n.t1.g, ? extends m0> r6) {
        kotlin.n0.d.o.f(r2, "constructor");
        kotlin.n0.d.o.f(r3, "arguments");
        kotlin.n0.d.o.f(r5, "memberScope");
        kotlin.n0.d.o.f(r6, "refinedTypeFactory");
        this.f21046g = r2;
        this.f21047h = r3;
        this.f21048i = r4;
        this.f21049j = r5;
        this.f21050k = r6;
        if ((q() instanceof kotlin.s0.w.d.l0.n.u1.f) == true) goto L5;
        return;
    L5:
        if ((q() instanceof kotlin.s0.w.d.l0.n.u1.l) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + q() + '\n' + O0());
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public List<g1> M0() {
        return this.f21047h;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public a1 N0() {
        return a1.f20943g.h();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public e1 O0() {
        return this.f21046g;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public boolean P0() {
        return this.f21048i;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return X0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return X0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 V0(boolean r2) {
        if (r2 == P0()) goto L10;
        if (r2 == false) goto L7;
        m0 r3 = new k0(this);
    L9:
        return r3;
    L7:
        r3 = new i0(this);
        goto L9
    L10:
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 W0(a1 r2) {
        kotlin.n0.d.o.f(r2, "newAttributes");
        if (r2.isEmpty() == false) goto L6;
        return this;
    L6:
        return new o0(this, r2);
    }

    public m0 X0(kotlin.s0.w.d.l0.n.t1.g r2) {
        kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
        m0 r3 = this.f21050k.invoke(r2);
        if (r3 != null) goto L6;
        return this;
    L6:
        return r3;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public kotlin.s0.w.d.l0.k.w.h q() {
        return this.f21049j;
    }
}

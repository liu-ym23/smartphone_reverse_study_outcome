package kotlin.s0.w.d.l0.n;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends m0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.n.t1.n f20975g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f20976h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.k.w.h f20977i;

    static {
    }

    public e(kotlin.s0.w.d.l0.n.t1.n r3, boolean r4) {
        kotlin.n0.d.o.f(r3, "originalTypeVariable");
        this.f20975g = r3;
        this.f20976h = r4;
        this.f20977i = kotlin.s0.w.d.l0.n.u1.k.b(kotlin.s0.w.d.l0.n.u1.g.f21145k, new String[]{r3.toString()});
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public List<g1> M0() {
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public a1 N0() {
        return a1.f20943g.h();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public boolean P0() {
        return this.f20976h;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        Z0(r1);
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
        Z0(r1);
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.m0, kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 U0(a1 r1) {
        W0(r1);
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 V0(boolean r2) {
        if (r2 != P0()) goto L6;
        return this;
    L6:
        return Y0(r2);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 W0(a1 r2) {
        kotlin.n0.d.o.f(r2, "newAttributes");
        return this;
    }

    public final kotlin.s0.w.d.l0.n.t1.n X0() {
        return this.f20975g;
    }

    public abstract e Y0(boolean r1);

    public e Z0(kotlin.s0.w.d.l0.n.t1.g r2) {
        kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public kotlin.s0.w.d.l0.k.w.h q() {
        return this.f20977i;
    }
}

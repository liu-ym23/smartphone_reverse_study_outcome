package kotlin.s0.w.d.l0.n;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends m0 {
    public r() {
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public List<g1> M0() {
        return X0().M0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public a1 N0() {
        return X0().N0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public e1 O0() {
        return X0().O0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public boolean P0() {
        return X0().P0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public /* bridge */ /* synthetic */ e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return Y0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 T0(kotlin.s0.w.d.l0.n.t1.g r1) {
        return Y0(r1);
    }

    protected abstract m0 X0();

    public m0 Y0(kotlin.s0.w.d.l0.n.t1.g r2) {
        kotlin.n0.d.o.f(r2, "kotlinTypeRefiner");
        e0 r3 = r2.h(X0());
        kotlin.n0.d.o.d(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return Z0((m0) r3);
    }

    public abstract r Z0(m0 r1);

    @Override // kotlin.s0.w.d.l0.n.e0
    public kotlin.s0.w.d.l0.k.w.h q() {
        return X0().q();
    }
}

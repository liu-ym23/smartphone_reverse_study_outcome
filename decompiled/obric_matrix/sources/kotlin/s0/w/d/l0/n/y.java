package kotlin.s0.w.d.l0.n;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y extends q1 implements kotlin.s0.w.d.l0.n.w1.g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0 f21195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m0 f21196h;

    public y(m0 r2, m0 r3) {
        kotlin.n0.d.o.f(r2, "lowerBound");
        kotlin.n0.d.o.f(r3, "upperBound");
        super(null);
        this.f21195g = r2;
        this.f21196h = r3;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public List<g1> M0() {
        return V0().M0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public a1 N0() {
        return V0().N0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public e1 O0() {
        return V0().O0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public boolean P0() {
        return V0().P0();
    }

    public abstract m0 V0();

    public final m0 W0() {
        return this.f21195g;
    }

    public final m0 X0() {
        return this.f21196h;
    }

    public abstract String Y0(kotlin.s0.w.d.l0.j.c r1, kotlin.s0.w.d.l0.j.f r2);

    @Override // kotlin.s0.w.d.l0.n.e0
    public kotlin.s0.w.d.l0.k.w.h q() {
        return V0().q();
    }

    public String toString() {
        return kotlin.s0.w.d.l0.j.c.f20439c.w(this);
    }
}

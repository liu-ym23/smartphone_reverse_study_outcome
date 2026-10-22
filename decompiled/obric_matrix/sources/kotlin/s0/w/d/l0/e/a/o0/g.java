package kotlin.s0.w.d.l0.e.a.o0;

import kotlin.s0.w.d.l0.n.a1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.j0;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.p1;
import kotlin.s0.w.d.l0.n.q1;
import kotlin.s0.w.d.l0.n.y;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends kotlin.s0.w.d.l0.n.r implements j0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0 f19558g;

    public g(m0 r2) {
        kotlin.n0.d.o.f(r2, "delegate");
        this.f19558g = r2;
    }

    private final m0 a1(m0 r1) {
        m0 r0 = r1.V0(false);
        if (kotlin.s0.w.d.l0.n.x1.a.q(r1) == true) goto L6;
        return r0;
    L6:
        return new g(r0);
    }

    @Override // kotlin.s0.w.d.l0.n.n
    public boolean A0() {
        return true;
    }

    @Override // kotlin.s0.w.d.l0.n.n
    public e0 J(e0 r3) {
        kotlin.n0.d.o.f(r3, "replacement");
        q1 r4 = r3.R0();
        if (kotlin.s0.w.d.l0.n.x1.a.q(r4) == true) goto L8;
        if (n1.l(r4) == true) goto L8;
        return r4;
    L8:
        if ((r4 instanceof m0) == false) goto L11;
        return a1((m0) r4);
    L11:
        if ((r4 instanceof y) == false) goto L15;
        y r0 = (y) r4;
        return p1.d(f0.d(a1(r0.W0()), a1(r0.X0())), p1.a(r4));
    L15:
        throw new IllegalStateException(("Incorrect type: " + r4).toString());
    }

    @Override // kotlin.s0.w.d.l0.n.r, kotlin.s0.w.d.l0.n.e0
    public boolean P0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.n.m0, kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 U0(a1 r1) {
        return b1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public m0 V0(boolean r1) {
        if (r1 == true) goto L4;
        return this;
    L4:
        return X0().V0(true);
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public /* bridge */ /* synthetic */ m0 W0(a1 r1) {
        return b1(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.r
    protected m0 X0() {
        return this.f19558g;
    }

    @Override // kotlin.s0.w.d.l0.n.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.r Z0(m0 r1) {
        return c1(r1);
    }

    public g b1(a1 r2) {
        kotlin.n0.d.o.f(r2, "newAttributes");
        return new g(X0().W0(r2));
    }

    public g c1(m0 r1) {
        kotlin.n0.d.o.f(r1, "delegate");
        return new g(r1);
    }
}

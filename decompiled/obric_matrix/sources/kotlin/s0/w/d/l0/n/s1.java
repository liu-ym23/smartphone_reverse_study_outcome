package kotlin.s0.w.d.l0.n;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s1 extends e0 {
    public s1() {
        super(null);
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public List<g1> M0() {
        return S0().M0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public a1 N0() {
        return S0().N0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public e1 O0() {
        return S0().O0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public boolean P0() {
        return S0().P0();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public final q1 R0() {
    L2:
        e0 r1 = this.S0();
        if ((r1 instanceof s1) == false) goto L5;
        s1 this = (s1) r1;
        goto L2
    L5:
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (q1) r1;
    }

    protected abstract e0 S0();

    public boolean T0() {
        return true;
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public kotlin.s0.w.d.l0.k.w.h q() {
        return S0().q();
    }

    public String toString() {
        if (T0() == true) goto L7;
        return "<Not computed yet>";
    L7:
        return S0().toString();
    }
}

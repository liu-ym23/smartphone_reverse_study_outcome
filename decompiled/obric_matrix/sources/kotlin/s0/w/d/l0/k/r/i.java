package kotlin.s0.w.d.l0.k.r;

import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends g<Double> {
    public i(double r1) {
        super(Double.valueOf(r1));
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public /* bridge */ /* synthetic */ e0 a(h0 r1) {
        return c(r1);
    }

    public m0 c(h0 r1) {
        kotlin.n0.d.o.f(r1, "module");
        m0 r0 = r1.o().z();
        kotlin.n0.d.o.e(r0, "module.builtIns.doubleType");
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public String toString() {
        return b().doubleValue() + ".toDouble()";
    }
}

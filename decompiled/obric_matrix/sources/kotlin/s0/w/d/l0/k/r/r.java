package kotlin.s0.w.d.l0.k.r;

import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends o<Long> {
    public r(long r1) {
        super(Long.valueOf(r1));
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public /* bridge */ /* synthetic */ e0 a(h0 r1) {
        return c(r1);
    }

    public m0 c(h0 r1) {
        kotlin.n0.d.o.f(r1, "module");
        m0 r0 = r1.o().F();
        kotlin.n0.d.o.e(r0, "module.builtIns.longType");
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public String toString() {
        return b().longValue() + ".toLong()";
    }
}

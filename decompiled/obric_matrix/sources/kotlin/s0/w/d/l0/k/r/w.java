package kotlin.s0.w.d.l0.k.r;

import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends a0<Byte> {
    public w(byte r1) {
        super(Byte.valueOf(r1));
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public e0 a(h0 r1) {
        kotlin.n0.d.o.f(r1, "module");
        kotlin.s0.w.d.l0.c.e r0 = kotlin.s0.w.d.l0.c.x.a(r1, kotlin.s0.w.d.l0.b.k.a.Y);
        if (r0 == null) goto L5;
        m0 r2 = r0.s();
    L6:
        if (r2 == null) goto L8;
        return r2;
    L8:
        return kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.C0, new String[]{"UByte"});
    L5:
        r2 = null;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public String toString() {
        return b().intValue() + ".toUByte()";
    }
}

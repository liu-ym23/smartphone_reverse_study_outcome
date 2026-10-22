package kotlin.s0.w.d.l0.n;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m0 extends q1 implements kotlin.s0.w.d.l0.n.w1.k, kotlin.s0.w.d.l0.n.w1.l {
    public m0() {
        super(null);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 S0(boolean r1) {
        return V0(r1);
    }

    @Override // kotlin.s0.w.d.l0.n.q1
    public /* bridge */ /* synthetic */ q1 U0(a1 r1) {
        return W0(r1);
    }

    public abstract m0 V0(boolean r1);

    public abstract m0 W0(a1 r1);

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        Iterator<kotlin.s0.w.d.l0.c.o1.c> r0 = getAnnotations().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        kotlin.u0.k.h(r10, new String[]{"[", kotlin.s0.w.d.l0.j.c.s(kotlin.s0.w.d.l0.j.c.f20439c, r0.next(), null, 2, null), "] "});
        goto L4
    L6:
        r10.append(O0());
        if ((!M0().isEmpty()) == false) goto L10;
        kotlin.i0.r.X(M0(), r10, ", ", "<", ">", 0, null, null, 112, null);
    L10:
        if (P0() == false) goto L12;
        r10.append("?");
    L12:
        String r11 = r10.toString();
        kotlin.n0.d.o.e(r11, "StringBuilder().apply(builderAction).toString()");
        return r11;
    }
}

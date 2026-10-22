package kotlin.s0.w.d.l0.l.b;

import kotlin.s0.w.d.l0.c.h0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends kotlin.s0.w.d.l0.c.q1.z {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.n f20855l;

    public p(kotlin.s0.w.d.l0.g.c r2, kotlin.s0.w.d.l0.m.n r3, h0 r4) {
        kotlin.n0.d.o.f(r2, "fqName");
        kotlin.n0.d.o.f(r3, "storageManager");
        kotlin.n0.d.o.f(r4, "module");
        super(r4, r2);
        this.f20855l = r3;
    }

    public abstract h F0();

    public boolean L0(kotlin.s0.w.d.l0.g.f r2) {
        kotlin.n0.d.o.f(r2, "name");
        kotlin.s0.w.d.l0.k.w.h r1 = q();
        if ((r1 instanceof kotlin.s0.w.d.l0.l.b.g0.h) == true) goto L5;
    L7:
        return false;
    L5:
        if (((kotlin.s0.w.d.l0.l.b.g0.h) r1).q().contains(r2) == false) goto L7;
        return true;
    }

    public abstract void M0(k r1);
}

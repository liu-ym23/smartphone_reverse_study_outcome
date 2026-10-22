package kotlin.s0.w.d.l0.n;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 implements kotlin.s0.w.d.l0.c.o1.a, kotlin.s0.w.d.l0.n.w1.i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f20978f;

    private e0() {
    }

    public /* synthetic */ e0(kotlin.n0.d.g r1) {
        this();
    }

    private final int L0() {
        if (g0.a(this) == false) goto L7;
        return super.hashCode();
    L7:
        return (((O0().hashCode() * 31) + M0().hashCode()) * 31) + (P0() ? 1 : 0);
    }

    public abstract List<g1> M0();

    public abstract a1 N0();

    public abstract e1 O0();

    public abstract boolean P0();

    public abstract e0 Q0(kotlin.s0.w.d.l0.n.t1.g r1);

    public abstract q1 R0();

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r6 = (e0) r5;
        if (P0() != r6.P0()) goto L14;
        if (kotlin.s0.w.d.l0.n.t1.r.f21108a.a(R0(), r6.R0()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.a
    public kotlin.s0.w.d.l0.c.o1.g getAnnotations() {
        return k.a(N0());
    }

    public final int hashCode() {
        int r0 = this.f20978f;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = L0();
        this.f20978f = r1;
        return r1;
    }

    public abstract kotlin.s0.w.d.l0.k.w.h q();
}

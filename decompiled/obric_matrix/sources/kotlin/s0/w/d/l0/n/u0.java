package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 extends e implements kotlin.s0.w.d.l0.n.w1.k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final e1 f21123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.k.w.h f21124k;

    public u0(kotlin.s0.w.d.l0.n.t1.n r2, boolean r3, e1 r4) {
        kotlin.n0.d.o.f(r2, "originalTypeVariable");
        kotlin.n0.d.o.f(r4, "constructor");
        super(r2, r3);
        this.f21123j = r4;
        this.f21124k = r2.o().i().q();
    }

    @Override // kotlin.s0.w.d.l0.n.e0
    public e1 O0() {
        return this.f21123j;
    }

    @Override // kotlin.s0.w.d.l0.n.e
    public e Y0(boolean r3) {
        return new u0(X0(), r3, O0());
    }

    @Override // kotlin.s0.w.d.l0.n.e, kotlin.s0.w.d.l0.n.e0
    public kotlin.s0.w.d.l0.k.w.h q() {
        return this.f21124k;
    }

    @Override // kotlin.s0.w.d.l0.n.m0
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Stub (BI): ");
        r0.append(X0());
        if (P0() == false) goto L5;
        String r2 = "?";
    L6:
        r0.append(r2);
        return r0.toString();
    L5:
        r2 = "";
        goto L6
    }
}

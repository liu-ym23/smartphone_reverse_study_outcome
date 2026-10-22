package kotlin.s0.w.d.l0.c.s1.b;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends f implements kotlin.s0.w.d.l0.e.a.n0.m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Enum<?> f19149c;

    public q(kotlin.s0.w.d.l0.g.f r2, Enum<?> r3) {
        kotlin.n0.d.o.f(r3, "value");
        super(r2, null);
        this.f19149c = r3;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.m
    public kotlin.s0.w.d.l0.g.b b() {
        Class<?> r1 = this.f19149c.getClass();
        if (r1.isEnum() == true) goto L6;
        r1 = r1.getEnclosingClass();
    L6:
        kotlin.n0.d.o.e(r1, "enumClass");
        return d.a(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.m
    public kotlin.s0.w.d.l0.g.f d() {
        return kotlin.s0.w.d.l0.g.f.k(this.f19149c.name());
    }
}

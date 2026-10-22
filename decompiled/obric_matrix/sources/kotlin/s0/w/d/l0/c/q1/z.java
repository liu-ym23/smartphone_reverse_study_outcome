package kotlin.s0.w.d.l0.c.q1;

import kotlin.s0.w.d.l0.c.a1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends k implements kotlin.s0.w.d.l0.c.l0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.c f19071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f19072k;

    public z(kotlin.s0.w.d.l0.c.h0 r4, kotlin.s0.w.d.l0.g.c r5) {
        kotlin.n0.d.o.f(r4, "module");
        kotlin.n0.d.o.f(r5, "fqName");
        super(r4, kotlin.s0.w.d.l0.c.o1.g.f18919b.b(), r5.h(), a1.f18847a);
        this.f19071j = r5;
        this.f19072k = "package " + r5 + " of " + r4;
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r2, D r3) {
        kotlin.n0.d.o.f(r2, "visitor");
        return r2.f(this, r3);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.m
    public kotlin.s0.w.d.l0.c.h0 c() {
        kotlin.s0.w.d.l0.c.m r1 = super.c();
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (kotlin.s0.w.d.l0.c.h0) r1;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m c() {
        return c();
    }

    @Override // kotlin.s0.w.d.l0.c.l0
    public final kotlin.s0.w.d.l0.g.c e() {
        return this.f19071j;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.p
    public a1 getSource() {
        a1 r1 = a1.f18847a;
        kotlin.n0.d.o.e(r1, "NO_SOURCE");
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.j
    public String toString() {
        return this.f19072k;
    }
}

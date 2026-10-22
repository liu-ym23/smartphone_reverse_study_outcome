package kotlin.s0.w.d.l0.c.q1;

import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<x> f19061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<x> f19062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<x> f19063c;

    public w(List<x> r2, Set<x> r3, List<x> r4, Set<x> r5) {
        kotlin.n0.d.o.f(r2, "allDependencies");
        kotlin.n0.d.o.f(r3, "modulesWhoseInternalsAreVisible");
        kotlin.n0.d.o.f(r4, "directExpectedByDependencies");
        kotlin.n0.d.o.f(r5, "allExpectedByDependencies");
        this.f19061a = r2;
        this.f19062b = r3;
        this.f19063c = r4;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.v
    public List<x> a() {
        return this.f19061a;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.v
    public Set<x> b() {
        return this.f19062b;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.v
    public List<x> c() {
        return this.f19063c;
    }
}

package kotlin.s0.w.d.l0.c.s1.b;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends p implements kotlin.s0.w.d.l0.e.a.n0.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.c f19153a;

    public w(kotlin.s0.w.d.l0.g.c r2) {
        kotlin.n0.d.o.f(r2, "fqName");
        this.f19153a = r2;
    }

    public List<kotlin.s0.w.d.l0.e.a.n0.a> R() {
        return kotlin.i0.r.g();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.u
    public kotlin.s0.w.d.l0.g.c e() {
        return this.f19153a;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof w) == true) goto L5;
    L7:
        return false;
    L5:
        if (kotlin.n0.d.o.a(e(), ((w) r2).e()) == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return R();
    }

    public int hashCode() {
        return e().hashCode();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public kotlin.s0.w.d.l0.e.a.n0.a i(kotlin.s0.w.d.l0.g.c r1) {
        kotlin.n0.d.o.f(r1, "fqName");
        return null;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public boolean l() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.u
    public Collection<kotlin.s0.w.d.l0.e.a.n0.g> p(kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r1) {
        kotlin.n0.d.o.f(r1, "nameFilter");
        return kotlin.i0.r.g();
    }

    public String toString() {
        return w.class.getName() + ": " + e();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.u
    public Collection<kotlin.s0.w.d.l0.e.a.n0.u> z() {
        return kotlin.i0.r.g();
    }
}

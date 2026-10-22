package kotlin.s0.w.d.l0.n.u1;

import java.util.Collection;
import java.util.List;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.g0;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.q0;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements h0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f21133f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.f f21134g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<h0> f21135h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final List<h0> f21136i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.b.h f21137j = null;

    static {
        f21133f = new d();
        kotlin.s0.w.d.l0.g.f r0 = kotlin.s0.w.d.l0.g.f.n(b.f21128j.b());
        o.e(r0, "special(ErrorEntity.ERROR_MODULE.debugText)");
        f21134g = r0;
        f21135h = r.g();
        f21136i = r.g();
        t0.b();
        f21137j = kotlin.s0.w.d.l0.b.e.f18673g.a();
    }

    private d() {
    }

    public kotlin.s0.w.d.l0.g.f F() {
        return f21134g;
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public <T> T I0(g0<T> r1) {
        o.f(r1, "capability");
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r1, D r2) {
        o.f(r1, "visitor");
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public q0 N(kotlin.s0.w.d.l0.g.c r1) {
        o.f(r1, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public m a() {
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public m c() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public boolean e0(h0 r1) {
        o.f(r1, "targetModule");
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.a
    public kotlin.s0.w.d.l0.c.o1.g getAnnotations() {
        return kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
    }

    @Override // kotlin.s0.w.d.l0.c.j0
    public kotlin.s0.w.d.l0.g.f getName() {
        return F();
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public kotlin.s0.w.d.l0.b.h o() {
        return f21137j;
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public Collection<kotlin.s0.w.d.l0.g.c> p(kotlin.s0.w.d.l0.g.c r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2) {
        o.f(r1, "fqName");
        o.f(r2, "nameFilter");
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.c.h0
    public List<h0> t0() {
        return f21136i;
    }
}

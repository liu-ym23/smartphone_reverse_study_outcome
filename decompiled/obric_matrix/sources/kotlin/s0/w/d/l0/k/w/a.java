package kotlin.s0.w.d.l0.k.w;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Collection;
import java.util.Set;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements h {
    public a() {
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Collection<z0> a(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        return i().a(r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> b() {
        return i().b();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Collection<u0> c(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        return i().c(r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> d() {
        return i().d();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        return i().e();
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        return i().f(r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public Collection<kotlin.s0.w.d.l0.c.m> g(d r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
        o.f(r2, "kindFilter");
        o.f(r3, "nameFilter");
        return i().g(r2, r3);
    }

    public final h h() {
        boolean r0 = i() instanceof a;
        h r1 = i();
        if (r0 == false) goto L6;
        o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
        return ((a) r1).h();
    L6:
        return r1;
    }

    protected abstract h i();
}

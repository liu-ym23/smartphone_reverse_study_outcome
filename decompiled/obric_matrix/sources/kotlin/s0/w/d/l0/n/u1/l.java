package kotlin.s0.w.d.l0.n.u1;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends f {
    public l(g r2, String... r3) {
        o.f(r2, "kind");
        o.f(r3, "formatParams");
        super(r2, (String[]) Arrays.copyOf(r3, r3.length));
    }

    @Override // kotlin.s0.w.d.l0.n.u1.f, kotlin.s0.w.d.l0.k.w.h
    public /* bridge */ /* synthetic */ Collection a(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        h(r1, r2);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.n.u1.f, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> b() {
        throw new IllegalStateException();
    }

    @Override // kotlin.s0.w.d.l0.n.u1.f, kotlin.s0.w.d.l0.k.w.h
    public /* bridge */ /* synthetic */ Collection c(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        i(r1, r2);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.n.u1.f, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> d() {
        throw new IllegalStateException();
    }

    @Override // kotlin.s0.w.d.l0.n.u1.f, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        throw new IllegalStateException();
    }

    @Override // kotlin.s0.w.d.l0.n.u1.f, kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        throw new IllegalStateException(j() + ", required name: " + r2);
    }

    @Override // kotlin.s0.w.d.l0.n.u1.f, kotlin.s0.w.d.l0.k.w.k
    public Collection<m> g(kotlin.s0.w.d.l0.k.w.d r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
        o.f(r2, "kindFilter");
        o.f(r3, "nameFilter");
        throw new IllegalStateException(j());
    }

    @Override // kotlin.s0.w.d.l0.n.u1.f
    public Set<z0> h(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        throw new IllegalStateException(j() + ", required name: " + r2);
    }

    @Override // kotlin.s0.w.d.l0.n.u1.f
    public Set<u0> i(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        throw new IllegalStateException(j() + ", required name: " + r2);
    }

    @Override // kotlin.s0.w.d.l0.n.u1.f
    public String toString() {
        return "ThrowingScope{" + j() + '}';
    }
}

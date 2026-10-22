package kotlin.s0.w.d.l0.n.u1;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public class f implements kotlin.s0.w.d.l0.k.w.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f21139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21140c;

    public f(g r2, String... r3) {
        o.f(r2, "kind");
        o.f(r3, "formatParams");
        this.f21139b = r2;
        String r4 = r2.b();
        Object[] r5 = Arrays.copyOf(r3, r3.length);
        String r6 = String.format(r4, Arrays.copyOf(r5, r5.length));
        o.e(r6, "format(this, *args)");
        this.f21140c = r6;
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public /* bridge */ /* synthetic */ Collection a(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        return h(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> b() {
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public /* bridge */ /* synthetic */ Collection c(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        return i(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> d() {
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r4, kotlin.s0.w.d.l0.d.b.b r5) {
        o.f(r4, "name");
        o.f(r5, LocationMonitorConst.LOCATION);
        String r6 = String.format(b.f21125g.b(), Arrays.copyOf(new Object[]{r4}, 1));
        o.e(r6, "format(this, *args)");
        kotlin.s0.w.d.l0.g.f r7 = kotlin.s0.w.d.l0.g.f.n(r6);
        o.e(r7, "special(ErrorEntity.ERRO…S.debugText.format(name))");
        return new a(r7);
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public Collection<m> g(kotlin.s0.w.d.l0.k.w.d r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2) {
        o.f(r1, "kindFilter");
        o.f(r2, "nameFilter");
        return r.g();
    }

    public Set<z0> h(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        o.f(r1, "name");
        o.f(r2, LocationMonitorConst.LOCATION);
        return t0.a(new c(k.f21165a.h()));
    }

    public Set<u0> i(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        o.f(r1, "name");
        o.f(r2, LocationMonitorConst.LOCATION);
        return k.f21165a.j();
    }

    protected final String j() {
        return this.f21140c;
    }

    public String toString() {
        return "ErrorScope{" + this.f21140c + '}';
    }
}

package kotlin.s0.w.d.l0.k.w;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i implements h {
    public i() {
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Collection<? extends z0> a(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        o.f(r1, "name");
        o.f(r2, LocationMonitorConst.LOCATION);
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> b() {
        Collection<kotlin.s0.w.d.l0.c.m> r3 = g(d.r, kotlin.s0.w.d.l0.p.d.a());
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r1 = r4.next();
        if ((r1 instanceof z0) == false) goto L4;
        kotlin.s0.w.d.l0.g.f r2 = ((z0) r1).getName();
        o.e(r2, "it.name");
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Collection<? extends u0> c(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        o.f(r1, "name");
        o.f(r2, LocationMonitorConst.LOCATION);
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> d() {
        Collection<kotlin.s0.w.d.l0.c.m> r3 = g(d.s, kotlin.s0.w.d.l0.p.d.a());
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r1 = r4.next();
        if ((r1 instanceof z0) == false) goto L4;
        kotlin.s0.w.d.l0.g.f r2 = ((z0) r1).getName();
        o.e(r2, "it.name");
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        o.f(r1, "name");
        o.f(r2, LocationMonitorConst.LOCATION);
        return null;
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public Collection<kotlin.s0.w.d.l0.c.m> g(d r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2) {
        o.f(r1, "kindFilter");
        o.f(r2, "nameFilter");
        return r.g();
    }
}

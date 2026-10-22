package kotlin.s0.w.d.l0.k.w;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.e1;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f20643b;

    public f(h r2) {
        o.f(r2, "workerScope");
        this.f20643b = r2;
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> b() {
        return this.f20643b.b();
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> d() {
        return this.f20643b.d();
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        return this.f20643b.e();
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        kotlin.s0.w.d.l0.c.h r1 = this.f20643b.f(r2, r3);
        if (r1 != null) goto L5;
        return null;
    L5:
        if ((r1 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L7;
        kotlin.s0.w.d.l0.c.e r4 = (kotlin.s0.w.d.l0.c.e) r1;
    L8:
        if (r4 == null) goto L11;
        return r4;
    L11:
        if ((r1 instanceof e1) == true) goto L13;
        return null;
    L13:
        return (e1) r1;
    L7:
        r4 = null;
        goto L8
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public /* bridge */ /* synthetic */ Collection g(d r1, kotlin.n0.c.l r2) {
        return h(r1, r2);
    }

    public List<kotlin.s0.w.d.l0.c.h> h(d r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
        o.f(r2, "kindFilter");
        o.f(r3, "nameFilter");
        d r4 = r2.n(d.f20623c.c());
        if (r4 == null) goto L5;
        Collection<kotlin.s0.w.d.l0.c.m> r1 = this.f20643b.g(r4, r3);
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r1.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        Object r7 = r6.next();
        if ((r7 instanceof kotlin.s0.w.d.l0.c.i) == false) goto L8;
        r5.add(r7);
        goto L8
    L12:
        return r5;
    L5:
        return r.g();
    }

    public String toString() {
        return "Classes from " + this.f20643b;
    }
}

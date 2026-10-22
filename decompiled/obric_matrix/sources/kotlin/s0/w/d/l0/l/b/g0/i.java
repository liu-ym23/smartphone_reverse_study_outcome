package kotlin.s0.w.d.l0.l.b.g0;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.f.r;
import kotlin.s0.w.d.l0.f.t;
import kotlin.s0.w.d.l0.f.w;

/* JADX INFO: loaded from: classes2.dex */
public class i extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l0 f20814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f20815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.c f20816i;

    public i(l0 r17, kotlin.s0.w.d.l0.f.l r18, kotlin.s0.w.d.l0.f.z.c r19, kotlin.s0.w.d.l0.f.z.a r20, f r21, kotlin.s0.w.d.l0.l.b.k r22, String r23, kotlin.n0.c.a<? extends Collection<kotlin.s0.w.d.l0.g.f>> r24) {
        o.f(r17, "packageDescriptor");
        o.f(r18, "proto");
        o.f(r19, "nameResolver");
        o.f(r20, "metadataVersion");
        o.f(r22, "components");
        o.f(r23, "debugName");
        o.f(r24, "classNames");
        t r0 = r18.V();
        o.e(r0, "proto.typeTable");
        kotlin.s0.w.d.l0.f.z.g r10 = new kotlin.s0.w.d.l0.f.z.g(r0);
        kotlin.s0.w.d.l0.f.z.h.a r1 = kotlin.s0.w.d.l0.f.z.h.f20249b;
        w r7 = r18.W();
        o.e(r7, "proto.versionRequirementTable");
        kotlin.s0.w.d.l0.l.b.m r2 = r22.a(r17, r19, r10, r1.a(r7), r20, r21);
        List<kotlin.s0.w.d.l0.f.i> r3 = r18.O();
        o.e(r3, "proto.functionList");
        List<kotlin.s0.w.d.l0.f.n> r4 = r18.R();
        o.e(r4, "proto.propertyList");
        List<r> r8 = r18.U();
        o.e(r8, "proto.typeAliasList");
        super(r2, r3, r4, r8, r24);
        this.f20814g = r17;
        this.f20815h = r23;
        this.f20816i = r17.e();
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.h, kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        z(r2, r3);
        return super.f(r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public /* bridge */ /* synthetic */ Collection g(kotlin.s0.w.d.l0.k.w.d r1, kotlin.n0.c.l r2) {
        return y(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.h
    protected void i(Collection<kotlin.s0.w.d.l0.c.m> r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2) {
        o.f(r1, "result");
        o.f(r2, "nameFilter");
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.h
    protected kotlin.s0.w.d.l0.g.b m(kotlin.s0.w.d.l0.g.f r2) {
        o.f(r2, "name");
        return new kotlin.s0.w.d.l0.g.b(this.f20816i, r2);
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.h
    protected Set<kotlin.s0.w.d.l0.g.f> s() {
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.h
    protected Set<kotlin.s0.w.d.l0.g.f> t() {
        return t0.b();
    }

    public String toString() {
        return this.f20815h;
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.h
    protected Set<kotlin.s0.w.d.l0.g.f> u() {
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.l.b.g0.h
    protected boolean w(kotlin.s0.w.d.l0.g.f r6) {
        o.f(r6, "name");
        if (super.w(r6) == true) goto L22;
        Iterable<kotlin.s0.w.d.l0.c.p1.b> r0 = p().c().k();
        if ((r0 instanceof Collection) == true) goto L7;
    L9:
        Iterator<kotlin.s0.w.d.l0.c.p1.b> r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        if (r1.next().b(this.f20816i, r6) == false) goto L11;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L18;
        return true;
    L18:
        return false;
    L8:
        r5 = false;
        goto L15
    L7:
        if (((Collection) r0).isEmpty() == false) goto L9;
    L22:
        return true;
    }

    public List<kotlin.s0.w.d.l0.c.m> y(kotlin.s0.w.d.l0.k.w.d r4, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r5) {
        o.f(r4, "kindFilter");
        o.f(r5, "nameFilter");
        Collection<kotlin.s0.w.d.l0.c.m> r6 = j(r4, r5, kotlin.s0.w.d.l0.d.b.d.r);
        Iterable<kotlin.s0.w.d.l0.c.p1.b> r7 = p().c().k();
        ArrayList r0 = new ArrayList();
        Iterator<kotlin.s0.w.d.l0.c.p1.b> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        kotlin.i0.r.v(r0, r8.next().a(this.f20816i));
        goto L4
    L7:
        return kotlin.i0.r.k0(r6, r0);
    }

    public void z(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        kotlin.s0.w.d.l0.d.a.b(p().c().o(), r3, this.f20814g, r2);
    }
}

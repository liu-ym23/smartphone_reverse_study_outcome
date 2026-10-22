package kotlin.s0.w.d.l0.k.w;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l<Object>[] f20651d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.e f20652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f20653c;

    static final class a extends q implements kotlin.n0.c.a<List<? extends z0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f20654f;

        a(l r1) {
            this.f20654f = r1;
            super(0);
        }

        public final List<z0> a() {
            return r.j(new z0[]{kotlin.s0.w.d.l0.k.c.f(l.h(this.f20654f)), kotlin.s0.w.d.l0.k.c.g(l.h(this.f20654f))});
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends z0> invoke() {
            return a();
        }
    }

    static {
        f20651d = new kotlin.s0.l[]{e0.g(new y(e0.b(l.class), "functions", "getFunctions()Ljava/util/List;"))};
    }

    public l(kotlin.s0.w.d.l0.m.n r2, kotlin.s0.w.d.l0.c.e r3) {
        o.f(r2, "storageManager");
        o.f(r3, "containingClass");
        this.f20652b = r3;
        r3.i();
        kotlin.s0.w.d.l0.c.f r0 = kotlin.s0.w.d.l0.c.f.f18867h;
        this.f20653c = r2.d(new a(this));
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.e h(l r0) {
        return r0.f20652b;
    }

    private final List<z0> l() {
        return (List) kotlin.s0.w.d.l0.m.m.a(this.f20653c, this, f20651d[0]);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public /* bridge */ /* synthetic */ Collection a(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        return k(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        return (kotlin.s0.w.d.l0.c.h) i(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public /* bridge */ /* synthetic */ Collection g(d r1, kotlin.n0.c.l r2) {
        return j(r1, r2);
    }

    public Void i(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        o.f(r1, "name");
        o.f(r2, LocationMonitorConst.LOCATION);
        return null;
    }

    public List<z0> j(d r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
        o.f(r2, "kindFilter");
        o.f(r3, "nameFilter");
        return l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public kotlin.s0.w.d.l0.p.e<z0> k(kotlin.s0.w.d.l0.g.f r3, kotlin.s0.w.d.l0.d.b.b r4) {
        o.f(r3, "name");
        o.f(r4, LocationMonitorConst.LOCATION);
        List<z0> r2 = l();
        kotlin.s0.w.d.l0.p.e<z0> r5 = new kotlin.s0.w.d.l0.p.e();
        Iterator<T> r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if (o.a(((z0) r0).getName(), r3) == false) goto L4;
        r5.add(r0);
        goto L4
    L8:
        return r5;
    }
}

package kotlin.s0.w.d.l0.k.w;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.c1;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.n.j1;
import kotlin.s0.w.d.l0.n.l1;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f20655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l1 f20656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<kotlin.s0.w.d.l0.c.m, kotlin.s0.w.d.l0.c.m> f20657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.h f20658e;

    static final class a extends q implements kotlin.n0.c.a<Collection<? extends kotlin.s0.w.d.l0.c.m>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m f20659f;

        a(m r1) {
            this.f20659f = r1;
            super(0);
        }

        public final Collection<kotlin.s0.w.d.l0.c.m> a() {
            m r3 = this.f20659f;
            return m.i(r3, k.a.a(m.h(r3), null, null, 3, null));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Collection<? extends kotlin.s0.w.d.l0.c.m> invoke() {
            return a();
        }
    }

    public m(h r3, l1 r4) {
        o.f(r3, "workerScope");
        o.f(r4, "givenSubstitutor");
        this.f20655b = r3;
        j1 r5 = r4.j();
        o.e(r5, "givenSubstitutor.substitution");
        this.f20656c = kotlin.s0.w.d.l0.k.q.a.d.f(r5, false, 1, null).c();
        this.f20658e = kotlin.i.b(new a(this));
    }

    public static final /* synthetic */ h h(m r0) {
        return r0.f20655b;
    }

    public static final /* synthetic */ Collection i(m r0, Collection r1) {
        return r0.k(r1);
    }

    private final Collection<kotlin.s0.w.d.l0.c.m> j() {
        return (Collection) this.f20658e.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <D extends kotlin.s0.w.d.l0.c.m> Collection<D> k(Collection<? extends D> r3) {
        if (this.f20656c.k() == false) goto L6;
        return r3;
    L6:
        if (r3.isEmpty() == false) goto L8;
        return r3;
    L8:
        LinkedHashSet r0 = kotlin.s0.w.d.l0.p.a.g(r3.size());
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        r0.add(l((kotlin.s0.w.d.l0.c.m) r4.next()));
        goto L10
    L12:
        return r0;
    }

    private final <D extends kotlin.s0.w.d.l0.c.m> D l(D r3) {
        if (this.f20656c.k() == false) goto L6;
        return r3;
    L6:
        if (this.f20657d != null) goto L8;
        this.f20657d = new HashMap();
    L8:
        Map<kotlin.s0.w.d.l0.c.m, kotlin.s0.w.d.l0.c.m> r0 = this.f20657d;
        o.c(r0);
        kotlin.s0.w.d.l0.c.m r1 = r0.get(r3);
        if (r1 == null) goto L11;
    L19:
        D r2 = (D) r1;
        o.d(r2, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return r2;
    L11:
        if ((r3 instanceof c1) == false) goto L18;
        r1 = ((c1) r3).d(this.f20656c);
        if (r1 == null) goto L16;
        r0.put(r3, r1);
        goto L19
    L16:
        throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + r3 + " substitution fails");
    L18:
        throw new IllegalStateException(("Unknown descriptor in scope: " + r3).toString());
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Collection<? extends z0> a(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        return k(this.f20655b.a(r2, r3));
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> b() {
        return this.f20655b.b();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Collection<? extends u0> c(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        return k(this.f20655b.c(r2, r3));
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> d() {
        return this.f20655b.d();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        return this.f20655b.e();
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        kotlin.s0.w.d.l0.c.h r4 = this.f20655b.f(r2, r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return (kotlin.s0.w.d.l0.c.h) l(r4);
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public Collection<kotlin.s0.w.d.l0.c.m> g(d r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
        o.f(r2, "kindFilter");
        o.f(r3, "nameFilter");
        return j();
    }
}

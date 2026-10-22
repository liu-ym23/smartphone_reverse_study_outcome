package kotlin.s0.w.d.l0.k.w;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f20617d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h[] f20619c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final h a(String r4, Iterable<? extends h> r5) {
            o.f(r4, "debugName");
            o.f(r5, "scopes");
            kotlin.s0.w.d.l0.p.e r0 = new kotlin.s0.w.d.l0.p.e();
            Iterator<? extends h> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L12;
            h r1 = r6.next();
            if (r1 == h.b.f20650b) goto L4;
            if ((r1 instanceof b) == true) goto L9;
            r0.add(r1);
            goto L4
        L9:
            r.w(r0, b.h((b) r1));
            goto L4
        L12:
            return b(r4, r0);
        }

        public final h b(String r3, List<? extends h> r4) {
            o.f(r3, "debugName");
            o.f(r4, "scopes");
            int r2 = r4.size();
            if (r2 == 0) goto L9;
            if (r2 == 1) goto L11;
            Object[] r5 = r4.toArray(new h[0]);
            o.d(r5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new b(r3, (h[]) r5, null);
        L11:
            return r4.get(0);
        L9:
            return h.b.f20650b;
        }
    }

    static {
        f20617d = new a(null);
    }

    private b(String r1, h[] r2) {
        this.f20618b = r1;
        this.f20619c = r2;
    }

    public /* synthetic */ b(String r1, h[] r2, kotlin.n0.d.g r3) {
        this(r1, r2);
    }

    public static final /* synthetic */ h[] h(b r0) {
        return r0.f20619c;
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Collection<z0> a(kotlin.s0.w.d.l0.g.f r5, kotlin.s0.w.d.l0.d.b.b r6) {
        o.f(r5, "name");
        o.f(r6, LocationMonitorConst.LOCATION);
        h[] r4 = this.f20619c;
        int r0 = r4.length;
        if (r0 == 0) goto L13;
        int r1 = 0;
        if (r0 == 1) goto L17;
        Collection<z0> r2 = null;
        int r3 = r4.length;
    L7:
        if (r1 >= r3) goto L9;
        r2 = kotlin.s0.w.d.l0.o.v.a.a(r2, r4[r1].a(r5, r6));
        r1 = r1 + 1;
        goto L7
    L9:
        if (r2 == null) goto L16;
        return r2;
    L16:
        return t0.b();
    L17:
        return r4[0].a(r5, r6);
    L13:
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> b() {
        h[] r4 = this.f20619c;
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r.v(r0, r4[r2].b());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Collection<u0> c(kotlin.s0.w.d.l0.g.f r5, kotlin.s0.w.d.l0.d.b.b r6) {
        o.f(r5, "name");
        o.f(r6, LocationMonitorConst.LOCATION);
        h[] r4 = this.f20619c;
        int r0 = r4.length;
        if (r0 == 0) goto L13;
        int r1 = 0;
        if (r0 == 1) goto L17;
        Collection<u0> r2 = null;
        int r3 = r4.length;
    L7:
        if (r1 >= r3) goto L9;
        r2 = kotlin.s0.w.d.l0.o.v.a.a(r2, r4[r1].c(r5, r6));
        r1 = r1 + 1;
        goto L7
    L9:
        if (r2 == null) goto L16;
        return r2;
    L16:
        return t0.b();
    L17:
        return r4[0].c(r5, r6);
    L13:
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> d() {
        h[] r4 = this.f20619c;
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r.v(r0, r4[r2].d());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        return j.a(kotlin.i0.i.p(this.f20619c));
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r6, kotlin.s0.w.d.l0.d.b.b r7) {
        o.f(r6, "name");
        o.f(r7, LocationMonitorConst.LOCATION);
        h[] r5 = this.f20619c;
        int r0 = r5.length;
        kotlin.s0.w.d.l0.c.h r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        kotlin.s0.w.d.l0.c.h r3 = r5[r2].f(r6, r7);
        if (r3 == null) goto L13;
        if ((r3 instanceof kotlin.s0.w.d.l0.c.i) == false) goto L14;
        if (((kotlin.s0.w.d.l0.c.i) r3).L() == false) goto L14;
        if (r1 != null) goto L13;
        r1 = r3;
    L14:
        return r3;
    L13:
        r2 = r2 + 1;
        goto L3
    L21:
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public Collection<kotlin.s0.w.d.l0.c.m> g(d r5, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r6) {
        o.f(r5, "kindFilter");
        o.f(r6, "nameFilter");
        h[] r4 = this.f20619c;
        int r0 = r4.length;
        if (r0 == 0) goto L13;
        int r1 = 0;
        if (r0 == 1) goto L17;
        Collection<kotlin.s0.w.d.l0.c.m> r2 = null;
        int r3 = r4.length;
    L7:
        if (r1 >= r3) goto L9;
        r2 = kotlin.s0.w.d.l0.o.v.a.a(r2, r4[r1].g(r5, r6));
        r1 = r1 + 1;
        goto L7
    L9:
        if (r2 == null) goto L16;
        return r2;
    L16:
        return t0.b();
    L17:
        return r4[0].g(r5, r6);
    L13:
        return r.g();
    }

    public String toString() {
        return this.f20618b;
    }
}

package kotlin.s0.w.d.l0.e.a.l0.l;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.e.a.n0.u;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements kotlin.s0.w.d.l0.k.w.h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l<Object>[] f19394f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.l0.g f19395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f19396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f19397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19398e;

    static final class a extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.k.w.h[]> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f19399f;

        a(d r1) {
            this.f19399f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.l0.k.w.h[] a() {
            Collection<kotlin.s0.w.d.l0.e.b.q> r0 = d.i(this.f19399f).N0().values();
            d r5 = this.f19399f;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            kotlin.s0.w.d.l0.e.b.q r3 = (kotlin.s0.w.d.l0.e.b.q) r2.next();
            kotlin.s0.w.d.l0.k.w.h r4 = d.h(r5).a().b().b(d.i(r5), r3);
            if (r4 == null) goto L4;
            r1.add(r4);
            goto L4
        L8:
            Object[] r6 = kotlin.s0.w.d.l0.o.v.a.b(r1).toArray(new kotlin.s0.w.d.l0.k.w.h[0]);
            o.d(r6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (kotlin.s0.w.d.l0.k.w.h[]) r6;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h[] invoke() {
            return a();
        }
    }

    static {
        f19394f = new kotlin.s0.l[]{e0.g(new y(e0.b(d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    }

    public d(kotlin.s0.w.d.l0.e.a.l0.g r2, u r3, h r4) {
        o.f(r2, "c");
        o.f(r3, "jPackage");
        o.f(r4, "packageFragment");
        this.f19395b = r2;
        this.f19396c = r4;
        this.f19397d = new i(r2, r3, r4);
        this.f19398e = r2.e().d(new a(this));
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.g h(d r0) {
        return r0.f19395b;
    }

    public static final /* synthetic */ h i(d r0) {
        return r0.f19396c;
    }

    private final kotlin.s0.w.d.l0.k.w.h[] k() {
        return (kotlin.s0.w.d.l0.k.w.h[]) kotlin.s0.w.d.l0.m.m.a(this.f19398e, this, f19394f[0]);
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Collection<z0> a(kotlin.s0.w.d.l0.g.f r5, kotlin.s0.w.d.l0.d.b.b r6) {
        o.f(r5, "name");
        o.f(r6, LocationMonitorConst.LOCATION);
        l(r5, r6);
        i r0 = this.f19397d;
        kotlin.s0.w.d.l0.k.w.h[] r4 = k();
        Collection<? extends z0> r1 = r0.a(r5, r6);
        int r2 = r4.length;
        int r3 = 0;
        Collection r7 = r1;
    L3:
        if (r3 >= r2) goto L5;
        Collection r8 = kotlin.s0.w.d.l0.o.v.a.a(r7, r4[r3].a(r5, r6));
        r3 = r3 + 1;
        r7 = r8;
        goto L3
    L5:
        if (r7 == null) goto L7;
        return r7;
    L7:
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> b() {
        kotlin.s0.w.d.l0.k.w.h[] r0 = k();
        LinkedHashSet r1 = new LinkedHashSet();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r.v(r1, r0[r3].b());
        r3 = r3 + 1;
        goto L3
    L5:
        r1.addAll(this.f19397d.b());
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Collection<u0> c(kotlin.s0.w.d.l0.g.f r5, kotlin.s0.w.d.l0.d.b.b r6) {
        o.f(r5, "name");
        o.f(r6, LocationMonitorConst.LOCATION);
        l(r5, r6);
        i r0 = this.f19397d;
        kotlin.s0.w.d.l0.k.w.h[] r4 = k();
        Collection<? extends u0> r1 = r0.c(r5, r6);
        int r2 = r4.length;
        int r3 = 0;
        Collection r7 = r1;
    L3:
        if (r3 >= r2) goto L5;
        Collection r8 = kotlin.s0.w.d.l0.o.v.a.a(r7, r4[r3].c(r5, r6));
        r3 = r3 + 1;
        r7 = r8;
        goto L3
    L5:
        if (r7 == null) goto L7;
        return r7;
    L7:
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> d() {
        kotlin.s0.w.d.l0.k.w.h[] r0 = k();
        LinkedHashSet r1 = new LinkedHashSet();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r.v(r1, r0[r3].d());
        r3 = r3 + 1;
        goto L3
    L5:
        r1.addAll(this.f19397d.d());
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        Set<kotlin.s0.w.d.l0.g.f> r0 = kotlin.s0.w.d.l0.k.w.j.a(kotlin.i0.i.p(k()));
        if (r0 == null) goto L5;
        r0.addAll(this.f19397d.e());
        return r0;
    L5:
        return null;
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r6, kotlin.s0.w.d.l0.d.b.b r7) {
        o.f(r6, "name");
        o.f(r7, LocationMonitorConst.LOCATION);
        l(r6, r7);
        kotlin.s0.w.d.l0.c.e r0 = this.f19397d.P(r6, r7);
        if (r0 == null) goto L5;
        return r0;
    L5:
        kotlin.s0.w.d.l0.k.w.h[] r5 = k();
        kotlin.s0.w.d.l0.c.h r1 = null;
        int r2 = 0;
        int r3 = r5.length;
    L6:
        if (r2 >= r3) goto L24;
        kotlin.s0.w.d.l0.c.h r4 = r5[r2].f(r6, r7);
        if (r4 == null) goto L16;
        if ((r4 instanceof kotlin.s0.w.d.l0.c.i) == false) goto L17;
        if (((kotlin.s0.w.d.l0.c.i) r4).L() == false) goto L17;
        if (r1 != null) goto L16;
        r1 = r4;
    L17:
        return r4;
    L16:
        r2 = r2 + 1;
        goto L6
    L24:
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.k.w.k
    public Collection<kotlin.s0.w.d.l0.c.m> g(kotlin.s0.w.d.l0.k.w.d r5, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r6) {
        o.f(r5, "kindFilter");
        o.f(r6, "nameFilter");
        i r0 = this.f19397d;
        kotlin.s0.w.d.l0.k.w.h[] r4 = k();
        Collection<kotlin.s0.w.d.l0.c.m> r1 = r0.g(r5, r6);
        int r2 = r4.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1 = kotlin.s0.w.d.l0.o.v.a.a(r1, r4[r3].g(r5, r6));
        r3 = r3 + 1;
        goto L3
    L5:
        if (r1 == null) goto L7;
        return r1;
    L7:
        return t0.b();
    }

    public final i j() {
        return this.f19397d;
    }

    public void l(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        kotlin.s0.w.d.l0.d.a.b(this.f19395b.a().l(), r3, this.f19396c, r2);
    }

    public String toString() {
        return "scope for " + this.f19396c;
    }
}

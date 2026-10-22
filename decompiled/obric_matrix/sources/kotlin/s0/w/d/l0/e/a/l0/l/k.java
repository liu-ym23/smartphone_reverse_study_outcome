package kotlin.s0.w.d.l0.e.a.l0.l;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends l {
    private final kotlin.s0.w.d.l0.e.a.n0.g n;
    private final f o;

    static final class a extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.e.a.n0.q, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19479f = null;

        static {
            f19479f = new a();
        }

        a() {
            super(1);
        }

        public final Boolean a(kotlin.s0.w.d.l0.e.a.n0.q r1) {
            o.f(r1, "it");
            return Boolean.valueOf(r1.Q());
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.e.a.n0.q r1) {
            return a(r1);
        }
    }

    static final class b extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.k.w.h, Collection<? extends u0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.g.f f19480f;

        b(kotlin.s0.w.d.l0.g.f r1) {
            this.f19480f = r1;
            super(1);
        }

        public final Collection<? extends u0> a(kotlin.s0.w.d.l0.k.w.h r2) {
            o.f(r2, "it");
            return r2.c(this.f19480f, kotlin.s0.w.d.l0.d.b.d.t);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Collection<? extends u0> invoke(kotlin.s0.w.d.l0.k.w.h r1) {
            return a(r1);
        }
    }

    static final class c extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.k.w.h, Collection<? extends kotlin.s0.w.d.l0.g.f>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f19481f = null;

        static {
            f19481f = new c();
        }

        c() {
            super(1);
        }

        public final Collection<kotlin.s0.w.d.l0.g.f> a(kotlin.s0.w.d.l0.k.w.h r1) {
            o.f(r1, "it");
            return r1.d();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Collection<? extends kotlin.s0.w.d.l0.g.f> invoke(kotlin.s0.w.d.l0.k.w.h r1) {
            return a(r1);
        }
    }

    static final class d<N> implements kotlin.s0.w.d.l0.p.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<N> f19482a = null;

        static final class a extends q implements kotlin.n0.c.l<e0, kotlin.s0.w.d.l0.c.e> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f19483f = null;

            static {
                f19483f = new a();
            }

            a() {
                super(1);
            }

            public final kotlin.s0.w.d.l0.c.e a(e0 r1) {
                kotlin.s0.w.d.l0.c.h r0 = r1.O0().d();
                if ((r0 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L7;
                return null;
            L7:
                return (kotlin.s0.w.d.l0.c.e) r0;
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.e invoke(e0 r1) {
                return a(r1);
            }
        }

        static {
            f19482a = new d();
        }

        d() {
        }

        @Override // kotlin.s0.w.d.l0.p.b.c
        public /* bridge */ /* synthetic */ Iterable a(Object r1) {
            return b((kotlin.s0.w.d.l0.c.e) r1);
        }

        public final Iterable<kotlin.s0.w.d.l0.c.e> b(kotlin.s0.w.d.l0.c.e r1) {
            Collection<e0> r0 = r1.k().a();
            o.e(r0, "it.typeConstructor.supertypes");
            return kotlin.t0.k.k(kotlin.t0.k.u(r.I(r0), a.f19483f));
        }
    }

    public static final class e extends kotlin.s0.w.d.l0.p.b.AbstractC0585b<kotlin.s0.w.d.l0.c.e, f0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.c.e f19484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set<R> f19485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l<kotlin.s0.w.d.l0.k.w.h, Collection<R>> f19486c;

        /* JADX WARN: Multi-variable type inference failed */
        e(kotlin.s0.w.d.l0.c.e r1, Set<R> r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.k.w.h, ? extends Collection<? extends R>> r3) {
            this.f19484a = r1;
            this.f19485b = r2;
            this.f19486c = r3;
        }

        @Override // kotlin.s0.w.d.l0.p.b.d
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return f0.f18324a;
        }

        @Override // kotlin.s0.w.d.l0.p.b.d
        public /* bridge */ /* synthetic */ boolean c(Object r1) {
            return d((kotlin.s0.w.d.l0.c.e) r1);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public boolean d(kotlin.s0.w.d.l0.c.e r3) {
            o.f(r3, "current");
            if (r3 != this.f19484a) goto L5;
            return true;
        L5:
            kotlin.s0.w.d.l0.k.w.h r4 = r3.R();
            o.e(r4, "current.staticScope");
            if ((r4 instanceof l) == false) goto L9;
            this.f19485b.addAll((Collection<? extends R>) ((Collection) this.f19486c.invoke(r4)));
            return false;
        L9:
            return true;
        }

        public void e() {
        }
    }

    public k(kotlin.s0.w.d.l0.e.a.l0.g r2, kotlin.s0.w.d.l0.e.a.n0.g r3, f r4) {
        o.f(r2, "c");
        o.f(r3, "jClass");
        o.f(r4, "ownerDescriptor");
        super(r2);
        this.n = r3;
        this.o = r4;
    }

    private final <R> Set<R> N(kotlin.s0.w.d.l0.c.e r3, Set<R> r4, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.k.w.h, ? extends Collection<? extends R>> r5) {
        kotlin.s0.w.d.l0.p.b.b(r.d(r3), d.f19482a, new e(r3, r4, r5));
        return r4;
    }

    private final u0 P(u0 r4) {
        if (r4.i().a() == false) goto L5;
        return r4;
    L5:
        Collection<? extends u0> r5 = r4.f();
        o.e(r5, "this.overriddenDescriptors");
        ArrayList r0 = new ArrayList(r.q(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L10;
        u0 r1 = (u0) r6.next();
        o.e(r1, "it");
        r0.add(P(r1));
        goto L7
    L10:
        return (u0) r.o0(r.K(r0));
    }

    private final Set<z0> Q(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.c.e r2) {
        k r0 = kotlin.s0.w.d.l0.e.a.k0.h.b(r2);
        if (r0 != null) goto L7;
        return t0.b();
    L7:
        return r.D0(r0.a(r1, kotlin.s0.w.d.l0.d.b.d.t));
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m C() {
        return O();
    }

    protected kotlin.s0.w.d.l0.e.a.l0.l.a M() {
        return new kotlin.s0.w.d.l0.e.a.l0.l.a(this.n, a.f19479f);
    }

    protected f O() {
        return this.o;
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        o.f(r1, "name");
        o.f(r2, LocationMonitorConst.LOCATION);
        return null;
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected Set<kotlin.s0.w.d.l0.g.f> l(kotlin.s0.w.d.l0.k.w.d r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2) {
        o.f(r1, "kindFilter");
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected Set<kotlin.s0.w.d.l0.g.f> n(kotlin.s0.w.d.l0.k.w.d r3, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r4) {
        o.f(r3, "kindFilter");
        Set<kotlin.s0.w.d.l0.g.f> r5 = r.C0(y().invoke().a());
        k r6 = kotlin.s0.w.d.l0.e.a.k0.h.b(O());
        if (r6 == null) goto L5;
        Set<kotlin.s0.w.d.l0.g.f> r7 = r6.b();
    L6:
        if (r7 != null) goto L8;
        r7 = t0.b();
    L8:
        r5.addAll(r7);
        if (this.n.A() == false) goto L11;
        r5.addAll(r.j(new kotlin.s0.w.d.l0.g.f[]{kotlin.s0.w.d.l0.b.k.f18707c, kotlin.s0.w.d.l0.b.k.f18706b}));
    L11:
        r5.addAll(w().a().w().a(O()));
        return r5;
    L5:
        r7 = null;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected void o(Collection<z0> r2, kotlin.s0.w.d.l0.g.f r3) {
        o.f(r2, "result");
        o.f(r3, "name");
        w().a().w().e(O(), r3, r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.l.b p() {
        return M();
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected void r(Collection<z0> r8, kotlin.s0.w.d.l0.g.f r9) {
        o.f(r8, "result");
        o.f(r9, "name");
        Collection<? extends z0> r0 = kotlin.s0.w.d.l0.e.a.j0.a.e(r9, Q(r9, O()), r8, O(), w().a().c(), w().a().k().a());
        o.e(r0, "resolveOverridesForStati….overridingUtil\n        )");
        r8.addAll(r0);
        if (this.n.A() == true) goto L5;
        return;
    L5:
        if (o.a(r9, kotlin.s0.w.d.l0.b.k.f18707c) == false) goto L9;
        z0 r7 = kotlin.s0.w.d.l0.k.c.f(O());
        String r10 = "createEnumValueOfMethod(ownerDescriptor)";
    L7:
        o.e(r7, r10);
        r8.add(r7);
        return;
    L9:
        if (o.a(r9, kotlin.s0.w.d.l0.b.k.f18706b) == false) goto L13;
        r7 = kotlin.s0.w.d.l0.k.c.g(O());
        r10 = "createEnumValuesMethod(ownerDescriptor)";
        goto L7
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.l, kotlin.s0.w.d.l0.e.a.l0.l.j
    protected void s(kotlin.s0.w.d.l0.g.f r11, Collection<u0> r12) {
        o.f(r11, "name");
        o.f(r12, "result");
        f r1 = O();
        LinkedHashSet r2 = new LinkedHashSet();
        N(r1, r2, new b(r11));
        if ((!r12.isEmpty()) == false) goto L5;
        Collection<? extends u0> r0 = kotlin.s0.w.d.l0.e.a.j0.a.e(r11, r2, r12, O(), w().a().c(), w().a().k().a());
        o.e(r0, "resolveOverridesForStati…ingUtil\n                )");
        r12.addAll(r0);
        return;
    L5:
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        Object r5 = r4.next();
        u0 r6 = P((u0) r5);
        Object r7 = r3.get(r6);
        if (r7 != null) goto L11;
        r7 = new ArrayList();
        r3.put(r6, r7);
    L11:
        ((List) r7).add(r5);
        goto L7
    L12:
        ArrayList r8 = new ArrayList();
        Iterator r9 = r3.entrySet().iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        Collection r10 = kotlin.s0.w.d.l0.e.a.j0.a.e(r11, (Collection) ((Map.Entry) r9.next()).getValue(), r12, O(), w().a().c(), w().a().k().a());
        o.e(r10, "resolveOverridesForStati…ingUtil\n                )");
        r.v(r8, r10);
        goto L14
    L16:
        r12.addAll(r8);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected Set<kotlin.s0.w.d.l0.g.f> t(kotlin.s0.w.d.l0.k.w.d r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
        o.f(r2, "kindFilter");
        Set<kotlin.s0.w.d.l0.g.f> r4 = r.C0(y().invoke().e());
        N(O(), r4, c.f19481f);
        return r4;
    }
}

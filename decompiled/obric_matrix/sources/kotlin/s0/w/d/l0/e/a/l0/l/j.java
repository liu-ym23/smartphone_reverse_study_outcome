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
import kotlin.a0;
import kotlin.i0.g0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.q1.c0;
import kotlin.s0.w.d.l0.c.q1.l0;
import kotlin.s0.w.d.l0.c.u;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.e.a.i0;
import kotlin.s0.w.d.l0.e.a.n0.b0;
import kotlin.s0.w.d.l0.e.a.n0.n;
import kotlin.s0.w.d.l0.e.a.n0.r;
import kotlin.s0.w.d.l0.e.a.n0.x;
import kotlin.s0.w.d.l0.e.b.v;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.n1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends kotlin.s0.w.d.l0.k.w.i {
    static final /* synthetic */ kotlin.s0.l<Object>[] m = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.l0.g f19444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f19445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i<Collection<kotlin.s0.w.d.l0.c.m>> f19446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i<kotlin.s0.w.d.l0.e.a.l0.l.b> f19447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.g<kotlin.s0.w.d.l0.g.f, Collection<z0>> f19448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.h<kotlin.s0.w.d.l0.g.f, u0> f19449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.g<kotlin.s0.w.d.l0.g.f, Collection<z0>> f19450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19451i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19452j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19453k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.g<kotlin.s0.w.d.l0.g.f, List<u0>> f19454l;

    protected static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e0 f19455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e0 f19456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<j1> f19457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<f1> f19458d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f19459e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List<String> f19460f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(e0 r2, e0 r3, List<? extends j1> r4, List<? extends f1> r5, boolean r6, List<String> r7) {
            o.f(r2, "returnType");
            o.f(r4, "valueParameters");
            o.f(r5, "typeParameters");
            o.f(r7, "errors");
            this.f19455a = r2;
            this.f19456b = r3;
            this.f19457c = r4;
            this.f19458d = r5;
            this.f19459e = r6;
            this.f19460f = r7;
        }

        public final List<String> a() {
            return this.f19460f;
        }

        public final boolean b() {
            return this.f19459e;
        }

        public final e0 c() {
            return this.f19456b;
        }

        public final e0 d() {
            return this.f19455a;
        }

        public final List<f1> e() {
            return this.f19458d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (o.a(this.f19455a, r6.f19455a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f19456b, r6.f19456b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f19457c, r6.f19457c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f19458d, r6.f19458d) == true) goto L21;
            return false;
        L21:
            if (this.f19459e == r6.f19459e) goto L24;
            return false;
        L24:
            if (o.a(this.f19460f, r6.f19460f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final List<j1> f() {
            return this.f19457c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            int r0 = this.f19455a.hashCode() * 31;
            e0 r1 = this.f19456b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (((((r0 + r2) * 31) + this.f19457c.hashCode()) * 31) + this.f19458d.hashCode()) * 31;
            boolean r4 = this.f19459e;
            ?? r5 = r4;
            if (r4 == false) goto L10;
            r5 = 1;
        L10:
            return ((r3 + r5) * 31) + this.f19460f.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.f19455a + ", receiverType=" + this.f19456b + ", valueParameters=" + this.f19457c + ", typeParameters=" + this.f19458d + ", hasStableParameterNames=" + this.f19459e + ", errors=" + this.f19460f + ')';
        }
    }

    protected static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<j1> f19461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f19462b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends j1> r2, boolean r3) {
            o.f(r2, "descriptors");
            this.f19461a = r2;
            this.f19462b = r3;
        }

        public final List<j1> a() {
            return this.f19461a;
        }

        public final boolean b() {
            return this.f19462b;
        }
    }

    static final class c extends q implements kotlin.n0.c.a<Collection<? extends kotlin.s0.w.d.l0.c.m>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f19463f;

        c(j r1) {
            this.f19463f = r1;
            super(0);
        }

        public final Collection<kotlin.s0.w.d.l0.c.m> a() {
            return this.f19463f.m(kotlin.s0.w.d.l0.k.w.d.o, kotlin.s0.w.d.l0.k.w.h.f20646a.a());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Collection<? extends kotlin.s0.w.d.l0.c.m> invoke() {
            return a();
        }
    }

    static final class d extends q implements kotlin.n0.c.a<Set<? extends kotlin.s0.w.d.l0.g.f>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f19464f;

        d(j r1) {
            this.f19464f = r1;
            super(0);
        }

        public final Set<kotlin.s0.w.d.l0.g.f> a() {
            return this.f19464f.l(kotlin.s0.w.d.l0.k.w.d.q, null);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Set<? extends kotlin.s0.w.d.l0.g.f> invoke() {
            return a();
        }
    }

    static final class e extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, u0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f19465f;

        e(j r1) {
            this.f19465f = r1;
            super(1);
        }

        public final u0 a(kotlin.s0.w.d.l0.g.f r2) {
            o.f(r2, "name");
            if (this.f19465f.B() != null) goto L5;
            n r3 = this.f19465f.y().invoke().c(r2);
            if (r3 != null) goto L9;
        L11:
            return null;
        L9:
            if (r3.G() == true) goto L11;
            return j.j(this.f19465f, r3);
        L5:
            return (u0) j.h(this.f19465f.B()).invoke(r2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ u0 invoke(kotlin.s0.w.d.l0.g.f r1) {
            return a(r1);
        }
    }

    static final class f extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Collection<? extends z0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f19466f;

        f(j r1) {
            this.f19466f = r1;
            super(1);
        }

        public final Collection<z0> a(kotlin.s0.w.d.l0.g.f r6) {
            o.f(r6, "name");
            if (this.f19466f.B() != null) goto L5;
            ArrayList r0 = new ArrayList();
            Iterator<r> r1 = this.f19466f.y().invoke().f(r6).iterator();
        L8:
            if (r1.hasNext() == false) goto L12;
            r r2 = r1.next();
            kotlin.s0.w.d.l0.e.a.k0.e r3 = this.f19466f.I(r2);
            if (this.f19466f.G(r3) == false) goto L8;
            this.f19466f.w().a().h().e(r2, r3);
            r0.add(r3);
            goto L8
        L12:
            this.f19466f.o(r0, r6);
            return r0;
        L5:
            return (Collection) j.i(this.f19466f.B()).invoke(r6);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Collection<? extends z0> invoke(kotlin.s0.w.d.l0.g.f r1) {
            return a(r1);
        }
    }

    static final class g extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.e.a.l0.l.b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f19467f;

        g(j r1) {
            this.f19467f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.l0.e.a.l0.l.b a() {
            return this.f19467f.p();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.l.b invoke() {
            return a();
        }
    }

    static final class h extends q implements kotlin.n0.c.a<Set<? extends kotlin.s0.w.d.l0.g.f>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f19468f;

        h(j r1) {
            this.f19468f = r1;
            super(0);
        }

        public final Set<kotlin.s0.w.d.l0.g.f> a() {
            return this.f19468f.n(kotlin.s0.w.d.l0.k.w.d.r, null);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Set<? extends kotlin.s0.w.d.l0.g.f> invoke() {
            return a();
        }
    }

    static final class i extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Collection<? extends z0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f19469f;

        i(j r1) {
            this.f19469f = r1;
            super(1);
        }

        public final Collection<z0> a(kotlin.s0.w.d.l0.g.f r3) {
            o.f(r3, "name");
            LinkedHashSet r0 = new LinkedHashSet((Collection) j.i(this.f19469f).invoke(r3));
            j.k(this.f19469f, r0);
            this.f19469f.r(r0, r3);
            return kotlin.i0.r.z0(this.f19469f.w().a().r().g(this.f19469f.w(), r0));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Collection<? extends z0> invoke(kotlin.s0.w.d.l0.g.f r1) {
            return a(r1);
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.l0.l.j$j, reason: collision with other inner class name */
    static final class C0516j extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, List<? extends u0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f19470f;

        C0516j(j r1) {
            this.f19470f = r1;
            super(1);
        }

        public final List<u0> a(kotlin.s0.w.d.l0.g.f r3) {
            o.f(r3, "name");
            ArrayList r0 = new ArrayList();
            kotlin.s0.w.d.l0.p.a.a(r0, j.h(this.f19470f).invoke(r3));
            this.f19470f.s(r3, r0);
            if (kotlin.s0.w.d.l0.k.d.t(this.f19470f.C()) == false) goto L6;
            return kotlin.i0.r.z0(r0);
        L6:
            return kotlin.i0.r.z0(this.f19470f.w().a().r().g(this.f19470f.w(), r0));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ List<? extends u0> invoke(kotlin.s0.w.d.l0.g.f r1) {
            return a(r1);
        }
    }

    static final class k extends q implements kotlin.n0.c.a<Set<? extends kotlin.s0.w.d.l0.g.f>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f19471f;

        k(j r1) {
            this.f19471f = r1;
            super(0);
        }

        public final Set<kotlin.s0.w.d.l0.g.f> a() {
            return this.f19471f.t(kotlin.s0.w.d.l0.k.w.d.s, null);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Set<? extends kotlin.s0.w.d.l0.g.f> invoke() {
            return a();
        }
    }

    static final class l extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.m.j<? extends kotlin.s0.w.d.l0.k.r.g<?>>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f19472f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f19473g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c0 f19474h;

        static final class a extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.k.r.g<?>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ j f19475f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ n f19476g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ c0 f19477h;

            a(j r1, n r2, c0 r3) {
                this.f19475f = r1;
                this.f19476g = r2;
                this.f19477h = r3;
                super(0);
            }

            public final kotlin.s0.w.d.l0.k.r.g<?> a() {
                return this.f19475f.w().a().g().a(this.f19476g, this.f19477h);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.r.g<?> invoke() {
                return a();
            }
        }

        l(j r1, n r2, c0 r3) {
            this.f19472f = r1;
            this.f19473g = r2;
            this.f19474h = r3;
            super(0);
        }

        public final kotlin.s0.w.d.l0.m.j<kotlin.s0.w.d.l0.k.r.g<?>> a() {
            return this.f19472f.w().e().f(new a(this.f19472f, this.f19473g, this.f19474h));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.m.j<? extends kotlin.s0.w.d.l0.k.r.g<?>> invoke() {
            return a();
        }
    }

    static final class m extends q implements kotlin.n0.c.l<z0, kotlin.s0.w.d.l0.c.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final m f19478f = null;

        static {
            f19478f = new m();
        }

        m() {
            super(1);
        }

        public final kotlin.s0.w.d.l0.c.a a(z0 r1) {
            o.f(r1, "$this$selectMostSpecificInEachOverridableGroup");
            return r1;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a invoke(z0 r1) {
            z0 r2 = r1;
            a(r2);
            return r2;
        }
    }

    static {
        m = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(j.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(j.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), kotlin.n0.d.e0.g(new y(kotlin.n0.d.e0.b(j.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    public j(kotlin.s0.w.d.l0.e.a.l0.g r3, j r4) {
        o.f(r3, "c");
        this.f19444b = r3;
        this.f19445c = r4;
        this.f19446d = r3.e().c(new c(this), kotlin.i0.r.g());
        this.f19447e = r3.e().d(new g(this));
        this.f19448f = r3.e().h(new f(this));
        this.f19449g = r3.e().i(new e(this));
        this.f19450h = r3.e().h(new i(this));
        this.f19451i = r3.e().d(new h(this));
        this.f19452j = r3.e().d(new k(this));
        this.f19453k = r3.e().d(new d(this));
        this.f19454l = r3.e().h(new C0516j(this));
    }

    public /* synthetic */ j(kotlin.s0.w.d.l0.e.a.l0.g r1, j r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    private final Set<kotlin.s0.w.d.l0.g.f> A() {
        return (Set) kotlin.s0.w.d.l0.m.m.a(this.f19451i, this, m[0]);
    }

    private final Set<kotlin.s0.w.d.l0.g.f> D() {
        return (Set) kotlin.s0.w.d.l0.m.m.a(this.f19452j, this, m[1]);
    }

    private final e0 E(n r7) {
        boolean r3 = false;
        e0 r0 = this.f19444b.g().o(r7.b(), kotlin.s0.w.d.l0.e.a.l0.m.d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, false, null, 3, null));
        if (kotlin.s0.w.d.l0.b.h.r0(r0) == true) goto L7;
        if (kotlin.s0.w.d.l0.b.h.u0(r0) == true) goto L7;
    L11:
        if (r3 == false) goto L14;
        e0 r6 = n1.n(r0);
        o.e(r6, "makeNotNullable(propertyType)");
        return r6;
    L14:
        return r0;
    L7:
        if (F(r7) == false) goto L11;
        if (r7.O() == false) goto L11;
        r3 = true;
        goto L11
    }

    private final boolean F(n r1) {
        if (r1.isFinal() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.Q() == false) goto L7;
        return true;
    }

    private final u0 J(n r8) {
        c0 r6 = u(r8);
        r6.W0(null, null, null, null);
        r6.c1(E(r8), kotlin.i0.r.g(), z(), null, kotlin.i0.r.g());
        if (kotlin.s0.w.d.l0.k.d.K(r6, r6.b()) == false) goto L5;
        r6.M0(new l(this, r8, r6));
    L5:
        this.f19444b.a().h().d(r8, r6);
        return r6;
    }

    private final void L(Set<z0> r7) {
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r0 = r7.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r1 = r0.next();
        String r2 = v.c((z0) r1, false, false, 2, null);
        Object r3 = r6.get(r2);
        if (r3 != null) goto L8;
        r3 = new ArrayList();
        r6.put(r2, r3);
    L8:
        ((List) r3).add(r1);
        goto L4
    L9:
        Iterator r8 = r6.values().iterator();
    L11:
        if (r8.hasNext() == false) goto L15;
        List r4 = (List) r8.next();
        if (r4.size() == 1) goto L11;
        Collection<? extends z0> r5 = kotlin.s0.w.d.l0.k.l.a(r4, m.f19478f);
        r7.removeAll(r4);
        r7.addAll(r5);
        goto L11
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.m.h h(j r0) {
        return r0.f19449g;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.m.g i(j r0) {
        return r0.f19448f;
    }

    public static final /* synthetic */ u0 j(j r0, n r1) {
        return r0.J(r1);
    }

    public static final /* synthetic */ void k(j r0, Set r1) {
        r0.L(r1);
    }

    private final c0 u(n r10) {
        boolean r5 = !r10.isFinal();
        kotlin.s0.w.d.l0.e.a.k0.f r9 = kotlin.s0.w.d.l0.e.a.k0.f.g1(C(), kotlin.s0.w.d.l0.e.a.l0.e.a(this.f19444b, r10), kotlin.s0.w.d.l0.c.e0.f18860g, i0.c(r10.getVisibility()), r5, r10.getName(), this.f19444b.a().t().a(r10), F(r10));
        o.e(r9, "create(\n            owne…d.isFinalStatic\n        )");
        return r9;
    }

    private final Set<kotlin.s0.w.d.l0.g.f> x() {
        return (Set) kotlin.s0.w.d.l0.m.m.a(this.f19453k, this, m[2]);
    }

    protected final j B() {
        return this.f19445c;
    }

    protected abstract kotlin.s0.w.d.l0.c.m C();

    protected boolean G(kotlin.s0.w.d.l0.e.a.k0.e r1) {
        o.f(r1, "<this>");
        return true;
    }

    protected abstract a H(r r1, List<? extends f1> r2, e0 r3, List<? extends j1> r4);

    protected final kotlin.s0.w.d.l0.e.a.k0.e I(r r21) {
        o.f(r21, "method");
        kotlin.s0.w.d.l0.c.o1.g r1 = kotlin.s0.w.d.l0.e.a.l0.e.a(this.f19444b, r21);
        kotlin.s0.w.d.l0.c.m r2 = C();
        kotlin.s0.w.d.l0.g.f r3 = r21.getName();
        kotlin.s0.w.d.l0.e.a.m0.a r4 = this.f19444b.a().t().a(r21);
        if (this.f19447e.invoke().b(r21.getName()) != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        kotlin.s0.w.d.l0.e.a.k0.e r15 = kotlin.s0.w.d.l0.e.a.k0.e.q1(r2, r1, r3, r4, r5);
        o.e(r15, "createJavaMethod(\n      …eters.isEmpty()\n        )");
        kotlin.s0.w.d.l0.e.a.l0.g r6 = kotlin.s0.w.d.l0.e.a.l0.a.f(this.f19444b, r15, r21, 0, 4, null);
        List<kotlin.s0.w.d.l0.e.a.n0.y> r7 = r21.getTypeParameters();
        List<? extends f1> r8 = new ArrayList(kotlin.i0.r.q(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        f1 r10 = r6.f().a((kotlin.s0.w.d.l0.e.a.n0.y) r9.next());
        o.c(r10);
        r8.add(r10);
        goto L10
    L12:
        b r11 = K(r6, r15, r21.h());
        a r12 = H(r21, r8, q(r21, r6), r11.a());
        e0 r13 = r12.c();
        if (r13 == null) goto L15;
        x0 r14 = kotlin.s0.w.d.l0.k.c.h(r15, r13, kotlin.s0.w.d.l0.c.o1.g.f18919b.b());
    L16:
        x0 r16 = z();
        List<x0> r17 = kotlin.i0.r.g();
        List<f1> r18 = r12.e();
        List<j1> r0 = r12.f();
        e0 r19 = r12.d();
        kotlin.s0.w.d.l0.c.e0 r110 = kotlin.s0.w.d.l0.c.e0.f18859f.a(false, r21.isAbstract(), !r21.isFinal());
        u r111 = i0.c(r21.getVisibility());
        if (r12.c() == null) goto L19;
        Map<? extends kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, ?> r20 = m0.e(a0.a(kotlin.s0.w.d.l0.e.a.k0.e.L, kotlin.i0.r.P(r11.a())));
    L20:
        r15.p1(r14, r16, r17, r18, r0, r19, r110, r111, r20);
        r15.t1(r12.b(), r11.b());
        if ((!r12.a().isEmpty()) == true) goto L23;
        return r15;
    L23:
        r6.a().s().b(r15, r12.a());
        throw null;
    L19:
        r20 = m0.h();
        goto L20
    L15:
        r14 = null;
        goto L16
    L5:
        if (r21.h().isEmpty() == false) goto L7;
        r5 = true;
        goto L8
    }

    protected final b K(kotlin.s0.w.d.l0.e.a.l0.g r22, kotlin.s0.w.d.l0.c.y r23, List<? extends b0> r24) {
        kotlin.s0.w.d.l0.e.a.l0.g r0 = r22;
        o.f(r0, "c");
        o.f(r23, "function");
        o.f(r24, "jValueParameters");
        Iterable r1 = kotlin.i0.r.F0(r24);
        ArrayList r13 = new ArrayList(kotlin.i0.r.q(r1, 10));
        Iterator r2 = r1.iterator();
        boolean r12 = false;
        boolean r3 = false;
    L4:
        if (r2.hasNext() == false) goto L29;
        g0 r4 = (g0) r2.next();
        int r5 = r4.a();
        b0 r6 = (b0) r4.b();
        kotlin.s0.w.d.l0.c.o1.g r7 = kotlin.s0.w.d.l0.e.a.l0.e.a(r0, r6);
        kotlin.s0.w.d.l0.e.a.n0.f r8 = null;
        kotlin.s0.w.d.l0.e.a.l0.m.a r9 = kotlin.s0.w.d.l0.e.a.l0.m.d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, r12, null, 3, null);
        if (r6.c() == false) goto L14;
        x r10 = r6.b();
        if ((r10 instanceof kotlin.s0.w.d.l0.e.a.n0.f) == false) goto L10;
        r8 = (kotlin.s0.w.d.l0.e.a.n0.f) r10;
    L10:
        if (r8 == null) goto L13;
        e0 r11 = r22.g().k(r8, r9, true);
        kotlin.u r14 = a0.a(r11, r22.d().o().k(r11));
    L15:
        e0 r15 = (e0) r14.a();
        e0 r16 = (e0) r14.b();
        if (o.a(r23.getName().b(), "equals") == true) goto L18;
    L22:
        kotlin.s0.w.d.l0.g.f r17 = r6.getName();
        if (r17 != null) goto L25;
        r3 = true;
    L25:
        if (r17 != null) goto L27;
        StringBuilder r18 = new StringBuilder();
        r18.append('p');
        r18.append(r5);
        r17 = kotlin.s0.w.d.l0.g.f.k(r18.toString());
        o.e(r17, "identifier(\"p$index\")");
    L27:
        kotlin.s0.w.d.l0.g.f r19 = r17;
        o.e(r19, "if (function.name.asStri…(\"p$index\")\n            }");
        ArrayList r20 = r13;
        r20.add(new l0(r23, null, r5, r7, r19, r15, false, false, false, r16, r22.a().t().a(r6)));
        r13 = r20;
        r3 = r3;
        r12 = r12;
        r0 = r22;
        goto L4
    L18:
        if (r24.size() != 1) goto L22;
        if (o.a(r22.d().o().I(), r15) == false) goto L22;
        r17 = kotlin.s0.w.d.l0.g.f.k("other");
        goto L27
    L13:
        throw new AssertionError("Vararg parameter should be an array: " + r6);
    L14:
        r14 = a0.a(r22.g().o(r6.b(), r9), null);
        goto L15
    L29:
        return new b(kotlin.i0.r.z0(r13), r3);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Collection<z0> a(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        if (b().contains(r2) == true) goto L7;
        return kotlin.i0.r.g();
    L7:
        return this.f19450h.invoke(r2);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> b() {
        return A();
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Collection<u0> c(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        if (d().contains(r2) == true) goto L7;
        return kotlin.i0.r.g();
    L7:
        return this.f19454l.invoke(r2);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> d() {
        return D();
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        return x();
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public Collection<kotlin.s0.w.d.l0.c.m> g(kotlin.s0.w.d.l0.k.w.d r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
        o.f(r2, "kindFilter");
        o.f(r3, "nameFilter");
        return this.f19446d.invoke();
    }

    protected abstract Set<kotlin.s0.w.d.l0.g.f> l(kotlin.s0.w.d.l0.k.w.d r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2);

    protected final List<kotlin.s0.w.d.l0.c.m> m(kotlin.s0.w.d.l0.k.w.d r6, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r7) {
        o.f(r6, "kindFilter");
        o.f(r7, "nameFilter");
        kotlin.s0.w.d.l0.d.b.d r0 = kotlin.s0.w.d.l0.d.b.d.r;
        LinkedHashSet r1 = new LinkedHashSet();
        if (r6.a(kotlin.s0.w.d.l0.k.w.d.f20623c.c()) == false) goto L11;
        Iterator<kotlin.s0.w.d.l0.g.f> r2 = l(r6, r7).iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        kotlin.s0.w.d.l0.g.f r3 = r2.next();
        if (r7.invoke(r3).booleanValue() == false) goto L6;
        kotlin.s0.w.d.l0.p.a.a(r1, f(r3, r0));
    L11:
        if (r6.a(kotlin.s0.w.d.l0.k.w.d.f20623c.d()) == false) goto L21;
        if (r6.l().contains(kotlin.s0.w.d.l0.k.w.c.a.f20620a) == true) goto L21;
        Iterator<kotlin.s0.w.d.l0.g.f> r4 = n(r6, r7).iterator();
    L16:
        if (r4.hasNext() == false) goto L21;
        kotlin.s0.w.d.l0.g.f r5 = r4.next();
        if (r7.invoke(r5).booleanValue() == false) goto L16;
        r1.addAll(a(r5, r0));
    L21:
        if (r6.a(kotlin.s0.w.d.l0.k.w.d.f20623c.i()) == false) goto L31;
        if (r6.l().contains(kotlin.s0.w.d.l0.k.w.c.a.f20620a) == true) goto L31;
        Iterator<kotlin.s0.w.d.l0.g.f> r8 = t(r6, r7).iterator();
    L26:
        if (r8.hasNext() == false) goto L31;
        kotlin.s0.w.d.l0.g.f r9 = r8.next();
        if (r7.invoke(r9).booleanValue() == false) goto L26;
        r1.addAll(c(r9, r0));
    L31:
        return kotlin.i0.r.z0(r1);
    }

    protected abstract Set<kotlin.s0.w.d.l0.g.f> n(kotlin.s0.w.d.l0.k.w.d r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2);

    protected void o(Collection<z0> r1, kotlin.s0.w.d.l0.g.f r2) {
        o.f(r1, "result");
        o.f(r2, "name");
    }

    protected abstract kotlin.s0.w.d.l0.e.a.l0.l.b p();

    protected final e0 q(r r4, kotlin.s0.w.d.l0.e.a.l0.g r5) {
        o.f(r4, "method");
        o.f(r5, "c");
        boolean r3 = r4.P().q();
        kotlin.s0.w.d.l0.e.a.l0.m.a r6 = kotlin.s0.w.d.l0.e.a.l0.m.d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, r3, null, 2, null);
        return r5.g().o(r4.getReturnType(), r6);
    }

    protected abstract void r(Collection<z0> r1, kotlin.s0.w.d.l0.g.f r2);

    protected abstract void s(kotlin.s0.w.d.l0.g.f r1, Collection<u0> r2);

    protected abstract Set<kotlin.s0.w.d.l0.g.f> t(kotlin.s0.w.d.l0.k.w.d r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2);

    public String toString() {
        return "Lazy scope for " + C();
    }

    protected final kotlin.s0.w.d.l0.m.i<Collection<kotlin.s0.w.d.l0.c.m>> v() {
        return this.f19446d;
    }

    protected final kotlin.s0.w.d.l0.e.a.l0.g w() {
        return this.f19444b;
    }

    protected final kotlin.s0.w.d.l0.m.i<kotlin.s0.w.d.l0.e.a.l0.l.b> y() {
        return this.f19447e;
    }

    protected abstract x0 z();
}

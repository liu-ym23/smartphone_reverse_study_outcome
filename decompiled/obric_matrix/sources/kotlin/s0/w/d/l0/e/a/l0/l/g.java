package kotlin.s0.w.d.l0.e.a.l0.l;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.q1.d0;
import kotlin.s0.w.d.l0.c.q1.l0;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.v0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.e.a.a0;
import kotlin.s0.w.d.l0.e.a.g0;
import kotlin.s0.w.d.l0.e.a.h0;
import kotlin.s0.w.d.l0.e.a.i0;
import kotlin.s0.w.d.l0.e.a.n0.n;
import kotlin.s0.w.d.l0.e.a.n0.w;
import kotlin.s0.w.d.l0.e.a.n0.x;
import kotlin.s0.w.d.l0.e.a.s;
import kotlin.s0.w.d.l0.e.a.z;
import kotlin.s0.w.d.l0.e.b.v;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends kotlin.s0.w.d.l0.e.a.l0.l.j {
    private final kotlin.s0.w.d.l0.c.e n;
    private final kotlin.s0.w.d.l0.e.a.n0.g o;
    private final boolean p;
    private final kotlin.s0.w.d.l0.m.i<List<kotlin.s0.w.d.l0.c.d>> q;
    private final kotlin.s0.w.d.l0.m.i<Set<kotlin.s0.w.d.l0.g.f>> r;
    private final kotlin.s0.w.d.l0.m.i<Map<kotlin.s0.w.d.l0.g.f, n>> s;
    private final kotlin.s0.w.d.l0.m.h<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.c.q1.g> t;

    static final class a extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.e.a.n0.q, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19418f = null;

        static {
            f19418f = new a();
        }

        a() {
            super(1);
        }

        public final Boolean a(kotlin.s0.w.d.l0.e.a.n0.q r1) {
            o.f(r1, "it");
            return Boolean.valueOf(!r1.Q());
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.e.a.n0.q r1) {
            return a(r1);
        }
    }

    /* synthetic */ class b extends kotlin.n0.d.l implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Collection<? extends z0>> {
        b(Object r2) {
            super(1, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(g.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Collection<? extends z0> invoke(kotlin.s0.w.d.l0.g.f r1) {
            return m(r1);
        }

        public final Collection<z0> m(kotlin.s0.w.d.l0.g.f r2) {
            o.f(r2, "p0");
            return g.S((g) this.receiver, r2);
        }
    }

    /* synthetic */ class c extends kotlin.n0.d.l implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Collection<? extends z0>> {
        c(Object r2) {
            super(1, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(g.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Collection<? extends z0> invoke(kotlin.s0.w.d.l0.g.f r1) {
            return m(r1);
        }

        public final Collection<z0> m(kotlin.s0.w.d.l0.g.f r2) {
            o.f(r2, "p0");
            return g.T((g) this.receiver, r2);
        }
    }

    static final class d extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Collection<? extends z0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f19419f;

        d(g r1) {
            this.f19419f = r1;
            super(1);
        }

        public final Collection<z0> a(kotlin.s0.w.d.l0.g.f r2) {
            o.f(r2, "it");
            return g.S(this.f19419f, r2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Collection<? extends z0> invoke(kotlin.s0.w.d.l0.g.f r1) {
            return a(r1);
        }
    }

    static final class e extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Collection<? extends z0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f19420f;

        e(g r1) {
            this.f19420f = r1;
            super(1);
        }

        public final Collection<z0> a(kotlin.s0.w.d.l0.g.f r2) {
            o.f(r2, "it");
            return g.T(this.f19420f, r2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Collection<? extends z0> invoke(kotlin.s0.w.d.l0.g.f r1) {
            return a(r1);
        }
    }

    static final class f extends q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.l0.c.d>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f19421f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.g f19422g;

        f(g r1, kotlin.s0.w.d.l0.e.a.l0.g r2) {
            this.f19421f = r1;
            this.f19422g = r2;
            super(0);
        }

        public final List<kotlin.s0.w.d.l0.c.d> a() {
            Collection<kotlin.s0.w.d.l0.e.a.n0.k> r0 = g.P(this.f19421f).m();
            ArrayList r1 = new ArrayList(r0.size());
            Iterator<kotlin.s0.w.d.l0.e.a.n0.k> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L7;
            r1.add(g.R(this.f19421f, r2.next()));
            goto L4
        L7:
            if (g.P(this.f19421f).s() == false) goto L18;
            kotlin.s0.w.d.l0.c.d r3 = g.N(this.f19421f);
            boolean r4 = false;
            String r5 = v.c(r3, false, false, 2, null);
            if (r1.isEmpty() == false) goto L11;
        L10:
            r4 = true;
        L16:
            if (r4 == false) goto L18;
            r1.add(r3);
            this.f19422g.a().h().b(g.P(this.f19421f), r3);
            goto L18
        L11:
            Iterator r6 = r1.iterator();
        L13:
            if (r6.hasNext() == false) goto L10;
            if (o.a(v.c((kotlin.s0.w.d.l0.c.d) r6.next(), false, false, 2, null), r5) == false) goto L13;
        L18:
            this.f19422g.a().w().c(this.f19421f.y0(), r1);
            kotlin.s0.w.d.l0.e.a.o0.l r7 = this.f19422g.a().r();
            kotlin.s0.w.d.l0.e.a.l0.g r8 = this.f19422g;
            g r9 = this.f19421f;
            boolean r10 = r1.isEmpty();
            List r11 = r1;
            if (r10 == false) goto L22;
            r11 = r.k(g.M(r9));
        L22:
            return r.z0(r7.g(r8, r11));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.l0.c.d> invoke() {
            return a();
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.l0.l.g$g, reason: collision with other inner class name */
    static final class C0514g extends q implements kotlin.n0.c.a<Map<kotlin.s0.w.d.l0.g.f, ? extends n>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f19423f;

        C0514g(g r1) {
            this.f19423f = r1;
            super(0);
        }

        public final Map<kotlin.s0.w.d.l0.g.f, n> a() {
            Collection<n> r3 = g.P(this.f19423f).C();
            ArrayList r0 = new ArrayList();
            Iterator<T> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L8;
            Object r1 = r4.next();
            if (((n) r1).G() == false) goto L4;
            r0.add(r1);
            goto L4
        L8:
            LinkedHashMap r2 = new LinkedHashMap(kotlin.r0.e.c(m0.d(r.q(r0, 10)), 16));
            Iterator r5 = r0.iterator();
        L10:
            if (r5.hasNext() == false) goto L12;
            Object r6 = r5.next();
            r2.put(((n) r6).getName(), r6);
            goto L10
        L12:
            return r2;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Map<kotlin.s0.w.d.l0.g.f, ? extends n> invoke() {
            return a();
        }
    }

    static final class h extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Collection<? extends z0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ z0 f19424f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f19425g;

        h(z0 r1, g r2) {
            this.f19424f = r1;
            this.f19425g = r2;
            super(1);
        }

        public final Collection<z0> a(kotlin.s0.w.d.l0.g.f r2) {
            o.f(r2, "accessorName");
            if (o.a(this.f19424f.getName(), r2) == false) goto L6;
            return r.d(this.f19424f);
        L6:
            return r.k0(g.S(this.f19425g, r2), g.T(this.f19425g, r2));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Collection<? extends z0> invoke(kotlin.s0.w.d.l0.g.f r1) {
            return a(r1);
        }
    }

    static final class i extends q implements kotlin.n0.c.a<Set<? extends kotlin.s0.w.d.l0.g.f>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f19426f;

        i(g r1) {
            this.f19426f = r1;
            super(0);
        }

        public final Set<kotlin.s0.w.d.l0.g.f> a() {
            return r.D0(g.P(this.f19426f).K());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Set<? extends kotlin.s0.w.d.l0.g.f> invoke() {
            return a();
        }
    }

    static final class j extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.c.q1.g> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f19427f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.g f19428g;

        static final class a extends q implements kotlin.n0.c.a<Set<? extends kotlin.s0.w.d.l0.g.f>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f19429f;

            a(g r1) {
                this.f19429f = r1;
                super(0);
            }

            public final Set<kotlin.s0.w.d.l0.g.f> a() {
                return t0.h(this.f19429f.b(), this.f19429f.d());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Set<? extends kotlin.s0.w.d.l0.g.f> invoke() {
                return a();
            }
        }

        j(g r1, kotlin.s0.w.d.l0.e.a.l0.g r2) {
            this.f19427f = r1;
            this.f19428g = r2;
            super(1);
        }

        public final kotlin.s0.w.d.l0.c.q1.g a(kotlin.s0.w.d.l0.g.f r19) {
            o.f(r19, "name");
            if (((Set) g.Q(this.f19427f).invoke()).contains(r19) == true) goto L7;
            n r1 = (n) ((Map) g.O(this.f19427f).invoke()).get(r19);
            if (r1 == null) goto L11;
            kotlin.s0.w.d.l0.m.i r3 = this.f19428g.e().d(new a(this.f19427f));
            return kotlin.s0.w.d.l0.c.q1.n.M0(this.f19428g.e(), this.f19427f.y0(), r19, r3, kotlin.s0.w.d.l0.e.a.l0.e.a(this.f19428g, r1), this.f19428g.a().t().a(r1));
        L11:
            return null;
        L7:
            kotlin.s0.w.d.l0.e.a.o r2 = this.f19428g.a().d();
            kotlin.s0.w.d.l0.g.b r4 = kotlin.s0.w.d.l0.k.t.a.g(this.f19427f.y0());
            o.c(r4);
            kotlin.s0.w.d.l0.g.b r5 = r4.d(r19);
            o.e(r5, "ownerDescriptor.classId!…createNestedClassId(name)");
            kotlin.s0.w.d.l0.e.a.n0.g r14 = r2.a(new kotlin.s0.w.d.l0.e.a.o.b(r5, null, g.P(this.f19427f), 2, null));
            if (r14 == null) goto L13;
            kotlin.s0.w.d.l0.e.a.l0.g r6 = this.f19428g;
            kotlin.s0.w.d.l0.e.a.l0.l.f r7 = new kotlin.s0.w.d.l0.e.a.l0.l.f(r6, this.f19427f.y0(), r14, null, 8, null);
            r6.a().e().a(r7);
            return r7;
        L13:
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.q1.g invoke(kotlin.s0.w.d.l0.g.f r1) {
            return a(r1);
        }
    }

    public g(kotlin.s0.w.d.l0.e.a.l0.g r2, kotlin.s0.w.d.l0.c.e r3, kotlin.s0.w.d.l0.e.a.n0.g r4, boolean r5, g r6) {
        o.f(r2, "c");
        o.f(r3, "ownerDescriptor");
        o.f(r4, "jClass");
        super(r2, r6);
        this.n = r3;
        this.o = r4;
        this.p = r5;
        this.q = r2.e().d(new f(this, r2));
        this.r = r2.e().d(new i(this));
        this.s = r2.e().d(new C0514g(this));
        this.t = r2.e().i(new j(this, r2));
    }

    public /* synthetic */ g(kotlin.s0.w.d.l0.e.a.l0.g r7, kotlin.s0.w.d.l0.c.e r8, kotlin.s0.w.d.l0.e.a.n0.g r9, boolean r10, g r11, int r12, kotlin.n0.d.g r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    private final boolean A0(z0 r7, y r8) {
        String r3 = v.c(r7, false, false, 2, null);
        y r4 = r8.a();
        o.e(r4, "builtinWithErasedParameters.original");
        if (o.a(r3, v.c(r4, false, false, 2, null)) == true) goto L5;
        return false;
    L5:
        if (o0(r7, r8) == true) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean B0(z0 r7) {
        kotlin.s0.w.d.l0.g.f r0 = r7.getName();
        o.e(r0, "function.name");
        List<kotlin.s0.w.d.l0.g.f> r1 = kotlin.s0.w.d.l0.e.a.e0.a(r0);
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L6;
        Set<u0> r3 = z0((kotlin.s0.w.d.l0.g.f) r2.next());
        if ((r3 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L14;
        u0 r5 = (u0) r4.next();
        if (n0(r5, new h(r7, this)) == true) goto L21;
    L25:
        boolean r6 = false;
    L26:
        if (r6 == false) goto L17;
        boolean r8 = true;
    L28:
        if (r8 == false) goto L9;
        boolean r9 = true;
    L30:
        if (r9 == false) goto L33;
        return false;
    L33:
        if (p0(r7) == true) goto L40;
        if (K0(r7) == true) goto L40;
        if (r0(r7) == true) goto L40;
        return true;
    L40:
        return false;
    L21:
        if (r5.j0() == true) goto L24;
        String r10 = r7.getName().b();
        o.e(r10, "function.name.asString()");
        if (z.d(r10) == true) goto L25;
    L24:
        r6 = true;
    L14:
        r8 = false;
        goto L28
    L13:
        if (r3.isEmpty() == false) goto L15;
    L6:
        r9 = false;
        goto L30
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L6
    }

    private final z0 C0(z0 r3, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends z0>> r4, Collection<? extends z0> r5) {
        y r6 = kotlin.s0.w.d.l0.e.a.f.k(r3);
        if (r6 != null) goto L5;
        return null;
    L5:
        z0 r7 = g0(r6, r4);
        if (r7 != null) goto L8;
        return null;
    L8:
        if (B0(r7) == true) goto L11;
        r7 = null;
    L11:
        if (r7 != null) goto L13;
        return null;
    L13:
        return f0(r7, r6, r5);
    }

    private final z0 D0(z0 r4, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends z0>> r5, kotlin.s0.w.d.l0.g.f r6, Collection<? extends z0> r7) {
        z0 r8 = (z0) g0.d(r4);
        if (r8 != null) goto L5;
        return null;
    L5:
        String r1 = g0.b(r8);
        o.c(r1);
        kotlin.s0.w.d.l0.g.f r2 = kotlin.s0.w.d.l0.g.f.k(r1);
        o.e(r2, "identifier(nameInJava)");
        Iterator<? extends z0> r9 = r5.invoke(r2).iterator();
    L7:
        if (r9.hasNext() == false) goto L12;
        z0 r3 = l0(r9.next(), r6);
        if (q0(r8, r3) == false) goto L7;
        return f0(r3, r8, r7);
    L12:
        return null;
    }

    private final z0 E0(z0 r4, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends z0>> r5) {
        if (r4.isSuspend() == true) goto L5;
        return null;
    L5:
        kotlin.s0.w.d.l0.g.f r0 = r4.getName();
        o.e(r0, "descriptor.name");
        Iterator<T> r6 = r5.invoke(r0).iterator();
    L7:
        if (r6.hasNext() == false) goto L22;
        z0 r1 = m0((z0) r6.next());
        if (r1 != null) goto L11;
    L13:
        r1 = null;
    L14:
        if (r1 == null) goto L7;
        return r1;
    L11:
        if (o0(r1, r4) == false) goto L13;
    L22:
        return null;
    }

    private final kotlin.s0.w.d.l0.e.a.k0.b G0(kotlin.s0.w.d.l0.e.a.n0.k r10) {
        kotlin.s0.w.d.l0.c.e r0 = y0();
        kotlin.s0.w.d.l0.e.a.k0.b r1 = kotlin.s0.w.d.l0.e.a.k0.b.u1(r0, kotlin.s0.w.d.l0.e.a.l0.e.a(w(), r10), false, w().a().t().a(r10));
        o.e(r1, "createJavaConstructor(\n …ce(constructor)\n        )");
        kotlin.s0.w.d.l0.e.a.l0.g r2 = kotlin.s0.w.d.l0.e.a.l0.a.e(w(), r1, r10, r0.u().size());
        kotlin.s0.w.d.l0.e.a.l0.l.j.b r9 = K(r2, r1, r10.h());
        List<f1> r4 = r0.u();
        o.e(r4, "classDescriptor.declaredTypeParameters");
        List<kotlin.s0.w.d.l0.e.a.n0.y> r5 = r10.getTypeParameters();
        ArrayList r6 = new ArrayList(r.q(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        kotlin.s0.w.d.l0.e.a.n0.y r8 = (kotlin.s0.w.d.l0.e.a.n0.y) r7.next();
        f1 r11 = r2.f().a(r8);
        o.c(r11);
        r6.add(r11);
        goto L4
    L6:
        List<f1> r12 = r.k0(r4, r6);
        r1.s1(r9.a(), i0.c(r10.getVisibility()), r12);
        r1.Z0(false);
        r1.a1(r9.b());
        r1.h1(r0.s());
        r2.a().h().b(r10, r1);
        return r1;
    }

    private final kotlin.s0.w.d.l0.e.a.k0.e H0(w r17) {
        kotlin.s0.w.d.l0.c.o1.g r1 = kotlin.s0.w.d.l0.e.a.l0.e.a(w(), r17);
        kotlin.s0.w.d.l0.e.a.k0.e r2 = kotlin.s0.w.d.l0.e.a.k0.e.q1(y0(), r1, r17.getName(), w().a().t().a(r17), true);
        o.e(r2, "createJavaMethod(\n      …omponent), true\n        )");
        kotlin.s0.w.d.l0.e.a.l0.m.a r3 = kotlin.s0.w.d.l0.e.a.l0.m.d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, false, null, 2, null);
        kotlin.s0.w.d.l0.n.e0 r12 = w().g().o(r17.b(), r3);
        r2.p1(null, z(), r.g(), r.g(), r.g(), r12, kotlin.s0.w.d.l0.c.e0.f18859f.a(false, false, true), t.f19163e, null);
        r2.t1(false, false);
        w().a().h().e(r17, r2);
        return r2;
    }

    private final Collection<z0> I0(kotlin.s0.w.d.l0.g.f r3) {
        Collection<kotlin.s0.w.d.l0.e.a.n0.r> r4 = y().invoke().f(r3);
        ArrayList r0 = new ArrayList(r.q(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(I((kotlin.s0.w.d.l0.e.a.n0.r) r5.next()));
        goto L4
    L6:
        return r0;
    }

    private final Collection<z0> J0(kotlin.s0.w.d.l0.g.f r4) {
        Set<z0> r3 = x0(r4);
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Object r0 = r6.next();
        z0 r1 = (z0) r0;
        if (g0.a(r1) == false) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L4;
        r5.add(r0);
        goto L4
    L8:
        if (kotlin.s0.w.d.l0.e.a.f.k(r1) != null) goto L11;
        r2 = false;
        goto L12
    L14:
        return r5;
    }

    private final boolean K0(z0 r5) {
        kotlin.s0.w.d.l0.e.a.f r0 = kotlin.s0.w.d.l0.e.a.f.m;
        kotlin.s0.w.d.l0.g.f r1 = r5.getName();
        o.e(r1, "name");
        if (r0.l(r1) == true) goto L5;
        return false;
    L5:
        kotlin.s0.w.d.l0.g.f r2 = r5.getName();
        o.e(r2, "name");
        Set<z0> r3 = x0(r2);
        ArrayList r4 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L12;
        y r7 = kotlin.s0.w.d.l0.e.a.f.k((z0) r6.next());
        if (r7 == null) goto L7;
        r4.add(r7);
        goto L7
    L12:
        if (r4.isEmpty() == true) goto L29;
        Iterator r8 = r4.iterator();
    L16:
        if (r8.hasNext() == false) goto L30;
        if (A0(r5, (y) r8.next()) == false) goto L16;
        return true;
    L30:
        return false;
    L29:
        return false;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.d M(g r0) {
        return r0.d0();
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.c.d N(g r0) {
        return r0.e0();
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.m.i O(g r0) {
        return r0.s;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.g P(g r0) {
        return r0.o;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.m.i Q(g r0) {
        return r0.r;
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.e.a.k0.b R(g r0, kotlin.s0.w.d.l0.e.a.n0.k r1) {
        return r0.G0(r1);
    }

    public static final /* synthetic */ Collection S(g r0, kotlin.s0.w.d.l0.g.f r1) {
        return r0.I0(r1);
    }

    public static final /* synthetic */ Collection T(g r0, kotlin.s0.w.d.l0.g.f r1) {
        return r0.J0(r1);
    }

    private final void U(List<j1> r14, kotlin.s0.w.d.l0.c.l r15, int r16, kotlin.s0.w.d.l0.e.a.n0.r r17, kotlin.s0.w.d.l0.n.e0 r18, kotlin.s0.w.d.l0.n.e0 r19) {
        kotlin.s0.w.d.l0.c.o1.g r5 = kotlin.s0.w.d.l0.c.o1.g.f18919b.b();
        kotlin.s0.w.d.l0.g.f r6 = r17.getName();
        kotlin.s0.w.d.l0.n.e0 r7 = n1.n(r18);
        o.e(r7, "makeNotNullable(returnType)");
        boolean r8 = r17.L();
        if (r19 == null) goto L5;
        kotlin.s0.w.d.l0.n.e0 r0 = n1.n(r19);
    L6:
        r14.add(new l0(r15, null, r16, r5, r6, r7, r8, false, false, r0, w().a().t().a(r17)));
        return;
    L5:
        r0 = null;
        goto L6
    }

    private final void V(Collection<z0> r7, kotlin.s0.w.d.l0.g.f r8, Collection<? extends z0> r9, boolean r10) {
        Collection<? extends z0> r11 = kotlin.s0.w.d.l0.e.a.j0.a.d(r8, r9, r7, y0(), w().a().c(), w().a().k().a());
        o.e(r11, "resolveOverridesForNonSt….overridingUtil\n        )");
        if (r10 == true) goto L5;
        r7.addAll(r11);
        return;
    L5:
        List r12 = r.k0(r7, r11);
        ArrayList r13 = new ArrayList(r.q(r11, 10));
        Iterator<T> r14 = r11.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        z0 r0 = (z0) r14.next();
        z0 r1 = (z0) g0.e(r0);
        o.e(r0, "resolvedOverride");
        if (r1 == null) goto L12;
        r0 = f0(r0, r1, r12);
    L12:
        r13.add(r0);
        goto L7
    L13:
        r7.addAll(r13);
    }

    private final void W(kotlin.s0.w.d.l0.g.f r3, Collection<? extends z0> r4, Collection<? extends z0> r5, Collection<z0> r6, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends z0>> r7) {
        Iterator<? extends z0> r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        z0 r0 = r8.next();
        kotlin.s0.w.d.l0.p.a.a(r6, D0(r0, r7, r3, r4));
        kotlin.s0.w.d.l0.p.a.a(r6, C0(r0, r7, r4));
        kotlin.s0.w.d.l0.p.a.a(r6, E0(r0, r7));
        goto L4
    }

    private final void X(Set<? extends u0> r3, Collection<u0> r4, Set<u0> r5, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends z0>> r6) {
        Iterator<? extends u0> r7 = r3.iterator();
    L4:
        if (r7.hasNext() == false) goto L15;
        u0 r0 = r7.next();
        kotlin.s0.w.d.l0.e.a.k0.f r1 = h0(r0, r6);
        if (r1 == null) goto L4;
        r4.add(r1);
        if (r5 == null) goto L14;
        r5.add(r0);
        return;
    L14:
        return;
    }

    private final void Y(kotlin.s0.w.d.l0.g.f r7, Collection<u0> r8) {
        kotlin.s0.w.d.l0.e.a.n0.r r1 = (kotlin.s0.w.d.l0.e.a.n0.r) r.p0(y().invoke().f(r7));
        if (r1 != null) goto L5;
        return;
    L5:
        r8.add(j0(this, r1, null, kotlin.s0.w.d.l0.c.e0.f18860g, 2, null));
    }

    private final Collection<kotlin.s0.w.d.l0.n.e0> b0() {
        if (this.p == false) goto L7;
        Collection<kotlin.s0.w.d.l0.n.e0> r1 = y0().k().a();
        o.e(r1, "ownerDescriptor.typeConstructor.supertypes");
        return r1;
    L7:
        return w().a().k().c().g(y0());
    }

    private final List<j1> c0(kotlin.s0.w.d.l0.c.q1.f r13) {
        Collection<kotlin.s0.w.d.l0.e.a.n0.r> r0 = this.o.M();
        ArrayList r8 = new ArrayList(r0.size());
        int r9 = 1;
        kotlin.s0.w.d.l0.e.a.l0.m.a r10 = kotlin.s0.w.d.l0.e.a.l0.m.d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, true, null, 2, null);
        ArrayList r1 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Object r4 = r2.next();
        if (o.a(((kotlin.s0.w.d.l0.e.a.n0.r) r4).getName(), a0.f19205b) == true) goto L7;
        r3.add(r4);
        goto L4
    L7:
        r1.add(r4);
        goto L4
    L9:
        u r5 = new u(r1, r3);
        List r6 = (List) r5.a();
        List r7 = (List) r5.b();
        r6.size();
        kotlin.s0.w.d.l0.e.a.n0.r r11 = (kotlin.s0.w.d.l0.e.a.n0.r) r.R(r6);
        if (r11 == null) goto L16;
        x r12 = r11.getReturnType();
        if ((r12 instanceof kotlin.s0.w.d.l0.e.a.n0.f) == false) goto L14;
        kotlin.s0.w.d.l0.e.a.n0.f r14 = (kotlin.s0.w.d.l0.e.a.n0.f) r12;
        u r15 = new u(w().g().k(r14, r10, true), w().g().o(r14.n(), r10));
    L15:
        U(r8, r13, 0, r11, (kotlin.s0.w.d.l0.n.e0) r15.a(), (kotlin.s0.w.d.l0.n.e0) r15.b());
        goto L16
    L14:
        r15 = new u(w().g().o(r12, r10), null);
    L16:
        int r16 = 0;
        if (r11 != null) goto L20;
        r9 = 0;
    L20:
        Iterator r17 = r7.iterator();
    L22:
        if (r17.hasNext() == false) goto L24;
        kotlin.s0.w.d.l0.e.a.n0.r r18 = (kotlin.s0.w.d.l0.e.a.n0.r) r17.next();
        U(r8, r13, r16 + r9, r18, w().g().o(r18.getReturnType(), r10), null);
        r16 = r16 + 1;
        goto L22
    L24:
        return r8;
    }

    private final kotlin.s0.w.d.l0.c.d d0() {
        boolean r0 = this.o.q();
        if (this.o.H() == false) goto L5;
    L6:
        if (r0 == true) goto L9;
        return null;
    L9:
        kotlin.s0.w.d.l0.c.e r1 = y0();
        kotlin.s0.w.d.l0.e.a.k0.b r2 = kotlin.s0.w.d.l0.e.a.k0.b.u1(r1, kotlin.s0.w.d.l0.c.o1.g.f18919b.b(), true, w().a().t().a(this.o));
        o.e(r2, "createJavaConstructor(\n ….source(jClass)\n        )");
        if (r0 == false) goto L12;
        List<j1> r3 = c0(r2);
    L13:
        r2.a1(false);
        r2.r1(r3, v0(r1));
        r2.Z0(true);
        r2.h1(r1.s());
        w().a().h().b(this.o, r2);
        return r2;
    L12:
        r3 = Collections.emptyList();
        goto L13
    L5:
        if (this.o.t() == true) goto L9;
        goto L6
    }

    private final kotlin.s0.w.d.l0.c.d e0() {
        kotlin.s0.w.d.l0.c.e r0 = y0();
        kotlin.s0.w.d.l0.e.a.k0.b r1 = kotlin.s0.w.d.l0.e.a.k0.b.u1(r0, kotlin.s0.w.d.l0.c.o1.g.f18919b.b(), true, w().a().t().a(this.o));
        o.e(r1, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<j1> r2 = k0(r1);
        r1.a1(false);
        r1.r1(r2, v0(r0));
        r1.Z0(false);
        r1.h1(r0.s());
        return r1;
    }

    private final z0 f0(z0 r5, kotlin.s0.w.d.l0.c.a r6, Collection<? extends z0> r7) {
        boolean r1 = false;
        if ((r7 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L6;
        z0 r0 = (z0) r8.next();
        if (o.a(r5, r0) == false) goto L13;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L9;
    L19:
        if (r1 == true) goto L28;
        y r4 = r5.t().p().build();
        o.c(r4);
        return (z0) r4;
    L28:
        return r5;
    L13:
        if (r0.d0() != null) goto L17;
        if (o0(r0, r6) == false) goto L17;
        r2 = true;
    L6:
        r1 = true;
        goto L19
    L5:
        if (r7.isEmpty() == false) goto L7;
        goto L6
    }

    private final z0 g0(y r4, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends z0>> r5) {
        kotlin.s0.w.d.l0.g.f r0 = r4.getName();
        o.e(r0, "overridden.name");
        Iterator<T> r6 = r5.invoke(r0).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r1 = r6.next();
        if (A0((z0) r1, r4) == false) goto L4;
    L9:
        z0 r2 = (z0) r1;
        if (r2 == null) goto L21;
        y.a<? extends z0> r3 = r2.t();
        List<j1> r7 = r4.h();
        o.e(r7, "overridden.valueParameters");
        ArrayList r8 = new ArrayList(r.q(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        r8.add(((j1) r9.next()).b());
        goto L13
    L15:
        List<j1> r10 = r2.h();
        o.e(r10, "override.valueParameters");
        r3.b(kotlin.s0.w.d.l0.e.a.k0.h.a(r8, r10, r4));
        r3.t();
        r3.e();
        r3.m(kotlin.s0.w.d.l0.e.a.k0.e.M, Boolean.TRUE);
        return (z0) r3.build();
    L21:
        return null;
    L8:
        r1 = null;
        goto L9
    }

    private final kotlin.s0.w.d.l0.e.a.k0.f h0(u0 r13, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends z0>> r14) {
        kotlin.s0.w.d.l0.c.q1.e0 r1 = null;
        if (n0(r13, r14) == true) goto L5;
        return null;
    L5:
        z0 r0 = t0(r13, r14);
        o.c(r0);
        if (r13.j0() == false) goto L8;
        z0 r15 = u0(r13, r14);
        o.c(r15);
    L9:
        if (r15 == null) goto L11;
        r15.l();
        r0.l();
    L11:
        kotlin.s0.w.d.l0.e.a.k0.d r2 = new kotlin.s0.w.d.l0.e.a.k0.d(y0(), r0, r15, r13);
        kotlin.s0.w.d.l0.n.e0 r5 = r0.getReturnType();
        o.c(r5);
        r2.c1(r5, r.g(), z(), null, r.g());
        d0 r12 = kotlin.s0.w.d.l0.k.c.j(r2, r0.getAnnotations(), false, false, false, r0.getSource());
        r12.O0(r0);
        r12.R0(r2.b());
        o.e(r12, "createGetter(\n          …escriptor.type)\n        }");
        if (r15 == null) goto L18;
        List<j1> r16 = r15.h();
        o.e(r16, "setterMethod.valueParameters");
        j1 r17 = (j1) r.R(r16);
        if (r17 == null) goto L17;
        r1 = kotlin.s0.w.d.l0.k.c.l(r2, r15.getAnnotations(), r17.getAnnotations(), false, false, false, r15.getVisibility(), r15.getSource());
        r1.O0(r15);
        goto L18
    L17:
        throw new AssertionError("No parameter found for " + r15);
    L18:
        r2.V0(r12, r1);
        return r2;
    L8:
        r15 = null;
        goto L9
    }

    private final kotlin.s0.w.d.l0.e.a.k0.f i0(kotlin.s0.w.d.l0.e.a.n0.r r16, kotlin.s0.w.d.l0.n.e0 r17, kotlin.s0.w.d.l0.c.e0 r18) {
        kotlin.s0.w.d.l0.c.o1.g r8 = kotlin.s0.w.d.l0.e.a.l0.e.a(w(), r16);
        kotlin.s0.w.d.l0.e.a.k0.f r7 = kotlin.s0.w.d.l0.e.a.k0.f.g1(y0(), r8, r18, i0.c(r16.getVisibility()), false, r16.getName(), w().a().t().a(r16), false);
        o.e(r7, "create(\n            owne…inal = */ false\n        )");
        d0 r9 = kotlin.s0.w.d.l0.k.c.d(r7, kotlin.s0.w.d.l0.c.o1.g.f18919b.b());
        o.e(r9, "createDefaultGetter(prop…iptor, Annotations.EMPTY)");
        r7.V0(r9, null);
        if (r17 != null) goto L5;
        kotlin.s0.w.d.l0.n.e0 r6 = q(r16, kotlin.s0.w.d.l0.e.a.l0.a.f(w(), r7, r16, 0, 4, null));
    L6:
        kotlin.s0.w.d.l0.n.e0 r1 = r6;
        r7.c1(r1, r.g(), z(), null, r.g());
        r9.R0(r6);
        return r7;
    L5:
        r6 = r17;
        goto L6
    }

    static /* synthetic */ kotlin.s0.w.d.l0.e.a.k0.f j0(g r0, kotlin.s0.w.d.l0.e.a.n0.r r1, kotlin.s0.w.d.l0.n.e0 r2, kotlin.s0.w.d.l0.c.e0 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.i0(r1, r2, r3);
    }

    private final List<j1> k0(kotlin.s0.w.d.l0.c.q1.f r20) {
        Collection<w> r1 = this.o.k();
        ArrayList r2 = new ArrayList(r1.size());
        kotlin.s0.w.d.l0.n.e0 r5 = null;
        kotlin.s0.w.d.l0.e.a.l0.m.a r3 = kotlin.s0.w.d.l0.e.a.l0.m.d.d(kotlin.s0.w.d.l0.e.a.j0.k.f19333g, false, null, 2, null);
        Iterator<w> r4 = r1.iterator();
        int r9 = 0;
    L4:
        if (r4.hasNext() == false) goto L10;
        int r6 = r9 + 1;
        w r7 = r4.next();
        kotlin.s0.w.d.l0.n.e0 r12 = w().g().o(r7.b(), r3);
        if (r7.c() == false) goto L8;
        kotlin.s0.w.d.l0.n.e0 r16 = w().a().m().o().k(r12);
    L9:
        r2.add(new l0(r20, null, r9, kotlin.s0.w.d.l0.c.o1.g.f18919b.b(), r7.getName(), r12, false, false, false, r16, w().a().t().a(r7)));
        r9 = r6;
        r5 = null;
        goto L4
    L8:
        r16 = r5;
        goto L9
    L10:
        return r2;
    }

    private final z0 l0(z0 r1, kotlin.s0.w.d.l0.g.f r2) {
        y.a<? extends z0> r0 = r1.t();
        r0.s(r2);
        r0.t();
        r0.e();
        y r3 = r0.build();
        o.c(r3);
        return (z0) r3;
    }

    private final z0 m0(z0 r5) {
        List<j1> r4 = r5.h();
        o.e(r4, "valueParameters");
        j1 r6 = (j1) r.d0(r4);
        if (r6 == null) goto L26;
        kotlin.s0.w.d.l0.c.h r2 = r6.b().O0().d();
        if (r2 == null) goto L14;
        kotlin.s0.w.d.l0.g.d r3 = kotlin.s0.w.d.l0.k.t.a.i(r2);
        if (r3 == null) goto L14;
        if (r3.f() == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L14;
        kotlin.s0.w.d.l0.g.c r7 = r3.l();
    L16:
        if (o.a(r7, kotlin.s0.w.d.l0.b.k.f18710f) == true) goto L19;
        r6 = null;
    L19:
        if (r6 == null) goto L26;
        y.a<? extends z0> r1 = r5.t();
        List<j1> r8 = r5.h();
        o.e(r8, "valueParameters");
        z0 r9 = (z0) r1.b(r.M(r8, 1)).f(r6.b().M0().get(0).b()).build();
        kotlin.s0.w.d.l0.c.q1.g0 r10 = (kotlin.s0.w.d.l0.c.q1.g0) r9;
        if (r10 == null) goto L25;
        r10.i1(true);
    L25:
        return r9;
    L14:
        r7 = null;
    L26:
        return null;
    }

    private final boolean n0(u0 r3, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends z0>> r4) {
        if (kotlin.s0.w.d.l0.e.a.l0.l.c.a(r3) == false) goto L5;
        return false;
    L5:
        z0 r0 = t0(r3, r4);
        z0 r2 = u0(r3, r4);
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r3.j0() == true) goto L11;
        return true;
    L11:
        if (r2 != null) goto L13;
        return false;
    L13:
        if (r2.l() == r0.l()) goto L15;
        return false;
    L15:
        return true;
    }

    private final boolean o0(kotlin.s0.w.d.l0.c.a r3, kotlin.s0.w.d.l0.c.a r4) {
        kotlin.s0.w.d.l0.k.j.i.a r2 = kotlin.s0.w.d.l0.k.j.f20527f.F(r4, r3, true).c();
        o.e(r2, "DEFAULT.isOverridableByW…iptor, this, true).result");
        if (r2 == kotlin.s0.w.d.l0.k.j.i.a.f20542f) goto L5;
    L7:
        return false;
    L5:
        if (s.f19639a.a(r4, r3) == true) goto L7;
        return true;
    }

    private final boolean p0(z0 r7) {
        h0.a r0 = h0.f19266a;
        kotlin.s0.w.d.l0.g.f r1 = r7.getName();
        o.e(r1, "name");
        kotlin.s0.w.d.l0.g.f r2 = r0.b(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        Set<z0> r3 = x0(r2);
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();
        if (g0.a((z0) r6) == false) goto L7;
        r4.add(r6);
        goto L7
    L12:
        if (r4.isEmpty() == false) goto L14;
        return false;
    L14:
        z0 r8 = l0(r7, r2);
        if (r4.isEmpty() == true) goto L32;
        Iterator r9 = r4.iterator();
    L19:
        if (r9.hasNext() == false) goto L33;
        if (q0((z0) r9.next(), r8) == false) goto L19;
        return true;
    L33:
        return false;
    L32:
        return false;
    }

    private final boolean q0(z0 r2, y r3) {
        if (kotlin.s0.w.d.l0.e.a.e.m.k(r2) == false) goto L5;
        r3 = r3.a();
    L5:
        o.e(r3, "if (superDescriptor.isRe…iginal else subDescriptor");
        return o0(r3, r2);
    }

    private final boolean r0(z0 r6) {
        z0 r0 = m0(r6);
        if (r0 != null) goto L5;
        return false;
    L5:
        kotlin.s0.w.d.l0.g.f r7 = r6.getName();
        o.e(r7, "name");
        Set<z0> r8 = x0(r7);
        if ((r8 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L28;
        z0 r2 = (z0) r9.next();
        if (r2.isSuspend() == true) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L12;
        return true;
    L16:
        if (o0(r0, r2) == false) goto L18;
        r3 = true;
        goto L19
    L28:
        return false;
    L8:
        if (r8.isEmpty() == false) goto L10;
        return false;
    }

    private final z0 s0(u0 r4, String r5, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends z0>> r6) {
        kotlin.s0.w.d.l0.g.f r3 = kotlin.s0.w.d.l0.g.f.k(r5);
        o.e(r3, "identifier(getterName)");
        Iterator<T> r7 = r6.invoke(r3).iterator();
    L3:
        z0 r8 = null;
        if (r7.hasNext() == false) goto L15;
        z0 r9 = (z0) r7.next();
        if (r9.h().size() != 0) goto L14;
        kotlin.s0.w.d.l0.n.t1.e r0 = kotlin.s0.w.d.l0.n.t1.e.f21078a;
        kotlin.s0.w.d.l0.n.e0 r1 = r9.getReturnType();
        if (r1 != null) goto L11;
        boolean r2 = false;
    L12:
        if (r2 == false) goto L14;
        r8 = r9;
        goto L14
    L11:
        r2 = r0.d(r1, r4.b());
    L14:
        if (r8 == null) goto L3;
    L15:
        return r8;
    }

    private final z0 t0(u0 r4, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends z0>> r5) {
        v0 r0 = r4.g();
        String r1 = null;
        if (r0 == null) goto L5;
        v0 r2 = (v0) g0.d(r0);
    L6:
        if (r2 == null) goto L8;
        r1 = kotlin.s0.w.d.l0.e.a.i.f19290a.a(r2);
    L8:
        if (r1 != null) goto L10;
    L13:
        String r3 = r4.getName().b();
        o.e(r3, "name.asString()");
        return s0(r4, z.b(r3), r5);
    L10:
        if (g0.f(y0(), r2) == true) goto L13;
        return s0(r4, r1, r5);
    L5:
        r2 = null;
        goto L6
    }

    private final z0 u0(u0 r5, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends z0>> r6) {
        String r4 = r5.getName().b();
        o.e(r4, "name.asString()");
        kotlin.s0.w.d.l0.g.f r7 = kotlin.s0.w.d.l0.g.f.k(z.e(r4));
        o.e(r7, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> r8 = r6.invoke(r7).iterator();
    L3:
        z0 r0 = null;
        if (r8.hasNext() == false) goto L18;
        z0 r9 = (z0) r8.next();
        if (r9.h().size() != 1) goto L17;
        kotlin.s0.w.d.l0.n.e0 r1 = r9.getReturnType();
        if (r1 == null) goto L17;
        if (kotlin.s0.w.d.l0.b.h.B0(r1) == false) goto L17;
        kotlin.s0.w.d.l0.n.t1.e r2 = kotlin.s0.w.d.l0.n.t1.e.f21078a;
        List<j1> r3 = r9.h();
        o.e(r3, "descriptor.valueParameters");
        if (r2.b(((j1) r.o0(r3)).b(), r5.b()) == false) goto L17;
        r0 = r9;
    L17:
        if (r0 == null) goto L3;
    L18:
        return r0;
    }

    private final kotlin.s0.w.d.l0.c.u v0(kotlin.s0.w.d.l0.c.e r1) {
        kotlin.s0.w.d.l0.c.u r0 = r1.getVisibility();
        o.e(r0, "classDescriptor.visibility");
        if (o.a(r0, kotlin.s0.w.d.l0.e.a.r.f19636b) == false) goto L6;
        kotlin.s0.w.d.l0.c.u r2 = kotlin.s0.w.d.l0.e.a.r.f19637c;
        o.e(r2, "PROTECTED_AND_PACKAGE");
        return r2;
    L6:
        return r0;
    }

    private final Set<z0> x0(kotlin.s0.w.d.l0.g.f r4) {
        Collection<kotlin.s0.w.d.l0.n.e0> r3 = b0();
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r.v(r0, ((kotlin.s0.w.d.l0.n.e0) r5.next()).q().a(r4, kotlin.s0.w.d.l0.d.b.d.t));
        goto L4
    L6:
        return r0;
    }

    private final Set<u0> z0(kotlin.s0.w.d.l0.g.f r5) {
        Collection<kotlin.s0.w.d.l0.n.e0> r4 = b0();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Collection<? extends u0> r1 = ((kotlin.s0.w.d.l0.n.e0) r6.next()).q().c(r5, kotlin.s0.w.d.l0.d.b.d.t);
        ArrayList r2 = new ArrayList(r.q(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add((u0) r3.next());
        goto L7
    L9:
        r.v(r0, r2);
        goto L4
    L11:
        return r.D0(r0);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m C() {
        return y0();
    }

    public void F0(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        kotlin.s0.w.d.l0.d.a.a(w().a().l(), r3, y0(), r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected boolean G(kotlin.s0.w.d.l0.e.a.k0.e r2) {
        o.f(r2, "<this>");
        if (this.o.q() == false) goto L7;
        return false;
    L7:
        return B0(r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected kotlin.s0.w.d.l0.e.a.l0.l.j.a H(kotlin.s0.w.d.l0.e.a.n0.r r9, List<? extends f1> r10, kotlin.s0.w.d.l0.n.e0 r11, List<? extends j1> r12) {
        o.f(r9, "method");
        o.f(r10, "methodTypeParameters");
        o.f(r11, "returnType");
        o.f(r12, "valueParameters");
        kotlin.s0.w.d.l0.e.a.j0.j.b r8 = w().a().s().a(r9, y0(), r11, null, r12, r10);
        o.e(r8, "c.components.signaturePr…dTypeParameters\n        )");
        kotlin.s0.w.d.l0.n.e0 r1 = r8.d();
        o.e(r1, "propagated.returnType");
        kotlin.s0.w.d.l0.n.e0 r2 = r8.c();
        List<j1> r3 = r8.f();
        o.e(r3, "propagated.valueParameters");
        List<f1> r4 = r8.e();
        o.e(r4, "propagated.typeParameters");
        boolean r5 = r8.g();
        List<String> r6 = r8.b();
        o.e(r6, "propagated.errors");
        return new kotlin.s0.w.d.l0.e.a.l0.l.j.a(r1, r2, r3, r4, r5, r6);
    }

    protected LinkedHashSet<kotlin.s0.w.d.l0.g.f> Z(kotlin.s0.w.d.l0.k.w.d r4, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r5) {
        o.f(r4, "kindFilter");
        Collection<kotlin.s0.w.d.l0.n.e0> r0 = y0().k().a();
        o.e(r0, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<kotlin.s0.w.d.l0.g.f> r1 = new LinkedHashSet();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r.v(r1, ((kotlin.s0.w.d.l0.n.e0) r2.next()).q().b());
        goto L4
    L6:
        r1.addAll(y().invoke().a());
        r1.addAll(y().invoke().d());
        r1.addAll(l(r4, r5));
        r1.addAll(w().a().w().d(y0()));
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j, kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Collection<z0> a(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        F0(r2, r3);
        return super.a(r2, r3);
    }

    protected kotlin.s0.w.d.l0.e.a.l0.l.a a0() {
        return new kotlin.s0.w.d.l0.e.a.l0.l.a(this.o, a.f19418f);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j, kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Collection<u0> c(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        F0(r2, r3);
        return super.c(r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        F0(r2, r3);
        g r4 = (g) B();
        if (r4 == null) goto L10;
        kotlin.s0.w.d.l0.m.h<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.c.q1.g> r5 = r4.t;
        if (r5 == null) goto L10;
        kotlin.s0.w.d.l0.c.q1.g r6 = r5.invoke(r2);
        if (r6 == null) goto L10;
        return r6;
    L10:
        return this.t.invoke(r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected Set<kotlin.s0.w.d.l0.g.f> l(kotlin.s0.w.d.l0.k.w.d r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2) {
        o.f(r1, "kindFilter");
        return t0.h(this.r.invoke(), this.s.invoke().keySet());
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    public /* bridge */ /* synthetic */ Set n(kotlin.s0.w.d.l0.k.w.d r1, kotlin.n0.c.l r2) {
        return Z(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected void o(Collection<z0> r4, kotlin.s0.w.d.l0.g.f r5) {
        o.f(r4, "result");
        o.f(r5, "name");
        if (this.o.s() == true) goto L5;
    L17:
        w().a().w().b(y0(), r5, r4);
        return;
    L5:
        if (y().invoke().b(r5) == null) goto L17;
        boolean r1 = true;
        if (r4.isEmpty() == true) goto L15;
        Iterator<T> r0 = r4.iterator();
    L11:
        if (r0.hasNext() == false) goto L15;
        if (((z0) r0.next()).h().isEmpty() == false) goto L11;
        r1 = false;
    L15:
        if (r1 == false) goto L17;
        w r2 = y().invoke().b(r5);
        o.c(r2);
        r4.add(H0(r2));
        goto L17
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.l.b p() {
        return a0();
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected void r(Collection<z0> r11, kotlin.s0.w.d.l0.g.f r12) {
        o.f(r11, "result");
        o.f(r12, "name");
        Set<z0> r6 = x0(r12);
        if (h0.f19266a.k(r12) == false) goto L5;
    L26:
        kotlin.s0.w.d.l0.p.f r8 = kotlin.s0.w.d.l0.p.f.f21288h.a();
        Collection<? extends z0> r9 = kotlin.s0.w.d.l0.e.a.j0.a.d(r12, r6, r.g(), y0(), kotlin.s0.w.d.l0.l.b.r.f20858a, w().a().k().a());
        o.e(r9, "resolveOverridesForNonSt….overridingUtil\n        )");
        W(r12, r11, r9, r11, new b(this));
        W(r12, r11, r9, r8, new c(this));
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r6.iterator();
    L28:
        if (r1.hasNext() == false) goto L32;
        Object r2 = r1.next();
        if (B0((z0) r2) == false) goto L28;
        r0.add(r2);
        goto L28
    L32:
        V(r11, r12, r.k0(r0, r8), true);
        return;
    L5:
        if (kotlin.s0.w.d.l0.e.a.f.m.l(r12) == true) goto L26;
        if ((r6 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r3 = r6.iterator();
    L13:
        if (r3.hasNext() == false) goto L10;
        if (((y) r3.next()).isSuspend() == false) goto L13;
        boolean r4 = false;
    L17:
        if (r4 == false) goto L26;
        ArrayList r5 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L20:
        if (r7.hasNext() == false) goto L24;
        Object r10 = r7.next();
        if (B0((z0) r10) == false) goto L20;
        r5.add(r10);
        goto L20
    L24:
        V(r11, r12, r5, false);
        return;
    L10:
        r4 = true;
        goto L17
    L9:
        if (r6.isEmpty() == false) goto L11;
        goto L10
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected void s(kotlin.s0.w.d.l0.g.f r12, Collection<u0> r13) {
        o.f(r12, "name");
        o.f(r13, "result");
        if (this.o.q() == false) goto L5;
        Y(r12, r13);
    L5:
        Set<u0> r0 = z0(r12);
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        kotlin.s0.w.d.l0.p.f.b r1 = kotlin.s0.w.d.l0.p.f.f21288h;
        kotlin.s0.w.d.l0.p.f r2 = r1.a();
        kotlin.s0.w.d.l0.p.f r3 = r1.a();
        X(r0, r13, r2, new d(this));
        X(t0.f(r0, r2), r3, null, new e(this));
        Collection<? extends u0> r11 = kotlin.s0.w.d.l0.e.a.j0.a.d(r12, t0.h(r0, r3), r13, y0(), w().a().c(), w().a().k().a());
        o.e(r11, "resolveOverridesForNonSt…rridingUtil\n            )");
        r13.addAll(r11);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected Set<kotlin.s0.w.d.l0.g.f> t(kotlin.s0.w.d.l0.k.w.d r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2) {
        o.f(r1, "kindFilter");
        if (this.o.q() == true) goto L5;
        LinkedHashSet r3 = new LinkedHashSet(y().invoke().e());
        Collection<kotlin.s0.w.d.l0.n.e0> r0 = y0().k().a();
        o.e(r0, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> r4 = r0.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r.v(r3, ((kotlin.s0.w.d.l0.n.e0) r4.next()).q().d());
        goto L8
    L10:
        return r3;
    L5:
        return b();
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    public String toString() {
        return "Lazy Java member scope for " + this.o.e();
    }

    public final kotlin.s0.w.d.l0.m.i<List<kotlin.s0.w.d.l0.c.d>> w0() {
        return this.q;
    }

    protected kotlin.s0.w.d.l0.c.e y0() {
        return this.n;
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected x0 z() {
        return kotlin.s0.w.d.l0.k.d.l(y0());
    }
}

package kotlin.s0.w.d.l0.l.b.g0;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.i0.t0;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.f.r;
import kotlin.s0.w.d.l0.i.s;
import kotlin.s0.w.d.l0.l.b.w;
import kotlin.s0.w.d.l0.l.b.x;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends kotlin.s0.w.d.l0.k.w.i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l<Object>[] f20763f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.l.b.m f20764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f20765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f20766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.j f20767e;

    private interface a {
        Collection<z0> a(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2);

        Set<kotlin.s0.w.d.l0.g.f> b();

        Collection<u0> c(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2);

        Set<kotlin.s0.w.d.l0.g.f> d();

        Set<kotlin.s0.w.d.l0.g.f> e();

        void f(Collection<kotlin.s0.w.d.l0.c.m> r1, kotlin.s0.w.d.l0.k.w.d r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3, kotlin.s0.w.d.l0.d.b.b r4);

        e1 g(kotlin.s0.w.d.l0.g.f r1);
    }

    private final class b implements a {
        static final /* synthetic */ kotlin.s0.l<Object>[] o = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<kotlin.s0.w.d.l0.f.i> f20768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<kotlin.s0.w.d.l0.f.n> f20769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<r> f20770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i f20771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i f20772e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i f20773f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i f20774g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i f20775h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i f20776i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i f20777j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i f20778k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i f20779l;
        private final kotlin.s0.w.d.l0.m.i m;
        final /* synthetic */ h n;

        static final class a extends q implements kotlin.n0.c.a<List<? extends z0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f20780f;

            a(b r1) {
                this.f20780f = r1;
                super(0);
            }

            public final List<z0> a() {
                return kotlin.i0.r.k0(b.p(this.f20780f), b.h(this.f20780f));
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends z0> invoke() {
                return a();
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.l.b.g0.h$b$b, reason: collision with other inner class name */
        static final class C0570b extends q implements kotlin.n0.c.a<List<? extends u0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f20781f;

            C0570b(b r1) {
                this.f20781f = r1;
                super(0);
            }

            public final List<u0> a() {
                return kotlin.i0.r.k0(b.q(this.f20781f), b.i(this.f20781f));
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends u0> invoke() {
                return a();
            }
        }

        static final class c extends q implements kotlin.n0.c.a<List<? extends e1>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f20782f;

            c(b r1) {
                this.f20782f = r1;
                super(0);
            }

            public final List<e1> a() {
                return b.l(this.f20782f);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends e1> invoke() {
                return a();
            }
        }

        static final class d extends q implements kotlin.n0.c.a<List<? extends z0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f20783f;

            d(b r1) {
                this.f20783f = r1;
                super(0);
            }

            public final List<z0> a() {
                return b.j(this.f20783f);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends z0> invoke() {
                return a();
            }
        }

        static final class e extends q implements kotlin.n0.c.a<List<? extends u0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f20784f;

            e(b r1) {
                this.f20784f = r1;
                super(0);
            }

            public final List<u0> a() {
                return b.k(this.f20784f);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends u0> invoke() {
                return a();
            }
        }

        static final class f extends q implements kotlin.n0.c.a<Set<? extends kotlin.s0.w.d.l0.g.f>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f20785f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f20786g;

            f(b r1, h r2) {
                this.f20785f = r1;
                this.f20786g = r2;
                super(0);
            }

            public final Set<kotlin.s0.w.d.l0.g.f> a() {
                b r0 = this.f20785f;
                List r1 = b.r(r0);
                LinkedHashSet r2 = new LinkedHashSet();
                h r3 = r0.n;
                Iterator r4 = r1.iterator();
            L4:
                if (r4.hasNext() == false) goto L7;
                kotlin.s0.w.d.l0.i.q r5 = (kotlin.s0.w.d.l0.i.q) r4.next();
                r2.add(x.b(r3.p().g(), ((kotlin.s0.w.d.l0.f.i) r5).d0()));
                goto L4
            L7:
                return t0.h(r2, this.f20786g.t());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Set<? extends kotlin.s0.w.d.l0.g.f> invoke() {
                return a();
            }
        }

        static final class g extends q implements kotlin.n0.c.a<Map<kotlin.s0.w.d.l0.g.f, ? extends List<? extends z0>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f20787f;

            g(b r1) {
                this.f20787f = r1;
                super(0);
            }

            public final Map<kotlin.s0.w.d.l0.g.f, List<z0>> a() {
                List r4 = b.m(this.f20787f);
                LinkedHashMap r0 = new LinkedHashMap();
                Iterator r5 = r4.iterator();
            L4:
                if (r5.hasNext() == false) goto L9;
                Object r1 = r5.next();
                kotlin.s0.w.d.l0.g.f r2 = ((z0) r1).getName();
                o.e(r2, "it.name");
                Object r3 = r0.get(r2);
                if (r3 != null) goto L8;
                r3 = new ArrayList();
                r0.put(r2, r3);
            L8:
                ((List) r3).add(r1);
                goto L4
            L9:
                return r0;
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Map<kotlin.s0.w.d.l0.g.f, ? extends List<? extends z0>> invoke() {
                return a();
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.l.b.g0.h$b$h, reason: collision with other inner class name */
        static final class C0571h extends q implements kotlin.n0.c.a<Map<kotlin.s0.w.d.l0.g.f, ? extends List<? extends u0>>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f20788f;

            C0571h(b r1) {
                this.f20788f = r1;
                super(0);
            }

            public final Map<kotlin.s0.w.d.l0.g.f, List<u0>> a() {
                List r4 = b.n(this.f20788f);
                LinkedHashMap r0 = new LinkedHashMap();
                Iterator r5 = r4.iterator();
            L4:
                if (r5.hasNext() == false) goto L9;
                Object r1 = r5.next();
                kotlin.s0.w.d.l0.g.f r2 = ((u0) r1).getName();
                o.e(r2, "it.name");
                Object r3 = r0.get(r2);
                if (r3 != null) goto L8;
                r3 = new ArrayList();
                r0.put(r2, r3);
            L8:
                ((List) r3).add(r1);
                goto L4
            L9:
                return r0;
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Map<kotlin.s0.w.d.l0.g.f, ? extends List<? extends u0>> invoke() {
                return a();
            }
        }

        static final class i extends q implements kotlin.n0.c.a<Map<kotlin.s0.w.d.l0.g.f, ? extends e1>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f20789f;

            i(b r1) {
                this.f20789f = r1;
                super(0);
            }

            public final Map<kotlin.s0.w.d.l0.g.f, e1> a() {
                List r4 = b.o(this.f20789f);
                LinkedHashMap r1 = new LinkedHashMap(kotlin.r0.e.c(m0.d(kotlin.i0.r.q(r4, 10)), 16));
                Iterator r5 = r4.iterator();
            L4:
                if (r5.hasNext() == false) goto L6;
                Object r0 = r5.next();
                kotlin.s0.w.d.l0.g.f r2 = ((e1) r0).getName();
                o.e(r2, "it.name");
                r1.put(r2, r0);
                goto L4
            L6:
                return r1;
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Map<kotlin.s0.w.d.l0.g.f, ? extends e1> invoke() {
                return a();
            }
        }

        static final class j extends q implements kotlin.n0.c.a<Set<? extends kotlin.s0.w.d.l0.g.f>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f20790f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f20791g;

            j(b r1, h r2) {
                this.f20790f = r1;
                this.f20791g = r2;
                super(0);
            }

            public final Set<kotlin.s0.w.d.l0.g.f> a() {
                b r0 = this.f20790f;
                List r1 = b.s(r0);
                LinkedHashSet r2 = new LinkedHashSet();
                h r3 = r0.n;
                Iterator r4 = r1.iterator();
            L4:
                if (r4.hasNext() == false) goto L7;
                kotlin.s0.w.d.l0.i.q r5 = (kotlin.s0.w.d.l0.i.q) r4.next();
                r2.add(x.b(r3.p().g(), ((kotlin.s0.w.d.l0.f.n) r5).c0()));
                goto L4
            L7:
                return t0.h(r2, this.f20791g.u());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Set<? extends kotlin.s0.w.d.l0.g.f> invoke() {
                return a();
            }
        }

        static {
            o = new kotlin.s0.l[]{e0.g(new y(e0.b(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), e0.g(new y(e0.b(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), e0.g(new y(e0.b(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), e0.g(new y(e0.b(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), e0.g(new y(e0.b(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), e0.g(new y(e0.b(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), e0.g(new y(e0.b(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), e0.g(new y(e0.b(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), e0.g(new y(e0.b(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), e0.g(new y(e0.b(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public b(h r2, List<kotlin.s0.w.d.l0.f.i> r3, List<kotlin.s0.w.d.l0.f.n> r4, List<r> r5) {
            o.f(r3, "functionList");
            o.f(r4, "propertyList");
            o.f(r5, "typeAliasList");
            this.n = r2;
            this.f20768a = r3;
            this.f20769b = r4;
            if (r2.p().c().g().f() == true) goto L6;
            r5 = kotlin.i0.r.g();
        L6:
            this.f20770c = r5;
            this.f20771d = r2.p().h().d(new d(this));
            this.f20772e = r2.p().h().d(new e(this));
            this.f20773f = r2.p().h().d(new c(this));
            this.f20774g = r2.p().h().d(new a(this));
            this.f20775h = r2.p().h().d(new C0570b(this));
            this.f20776i = r2.p().h().d(new i(this));
            this.f20777j = r2.p().h().d(new g(this));
            this.f20778k = r2.p().h().d(new C0571h(this));
            this.f20779l = r2.p().h().d(new f(this, r2));
            this.m = r2.p().h().d(new j(this, r2));
        }

        private final List<z0> A() {
            return (List) kotlin.s0.w.d.l0.m.m.a(this.f20774g, this, o[3]);
        }

        private final List<u0> B() {
            return (List) kotlin.s0.w.d.l0.m.m.a(this.f20775h, this, o[4]);
        }

        private final List<e1> C() {
            return (List) kotlin.s0.w.d.l0.m.m.a(this.f20773f, this, o[2]);
        }

        private final List<z0> D() {
            return (List) kotlin.s0.w.d.l0.m.m.a(this.f20771d, this, o[0]);
        }

        private final List<u0> E() {
            return (List) kotlin.s0.w.d.l0.m.m.a(this.f20772e, this, o[1]);
        }

        private final Map<kotlin.s0.w.d.l0.g.f, Collection<z0>> F() {
            return (Map) kotlin.s0.w.d.l0.m.m.a(this.f20777j, this, o[6]);
        }

        private final Map<kotlin.s0.w.d.l0.g.f, Collection<u0>> G() {
            return (Map) kotlin.s0.w.d.l0.m.m.a(this.f20778k, this, o[7]);
        }

        private final Map<kotlin.s0.w.d.l0.g.f, e1> H() {
            return (Map) kotlin.s0.w.d.l0.m.m.a(this.f20776i, this, o[5]);
        }

        public static final /* synthetic */ List h(b r0) {
            return r0.t();
        }

        public static final /* synthetic */ List i(b r0) {
            return r0.u();
        }

        public static final /* synthetic */ List j(b r0) {
            return r0.v();
        }

        public static final /* synthetic */ List k(b r0) {
            return r0.y();
        }

        public static final /* synthetic */ List l(b r0) {
            return r0.z();
        }

        public static final /* synthetic */ List m(b r0) {
            return r0.A();
        }

        public static final /* synthetic */ List n(b r0) {
            return r0.B();
        }

        public static final /* synthetic */ List o(b r0) {
            return r0.C();
        }

        public static final /* synthetic */ List p(b r0) {
            return r0.D();
        }

        public static final /* synthetic */ List q(b r0) {
            return r0.E();
        }

        public static final /* synthetic */ List r(b r0) {
            return r0.f20768a;
        }

        public static final /* synthetic */ List s(b r0) {
            return r0.f20769b;
        }

        private final List<z0> t() {
            Set<kotlin.s0.w.d.l0.g.f> r0 = this.n.t();
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            kotlin.i0.r.v(r1, w((kotlin.s0.w.d.l0.g.f) r2.next()));
            goto L4
        L6:
            return r1;
        }

        private final List<u0> u() {
            Set<kotlin.s0.w.d.l0.g.f> r0 = this.n.u();
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            kotlin.i0.r.v(r1, x((kotlin.s0.w.d.l0.g.f) r2.next()));
            goto L4
        L6:
            return r1;
        }

        private final List<z0> v() {
            List<kotlin.s0.w.d.l0.f.i> r0 = this.f20768a;
            h r4 = this.n;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L11;
            kotlin.s0.w.d.l0.i.q r3 = (kotlin.s0.w.d.l0.i.q) r2.next();
            z0 r5 = r4.p().f().j((kotlin.s0.w.d.l0.f.i) r3);
            if (r4.x(r5) == true) goto L9;
            r5 = null;
        L9:
            if (r5 == null) goto L4;
            r1.add(r5);
            goto L4
        L11:
            return r1;
        }

        private final List<z0> w(kotlin.s0.w.d.l0.g.f r5) {
            List<z0> r0 = D();
            h r4 = this.n;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Object r3 = r2.next();
            if (o.a(((kotlin.s0.w.d.l0.c.m) r3).getName(), r5) == false) goto L4;
            r1.add(r3);
            goto L4
        L8:
            int r6 = r1.size();
            r4.k(r5, r1);
            return r1.subList(r6, r1.size());
        }

        private final List<u0> x(kotlin.s0.w.d.l0.g.f r5) {
            List<u0> r0 = E();
            h r4 = this.n;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Object r3 = r2.next();
            if (o.a(((kotlin.s0.w.d.l0.c.m) r3).getName(), r5) == false) goto L4;
            r1.add(r3);
            goto L4
        L8:
            int r6 = r1.size();
            r4.l(r5, r1);
            return r1.subList(r6, r1.size());
        }

        private final List<u0> y() {
            List<kotlin.s0.w.d.l0.f.n> r0 = this.f20769b;
            h r4 = this.n;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            kotlin.s0.w.d.l0.i.q r3 = (kotlin.s0.w.d.l0.i.q) r2.next();
            u0 r5 = r4.p().f().l((kotlin.s0.w.d.l0.f.n) r3);
            if (r5 == null) goto L4;
            r1.add(r5);
            goto L4
        L8:
            return r1;
        }

        private final List<e1> z() {
            List<r> r0 = this.f20770c;
            h r4 = this.n;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            kotlin.s0.w.d.l0.i.q r3 = (kotlin.s0.w.d.l0.i.q) r2.next();
            e1 r5 = r4.p().f().m((r) r3);
            if (r5 == null) goto L4;
            r1.add(r5);
            goto L4
        L8:
            return r1;
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public Collection<z0> a(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
            o.f(r2, "name");
            o.f(r3, LocationMonitorConst.LOCATION);
            if (b().contains(r2) == false) goto L5;
            Collection<z0> r1 = F().get(r2);
            if (r1 == null) goto L9;
            return r1;
        L9:
            return kotlin.i0.r.g();
        L5:
            return kotlin.i0.r.g();
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public Set<kotlin.s0.w.d.l0.g.f> b() {
            return (Set) kotlin.s0.w.d.l0.m.m.a(this.f20779l, this, o[8]);
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public Collection<u0> c(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
            o.f(r2, "name");
            o.f(r3, LocationMonitorConst.LOCATION);
            if (d().contains(r2) == false) goto L5;
            Collection<u0> r1 = G().get(r2);
            if (r1 == null) goto L9;
            return r1;
        L9:
            return kotlin.i0.r.g();
        L5:
            return kotlin.i0.r.g();
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public Set<kotlin.s0.w.d.l0.g.f> d() {
            return (Set) kotlin.s0.w.d.l0.m.m.a(this.m, this, o[9]);
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public Set<kotlin.s0.w.d.l0.g.f> e() {
            List<r> r0 = this.f20770c;
            LinkedHashSet r1 = new LinkedHashSet();
            h r4 = this.n;
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            kotlin.s0.w.d.l0.i.q r3 = (kotlin.s0.w.d.l0.i.q) r2.next();
            r1.add(x.b(r4.p().g(), ((r) r3).W()));
            goto L4
        L6:
            return r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public void f(Collection<kotlin.s0.w.d.l0.c.m> r4, kotlin.s0.w.d.l0.k.w.d r5, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r6, kotlin.s0.w.d.l0.d.b.b r7) {
            o.f(r4, "result");
            o.f(r5, "kindFilter");
            o.f(r6, "nameFilter");
            o.f(r7, LocationMonitorConst.LOCATION);
            if (r5.a(kotlin.s0.w.d.l0.k.w.d.f20623c.i()) == false) goto L11;
            Iterator<T> r8 = B().iterator();
        L6:
            if (r8.hasNext() == false) goto L11;
            Object r1 = r8.next();
            kotlin.s0.w.d.l0.g.f r2 = ((u0) r1).getName();
            o.e(r2, "it.name");
            if (r6.invoke(r2).booleanValue() == false) goto L6;
            r4.add(r1);
        L11:
            if (r5.a(kotlin.s0.w.d.l0.k.w.d.f20623c.d()) == false) goto L18;
            Iterator<T> r3 = A().iterator();
        L14:
            if (r3.hasNext() == false) goto L29;
            Object r9 = r3.next();
            kotlin.s0.w.d.l0.g.f r10 = ((z0) r9).getName();
            o.e(r10, "it.name");
            if (r6.invoke(r10).booleanValue() == false) goto L14;
            r4.add(r9);
            goto L14
        L29:
            return;
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public e1 g(kotlin.s0.w.d.l0.g.f r2) {
            o.f(r2, "name");
            return H().get(r2);
        }
    }

    private final class c implements a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final /* synthetic */ kotlin.s0.l<Object>[] f20792j = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<kotlin.s0.w.d.l0.g.f, byte[]> f20793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<kotlin.s0.w.d.l0.g.f, byte[]> f20794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<kotlin.s0.w.d.l0.g.f, byte[]> f20795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.g<kotlin.s0.w.d.l0.g.f, Collection<z0>> f20796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.g<kotlin.s0.w.d.l0.g.f, Collection<u0>> f20797e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.h<kotlin.s0.w.d.l0.g.f, e1> f20798f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i f20799g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.m.i f20800h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ h f20801i;

        /* JADX INFO: Add missing generic type declarations: [M] */
        static final class a<M> extends q implements kotlin.n0.c.a<M> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ s<M> f20802f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ ByteArrayInputStream f20803g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ h f20804h;

            public a(s<M> r1, ByteArrayInputStream r2, h r3) {
                this.f20802f = r1;
                this.f20803g = r2;
                this.f20804h = r3;
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TM; */
            public final kotlin.s0.w.d.l0.i.q a() {
                return (kotlin.s0.w.d.l0.i.q) this.f20802f.c(this.f20803g, this.f20804h.p().c().j());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Object invoke() {
                return a();
            }
        }

        static final class b extends q implements kotlin.n0.c.a<Set<? extends kotlin.s0.w.d.l0.g.f>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f20805f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f20806g;

            b(c r1, h r2) {
                this.f20805f = r1;
                this.f20806g = r2;
                super(0);
            }

            public final Set<kotlin.s0.w.d.l0.g.f> a() {
                return t0.h(c.k(this.f20805f).keySet(), this.f20806g.t());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Set<? extends kotlin.s0.w.d.l0.g.f> invoke() {
                return a();
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.l.b.g0.h$c$c, reason: collision with other inner class name */
        static final class C0572c extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Collection<? extends z0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f20807f;

            C0572c(c r1) {
                this.f20807f = r1;
                super(1);
            }

            public final Collection<z0> a(kotlin.s0.w.d.l0.g.f r2) {
                o.f(r2, "it");
                return c.h(this.f20807f, r2);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ Collection<? extends z0> invoke(kotlin.s0.w.d.l0.g.f r1) {
                return a(r1);
            }
        }

        static final class d extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, Collection<? extends u0>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f20808f;

            d(c r1) {
                this.f20808f = r1;
                super(1);
            }

            public final Collection<u0> a(kotlin.s0.w.d.l0.g.f r2) {
                o.f(r2, "it");
                return c.i(this.f20808f, r2);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ Collection<? extends u0> invoke(kotlin.s0.w.d.l0.g.f r1) {
                return a(r1);
            }
        }

        static final class e extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, e1> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f20809f;

            e(c r1) {
                this.f20809f = r1;
                super(1);
            }

            public final e1 a(kotlin.s0.w.d.l0.g.f r2) {
                o.f(r2, "it");
                return c.j(this.f20809f, r2);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ e1 invoke(kotlin.s0.w.d.l0.g.f r1) {
                return a(r1);
            }
        }

        static final class f extends q implements kotlin.n0.c.a<Set<? extends kotlin.s0.w.d.l0.g.f>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f20810f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ h f20811g;

            f(c r1, h r2) {
                this.f20810f = r1;
                this.f20811g = r2;
                super(0);
            }

            public final Set<kotlin.s0.w.d.l0.g.f> a() {
                return t0.h(c.l(this.f20810f).keySet(), this.f20811g.u());
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Set<? extends kotlin.s0.w.d.l0.g.f> invoke() {
                return a();
            }
        }

        static {
            f20792j = new kotlin.s0.l[]{e0.g(new y(e0.b(c.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), e0.g(new y(e0.b(c.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        }

        public c(h r5, List<kotlin.s0.w.d.l0.f.i> r6, List<kotlin.s0.w.d.l0.f.n> r7, List<r> r8) {
            o.f(r6, "functionList");
            o.f(r7, "propertyList");
            o.f(r8, "typeAliasList");
            this.f20801i = r5;
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator<T> r9 = r6.iterator();
        L4:
            if (r9.hasNext() == false) goto L9;
            Object r1 = r9.next();
            kotlin.s0.w.d.l0.g.f r2 = x.b(r5.p().g(), ((kotlin.s0.w.d.l0.f.i) ((kotlin.s0.w.d.l0.i.q) r1)).d0());
            Object r3 = r0.get(r2);
            if (r3 != null) goto L8;
            r3 = new ArrayList();
            r0.put(r2, r3);
        L8:
            ((List) r3).add(r1);
            goto L4
        L9:
            this.f20793a = p(r0);
            h r10 = this.f20801i;
            LinkedHashMap r11 = new LinkedHashMap();
            Iterator<T> r12 = r7.iterator();
        L11:
            if (r12.hasNext() == false) goto L16;
            Object r4 = r12.next();
            kotlin.s0.w.d.l0.g.f r13 = x.b(r10.p().g(), ((kotlin.s0.w.d.l0.f.n) ((kotlin.s0.w.d.l0.i.q) r4)).c0());
            Object r14 = r11.get(r13);
            if (r14 != null) goto L15;
            r14 = new ArrayList();
            r11.put(r13, r14);
        L15:
            ((List) r14).add(r4);
            goto L11
        L16:
            this.f20794b = p(r11);
            if (this.f20801i.p().c().g().f() == false) goto L26;
            h r15 = this.f20801i;
            LinkedHashMap r16 = new LinkedHashMap();
            Iterator<T> r17 = r8.iterator();
        L20:
            if (r17.hasNext() == false) goto L25;
            Object r18 = r17.next();
            kotlin.s0.w.d.l0.g.f r19 = x.b(r15.p().g(), ((r) ((kotlin.s0.w.d.l0.i.q) r18)).W());
            Object r20 = r16.get(r19);
            if (r20 != null) goto L24;
            r20 = new ArrayList();
            r16.put(r19, r20);
        L24:
            ((List) r20).add(r18);
            goto L20
        L25:
            Map<kotlin.s0.w.d.l0.g.f, byte[]> r21 = p(r16);
        L27:
            this.f20795c = r21;
            this.f20796d = this.f20801i.p().h().h(new C0572c(this));
            this.f20797e = this.f20801i.p().h().h(new d(this));
            this.f20798f = this.f20801i.p().h().i(new e(this));
            this.f20799g = this.f20801i.p().h().d(new b(this, this.f20801i));
            this.f20800h = this.f20801i.p().h().d(new f(this, this.f20801i));
            return;
        L26:
            r21 = m0.h();
            goto L27
        }

        public static final /* synthetic */ Collection h(c r0, kotlin.s0.w.d.l0.g.f r1) {
            return r0.m(r1);
        }

        public static final /* synthetic */ Collection i(c r0, kotlin.s0.w.d.l0.g.f r1) {
            return r0.n(r1);
        }

        public static final /* synthetic */ e1 j(c r0, kotlin.s0.w.d.l0.g.f r1) {
            return r0.o(r1);
        }

        public static final /* synthetic */ Map k(c r0) {
            return r0.f20793a;
        }

        public static final /* synthetic */ Map l(c r0) {
            return r0.f20794b;
        }

        private final Collection<z0> m(kotlin.s0.w.d.l0.g.f r6) {
            Map<kotlin.s0.w.d.l0.g.f, byte[]> r0 = this.f20793a;
            s<kotlin.s0.w.d.l0.f.i> r1 = kotlin.s0.w.d.l0.f.i.A;
            o.e(r1, "PARSER");
            h r2 = this.f20801i;
            byte[] r3 = r0.get(r6);
            if (r3 == null) goto L7;
            h r5 = this.f20801i;
            List r7 = kotlin.t0.k.z(kotlin.t0.k.i(new a(r1, new ByteArrayInputStream(r3), r5)));
            if (r7 == null) goto L7;
        L8:
            ArrayList r4 = new ArrayList(r7.size());
            Iterator r8 = r7.iterator();
        L10:
            if (r8.hasNext() == false) goto L17;
            kotlin.s0.w.d.l0.f.i r9 = (kotlin.s0.w.d.l0.f.i) r8.next();
            w r10 = r2.p().f();
            o.e(r9, "it");
            z0 r11 = r10.j(r9);
            if (r2.x(r11) == true) goto L15;
            r11 = null;
        L15:
            if (r11 == null) goto L10;
            r4.add(r11);
            goto L10
        L17:
            r2.k(r6, r4);
            return kotlin.s0.w.d.l0.p.a.c(r4);
        L7:
            r7 = kotlin.i0.r.g();
            goto L8
        }

        private final Collection<u0> n(kotlin.s0.w.d.l0.g.f r6) {
            Map<kotlin.s0.w.d.l0.g.f, byte[]> r0 = this.f20794b;
            s<kotlin.s0.w.d.l0.f.n> r1 = kotlin.s0.w.d.l0.f.n.A;
            o.e(r1, "PARSER");
            h r2 = this.f20801i;
            byte[] r3 = r0.get(r6);
            if (r3 == null) goto L7;
            h r5 = this.f20801i;
            List r7 = kotlin.t0.k.z(kotlin.t0.k.i(new a(r1, new ByteArrayInputStream(r3), r5)));
            if (r7 == null) goto L7;
        L8:
            ArrayList r4 = new ArrayList(r7.size());
            Iterator r8 = r7.iterator();
        L10:
            if (r8.hasNext() == false) goto L14;
            kotlin.s0.w.d.l0.f.n r9 = (kotlin.s0.w.d.l0.f.n) r8.next();
            w r10 = r2.p().f();
            o.e(r9, "it");
            u0 r11 = r10.l(r9);
            if (r11 == null) goto L10;
            r4.add(r11);
            goto L10
        L14:
            r2.l(r6, r4);
            return kotlin.s0.w.d.l0.p.a.c(r4);
        L7:
            r7 = kotlin.i0.r.g();
            goto L8
        }

        private final e1 o(kotlin.s0.w.d.l0.g.f r3) {
            byte[] r4 = this.f20795c.get(r3);
            if (r4 != null) goto L5;
            return null;
        L5:
            r r5 = r.n0(new ByteArrayInputStream(r4), this.f20801i.p().c().j());
            if (r5 != null) goto L9;
            return null;
        L9:
            return this.f20801i.p().f().m(r5);
        }

        private final Map<kotlin.s0.w.d.l0.g.f, byte[]> p(Map<kotlin.s0.w.d.l0.g.f, ? extends Collection<? extends kotlin.s0.w.d.l0.i.a>> r6) {
            LinkedHashMap r5 = new LinkedHashMap(m0.d(r6.size()));
            Iterator<T> r7 = r6.entrySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L10;
            Map.Entry r0 = (Map.Entry) r7.next();
            Object r1 = r0.getKey();
            ByteArrayOutputStream r2 = new ByteArrayOutputStream();
            Iterable r3 = (Iterable) r0.getValue();
            ArrayList r4 = new ArrayList(kotlin.i0.r.q(r3, 10));
            Iterator r8 = r3.iterator();
        L7:
            if (r8.hasNext() == false) goto L9;
            ((kotlin.s0.w.d.l0.i.a) r8.next()).g(r2);
            r4.add(f0.f18324a);
            goto L7
        L9:
            r5.put(r1, r2.toByteArray());
            goto L4
        L10:
            return r5;
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public Collection<z0> a(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
            o.f(r2, "name");
            o.f(r3, LocationMonitorConst.LOCATION);
            if (b().contains(r2) == true) goto L7;
            return kotlin.i0.r.g();
        L7:
            return this.f20796d.invoke(r2);
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public Set<kotlin.s0.w.d.l0.g.f> b() {
            return (Set) kotlin.s0.w.d.l0.m.m.a(this.f20799g, this, f20792j[0]);
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public Collection<u0> c(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
            o.f(r2, "name");
            o.f(r3, LocationMonitorConst.LOCATION);
            if (d().contains(r2) == true) goto L7;
            return kotlin.i0.r.g();
        L7:
            return this.f20797e.invoke(r2);
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public Set<kotlin.s0.w.d.l0.g.f> d() {
            return (Set) kotlin.s0.w.d.l0.m.m.a(this.f20800h, this, f20792j[1]);
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public Set<kotlin.s0.w.d.l0.g.f> e() {
            return this.f20795c.keySet();
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public void f(Collection<kotlin.s0.w.d.l0.c.m> r6, kotlin.s0.w.d.l0.k.w.d r7, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r8, kotlin.s0.w.d.l0.d.b.b r9) {
            o.f(r6, "result");
            o.f(r7, "kindFilter");
            o.f(r8, "nameFilter");
            o.f(r9, LocationMonitorConst.LOCATION);
            if (r7.a(kotlin.s0.w.d.l0.k.w.d.f20623c.i()) == false) goto L12;
            Set<kotlin.s0.w.d.l0.g.f> r0 = d();
            ArrayList r2 = new ArrayList();
            Iterator<kotlin.s0.w.d.l0.g.f> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            kotlin.s0.w.d.l0.g.f r3 = r1.next();
            if (r8.invoke(r3).booleanValue() == false) goto L6;
            r2.addAll(c(r3, r9));
            goto L6
        L10:
            kotlin.s0.w.d.l0.k.g r4 = kotlin.s0.w.d.l0.k.g.f20525f;
            o.e(r4, "INSTANCE");
            kotlin.i0.r.u(r2, r4);
            r6.addAll(r2);
        L12:
            if (r7.a(kotlin.s0.w.d.l0.k.w.d.f20623c.d()) == false) goto L31;
            Set<kotlin.s0.w.d.l0.g.f> r10 = b();
            ArrayList r5 = new ArrayList();
            Iterator<kotlin.s0.w.d.l0.g.f> r11 = r10.iterator();
        L15:
            if (r11.hasNext() == false) goto L19;
            kotlin.s0.w.d.l0.g.f r12 = r11.next();
            if (r8.invoke(r12).booleanValue() == false) goto L15;
            r5.addAll(a(r12, r9));
            goto L15
        L19:
            kotlin.s0.w.d.l0.k.g r13 = kotlin.s0.w.d.l0.k.g.f20525f;
            o.e(r13, "INSTANCE");
            kotlin.i0.r.u(r5, r13);
            r6.addAll(r5);
            return;
        }

        @Override // kotlin.s0.w.d.l0.l.b.g0.h.a
        public e1 g(kotlin.s0.w.d.l0.g.f r2) {
            o.f(r2, "name");
            return this.f20798f.invoke(r2);
        }
    }

    static final class d extends q implements kotlin.n0.c.a<Set<? extends kotlin.s0.w.d.l0.g.f>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<Collection<kotlin.s0.w.d.l0.g.f>> f20812f;

        /* JADX WARN: Multi-variable type inference failed */
        d(kotlin.n0.c.a<? extends Collection<kotlin.s0.w.d.l0.g.f>> r1) {
            this.f20812f = r1;
            super(0);
        }

        public final Set<kotlin.s0.w.d.l0.g.f> a() {
            return kotlin.i0.r.D0(this.f20812f.invoke());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Set<? extends kotlin.s0.w.d.l0.g.f> invoke() {
            return a();
        }
    }

    static final class e extends q implements kotlin.n0.c.a<Set<? extends kotlin.s0.w.d.l0.g.f>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f20813f;

        e(h r1) {
            this.f20813f = r1;
            super(0);
        }

        public final Set<kotlin.s0.w.d.l0.g.f> a() {
            Set<kotlin.s0.w.d.l0.g.f> r0 = this.f20813f.s();
            if (r0 != null) goto L7;
            return null;
        L7:
            return t0.h(t0.h(this.f20813f.q(), h.h(this.f20813f).e()), r0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Set<? extends kotlin.s0.w.d.l0.g.f> invoke() {
            return a();
        }
    }

    static {
        f20763f = new kotlin.s0.l[]{e0.g(new y(e0.b(h.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), e0.g(new y(e0.b(h.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    }

    protected h(kotlin.s0.w.d.l0.l.b.m r2, List<kotlin.s0.w.d.l0.f.i> r3, List<kotlin.s0.w.d.l0.f.n> r4, List<r> r5, kotlin.n0.c.a<? extends Collection<kotlin.s0.w.d.l0.g.f>> r6) {
        o.f(r2, "c");
        o.f(r3, "functionList");
        o.f(r4, "propertyList");
        o.f(r5, "typeAliasList");
        o.f(r6, "classNames");
        this.f20764b = r2;
        this.f20765c = n(r3, r4, r5);
        this.f20766d = r2.h().d(new d(r6));
        this.f20767e = r2.h().f(new e(this));
    }

    public static final /* synthetic */ a h(h r0) {
        return r0.f20765c;
    }

    private final a n(List<kotlin.s0.w.d.l0.f.i> r2, List<kotlin.s0.w.d.l0.f.n> r3, List<r> r4) {
        if (this.f20764b.c().g().a() == false) goto L6;
        return new b(this, r2, r3, r4);
    L6:
        return new c(this, r2, r3, r4);
    }

    private final kotlin.s0.w.d.l0.c.e o(kotlin.s0.w.d.l0.g.f r2) {
        return this.f20764b.c().b(m(r2));
    }

    private final Set<kotlin.s0.w.d.l0.g.f> r() {
        return (Set) kotlin.s0.w.d.l0.m.m.b(this.f20767e, this, f20763f[1]);
    }

    private final e1 v(kotlin.s0.w.d.l0.g.f r1) {
        return this.f20765c.g(r1);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Collection<z0> a(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        return this.f20765c.a(r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> b() {
        return this.f20765c.b();
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Collection<u0> c(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        return this.f20765c.c(r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> d() {
        return this.f20765c.d();
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        return r();
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        if (w(r2) == false) goto L6;
        return o(r2);
    L6:
        if (this.f20765c.e().contains(r2) == true) goto L11;
        return null;
    L11:
        return v(r2);
    }

    protected abstract void i(Collection<kotlin.s0.w.d.l0.c.m> r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2);

    protected final Collection<kotlin.s0.w.d.l0.c.m> j(kotlin.s0.w.d.l0.k.w.d r4, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r5, kotlin.s0.w.d.l0.d.b.b r6) {
        o.f(r4, "kindFilter");
        o.f(r5, "nameFilter");
        o.f(r6, LocationMonitorConst.LOCATION);
        ArrayList r0 = new ArrayList(0);
        kotlin.s0.w.d.l0.k.w.d.a r1 = kotlin.s0.w.d.l0.k.w.d.f20623c;
        if (r4.a(r1.g()) == false) goto L5;
        i(r0, r5);
    L5:
        this.f20765c.f(r0, r4, r5, r6);
        if (r4.a(r1.c()) == false) goto L14;
        Iterator<kotlin.s0.w.d.l0.g.f> r7 = q().iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        kotlin.s0.w.d.l0.g.f r2 = r7.next();
        if (r5.invoke(r2).booleanValue() == false) goto L9;
        kotlin.s0.w.d.l0.p.a.a(r0, o(r2));
    L14:
        if (r4.a(kotlin.s0.w.d.l0.k.w.d.f20623c.h()) == false) goto L22;
        Iterator<kotlin.s0.w.d.l0.g.f> r8 = this.f20765c.e().iterator();
    L17:
        if (r8.hasNext() == false) goto L22;
        kotlin.s0.w.d.l0.g.f r9 = r8.next();
        if (r5.invoke(r9).booleanValue() == false) goto L17;
        kotlin.s0.w.d.l0.p.a.a(r0, this.f20765c.g(r9));
    L22:
        return kotlin.s0.w.d.l0.p.a.c(r0);
    }

    protected void k(kotlin.s0.w.d.l0.g.f r1, List<z0> r2) {
        o.f(r1, "name");
        o.f(r2, "functions");
    }

    protected void l(kotlin.s0.w.d.l0.g.f r1, List<u0> r2) {
        o.f(r1, "name");
        o.f(r2, "descriptors");
    }

    protected abstract kotlin.s0.w.d.l0.g.b m(kotlin.s0.w.d.l0.g.f r1);

    protected final kotlin.s0.w.d.l0.l.b.m p() {
        return this.f20764b;
    }

    public final Set<kotlin.s0.w.d.l0.g.f> q() {
        return (Set) kotlin.s0.w.d.l0.m.m.a(this.f20766d, this, f20763f[0]);
    }

    protected abstract Set<kotlin.s0.w.d.l0.g.f> s();

    protected abstract Set<kotlin.s0.w.d.l0.g.f> t();

    protected abstract Set<kotlin.s0.w.d.l0.g.f> u();

    protected boolean w(kotlin.s0.w.d.l0.g.f r2) {
        o.f(r2, "name");
        return q().contains(r2);
    }

    protected boolean x(z0 r1) {
        o.f(r1, "function");
        return true;
    }
}

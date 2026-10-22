package kotlin.s0.w.d.l0.e.a.l0.l;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.e.a.n0.d0;
import kotlin.s0.w.d.l0.e.a.n0.u;
import kotlin.s0.w.d.l0.e.b.p;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends l {
    private final u n;
    private final h o;
    private final kotlin.s0.w.d.l0.m.j<Set<String>> p;
    private final kotlin.s0.w.d.l0.m.h<a, kotlin.s0.w.d.l0.c.e> q;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.g.f f19435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.e.a.n0.g f19436b;

        public a(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.e.a.n0.g r3) {
            o.f(r2, "name");
            this.f19435a = r2;
            this.f19436b = r3;
        }

        public final kotlin.s0.w.d.l0.e.a.n0.g a() {
            return this.f19436b;
        }

        public final kotlin.s0.w.d.l0.g.f b() {
            return this.f19435a;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof a) == true) goto L5;
        L7:
            return false;
        L5:
            if (o.a(this.f19435a, ((a) r2).f19435a) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.f19435a.hashCode();
        }
    }

    private static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final kotlin.s0.w.d.l0.c.e f19437a;

            public a(kotlin.s0.w.d.l0.c.e r2) {
                o.f(r2, "descriptor");
                super(null);
                this.f19437a = r2;
            }

            public final kotlin.s0.w.d.l0.c.e a() {
                return this.f19437a;
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.l0.l.i$b$b, reason: collision with other inner class name */
        public static final class C0515b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0515b f19438a = null;

            static {
                f19438a = new C0515b();
            }

            private C0515b() {
                super(null);
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f19439a = null;

            static {
                f19439a = new c();
            }

            private c() {
                super(null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.n0.d.g r1) {
            this();
        }
    }

    static final class c extends q implements kotlin.n0.c.l<a, kotlin.s0.w.d.l0.c.e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f19440f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.g f19441g;

        c(i r1, kotlin.s0.w.d.l0.e.a.l0.g r2) {
            this.f19440f = r1;
            this.f19441g = r2;
            super(1);
        }

        public final kotlin.s0.w.d.l0.c.e a(a r17) {
            o.f(r17, "request");
            kotlin.s0.w.d.l0.g.b r1 = new kotlin.s0.w.d.l0.g.b(this.f19440f.Q().e(), r17.b());
            if (r17.a() == null) goto L5;
            kotlin.s0.w.d.l0.e.b.o.a r3 = this.f19441g.a().j().a(r17.a());
        L7:
            if (r3 == null) goto L9;
            kotlin.s0.w.d.l0.e.b.q r4 = r3.a();
        L10:
            if (r4 == null) goto L12;
            kotlin.s0.w.d.l0.g.b r5 = r4.f();
        L13:
            if (r5 != null) goto L15;
        L19:
            b r6 = i.M(this.f19440f, r4);
            if ((r6 instanceof b.a) == false) goto L23;
            return ((b.a) r6).a();
        L23:
            if ((r6 instanceof b.c) == false) goto L26;
            return null;
        L26:
            if ((r6 instanceof b.C0515b) == false) goto L59;
            kotlin.s0.w.d.l0.e.a.n0.g r2 = r17.a();
            if (r2 != null) goto L39;
            kotlin.s0.w.d.l0.e.a.o r9 = this.f19441g.a().d();
            if (r3 != null) goto L32;
        L37:
            byte[] r7 = null;
        L38:
            r2 = r9.a(new kotlin.s0.w.d.l0.e.a.o.b(r1, r7, null, 4, null));
            goto L39
        L32:
            if ((r3 instanceof kotlin.s0.w.d.l0.e.b.o.a.C0532a) == true) goto L34;
            r3 = null;
        L34:
            kotlin.s0.w.d.l0.e.b.o.a.C0532a r8 = (kotlin.s0.w.d.l0.e.b.o.a.C0532a) r3;
            if (r8 == null) goto L37;
            r7 = r8.b();
        L39:
            kotlin.s0.w.d.l0.e.a.n0.g r12 = r2;
            if (r12 == null) goto L42;
            d0 r10 = r12.I();
        L44:
            if (r10 == d0.f19528g) goto L57;
            if (r12 == null) goto L47;
            kotlin.s0.w.d.l0.g.c r11 = r12.e();
        L48:
            if (r11 != null) goto L50;
            return null;
        L50:
            if (r11.d() == false) goto L52;
            return null;
        L52:
            if (o.a(r11.e(), this.f19440f.Q().e()) == false) goto L64;
            f r13 = new f(this.f19441g, this.f19440f.Q(), r12, null, 8, null);
            this.f19441g.a().e().a(r13);
            return r13;
        L64:
            return null;
        L47:
            r11 = null;
            goto L48
        L57:
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + r12 + "\nClassId: " + r1 + "\nfindKotlinClass(JavaClass) = " + p.a(this.f19441g.a().j(), r12) + "\nfindKotlinClass(ClassId) = " + p.b(this.f19441g.a().j(), r1) + '\n');
        L42:
            r10 = null;
            goto L44
        L59:
            throw new kotlin.m();
        L15:
            if (r5.l() == false) goto L17;
        L18:
            return null;
        L17:
            if (r5.k() == false) goto L19;
        L12:
            r5 = null;
            goto L13
        L9:
            r4 = null;
            goto L10
        L5:
            r3 = this.f19441g.a().j().c(r1);
            goto L7
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.e invoke(a r1) {
            return a(r1);
        }
    }

    static final class d extends q implements kotlin.n0.c.a<Set<? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.g f19442f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i f19443g;

        d(kotlin.s0.w.d.l0.e.a.l0.g r1, i r2) {
            this.f19442f = r1;
            this.f19443g = r2;
            super(0);
        }

        public final Set<String> a() {
            return this.f19442f.a().d().b(this.f19443g.Q().e());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Set<? extends String> invoke() {
            return a();
        }
    }

    public i(kotlin.s0.w.d.l0.e.a.l0.g r2, u r3, h r4) {
        o.f(r2, "c");
        o.f(r3, "jPackage");
        o.f(r4, "ownerDescriptor");
        super(r2);
        this.n = r3;
        this.o = r4;
        this.p = r2.e().f(new d(r2, this));
        this.q = r2.e().i(new c(this, r2));
    }

    public static final /* synthetic */ b M(i r0, kotlin.s0.w.d.l0.e.b.q r1) {
        return r0.R(r1);
    }

    private final kotlin.s0.w.d.l0.c.e N(kotlin.s0.w.d.l0.g.f r4, kotlin.s0.w.d.l0.e.a.n0.g r5) {
        if (kotlin.s0.w.d.l0.g.h.f20274a.a(r4) == true) goto L5;
        return null;
    L5:
        Set<String> r0 = this.p.invoke();
        if (r5 != null) goto L12;
        if (r0 == null) goto L12;
        if (r0.contains(r4.b()) == true) goto L12;
        return null;
    L12:
        return this.q.invoke(new a(r4, r5));
    }

    private final b R(kotlin.s0.w.d.l0.e.b.q r3) {
        if (r3 != null) goto L5;
    L11:
        return b.C0515b.f19438a;
    L5:
        if (r3.a().c() != kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19734j) goto L10;
        kotlin.s0.w.d.l0.c.e r2 = w().a().b().k(r3);
        if (r2 == null) goto L11;
        return new b.a(r2);
    L10:
        return b.c.f19439a;
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m C() {
        return Q();
    }

    public final kotlin.s0.w.d.l0.c.e O(kotlin.s0.w.d.l0.e.a.n0.g r2) {
        o.f(r2, "javaClass");
        return N(r2.getName(), r2);
    }

    public kotlin.s0.w.d.l0.c.e P(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        return N(r2, null);
    }

    protected h Q() {
        return this.o;
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j, kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Collection<u0> c(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        o.f(r1, "name");
        o.f(r2, LocationMonitorConst.LOCATION);
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.g.f r1, kotlin.s0.w.d.l0.d.b.b r2) {
        return P(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j, kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public Collection<kotlin.s0.w.d.l0.c.m> g(kotlin.s0.w.d.l0.k.w.d r4, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r5) {
        o.f(r4, "kindFilter");
        o.f(r5, "nameFilter");
        kotlin.s0.w.d.l0.k.w.d.a r0 = kotlin.s0.w.d.l0.k.w.d.f20623c;
        int r1 = r0.c();
        if (r4.a(r0.e() | r1) == false) goto L23;
        Collection<kotlin.s0.w.d.l0.c.m> r3 = v().invoke();
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r3.iterator();
    L7:
        if (r7.hasNext() == false) goto L17;
        Object r2 = r7.next();
        kotlin.s0.w.d.l0.c.m r8 = (kotlin.s0.w.d.l0.c.m) r2;
        if ((r8 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L13;
        kotlin.s0.w.d.l0.g.f r9 = ((kotlin.s0.w.d.l0.c.e) r8).getName();
        o.e(r9, "it.name");
        if (r5.invoke(r9).booleanValue() == false) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L7;
        r6.add(r2);
    L13:
        r10 = false;
        goto L14
    L17:
        return r6;
    L23:
        return r.g();
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected Set<kotlin.s0.w.d.l0.g.f> l(kotlin.s0.w.d.l0.k.w.d r3, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r4) {
        o.f(r3, "kindFilter");
        if (r3.a(kotlin.s0.w.d.l0.k.w.d.f20623c.e()) == false) goto L5;
        Set<String> r5 = this.p.invoke();
        if (r5 == null) goto L13;
        HashSet r2 = new HashSet();
        Iterator<T> r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r2.add(kotlin.s0.w.d.l0.g.f.k((String) r6.next()));
        goto L10
    L12:
        return r2;
    L13:
        u r7 = this.n;
        if (r4 != null) goto L16;
        r4 = kotlin.s0.w.d.l0.p.d.a();
    L16:
        Collection<kotlin.s0.w.d.l0.e.a.n0.g> r8 = r7.p(r4);
        LinkedHashSet r9 = new LinkedHashSet();
        Iterator<T> r10 = r8.iterator();
    L18:
        if (r10.hasNext() == false) goto L25;
        kotlin.s0.w.d.l0.e.a.n0.g r11 = (kotlin.s0.w.d.l0.e.a.n0.g) r10.next();
        if (r11.I() != d0.f19527f) goto L22;
        kotlin.s0.w.d.l0.g.f r12 = null;
    L23:
        if (r12 == null) goto L18;
        r9.add(r12);
        goto L18
    L22:
        r12 = r11.getName();
        goto L23
    L25:
        return r9;
    L5:
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected Set<kotlin.s0.w.d.l0.g.f> n(kotlin.s0.w.d.l0.k.w.d r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2) {
        o.f(r1, "kindFilter");
        return t0.b();
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected kotlin.s0.w.d.l0.e.a.l0.l.b p() {
        return kotlin.s0.w.d.l0.e.a.l0.l.b.a.f19393a;
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected void r(Collection<z0> r1, kotlin.s0.w.d.l0.g.f r2) {
        o.f(r1, "result");
        o.f(r2, "name");
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.j
    protected Set<kotlin.s0.w.d.l0.g.f> t(kotlin.s0.w.d.l0.k.w.d r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r2) {
        o.f(r1, "kindFilter");
        return t0.b();
    }
}

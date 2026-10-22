package kotlin.s0.w.d.l0.k.t;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.i0.r;
import kotlin.n0.d.d0;
import kotlin.n0.d.e0;
import kotlin.n0.d.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.f;
import kotlin.s0.w.d.l0.c.h;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.h1;
import kotlin.s0.w.d.l0.c.i;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.t0;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.t1.g;
import kotlin.s0.w.d.l0.n.t1.p;
import kotlin.s0.w.d.l0.n.t1.x;
import kotlin.t0.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.k.t.a$a, reason: collision with other inner class name */
    static final class C0562a<N> implements kotlin.s0.w.d.l0.p.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0562a<N> f20596a = null;

        static {
            f20596a = new C0562a();
        }

        C0562a() {
        }

        @Override // kotlin.s0.w.d.l0.p.b.c
        public /* bridge */ /* synthetic */ Iterable a(Object r1) {
            return b((j1) r1);
        }

        public final Iterable<j1> b(j1 r2) {
            Collection<j1> r1 = r2.f();
            ArrayList r3 = new ArrayList(r.q(r1, 10));
            Iterator<T> r4 = r1.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r3.add(((j1) r4.next()).a());
            goto L4
        L6:
            return r3;
        }
    }

    /* synthetic */ class b extends l implements kotlin.n0.c.l<j1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f20597f = null;

        static {
            f20597f = new b();
        }

        b() {
            super(1);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // kotlin.n0.d.c
        public final f getOwner() {
            return e0.b(j1.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(j1 r1) {
            return m(r1);
        }

        public final Boolean m(j1 r1) {
            o.f(r1, "p0");
            return Boolean.valueOf(r1.u0());
        }
    }

    static final class c<N> implements kotlin.s0.w.d.l0.p.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f20598a;

        c(boolean r1) {
            this.f20598a = r1;
        }

        @Override // kotlin.s0.w.d.l0.p.b.c
        public /* bridge */ /* synthetic */ Iterable a(Object r1) {
            return b((kotlin.s0.w.d.l0.c.b) r1);
        }

        public final Iterable<kotlin.s0.w.d.l0.c.b> b(kotlin.s0.w.d.l0.c.b r2) {
            Collection<? extends kotlin.s0.w.d.l0.c.b> r0 = null;
            if (this.f20598a == false) goto L7;
            if (r2 == null) goto L6;
            r2 = r2.a();
            goto L7
        L6:
            r2 = null;
        L7:
            if (r2 == null) goto L9;
            r0 = r2.f();
        L9:
            if (r0 == null) goto L11;
            return r0;
        L11:
            return r.g();
        }
    }

    public static final class d extends kotlin.s0.w.d.l0.p.b.AbstractC0585b<kotlin.s0.w.d.l0.c.b, kotlin.s0.w.d.l0.c.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d0<kotlin.s0.w.d.l0.c.b> f20599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, Boolean> f20600b;

        /* JADX WARN: Multi-variable type inference failed */
        d(d0<kotlin.s0.w.d.l0.c.b> r1, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.c.b, Boolean> r2) {
            this.f20599a = r1;
            this.f20600b = r2;
        }

        @Override // kotlin.s0.w.d.l0.p.b.d
        public /* bridge */ /* synthetic */ Object a() {
            return f();
        }

        @Override // kotlin.s0.w.d.l0.p.b.AbstractC0585b, kotlin.s0.w.d.l0.p.b.d
        public /* bridge */ /* synthetic */ void b(Object r1) {
            d((kotlin.s0.w.d.l0.c.b) r1);
        }

        @Override // kotlin.s0.w.d.l0.p.b.d
        public /* bridge */ /* synthetic */ boolean c(Object r1) {
            return e((kotlin.s0.w.d.l0.c.b) r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void d(kotlin.s0.w.d.l0.c.b r2) {
            o.f(r2, "current");
            if (this.f20599a.f18431f == null) goto L5;
            return;
        L5:
            if (this.f20600b.invoke(r2).booleanValue() == false) goto L9;
            this.f20599a.f18431f = r2;
            return;
        }

        public boolean e(kotlin.s0.w.d.l0.c.b r2) {
            o.f(r2, "current");
            if (this.f20599a.f18431f != null) goto L5;
            return true;
        L5:
            return false;
        }

        public kotlin.s0.w.d.l0.c.b f() {
            return this.f20599a.f18431f;
        }
    }

    static final class e extends q implements kotlin.n0.c.l<m, m> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f20601f = null;

        static {
            f20601f = new e();
        }

        e() {
            super(1);
        }

        public final m a(m r1) {
            o.f(r1, "it");
            return r1.c();
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ m invoke(m r1) {
            return a(r1);
        }
    }

    static {
        o.e(kotlin.s0.w.d.l0.g.f.k("value"), "identifier(\"value\")");
    }

    public static final boolean a(j1 r2) {
        o.f(r2, "<this>");
        Boolean r3 = kotlin.s0.w.d.l0.p.b.e(r.d(r2), C0562a.f20596a, b.f20597f);
        o.e(r3, "ifAny(\n        listOf(th…eclaresDefaultValue\n    )");
        return r3.booleanValue();
    }

    public static final kotlin.s0.w.d.l0.c.b b(kotlin.s0.w.d.l0.c.b r2, boolean r3, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.c.b, Boolean> r4) {
        o.f(r2, "<this>");
        o.f(r4, "predicate");
        d0 r0 = new d0();
        return (kotlin.s0.w.d.l0.c.b) kotlin.s0.w.d.l0.p.b.b(r.d(r2), new c(r3), new d(r0, r4));
    }

    public static /* synthetic */ kotlin.s0.w.d.l0.c.b c(kotlin.s0.w.d.l0.c.b r0, boolean r1, kotlin.n0.c.l r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return b(r0, r1, r2);
    }

    public static final kotlin.s0.w.d.l0.g.c d(m r2) {
        o.f(r2, "<this>");
        kotlin.s0.w.d.l0.g.d r3 = i(r2);
        if (r3.f() == true) goto L6;
        r3 = null;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.l();
    }

    public static final kotlin.s0.w.d.l0.c.e e(kotlin.s0.w.d.l0.c.o1.c r1) {
        o.f(r1, "<this>");
        h r2 = r1.b().O0().d();
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L7;
        return null;
    L7:
        return (kotlin.s0.w.d.l0.c.e) r2;
    }

    public static final kotlin.s0.w.d.l0.b.h f(m r1) {
        o.f(r1, "<this>");
        return l(r1).o();
    }

    public static final kotlin.s0.w.d.l0.g.b g(h r3) {
        if (r3 == null) goto L15;
        m r1 = r3.c();
        if (r1 != null) goto L7;
        return null;
    L7:
        if ((r1 instanceof l0) == false) goto L10;
        return new kotlin.s0.w.d.l0.g.b(((l0) r1).e(), r3.getName());
    L10:
        if ((r1 instanceof i) == false) goto L18;
        kotlin.s0.w.d.l0.g.b r2 = g((h) r1);
        if (r2 != null) goto L14;
        return null;
    L14:
        return r2.d(r3.getName());
    L18:
        return null;
    L15:
        return null;
    }

    public static final kotlin.s0.w.d.l0.g.c h(m r1) {
        o.f(r1, "<this>");
        kotlin.s0.w.d.l0.g.c r2 = kotlin.s0.w.d.l0.k.d.n(r1);
        o.e(r2, "getFqNameSafe(this)");
        return r2;
    }

    public static final kotlin.s0.w.d.l0.g.d i(m r1) {
        o.f(r1, "<this>");
        kotlin.s0.w.d.l0.g.d r2 = kotlin.s0.w.d.l0.k.d.m(r1);
        o.e(r2, "getFqName(this)");
        return r2;
    }

    public static final z<m0> j(kotlin.s0.w.d.l0.c.e r2) {
        if (r2 == null) goto L5;
        h1<m0> r3 = r2.z0();
    L7:
        if ((r3 instanceof z) == true) goto L9;
        return null;
    L9:
        return (z) r3;
    L5:
        r3 = null;
        goto L7
    }

    public static final g k(h0 r1) {
        o.f(r1, "<this>");
        p r2 = (p) r1.I0(kotlin.s0.w.d.l0.n.t1.h.a());
        if (r2 == null) goto L5;
        x r3 = (x) r2.a();
    L7:
        if ((r3 instanceof x.a) == false) goto L10;
        return ((x.a) r3).b();
    L10:
        return g.a.f21080a;
    L5:
        r3 = null;
        goto L7
    }

    public static final h0 l(m r1) {
        o.f(r1, "<this>");
        h0 r2 = kotlin.s0.w.d.l0.k.d.g(r1);
        o.e(r2, "getContainingModule(this)");
        return r2;
    }

    public static final kotlin.t0.h<m> m(m r1) {
        o.f(r1, "<this>");
        return k.m(n(r1), 1);
    }

    public static final kotlin.t0.h<m> n(m r1) {
        o.f(r1, "<this>");
        return k.h(r1, e.f20601f);
    }

    public static final kotlin.s0.w.d.l0.c.b o(kotlin.s0.w.d.l0.c.b r1) {
        o.f(r1, "<this>");
        if ((r1 instanceof t0) == false) goto L6;
        u0 r2 = ((t0) r1).B0();
        o.e(r2, "correspondingProperty");
        return r2;
    L6:
        return r1;
    }

    public static final kotlin.s0.w.d.l0.c.e p(kotlin.s0.w.d.l0.c.e r2) {
        o.f(r2, "<this>");
        Iterator<kotlin.s0.w.d.l0.n.e0> r3 = r2.s().O0().a().iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        kotlin.s0.w.d.l0.n.e0 r0 = r3.next();
        if (kotlin.s0.w.d.l0.b.h.b0(r0) == true) goto L4;
        h r1 = r0.O0().d();
        if (kotlin.s0.w.d.l0.k.d.w(r1) == false) goto L4;
        o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return (kotlin.s0.w.d.l0.c.e) r1;
    L11:
        return null;
    }

    public static final boolean q(h0 r2) {
        o.f(r2, "<this>");
        p r3 = (p) r2.I0(kotlin.s0.w.d.l0.n.t1.h.a());
        if (r3 == null) goto L10;
        x r4 = (x) r3.a();
        if (r4 == null) goto L10;
        if (r4.a() != true) goto L10;
        return true;
    L10:
        return false;
    }

    public static final kotlin.s0.w.d.l0.c.e r(h0 r2, kotlin.s0.w.d.l0.g.c r3, kotlin.s0.w.d.l0.d.b.b r4) {
        o.f(r2, "<this>");
        o.f(r3, "topLevelClassFqName");
        o.f(r4, LocationMonitorConst.LOCATION);
        r3.d();
        kotlin.s0.w.d.l0.g.c r0 = r3.e();
        o.e(r0, "topLevelClassFqName.parent()");
        kotlin.s0.w.d.l0.k.w.h r5 = r2.N(r0).q();
        kotlin.s0.w.d.l0.g.f r6 = r3.g();
        o.e(r6, "topLevelClassFqName.shortName()");
        h r7 = r5.f(r6, r4);
        if ((r7 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L7;
        return null;
    L7:
        return (kotlin.s0.w.d.l0.c.e) r7;
    }
}

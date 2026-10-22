package kotlin.s0.w.d.l0.k.w;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends kotlin.s0.w.d.l0.k.w.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f20660c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f20661b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final h a(String r2, Collection<? extends e0> r3) {
            o.f(r2, "message");
            o.f(r3, "types");
            ArrayList r1 = new ArrayList(r.q(r3, 10));
            Iterator<T> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r1.add(((e0) r4.next()).q());
            goto L4
        L6:
            kotlin.s0.w.d.l0.p.e<h> r5 = kotlin.s0.w.d.l0.o.v.a.b(r1);
            h r6 = kotlin.s0.w.d.l0.k.w.b.f20617d.b(r2, r5);
            if (r5.size() > 1) goto L10;
            return r6;
        L10:
            return new n(r2, r6, null);
        }
    }

    static final class b extends q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.a, kotlin.s0.w.d.l0.c.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f20662f = null;

        static {
            f20662f = new b();
        }

        b() {
            super(1);
        }

        public final kotlin.s0.w.d.l0.c.a a(kotlin.s0.w.d.l0.c.a r1) {
            o.f(r1, "$this$selectMostSpecificInEachOverridableGroup");
            return r1;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a invoke(kotlin.s0.w.d.l0.c.a r1) {
            kotlin.s0.w.d.l0.c.a r2 = r1;
            a(r2);
            return r2;
        }
    }

    static final class c extends q implements kotlin.n0.c.l<z0, kotlin.s0.w.d.l0.c.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f20663f = null;

        static {
            f20663f = new c();
        }

        c() {
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

    static final class d extends q implements kotlin.n0.c.l<u0, kotlin.s0.w.d.l0.c.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f20664f = null;

        static {
            f20664f = new d();
        }

        d() {
            super(1);
        }

        public final kotlin.s0.w.d.l0.c.a a(u0 r1) {
            o.f(r1, "$this$selectMostSpecificInEachOverridableGroup");
            return r1;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a invoke(u0 r1) {
            u0 r2 = r1;
            a(r2);
            return r2;
        }
    }

    static {
        f20660c = new a(null);
    }

    private n(String r1, h r2) {
        this.f20661b = r2;
    }

    public /* synthetic */ n(String r1, h r2, kotlin.n0.d.g r3) {
        this(r1, r2);
    }

    public static final h j(String r1, Collection<? extends e0> r2) {
        return f20660c.a(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.k.w.a, kotlin.s0.w.d.l0.k.w.h
    public Collection<z0> a(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        return kotlin.s0.w.d.l0.k.l.a(super.a(r2, r3), c.f20663f);
    }

    @Override // kotlin.s0.w.d.l0.k.w.a, kotlin.s0.w.d.l0.k.w.h
    public Collection<u0> c(kotlin.s0.w.d.l0.g.f r2, kotlin.s0.w.d.l0.d.b.b r3) {
        o.f(r2, "name");
        o.f(r3, LocationMonitorConst.LOCATION);
        return kotlin.s0.w.d.l0.k.l.a(super.c(r2, r3), d.f20664f);
    }

    @Override // kotlin.s0.w.d.l0.k.w.a, kotlin.s0.w.d.l0.k.w.k
    public Collection<kotlin.s0.w.d.l0.c.m> g(kotlin.s0.w.d.l0.k.w.d r3, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r4) {
        o.f(r3, "kindFilter");
        o.f(r4, "nameFilter");
        Collection<kotlin.s0.w.d.l0.c.m> r2 = super.g(r3, r4);
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r2.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Object r0 = r7.next();
        if ((((kotlin.s0.w.d.l0.c.m) r0) instanceof kotlin.s0.w.d.l0.c.a) == true) goto L7;
        r6.add(r0);
        goto L4
    L7:
        r5.add(r0);
        goto L4
    L9:
        u r8 = new u(r5, r6);
        List r9 = (List) r8.a();
        List r10 = (List) r8.b();
        o.d(r9, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return r.k0(kotlin.s0.w.d.l0.k.l.a(r9, b.f20662f), r10);
    }

    @Override // kotlin.s0.w.d.l0.k.w.a
    protected h i() {
        return this.f20661b;
    }
}

package kotlin.s0.w.d.l0.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 {

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<m, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f18873f = null;

        static {
            f18873f = new a();
        }

        a() {
            super(1);
        }

        public final Boolean a(m r1) {
            kotlin.n0.d.o.f(r1, "it");
            return Boolean.valueOf(r1 instanceof kotlin.s0.w.d.l0.c.a);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(m r1) {
            return a(r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<m, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f18874f = null;

        static {
            f18874f = new b();
        }

        b() {
            super(1);
        }

        public final Boolean a(m r1) {
            kotlin.n0.d.o.f(r1, "it");
            return Boolean.valueOf(!(r1 instanceof l));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(m r1) {
            return a(r1);
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<m, kotlin.t0.h<? extends f1>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f18875f = null;

        static {
            f18875f = new c();
        }

        c() {
            super(1);
        }

        public final kotlin.t0.h<f1> a(m r1) {
            kotlin.n0.d.o.f(r1, "it");
            List<f1> r0 = ((kotlin.s0.w.d.l0.c.a) r1).getTypeParameters();
            kotlin.n0.d.o.e(r0, "it as CallableDescriptor).typeParameters");
            return kotlin.i0.r.I(r0);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.t0.h<? extends f1> invoke(m r1) {
            return a(r1);
        }
    }

    public static final s0 a(kotlin.s0.w.d.l0.n.e0 r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        h r0 = r2.O0().d();
        if ((r0 instanceof i) == false) goto L5;
        i r1 = (i) r0;
    L7:
        return b(r2, r1, 0);
    L5:
        r1 = null;
        goto L7
    }

    private static final s0 b(kotlin.s0.w.d.l0.n.e0 r5, i r6, int r7) {
        i r0 = null;
        if (r6 != null) goto L5;
    L19:
        return null;
    L5:
        if (kotlin.s0.w.d.l0.n.u1.k.m(r6) == true) goto L19;
        int r1 = r6.u().size() + r7;
        if (r6.M() == false) goto L10;
        List<kotlin.s0.w.d.l0.n.g1> r8 = r5.M0().subList(r7, r1);
        m r3 = r6.c();
        if ((r3 instanceof i) == false) goto L18;
        r0 = (i) r3;
    L18:
        return new s0(r6, r8, b(r5, r0, r1));
    L10:
        if (r1 == r5.M0().size()) goto L13;
        kotlin.s0.w.d.l0.k.d.E(r6);
    L13:
        return new s0(r6, r5.M0().subList(r7, r5.M0().size()), null);
    }

    private static final kotlin.s0.w.d.l0.c.c c(f1 r1, m r2, int r3) {
        return new kotlin.s0.w.d.l0.c.c(r1, r2, r3);
    }

    public static final List<f1> d(i r7) {
        kotlin.n0.d.o.f(r7, "<this>");
        List<f1> r0 = r7.u();
        kotlin.n0.d.o.e(r0, "declaredTypeParameters");
        if (r7.M() == false) goto L5;
    L7:
        List r2 = kotlin.t0.k.z(kotlin.t0.k.r(kotlin.t0.k.n(kotlin.t0.k.x(kotlin.s0.w.d.l0.k.t.a.m(r7), a.f18873f), b.f18874f), c.f18875f));
        Iterator<m> r3 = kotlin.s0.w.d.l0.k.t.a.m(r7).iterator();
    L8:
        List<f1> r5 = null;
        if (r3.hasNext() == false) goto L13;
        m r4 = r3.next();
        if ((r4 instanceof e) == false) goto L8;
    L14:
        e r6 = (e) r4;
        if (r6 == null) goto L19;
        kotlin.s0.w.d.l0.n.e1 r8 = r6.k();
        if (r8 == null) goto L19;
        r5 = r8.getParameters();
    L19:
        if (r5 != null) goto L22;
        r5 = kotlin.i0.r.g();
    L22:
        if (r2.isEmpty() == true) goto L24;
    L27:
        List r1 = kotlin.i0.r.k0(r2, r5);
        ArrayList r9 = new ArrayList(kotlin.i0.r.q(r1, 10));
        Iterator r10 = r1.iterator();
    L29:
        if (r10.hasNext() == false) goto L32;
        f1 r11 = (f1) r10.next();
        kotlin.n0.d.o.e(r11, "it");
        r9.add(c(r11, r7, r0.size()));
        goto L29
    L32:
        return kotlin.i0.r.k0(r0, r9);
    L24:
        if (r5.isEmpty() == false) goto L27;
        List<f1> r12 = r7.u();
        kotlin.n0.d.o.e(r12, "declaredTypeParameters");
        return r12;
    L13:
        r4 = null;
        goto L14
    L5:
        if ((r7.c() instanceof kotlin.s0.w.d.l0.c.a) == true) goto L7;
        return r0;
    }
}

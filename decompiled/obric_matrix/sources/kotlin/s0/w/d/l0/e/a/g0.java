package kotlin.s0.w.d.l0.e.a;

import kotlin.s0.w.d.l0.c.t0;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19263f = null;

        static {
            f19263f = new a();
        }

        a() {
            super(1);
        }

        public final Boolean a(kotlin.s0.w.d.l0.c.b r1) {
            kotlin.n0.d.o.f(r1, "it");
            return Boolean.valueOf(i.f19290a.b(kotlin.s0.w.d.l0.k.t.a.o(r1)));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f19264f = null;

        static {
            f19264f = new b();
        }

        b() {
            super(1);
        }

        public final Boolean a(kotlin.s0.w.d.l0.c.b r1) {
            kotlin.n0.d.o.f(r1, "it");
            return Boolean.valueOf(e.m.j((z0) r1));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f19265f = null;

        static {
            f19265f = new c();
        }

        c() {
            super(1);
        }

        public final Boolean a(kotlin.s0.w.d.l0.c.b r1) {
            kotlin.n0.d.o.f(r1, "it");
            if (kotlin.s0.w.d.l0.b.h.f0(r1) == true) goto L5;
        L7:
            boolean r0 = false;
        L9:
            return Boolean.valueOf(r0);
        L5:
            if (f.m(r1) == null) goto L7;
            r0 = true;
            goto L9
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    public static final boolean a(kotlin.s0.w.d.l0.c.b r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        if (d(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final String b(kotlin.s0.w.d.l0.c.b r2) {
        kotlin.n0.d.o.f(r2, "callableMemberDescriptor");
        kotlin.s0.w.d.l0.c.b r3 = c(r2);
        if (r3 == null) goto L16;
        kotlin.s0.w.d.l0.c.b r4 = kotlin.s0.w.d.l0.k.t.a.o(r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        if ((r4 instanceof u0) == false) goto L11;
        return i.f19290a.a(r4);
    L11:
        if ((r4 instanceof z0) == false) goto L18;
        kotlin.s0.w.d.l0.g.f r5 = e.m.i((z0) r4);
        if (r5 != null) goto L15;
        return null;
    L15:
        return r5.b();
    L18:
        return null;
    L16:
        return null;
    }

    private static final kotlin.s0.w.d.l0.c.b c(kotlin.s0.w.d.l0.c.b r1) {
        if (kotlin.s0.w.d.l0.b.h.f0(r1) == true) goto L7;
        return null;
    L7:
        return d(r1);
    }

    public static final <T extends kotlin.s0.w.d.l0.c.b> T d(T r4) {
        kotlin.n0.d.o.f(r4, "<this>");
        if (h0.f19266a.g().contains(r4.getName()) == true) goto L8;
        if (g.f19258a.d().contains(kotlin.s0.w.d.l0.k.t.a.o(r4).getName()) == true) goto L8;
        return null;
    L8:
        if ((r4 instanceof u0) == false) goto L10;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L16;
        kotlin.n0.c.l r1 = a.f19263f;
    L18:
        return (T) kotlin.s0.w.d.l0.k.t.a.c(r4, false, r1, 1, null);
    L16:
        if ((r4 instanceof z0) == false) goto L19;
        r1 = b.f19264f;
        goto L18
    L19:
        return null;
    L10:
        r0 = r4 instanceof t0;
        goto L12
    }

    public static final <T extends kotlin.s0.w.d.l0.c.b> T e(T r4) {
        kotlin.n0.d.o.f(r4, "<this>");
        T r0 = (T) d(r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        f r1 = f.m;
        kotlin.s0.w.d.l0.g.f r2 = r4.getName();
        kotlin.n0.d.o.e(r2, "name");
        if (r1.l(r2) == true) goto L9;
        return null;
    L9:
        return (T) kotlin.s0.w.d.l0.k.t.a.c(r4, false, c.f19265f, 1, null);
    }

    public static final boolean f(kotlin.s0.w.d.l0.c.e r3, kotlin.s0.w.d.l0.c.a r4) {
        kotlin.n0.d.o.f(r3, "<this>");
        kotlin.n0.d.o.f(r4, "specialCallableDescriptor");
        kotlin.s0.w.d.l0.c.m r5 = r4.c();
        kotlin.n0.d.o.d(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        m0 r6 = ((kotlin.s0.w.d.l0.c.e) r5).s();
        kotlin.n0.d.o.e(r6, "specialCallableDescripto…ssDescriptor).defaultType");
    L3:
        r3 = kotlin.s0.w.d.l0.k.d.s(r3);
        boolean r0 = false;
        if (r3 == null) goto L13;
        if ((r3 instanceof kotlin.s0.w.d.l0.e.a.k0.c) == true) goto L3;
        if (kotlin.s0.w.d.l0.n.t1.u.b(r3.s(), r6) == null) goto L10;
        r0 = true;
    L10:
        if (r0 == false) goto L3;
        return !kotlin.s0.w.d.l0.b.h.f0(r3);
    L13:
        return false;
    }

    public static final boolean g(kotlin.s0.w.d.l0.c.b r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return kotlin.s0.w.d.l0.k.t.a.o(r1).c() instanceof kotlin.s0.w.d.l0.e.a.k0.c;
    }

    public static final boolean h(kotlin.s0.w.d.l0.c.b r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        if (g(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (kotlin.s0.w.d.l0.b.h.f0(r1) == true) goto L8;
        return false;
    }
}

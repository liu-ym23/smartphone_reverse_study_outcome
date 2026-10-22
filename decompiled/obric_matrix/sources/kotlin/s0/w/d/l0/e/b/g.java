package kotlin.s0.w.d.l0.e.b;

import java.util.Collection;
import java.util.Set;
import kotlin.i0.t0;
import kotlin.s0.w.d.l0.c.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f19762b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a> f19763c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a> f19764d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.f.a0.b.e f19765e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.f.a0.b.e f19766f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.f.a0.b.e f19767g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kotlin.s0.w.d.l0.l.b.k f19768a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final kotlin.s0.w.d.l0.f.a0.b.e a() {
            return g.a();
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<Collection<? extends kotlin.s0.w.d.l0.g.f>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f19769f = null;

        static {
            f19769f = new b();
        }

        b() {
            super(0);
        }

        public final Collection<kotlin.s0.w.d.l0.g.f> a() {
            return kotlin.i0.r.g();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Collection<? extends kotlin.s0.w.d.l0.g.f> invoke() {
            return a();
        }
    }

    static {
        f19762b = new a(null);
        f19763c = t0.a(kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19734j);
        f19764d = t0.e(new kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a[]{kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19735k, kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.n});
        f19765e = new kotlin.s0.w.d.l0.f.a0.b.e(new int[]{1, 1, 2});
        f19766f = new kotlin.s0.w.d.l0.f.a0.b.e(new int[]{1, 1, 11});
        f19767g = new kotlin.s0.w.d.l0.f.a0.b.e(new int[]{1, 1, 13});
    }

    public g() {
    }

    public static final /* synthetic */ kotlin.s0.w.d.l0.f.a0.b.e a() {
        return f19767g;
    }

    private final kotlin.s0.w.d.l0.l.b.g0.e c(q r1) {
        if (d().g().b() == false) goto L6;
    L12:
        return kotlin.s0.w.d.l0.l.b.g0.e.f20759f;
    L6:
        if (r1.a().j() == false) goto L9;
        return kotlin.s0.w.d.l0.l.b.g0.e.f20760g;
    L9:
        if (r1.a().k() == false) goto L12;
        return kotlin.s0.w.d.l0.l.b.g0.e.f20761h;
    }

    private final kotlin.s0.w.d.l0.l.b.t<kotlin.s0.w.d.l0.f.a0.b.e> e(q r4) {
        if (f() == false) goto L5;
        return null;
    L5:
        if (r4.a().d().h() == false) goto L8;
        return null;
    L8:
        return new kotlin.s0.w.d.l0.l.b.t(r4.a().d(), kotlin.s0.w.d.l0.f.a0.b.e.f19882g, r4.getLocation(), r4.f());
    }

    private final boolean f() {
        return d().g().d();
    }

    private final boolean g(q r1) {
        if (d().g().c() == false) goto L5;
    L9:
        return false;
    L5:
        if (r1.a().i() == false) goto L9;
        if (kotlin.n0.d.o.a(r1.a().d(), f19766f) == false) goto L9;
        return true;
    }

    private final boolean h(q r3) {
        if (d().g().e() == false) goto L9;
        if (r3.a().i() == false) goto L7;
    L10:
        return true;
    L7:
        if (kotlin.n0.d.o.a(r3.a().d(), f19765e) == true) goto L10;
    L9:
        if (g(r3) == true) goto L10;
        return false;
    }

    private final String[] j(q r2, Set<? extends kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a> r3) {
        kotlin.s0.w.d.l0.e.b.c0.a r1 = r2.a();
        String[] r4 = r1.a();
        if (r4 != null) goto L6;
        r4 = r1.b();
    L6:
        if (r4 == null) goto L11;
        if (r3.contains(r1.c()) == false) goto L11;
        return r4;
    L11:
        return null;
    }

    public final kotlin.s0.w.d.l0.k.w.h b(l0 r13, q r14) {
        kotlin.n0.d.o.f(r13, "descriptor");
        kotlin.n0.d.o.f(r14, "kotlinClass");
        String[] r0 = j(r14, f19764d);
        if (r0 != null) goto L5;
        return null;
    L5:
        String[] r2 = r14.a().g();
        if (r2 != null) goto L25;
        return null;
    L25:
        kotlin.u<kotlin.s0.w.d.l0.f.a0.b.f, kotlin.s0.w.d.l0.f.l> r1 = kotlin.s0.w.d.l0.f.a0.b.i.m(r0, r2);     // Catch: Throwable -> L10 kotlin.s0.w.d.l0.i.k -> L12
    L20:
        if (r1 != null) goto L22;
        return null;
    L22:
        kotlin.s0.w.d.l0.f.a0.b.f r3 = r1.a();
        kotlin.s0.w.d.l0.f.l r4 = r1.b();
        k r9 = new k(r14, r4, r3, e(r14), h(r14), c(r14));
        return new kotlin.s0.w.d.l0.l.b.g0.i(r13, r4, r3, r14.a().d(), r9, d(), "scope for " + r9 + " in " + r13, b.f19769f);
    L12:
        e = move-exception;
        throw new IllegalStateException("Could not read data from " + r14.getLocation(), e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (f() == false) goto L18;
    L24:
        throw th;
    L18:
        if (r14.a().d().h() == true) goto L24;
        r1 = null;
        goto L20
    }

    public final kotlin.s0.w.d.l0.l.b.k d() {
        kotlin.s0.w.d.l0.l.b.k r0 = this.f19768a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        kotlin.n0.d.o.v("components");
        throw null;
    }

    public final kotlin.s0.w.d.l0.l.b.g i(q r6) {
        kotlin.n0.d.o.f(r6, "kotlinClass");
        String[] r0 = j(r6, f19763c);
        if (r0 != null) goto L5;
        return null;
    L5:
        String[] r2 = r6.a().g();
        if (r2 != null) goto L25;
        return null;
    L25:
        kotlin.u<kotlin.s0.w.d.l0.f.a0.b.f, kotlin.s0.w.d.l0.f.c> r1 = kotlin.s0.w.d.l0.f.a0.b.i.i(r0, r2);     // Catch: Throwable -> L10 kotlin.s0.w.d.l0.i.k -> L12
    L20:
        if (r1 != null) goto L23;
        return null;
    L23:
        return new kotlin.s0.w.d.l0.l.b.g(r1.a(), r1.b(), r6.a().d(), new s(r6, e(r6), h(r6), c(r6)));
    L12:
        e = move-exception;
        throw new IllegalStateException("Could not read data from " + r6.getLocation(), e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (f() == false) goto L18;
    L24:
        throw th;
    L18:
        if (r6.a().d().h() == true) goto L24;
        r1 = null;
        goto L20
    }

    public final kotlin.s0.w.d.l0.c.e k(q r2) {
        kotlin.n0.d.o.f(r2, "kotlinClass");
        kotlin.s0.w.d.l0.l.b.g r0 = i(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return d().f().d(r2.f(), r0);
    }

    public final void l(e r2) {
        kotlin.n0.d.o.f(r2, "components");
        m(r2.a());
    }

    public final void m(kotlin.s0.w.d.l0.l.b.k r2) {
        kotlin.n0.d.o.f(r2, "<set-?>");
        this.f19768a = r2;
    }
}

package kotlin.s0.w.d.l0.f;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends kotlin.s0.w.d.l0.i.i.d<g> implements Object {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final g f19990l = null;
    public static kotlin.s0.w.d.l0.i.s<g> m;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f19991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte f19994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f19995k;

    static class a extends kotlin.s0.w.d.l0.i.b<g> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public g m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new g(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.c<g, b> implements Object {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f19996i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f19997j;

        private b() {
            B();
        }

        private void B() {
        }

        static /* synthetic */ b u() {
            return z();
        }

        private static b z() {
            return new b();
        }

        public b C(g r2) {
            if (r2 != g.D()) goto L6;
            return this;
        L6:
            if (r2.G() == false) goto L8;
            E(r2.F());
        L8:
            t(r2);
            o(m().b(g.C(r2)));
            return this;
        }

        public b D(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            g r0 = null;
            g r5 = g.m.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            C(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            g r6 = (g) e.a();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            C(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }

        public b E(int r2) {
            this.f19996i |= 1;
            this.f19997j = r2;
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q build() {
            return v();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ Object clone() {
            return y();
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.a.AbstractC0550a i(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            D(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return y();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            C((g) r1);
            return this;
        }

        public g v() {
            g r1 = w();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public g w() {
            g r0 = new g(this, null);
            int r2 = 1;
            if ((this.f19996i & 1) == 1) goto L6;
            r2 = 0;
        L6:
            g.A(r0, this.f19997j);
            g.B(r0, r2);
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            D(r1, r2);
            return this;
        }

        public b y() {
            b r0 = z();
            r0.C(w());
            return r0;
        }
    }

    static {
        m = new a();
        g r0 = new g(true);
        f19990l = r0;
        r0.H();
    }

    private g(kotlin.s0.w.d.l0.i.e r7, kotlin.s0.w.d.l0.i.g r8) {
        this.f19994j = -1;
        this.f19995k = -1;
        H();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
    L3:
        if (r3 == true) goto L42;
        int r4 = r7.K();     // Catch: Throwable -> L14 IOException -> L16 kotlin.s0.w.d.l0.i.k -> L19
        if (r4 == 0) goto L13;
        if (r4 != 8) goto L9;
        this.f19992h |= 1;     // Catch: Throwable -> L14 IOException -> L16 kotlin.s0.w.d.l0.i.k -> L19
        this.f19993i = r7.s();     // Catch: Throwable -> L14 IOException -> L16 kotlin.s0.w.d.l0.i.k -> L19
        goto L3
    L9:
        if (o(r7, r2, r8, r4) == true) goto L3;
    L13:
        r3 = true;
        goto L3
    L14:
        th = move-exception;
        r2.I();     // Catch: IOException -> L36 Throwable -> L24
    L24:
        th = move-exception;
        this.f19991g = r0.l();
        throw th;
    L23:
        this.f19991g = r0.l();
        l();
        throw th;
    L19:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L14
        throw e;     // Catch: Throwable -> L14
    L16:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r9 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L14
        r9.i(this);     // Catch: Throwable -> L14
        throw r9;     // Catch: Throwable -> L14
    L42:
        r2.I();     // Catch: IOException -> L37 Throwable -> L31
    L31:
        th = move-exception;
        this.f19991g = r0.l();
        throw th;
    L30:
        this.f19991g = r0.l();
        l();
    }

    /* synthetic */ g(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private g(kotlin.s0.w.d.l0.i.i.c<g, ?> r2) {
        super(r2);
        this.f19994j = -1;
        this.f19995k = -1;
        this.f19991g = r2.m();
    }

    /* synthetic */ g(kotlin.s0.w.d.l0.i.i.c r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private g(boolean r1) {
        this.f19994j = -1;
        this.f19995k = -1;
        this.f19991g = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ int A(g r0, int r1) {
        r0.f19993i = r1;
        return r1;
    }

    static /* synthetic */ int B(g r0, int r1) {
        r0.f19992h = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d C(g r0) {
        return r0.f19991g;
    }

    public static g D() {
        return f19990l;
    }

    private void H() {
        this.f19993i = 0;
    }

    public static b I() {
        return b.u();
    }

    public static b J(g r1) {
        b r0 = I();
        r0.C(r1);
        return r0;
    }

    public g E() {
        return f19990l;
    }

    public int F() {
        return this.f19993i;
    }

    public boolean G() {
        if ((this.f19992h & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public b K() {
        return I();
    }

    public b L() {
        return J(this);
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q a() {
        return E();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return L();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r4) {
        e();
        kotlin.s0.w.d.l0.i.i.d<MessageType>.a r0 = y();
        if ((this.f19992h & 1) != 1) goto L5;
        r4.a0(1, this.f19993i);
    L5:
        r0.a(200, r4);
        r4.i0(this.f19991g);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.f19995k;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if ((this.f19992h & 1) != 1) goto L8;
        r1 = 0 + kotlin.s0.w.d.l0.i.f.o(1, this.f19993i);
    L8:
        int r2 = (r1 + s()) + this.f19991g.size();
        this.f19995k = r2;
        return r2;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return K();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<g> h() {
        return m;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.f19994j;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (r() == true) goto L12;
        this.f19994j = 0;
        return false;
    L12:
        this.f19994j = 1;
        return true;
    }
}

package kotlin.s0.w.d.l0.f;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends kotlin.s0.w.d.l0.i.i.d<u> implements Object {
    private static final u q = null;
    public static kotlin.s0.w.d.l0.i.s<u> r;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private q f20166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f20167l;
    private q m;
    private int n;
    private byte o;
    private int p;

    static class a extends kotlin.s0.w.d.l0.i.b<u> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public u m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new u(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.c<u, b> implements Object {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20168i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f20169j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f20170k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private q f20171l;
        private int m;
        private q n;
        private int o;

        private b() {
            this.f20171l = q.X();
            this.n = q.X();
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

        public b C(u r2) {
            if (r2 != u.I()) goto L6;
            return this;
        L6:
            if (r2.Q() == false) goto L9;
            G(r2.K());
        L9:
            if (r2.R() == false) goto L12;
            H(r2.L());
        L12:
            if (r2.S() == false) goto L15;
            E(r2.M());
        L15:
            if (r2.T() == false) goto L18;
            I(r2.N());
        L18:
            if (r2.U() == false) goto L21;
            F(r2.O());
        L21:
            if (r2.V() == false) goto L23;
            J(r2.P());
        L23:
            t(r2);
            o(m().b(u.H(r2)));
            return this;
        }

        public b D(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            u r0 = null;
            u r5 = u.r.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            C(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            u r6 = (u) e.a();     // Catch: Throwable -> L7
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

        public b E(q r4) {
            if ((this.f20168i & 4) == 4) goto L5;
        L7:
            this.f20171l = r4;
            this.f20168i |= 4;
            return this;
        L5:
            if (this.f20171l == q.X()) goto L7;
            r4 = q.y0(this.f20171l).F(r4).w();
            goto L7
        }

        public b F(q r4) {
            if ((this.f20168i & 16) == 16) goto L5;
        L7:
            this.n = r4;
            this.f20168i |= 16;
            return this;
        L5:
            if (this.n == q.X()) goto L7;
            r4 = q.y0(this.n).F(r4).w();
            goto L7
        }

        public b G(int r2) {
            this.f20168i |= 1;
            this.f20169j = r2;
            return this;
        }

        public b H(int r2) {
            this.f20168i |= 2;
            this.f20170k = r2;
            return this;
        }

        public b I(int r2) {
            this.f20168i |= 8;
            this.m = r2;
            return this;
        }

        public b J(int r2) {
            this.f20168i |= 32;
            this.o = r2;
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
            C((u) r1);
            return this;
        }

        public u v() {
            u r1 = w();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public u w() {
            u r0 = new u(this, null);
            int r1 = this.f20168i;
            int r3 = 1;
            if ((r1 & 1) == 1) goto L6;
            r3 = 0;
        L6:
            u.A(r0, this.f20169j);
            if ((r1 & 2) != 2) goto L9;
            r3 = r3 | 2;
        L9:
            u.B(r0, this.f20170k);
            if ((r1 & 4) != 4) goto L12;
            r3 = r3 | 4;
        L12:
            u.C(r0, this.f20171l);
            if ((r1 & 8) != 8) goto L15;
            r3 = r3 | 8;
        L15:
            u.D(r0, this.m);
            if ((r1 & 16) != 16) goto L18;
            r3 = r3 | 16;
        L18:
            u.E(r0, this.n);
            if ((r1 & 32) != 32) goto L21;
            r3 = r3 | 32;
        L21:
            u.F(r0, this.o);
            u.G(r0, r3);
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
        r = new a();
        u r0 = new u(true);
        q = r0;
        r0.W();
    }

    private u(kotlin.s0.w.d.l0.i.e r10, kotlin.s0.w.d.l0.i.g r11) {
        this.o = -1;
        this.p = -1;
        W();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
    L3:
        if (r3 == true) goto L69;
        int r4 = r10.K();     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        if (r4 == 0) goto L40;
        if (r4 != 8) goto L9;
        this.f20163h |= 1;     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        this.f20164i = r10.s();     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        goto L3
    L9:
        if (r4 != 16) goto L10;
        this.f20163h |= 2;     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        this.f20165j = r10.s();     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        goto L3
    L10:
        q.c r8 = null;
        if (r4 != 26) goto L13;
        if ((this.f20163h & 4) != 4) goto L33;
        r8 = this.f20166k.A0();     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
    L33:
        q r5 = (q) r10.u(q.z, r11);     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        this.f20166k = r5;     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        if (r8 == null) goto L36;
        r8.F(r5);     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        this.f20166k = r8.w();     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
    L36:
        this.f20163h |= 4;     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        goto L3
    L13:
        if (r4 != 34) goto L15;
        if ((this.f20163h & 16) != 16) goto L26;
        r8 = this.m.A0();     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
    L26:
        q r6 = (q) r10.u(q.z, r11);     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        this.m = r6;     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        if (r8 == null) goto L29;
        r8.F(r6);     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        this.m = r8.w();     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
    L29:
        this.f20163h |= 16;     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        goto L3
    L15:
        if (r4 != 40) goto L17;
        this.f20163h |= 8;     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        this.f20167l = r10.s();     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        goto L3
    L17:
        if (r4 != 48) goto L19;
        this.f20163h |= 32;     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        this.n = r10.s();     // Catch: Throwable -> L41 IOException -> L43 kotlin.s0.w.d.l0.i.k -> L46
        goto L3
    L19:
        if (o(r10, r2, r11, r4) == true) goto L3;
    L40:
        r3 = true;
        goto L3
    L41:
        th = move-exception;
        r2.I();     // Catch: IOException -> L63 Throwable -> L51
    L51:
        th = move-exception;
        this.f20162g = r0.l();
        throw th;
    L50:
        this.f20162g = r0.l();
        l();
        throw th;
    L46:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L41
        throw e;     // Catch: Throwable -> L41
    L43:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r12 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L41
        r12.i(this);     // Catch: Throwable -> L41
        throw r12;     // Catch: Throwable -> L41
    L69:
        r2.I();     // Catch: IOException -> L64 Throwable -> L58
    L58:
        th = move-exception;
        this.f20162g = r0.l();
        throw th;
    L57:
        this.f20162g = r0.l();
        l();
    }

    /* synthetic */ u(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private u(kotlin.s0.w.d.l0.i.i.c<u, ?> r2) {
        super(r2);
        this.o = -1;
        this.p = -1;
        this.f20162g = r2.m();
    }

    /* synthetic */ u(kotlin.s0.w.d.l0.i.i.c r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private u(boolean r1) {
        this.o = -1;
        this.p = -1;
        this.f20162g = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ int A(u r0, int r1) {
        r0.f20164i = r1;
        return r1;
    }

    static /* synthetic */ int B(u r0, int r1) {
        r0.f20165j = r1;
        return r1;
    }

    static /* synthetic */ q C(u r0, q r1) {
        r0.f20166k = r1;
        return r1;
    }

    static /* synthetic */ int D(u r0, int r1) {
        r0.f20167l = r1;
        return r1;
    }

    static /* synthetic */ q E(u r0, q r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ int F(u r0, int r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ int G(u r0, int r1) {
        r0.f20163h = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d H(u r0) {
        return r0.f20162g;
    }

    public static u I() {
        return q;
    }

    private void W() {
        this.f20164i = 0;
        this.f20165j = 0;
        this.f20166k = q.X();
        this.f20167l = 0;
        this.m = q.X();
        this.n = 0;
    }

    public static b X() {
        return b.u();
    }

    public static b Y(u r1) {
        b r0 = X();
        r0.C(r1);
        return r0;
    }

    public u J() {
        return q;
    }

    public int K() {
        return this.f20164i;
    }

    public int L() {
        return this.f20165j;
    }

    public q M() {
        return this.f20166k;
    }

    public int N() {
        return this.f20167l;
    }

    public q O() {
        return this.m;
    }

    public int P() {
        return this.n;
    }

    public boolean Q() {
        if ((this.f20163h & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean R() {
        if ((this.f20163h & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean S() {
        if ((this.f20163h & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean T() {
        if ((this.f20163h & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean U() {
        if ((this.f20163h & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean V() {
        if ((this.f20163h & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public b Z() {
        return X();
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q a() {
        return J();
    }

    public b a0() {
        return Y(this);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return a0();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r5) {
        e();
        kotlin.s0.w.d.l0.i.i.d<MessageType>.a r0 = y();
        if ((this.f20163h & 1) != 1) goto L6;
        r5.a0(1, this.f20164i);
    L6:
        if ((this.f20163h & 2) != 2) goto L9;
        r5.a0(2, this.f20165j);
    L9:
        if ((this.f20163h & 4) != 4) goto L12;
        r5.d0(3, this.f20166k);
    L12:
        if ((this.f20163h & 16) != 16) goto L15;
        r5.d0(4, this.m);
    L15:
        if ((this.f20163h & 8) != 8) goto L18;
        r5.a0(5, this.f20167l);
    L18:
        if ((this.f20163h & 32) != 32) goto L20;
        r5.a0(6, this.n);
    L20:
        r0.a(200, r5);
        r5.i0(this.f20162g);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.p;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if ((this.f20163h & 1) != 1) goto L9;
        r1 = 0 + kotlin.s0.w.d.l0.i.f.o(1, this.f20164i);
    L9:
        if ((this.f20163h & 2) != 2) goto L12;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(2, this.f20165j);
    L12:
        if ((this.f20163h & 4) != 4) goto L15;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(3, this.f20166k);
    L15:
        if ((this.f20163h & 16) != 16) goto L18;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(4, this.m);
    L18:
        if ((this.f20163h & 8) != 8) goto L21;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(5, this.f20167l);
    L21:
        if ((this.f20163h & 32) != 32) goto L23;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(6, this.n);
    L23:
        int r2 = (r1 + s()) + this.f20162g.size();
        this.p = r2;
        return r2;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return Z();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<u> h() {
        return r;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.o;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (R() == true) goto L13;
        this.o = 0;
        return false;
    L13:
        if (S() == false) goto L19;
        if (M().isInitialized() == true) goto L19;
        this.o = 0;
        return false;
    L19:
        if (U() == false) goto L25;
        if (O().isInitialized() == true) goto L25;
        this.o = 0;
        return false;
    L25:
        if (r() == true) goto L28;
        this.o = 0;
        return false;
    L28:
        this.o = 1;
        return true;
    }
}

package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {
    private static final v p = null;
    public static kotlin.s0.w.d.l0.i.s<v> q;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20175i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f20176j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f20177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f20178l;
    private d m;
    private byte n;
    private int o;

    static class a extends kotlin.s0.w.d.l0.i.b<v> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public v m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new v(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.b<v, b> implements Object {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20179g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f20180h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20181i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private c f20182j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f20183k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f20184l;
        private d m;

        private b() {
            this.f20182j = c.f20186h;
            this.m = d.f20190g;
            v();
        }

        static /* synthetic */ b p() {
            return u();
        }

        private static b u() {
            return new b();
        }

        private void v() {
        }

        public b B(c r2) {
            Objects.requireNonNull(r2);
            this.f20179g |= 4;
            this.f20182j = r2;
            return this;
        }

        public b C(int r2) {
            this.f20179g |= 16;
            this.f20184l = r2;
            return this;
        }

        public b D(int r2) {
            this.f20179g |= 1;
            this.f20180h = r2;
            return this;
        }

        public b E(int r2) {
            this.f20179g |= 2;
            this.f20181i = r2;
            return this;
        }

        public b F(d r2) {
            Objects.requireNonNull(r2);
            this.f20179g |= 32;
            this.m = r2;
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q build() {
            return q();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ Object clone() {
            return t();
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.a.AbstractC0550a i(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            y(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return t();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            w((v) r1);
            return this;
        }

        public v q() {
            v r1 = r();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public v r() {
            v r0 = new v(this, null);
            int r1 = this.f20179g;
            int r3 = 1;
            if ((r1 & 1) == 1) goto L6;
            r3 = 0;
        L6:
            v.q(r0, this.f20180h);
            if ((r1 & 2) != 2) goto L9;
            r3 = r3 | 2;
        L9:
            v.r(r0, this.f20181i);
            if ((r1 & 4) != 4) goto L12;
            r3 = r3 | 4;
        L12:
            v.s(r0, this.f20182j);
            if ((r1 & 8) != 8) goto L15;
            r3 = r3 | 8;
        L15:
            v.t(r0, this.f20183k);
            if ((r1 & 16) != 16) goto L18;
            r3 = r3 | 16;
        L18:
            v.u(r0, this.f20184l);
            if ((r1 & 32) != 32) goto L21;
            r3 = r3 | 32;
        L21:
            v.v(r0, this.m);
            v.w(r0, r3);
            return r0;
        }

        public b t() {
            b r0 = u();
            r0.w(r());
            return r0;
        }

        public b w(v r2) {
            if (r2 != v.z()) goto L6;
            return this;
        L6:
            if (r2.J() == false) goto L9;
            D(r2.D());
        L9:
            if (r2.K() == false) goto L12;
            E(r2.E());
        L12:
            if (r2.H() == false) goto L15;
            B(r2.B());
        L15:
            if (r2.G() == false) goto L18;
            z(r2.A());
        L18:
            if (r2.I() == false) goto L21;
            C(r2.C());
        L21:
            if (r2.L() == false) goto L23;
            F(r2.F());
        L23:
            o(m().b(v.y(r2)));
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            y(r1, r2);
            return this;
        }

        public b y(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            v r0 = null;
            v r5 = v.q.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            w(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            v r6 = (v) e.a();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            w(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }

        public b z(int r2) {
            this.f20179g |= 8;
            this.f20183k = r2;
            return this;
        }
    }

    public static final enum c extends Enum<c> implements kotlin.s0.w.d.l0.i.j.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f20185g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f20186h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f20187i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ c[] f20188j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f20189f;

        static {
            c r0 = new c("WARNING", 0, 0, 0);
            f20185g = r0;
            c r1 = new c("ERROR", 1, 1, 1);
            f20186h = r1;
            c r3 = new c("HIDDEN", 2, 2, 2);
            f20187i = r3;
            f20188j = new c[]{r0, r1, r3};
        }

        private c(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.f20189f = r4;
        }

        public static c a(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return f20187i;
        L12:
            return f20186h;
        L14:
            return f20185g;
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f20188j.clone();
        }

        @Override // kotlin.s0.w.d.l0.i.j.a
        public final int d() {
            return this.f20189f;
        }
    }

    public static final enum d extends Enum<d> implements kotlin.s0.w.d.l0.i.j.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f20190g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f20191h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final d f20192i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ d[] f20193j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f20194f;

        static {
            d r0 = new d("LANGUAGE_VERSION", 0, 0, 0);
            f20190g = r0;
            d r1 = new d("COMPILER_VERSION", 1, 1, 1);
            f20191h = r1;
            d r3 = new d("API_VERSION", 2, 2, 2);
            f20192i = r3;
            f20193j = new d[]{r0, r1, r3};
        }

        private d(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.f20194f = r4;
        }

        public static d a(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return f20192i;
        L12:
            return f20191h;
        L14:
            return f20190g;
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f20193j.clone();
        }

        @Override // kotlin.s0.w.d.l0.i.j.a
        public final int d() {
            return this.f20194f;
        }
    }

    static {
        q = new a();
        v r0 = new v(true);
        p = r0;
        r0.M();
    }

    private v(kotlin.s0.w.d.l0.i.e r9, kotlin.s0.w.d.l0.i.g r10) {
        this.n = -1;
        this.o = -1;
        M();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
    L3:
        if (r3 == true) goto L64;
        int r4 = r9.K();     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        if (r4 == 0) goto L35;
        if (r4 != 8) goto L9;
        this.f20173g |= 1;     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        this.f20174h = r9.s();     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        goto L3
    L9:
        if (r4 != 16) goto L11;
        this.f20173g |= 2;     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        this.f20175i = r9.s();     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        goto L3
    L11:
        if (r4 != 24) goto L13;
        int r5 = r9.n();     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        c r6 = c.a(r5);     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        if (r6 == null) goto L30;
        this.f20173g |= 4;     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        this.f20176j = r6;     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        goto L3
    L30:
        r2.o0(r4);     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
    L24:
        r2.o0(r5);     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        goto L3
    L13:
        if (r4 != 32) goto L15;
        this.f20173g |= 8;     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        this.f20177k = r9.s();     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        goto L3
    L15:
        if (r4 != 40) goto L17;
        this.f20173g |= 16;     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        this.f20178l = r9.s();     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        goto L3
    L17:
        if (r4 != 48) goto L19;
        r5 = r9.n();     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        d r7 = d.a(r5);     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        if (r7 == null) goto L23;
        this.f20173g |= 32;     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        this.m = r7;     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        goto L3
    L23:
        r2.o0(r4);     // Catch: Throwable -> L36 IOException -> L38 kotlin.s0.w.d.l0.i.k -> L41
        goto L24
    L19:
        if (o(r9, r2, r10, r4) == true) goto L3;
    L35:
        r3 = true;
        goto L3
    L36:
        th = move-exception;
        r2.I();     // Catch: IOException -> L58 Throwable -> L46
    L46:
        th = move-exception;
        this.f20172f = r0.l();
        throw th;
    L45:
        this.f20172f = r0.l();
        l();
        throw th;
    L41:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L36
        throw e;     // Catch: Throwable -> L36
    L38:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r11 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L36
        r11.i(this);     // Catch: Throwable -> L36
        throw r11;     // Catch: Throwable -> L36
    L64:
        r2.I();     // Catch: IOException -> L59 Throwable -> L53
    L53:
        th = move-exception;
        this.f20172f = r0.l();
        throw th;
    L52:
        this.f20172f = r0.l();
        l();
    }

    /* synthetic */ v(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private v(kotlin.s0.w.d.l0.i.i.b r2) {
        super(r2);
        this.n = -1;
        this.o = -1;
        this.f20172f = r2.m();
    }

    /* synthetic */ v(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private v(boolean r1) {
        this.n = -1;
        this.o = -1;
        this.f20172f = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    private void M() {
        this.f20174h = 0;
        this.f20175i = 0;
        this.f20176j = c.f20186h;
        this.f20177k = 0;
        this.f20178l = 0;
        this.m = d.f20190g;
    }

    public static b N() {
        return b.p();
    }

    public static b O(v r1) {
        b r0 = N();
        r0.w(r1);
        return r0;
    }

    static /* synthetic */ int q(v r0, int r1) {
        r0.f20174h = r1;
        return r1;
    }

    static /* synthetic */ int r(v r0, int r1) {
        r0.f20175i = r1;
        return r1;
    }

    static /* synthetic */ c s(v r0, c r1) {
        r0.f20176j = r1;
        return r1;
    }

    static /* synthetic */ int t(v r0, int r1) {
        r0.f20177k = r1;
        return r1;
    }

    static /* synthetic */ int u(v r0, int r1) {
        r0.f20178l = r1;
        return r1;
    }

    static /* synthetic */ d v(v r0, d r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ int w(v r0, int r1) {
        r0.f20173g = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d y(v r0) {
        return r0.f20172f;
    }

    public static v z() {
        return p;
    }

    public int A() {
        return this.f20177k;
    }

    public c B() {
        return this.f20176j;
    }

    public int C() {
        return this.f20178l;
    }

    public int D() {
        return this.f20174h;
    }

    public int E() {
        return this.f20175i;
    }

    public d F() {
        return this.m;
    }

    public boolean G() {
        if ((this.f20173g & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean H() {
        if ((this.f20173g & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean I() {
        if ((this.f20173g & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean J() {
        if ((this.f20173g & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean K() {
        if ((this.f20173g & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean L() {
        if ((this.f20173g & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public b P() {
        return N();
    }

    public b Q() {
        return O(this);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return Q();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r4) {
        e();
        if ((this.f20173g & 1) != 1) goto L6;
        r4.a0(1, this.f20174h);
    L6:
        if ((this.f20173g & 2) != 2) goto L9;
        r4.a0(2, this.f20175i);
    L9:
        if ((this.f20173g & 4) != 4) goto L12;
        r4.S(3, this.f20176j.d());
    L12:
        if ((this.f20173g & 8) != 8) goto L15;
        r4.a0(4, this.f20177k);
    L15:
        if ((this.f20173g & 16) != 16) goto L18;
        r4.a0(5, this.f20178l);
    L18:
        if ((this.f20173g & 32) != 32) goto L20;
        r4.S(6, this.m.d());
    L20:
        r4.i0(this.f20172f);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.o;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if ((this.f20173g & 1) != 1) goto L9;
        r1 = 0 + kotlin.s0.w.d.l0.i.f.o(1, this.f20174h);
    L9:
        if ((this.f20173g & 2) != 2) goto L12;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(2, this.f20175i);
    L12:
        if ((this.f20173g & 4) != 4) goto L15;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.h(3, this.f20176j.d());
    L15:
        if ((this.f20173g & 8) != 8) goto L18;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(4, this.f20177k);
    L18:
        if ((this.f20173g & 16) != 16) goto L21;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(5, this.f20178l);
    L21:
        if ((this.f20173g & 32) != 32) goto L23;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.h(6, this.m.d());
    L23:
        int r2 = r1 + this.f20172f.size();
        this.o = r2;
        return r2;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return P();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<v> h() {
        return q;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.n;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
        return false;
    L8:
        this.n = 1;
        return true;
    }
}

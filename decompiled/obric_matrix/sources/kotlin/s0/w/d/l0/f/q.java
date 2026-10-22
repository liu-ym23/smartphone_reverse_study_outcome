package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends kotlin.s0.w.d.l0.i.i.d<q> implements Object {
    private static final q y = null;
    public static kotlin.s0.w.d.l0.i.s<q> z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<b> f20102i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f20103j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f20104k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private q f20105l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private q r;
    private int s;
    private q t;
    private int u;
    private int v;
    private byte w;
    private int x;

    static class a extends kotlin.s0.w.d.l0.i.b<q> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public q m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new q(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {
        private static final b m = null;
        public static kotlin.s0.w.d.l0.i.s<b> n;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final kotlin.s0.w.d.l0.i.d f20106f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20107g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private c f20108h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private q f20109i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f20110j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private byte f20111k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f20112l;

        static class a extends kotlin.s0.w.d.l0.i.b<b> {
            a() {
            }

            @Override // kotlin.s0.w.d.l0.i.s
            public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
                return m(r1, r2);
            }

            public b m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
                return new b(r2, r3, null);
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.q$b$b, reason: collision with other inner class name */
        public static final class C0547b extends kotlin.s0.w.d.l0.i.i.b<b, C0547b> implements Object {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f20113g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private c f20114h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private q f20115i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private int f20116j;

            private C0547b() {
                this.f20114h = c.f20119i;
                this.f20115i = q.X();
                v();
            }

            static /* synthetic */ C0547b p() {
                return u();
            }

            private static C0547b u() {
                return new C0547b();
            }

            private void v() {
            }

            public C0547b B(c r2) {
                Objects.requireNonNull(r2);
                this.f20113g |= 1;
                this.f20114h = r2;
                return this;
            }

            public C0547b C(int r2) {
                this.f20113g |= 4;
                this.f20116j = r2;
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
                w((b) r1);
                return this;
            }

            public b q() {
                b r1 = r();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
            }

            public b r() {
                b r0 = new b(this, null);
                int r1 = this.f20113g;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                b.q(r0, this.f20114h);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                b.r(r0, this.f20115i);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                b.s(r0, this.f20116j);
                b.t(r0, r3);
                return r0;
            }

            public C0547b t() {
                C0547b r0 = u();
                r0.w(r());
                return r0;
            }

            public C0547b w(b r2) {
                if (r2 != b.v()) goto L6;
                return this;
            L6:
                if (r2.A() == false) goto L9;
                B(r2.w());
            L9:
                if (r2.B() == false) goto L12;
                z(r2.y());
            L12:
                if (r2.C() == false) goto L14;
                C(r2.z());
            L14:
                o(m().b(b.u(r2)));
                return this;
            }

            @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
                y(r1, r2);
                return this;
            }

            public C0547b y(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
                b r0 = null;
                b r5 = b.n.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
                if (r5 == null) goto L6;
                w(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                b r6 = (b) e.a();     // Catch: Throwable -> L7
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

            public C0547b z(q r4) {
                if ((this.f20113g & 2) == 2) goto L5;
            L7:
                this.f20115i = r4;
                this.f20113g |= 2;
                return this;
            L5:
                if (this.f20115i == q.X()) goto L7;
                r4 = q.y0(this.f20115i).F(r4).w();
                goto L7
            }
        }

        public static final enum c extends Enum<c> implements kotlin.s0.w.d.l0.i.j.a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final c f20117g = null;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final c f20118h = null;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final c f20119i = null;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final c f20120j = null;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private static final /* synthetic */ c[] f20121k = null;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final int f20122f;

            static {
                c r0 = new c("IN", 0, 0, 0);
                f20117g = r0;
                c r1 = new c("OUT", 1, 1, 1);
                f20118h = r1;
                c r3 = new c("INV", 2, 2, 2);
                f20119i = r3;
                c r5 = new c("STAR", 3, 3, 3);
                f20120j = r5;
                f20121k = new c[]{r0, r1, r3, r5};
            }

            private c(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.f20122f = r4;
            }

            public static c a(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return f20120j;
            L14:
                return f20119i;
            L16:
                return f20118h;
            L18:
                return f20117g;
            }

            public static c valueOf(String r1) {
                return (c) Enum.valueOf(c.class, r1);
            }

            public static c[] values() {
                return (c[]) f20121k.clone();
            }

            @Override // kotlin.s0.w.d.l0.i.j.a
            public final int d() {
                return this.f20122f;
            }
        }

        static {
            n = new a();
            b r0 = new b(true);
            m = r0;
            r0.D();
        }

        private b(kotlin.s0.w.d.l0.i.e r8, kotlin.s0.w.d.l0.i.g r9) {
            this.f20111k = -1;
            this.f20112l = -1;
            D();
            kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
            kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L57;
            int r4 = r8.K();     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            if (r4 == 0) goto L28;
            if (r4 != 8) goto L9;
            int r5 = r8.n();     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            c r6 = c.a(r5);     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            if (r6 == null) goto L25;
            this.f20107g |= 1;     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            this.f20108h = r6;     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            goto L3
        L25:
            r2.o0(r4);     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            r2.o0(r5);     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            goto L3
        L9:
            if (r4 != 18) goto L11;
            c r7 = null;
            if ((this.f20107g & 2) != 2) goto L19;
            r7 = this.f20109i.A0();     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
        L19:
            q r10 = (q) r8.u(q.z, r9);     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            this.f20109i = r10;     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            if (r7 == null) goto L22;
            r7.F(r10);     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            this.f20109i = r7.w();     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
        L22:
            this.f20107g |= 2;     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            goto L3
        L11:
            if (r4 != 24) goto L13;
            this.f20107g |= 4;     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            this.f20110j = r8.s();     // Catch: Throwable -> L29 IOException -> L31 kotlin.s0.w.d.l0.i.k -> L34
            goto L3
        L13:
            if (o(r8, r2, r9, r4) == true) goto L3;
        L28:
            r3 = true;
            goto L3
        L29:
            th = move-exception;
            r2.I();     // Catch: IOException -> L51 Throwable -> L39
        L39:
            th = move-exception;
            this.f20106f = r0.l();
            throw th;
        L38:
            this.f20106f = r0.l();
            l();
            throw th;
        L34:
            e = move-exception;
            e.i(this);     // Catch: Throwable -> L29
            throw e;     // Catch: Throwable -> L29
        L31:
            e = move-exception;
            kotlin.s0.w.d.l0.i.k r11 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L29
            r11.i(this);     // Catch: Throwable -> L29
            throw r11;     // Catch: Throwable -> L29
        L57:
            r2.I();     // Catch: IOException -> L52 Throwable -> L46
        L46:
            th = move-exception;
            this.f20106f = r0.l();
            throw th;
        L45:
            this.f20106f = r0.l();
            l();
        }

        /* synthetic */ b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
            this(r1, r2);
        }

        private b(kotlin.s0.w.d.l0.i.i.b r2) {
            super(r2);
            this.f20111k = -1;
            this.f20112l = -1;
            this.f20106f = r2.m();
        }

        /* synthetic */ b(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
            this(r1);
        }

        private b(boolean r1) {
            this.f20111k = -1;
            this.f20112l = -1;
            this.f20106f = kotlin.s0.w.d.l0.i.d.f20305f;
        }

        private void D() {
            this.f20108h = c.f20119i;
            this.f20109i = q.X();
            this.f20110j = 0;
        }

        public static C0547b E() {
            return C0547b.p();
        }

        public static C0547b F(b r1) {
            C0547b r0 = E();
            r0.w(r1);
            return r0;
        }

        static /* synthetic */ c q(b r0, c r1) {
            r0.f20108h = r1;
            return r1;
        }

        static /* synthetic */ q r(b r0, q r1) {
            r0.f20109i = r1;
            return r1;
        }

        static /* synthetic */ int s(b r0, int r1) {
            r0.f20110j = r1;
            return r1;
        }

        static /* synthetic */ int t(b r0, int r1) {
            r0.f20107g = r1;
            return r1;
        }

        static /* synthetic */ kotlin.s0.w.d.l0.i.d u(b r0) {
            return r0.f20106f;
        }

        public static b v() {
            return m;
        }

        public boolean A() {
            if ((this.f20107g & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean B() {
            if ((this.f20107g & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean C() {
            if ((this.f20107g & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public C0547b G() {
            return E();
        }

        public C0547b H() {
            return F(this);
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
            return H();
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public void d(kotlin.s0.w.d.l0.i.f r3) {
            e();
            if ((this.f20107g & 1) != 1) goto L6;
            r3.S(1, this.f20108h.d());
        L6:
            if ((this.f20107g & 2) != 2) goto L9;
            r3.d0(2, this.f20109i);
        L9:
            if ((this.f20107g & 4) != 4) goto L11;
            r3.a0(3, this.f20110j);
        L11:
            r3.i0(this.f20106f);
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public int e() {
            int r0 = this.f20112l;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            if ((this.f20107g & 1) != 1) goto L9;
            r1 = 0 + kotlin.s0.w.d.l0.i.f.h(1, this.f20108h.d());
        L9:
            if ((this.f20107g & 2) != 2) goto L12;
            r1 = r1 + kotlin.s0.w.d.l0.i.f.s(2, this.f20109i);
        L12:
            if ((this.f20107g & 4) != 4) goto L14;
            r1 = r1 + kotlin.s0.w.d.l0.i.f.o(3, this.f20110j);
        L14:
            int r2 = r1 + this.f20106f.size();
            this.f20112l = r2;
            return r2;
        }

        @Override // kotlin.s0.w.d.l0.i.q
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
            return G();
        }

        @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
        public kotlin.s0.w.d.l0.i.s<b> h() {
            return n;
        }

        @Override // kotlin.s0.w.d.l0.i.r
        public final boolean isInitialized() {
            byte r0 = this.f20111k;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (B() == true) goto L11;
        L14:
            this.f20111k = 1;
            return true;
        L11:
            if (y().isInitialized() == true) goto L14;
            this.f20111k = 0;
            return false;
        }

        public c w() {
            return this.f20108h;
        }

        public q y() {
            return this.f20109i;
        }

        public int z() {
            return this.f20110j;
        }
    }

    public static final class c extends kotlin.s0.w.d.l0.i.i.c<q, c> implements Object {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20123i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<b> f20124j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f20125k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f20126l;
        private q m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private q s;
        private int t;
        private q u;
        private int v;
        private int w;

        private c() {
            this.f20124j = Collections.emptyList();
            this.m = q.X();
            this.s = q.X();
            this.u = q.X();
            C();
        }

        private void B() {
            if ((this.f20123i & 1) == 1) goto L6;
            this.f20124j = new ArrayList(this.f20124j);
            this.f20123i |= 1;
            return;
        }

        private void C() {
        }

        static /* synthetic */ c u() {
            return z();
        }

        private static c z() {
            return new c();
        }

        public c D(q r4) {
            if ((this.f20123i & 2048) == 2048) goto L5;
        L7:
            this.u = r4;
            this.f20123i |= 2048;
            return this;
        L5:
            if (this.u == q.X()) goto L7;
            r4 = q.y0(this.u).F(r4).w();
            goto L7
        }

        public c E(q r4) {
            if ((this.f20123i & 8) == 8) goto L5;
        L7:
            this.m = r4;
            this.f20123i |= 8;
            return this;
        L5:
            if (this.m == q.X()) goto L7;
            r4 = q.y0(this.m).F(r4).w();
            goto L7
        }

        public c F(q r3) {
            if (r3 != q.X()) goto L6;
            return this;
        L6:
            if (q.A(r3).isEmpty() == true) goto L12;
            if (this.f20124j.isEmpty() == false) goto L10;
            this.f20124j = q.A(r3);
            this.f20123i &= -2;
            goto L12
        L10:
            B();
            this.f20124j.addAll(q.A(r3));
        L12:
            if (r3.q0() == false) goto L15;
            N(r3.d0());
        L15:
            if (r3.n0() == false) goto L18;
            L(r3.a0());
        L18:
            if (r3.o0() == false) goto L21;
            E(r3.b0());
        L21:
            if (r3.p0() == false) goto L24;
            M(r3.c0());
        L24:
            if (r3.l0() == false) goto L27;
            J(r3.W());
        L27:
            if (r3.u0() == false) goto L30;
            Q(r3.h0());
        L30:
            if (r3.v0() == false) goto L33;
            R(r3.i0());
        L33:
            if (r3.t0() == false) goto L36;
            P(r3.g0());
        L36:
            if (r3.r0() == false) goto L39;
            H(r3.e0());
        L39:
            if (r3.s0() == false) goto L42;
            O(r3.f0());
        L42:
            if (r3.j0() == false) goto L45;
            D(r3.R());
        L45:
            if (r3.k0() == false) goto L48;
            I(r3.S());
        L48:
            if (r3.m0() == false) goto L50;
            K(r3.Z());
        L50:
            t(r3);
            o(m().b(q.Q(r3)));
            return this;
        }

        public c G(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            q r0 = null;
            q r5 = q.z.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            F(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            q r6 = (q) e.a();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            F(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }

        public c H(q r4) {
            if ((this.f20123i & 512) == 512) goto L5;
        L7:
            this.s = r4;
            this.f20123i |= 512;
            return this;
        L5:
            if (this.s == q.X()) goto L7;
            r4 = q.y0(this.s).F(r4).w();
            goto L7
        }

        public c I(int r2) {
            this.f20123i |= 4096;
            this.v = r2;
            return this;
        }

        public c J(int r2) {
            this.f20123i |= 32;
            this.o = r2;
            return this;
        }

        public c K(int r2) {
            this.f20123i |= 8192;
            this.w = r2;
            return this;
        }

        public c L(int r2) {
            this.f20123i |= 4;
            this.f20126l = r2;
            return this;
        }

        public c M(int r2) {
            this.f20123i |= 16;
            this.n = r2;
            return this;
        }

        public c N(boolean r2) {
            this.f20123i |= 2;
            this.f20125k = r2;
            return this;
        }

        public c O(int r2) {
            this.f20123i |= 1024;
            this.t = r2;
            return this;
        }

        public c P(int r2) {
            this.f20123i |= 256;
            this.r = r2;
            return this;
        }

        public c Q(int r2) {
            this.f20123i |= 64;
            this.p = r2;
            return this;
        }

        public c R(int r2) {
            this.f20123i |= 128;
            this.q = r2;
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
            G(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return y();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            return F((q) r1);
        }

        public q v() {
            q r1 = w();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public q w() {
            q r0 = new q(this, null);
            int r1 = this.f20123i;
            int r3 = 1;
            if ((r1 & 1) != 1) goto L5;
            this.f20124j = Collections.unmodifiableList(this.f20124j);
            this.f20123i &= -2;
        L5:
            q.B(r0, this.f20124j);
            if ((r1 & 2) == 2) goto L9;
            r3 = 0;
        L9:
            q.C(r0, this.f20125k);
            if ((r1 & 4) != 4) goto L12;
            r3 = r3 | 2;
        L12:
            q.D(r0, this.f20126l);
            if ((r1 & 8) != 8) goto L15;
            r3 = r3 | 4;
        L15:
            q.E(r0, this.m);
            if ((r1 & 16) != 16) goto L18;
            r3 = r3 | 8;
        L18:
            q.F(r0, this.n);
            if ((r1 & 32) != 32) goto L21;
            r3 = r3 | 16;
        L21:
            q.G(r0, this.o);
            if ((r1 & 64) != 64) goto L24;
            r3 = r3 | 32;
        L24:
            q.H(r0, this.p);
            if ((r1 & 128) != 128) goto L27;
            r3 = r3 | 64;
        L27:
            q.I(r0, this.q);
            if ((r1 & 256) != 256) goto L30;
            r3 = r3 | 128;
        L30:
            q.J(r0, this.r);
            if ((r1 & 512) != 512) goto L33;
            r3 = r3 | 256;
        L33:
            q.K(r0, this.s);
            if ((r1 & 1024) != 1024) goto L36;
            r3 = r3 | 512;
        L36:
            q.L(r0, this.t);
            if ((r1 & 2048) != 2048) goto L39;
            r3 = r3 | 1024;
        L39:
            q.M(r0, this.u);
            if ((r1 & 4096) != 4096) goto L42;
            r3 = r3 | 2048;
        L42:
            q.N(r0, this.v);
            if ((r1 & 8192) != 8192) goto L45;
            r3 = r3 | 4096;
        L45:
            q.O(r0, this.w);
            q.P(r0, r3);
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            G(r1, r2);
            return this;
        }

        public c y() {
            c r0 = z();
            r0.F(w());
            return r0;
        }
    }

    static {
        z = new a();
        q r0 = new q(true);
        y = r0;
        r0.w0();
    }

    private q(kotlin.s0.w.d.l0.i.e r9, kotlin.s0.w.d.l0.i.g r10) {
        this.w = -1;
        this.x = -1;
        w0();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        boolean r4 = false;
    L3:
        if (r3 == true) goto L66;
        int r5 = r9.K();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        c r6 = null;
        switch(r5) {
            case 0: goto L44;
            case 8: goto L42;
            case 18: goto L39;
            case 24: goto L37;
            case 32: goto L36;
            case 42: goto L29;
            case 48: goto L28;
            case 56: goto L27;
            case 64: goto L26;
            case 72: goto L25;
            case 82: goto L18;
            case 88: goto L17;
            case 96: goto L16;
            case 106: goto L8;
            case 112: goto L7;
            default: goto L45;
        };     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
    L7:
        this.f20101h |= 2048;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.u = r9.s();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L3
    L8:
        int r7 = 1024;
        if ((this.f20101h & 1024) != 1024) goto L11;
        r6 = this.t.A0();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
    L11:
        q r8 = (q) r9.u(z, r10);     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.t = r8;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        if (r6 == null) goto L14;
        r6.F(r8);     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.t = r6.w();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
    L14:
        int r11 = this.f20101h;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
    L15:
        this.f20101h = r11 | r7;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L3
    L16:
        this.f20101h |= 128;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.q = r9.s();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L3
    L17:
        this.f20101h |= 512;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.s = r9.s();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L3
    L18:
        r7 = 256;
        if ((this.f20101h & 256) != 256) goto L21;
        r6 = this.r.A0();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
    L21:
        q r12 = (q) r9.u(z, r10);     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.r = r12;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        if (r6 == null) goto L24;
        r6.F(r12);     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.r = r6.w();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
    L24:
        r11 = this.f20101h;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L15
    L25:
        this.f20101h |= 64;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.p = r9.s();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L3
    L26:
        this.f20101h |= 8;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.m = r9.s();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L3
    L27:
        this.f20101h |= 32;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.o = r9.s();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L3
    L28:
        this.f20101h |= 16;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.n = r9.s();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L3
    L29:
        r7 = 4;
        if ((this.f20101h & 4) != 4) goto L32;
        r6 = this.f20105l.A0();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
    L32:
        q r13 = (q) r9.u(z, r10);     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.f20105l = r13;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        if (r6 == null) goto L35;
        r6.F(r13);     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.f20105l = r6.w();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
    L35:
        r11 = this.f20101h;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L15
    L36:
        this.f20101h |= 2;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.f20104k = r9.s();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L3
    L37:
        this.f20101h |= 1;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.f20103j = r9.k();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L3
    L39:
        if ((r4 & true) == true) goto L41;
        this.f20102i = new ArrayList();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        r4 = r4 | true;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
    L41:
        this.f20102i.add((b) r9.u(b.n, r10));     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        goto L3
    L42:
        this.f20101h |= 4096;     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
        this.v = r9.s();     // Catch: Throwable -> L47 IOException -> L49 kotlin.s0.w.d.l0.i.k -> L52
    L44:
        r3 = true;
        goto L3
    L45:
        if (o(r9, r2, r10, r5) == true) goto L3;
    L47:
        th = move-exception;
        if ((r4 & true) != true) goto L81;
        this.f20102i = Collections.unmodifiableList(this.f20102i);
    L81:
        r2.I();     // Catch: IOException -> L76 Throwable -> L60
    L60:
        th = move-exception;
        this.f20100g = r0.l();
        throw th;
    L59:
        this.f20100g = r0.l();
        l();
        throw th;
    L52:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L47
        throw e;     // Catch: Throwable -> L47
    L49:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r14 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L47
        r14.i(this);     // Catch: Throwable -> L47
        throw r14;     // Catch: Throwable -> L47
    L66:
        if ((r4 & true) != true) goto L79;
        this.f20102i = Collections.unmodifiableList(this.f20102i);
    L79:
        r2.I();     // Catch: IOException -> L75 Throwable -> L70
    L70:
        th = move-exception;
        this.f20100g = r0.l();
        throw th;
    L69:
        this.f20100g = r0.l();
        l();
    }

    /* synthetic */ q(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private q(kotlin.s0.w.d.l0.i.i.c<q, ?> r2) {
        super(r2);
        this.w = -1;
        this.x = -1;
        this.f20100g = r2.m();
    }

    /* synthetic */ q(kotlin.s0.w.d.l0.i.i.c r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private q(boolean r1) {
        this.w = -1;
        this.x = -1;
        this.f20100g = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ List A(q r0) {
        return r0.f20102i;
    }

    static /* synthetic */ List B(q r0, List r1) {
        r0.f20102i = r1;
        return r1;
    }

    static /* synthetic */ boolean C(q r0, boolean r1) {
        r0.f20103j = r1;
        return r1;
    }

    static /* synthetic */ int D(q r0, int r1) {
        r0.f20104k = r1;
        return r1;
    }

    static /* synthetic */ q E(q r0, q r1) {
        r0.f20105l = r1;
        return r1;
    }

    static /* synthetic */ int F(q r0, int r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ int G(q r0, int r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ int H(q r0, int r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ int I(q r0, int r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ int J(q r0, int r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ q K(q r0, q r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ int L(q r0, int r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ q M(q r0, q r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ int N(q r0, int r1) {
        r0.u = r1;
        return r1;
    }

    static /* synthetic */ int O(q r0, int r1) {
        r0.v = r1;
        return r1;
    }

    static /* synthetic */ int P(q r0, int r1) {
        r0.f20101h = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d Q(q r0) {
        return r0.f20100g;
    }

    public static q X() {
        return y;
    }

    private void w0() {
        this.f20102i = Collections.emptyList();
        this.f20103j = false;
        this.f20104k = 0;
        this.f20105l = X();
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = X();
        this.s = 0;
        this.t = X();
        this.u = 0;
        this.v = 0;
    }

    public static c x0() {
        return c.u();
    }

    public static c y0(q r1) {
        c r0 = x0();
        r0.F(r1);
        return r0;
    }

    public c A0() {
        return y0(this);
    }

    public q R() {
        return this.t;
    }

    public int S() {
        return this.u;
    }

    public b T(int r1) {
        return this.f20102i.get(r1);
    }

    public int U() {
        return this.f20102i.size();
    }

    public List<b> V() {
        return this.f20102i;
    }

    public int W() {
        return this.n;
    }

    public q Y() {
        return y;
    }

    public int Z() {
        return this.v;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q a() {
        return Y();
    }

    public int a0() {
        return this.f20104k;
    }

    public q b0() {
        return this.f20105l;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return A0();
    }

    public int c0() {
        return this.m;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r6) {
        e();
        kotlin.s0.w.d.l0.i.i.d<MessageType>.a r0 = y();
        if ((this.f20101h & 4096) != 4096) goto L5;
        r6.a0(1, this.v);
    L5:
        int r1 = 0;
    L7:
        if (r1 >= this.f20102i.size()) goto L10;
        r6.d0(2, this.f20102i.get(r1));
        r1 = r1 + 1;
        goto L7
    L10:
        if ((this.f20101h & 1) != 1) goto L13;
        r6.L(3, this.f20103j);
    L13:
        if ((this.f20101h & 2) != 2) goto L16;
        r6.a0(4, this.f20104k);
    L16:
        if ((this.f20101h & 4) != 4) goto L19;
        r6.d0(5, this.f20105l);
    L19:
        if ((this.f20101h & 16) != 16) goto L22;
        r6.a0(6, this.n);
    L22:
        if ((this.f20101h & 32) != 32) goto L25;
        r6.a0(7, this.o);
    L25:
        if ((this.f20101h & 8) != 8) goto L28;
        r6.a0(8, this.m);
    L28:
        if ((this.f20101h & 64) != 64) goto L31;
        r6.a0(9, this.p);
    L31:
        if ((this.f20101h & 256) != 256) goto L34;
        r6.d0(10, this.r);
    L34:
        if ((this.f20101h & 512) != 512) goto L37;
        r6.a0(11, this.s);
    L37:
        if ((this.f20101h & 128) != 128) goto L40;
        r6.a0(12, this.q);
    L40:
        if ((this.f20101h & 1024) != 1024) goto L43;
        r6.d0(13, this.t);
    L43:
        if ((this.f20101h & 2048) != 2048) goto L45;
        r6.a0(14, this.u);
    L45:
        r0.a(200, r6);
        r6.i0(this.f20100g);
    }

    public boolean d0() {
        return this.f20103j;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.x;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.f20101h & 4096) != 4096) goto L8;
        int r1 = kotlin.s0.w.d.l0.i.f.o(1, this.v) + 0;
    L10:
        if (r2 >= this.f20102i.size()) goto L13;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(2, this.f20102i.get(r2));
        r2 = r2 + 1;
        goto L10
    L13:
        if ((this.f20101h & 1) != 1) goto L16;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.a(3, this.f20103j);
    L16:
        if ((this.f20101h & 2) != 2) goto L19;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(4, this.f20104k);
    L19:
        if ((this.f20101h & 4) != 4) goto L22;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(5, this.f20105l);
    L22:
        if ((this.f20101h & 16) != 16) goto L25;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(6, this.n);
    L25:
        if ((this.f20101h & 32) != 32) goto L28;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(7, this.o);
    L28:
        if ((this.f20101h & 8) != 8) goto L31;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(8, this.m);
    L31:
        if ((this.f20101h & 64) != 64) goto L34;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(9, this.p);
    L34:
        if ((this.f20101h & 256) != 256) goto L37;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(10, this.r);
    L37:
        if ((this.f20101h & 512) != 512) goto L40;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(11, this.s);
    L40:
        if ((this.f20101h & 128) != 128) goto L43;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(12, this.q);
    L43:
        if ((this.f20101h & 1024) != 1024) goto L46;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(13, this.t);
    L46:
        if ((this.f20101h & 2048) != 2048) goto L48;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(14, this.u);
    L48:
        int r3 = (r1 + s()) + this.f20100g.size();
        this.x = r3;
        return r3;
    L8:
        r1 = 0;
        goto L10
    }

    public q e0() {
        return this.r;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return z0();
    }

    public int f0() {
        return this.s;
    }

    public int g0() {
        return this.q;
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<q> h() {
        return z;
    }

    public int h0() {
        return this.o;
    }

    public int i0() {
        return this.p;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.w;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= U()) goto L17;
        if (T(r1).isInitialized() == false) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        this.w = 0;
        return false;
    L17:
        if (o0() == false) goto L23;
        if (b0().isInitialized() == true) goto L23;
        this.w = 0;
        return false;
    L23:
        if (r0() == false) goto L29;
        if (e0().isInitialized() == true) goto L29;
        this.w = 0;
        return false;
    L29:
        if (j0() == false) goto L35;
        if (R().isInitialized() == true) goto L35;
        this.w = 0;
        return false;
    L35:
        if (r() == true) goto L38;
        this.w = 0;
        return false;
    L38:
        this.w = 1;
        return true;
    }

    public boolean j0() {
        if ((this.f20101h & 1024) != 1024) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean k0() {
        if ((this.f20101h & 2048) != 2048) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l0() {
        if ((this.f20101h & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean m0() {
        if ((this.f20101h & 4096) != 4096) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean n0() {
        if ((this.f20101h & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean o0() {
        if ((this.f20101h & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean p0() {
        if ((this.f20101h & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean q0() {
        if ((this.f20101h & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean r0() {
        if ((this.f20101h & 256) != 256) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean s0() {
        if ((this.f20101h & 512) != 512) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean t0() {
        if ((this.f20101h & 128) != 128) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean u0() {
        if ((this.f20101h & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean v0() {
        if ((this.f20101h & 64) != 64) goto L5;
        return true;
    L5:
        return false;
    }

    public c z0() {
        return x0();
    }
}

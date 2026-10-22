package kotlin.s0.w.d.l0.f;

import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends kotlin.s0.w.d.l0.i.i.d<c> implements Object {
    private static final c O = null;
    public static kotlin.s0.w.d.l0.i.s<c> P;
    private int A;
    private int B;
    private q C;
    private int D;
    private List<Integer> E;
    private int F;
    private List<q> G;
    private List<Integer> H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private t f19932J;
    private List<Integer> K;
    private w L;
    private byte M;
    private int N;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f19933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f19936j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f19937k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<s> f19938l;
    private List<q> m;
    private List<Integer> n;
    private int o;
    private List<Integer> p;
    private int q;
    private List<q> r;
    private List<Integer> s;
    private int t;
    private List<d> u;
    private List<i> v;
    private List<n> w;
    private List<r> x;
    private List<g> y;
    private List<Integer> z;

    static class a extends kotlin.s0.w.d.l0.i.b<c> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public c m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new c(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.c<c, b> implements Object {
        private int A;
        private List<Integer> B;
        private List<q> C;
        private List<Integer> D;
        private t E;
        private List<Integer> F;
        private w G;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f19939i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f19940j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f19941k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f19942l;
        private List<s> m;
        private List<q> n;
        private List<Integer> o;
        private List<Integer> p;
        private List<q> q;
        private List<Integer> r;
        private List<d> s;
        private List<i> t;
        private List<n> u;
        private List<r> v;
        private List<g> w;
        private List<Integer> x;
        private int y;
        private q z;

        private b() {
            this.f19940j = 6;
            this.m = Collections.emptyList();
            this.n = Collections.emptyList();
            this.o = Collections.emptyList();
            this.p = Collections.emptyList();
            this.q = Collections.emptyList();
            this.r = Collections.emptyList();
            this.s = Collections.emptyList();
            this.t = Collections.emptyList();
            this.u = Collections.emptyList();
            this.v = Collections.emptyList();
            this.w = Collections.emptyList();
            this.x = Collections.emptyList();
            this.z = q.X();
            this.B = Collections.emptyList();
            this.C = Collections.emptyList();
            this.D = Collections.emptyList();
            this.E = t.v();
            this.F = Collections.emptyList();
            this.G = w.t();
            R();
        }

        private void B() {
            if ((this.f19939i & 512) == 512) goto L6;
            this.s = new ArrayList(this.s);
            this.f19939i |= 512;
            return;
        }

        private void C() {
            if ((this.f19939i & 256) == 256) goto L6;
            this.r = new ArrayList(this.r);
            this.f19939i |= 256;
            return;
        }

        private void D() {
            if ((this.f19939i & 128) == 128) goto L6;
            this.q = new ArrayList(this.q);
            this.f19939i |= 128;
            return;
        }

        private void E() {
            if ((this.f19939i & 8192) == 8192) goto L6;
            this.w = new ArrayList(this.w);
            this.f19939i |= 8192;
            return;
        }

        private void F() {
            if ((this.f19939i & 1024) == 1024) goto L6;
            this.t = new ArrayList(this.t);
            this.f19939i |= 1024;
            return;
        }

        private void G() {
            if ((this.f19939i & 262144) == 262144) goto L6;
            this.B = new ArrayList(this.B);
            this.f19939i |= 262144;
            return;
        }

        private void H() {
            if ((this.f19939i & 1048576) == 1048576) goto L6;
            this.D = new ArrayList(this.D);
            this.f19939i |= 1048576;
            return;
        }

        private void I() {
            if ((this.f19939i & 524288) == 524288) goto L6;
            this.C = new ArrayList(this.C);
            this.f19939i |= 524288;
            return;
        }

        private void J() {
            if ((this.f19939i & 64) == 64) goto L6;
            this.p = new ArrayList(this.p);
            this.f19939i |= 64;
            return;
        }

        private void K() {
            if ((this.f19939i & 2048) == 2048) goto L6;
            this.u = new ArrayList(this.u);
            this.f19939i |= 2048;
            return;
        }

        private void L() {
            if ((this.f19939i & 16384) == 16384) goto L6;
            this.x = new ArrayList(this.x);
            this.f19939i |= 16384;
            return;
        }

        private void M() {
            if ((this.f19939i & 32) == 32) goto L6;
            this.o = new ArrayList(this.o);
            this.f19939i |= 32;
            return;
        }

        private void N() {
            if ((this.f19939i & 16) == 16) goto L6;
            this.n = new ArrayList(this.n);
            this.f19939i |= 16;
            return;
        }

        private void O() {
            if ((this.f19939i & 4096) == 4096) goto L6;
            this.v = new ArrayList(this.v);
            this.f19939i |= 4096;
            return;
        }

        private void P() {
            if ((this.f19939i & 8) == 8) goto L6;
            this.m = new ArrayList(this.m);
            this.f19939i |= 8;
            return;
        }

        private void Q() {
            if ((this.f19939i & 4194304) == 4194304) goto L6;
            this.F = new ArrayList(this.F);
            this.f19939i |= 4194304;
            return;
        }

        private void R() {
        }

        static /* synthetic */ b u() {
            return z();
        }

        private static b z() {
            return new b();
        }

        public b S(c r3) {
            if (r3 != c.y0()) goto L6;
            return this;
        L6:
            if (r3.l1() == false) goto L9;
            Y(r3.D0());
        L9:
            if (r3.m1() == false) goto L12;
            Z(r3.E0());
        L12:
            if (r3.k1() == false) goto L15;
            X(r3.q0());
        L15:
            if (c.a0(r3).isEmpty() == true) goto L21;
            if (this.m.isEmpty() == false) goto L19;
            this.m = c.a0(r3);
            this.f19939i &= -9;
            goto L21
        L19:
            P();
            this.m.addAll(c.a0(r3));
        L21:
            if (c.c0(r3).isEmpty() == true) goto L27;
            if (this.n.isEmpty() == false) goto L25;
            this.n = c.c0(r3);
            this.f19939i &= -17;
            goto L27
        L25:
            N();
            this.n.addAll(c.c0(r3));
        L27:
            if (c.e0(r3).isEmpty() == true) goto L33;
            if (this.o.isEmpty() == false) goto L31;
            this.o = c.e0(r3);
            this.f19939i &= -33;
            goto L33
        L31:
            M();
            this.o.addAll(c.e0(r3));
        L33:
            if (c.g0(r3).isEmpty() == true) goto L39;
            if (this.p.isEmpty() == false) goto L37;
            this.p = c.g0(r3);
            this.f19939i &= -65;
            goto L39
        L37:
            J();
            this.p.addAll(c.g0(r3));
        L39:
            if (c.i0(r3).isEmpty() == true) goto L45;
            if (this.q.isEmpty() == false) goto L43;
            this.q = c.i0(r3);
            this.f19939i &= -129;
            goto L45
        L43:
            D();
            this.q.addAll(c.i0(r3));
        L45:
            if (c.k0(r3).isEmpty() == true) goto L51;
            if (this.r.isEmpty() == false) goto L49;
            this.r = c.k0(r3);
            this.f19939i &= -257;
            goto L51
        L49:
            C();
            this.r.addAll(c.k0(r3));
        L51:
            if (c.m0(r3).isEmpty() == true) goto L57;
            if (this.s.isEmpty() == false) goto L55;
            this.s = c.m0(r3);
            this.f19939i &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            goto L57
        L55:
            B();
            this.s.addAll(c.m0(r3));
        L57:
            if (c.o0(r3).isEmpty() == true) goto L63;
            if (this.t.isEmpty() == false) goto L61;
            this.t = c.o0(r3);
            this.f19939i &= -1025;
            goto L63
        L61:
            F();
            this.t.addAll(c.o0(r3));
        L63:
            if (c.A(r3).isEmpty() == true) goto L69;
            if (this.u.isEmpty() == false) goto L67;
            this.u = c.A(r3);
            this.f19939i &= -2049;
            goto L69
        L67:
            K();
            this.u.addAll(c.A(r3));
        L69:
            if (c.C(r3).isEmpty() == true) goto L75;
            if (this.v.isEmpty() == false) goto L73;
            this.v = c.C(r3);
            this.f19939i &= -4097;
            goto L75
        L73:
            O();
            this.v.addAll(c.C(r3));
        L75:
            if (c.E(r3).isEmpty() == true) goto L81;
            if (this.w.isEmpty() == false) goto L79;
            this.w = c.E(r3);
            this.f19939i &= -8193;
            goto L81
        L79:
            E();
            this.w.addAll(c.E(r3));
        L81:
            if (c.G(r3).isEmpty() == true) goto L87;
            if (this.x.isEmpty() == false) goto L85;
            this.x = c.G(r3);
            this.f19939i &= -16385;
            goto L87
        L85:
            L();
            this.x.addAll(c.G(r3));
        L87:
            if (r3.n1() == false) goto L90;
            a0(r3.I0());
        L90:
            if (r3.o1() == false) goto L93;
            U(r3.J0());
        L93:
            if (r3.p1() == false) goto L96;
            b0(r3.K0());
        L96:
            if (c.L(r3).isEmpty() == true) goto L102;
            if (this.B.isEmpty() == false) goto L100;
            this.B = c.L(r3);
            this.f19939i &= -262145;
            goto L102
        L100:
            G();
            this.B.addAll(c.L(r3));
        L102:
            if (c.N(r3).isEmpty() == true) goto L108;
            if (this.C.isEmpty() == false) goto L106;
            this.C = c.N(r3);
            this.f19939i &= -524289;
            goto L108
        L106:
            I();
            this.C.addAll(c.N(r3));
        L108:
            if (c.P(r3).isEmpty() == true) goto L114;
            if (this.D.isEmpty() == false) goto L112;
            this.D = c.P(r3);
            this.f19939i &= -1048577;
            goto L114
        L112:
            H();
            this.D.addAll(c.P(r3));
        L114:
            if (r3.q1() == false) goto L117;
            V(r3.h1());
        L117:
            if (c.S(r3).isEmpty() == true) goto L123;
            if (this.F.isEmpty() == false) goto L121;
            this.F = c.S(r3);
            this.f19939i &= -4194305;
            goto L123
        L121:
            Q();
            this.F.addAll(c.S(r3));
        L123:
            if (r3.r1() == false) goto L125;
            W(r3.j1());
        L125:
            t(r3);
            o(m().b(c.W(r3)));
            return this;
        }

        public b T(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            c r0 = null;
            c r5 = c.P.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            S(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            c r6 = (c) e.a();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            S(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }

        public b U(q r4) {
            if ((this.f19939i & 65536) == 65536) goto L5;
        L7:
            this.z = r4;
            this.f19939i |= 65536;
            return this;
        L5:
            if (this.z == q.X()) goto L7;
            r4 = q.y0(this.z).F(r4).w();
            goto L7
        }

        public b V(t r4) {
            if ((this.f19939i & 2097152) == 2097152) goto L5;
        L7:
            this.E = r4;
            this.f19939i |= 2097152;
            return this;
        L5:
            if (this.E == t.v()) goto L7;
            t.b r0 = t.E(this.E);
            r0.y(r4);
            r4 = r0.r();
            goto L7
        }

        public b W(w r4) {
            if ((this.f19939i & 8388608) == 8388608) goto L5;
        L7:
            this.G = r4;
            this.f19939i |= 8388608;
            return this;
        L5:
            if (this.G == w.t()) goto L7;
            w.b r0 = w.z(this.G);
            r0.y(r4);
            r4 = r0.r();
            goto L7
        }

        public b X(int r2) {
            this.f19939i |= 4;
            this.f19942l = r2;
            return this;
        }

        public b Y(int r2) {
            this.f19939i |= 1;
            this.f19940j = r2;
            return this;
        }

        public b Z(int r2) {
            this.f19939i |= 2;
            this.f19941k = r2;
            return this;
        }

        public b a0(int r3) {
            this.f19939i |= 32768;
            this.y = r3;
            return this;
        }

        public b b0(int r3) {
            this.f19939i |= 131072;
            this.A = r3;
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
            T(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return y();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            S((c) r1);
            return this;
        }

        public c v() {
            c r1 = w();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public c w() {
            c r0 = new c(this, null);
            int r1 = this.f19939i;
            int r3 = 1;
            if ((r1 & 1) == 1) goto L6;
            r3 = 0;
        L6:
            c.X(r0, this.f19940j);
            if ((r1 & 2) != 2) goto L9;
            r3 = r3 | 2;
        L9:
            c.Y(r0, this.f19941k);
            if ((r1 & 4) != 4) goto L12;
            r3 = r3 | 4;
        L12:
            c.Z(r0, this.f19942l);
            if ((this.f19939i & 8) != 8) goto L15;
            this.m = Collections.unmodifiableList(this.m);
            this.f19939i &= -9;
        L15:
            c.b0(r0, this.m);
            if ((this.f19939i & 16) != 16) goto L18;
            this.n = Collections.unmodifiableList(this.n);
            this.f19939i &= -17;
        L18:
            c.d0(r0, this.n);
            if ((this.f19939i & 32) != 32) goto L21;
            this.o = Collections.unmodifiableList(this.o);
            this.f19939i &= -33;
        L21:
            c.f0(r0, this.o);
            if ((this.f19939i & 64) != 64) goto L24;
            this.p = Collections.unmodifiableList(this.p);
            this.f19939i &= -65;
        L24:
            c.h0(r0, this.p);
            if ((this.f19939i & 128) != 128) goto L27;
            this.q = Collections.unmodifiableList(this.q);
            this.f19939i &= -129;
        L27:
            c.j0(r0, this.q);
            if ((this.f19939i & 256) != 256) goto L30;
            this.r = Collections.unmodifiableList(this.r);
            this.f19939i &= -257;
        L30:
            c.l0(r0, this.r);
            if ((this.f19939i & 512) != 512) goto L33;
            this.s = Collections.unmodifiableList(this.s);
            this.f19939i &= NetError.ERR_TTNET_FT_INVALID_STREAM;
        L33:
            c.n0(r0, this.s);
            if ((this.f19939i & 1024) != 1024) goto L36;
            this.t = Collections.unmodifiableList(this.t);
            this.f19939i &= -1025;
        L36:
            c.p0(r0, this.t);
            if ((this.f19939i & 2048) != 2048) goto L39;
            this.u = Collections.unmodifiableList(this.u);
            this.f19939i &= -2049;
        L39:
            c.B(r0, this.u);
            if ((this.f19939i & 4096) != 4096) goto L42;
            this.v = Collections.unmodifiableList(this.v);
            this.f19939i &= -4097;
        L42:
            c.D(r0, this.v);
            if ((this.f19939i & 8192) != 8192) goto L45;
            this.w = Collections.unmodifiableList(this.w);
            this.f19939i &= -8193;
        L45:
            c.F(r0, this.w);
            if ((this.f19939i & 16384) != 16384) goto L48;
            this.x = Collections.unmodifiableList(this.x);
            this.f19939i &= -16385;
        L48:
            c.H(r0, this.x);
            if ((r1 & 32768) != 32768) goto L51;
            r3 = r3 | 8;
        L51:
            c.I(r0, this.y);
            if ((r1 & 65536) != 65536) goto L54;
            r3 = r3 | 16;
        L54:
            c.J(r0, this.z);
            if ((r1 & 131072) != 131072) goto L57;
            r3 = r3 | 32;
        L57:
            c.K(r0, this.A);
            if ((this.f19939i & 262144) != 262144) goto L60;
            this.B = Collections.unmodifiableList(this.B);
            this.f19939i &= -262145;
        L60:
            c.M(r0, this.B);
            if ((this.f19939i & 524288) != 524288) goto L63;
            this.C = Collections.unmodifiableList(this.C);
            this.f19939i &= -524289;
        L63:
            c.O(r0, this.C);
            if ((this.f19939i & 1048576) != 1048576) goto L66;
            this.D = Collections.unmodifiableList(this.D);
            this.f19939i &= -1048577;
        L66:
            c.Q(r0, this.D);
            if ((r1 & 2097152) != 2097152) goto L69;
            r3 = r3 | 64;
        L69:
            c.R(r0, this.E);
            if ((this.f19939i & 4194304) != 4194304) goto L72;
            this.F = Collections.unmodifiableList(this.F);
            this.f19939i &= -4194305;
        L72:
            c.T(r0, this.F);
            if ((r1 & 8388608) != 8388608) goto L75;
            r3 = r3 | 128;
        L75:
            c.U(r0, this.G);
            c.V(r0, r3);
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            T(r1, r2);
            return this;
        }

        public b y() {
            b r0 = z();
            r0.S(w());
            return r0;
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.c$c, reason: collision with other inner class name */
    public static final enum EnumC0545c extends Enum<EnumC0545c> implements kotlin.s0.w.d.l0.i.j.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0545c f19943g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0545c f19944h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0545c f19945i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final EnumC0545c f19946j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final EnumC0545c f19947k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final EnumC0545c f19948l = null;
        public static final EnumC0545c m = null;
        private static final /* synthetic */ EnumC0545c[] n = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f19949f;

        static {
            EnumC0545c r0 = new EnumC0545c("CLASS", 0, 0, 0);
            f19943g = r0;
            EnumC0545c r1 = new EnumC0545c("INTERFACE", 1, 1, 1);
            f19944h = r1;
            EnumC0545c r3 = new EnumC0545c("ENUM_CLASS", 2, 2, 2);
            f19945i = r3;
            EnumC0545c r5 = new EnumC0545c("ENUM_ENTRY", 3, 3, 3);
            f19946j = r5;
            EnumC0545c r7 = new EnumC0545c("ANNOTATION_CLASS", 4, 4, 4);
            f19947k = r7;
            EnumC0545c r9 = new EnumC0545c("OBJECT", 5, 5, 5);
            f19948l = r9;
            EnumC0545c r11 = new EnumC0545c("COMPANION_OBJECT", 6, 6, 6);
            m = r11;
            n = new EnumC0545c[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private EnumC0545c(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.f19949f = r4;
        }

        public static EnumC0545c valueOf(String r1) {
            return (EnumC0545c) Enum.valueOf(EnumC0545c.class, r1);
        }

        public static EnumC0545c[] values() {
            return (EnumC0545c[]) n.clone();
        }

        @Override // kotlin.s0.w.d.l0.i.j.a
        public final int d() {
            return this.f19949f;
        }
    }

    static {
        P = new a();
        c r0 = new c(true);
        O = r0;
        r0.s1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private c(kotlin.s0.w.d.l0.i.e r18, kotlin.s0.w.d.l0.i.g r19) {
        this.o = -1;
        this.q = -1;
        this.t = -1;
        this.A = -1;
        this.F = -1;
        this.I = -1;
        this.M = -1;
        this.N = -1;
        s1();
        kotlin.s0.w.d.l0.i.d.b r4 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r6 = kotlin.s0.w.d.l0.i.f.J(r4, 1);
        boolean r7 = false;
        int r8 = 0;
    L4:
        if (r7 == true) goto L229;
        int r15 = r18.K();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        Cloneable r16 = null;
        switch(r15) {
            case 0: goto L159;
            case 8: goto L157;
            case 16: goto L153;
            case 18: goto L144;
            case 24: goto L143;
            case 32: goto L142;
            case 42: goto L139;
            case 50: goto L135;
            case 56: goto L131;
            case 58: goto L122;
            case 66: goto L119;
            case 74: goto L115;
            case 82: goto L111;
            case 90: goto L107;
            case 106: goto L103;
            case 128: goto L99;
            case 130: goto L90;
            case 136: goto L89;
            case 146: goto L83;
            case 152: goto L81;
            case 162: goto L78;
            case 168: goto L74;
            case 170: goto L65;
            case 176: goto L62;
            case 178: goto L53;
            case 186: goto L49;
            case 192: goto L45;
            case 194: goto L35;
            case 242: goto L29;
            case 248: goto L25;
            case 250: goto L15;
            case 258: goto L9;
            default: goto L7;
        };     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L7:
        boolean r12 = true;
        if (o(r18, r6, r19, r15) == true) goto L4;
    L160:
        r7 = r12;
        goto L4
    L15:
        int r13 = r18.j(r18.A());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        if ((r8 & 4194304) == 4194304) goto L21;
        if (r18.e() <= 0) goto L21;
        this.K = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 4194304;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L21:
        if (r18.e() <= 0) goto L23;
        this.K.add(Integer.valueOf(r18.s()));     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L21
    L23:
        r18.i(r13);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L156:
        r12 = true;
        goto L4
    L35:
        int r11 = r18.j(r18.A());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        if ((r8 & 1048576) == 1048576) goto L41;
        if (r18.e() <= 0) goto L41;
        this.H = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 1048576;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L41:
        if (r18.e() <= 0) goto L43;
        this.H.add(Integer.valueOf(r18.s()));     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L43:
        r18.i(r11);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L156
    L53:
        r11 = r18.j(r18.A());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        if ((r8 & 262144) == 262144) goto L59;
        if (r18.e() <= 0) goto L59;
        this.E = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 262144;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L59:
        if (r18.e() <= 0) goto L43;
        this.E.add(Integer.valueOf(r18.s()));     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L59
    L65:
        r11 = r18.j(r18.A());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        if ((r8 & 256) == 256) goto L71;
        if (r18.e() <= 0) goto L71;
        this.s = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 256;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L71:
        if (r18.e() <= 0) goto L43;
        this.s.add(Integer.valueOf(r18.s()));     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L71
    L81:
        this.f19934h |= 32;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        this.D = r18.s();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L156
    L89:
        this.f19934h |= 8;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        this.B = r18.s();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L156
    L90:
        r11 = r18.j(r18.A());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        if ((r8 & 16384) == 16384) goto L96;
        if (r18.e() <= 0) goto L96;
        this.z = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 16384;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L96:
        if (r18.e() <= 0) goto L43;
        this.z.add(Integer.valueOf(r18.s()));     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L96
    L122:
        r11 = r18.j(r18.A());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        if ((r8 & 64) == 64) goto L128;
        if (r18.e() <= 0) goto L128;
        this.p = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 64;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L128:
        if (r18.e() <= 0) goto L43;
        this.p.add(Integer.valueOf(r18.s()));     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L128
    L142:
        this.f19934h |= 4;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        this.f19937k = r18.s();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L156
    L143:
        this.f19934h |= 2;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        this.f19936j = r18.s();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L156
    L144:
        r11 = r18.j(r18.A());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        if ((r8 & 32) == 32) goto L150;
        if (r18.e() <= 0) goto L150;
        this.n = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 32;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L150:
        if (r18.e() <= 0) goto L43;
        this.n.add(Integer.valueOf(r18.s()));     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L150
    L157:
        r12 = true;
        this.f19934h |= 1;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        this.f19935i = r18.s();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L4
    L159:
        r12 = true;
        goto L160
    L9:
        if ((this.f19934h & 128) != 128) goto L11;
        r16 = this.L.B();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L11:
        w.b r17 = r16;
        w r14 = (w) r18.u(w.f20196k, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        this.L = r14;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        if (r17 == 0) goto L14;
        r17.y(r14);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        this.L = r17.r();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L14:
        this.f19934h |= 128;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L156
    L25:
        if ((r8 & 4194304) == 4194304) goto L27;
        this.K = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 4194304;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L27:
        List r110 = this.K;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        Object r111 = Integer.valueOf(r18.s());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L52:
        r110.add(r111);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L156
    L29:
        if ((this.f19934h & 64) != 64) goto L31;
        r16 = this.f19932J.G();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L31:
        t.b r112 = r16;
        t r113 = (t) r18.u(t.m, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        this.f19932J = r113;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        if (r112 == 0) goto L34;
        r112.y(r113);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        this.f19932J = r112.r();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L34:
        this.f19934h |= 64;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L156
    L45:
        if ((r8 & 1048576) == 1048576) goto L47;
        this.H = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 1048576;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L47:
        r110 = this.H;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = Integer.valueOf(r18.s());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L49:
        if ((r8 & 524288) == 524288) goto L51;
        this.G = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 524288;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L51:
        r110 = this.G;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = r18.u(q.z, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L62:
        if ((r8 & 262144) == 262144) goto L64;
        this.E = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 262144;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L64:
        r110 = this.E;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = Integer.valueOf(r18.s());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L74:
        if ((r8 & 256) == 256) goto L76;
        this.s = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 256;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L76:
        r110 = this.s;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = Integer.valueOf(r18.s());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L78:
        if ((r8 & 128) == 128) goto L80;
        this.r = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 128;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L80:
        r110 = this.r;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = r18.u(q.z, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L83:
        if ((this.f19934h & 16) != 16) goto L85;
        r16 = this.C.A0();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L85:
        q.c r114 = r16;
        q r115 = (q) r18.u(q.z, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        this.C = r115;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        if (r114 == 0) goto L88;
        r114.F(r115);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        this.C = r114.w();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L88:
        this.f19934h |= 16;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L156
    L99:
        if ((r8 & 16384) == 16384) goto L101;
        this.z = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 16384;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L101:
        r110 = this.z;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = Integer.valueOf(r18.s());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L103:
        if ((r8 & 8192) == 8192) goto L105;
        this.y = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 8192;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L105:
        r110 = this.y;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = r18.u(g.m, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L107:
        if ((r8 & 4096) == 4096) goto L109;
        this.x = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 4096;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L109:
        r110 = this.x;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = r18.u(r.u, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L111:
        if ((r8 & 2048) == 2048) goto L113;
        this.w = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 2048;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L113:
        r110 = this.w;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = r18.u(n.A, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L115:
        if ((r8 & 1024) == 1024) goto L117;
        this.v = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 1024;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L117:
        r110 = this.v;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = r18.u(i.A, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L119:
        if ((r8 & 512) == 512) goto L121;
        this.u = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 512;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L121:
        r110 = this.u;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = r18.u(d.o, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L131:
        if ((r8 & 64) == 64) goto L133;
        this.p = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 64;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L133:
        r110 = this.p;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = Integer.valueOf(r18.s());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L135:
        if ((r8 & 16) == 16) goto L137;
        this.m = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 16;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L137:
        r110 = this.m;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = r18.u(q.z, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L139:
        if ((r8 & 8) == 8) goto L141;
        this.f19938l = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 8;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L141:
        r110 = this.f19938l;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = r18.u(s.s, r19);     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L153:
        if ((r8 & 32) == 32) goto L155;
        this.n = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r8 = r8 | 32;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
    L155:
        r110 = this.n;     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        r111 = Integer.valueOf(r18.s());     // Catch: Throwable -> L164 IOException -> L166 kotlin.s0.w.d.l0.i.k -> L170
        goto L52
    L164:
        th = move-exception;
        if ((r8 & 32) != 32) goto L177;
        this.n = Collections.unmodifiableList(this.n);
    L177:
        if ((r8 & 8) != 8) goto L180;
        this.f19938l = Collections.unmodifiableList(this.f19938l);
    L180:
        if ((r8 & 16) != 16) goto L183;
        this.m = Collections.unmodifiableList(this.m);
    L183:
        if ((r8 & 64) != 64) goto L186;
        this.p = Collections.unmodifiableList(this.p);
    L186:
        if ((r8 & 512) != 512) goto L189;
        this.u = Collections.unmodifiableList(this.u);
    L189:
        if ((r8 & 1024) != 1024) goto L192;
        this.v = Collections.unmodifiableList(this.v);
    L192:
        if ((r8 & 2048) != 2048) goto L195;
        this.w = Collections.unmodifiableList(this.w);
    L195:
        if ((r8 & 4096) != 4096) goto L198;
        this.x = Collections.unmodifiableList(this.x);
    L198:
        if ((r8 & 8192) != 8192) goto L201;
        this.y = Collections.unmodifiableList(this.y);
    L201:
        if ((r8 & 16384) != 16384) goto L204;
        this.z = Collections.unmodifiableList(this.z);
    L204:
        if ((r8 & 128) != 128) goto L207;
        this.r = Collections.unmodifiableList(this.r);
    L207:
        if ((r8 & 256) != 256) goto L210;
        this.s = Collections.unmodifiableList(this.s);
    L210:
        if ((r8 & 262144) != 262144) goto L213;
        this.E = Collections.unmodifiableList(this.E);
    L213:
        if ((r8 & 524288) != 524288) goto L216;
        this.G = Collections.unmodifiableList(this.G);
    L216:
        if ((r8 & 1048576) != 1048576) goto L219;
        this.H = Collections.unmodifiableList(this.H);
    L219:
        if ((r8 & 4194304) != 4194304) goto L289;
        this.K = Collections.unmodifiableList(this.K);
    L289:
        r6.I();     // Catch: IOException -> L284 Throwable -> L223
    L223:
        th = move-exception;
        this.f19933g = r4.l();
        throw th;
    L222:
        this.f19933g = r4.l();
        l();
        throw th;
    L170:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L164
        throw e;     // Catch: Throwable -> L164
    L166:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r3 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L164
        r3.i(this);     // Catch: Throwable -> L164
        throw r3;     // Catch: Throwable -> L164
    L229:
        if ((r8 & 32) != 32) goto L232;
        this.n = Collections.unmodifiableList(this.n);
    L232:
        if ((r8 & 8) != 8) goto L235;
        this.f19938l = Collections.unmodifiableList(this.f19938l);
    L235:
        if ((r8 & 16) != 16) goto L238;
        this.m = Collections.unmodifiableList(this.m);
    L238:
        if ((r8 & 64) != 64) goto L241;
        this.p = Collections.unmodifiableList(this.p);
    L241:
        if ((r8 & 512) != 512) goto L244;
        this.u = Collections.unmodifiableList(this.u);
    L244:
        if ((r8 & 1024) != 1024) goto L247;
        this.v = Collections.unmodifiableList(this.v);
    L247:
        if ((r8 & 2048) != 2048) goto L250;
        this.w = Collections.unmodifiableList(this.w);
    L250:
        if ((r8 & 4096) != 4096) goto L253;
        this.x = Collections.unmodifiableList(this.x);
    L253:
        if ((r8 & 8192) != 8192) goto L256;
        this.y = Collections.unmodifiableList(this.y);
    L256:
        if ((r8 & 16384) != 16384) goto L259;
        this.z = Collections.unmodifiableList(this.z);
    L259:
        if ((r8 & 128) != 128) goto L262;
        this.r = Collections.unmodifiableList(this.r);
    L262:
        if ((r8 & 256) != 256) goto L265;
        this.s = Collections.unmodifiableList(this.s);
    L265:
        if ((r8 & 262144) != 262144) goto L268;
        this.E = Collections.unmodifiableList(this.E);
    L268:
        if ((r8 & 524288) != 524288) goto L271;
        this.G = Collections.unmodifiableList(this.G);
    L271:
        if ((r8 & 1048576) != 1048576) goto L274;
        this.H = Collections.unmodifiableList(this.H);
    L274:
        if ((r8 & 4194304) != 4194304) goto L286;
        this.K = Collections.unmodifiableList(this.K);
    L286:
        r6.I();     // Catch: IOException -> L283 Throwable -> L278
    L278:
        th = move-exception;
        this.f19933g = r4.l();
        throw th;
    L277:
        this.f19933g = r4.l();
        l();
    }

    /* synthetic */ c(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private c(kotlin.s0.w.d.l0.i.i.c<c, ?> r2) {
        super(r2);
        this.o = -1;
        this.q = -1;
        this.t = -1;
        this.A = -1;
        this.F = -1;
        this.I = -1;
        this.M = -1;
        this.N = -1;
        this.f19933g = r2.m();
    }

    /* synthetic */ c(kotlin.s0.w.d.l0.i.i.c r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private c(boolean r1) {
        this.o = -1;
        this.q = -1;
        this.t = -1;
        this.A = -1;
        this.F = -1;
        this.I = -1;
        this.M = -1;
        this.N = -1;
        this.f19933g = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ List A(c r0) {
        return r0.w;
    }

    static /* synthetic */ List B(c r0, List r1) {
        r0.w = r1;
        return r1;
    }

    static /* synthetic */ List C(c r0) {
        return r0.x;
    }

    static /* synthetic */ List D(c r0, List r1) {
        r0.x = r1;
        return r1;
    }

    static /* synthetic */ List E(c r0) {
        return r0.y;
    }

    static /* synthetic */ List F(c r0, List r1) {
        r0.y = r1;
        return r1;
    }

    static /* synthetic */ List G(c r0) {
        return r0.z;
    }

    static /* synthetic */ List H(c r0, List r1) {
        r0.z = r1;
        return r1;
    }

    static /* synthetic */ int I(c r0, int r1) {
        r0.B = r1;
        return r1;
    }

    static /* synthetic */ q J(c r0, q r1) {
        r0.C = r1;
        return r1;
    }

    static /* synthetic */ int K(c r0, int r1) {
        r0.D = r1;
        return r1;
    }

    static /* synthetic */ List L(c r0) {
        return r0.E;
    }

    static /* synthetic */ List M(c r0, List r1) {
        r0.E = r1;
        return r1;
    }

    static /* synthetic */ List N(c r0) {
        return r0.G;
    }

    static /* synthetic */ List O(c r0, List r1) {
        r0.G = r1;
        return r1;
    }

    static /* synthetic */ List P(c r0) {
        return r0.H;
    }

    static /* synthetic */ List Q(c r0, List r1) {
        r0.H = r1;
        return r1;
    }

    static /* synthetic */ t R(c r0, t r1) {
        r0.f19932J = r1;
        return r1;
    }

    static /* synthetic */ List S(c r0) {
        return r0.K;
    }

    static /* synthetic */ List T(c r0, List r1) {
        r0.K = r1;
        return r1;
    }

    static /* synthetic */ w U(c r0, w r1) {
        r0.L = r1;
        return r1;
    }

    static /* synthetic */ int V(c r0, int r1) {
        r0.f19934h = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d W(c r0) {
        return r0.f19933g;
    }

    static /* synthetic */ int X(c r0, int r1) {
        r0.f19935i = r1;
        return r1;
    }

    static /* synthetic */ int Y(c r0, int r1) {
        r0.f19936j = r1;
        return r1;
    }

    static /* synthetic */ int Z(c r0, int r1) {
        r0.f19937k = r1;
        return r1;
    }

    static /* synthetic */ List a0(c r0) {
        return r0.f19938l;
    }

    static /* synthetic */ List b0(c r0, List r1) {
        r0.f19938l = r1;
        return r1;
    }

    static /* synthetic */ List c0(c r0) {
        return r0.m;
    }

    static /* synthetic */ List d0(c r0, List r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ List e0(c r0) {
        return r0.n;
    }

    static /* synthetic */ List f0(c r0, List r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ List g0(c r0) {
        return r0.p;
    }

    static /* synthetic */ List h0(c r0, List r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ List i0(c r0) {
        return r0.r;
    }

    static /* synthetic */ List j0(c r0, List r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ List k0(c r0) {
        return r0.s;
    }

    static /* synthetic */ List l0(c r0, List r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ List m0(c r0) {
        return r0.u;
    }

    static /* synthetic */ List n0(c r0, List r1) {
        r0.u = r1;
        return r1;
    }

    static /* synthetic */ List o0(c r0) {
        return r0.v;
    }

    static /* synthetic */ List p0(c r0, List r1) {
        r0.v = r1;
        return r1;
    }

    private void s1() {
        this.f19935i = 6;
        this.f19936j = 0;
        this.f19937k = 0;
        this.f19938l = Collections.emptyList();
        this.m = Collections.emptyList();
        this.n = Collections.emptyList();
        this.p = Collections.emptyList();
        this.r = Collections.emptyList();
        this.s = Collections.emptyList();
        this.u = Collections.emptyList();
        this.v = Collections.emptyList();
        this.w = Collections.emptyList();
        this.x = Collections.emptyList();
        this.y = Collections.emptyList();
        this.z = Collections.emptyList();
        this.B = 0;
        this.C = q.X();
        this.D = 0;
        this.E = Collections.emptyList();
        this.G = Collections.emptyList();
        this.H = Collections.emptyList();
        this.f19932J = t.v();
        this.K = Collections.emptyList();
        this.L = w.t();
    }

    public static b t1() {
        return b.u();
    }

    public static b u1(c r1) {
        b r0 = t1();
        r0.S(r1);
        return r0;
    }

    public static c w1(InputStream r1, kotlin.s0.w.d.l0.i.g r2) {
        return P.a(r1, r2);
    }

    public static c y0() {
        return O;
    }

    public g A0(int r1) {
        return this.y.get(r1);
    }

    public int B0() {
        return this.y.size();
    }

    public List<g> C0() {
        return this.y;
    }

    public int D0() {
        return this.f19935i;
    }

    public int E0() {
        return this.f19936j;
    }

    public i F0(int r1) {
        return this.v.get(r1);
    }

    public int G0() {
        return this.v.size();
    }

    public List<i> H0() {
        return this.v;
    }

    public int I0() {
        return this.B;
    }

    public q J0() {
        return this.C;
    }

    public int K0() {
        return this.D;
    }

    public int L0() {
        return this.E.size();
    }

    public List<Integer> M0() {
        return this.E;
    }

    public q N0(int r1) {
        return this.G.get(r1);
    }

    public int O0() {
        return this.G.size();
    }

    public int P0() {
        return this.H.size();
    }

    public List<Integer> Q0() {
        return this.H;
    }

    public List<q> R0() {
        return this.G;
    }

    public List<Integer> S0() {
        return this.p;
    }

    public n T0(int r1) {
        return this.w.get(r1);
    }

    public int U0() {
        return this.w.size();
    }

    public List<n> V0() {
        return this.w;
    }

    public List<Integer> W0() {
        return this.z;
    }

    public q X0(int r1) {
        return this.m.get(r1);
    }

    public int Y0() {
        return this.m.size();
    }

    public List<Integer> Z0() {
        return this.n;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q a() {
        return z0();
    }

    public List<q> a1() {
        return this.m;
    }

    public r b1(int r1) {
        return this.x.get(r1);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return x1();
    }

    public int c1() {
        return this.x.size();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r8) {
        e();
        kotlin.s0.w.d.l0.i.i.d<MessageType>.a r0 = y();
        if ((this.f19934h & 1) != 1) goto L6;
        r8.a0(1, this.f19935i);
    L6:
        if (Z0().size() <= 0) goto L8;
        r8.o0(18);
        r8.o0(this.o);
    L8:
        int r1 = 0;
        int r3 = 0;
    L10:
        if (r3 >= this.n.size()) goto L13;
        r8.b0(this.n.get(r3).intValue());
        r3 = r3 + 1;
        goto L10
    L13:
        if ((this.f19934h & 2) != 2) goto L16;
        r8.a0(3, this.f19936j);
    L16:
        if ((this.f19934h & 4) != 4) goto L18;
        r8.a0(4, this.f19937k);
    L18:
        int r4 = 0;
    L20:
        if (r4 >= this.f19938l.size()) goto L22;
        r8.d0(5, this.f19938l.get(r4));
        r4 = r4 + 1;
        goto L20
    L22:
        int r5 = 0;
    L24:
        if (r5 >= this.m.size()) goto L27;
        r8.d0(6, this.m.get(r5));
        r5 = r5 + 1;
        goto L24
    L27:
        if (S0().size() <= 0) goto L29;
        r8.o0(58);
        r8.o0(this.q);
    L29:
        int r6 = 0;
    L31:
        if (r6 >= this.p.size()) goto L33;
        r8.b0(this.p.get(r6).intValue());
        r6 = r6 + 1;
        goto L31
    L33:
        int r7 = 0;
    L35:
        if (r7 >= this.u.size()) goto L37;
        r8.d0(8, this.u.get(r7));
        r7 = r7 + 1;
        goto L35
    L37:
        int r9 = 0;
    L39:
        if (r9 >= this.v.size()) goto L41;
        r8.d0(9, this.v.get(r9));
        r9 = r9 + 1;
        goto L39
    L41:
        int r10 = 0;
    L43:
        if (r10 >= this.w.size()) goto L45;
        r8.d0(10, this.w.get(r10));
        r10 = r10 + 1;
        goto L43
    L45:
        int r11 = 0;
    L47:
        if (r11 >= this.x.size()) goto L49;
        r8.d0(11, this.x.get(r11));
        r11 = r11 + 1;
        goto L47
    L49:
        int r12 = 0;
    L51:
        if (r12 >= this.y.size()) goto L54;
        r8.d0(13, this.y.get(r12));
        r12 = r12 + 1;
        goto L51
    L54:
        if (W0().size() <= 0) goto L56;
        r8.o0(130);
        r8.o0(this.A);
    L56:
        int r13 = 0;
    L58:
        if (r13 >= this.z.size()) goto L61;
        r8.b0(this.z.get(r13).intValue());
        r13 = r13 + 1;
        goto L58
    L61:
        if ((this.f19934h & 8) != 8) goto L64;
        r8.a0(17, this.B);
    L64:
        if ((this.f19934h & 16) != 16) goto L67;
        r8.d0(18, this.C);
    L67:
        if ((this.f19934h & 32) != 32) goto L69;
        r8.a0(19, this.D);
    L69:
        int r2 = 0;
    L71:
        if (r2 >= this.r.size()) goto L74;
        r8.d0(20, this.r.get(r2));
        r2 = r2 + 1;
        goto L71
    L74:
        if (w0().size() <= 0) goto L76;
        r8.o0(170);
        r8.o0(this.t);
    L76:
        int r14 = 0;
    L78:
        if (r14 >= this.s.size()) goto L81;
        r8.b0(this.s.get(r14).intValue());
        r14 = r14 + 1;
        goto L78
    L81:
        if (M0().size() <= 0) goto L83;
        r8.o0(178);
        r8.o0(this.F);
    L83:
        int r15 = 0;
    L85:
        if (r15 >= this.E.size()) goto L87;
        r8.b0(this.E.get(r15).intValue());
        r15 = r15 + 1;
        goto L85
    L87:
        int r16 = 0;
    L89:
        if (r16 >= this.G.size()) goto L92;
        r8.d0(23, this.G.get(r16));
        r16 = r16 + 1;
        goto L89
    L92:
        if (Q0().size() <= 0) goto L94;
        r8.o0(194);
        r8.o0(this.I);
    L94:
        int r17 = 0;
    L96:
        if (r17 >= this.H.size()) goto L99;
        r8.b0(this.H.get(r17).intValue());
        r17 = r17 + 1;
        goto L96
    L99:
        if ((this.f19934h & 64) != 64) goto L102;
        r8.d0(30, this.f19932J);
    L102:
        if (r1 >= this.K.size()) goto L105;
        r8.a0(31, this.K.get(r1).intValue());
        r1 = r1 + 1;
        goto L102
    L105:
        if ((this.f19934h & 128) != 128) goto L107;
        r8.d0(32, this.L);
    L107:
        r0.a(19000, r8);
        r8.i0(this.f19933g);
    }

    public List<r> d1() {
        return this.x;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.N;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.f19934h & 1) != 1) goto L8;
        int r1 = kotlin.s0.w.d.l0.i.f.o(1, this.f19935i) + 0;
    L9:
        int r3 = 0;
        int r4 = 0;
    L11:
        if (r3 >= this.n.size()) goto L13;
        r4 = r4 + kotlin.s0.w.d.l0.i.f.p(this.n.get(r3).intValue());
        r3 = r3 + 1;
        goto L11
    L13:
        int r5 = r1 + r4;
        if (Z0().isEmpty() == true) goto L16;
        r5 = (r5 + 1) + kotlin.s0.w.d.l0.i.f.p(r4);
    L16:
        this.o = r4;
        if ((this.f19934h & 2) != 2) goto L20;
        r5 = r5 + kotlin.s0.w.d.l0.i.f.o(3, this.f19936j);
    L20:
        if ((this.f19934h & 4) != 4) goto L22;
        r5 = r5 + kotlin.s0.w.d.l0.i.f.o(4, this.f19937k);
    L22:
        int r6 = 0;
    L24:
        if (r6 >= this.f19938l.size()) goto L26;
        r5 = r5 + kotlin.s0.w.d.l0.i.f.s(5, this.f19938l.get(r6));
        r6 = r6 + 1;
        goto L24
    L26:
        int r7 = 0;
    L28:
        if (r7 >= this.m.size()) goto L30;
        r5 = r5 + kotlin.s0.w.d.l0.i.f.s(6, this.m.get(r7));
        r7 = r7 + 1;
        goto L28
    L30:
        int r8 = 0;
        int r9 = 0;
    L32:
        if (r8 >= this.p.size()) goto L34;
        r9 = r9 + kotlin.s0.w.d.l0.i.f.p(this.p.get(r8).intValue());
        r8 = r8 + 1;
        goto L32
    L34:
        int r10 = r5 + r9;
        if (S0().isEmpty() == true) goto L37;
        r10 = (r10 + 1) + kotlin.s0.w.d.l0.i.f.p(r9);
    L37:
        this.q = r9;
        int r11 = 0;
    L39:
        if (r11 >= this.u.size()) goto L41;
        r10 = r10 + kotlin.s0.w.d.l0.i.f.s(8, this.u.get(r11));
        r11 = r11 + 1;
        goto L39
    L41:
        int r12 = 0;
    L43:
        if (r12 >= this.v.size()) goto L45;
        r10 = r10 + kotlin.s0.w.d.l0.i.f.s(9, this.v.get(r12));
        r12 = r12 + 1;
        goto L43
    L45:
        int r13 = 0;
    L47:
        if (r13 >= this.w.size()) goto L49;
        r10 = r10 + kotlin.s0.w.d.l0.i.f.s(10, this.w.get(r13));
        r13 = r13 + 1;
        goto L47
    L49:
        int r14 = 0;
    L51:
        if (r14 >= this.x.size()) goto L53;
        r10 = r10 + kotlin.s0.w.d.l0.i.f.s(11, this.x.get(r14));
        r14 = r14 + 1;
        goto L51
    L53:
        int r15 = 0;
    L55:
        if (r15 >= this.y.size()) goto L57;
        r10 = r10 + kotlin.s0.w.d.l0.i.f.s(13, this.y.get(r15));
        r15 = r15 + 1;
        goto L55
    L57:
        int r16 = 0;
        int r17 = 0;
    L59:
        if (r16 >= this.z.size()) goto L61;
        r17 = r17 + kotlin.s0.w.d.l0.i.f.p(this.z.get(r16).intValue());
        r16 = r16 + 1;
        goto L59
    L61:
        int r18 = r10 + r17;
        if (W0().isEmpty() == true) goto L64;
        r18 = (r18 + 2) + kotlin.s0.w.d.l0.i.f.p(r17);
    L64:
        this.A = r17;
        if ((this.f19934h & 8) != 8) goto L68;
        r18 = r18 + kotlin.s0.w.d.l0.i.f.o(17, this.B);
    L68:
        if ((this.f19934h & 16) != 16) goto L71;
        r18 = r18 + kotlin.s0.w.d.l0.i.f.s(18, this.C);
    L71:
        if ((this.f19934h & 32) != 32) goto L73;
        r18 = r18 + kotlin.s0.w.d.l0.i.f.o(19, this.D);
    L73:
        int r19 = 0;
    L75:
        if (r19 >= this.r.size()) goto L77;
        r18 = r18 + kotlin.s0.w.d.l0.i.f.s(20, this.r.get(r19));
        r19 = r19 + 1;
        goto L75
    L77:
        int r20 = 0;
        int r21 = 0;
    L79:
        if (r20 >= this.s.size()) goto L81;
        r21 = r21 + kotlin.s0.w.d.l0.i.f.p(this.s.get(r20).intValue());
        r20 = r20 + 1;
        goto L79
    L81:
        int r22 = r18 + r21;
        if (w0().isEmpty() == true) goto L84;
        r22 = (r22 + 2) + kotlin.s0.w.d.l0.i.f.p(r21);
    L84:
        this.t = r21;
        int r23 = 0;
        int r24 = 0;
    L86:
        if (r23 >= this.E.size()) goto L88;
        r24 = r24 + kotlin.s0.w.d.l0.i.f.p(this.E.get(r23).intValue());
        r23 = r23 + 1;
        goto L86
    L88:
        int r25 = r22 + r24;
        if (M0().isEmpty() == true) goto L91;
        r25 = (r25 + 2) + kotlin.s0.w.d.l0.i.f.p(r24);
    L91:
        this.F = r24;
        int r26 = 0;
    L93:
        if (r26 >= this.G.size()) goto L95;
        r25 = r25 + kotlin.s0.w.d.l0.i.f.s(23, this.G.get(r26));
        r26 = r26 + 1;
        goto L93
    L95:
        int r27 = 0;
        int r28 = 0;
    L97:
        if (r27 >= this.H.size()) goto L99;
        r28 = r28 + kotlin.s0.w.d.l0.i.f.p(this.H.get(r27).intValue());
        r27 = r27 + 1;
        goto L97
    L99:
        int r29 = r25 + r28;
        if (Q0().isEmpty() == true) goto L102;
        r29 = (r29 + 2) + kotlin.s0.w.d.l0.i.f.p(r28);
    L102:
        this.I = r28;
        if ((this.f19934h & 64) != 64) goto L105;
        r29 = r29 + kotlin.s0.w.d.l0.i.f.s(30, this.f19932J);
    L105:
        int r30 = 0;
    L107:
        if (r2 >= this.K.size()) goto L109;
        r30 = r30 + kotlin.s0.w.d.l0.i.f.p(this.K.get(r2).intValue());
        r2 = r2 + 1;
        goto L107
    L109:
        int r31 = (r29 + r30) + (i1().size() * 2);
        if ((this.f19934h & 128) != 128) goto L112;
        r31 = r31 + kotlin.s0.w.d.l0.i.f.s(32, this.L);
    L112:
        int r32 = (r31 + s()) + this.f19933g.size();
        this.N = r32;
        return r32;
    L8:
        r1 = 0;
        goto L9
    }

    public s e1(int r1) {
        return this.f19938l.get(r1);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return v1();
    }

    public int f1() {
        return this.f19938l.size();
    }

    public List<s> g1() {
        return this.f19938l;
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<c> h() {
        return P;
    }

    public t h1() {
        return this.f19932J;
    }

    public List<Integer> i1() {
        return this.K;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.M;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (m1() == true) goto L12;
        this.M = 0;
        return false;
    L12:
        int r1 = 0;
    L14:
        if (r1 >= f1()) goto L20;
        if (e1(r1).isInitialized() == false) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        this.M = 0;
        return false;
    L20:
        int r2 = 0;
    L22:
        if (r2 >= Y0()) goto L28;
        if (X0(r2).isInitialized() == false) goto L25;
        r2 = r2 + 1;
        goto L22
    L25:
        this.M = 0;
        return false;
    L28:
        int r3 = 0;
    L30:
        if (r3 >= v0()) goto L36;
        if (u0(r3).isInitialized() == false) goto L33;
        r3 = r3 + 1;
        goto L30
    L33:
        this.M = 0;
        return false;
    L36:
        int r4 = 0;
    L38:
        if (r4 >= s0()) goto L44;
        if (r0(r4).isInitialized() == false) goto L41;
        r4 = r4 + 1;
        goto L38
    L41:
        this.M = 0;
        return false;
    L44:
        int r5 = 0;
    L46:
        if (r5 >= G0()) goto L52;
        if (F0(r5).isInitialized() == false) goto L49;
        r5 = r5 + 1;
        goto L46
    L49:
        this.M = 0;
        return false;
    L52:
        int r6 = 0;
    L54:
        if (r6 >= U0()) goto L60;
        if (T0(r6).isInitialized() == false) goto L57;
        r6 = r6 + 1;
        goto L54
    L57:
        this.M = 0;
        return false;
    L60:
        int r7 = 0;
    L62:
        if (r7 >= c1()) goto L68;
        if (b1(r7).isInitialized() == false) goto L65;
        r7 = r7 + 1;
        goto L62
    L65:
        this.M = 0;
        return false;
    L68:
        int r8 = 0;
    L70:
        if (r8 >= B0()) goto L77;
        if (A0(r8).isInitialized() == false) goto L73;
        r8 = r8 + 1;
        goto L70
    L73:
        this.M = 0;
        return false;
    L77:
        if (o1() == true) goto L79;
    L82:
        int r9 = 0;
    L84:
        if (r9 >= O0()) goto L91;
        if (N0(r9).isInitialized() == false) goto L87;
        r9 = r9 + 1;
        goto L84
    L87:
        this.M = 0;
        return false;
    L91:
        if (q1() == false) goto L97;
        if (h1().isInitialized() == true) goto L97;
        this.M = 0;
        return false;
    L97:
        if (r() == true) goto L100;
        this.M = 0;
        return false;
    L100:
        this.M = 1;
        return true;
    L79:
        if (J0().isInitialized() == true) goto L82;
        this.M = 0;
        return false;
    }

    public w j1() {
        return this.L;
    }

    public boolean k1() {
        if ((this.f19934h & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l1() {
        if ((this.f19934h & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean m1() {
        if ((this.f19934h & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean n1() {
        if ((this.f19934h & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean o1() {
        if ((this.f19934h & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean p1() {
        if ((this.f19934h & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public int q0() {
        return this.f19937k;
    }

    public boolean q1() {
        if ((this.f19934h & 64) != 64) goto L5;
        return true;
    L5:
        return false;
    }

    public d r0(int r1) {
        return this.u.get(r1);
    }

    public boolean r1() {
        if ((this.f19934h & 128) != 128) goto L5;
        return true;
    L5:
        return false;
    }

    public int s0() {
        return this.u.size();
    }

    public List<d> t0() {
        return this.u;
    }

    public q u0(int r1) {
        return this.r.get(r1);
    }

    public int v0() {
        return this.r.size();
    }

    public b v1() {
        return t1();
    }

    public List<Integer> w0() {
        return this.s;
    }

    public List<q> x0() {
        return this.r;
    }

    public b x1() {
        return u1(this);
    }

    public c z0() {
        return O;
    }
}

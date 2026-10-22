package kotlin.s0.w.d.l0.f;

import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends kotlin.s0.w.d.l0.i.i.d<n> implements Object {
    public static kotlin.s0.w.d.l0.i.s<n> A;
    private static final n z = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f20062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private q f20063l;
    private int m;
    private List<s> n;
    private q o;
    private int p;
    private List<q> q;
    private List<Integer> r;
    private int s;
    private u t;
    private int u;
    private int v;
    private List<Integer> w;
    private byte x;
    private int y;

    static class a extends kotlin.s0.w.d.l0.i.b<n> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public n m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new n(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.c<n, b> implements Object {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20064i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f20065j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f20066k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f20067l;
        private q m;
        private int n;
        private List<s> o;
        private q p;
        private int q;
        private List<q> r;
        private List<Integer> s;
        private u t;
        private int u;
        private int v;
        private List<Integer> w;

        private b() {
            this.f20065j = 518;
            this.f20066k = 2054;
            this.m = q.X();
            this.o = Collections.emptyList();
            this.p = q.X();
            this.r = Collections.emptyList();
            this.s = Collections.emptyList();
            this.t = u.I();
            this.w = Collections.emptyList();
            F();
        }

        private void B() {
            if ((this.f20064i & 512) == 512) goto L6;
            this.s = new ArrayList(this.s);
            this.f20064i |= 512;
            return;
        }

        private void C() {
            if ((this.f20064i & 256) == 256) goto L6;
            this.r = new ArrayList(this.r);
            this.f20064i |= 256;
            return;
        }

        private void D() {
            if ((this.f20064i & 32) == 32) goto L6;
            this.o = new ArrayList(this.o);
            this.f20064i |= 32;
            return;
        }

        private void E() {
            if ((this.f20064i & 8192) == 8192) goto L6;
            this.w = new ArrayList(this.w);
            this.f20064i |= 8192;
            return;
        }

        private void F() {
        }

        static /* synthetic */ b u() {
            return z();
        }

        private static b z() {
            return new b();
        }

        public b G(n r3) {
            if (r3 != n.Y()) goto L6;
            return this;
        L6:
            if (r3.o0() == false) goto L9;
            L(r3.a0());
        L9:
            if (r3.r0() == false) goto L12;
            O(r3.d0());
        L12:
            if (r3.q0() == false) goto L15;
            N(r3.c0());
        L15:
            if (r3.u0() == false) goto L18;
            J(r3.g0());
        L18:
            if (r3.v0() == false) goto L21;
            Q(r3.h0());
        L21:
            if (n.F(r3).isEmpty() == true) goto L27;
            if (this.o.isEmpty() == false) goto L25;
            this.o = n.F(r3);
            this.f20064i &= -33;
            goto L27
        L25:
            D();
            this.o.addAll(n.F(r3));
        L27:
            if (r3.s0() == false) goto L30;
            I(r3.e0());
        L30:
            if (r3.t0() == false) goto L33;
            P(r3.f0());
        L33:
            if (n.J(r3).isEmpty() == true) goto L39;
            if (this.r.isEmpty() == false) goto L37;
            this.r = n.J(r3);
            this.f20064i &= -257;
            goto L39
        L37:
            C();
            this.r.addAll(n.J(r3));
        L39:
            if (n.L(r3).isEmpty() == true) goto L45;
            if (this.s.isEmpty() == false) goto L43;
            this.s = n.L(r3);
            this.f20064i &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            goto L45
        L43:
            B();
            this.s.addAll(n.L(r3));
        L45:
            if (r3.x0() == false) goto L48;
            K(r3.j0());
        L48:
            if (r3.p0() == false) goto L51;
            M(r3.b0());
        L51:
            if (r3.w0() == false) goto L54;
            R(r3.i0());
        L54:
            if (n.Q(r3).isEmpty() == false) goto L56;
        L59:
            t(r3);
            o(m().b(n.T(r3)));
            return this;
        L56:
            if (this.w.isEmpty() == false) goto L58;
            this.w = n.Q(r3);
            this.f20064i &= -8193;
            goto L59
        L58:
            E();
            this.w.addAll(n.Q(r3));
            goto L59
        }

        public b H(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            n r0 = null;
            n r5 = n.A.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            G(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            n r6 = (n) e.a();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            G(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }

        public b I(q r4) {
            if ((this.f20064i & 64) == 64) goto L5;
        L7:
            this.p = r4;
            this.f20064i |= 64;
            return this;
        L5:
            if (this.p == q.X()) goto L7;
            r4 = q.y0(this.p).F(r4).w();
            goto L7
        }

        public b J(q r4) {
            if ((this.f20064i & 8) == 8) goto L5;
        L7:
            this.m = r4;
            this.f20064i |= 8;
            return this;
        L5:
            if (this.m == q.X()) goto L7;
            r4 = q.y0(this.m).F(r4).w();
            goto L7
        }

        public b K(u r4) {
            if ((this.f20064i & 1024) == 1024) goto L5;
        L7:
            this.t = r4;
            this.f20064i |= 1024;
            return this;
        L5:
            if (this.t == u.I()) goto L7;
            u.b r0 = u.Y(this.t);
            r0.C(r4);
            r4 = r0.w();
            goto L7
        }

        public b L(int r2) {
            this.f20064i |= 1;
            this.f20065j = r2;
            return this;
        }

        public b M(int r2) {
            this.f20064i |= 2048;
            this.u = r2;
            return this;
        }

        public b N(int r2) {
            this.f20064i |= 4;
            this.f20067l = r2;
            return this;
        }

        public b O(int r2) {
            this.f20064i |= 2;
            this.f20066k = r2;
            return this;
        }

        public b P(int r2) {
            this.f20064i |= 128;
            this.q = r2;
            return this;
        }

        public b Q(int r2) {
            this.f20064i |= 16;
            this.n = r2;
            return this;
        }

        public b R(int r2) {
            this.f20064i |= 4096;
            this.v = r2;
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
            H(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return y();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            G((n) r1);
            return this;
        }

        public n v() {
            n r1 = w();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public n w() {
            n r0 = new n(this, null);
            int r1 = this.f20064i;
            int r3 = 1;
            if ((r1 & 1) == 1) goto L6;
            r3 = 0;
        L6:
            n.A(r0, this.f20065j);
            if ((r1 & 2) != 2) goto L9;
            r3 = r3 | 2;
        L9:
            n.B(r0, this.f20066k);
            if ((r1 & 4) != 4) goto L12;
            r3 = r3 | 4;
        L12:
            n.C(r0, this.f20067l);
            if ((r1 & 8) != 8) goto L15;
            r3 = r3 | 8;
        L15:
            n.D(r0, this.m);
            if ((r1 & 16) != 16) goto L18;
            r3 = r3 | 16;
        L18:
            n.E(r0, this.n);
            if ((this.f20064i & 32) != 32) goto L21;
            this.o = Collections.unmodifiableList(this.o);
            this.f20064i &= -33;
        L21:
            n.G(r0, this.o);
            if ((r1 & 64) != 64) goto L24;
            r3 = r3 | 32;
        L24:
            n.H(r0, this.p);
            if ((r1 & 128) != 128) goto L27;
            r3 = r3 | 64;
        L27:
            n.I(r0, this.q);
            if ((this.f20064i & 256) != 256) goto L30;
            this.r = Collections.unmodifiableList(this.r);
            this.f20064i &= -257;
        L30:
            n.K(r0, this.r);
            if ((this.f20064i & 512) != 512) goto L33;
            this.s = Collections.unmodifiableList(this.s);
            this.f20064i &= NetError.ERR_TTNET_FT_INVALID_STREAM;
        L33:
            n.M(r0, this.s);
            if ((r1 & 1024) != 1024) goto L36;
            r3 = r3 | 128;
        L36:
            n.N(r0, this.t);
            if ((r1 & 2048) != 2048) goto L39;
            r3 = r3 | 256;
        L39:
            n.O(r0, this.u);
            if ((r1 & 4096) != 4096) goto L42;
            r3 = r3 | 512;
        L42:
            n.P(r0, this.v);
            if ((this.f20064i & 8192) != 8192) goto L45;
            this.w = Collections.unmodifiableList(this.w);
            this.f20064i &= -8193;
        L45:
            n.R(r0, this.w);
            n.S(r0, r3);
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            H(r1, r2);
            return this;
        }

        public b y() {
            b r0 = z();
            r0.G(w());
            return r0;
        }
    }

    static {
        A = new a();
        n r0 = new n(true);
        z = r0;
        r0.y0();
    }

    private n(kotlin.s0.w.d.l0.i.e r13, kotlin.s0.w.d.l0.i.g r14) {
        this.s = -1;
        this.x = -1;
        this.y = -1;
        y0();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L103;
        int r9 = r13.K();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        q.c r10 = null;
        u.b r11 = null;
        q.c r12 = null;
        switch(r9) {
            case 0: goto L72;
            case 8: goto L70;
            case 16: goto L69;
            case 26: goto L62;
            case 34: goto L58;
            case 42: goto L52;
            case 50: goto L43;
            case 56: goto L42;
            case 64: goto L41;
            case 72: goto L40;
            case 80: goto L39;
            case 88: goto L38;
            case 98: goto L34;
            case 104: goto L30;
            case 106: goto L22;
            case 248: goto L17;
            case 250: goto L8;
            default: goto L73;
        };     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L8:
        int r15 = r13.j(r13.A());     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        int r16 = (r4 == true ? 1 : 0) & 8192;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r4 = r4;
        if (r16 == 8192) goto L14;
        r4 = r4;
        if (r13.e() <= 0) goto L14;
        this.w = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r4 = (r4 == true ? 1 : 0) | 8192;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L14:
        if (r13.e() <= 0) goto L16;
        this.w.add(Integer.valueOf(r13.s()));     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L16:
        r13.i(r15);     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L4
    L17:
        int r17 = (r4 == true ? 1 : 0) & 8192;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        int r5 = r4;
        if (r17 == 8192) goto L20;
        this.w = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r5 = (r4 == true ? 1 : 0) | 8192;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L20:
        List r18 = this.w;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r4 = r5;
        Object r19 = Integer.valueOf(r13.s());     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L21:
        r18.add(r19);     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L4
    L22:
        r15 = r13.j(r13.A());     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        int r110 = (r4 == true ? 1 : 0) & 512;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r4 = r4;
        if (r110 == 512) goto L28;
        r4 = r4;
        if (r13.e() <= 0) goto L28;
        this.r = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r4 = (r4 == true ? 1 : 0) | 512;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L28:
        if (r13.e() <= 0) goto L16;
        this.r.add(Integer.valueOf(r13.s()));     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L28
    L30:
        int r20 = (r4 == true ? 1 : 0) & 512;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        int r6 = r4;
        if (r20 == 512) goto L33;
        this.r = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r6 = (r4 == true ? 1 : 0) | 512;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L33:
        r18 = this.r;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r4 = r6;
        r19 = Integer.valueOf(r13.s());     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L21
    L34:
        int r21 = (r4 == true ? 1 : 0) & 256;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        int r7 = r4;
        if (r21 == 256) goto L37;
        this.q = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r7 = (r4 == true ? 1 : 0) | 256;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L37:
        r18 = this.q;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r4 = r7;
        r19 = r13.u(q.z, r14);     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L21
    L38:
        this.f20059h |= 1;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.f20060i = r13.s();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L4
    L39:
        this.f20059h |= 64;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.p = r13.s();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L4
    L40:
        this.f20059h |= 16;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.m = r13.s();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L4
    L41:
        this.f20059h |= 512;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.v = r13.s();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L4
    L42:
        this.f20059h |= 256;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.u = r13.s();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L4
    L43:
        int r111 = 128;
        if ((this.f20059h & 128) != 128) goto L46;
        r11 = this.t.a0();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L46:
        u r22 = (u) r13.u(u.r, r14);     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.t = r22;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        if (r11 == null) goto L49;
        r11.C(r22);     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.t = r11.w();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L49:
        int r23 = this.f20059h;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L50:
        this.f20059h = r23 | r111;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L4
    L52:
        if ((this.f20059h & 32) != 32) goto L54;
        r12 = this.o.A0();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L54:
        q r24 = (q) r13.u(q.z, r14);     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.o = r24;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        if (r12 == null) goto L57;
        r12.F(r24);     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.o = r12.w();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L57:
        this.f20059h |= 32;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L4
    L58:
        int r25 = (r4 == true ? 1 : 0) & 32;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        int r8 = r4;
        if (r25 == 32) goto L61;
        this.n = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r8 = (r4 == true ? 1 : 0) | 32;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L61:
        r18 = this.n;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        r4 = r8;
        r19 = r13.u(s.s, r14);     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L21
    L62:
        r111 = 8;
        if ((this.f20059h & 8) != 8) goto L65;
        r10 = this.f20063l.A0();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L65:
        q r26 = (q) r13.u(q.z, r14);     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.f20063l = r26;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        if (r10 == null) goto L68;
        r10.F(r26);     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.f20063l = r10.w();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L68:
        r23 = this.f20059h;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L50
    L69:
        this.f20059h |= 4;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.f20062k = r13.s();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        goto L4
    L70:
        this.f20059h |= 2;     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
        this.f20061j = r13.s();     // Catch: Throwable -> L75 IOException -> L77 kotlin.s0.w.d.l0.i.k -> L80
    L72:
        r3 = true;
        goto L4
    L73:
        if (o(r13, r2, r14, r9) == true) goto L4;
    L75:
        th = move-exception;
        if (((r4 == true ? 1 : 0) & 32) != 32) goto L87;
        this.n = Collections.unmodifiableList(this.n);
    L87:
        if (((r4 == true ? 1 : 0) & 256) != 256) goto L90;
        this.q = Collections.unmodifiableList(this.q);
    L90:
        if (((r4 == true ? 1 : 0) & 512) != 512) goto L93;
        this.r = Collections.unmodifiableList(this.r);
    L93:
        if (((r4 == true ? 1 : 0) & 8192) != 8192) goto L126;
        this.w = Collections.unmodifiableList(this.w);
    L126:
        r2.I();     // Catch: IOException -> L122 Throwable -> L97
    L97:
        th = move-exception;
        this.f20058g = r0.l();
        throw th;
    L96:
        this.f20058g = r0.l();
        l();
        throw th;
    L80:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L75
        throw e;     // Catch: Throwable -> L75
    L77:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r112 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L75
        r112.i(this);     // Catch: Throwable -> L75
        throw r112;     // Catch: Throwable -> L75
    L103:
        if (((r4 == true ? 1 : 0) & 32) != 32) goto L106;
        this.n = Collections.unmodifiableList(this.n);
    L106:
        if (((r4 == true ? 1 : 0) & 256) != 256) goto L109;
        this.q = Collections.unmodifiableList(this.q);
    L109:
        if (((r4 == true ? 1 : 0) & 512) != 512) goto L112;
        this.r = Collections.unmodifiableList(this.r);
    L112:
        if (((r4 == true ? 1 : 0) & 8192) != 8192) goto L124;
        this.w = Collections.unmodifiableList(this.w);
    L124:
        r2.I();     // Catch: IOException -> L121 Throwable -> L116
    L116:
        th = move-exception;
        this.f20058g = r0.l();
        throw th;
    L115:
        this.f20058g = r0.l();
        l();
    }

    /* synthetic */ n(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private n(kotlin.s0.w.d.l0.i.i.c<n, ?> r2) {
        super(r2);
        this.s = -1;
        this.x = -1;
        this.y = -1;
        this.f20058g = r2.m();
    }

    /* synthetic */ n(kotlin.s0.w.d.l0.i.i.c r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private n(boolean r1) {
        this.s = -1;
        this.x = -1;
        this.y = -1;
        this.f20058g = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ int A(n r0, int r1) {
        r0.f20060i = r1;
        return r1;
    }

    public static b A0(n r1) {
        b r0 = z0();
        r0.G(r1);
        return r0;
    }

    static /* synthetic */ int B(n r0, int r1) {
        r0.f20061j = r1;
        return r1;
    }

    static /* synthetic */ int C(n r0, int r1) {
        r0.f20062k = r1;
        return r1;
    }

    static /* synthetic */ q D(n r0, q r1) {
        r0.f20063l = r1;
        return r1;
    }

    static /* synthetic */ int E(n r0, int r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ List F(n r0) {
        return r0.n;
    }

    static /* synthetic */ List G(n r0, List r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ q H(n r0, q r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ int I(n r0, int r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ List J(n r0) {
        return r0.q;
    }

    static /* synthetic */ List K(n r0, List r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ List L(n r0) {
        return r0.r;
    }

    static /* synthetic */ List M(n r0, List r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ u N(n r0, u r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ int O(n r0, int r1) {
        r0.u = r1;
        return r1;
    }

    static /* synthetic */ int P(n r0, int r1) {
        r0.v = r1;
        return r1;
    }

    static /* synthetic */ List Q(n r0) {
        return r0.w;
    }

    static /* synthetic */ List R(n r0, List r1) {
        r0.w = r1;
        return r1;
    }

    static /* synthetic */ int S(n r0, int r1) {
        r0.f20059h = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d T(n r0) {
        return r0.f20058g;
    }

    public static n Y() {
        return z;
    }

    private void y0() {
        this.f20060i = 518;
        this.f20061j = 2054;
        this.f20062k = 0;
        this.f20063l = q.X();
        this.m = 0;
        this.n = Collections.emptyList();
        this.o = q.X();
        this.p = 0;
        this.q = Collections.emptyList();
        this.r = Collections.emptyList();
        this.t = u.I();
        this.u = 0;
        this.v = 0;
        this.w = Collections.emptyList();
    }

    public static b z0() {
        return b.u();
    }

    public b B0() {
        return z0();
    }

    public b C0() {
        return A0(this);
    }

    public q U(int r1) {
        return this.q.get(r1);
    }

    public int V() {
        return this.q.size();
    }

    public List<Integer> W() {
        return this.r;
    }

    public List<q> X() {
        return this.q;
    }

    public n Z() {
        return z;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q a() {
        return Z();
    }

    public int a0() {
        return this.f20060i;
    }

    public int b0() {
        return this.u;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return C0();
    }

    public int c0() {
        return this.f20062k;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r8) {
        e();
        kotlin.s0.w.d.l0.i.i.d<MessageType>.a r0 = y();
        if ((this.f20059h & 2) != 2) goto L6;
        r8.a0(1, this.f20061j);
    L6:
        if ((this.f20059h & 4) != 4) goto L9;
        r8.a0(2, this.f20062k);
    L9:
        if ((this.f20059h & 8) != 8) goto L11;
        r8.d0(3, this.f20063l);
    L11:
        int r1 = 0;
        int r5 = 0;
    L13:
        if (r5 >= this.n.size()) goto L16;
        r8.d0(4, this.n.get(r5));
        r5 = r5 + 1;
        goto L13
    L16:
        if ((this.f20059h & 32) != 32) goto L19;
        r8.d0(5, this.o);
    L19:
        if ((this.f20059h & 128) != 128) goto L22;
        r8.d0(6, this.t);
    L22:
        if ((this.f20059h & 256) != 256) goto L25;
        r8.a0(7, this.u);
    L25:
        if ((this.f20059h & 512) != 512) goto L28;
        r8.a0(8, this.v);
    L28:
        if ((this.f20059h & 16) != 16) goto L31;
        r8.a0(9, this.m);
    L31:
        if ((this.f20059h & 64) != 64) goto L34;
        r8.a0(10, this.p);
    L34:
        if ((this.f20059h & 1) != 1) goto L36;
        r8.a0(11, this.f20060i);
    L36:
        int r2 = 0;
    L38:
        if (r2 >= this.q.size()) goto L41;
        r8.d0(12, this.q.get(r2));
        r2 = r2 + 1;
        goto L38
    L41:
        if (W().size() <= 0) goto L43;
        r8.o0(106);
        r8.o0(this.s);
    L43:
        int r3 = 0;
    L45:
        if (r3 >= this.r.size()) goto L48;
        r8.b0(this.r.get(r3).intValue());
        r3 = r3 + 1;
    L48:
        if (r1 >= this.w.size()) goto L50;
        r8.a0(31, this.w.get(r1).intValue());
        r1 = r1 + 1;
        goto L48
    L50:
        r0.a(19000, r8);
        r8.i0(this.f20058g);
    }

    public int d0() {
        return this.f20061j;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.y;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.f20059h & 2) != 2) goto L8;
        int r1 = kotlin.s0.w.d.l0.i.f.o(1, this.f20061j) + 0;
    L10:
        if ((this.f20059h & 4) != 4) goto L13;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(2, this.f20062k);
    L13:
        if ((this.f20059h & 8) != 8) goto L15;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(3, this.f20063l);
    L15:
        int r4 = 0;
    L17:
        if (r4 >= this.n.size()) goto L20;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(4, this.n.get(r4));
        r4 = r4 + 1;
        goto L17
    L20:
        if ((this.f20059h & 32) != 32) goto L23;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(5, this.o);
    L23:
        if ((this.f20059h & 128) != 128) goto L26;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(6, this.t);
    L26:
        if ((this.f20059h & 256) != 256) goto L29;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(7, this.u);
    L29:
        if ((this.f20059h & 512) != 512) goto L32;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(8, this.v);
    L32:
        if ((this.f20059h & 16) != 16) goto L35;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(9, this.m);
    L35:
        if ((this.f20059h & 64) != 64) goto L38;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(10, this.p);
    L38:
        if ((this.f20059h & 1) != 1) goto L40;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(11, this.f20060i);
    L40:
        int r3 = 0;
    L42:
        if (r3 >= this.q.size()) goto L44;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(12, this.q.get(r3));
        r3 = r3 + 1;
        goto L42
    L44:
        int r5 = 0;
        int r6 = 0;
    L46:
        if (r5 >= this.r.size()) goto L48;
        r6 = r6 + kotlin.s0.w.d.l0.i.f.p(this.r.get(r5).intValue());
        r5 = r5 + 1;
        goto L46
    L48:
        int r7 = r1 + r6;
        if (W().isEmpty() == true) goto L51;
        r7 = (r7 + 1) + kotlin.s0.w.d.l0.i.f.p(r6);
    L51:
        this.s = r6;
        int r8 = 0;
    L53:
        if (r2 >= this.w.size()) goto L55;
        r8 = r8 + kotlin.s0.w.d.l0.i.f.p(this.w.get(r2).intValue());
        r2 = r2 + 1;
        goto L53
    L55:
        int r9 = (((r7 + r8) + (n0().size() * 2)) + s()) + this.f20058g.size();
        this.y = r9;
        return r9;
    L8:
        r1 = 0;
        goto L10
    }

    public q e0() {
        return this.o;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return B0();
    }

    public int f0() {
        return this.p;
    }

    public q g0() {
        return this.f20063l;
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<n> h() {
        return A;
    }

    public int h0() {
        return this.m;
    }

    public int i0() {
        return this.v;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.x;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (q0() == true) goto L13;
        this.x = 0;
        return false;
    L13:
        if (u0() == true) goto L15;
    L18:
        int r1 = 0;
    L20:
        if (r1 >= l0()) goto L27;
        if (k0(r1).isInitialized() == false) goto L23;
        r1 = r1 + 1;
        goto L20
    L23:
        this.x = 0;
        return false;
    L27:
        if (s0() == true) goto L29;
    L32:
        int r2 = 0;
    L34:
        if (r2 >= V()) goto L41;
        if (U(r2).isInitialized() == false) goto L37;
        r2 = r2 + 1;
        goto L34
    L37:
        this.x = 0;
        return false;
    L41:
        if (x0() == false) goto L47;
        if (j0().isInitialized() == true) goto L47;
        this.x = 0;
        return false;
    L47:
        if (r() == true) goto L50;
        this.x = 0;
        return false;
    L50:
        this.x = 1;
        return true;
    L29:
        if (e0().isInitialized() == true) goto L32;
        this.x = 0;
        return false;
    L15:
        if (g0().isInitialized() == true) goto L18;
        this.x = 0;
        return false;
    }

    public u j0() {
        return this.t;
    }

    public s k0(int r1) {
        return this.n.get(r1);
    }

    public int l0() {
        return this.n.size();
    }

    public List<s> m0() {
        return this.n;
    }

    public List<Integer> n0() {
        return this.w;
    }

    public boolean o0() {
        if ((this.f20059h & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean p0() {
        if ((this.f20059h & 256) != 256) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean q0() {
        if ((this.f20059h & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean r0() {
        if ((this.f20059h & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean s0() {
        if ((this.f20059h & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean t0() {
        if ((this.f20059h & 64) != 64) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean u0() {
        if ((this.f20059h & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean v0() {
        if ((this.f20059h & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean w0() {
        if ((this.f20059h & 512) != 512) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean x0() {
        if ((this.f20059h & 128) != 128) goto L5;
        return true;
    L5:
        return false;
    }
}

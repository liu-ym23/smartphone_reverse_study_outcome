package kotlin.s0.w.d.l0.f;

import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends kotlin.s0.w.d.l0.i.i.d<i> implements Object {
    public static kotlin.s0.w.d.l0.i.s<i> A;
    private static final i z = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20019j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f20020k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private q f20021l;
    private int m;
    private List<s> n;
    private q o;
    private int p;
    private List<q> q;
    private List<Integer> r;
    private int s;
    private List<u> t;
    private t u;
    private List<Integer> v;
    private e w;
    private byte x;
    private int y;

    static class a extends kotlin.s0.w.d.l0.i.b<i> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public i m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new i(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.c<i, b> implements Object {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20022i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f20023j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f20024k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f20025l;
        private q m;
        private int n;
        private List<s> o;
        private q p;
        private int q;
        private List<q> r;
        private List<Integer> s;
        private List<u> t;
        private t u;
        private List<Integer> v;
        private e w;

        private b() {
            this.f20023j = 6;
            this.f20024k = 6;
            this.m = q.X();
            this.o = Collections.emptyList();
            this.p = q.X();
            this.r = Collections.emptyList();
            this.s = Collections.emptyList();
            this.t = Collections.emptyList();
            this.u = t.v();
            this.v = Collections.emptyList();
            this.w = e.t();
            G();
        }

        private void B() {
            if ((this.f20022i & 512) == 512) goto L6;
            this.s = new ArrayList(this.s);
            this.f20022i |= 512;
            return;
        }

        private void C() {
            if ((this.f20022i & 256) == 256) goto L6;
            this.r = new ArrayList(this.r);
            this.f20022i |= 256;
            return;
        }

        private void D() {
            if ((this.f20022i & 32) == 32) goto L6;
            this.o = new ArrayList(this.o);
            this.f20022i |= 32;
            return;
        }

        private void E() {
            if ((this.f20022i & 1024) == 1024) goto L6;
            this.t = new ArrayList(this.t);
            this.f20022i |= 1024;
            return;
        }

        private void F() {
            if ((this.f20022i & 4096) == 4096) goto L6;
            this.v = new ArrayList(this.v);
            this.f20022i |= 4096;
            return;
        }

        private void G() {
        }

        static /* synthetic */ b u() {
            return z();
        }

        private static b z() {
            return new b();
        }

        public b H(e r4) {
            if ((this.f20022i & 8192) == 8192) goto L5;
        L7:
            this.w = r4;
            this.f20022i |= 8192;
            return this;
        L5:
            if (this.w == e.t()) goto L7;
            e.b r0 = e.z(this.w);
            r0.y(r4);
            r4 = r0.r();
            goto L7
        }

        public b I(i r3) {
            if (r3 != i.a0()) goto L6;
            return this;
        L6:
            if (r3.s0() == false) goto L9;
            N(r3.c0());
        L9:
            if (r3.u0() == false) goto L12;
            P(r3.e0());
        L12:
            if (r3.t0() == false) goto L15;
            O(r3.d0());
        L15:
            if (r3.x0() == false) goto L18;
            L(r3.h0());
        L18:
            if (r3.y0() == false) goto L21;
            R(r3.i0());
        L21:
            if (i.F(r3).isEmpty() == true) goto L27;
            if (this.o.isEmpty() == false) goto L25;
            this.o = i.F(r3);
            this.f20022i &= -33;
            goto L27
        L25:
            D();
            this.o.addAll(i.F(r3));
        L27:
            if (r3.v0() == false) goto L30;
            K(r3.f0());
        L30:
            if (r3.w0() == false) goto L33;
            Q(r3.g0());
        L33:
            if (i.J(r3).isEmpty() == true) goto L39;
            if (this.r.isEmpty() == false) goto L37;
            this.r = i.J(r3);
            this.f20022i &= -257;
            goto L39
        L37:
            C();
            this.r.addAll(i.J(r3));
        L39:
            if (i.L(r3).isEmpty() == true) goto L45;
            if (this.s.isEmpty() == false) goto L43;
            this.s = i.L(r3);
            this.f20022i &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            goto L45
        L43:
            B();
            this.s.addAll(i.L(r3));
        L45:
            if (i.N(r3).isEmpty() == true) goto L51;
            if (this.t.isEmpty() == false) goto L49;
            this.t = i.N(r3);
            this.f20022i &= -1025;
            goto L51
        L49:
            E();
            this.t.addAll(i.N(r3));
        L51:
            if (r3.z0() == false) goto L54;
            M(r3.m0());
        L54:
            if (i.Q(r3).isEmpty() == true) goto L60;
            if (this.v.isEmpty() == false) goto L58;
            this.v = i.Q(r3);
            this.f20022i &= -4097;
            goto L60
        L58:
            F();
            this.v.addAll(i.Q(r3));
        L60:
            if (r3.r0() == false) goto L62;
            H(r3.Z());
        L62:
            t(r3);
            o(m().b(i.U(r3)));
            return this;
        }

        public b J(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            i r0 = null;
            i r5 = i.A.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            I(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            i r6 = (i) e.a();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            I(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }

        public b K(q r4) {
            if ((this.f20022i & 64) == 64) goto L5;
        L7:
            this.p = r4;
            this.f20022i |= 64;
            return this;
        L5:
            if (this.p == q.X()) goto L7;
            r4 = q.y0(this.p).F(r4).w();
            goto L7
        }

        public b L(q r4) {
            if ((this.f20022i & 8) == 8) goto L5;
        L7:
            this.m = r4;
            this.f20022i |= 8;
            return this;
        L5:
            if (this.m == q.X()) goto L7;
            r4 = q.y0(this.m).F(r4).w();
            goto L7
        }

        public b M(t r4) {
            if ((this.f20022i & 2048) == 2048) goto L5;
        L7:
            this.u = r4;
            this.f20022i |= 2048;
            return this;
        L5:
            if (this.u == t.v()) goto L7;
            t.b r0 = t.E(this.u);
            r0.y(r4);
            r4 = r0.r();
            goto L7
        }

        public b N(int r2) {
            this.f20022i |= 1;
            this.f20023j = r2;
            return this;
        }

        public b O(int r2) {
            this.f20022i |= 4;
            this.f20025l = r2;
            return this;
        }

        public b P(int r2) {
            this.f20022i |= 2;
            this.f20024k = r2;
            return this;
        }

        public b Q(int r2) {
            this.f20022i |= 128;
            this.q = r2;
            return this;
        }

        public b R(int r2) {
            this.f20022i |= 16;
            this.n = r2;
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
            J(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return y();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            I((i) r1);
            return this;
        }

        public i v() {
            i r1 = w();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public i w() {
            i r0 = new i(this, null);
            int r1 = this.f20022i;
            int r3 = 1;
            if ((r1 & 1) == 1) goto L6;
            r3 = 0;
        L6:
            i.A(r0, this.f20023j);
            if ((r1 & 2) != 2) goto L9;
            r3 = r3 | 2;
        L9:
            i.B(r0, this.f20024k);
            if ((r1 & 4) != 4) goto L12;
            r3 = r3 | 4;
        L12:
            i.C(r0, this.f20025l);
            if ((r1 & 8) != 8) goto L15;
            r3 = r3 | 8;
        L15:
            i.D(r0, this.m);
            if ((r1 & 16) != 16) goto L18;
            r3 = r3 | 16;
        L18:
            i.E(r0, this.n);
            if ((this.f20022i & 32) != 32) goto L21;
            this.o = Collections.unmodifiableList(this.o);
            this.f20022i &= -33;
        L21:
            i.G(r0, this.o);
            if ((r1 & 64) != 64) goto L24;
            r3 = r3 | 32;
        L24:
            i.H(r0, this.p);
            if ((r1 & 128) != 128) goto L27;
            r3 = r3 | 64;
        L27:
            i.I(r0, this.q);
            if ((this.f20022i & 256) != 256) goto L30;
            this.r = Collections.unmodifiableList(this.r);
            this.f20022i &= -257;
        L30:
            i.K(r0, this.r);
            if ((this.f20022i & 512) != 512) goto L33;
            this.s = Collections.unmodifiableList(this.s);
            this.f20022i &= NetError.ERR_TTNET_FT_INVALID_STREAM;
        L33:
            i.M(r0, this.s);
            if ((this.f20022i & 1024) != 1024) goto L36;
            this.t = Collections.unmodifiableList(this.t);
            this.f20022i &= -1025;
        L36:
            i.O(r0, this.t);
            if ((r1 & 2048) != 2048) goto L39;
            r3 = r3 | 128;
        L39:
            i.P(r0, this.u);
            if ((this.f20022i & 4096) != 4096) goto L42;
            this.v = Collections.unmodifiableList(this.v);
            this.f20022i &= -4097;
        L42:
            i.R(r0, this.v);
            if ((r1 & 8192) != 8192) goto L45;
            r3 = r3 | 256;
        L45:
            i.S(r0, this.w);
            i.T(r0, r3);
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            J(r1, r2);
            return this;
        }

        public b y() {
            b r0 = z();
            r0.I(w());
            return r0;
        }
    }

    static {
        A = new a();
        i r0 = new i(true);
        z = r0;
        r0.A0();
    }

    private i(kotlin.s0.w.d.l0.i.e r14, kotlin.s0.w.d.l0.i.g r15) {
        this.s = -1;
        this.x = -1;
        this.y = -1;
        A0();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L115;
        int r10 = r14.K();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        q.c r11 = null;
        e.b r12 = null;
        t.b r13 = null;
        q.c r16 = null;
        switch(r10) {
            case 0: goto L81;
            case 8: goto L79;
            case 16: goto L78;
            case 26: goto L71;
            case 34: goto L67;
            case 42: goto L61;
            case 50: goto L56;
            case 56: goto L55;
            case 64: goto L54;
            case 72: goto L53;
            case 82: goto L49;
            case 88: goto L45;
            case 90: goto L37;
            case 242: goto L29;
            case 248: goto L24;
            case 250: goto L15;
            case 258: goto L9;
            default: goto L82;
        };     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L9:
        if ((this.f20017h & 256) != 256) goto L11;
        r12 = this.w.B();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L11:
        e r17 = (e) r14.u(e.f19961k, r15);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.w = r17;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        if (r12 == null) goto L14;
        r12.y(r17);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.w = r12.r();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L14:
        this.f20017h |= 256;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L4
    L15:
        int r18 = r14.j(r14.A());     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        int r19 = (r4 == true ? 1 : 0) & 4096;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r4 = r4;
        if (r19 == 4096) goto L21;
        r4 = r4;
        if (r14.e() <= 0) goto L21;
        this.v = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r4 = (r4 == true ? 1 : 0) | 4096;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L21:
        if (r14.e() <= 0) goto L23;
        this.v.add(Integer.valueOf(r14.s()));     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L23:
        r14.i(r18);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L4
    L24:
        int r110 = (r4 == true ? 1 : 0) & 4096;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        int r5 = r4;
        if (r110 == 4096) goto L27;
        this.v = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r5 = (r4 == true ? 1 : 0) | 4096;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L27:
        List r111 = this.v;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r4 = r5;
        Object r112 = Integer.valueOf(r14.s());     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L28:
        r111.add(r112);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L4
    L29:
        int r113 = 128;
        if ((this.f20017h & 128) != 128) goto L32;
        r13 = this.u.G();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L32:
        t r114 = (t) r14.u(t.m, r15);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.u = r114;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        if (r13 == null) goto L35;
        r13.y(r114);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.u = r13.r();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L35:
        int r115 = this.f20017h;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L36:
        this.f20017h = r115 | r113;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L4
    L37:
        r18 = r14.j(r14.A());     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        int r116 = (r4 == true ? 1 : 0) & 512;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r4 = r4;
        if (r116 == 512) goto L43;
        r4 = r4;
        if (r14.e() <= 0) goto L43;
        this.r = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r4 = (r4 == true ? 1 : 0) | 512;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L43:
        if (r14.e() <= 0) goto L23;
        this.r.add(Integer.valueOf(r14.s()));     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L43
    L45:
        int r117 = (r4 == true ? 1 : 0) & 512;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        int r6 = r4;
        if (r117 == 512) goto L48;
        this.r = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r6 = (r4 == true ? 1 : 0) | 512;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L48:
        r111 = this.r;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r4 = r6;
        r112 = Integer.valueOf(r14.s());     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L28
    L49:
        int r118 = (r4 == true ? 1 : 0) & 256;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        int r7 = r4;
        if (r118 == 256) goto L52;
        this.q = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r7 = (r4 == true ? 1 : 0) | 256;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L52:
        r111 = this.q;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r4 = r7;
        r112 = r14.u(q.z, r15);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L28
    L53:
        this.f20017h |= 1;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.f20018i = r14.s();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L4
    L54:
        this.f20017h |= 64;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.p = r14.s();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L4
    L55:
        this.f20017h |= 16;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.m = r14.s();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L4
    L56:
        int r119 = (r4 == true ? 1 : 0) & 1024;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        int r8 = r4;
        if (r119 == 1024) goto L59;
        this.t = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r8 = (r4 == true ? 1 : 0) | 1024;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L59:
        r111 = this.t;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r4 = r8;
        r112 = r14.u(u.r, r15);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L28
    L61:
        if ((this.f20017h & 32) != 32) goto L63;
        r16 = this.o.A0();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L63:
        q r120 = (q) r14.u(q.z, r15);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.o = r120;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        if (r16 == null) goto L66;
        r16.F(r120);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.o = r16.w();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L66:
        this.f20017h |= 32;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L4
    L67:
        int r121 = (r4 == true ? 1 : 0) & 32;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        int r9 = r4;
        if (r121 == 32) goto L70;
        this.n = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r9 = (r4 == true ? 1 : 0) | 32;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L70:
        r111 = this.n;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        r4 = r9;
        r112 = r14.u(s.s, r15);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L28
    L71:
        r113 = 8;
        if ((this.f20017h & 8) != 8) goto L74;
        r11 = this.f20021l.A0();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L74:
        q r122 = (q) r14.u(q.z, r15);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.f20021l = r122;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        if (r11 == null) goto L77;
        r11.F(r122);     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.f20021l = r11.w();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L77:
        r115 = this.f20017h;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L36
    L78:
        this.f20017h |= 4;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.f20020k = r14.s();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        goto L4
    L79:
        this.f20017h |= 2;     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
        this.f20019j = r14.s();     // Catch: Throwable -> L84 IOException -> L86 kotlin.s0.w.d.l0.i.k -> L89
    L81:
        r3 = true;
        goto L4
    L82:
        if (o(r14, r2, r15, r10) == true) goto L4;
    L84:
        th = move-exception;
        if (((r4 == true ? 1 : 0) & 32) != 32) goto L96;
        this.n = Collections.unmodifiableList(this.n);
    L96:
        if (((r4 == true ? 1 : 0) & 1024) != 1024) goto L99;
        this.t = Collections.unmodifiableList(this.t);
    L99:
        if (((r4 == true ? 1 : 0) & 256) != 256) goto L102;
        this.q = Collections.unmodifiableList(this.q);
    L102:
        if (((r4 == true ? 1 : 0) & 512) != 512) goto L105;
        this.r = Collections.unmodifiableList(this.r);
    L105:
        if (((r4 == true ? 1 : 0) & 4096) != 4096) goto L142;
        this.v = Collections.unmodifiableList(this.v);
    L142:
        r2.I();     // Catch: IOException -> L137 Throwable -> L109
    L109:
        th = move-exception;
        this.f20016g = r0.l();
        throw th;
    L108:
        this.f20016g = r0.l();
        l();
        throw th;
    L89:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L84
        throw e;     // Catch: Throwable -> L84
    L86:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r123 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L84
        r123.i(this);     // Catch: Throwable -> L84
        throw r123;     // Catch: Throwable -> L84
    L115:
        if (((r4 == true ? 1 : 0) & 32) != 32) goto L118;
        this.n = Collections.unmodifiableList(this.n);
    L118:
        if (((r4 == true ? 1 : 0) & 1024) != 1024) goto L121;
        this.t = Collections.unmodifiableList(this.t);
    L121:
        if (((r4 == true ? 1 : 0) & 256) != 256) goto L124;
        this.q = Collections.unmodifiableList(this.q);
    L124:
        if (((r4 == true ? 1 : 0) & 512) != 512) goto L127;
        this.r = Collections.unmodifiableList(this.r);
    L127:
        if (((r4 == true ? 1 : 0) & 4096) != 4096) goto L139;
        this.v = Collections.unmodifiableList(this.v);
    L139:
        r2.I();     // Catch: IOException -> L136 Throwable -> L131
    L131:
        th = move-exception;
        this.f20016g = r0.l();
        throw th;
    L130:
        this.f20016g = r0.l();
        l();
    }

    /* synthetic */ i(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private i(kotlin.s0.w.d.l0.i.i.c<i, ?> r2) {
        super(r2);
        this.s = -1;
        this.x = -1;
        this.y = -1;
        this.f20016g = r2.m();
    }

    /* synthetic */ i(kotlin.s0.w.d.l0.i.i.c r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private i(boolean r1) {
        this.s = -1;
        this.x = -1;
        this.y = -1;
        this.f20016g = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ int A(i r0, int r1) {
        r0.f20018i = r1;
        return r1;
    }

    private void A0() {
        this.f20018i = 6;
        this.f20019j = 6;
        this.f20020k = 0;
        this.f20021l = q.X();
        this.m = 0;
        this.n = Collections.emptyList();
        this.o = q.X();
        this.p = 0;
        this.q = Collections.emptyList();
        this.r = Collections.emptyList();
        this.t = Collections.emptyList();
        this.u = t.v();
        this.v = Collections.emptyList();
        this.w = e.t();
    }

    static /* synthetic */ int B(i r0, int r1) {
        r0.f20019j = r1;
        return r1;
    }

    public static b B0() {
        return b.u();
    }

    static /* synthetic */ int C(i r0, int r1) {
        r0.f20020k = r1;
        return r1;
    }

    public static b C0(i r1) {
        b r0 = B0();
        r0.I(r1);
        return r0;
    }

    static /* synthetic */ q D(i r0, q r1) {
        r0.f20021l = r1;
        return r1;
    }

    static /* synthetic */ int E(i r0, int r1) {
        r0.m = r1;
        return r1;
    }

    public static i E0(InputStream r1, kotlin.s0.w.d.l0.i.g r2) {
        return A.a(r1, r2);
    }

    static /* synthetic */ List F(i r0) {
        return r0.n;
    }

    static /* synthetic */ List G(i r0, List r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ q H(i r0, q r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ int I(i r0, int r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ List J(i r0) {
        return r0.q;
    }

    static /* synthetic */ List K(i r0, List r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ List L(i r0) {
        return r0.r;
    }

    static /* synthetic */ List M(i r0, List r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ List N(i r0) {
        return r0.t;
    }

    static /* synthetic */ List O(i r0, List r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ t P(i r0, t r1) {
        r0.u = r1;
        return r1;
    }

    static /* synthetic */ List Q(i r0) {
        return r0.v;
    }

    static /* synthetic */ List R(i r0, List r1) {
        r0.v = r1;
        return r1;
    }

    static /* synthetic */ e S(i r0, e r1) {
        r0.w = r1;
        return r1;
    }

    static /* synthetic */ int T(i r0, int r1) {
        r0.f20017h = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d U(i r0) {
        return r0.f20016g;
    }

    public static i a0() {
        return z;
    }

    public b D0() {
        return B0();
    }

    public b F0() {
        return C0(this);
    }

    public q V(int r1) {
        return this.q.get(r1);
    }

    public int W() {
        return this.q.size();
    }

    public List<Integer> X() {
        return this.r;
    }

    public List<q> Y() {
        return this.q;
    }

    public e Z() {
        return this.w;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q a() {
        return b0();
    }

    public i b0() {
        return z;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return F0();
    }

    public int c0() {
        return this.f20018i;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r9) {
        e();
        kotlin.s0.w.d.l0.i.i.d<MessageType>.a r0 = y();
        if ((this.f20017h & 2) != 2) goto L6;
        r9.a0(1, this.f20019j);
    L6:
        if ((this.f20017h & 4) != 4) goto L9;
        r9.a0(2, this.f20020k);
    L9:
        if ((this.f20017h & 8) != 8) goto L11;
        r9.d0(3, this.f20021l);
    L11:
        int r1 = 0;
        int r5 = 0;
    L13:
        if (r5 >= this.n.size()) goto L16;
        r9.d0(4, this.n.get(r5));
        r5 = r5 + 1;
        goto L13
    L16:
        if ((this.f20017h & 32) != 32) goto L18;
        r9.d0(5, this.o);
    L18:
        int r4 = 0;
    L20:
        if (r4 >= this.t.size()) goto L23;
        r9.d0(6, this.t.get(r4));
        r4 = r4 + 1;
        goto L20
    L23:
        if ((this.f20017h & 16) != 16) goto L26;
        r9.a0(7, this.m);
    L26:
        if ((this.f20017h & 64) != 64) goto L29;
        r9.a0(8, this.p);
    L29:
        if ((this.f20017h & 1) != 1) goto L31;
        r9.a0(9, this.f20018i);
    L31:
        int r2 = 0;
    L33:
        if (r2 >= this.q.size()) goto L36;
        r9.d0(10, this.q.get(r2));
        r2 = r2 + 1;
        goto L33
    L36:
        if (X().size() <= 0) goto L38;
        r9.o0(90);
        r9.o0(this.s);
    L38:
        int r3 = 0;
    L40:
        if (r3 >= this.r.size()) goto L43;
        r9.b0(this.r.get(r3).intValue());
        r3 = r3 + 1;
        goto L40
    L43:
        if ((this.f20017h & 128) != 128) goto L46;
        r9.d0(30, this.u);
    L46:
        if (r1 >= this.v.size()) goto L49;
        r9.a0(31, this.v.get(r1).intValue());
        r1 = r1 + 1;
        goto L46
    L49:
        if ((this.f20017h & 256) != 256) goto L51;
        r9.d0(32, this.w);
    L51:
        r0.a(19000, r9);
        r9.i0(this.f20016g);
    }

    public int d0() {
        return this.f20020k;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.y;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.f20017h & 2) != 2) goto L8;
        int r1 = kotlin.s0.w.d.l0.i.f.o(1, this.f20019j) + 0;
    L10:
        if ((this.f20017h & 4) != 4) goto L13;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(2, this.f20020k);
    L13:
        if ((this.f20017h & 8) != 8) goto L15;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(3, this.f20021l);
    L15:
        int r4 = 0;
    L17:
        if (r4 >= this.n.size()) goto L20;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(4, this.n.get(r4));
        r4 = r4 + 1;
        goto L17
    L20:
        if ((this.f20017h & 32) != 32) goto L22;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(5, this.o);
    L22:
        int r5 = 0;
    L24:
        if (r5 >= this.t.size()) goto L27;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(6, this.t.get(r5));
        r5 = r5 + 1;
        goto L24
    L27:
        if ((this.f20017h & 16) != 16) goto L30;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(7, this.m);
    L30:
        if ((this.f20017h & 64) != 64) goto L33;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(8, this.p);
    L33:
        if ((this.f20017h & 1) != 1) goto L35;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(9, this.f20018i);
    L35:
        int r3 = 0;
    L37:
        if (r3 >= this.q.size()) goto L39;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(10, this.q.get(r3));
        r3 = r3 + 1;
        goto L37
    L39:
        int r6 = 0;
        int r7 = 0;
    L41:
        if (r6 >= this.r.size()) goto L43;
        r7 = r7 + kotlin.s0.w.d.l0.i.f.p(this.r.get(r6).intValue());
        r6 = r6 + 1;
        goto L41
    L43:
        int r8 = r1 + r7;
        if (X().isEmpty() == true) goto L46;
        r8 = (r8 + 1) + kotlin.s0.w.d.l0.i.f.p(r7);
    L46:
        this.s = r7;
        if ((this.f20017h & 128) != 128) goto L49;
        r8 = r8 + kotlin.s0.w.d.l0.i.f.s(30, this.u);
    L49:
        int r9 = 0;
    L51:
        if (r2 >= this.v.size()) goto L53;
        r9 = r9 + kotlin.s0.w.d.l0.i.f.p(this.v.get(r2).intValue());
        r2 = r2 + 1;
        goto L51
    L53:
        int r10 = (r8 + r9) + (q0().size() * 2);
        if ((this.f20017h & 256) != 256) goto L56;
        r10 = r10 + kotlin.s0.w.d.l0.i.f.s(32, this.w);
    L56:
        int r11 = (r10 + s()) + this.f20016g.size();
        this.y = r11;
        return r11;
    L8:
        r1 = 0;
        goto L10
    }

    public int e0() {
        return this.f20019j;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return D0();
    }

    public q f0() {
        return this.o;
    }

    public int g0() {
        return this.p;
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<i> h() {
        return A;
    }

    public q h0() {
        return this.f20021l;
    }

    public int i0() {
        return this.m;
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
        if (t0() == true) goto L13;
        this.x = 0;
        return false;
    L13:
        if (x0() == true) goto L15;
    L18:
        int r1 = 0;
    L20:
        if (r1 >= k0()) goto L27;
        if (j0(r1).isInitialized() == false) goto L23;
        r1 = r1 + 1;
        goto L20
    L23:
        this.x = 0;
        return false;
    L27:
        if (v0() == true) goto L29;
    L32:
        int r2 = 0;
    L34:
        if (r2 >= W()) goto L40;
        if (V(r2).isInitialized() == false) goto L37;
        r2 = r2 + 1;
        goto L34
    L37:
        this.x = 0;
        return false;
    L40:
        int r3 = 0;
    L42:
        if (r3 >= o0()) goto L49;
        if (n0(r3).isInitialized() == false) goto L45;
        r3 = r3 + 1;
        goto L42
    L45:
        this.x = 0;
        return false;
    L49:
        if (z0() == false) goto L55;
        if (m0().isInitialized() == true) goto L55;
        this.x = 0;
        return false;
    L55:
        if (r0() == false) goto L61;
        if (Z().isInitialized() == true) goto L61;
        this.x = 0;
        return false;
    L61:
        if (r() == true) goto L64;
        this.x = 0;
        return false;
    L64:
        this.x = 1;
        return true;
    L29:
        if (f0().isInitialized() == true) goto L32;
        this.x = 0;
        return false;
    L15:
        if (h0().isInitialized() == true) goto L18;
        this.x = 0;
        return false;
    }

    public s j0(int r1) {
        return this.n.get(r1);
    }

    public int k0() {
        return this.n.size();
    }

    public List<s> l0() {
        return this.n;
    }

    public t m0() {
        return this.u;
    }

    public u n0(int r1) {
        return this.t.get(r1);
    }

    public int o0() {
        return this.t.size();
    }

    public List<u> p0() {
        return this.t;
    }

    public List<Integer> q0() {
        return this.v;
    }

    public boolean r0() {
        if ((this.f20017h & 256) != 256) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean s0() {
        if ((this.f20017h & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean t0() {
        if ((this.f20017h & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean u0() {
        if ((this.f20017h & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean v0() {
        if ((this.f20017h & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean w0() {
        if ((this.f20017h & 64) != 64) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean x0() {
        if ((this.f20017h & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean y0() {
        if ((this.f20017h & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean z0() {
        if ((this.f20017h & 128) != 128) goto L5;
        return true;
    L5:
        return false;
    }
}

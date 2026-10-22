package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends kotlin.s0.w.d.l0.i.i.d<r> implements Object {
    private static final r t = null;
    public static kotlin.s0.w.d.l0.i.s<r> u;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20129i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20130j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<s> f20131k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private q f20132l;
    private int m;
    private q n;
    private int o;
    private List<kotlin.s0.w.d.l0.f.b> p;
    private List<Integer> q;
    private byte r;
    private int s;

    static class a extends kotlin.s0.w.d.l0.i.b<r> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public r m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new r(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.c<r, b> implements Object {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20133i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f20134j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f20135k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private List<s> f20136l;
        private q m;
        private int n;
        private q o;
        private int p;
        private List<kotlin.s0.w.d.l0.f.b> q;
        private List<Integer> r;

        private b() {
            this.f20134j = 6;
            this.f20136l = Collections.emptyList();
            this.m = q.X();
            this.o = q.X();
            this.q = Collections.emptyList();
            this.r = Collections.emptyList();
            E();
        }

        private void B() {
            if ((this.f20133i & 128) == 128) goto L6;
            this.q = new ArrayList(this.q);
            this.f20133i |= 128;
            return;
        }

        private void C() {
            if ((this.f20133i & 4) == 4) goto L6;
            this.f20136l = new ArrayList(this.f20136l);
            this.f20133i |= 4;
            return;
        }

        private void D() {
            if ((this.f20133i & 256) == 256) goto L6;
            this.r = new ArrayList(this.r);
            this.f20133i |= 256;
            return;
        }

        private void E() {
        }

        static /* synthetic */ b u() {
            return z();
        }

        private static b z() {
            return new b();
        }

        public b F(q r4) {
            if ((this.f20133i & 32) == 32) goto L5;
        L7:
            this.o = r4;
            this.f20133i |= 32;
            return this;
        L5:
            if (this.o == q.X()) goto L7;
            r4 = q.y0(this.o).F(r4).w();
            goto L7
        }

        public b G(r r3) {
            if (r3 != r.R()) goto L6;
            return this;
        L6:
            if (r3.f0() == false) goto L9;
            K(r3.V());
        L9:
            if (r3.g0() == false) goto L12;
            L(r3.W());
        L12:
            if (r.C(r3).isEmpty() == true) goto L18;
            if (this.f20136l.isEmpty() == false) goto L16;
            this.f20136l = r.C(r3);
            this.f20133i &= -5;
            goto L18
        L16:
            C();
            this.f20136l.addAll(r.C(r3));
        L18:
            if (r3.h0() == false) goto L21;
            I(r3.a0());
        L21:
            if (r3.i0() == false) goto L24;
            M(r3.b0());
        L24:
            if (r3.d0() == false) goto L27;
            F(r3.T());
        L27:
            if (r3.e0() == false) goto L30;
            J(r3.U());
        L30:
            if (r.I(r3).isEmpty() == true) goto L36;
            if (this.q.isEmpty() == false) goto L34;
            this.q = r.I(r3);
            this.f20133i &= -129;
            goto L36
        L34:
            B();
            this.q.addAll(r.I(r3));
        L36:
            if (r.K(r3).isEmpty() == false) goto L38;
        L41:
            t(r3);
            o(m().b(r.N(r3)));
            return this;
        L38:
            if (this.r.isEmpty() == false) goto L40;
            this.r = r.K(r3);
            this.f20133i &= -257;
            goto L41
        L40:
            D();
            this.r.addAll(r.K(r3));
            goto L41
        }

        public b H(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            r r0 = null;
            r r5 = r.u.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            G(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            r r6 = (r) e.a();     // Catch: Throwable -> L7
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
            if ((this.f20133i & 8) == 8) goto L5;
        L7:
            this.m = r4;
            this.f20133i |= 8;
            return this;
        L5:
            if (this.m == q.X()) goto L7;
            r4 = q.y0(this.m).F(r4).w();
            goto L7
        }

        public b J(int r2) {
            this.f20133i |= 64;
            this.p = r2;
            return this;
        }

        public b K(int r2) {
            this.f20133i |= 1;
            this.f20134j = r2;
            return this;
        }

        public b L(int r2) {
            this.f20133i |= 2;
            this.f20135k = r2;
            return this;
        }

        public b M(int r2) {
            this.f20133i |= 16;
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
            H(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return y();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            G((r) r1);
            return this;
        }

        public r v() {
            r r1 = w();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public r w() {
            r r0 = new r(this, null);
            int r1 = this.f20133i;
            int r3 = 1;
            if ((r1 & 1) == 1) goto L6;
            r3 = 0;
        L6:
            r.A(r0, this.f20134j);
            if ((r1 & 2) != 2) goto L9;
            r3 = r3 | 2;
        L9:
            r.B(r0, this.f20135k);
            if ((this.f20133i & 4) != 4) goto L12;
            this.f20136l = Collections.unmodifiableList(this.f20136l);
            this.f20133i &= -5;
        L12:
            r.D(r0, this.f20136l);
            if ((r1 & 8) != 8) goto L15;
            r3 = r3 | 4;
        L15:
            r.E(r0, this.m);
            if ((r1 & 16) != 16) goto L18;
            r3 = r3 | 8;
        L18:
            r.F(r0, this.n);
            if ((r1 & 32) != 32) goto L21;
            r3 = r3 | 16;
        L21:
            r.G(r0, this.o);
            if ((r1 & 64) != 64) goto L24;
            r3 = r3 | 32;
        L24:
            r.H(r0, this.p);
            if ((this.f20133i & 128) != 128) goto L27;
            this.q = Collections.unmodifiableList(this.q);
            this.f20133i &= -129;
        L27:
            r.J(r0, this.q);
            if ((this.f20133i & 256) != 256) goto L30;
            this.r = Collections.unmodifiableList(this.r);
            this.f20133i &= -257;
        L30:
            r.L(r0, this.r);
            r.M(r0, r3);
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
        u = new a();
        r r0 = new r(true);
        t = r0;
        r0.j0();
    }

    private r(kotlin.s0.w.d.l0.i.e r12, kotlin.s0.w.d.l0.i.g r13) {
        this.r = -1;
        this.s = -1;
        j0();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L77;
        int r8 = r12.K();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        q.c r9 = null;
        switch(r8) {
            case 0: goto L49;
            case 8: goto L47;
            case 16: goto L46;
            case 26: goto L43;
            case 34: goto L36;
            case 40: goto L34;
            case 50: goto L28;
            case 56: goto L26;
            case 66: goto L23;
            case 248: goto L18;
            case 250: goto L8;
            default: goto L50;
        };     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
    L8:
        int r10 = r12.j(r12.A());     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        if ((r4 & 256) == 256) goto L14;
        if (r12.e() <= 0) goto L14;
        this.q = new ArrayList();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        r4 = r4 | 256;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
    L14:
        if (r12.e() <= 0) goto L16;
        this.q.add(Integer.valueOf(r12.s()));     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        goto L14
    L16:
        r12.i(r10);     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        goto L4
    L18:
        if ((r4 & 256) == 256) goto L20;
        this.q = new ArrayList();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        r4 = r4 | 256;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
    L20:
        List r11 = this.q;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        Object r14 = Integer.valueOf(r12.s());     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
    L21:
        r11.add(r14);     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        goto L4
    L23:
        if ((r4 & 128) == 128) goto L25;
        this.p = new ArrayList();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        r4 = r4 | 128;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
    L25:
        r11 = this.p;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        r14 = r12.u(kotlin.s0.w.d.l0.f.b.m, r13);     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        goto L21
    L26:
        this.f20128h |= 32;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        this.o = r12.s();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        goto L4
    L28:
        if ((this.f20128h & 16) != 16) goto L30;
        r9 = this.n.A0();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
    L30:
        q r15 = (q) r12.u(q.z, r13);     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        this.n = r15;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        if (r9 == null) goto L33;
        r9.F(r15);     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        this.n = r9.w();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
    L33:
        this.f20128h |= 16;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        goto L4
    L34:
        this.f20128h |= 8;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        this.m = r12.s();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        goto L4
    L36:
        if ((this.f20128h & 4) != 4) goto L38;
        r9 = this.f20132l.A0();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
    L38:
        q r16 = (q) r12.u(q.z, r13);     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        this.f20132l = r16;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        if (r9 == null) goto L41;
        r9.F(r16);     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        this.f20132l = r9.w();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
    L41:
        this.f20128h |= 4;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        goto L4
    L43:
        if ((r4 & 4) == 4) goto L45;
        this.f20131k = new ArrayList();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        r4 = r4 | 4;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
    L45:
        r11 = this.f20131k;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        r14 = r12.u(s.s, r13);     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        goto L21
    L46:
        this.f20128h |= 2;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        this.f20130j = r12.s();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        goto L4
    L47:
        this.f20128h |= 1;     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
        this.f20129i = r12.s();     // Catch: Throwable -> L52 IOException -> L54 kotlin.s0.w.d.l0.i.k -> L57
    L49:
        r3 = true;
        goto L4
    L50:
        if (o(r12, r2, r13, r8) == true) goto L4;
    L52:
        th = move-exception;
        if ((r4 & 4) != 4) goto L64;
        this.f20131k = Collections.unmodifiableList(this.f20131k);
    L64:
        if ((r4 & 128) != 128) goto L67;
        this.p = Collections.unmodifiableList(this.p);
    L67:
        if ((r4 & 256) != 256) goto L98;
        this.q = Collections.unmodifiableList(this.q);
    L98:
        r2.I();     // Catch: IOException -> L93 Throwable -> L71
    L71:
        th = move-exception;
        this.f20127g = r0.l();
        throw th;
    L70:
        this.f20127g = r0.l();
        l();
        throw th;
    L57:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L52
        throw e;     // Catch: Throwable -> L52
    L54:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r17 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L52
        r17.i(this);     // Catch: Throwable -> L52
        throw r17;     // Catch: Throwable -> L52
    L77:
        if ((r4 & 4) != 4) goto L80;
        this.f20131k = Collections.unmodifiableList(this.f20131k);
    L80:
        if ((r4 & 128) != 128) goto L83;
        this.p = Collections.unmodifiableList(this.p);
    L83:
        if ((r4 & 256) != 256) goto L95;
        this.q = Collections.unmodifiableList(this.q);
    L95:
        r2.I();     // Catch: IOException -> L92 Throwable -> L87
    L87:
        th = move-exception;
        this.f20127g = r0.l();
        throw th;
    L86:
        this.f20127g = r0.l();
        l();
    }

    /* synthetic */ r(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private r(kotlin.s0.w.d.l0.i.i.c<r, ?> r2) {
        super(r2);
        this.r = -1;
        this.s = -1;
        this.f20127g = r2.m();
    }

    /* synthetic */ r(kotlin.s0.w.d.l0.i.i.c r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private r(boolean r1) {
        this.r = -1;
        this.s = -1;
        this.f20127g = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ int A(r r0, int r1) {
        r0.f20129i = r1;
        return r1;
    }

    static /* synthetic */ int B(r r0, int r1) {
        r0.f20130j = r1;
        return r1;
    }

    static /* synthetic */ List C(r r0) {
        return r0.f20131k;
    }

    static /* synthetic */ List D(r r0, List r1) {
        r0.f20131k = r1;
        return r1;
    }

    static /* synthetic */ q E(r r0, q r1) {
        r0.f20132l = r1;
        return r1;
    }

    static /* synthetic */ int F(r r0, int r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ q G(r r0, q r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ int H(r r0, int r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ List I(r r0) {
        return r0.p;
    }

    static /* synthetic */ List J(r r0, List r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ List K(r r0) {
        return r0.q;
    }

    static /* synthetic */ List L(r r0, List r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ int M(r r0, int r1) {
        r0.f20128h = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d N(r r0) {
        return r0.f20127g;
    }

    public static r R() {
        return t;
    }

    private void j0() {
        this.f20129i = 6;
        this.f20130j = 0;
        this.f20131k = Collections.emptyList();
        this.f20132l = q.X();
        this.m = 0;
        this.n = q.X();
        this.o = 0;
        this.p = Collections.emptyList();
        this.q = Collections.emptyList();
    }

    public static b k0() {
        return b.u();
    }

    public static b l0(r r1) {
        b r0 = k0();
        r0.G(r1);
        return r0;
    }

    public static r n0(InputStream r1, kotlin.s0.w.d.l0.i.g r2) {
        return u.c(r1, r2);
    }

    public kotlin.s0.w.d.l0.f.b O(int r1) {
        return this.p.get(r1);
    }

    public int P() {
        return this.p.size();
    }

    public List<kotlin.s0.w.d.l0.f.b> Q() {
        return this.p;
    }

    public r S() {
        return t;
    }

    public q T() {
        return this.n;
    }

    public int U() {
        return this.o;
    }

    public int V() {
        return this.f20129i;
    }

    public int W() {
        return this.f20130j;
    }

    public s X(int r1) {
        return this.f20131k.get(r1);
    }

    public int Y() {
        return this.f20131k.size();
    }

    public List<s> Z() {
        return this.f20131k;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q a() {
        return S();
    }

    public q a0() {
        return this.f20132l;
    }

    public int b0() {
        return this.m;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return o0();
    }

    public List<Integer> c0() {
        return this.q;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r6) {
        e();
        kotlin.s0.w.d.l0.i.i.d<MessageType>.a r0 = y();
        if ((this.f20128h & 1) != 1) goto L6;
        r6.a0(1, this.f20129i);
    L6:
        if ((this.f20128h & 2) != 2) goto L8;
        r6.a0(2, this.f20130j);
    L8:
        int r1 = 0;
        int r2 = 0;
    L10:
        if (r2 >= this.f20131k.size()) goto L13;
        r6.d0(3, this.f20131k.get(r2));
        r2 = r2 + 1;
        goto L10
    L13:
        if ((this.f20128h & 4) != 4) goto L16;
        r6.d0(4, this.f20132l);
    L16:
        if ((this.f20128h & 8) != 8) goto L19;
        r6.a0(5, this.m);
    L19:
        if ((this.f20128h & 16) != 16) goto L22;
        r6.d0(6, this.n);
    L22:
        if ((this.f20128h & 32) != 32) goto L24;
        r6.a0(7, this.o);
    L24:
        int r3 = 0;
    L26:
        if (r3 >= this.p.size()) goto L29;
        r6.d0(8, this.p.get(r3));
        r3 = r3 + 1;
    L29:
        if (r1 >= this.q.size()) goto L31;
        r6.a0(31, this.q.get(r1).intValue());
        r1 = r1 + 1;
        goto L29
    L31:
        r0.a(200, r6);
        r6.i0(this.f20127g);
    }

    public boolean d0() {
        if ((this.f20128h & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.s;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.f20128h & 1) != 1) goto L8;
        int r1 = kotlin.s0.w.d.l0.i.f.o(1, this.f20129i) + 0;
    L10:
        if ((this.f20128h & 2) != 2) goto L12;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(2, this.f20130j);
    L12:
        int r3 = 0;
    L14:
        if (r3 >= this.f20131k.size()) goto L17;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(3, this.f20131k.get(r3));
        r3 = r3 + 1;
        goto L14
    L17:
        if ((this.f20128h & 4) != 4) goto L20;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(4, this.f20132l);
    L20:
        if ((this.f20128h & 8) != 8) goto L23;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(5, this.m);
    L23:
        if ((this.f20128h & 16) != 16) goto L26;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(6, this.n);
    L26:
        if ((this.f20128h & 32) != 32) goto L28;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(7, this.o);
    L28:
        int r4 = 0;
    L30:
        if (r4 >= this.p.size()) goto L32;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(8, this.p.get(r4));
        r4 = r4 + 1;
        goto L30
    L32:
        int r5 = 0;
    L34:
        if (r2 >= this.q.size()) goto L36;
        r5 = r5 + kotlin.s0.w.d.l0.i.f.p(this.q.get(r2).intValue());
        r2 = r2 + 1;
        goto L34
    L36:
        int r6 = (((r1 + r5) + (c0().size() * 2)) + s()) + this.f20127g.size();
        this.s = r6;
        return r6;
    L8:
        r1 = 0;
        goto L10
    }

    public boolean e0() {
        if ((this.f20128h & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return m0();
    }

    public boolean f0() {
        if ((this.f20128h & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean g0() {
        if ((this.f20128h & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<r> h() {
        return u;
    }

    public boolean h0() {
        if ((this.f20128h & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i0() {
        if ((this.f20128h & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.r;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (g0() == true) goto L12;
        this.r = 0;
        return false;
    L12:
        int r1 = 0;
    L14:
        if (r1 >= Y()) goto L21;
        if (X(r1).isInitialized() == false) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        this.r = 0;
        return false;
    L21:
        if (h0() == false) goto L27;
        if (a0().isInitialized() == true) goto L27;
        this.r = 0;
        return false;
    L27:
        if (d0() == true) goto L29;
    L32:
        int r2 = 0;
    L34:
        if (r2 >= P()) goto L41;
        if (O(r2).isInitialized() == false) goto L37;
        r2 = r2 + 1;
        goto L34
    L37:
        this.r = 0;
        return false;
    L41:
        if (r() == true) goto L44;
        this.r = 0;
        return false;
    L44:
        this.r = 1;
        return true;
    L29:
        if (T().isInitialized() == true) goto L32;
        this.r = 0;
        return false;
    }

    public b m0() {
        return k0();
    }

    public b o0() {
        return l0(this);
    }
}

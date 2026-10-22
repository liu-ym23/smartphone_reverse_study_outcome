package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends kotlin.s0.w.d.l0.i.i.d<l> implements Object {
    private static final l p = null;
    public static kotlin.s0.w.d.l0.i.s<l> q;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<i> f20040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<n> f20041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<r> f20042k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private t f20043l;
    private w m;
    private byte n;
    private int o;

    static class a extends kotlin.s0.w.d.l0.i.b<l> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public l m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new l(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.c<l, b> implements Object {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20044i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<i> f20045j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private List<n> f20046k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private List<r> f20047l;
        private t m;
        private w n;

        private b() {
            this.f20045j = Collections.emptyList();
            this.f20046k = Collections.emptyList();
            this.f20047l = Collections.emptyList();
            this.m = t.v();
            this.n = w.t();
            E();
        }

        private void B() {
            if ((this.f20044i & 1) == 1) goto L6;
            this.f20045j = new ArrayList(this.f20045j);
            this.f20044i |= 1;
            return;
        }

        private void C() {
            if ((this.f20044i & 2) == 2) goto L6;
            this.f20046k = new ArrayList(this.f20046k);
            this.f20044i |= 2;
            return;
        }

        private void D() {
            if ((this.f20044i & 4) == 4) goto L6;
            this.f20047l = new ArrayList(this.f20047l);
            this.f20044i |= 4;
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

        public b F(l r3) {
            if (r3 != l.K()) goto L6;
            return this;
        L6:
            if (l.A(r3).isEmpty() == true) goto L12;
            if (this.f20045j.isEmpty() == false) goto L10;
            this.f20045j = l.A(r3);
            this.f20044i &= -2;
            goto L12
        L10:
            B();
            this.f20045j.addAll(l.A(r3));
        L12:
            if (l.C(r3).isEmpty() == true) goto L18;
            if (this.f20046k.isEmpty() == false) goto L16;
            this.f20046k = l.C(r3);
            this.f20044i &= -3;
            goto L18
        L16:
            C();
            this.f20046k.addAll(l.C(r3));
        L18:
            if (l.E(r3).isEmpty() == true) goto L24;
            if (this.f20047l.isEmpty() == false) goto L22;
            this.f20047l = l.E(r3);
            this.f20044i &= -5;
            goto L24
        L22:
            D();
            this.f20047l.addAll(l.E(r3));
        L24:
            if (r3.X() == false) goto L27;
            H(r3.V());
        L27:
            if (r3.Y() == false) goto L29;
            I(r3.W());
        L29:
            t(r3);
            o(m().b(l.J(r3)));
            return this;
        }

        public b G(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            l r0 = null;
            l r5 = l.q.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            F(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            l r6 = (l) e.a();     // Catch: Throwable -> L7
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

        public b H(t r4) {
            if ((this.f20044i & 8) == 8) goto L5;
        L7:
            this.m = r4;
            this.f20044i |= 8;
            return this;
        L5:
            if (this.m == t.v()) goto L7;
            t.b r0 = t.E(this.m);
            r0.y(r4);
            r4 = r0.r();
            goto L7
        }

        public b I(w r4) {
            if ((this.f20044i & 16) == 16) goto L5;
        L7:
            this.n = r4;
            this.f20044i |= 16;
            return this;
        L5:
            if (this.n == w.t()) goto L7;
            w.b r0 = w.z(this.n);
            r0.y(r4);
            r4 = r0.r();
            goto L7
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
            F((l) r1);
            return this;
        }

        public l v() {
            l r1 = w();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public l w() {
            l r0 = new l(this, null);
            int r1 = this.f20044i;
            int r3 = 1;
            if ((r1 & 1) != 1) goto L5;
            this.f20045j = Collections.unmodifiableList(this.f20045j);
            this.f20044i &= -2;
        L5:
            l.B(r0, this.f20045j);
            if ((this.f20044i & 2) != 2) goto L8;
            this.f20046k = Collections.unmodifiableList(this.f20046k);
            this.f20044i &= -3;
        L8:
            l.D(r0, this.f20046k);
            if ((this.f20044i & 4) != 4) goto L11;
            this.f20047l = Collections.unmodifiableList(this.f20047l);
            this.f20044i &= -5;
        L11:
            l.F(r0, this.f20047l);
            if ((r1 & 8) == 8) goto L15;
            r3 = 0;
        L15:
            l.G(r0, this.m);
            if ((r1 & 16) != 16) goto L18;
            r3 = r3 | 2;
        L18:
            l.H(r0, this.n);
            l.I(r0, r3);
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            G(r1, r2);
            return this;
        }

        public b y() {
            b r0 = z();
            r0.F(w());
            return r0;
        }
    }

    static {
        q = new a();
        l r0 = new l(true);
        p = r0;
        r0.Z();
    }

    private l(kotlin.s0.w.d.l0.i.e r11, kotlin.s0.w.d.l0.i.g r12) {
        this.n = -1;
        this.o = -1;
        Z();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L74;
        int r7 = r11.K();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        if (r7 == 0) goto L48;
        if (r7 == 26) goto L43;
        if (r7 == 34) goto L39;
        if (r7 != 42) goto L13;
        int r8 = (r4 == true ? 1 : 0) & 4;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        int r5 = r4;
        if (r8 == 4) goto L37;
        this.f20042k = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r5 = (r4 == true ? 1 : 0) | 4;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L37:
        List r9 = this.f20042k;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        kotlin.s0.w.d.l0.i.q r10 = r11.u(r.u, r12);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r4 = r5;
    L38:
        r9.add(r10);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L13:
        w.b r13 = null;
        t.b r14 = null;
        if (r7 != 242) goto L16;
        if ((this.f20039h & 1) != 1) goto L30;
        r14 = this.f20043l.G();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L30:
        t r15 = (t) r11.u(t.m, r12);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20043l = r15;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        if (r14 == null) goto L33;
        r14.y(r15);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20043l = r14.r();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L33:
        this.f20039h |= 1;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L16:
        if (r7 != 258) goto L18;
        if ((this.f20039h & 2) != 2) goto L23;
        r13 = this.m.B();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L23:
        w r16 = (w) r11.u(w.f20196k, r12);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.m = r16;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        if (r13 == null) goto L26;
        r13.y(r16);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.m = r13.r();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L26:
        this.f20039h |= 2;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L18:
        if (o(r11, r2, r12, r7) == true) goto L4;
    L39:
        int r17 = (r4 == true ? 1 : 0) & 2;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        int r6 = r4;
        if (r17 == 2) goto L42;
        this.f20041j = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r6 = (r4 == true ? 1 : 0) | 2;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L42:
        r9 = this.f20041j;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r10 = r11.u(n.A, r12);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r4 = r6;
        goto L38
    L43:
        int r18 = (r4 == true ? 1 : 0) & 1;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        int r19 = r4;
        if (r18 == 1) goto L46;
        this.f20040i = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r19 = (r4 == true ? 1 : 0) | 1;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L46:
        r9 = this.f20040i;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r10 = r11.u(i.A, r12);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r4 = r19;
    L48:
        r3 = true;
        goto L4
    L49:
        th = move-exception;
        if (((r4 == true ? 1 : 0) & 1) != 1) goto L61;
        this.f20040i = Collections.unmodifiableList(this.f20040i);
    L61:
        if (((r4 == true ? 1 : 0) & 2) != 2) goto L64;
        this.f20041j = Collections.unmodifiableList(this.f20041j);
    L64:
        if (((r4 == true ? 1 : 0) & 4) != 4) goto L95;
        this.f20042k = Collections.unmodifiableList(this.f20042k);
    L95:
        r2.I();     // Catch: IOException -> L90 Throwable -> L68
    L68:
        th = move-exception;
        this.f20038g = r0.l();
        throw th;
    L67:
        this.f20038g = r0.l();
        l();
        throw th;
    L54:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L49
        throw e;     // Catch: Throwable -> L49
    L51:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r110 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L49
        r110.i(this);     // Catch: Throwable -> L49
        throw r110;     // Catch: Throwable -> L49
    L74:
        if (((r4 == true ? 1 : 0) & 1) != 1) goto L77;
        this.f20040i = Collections.unmodifiableList(this.f20040i);
    L77:
        if (((r4 == true ? 1 : 0) & 2) != 2) goto L80;
        this.f20041j = Collections.unmodifiableList(this.f20041j);
    L80:
        if (((r4 == true ? 1 : 0) & 4) != 4) goto L93;
        this.f20042k = Collections.unmodifiableList(this.f20042k);
    L93:
        r2.I();     // Catch: IOException -> L89 Throwable -> L84
    L84:
        th = move-exception;
        this.f20038g = r0.l();
        throw th;
    L83:
        this.f20038g = r0.l();
        l();
    }

    /* synthetic */ l(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private l(kotlin.s0.w.d.l0.i.i.c<l, ?> r2) {
        super(r2);
        this.n = -1;
        this.o = -1;
        this.f20038g = r2.m();
    }

    /* synthetic */ l(kotlin.s0.w.d.l0.i.i.c r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private l(boolean r1) {
        this.n = -1;
        this.o = -1;
        this.f20038g = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ List A(l r0) {
        return r0.f20040i;
    }

    static /* synthetic */ List B(l r0, List r1) {
        r0.f20040i = r1;
        return r1;
    }

    static /* synthetic */ List C(l r0) {
        return r0.f20041j;
    }

    static /* synthetic */ List D(l r0, List r1) {
        r0.f20041j = r1;
        return r1;
    }

    static /* synthetic */ List E(l r0) {
        return r0.f20042k;
    }

    static /* synthetic */ List F(l r0, List r1) {
        r0.f20042k = r1;
        return r1;
    }

    static /* synthetic */ t G(l r0, t r1) {
        r0.f20043l = r1;
        return r1;
    }

    static /* synthetic */ w H(l r0, w r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ int I(l r0, int r1) {
        r0.f20039h = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d J(l r0) {
        return r0.f20038g;
    }

    public static l K() {
        return p;
    }

    private void Z() {
        this.f20040i = Collections.emptyList();
        this.f20041j = Collections.emptyList();
        this.f20042k = Collections.emptyList();
        this.f20043l = t.v();
        this.m = w.t();
    }

    public static b a0() {
        return b.u();
    }

    public static b b0(l r1) {
        b r0 = a0();
        r0.F(r1);
        return r0;
    }

    public static l d0(InputStream r1, kotlin.s0.w.d.l0.i.g r2) {
        return q.a(r1, r2);
    }

    public l L() {
        return p;
    }

    public i M(int r1) {
        return this.f20040i.get(r1);
    }

    public int N() {
        return this.f20040i.size();
    }

    public List<i> O() {
        return this.f20040i;
    }

    public n P(int r1) {
        return this.f20041j.get(r1);
    }

    public int Q() {
        return this.f20041j.size();
    }

    public List<n> R() {
        return this.f20041j;
    }

    public r S(int r1) {
        return this.f20042k.get(r1);
    }

    public int T() {
        return this.f20042k.size();
    }

    public List<r> U() {
        return this.f20042k;
    }

    public t V() {
        return this.f20043l;
    }

    public w W() {
        return this.m;
    }

    public boolean X() {
        if ((this.f20039h & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean Y() {
        if ((this.f20039h & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q a() {
        return L();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return e0();
    }

    public b c0() {
        return a0();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r6) {
        e();
        kotlin.s0.w.d.l0.i.i.d<MessageType>.a r0 = y();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= this.f20040i.size()) goto L6;
        r6.d0(3, this.f20040i.get(r2));
        r2 = r2 + 1;
        goto L4
    L6:
        int r3 = 0;
    L8:
        if (r3 >= this.f20041j.size()) goto L11;
        r6.d0(4, this.f20041j.get(r3));
        r3 = r3 + 1;
    L11:
        if (r1 >= this.f20042k.size()) goto L14;
        r6.d0(5, this.f20042k.get(r1));
        r1 = r1 + 1;
        goto L11
    L14:
        if ((this.f20039h & 1) != 1) goto L17;
        r6.d0(30, this.f20043l);
    L17:
        if ((this.f20039h & 2) != 2) goto L19;
        r6.d0(32, this.m);
    L19:
        r0.a(200, r6);
        r6.i0(this.f20038g);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.o;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= this.f20040i.size()) goto L9;
        r3 = r3 + kotlin.s0.w.d.l0.i.f.s(3, this.f20040i.get(r2));
        r2 = r2 + 1;
        goto L7
    L9:
        int r4 = 0;
    L11:
        if (r4 >= this.f20041j.size()) goto L14;
        r3 = r3 + kotlin.s0.w.d.l0.i.f.s(4, this.f20041j.get(r4));
        r4 = r4 + 1;
    L14:
        if (r1 >= this.f20042k.size()) goto L17;
        r3 = r3 + kotlin.s0.w.d.l0.i.f.s(5, this.f20042k.get(r1));
        r1 = r1 + 1;
        goto L14
    L17:
        if ((this.f20039h & 1) != 1) goto L20;
        r3 = r3 + kotlin.s0.w.d.l0.i.f.s(30, this.f20043l);
    L20:
        if ((this.f20039h & 2) != 2) goto L22;
        r3 = r3 + kotlin.s0.w.d.l0.i.f.s(32, this.m);
    L22:
        int r5 = (r3 + s()) + this.f20038g.size();
        this.o = r5;
        return r5;
    }

    public b e0() {
        return b0(this);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return c0();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<l> h() {
        return q;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.n;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= N()) goto L16;
        if (M(r1).isInitialized() == false) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        this.n = 0;
        return false;
    L16:
        int r2 = 0;
    L18:
        if (r2 >= Q()) goto L24;
        if (P(r2).isInitialized() == false) goto L21;
        r2 = r2 + 1;
        goto L18
    L21:
        this.n = 0;
        return false;
    L24:
        int r3 = 0;
    L26:
        if (r3 >= T()) goto L33;
        if (S(r3).isInitialized() == false) goto L29;
        r3 = r3 + 1;
        goto L26
    L29:
        this.n = 0;
        return false;
    L33:
        if (X() == false) goto L39;
        if (V().isInitialized() == true) goto L39;
        this.n = 0;
        return false;
    L39:
        if (r() == true) goto L42;
        this.n = 0;
        return false;
    L42:
        this.n = 1;
        return true;
    }
}

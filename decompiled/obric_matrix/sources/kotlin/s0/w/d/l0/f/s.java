package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends kotlin.s0.w.d.l0.i.i.d<s> implements Object {
    private static final s r = null;
    public static kotlin.s0.w.d.l0.i.s<s> s;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20140j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f20141k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private c f20142l;
    private List<q> m;
    private List<Integer> n;
    private int o;
    private byte p;
    private int q;

    static class a extends kotlin.s0.w.d.l0.i.b<s> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public s m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new s(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.c<s, b> implements Object {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20143i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f20144j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f20145k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f20146l;
        private c m;
        private List<q> n;
        private List<Integer> o;

        private b() {
            this.m = c.f20149i;
            this.n = Collections.emptyList();
            this.o = Collections.emptyList();
            D();
        }

        private void B() {
            if ((this.f20143i & 32) == 32) goto L6;
            this.o = new ArrayList(this.o);
            this.f20143i |= 32;
            return;
        }

        private void C() {
            if ((this.f20143i & 16) == 16) goto L6;
            this.n = new ArrayList(this.n);
            this.f20143i |= 16;
            return;
        }

        private void D() {
        }

        static /* synthetic */ b u() {
            return z();
        }

        private static b z() {
            return new b();
        }

        public b E(s r3) {
            if (r3 != s.K()) goto L6;
            return this;
        L6:
            if (r3.U() == false) goto L9;
            G(r3.M());
        L9:
            if (r3.V() == false) goto L12;
            H(r3.N());
        L12:
            if (r3.W() == false) goto L15;
            I(r3.O());
        L15:
            if (r3.X() == false) goto L18;
            J(r3.T());
        L18:
            if (s.E(r3).isEmpty() == true) goto L24;
            if (this.n.isEmpty() == false) goto L22;
            this.n = s.E(r3);
            this.f20143i &= -17;
            goto L24
        L22:
            C();
            this.n.addAll(s.E(r3));
        L24:
            if (s.G(r3).isEmpty() == false) goto L26;
        L29:
            t(r3);
            o(m().b(s.J(r3)));
            return this;
        L26:
            if (this.o.isEmpty() == false) goto L28;
            this.o = s.G(r3);
            this.f20143i &= -33;
            goto L29
        L28:
            B();
            this.o.addAll(s.G(r3));
            goto L29
        }

        public b F(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            s r0 = null;
            s r5 = s.s.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            E(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            s r6 = (s) e.a();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            E(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }

        public b G(int r2) {
            this.f20143i |= 1;
            this.f20144j = r2;
            return this;
        }

        public b H(int r2) {
            this.f20143i |= 2;
            this.f20145k = r2;
            return this;
        }

        public b I(boolean r2) {
            this.f20143i |= 4;
            this.f20146l = r2;
            return this;
        }

        public b J(c r2) {
            Objects.requireNonNull(r2);
            this.f20143i |= 8;
            this.m = r2;
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
            F(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return y();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            E((s) r1);
            return this;
        }

        public s v() {
            s r1 = w();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public s w() {
            s r0 = new s(this, null);
            int r1 = this.f20143i;
            int r3 = 1;
            if ((r1 & 1) == 1) goto L6;
            r3 = 0;
        L6:
            s.A(r0, this.f20144j);
            if ((r1 & 2) != 2) goto L9;
            r3 = r3 | 2;
        L9:
            s.B(r0, this.f20145k);
            if ((r1 & 4) != 4) goto L12;
            r3 = r3 | 4;
        L12:
            s.C(r0, this.f20146l);
            if ((r1 & 8) != 8) goto L15;
            r3 = r3 | 8;
        L15:
            s.D(r0, this.m);
            if ((this.f20143i & 16) != 16) goto L18;
            this.n = Collections.unmodifiableList(this.n);
            this.f20143i &= -17;
        L18:
            s.F(r0, this.n);
            if ((this.f20143i & 32) != 32) goto L21;
            this.o = Collections.unmodifiableList(this.o);
            this.f20143i &= -33;
        L21:
            s.H(r0, this.o);
            s.I(r0, r3);
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            F(r1, r2);
            return this;
        }

        public b y() {
            b r0 = z();
            r0.E(w());
            return r0;
        }
    }

    public static final enum c extends Enum<c> implements kotlin.s0.w.d.l0.i.j.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f20147g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f20148h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f20149i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ c[] f20150j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f20151f;

        static {
            c r0 = new c("IN", 0, 0, 0);
            f20147g = r0;
            c r1 = new c("OUT", 1, 1, 1);
            f20148h = r1;
            c r3 = new c("INV", 2, 2, 2);
            f20149i = r3;
            f20150j = new c[]{r0, r1, r3};
        }

        private c(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.f20151f = r4;
        }

        public static c a(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return f20149i;
        L12:
            return f20148h;
        L14:
            return f20147g;
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f20150j.clone();
        }

        @Override // kotlin.s0.w.d.l0.i.j.a
        public final int d() {
            return this.f20151f;
        }
    }

    static {
        s = new a();
        s r0 = new s(true);
        r = r0;
        r0.Y();
    }

    private s(kotlin.s0.w.d.l0.i.e r12, kotlin.s0.w.d.l0.i.g r13) {
        this.o = -1;
        this.p = -1;
        this.q = -1;
        Y();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L71;
        int r7 = r12.K();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        if (r7 == 0) goto L48;
        if (r7 != 8) goto L9;
        this.f20138h |= 1;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20139i = r12.s();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L9:
        if (r7 != 16) goto L11;
        this.f20138h |= 2;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20140j = r12.s();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L11:
        if (r7 != 24) goto L12;
        this.f20138h |= 4;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20141k = r12.k();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L12:
        if (r7 != 32) goto L14;
        int r9 = r12.n();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        c r10 = c.a(r9);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        if (r10 == null) goto L42;
        this.f20138h |= 8;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20142l = r10;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L42:
        r2.o0(r7);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r2.o0(r9);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L14:
        if (r7 == 42) goto L37;
        if (r7 != 48) goto L18;
        if ((r4 & 32) == 32) goto L34;
        this.n = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r4 = r4 | 32;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L34:
        List r8 = this.n;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        Object r11 = Integer.valueOf(r12.s());     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L35:
        r8.add(r11);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L18:
        if (r7 != 50) goto L20;
        int r14 = r12.j(r12.A());     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        if ((r4 & 32) == 32) goto L28;
        if (r12.e() <= 0) goto L28;
        this.n = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r4 = r4 | 32;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L28:
        if (r12.e() <= 0) goto L30;
        this.n.add(Integer.valueOf(r12.s()));     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L28
    L30:
        r12.i(r14);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L20:
        if (o(r12, r2, r13, r7) == true) goto L4;
    L37:
        if ((r4 & 16) == 16) goto L39;
        this.m = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r4 = r4 | 16;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L39:
        r8 = this.m;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r11 = r12.u(q.z, r13);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L48:
        r3 = true;
        goto L4
    L49:
        th = move-exception;
        if ((r4 & 16) != 16) goto L61;
        this.m = Collections.unmodifiableList(this.m);
    L61:
        if ((r4 & 32) != 32) goto L89;
        this.n = Collections.unmodifiableList(this.n);
    L89:
        r2.I();     // Catch: IOException -> L84 Throwable -> L65
    L65:
        th = move-exception;
        this.f20137g = r0.l();
        throw th;
    L64:
        this.f20137g = r0.l();
        l();
        throw th;
    L54:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L49
        throw e;     // Catch: Throwable -> L49
    L51:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r15 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L49
        r15.i(this);     // Catch: Throwable -> L49
        throw r15;     // Catch: Throwable -> L49
    L71:
        if ((r4 & 16) != 16) goto L74;
        this.m = Collections.unmodifiableList(this.m);
    L74:
        if ((r4 & 32) != 32) goto L86;
        this.n = Collections.unmodifiableList(this.n);
    L86:
        r2.I();     // Catch: IOException -> L83 Throwable -> L78
    L78:
        th = move-exception;
        this.f20137g = r0.l();
        throw th;
    L77:
        this.f20137g = r0.l();
        l();
    }

    /* synthetic */ s(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private s(kotlin.s0.w.d.l0.i.i.c<s, ?> r2) {
        super(r2);
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.f20137g = r2.m();
    }

    /* synthetic */ s(kotlin.s0.w.d.l0.i.i.c r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private s(boolean r1) {
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.f20137g = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ int A(s r0, int r1) {
        r0.f20139i = r1;
        return r1;
    }

    static /* synthetic */ int B(s r0, int r1) {
        r0.f20140j = r1;
        return r1;
    }

    static /* synthetic */ boolean C(s r0, boolean r1) {
        r0.f20141k = r1;
        return r1;
    }

    static /* synthetic */ c D(s r0, c r1) {
        r0.f20142l = r1;
        return r1;
    }

    static /* synthetic */ List E(s r0) {
        return r0.m;
    }

    static /* synthetic */ List F(s r0, List r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ List G(s r0) {
        return r0.n;
    }

    static /* synthetic */ List H(s r0, List r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ int I(s r0, int r1) {
        r0.f20138h = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d J(s r0) {
        return r0.f20137g;
    }

    public static s K() {
        return r;
    }

    private void Y() {
        this.f20139i = 0;
        this.f20140j = 0;
        this.f20141k = false;
        this.f20142l = c.f20149i;
        this.m = Collections.emptyList();
        this.n = Collections.emptyList();
    }

    public static b Z() {
        return b.u();
    }

    public static b a0(s r1) {
        b r0 = Z();
        r0.E(r1);
        return r0;
    }

    public s L() {
        return r;
    }

    public int M() {
        return this.f20139i;
    }

    public int N() {
        return this.f20140j;
    }

    public boolean O() {
        return this.f20141k;
    }

    public q P(int r1) {
        return this.m.get(r1);
    }

    public int Q() {
        return this.m.size();
    }

    public List<Integer> R() {
        return this.n;
    }

    public List<q> S() {
        return this.m;
    }

    public c T() {
        return this.f20142l;
    }

    public boolean U() {
        if ((this.f20138h & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean V() {
        if ((this.f20138h & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean W() {
        if ((this.f20138h & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean X() {
        if ((this.f20138h & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q a() {
        return L();
    }

    public b b0() {
        return Z();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return c0();
    }

    public b c0() {
        return a0(this);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r6) {
        e();
        kotlin.s0.w.d.l0.i.i.d<MessageType>.a r0 = y();
        if ((this.f20138h & 1) != 1) goto L6;
        r6.a0(1, this.f20139i);
    L6:
        if ((this.f20138h & 2) != 2) goto L9;
        r6.a0(2, this.f20140j);
    L9:
        if ((this.f20138h & 4) != 4) goto L12;
        r6.L(3, this.f20141k);
    L12:
        if ((this.f20138h & 8) != 8) goto L14;
        r6.S(4, this.f20142l.d());
    L14:
        int r1 = 0;
        int r2 = 0;
    L16:
        if (r2 >= this.m.size()) goto L19;
        r6.d0(5, this.m.get(r2));
        r2 = r2 + 1;
        goto L16
    L19:
        if (R().size() <= 0) goto L22;
        r6.o0(50);
        r6.o0(this.o);
    L22:
        if (r1 >= this.n.size()) goto L24;
        r6.b0(this.n.get(r1).intValue());
        r1 = r1 + 1;
        goto L22
    L24:
        r0.a(1000, r6);
        r6.i0(this.f20137g);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.q;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.f20138h & 1) != 1) goto L8;
        int r1 = kotlin.s0.w.d.l0.i.f.o(1, this.f20139i) + 0;
    L10:
        if ((this.f20138h & 2) != 2) goto L13;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(2, this.f20140j);
    L13:
        if ((this.f20138h & 4) != 4) goto L16;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.a(3, this.f20141k);
    L16:
        if ((this.f20138h & 8) != 8) goto L18;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.h(4, this.f20142l.d());
    L18:
        int r3 = 0;
    L20:
        if (r3 >= this.m.size()) goto L22;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(5, this.m.get(r3));
        r3 = r3 + 1;
        goto L20
    L22:
        int r4 = 0;
    L24:
        if (r2 >= this.n.size()) goto L26;
        r4 = r4 + kotlin.s0.w.d.l0.i.f.p(this.n.get(r2).intValue());
        r2 = r2 + 1;
        goto L24
    L26:
        int r5 = r1 + r4;
        if (R().isEmpty() == true) goto L29;
        r5 = (r5 + 1) + kotlin.s0.w.d.l0.i.f.p(r4);
    L29:
        this.o = r4;
        int r6 = (r5 + s()) + this.f20137g.size();
        this.q = r6;
        return r6;
    L8:
        r1 = 0;
        goto L10
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return b0();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<s> h() {
        return s;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.p;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (U() == true) goto L13;
        this.p = 0;
        return false;
    L13:
        if (V() == true) goto L16;
        this.p = 0;
        return false;
    L16:
        int r1 = 0;
    L18:
        if (r1 >= Q()) goto L25;
        if (P(r1).isInitialized() == false) goto L21;
        r1 = r1 + 1;
        goto L18
    L21:
        this.p = 0;
        return false;
    L25:
        if (r() == true) goto L28;
        this.p = 0;
        return false;
    L28:
        this.p = 1;
        return true;
    }
}

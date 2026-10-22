package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {
    private static final h q = null;
    public static kotlin.s0.w.d.l0.i.s<h> r;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f19998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f20002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private q f20003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f20004l;
    private List<h> m;
    private List<h> n;
    private byte o;
    private int p;

    static class a extends kotlin.s0.w.d.l0.i.b<h> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public h m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new h(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.b<h, b> implements Object {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20005g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f20006h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20007i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private c f20008j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private q f20009k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f20010l;
        private List<h> m;
        private List<h> n;

        private b() {
            this.f20008j = c.f20011g;
            this.f20009k = q.X();
            this.m = Collections.emptyList();
            this.n = Collections.emptyList();
            y();
        }

        static /* synthetic */ b p() {
            return u();
        }

        private static b u() {
            return new b();
        }

        private void v() {
            if ((this.f20005g & 32) == 32) goto L6;
            this.m = new ArrayList(this.m);
            this.f20005g |= 32;
            return;
        }

        private void w() {
            if ((this.f20005g & 64) == 64) goto L6;
            this.n = new ArrayList(this.n);
            this.f20005g |= 64;
            return;
        }

        private void y() {
        }

        public b B(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            h r0 = null;
            h r5 = h.r.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            z(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            h r6 = (h) e.a();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            z(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }

        public b C(q r4) {
            if ((this.f20005g & 8) == 8) goto L5;
        L7:
            this.f20009k = r4;
            this.f20005g |= 8;
            return this;
        L5:
            if (this.f20009k == q.X()) goto L7;
            r4 = q.y0(this.f20009k).F(r4).w();
            goto L7
        }

        public b D(c r2) {
            Objects.requireNonNull(r2);
            this.f20005g |= 4;
            this.f20008j = r2;
            return this;
        }

        public b E(int r2) {
            this.f20005g |= 1;
            this.f20006h = r2;
            return this;
        }

        public b F(int r2) {
            this.f20005g |= 16;
            this.f20010l = r2;
            return this;
        }

        public b G(int r2) {
            this.f20005g |= 2;
            this.f20007i = r2;
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
            B(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return t();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            z((h) r1);
            return this;
        }

        public h q() {
            h r1 = r();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public h r() {
            h r0 = new h(this, null);
            int r1 = this.f20005g;
            int r3 = 1;
            if ((r1 & 1) == 1) goto L6;
            r3 = 0;
        L6:
            h.q(r0, this.f20006h);
            if ((r1 & 2) != 2) goto L9;
            r3 = r3 | 2;
        L9:
            h.r(r0, this.f20007i);
            if ((r1 & 4) != 4) goto L12;
            r3 = r3 | 4;
        L12:
            h.s(r0, this.f20008j);
            if ((r1 & 8) != 8) goto L15;
            r3 = r3 | 8;
        L15:
            h.t(r0, this.f20009k);
            if ((r1 & 16) != 16) goto L18;
            r3 = r3 | 16;
        L18:
            h.u(r0, this.f20010l);
            if ((this.f20005g & 32) != 32) goto L21;
            this.m = Collections.unmodifiableList(this.m);
            this.f20005g &= -33;
        L21:
            h.w(r0, this.m);
            if ((this.f20005g & 64) != 64) goto L24;
            this.n = Collections.unmodifiableList(this.n);
            this.f20005g &= -65;
        L24:
            h.z(r0, this.n);
            h.A(r0, r3);
            return r0;
        }

        public b t() {
            b r0 = u();
            r0.z(r());
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            B(r1, r2);
            return this;
        }

        public b z(h r3) {
            if (r3 != h.F()) goto L6;
            return this;
        L6:
            if (r3.N() == false) goto L9;
            E(r3.G());
        L9:
            if (r3.Q() == false) goto L12;
            G(r3.L());
        L12:
            if (r3.M() == false) goto L15;
            D(r3.E());
        L15:
            if (r3.O() == false) goto L18;
            C(r3.H());
        L18:
            if (r3.P() == false) goto L21;
            F(r3.I());
        L21:
            if (h.v(r3).isEmpty() == true) goto L27;
            if (this.m.isEmpty() == false) goto L25;
            this.m = h.v(r3);
            this.f20005g &= -33;
            goto L27
        L25:
            v();
            this.m.addAll(h.v(r3));
        L27:
            if (h.y(r3).isEmpty() == false) goto L29;
        L32:
            o(m().b(h.B(r3)));
            return this;
        L29:
            if (this.n.isEmpty() == false) goto L31;
            this.n = h.y(r3);
            this.f20005g &= -65;
            goto L32
        L31:
            w();
            this.n.addAll(h.y(r3));
            goto L32
        }
    }

    public static final enum c extends Enum<c> implements kotlin.s0.w.d.l0.i.j.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f20011g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f20012h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f20013i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ c[] f20014j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f20015f;

        static {
            c r0 = new c("TRUE", 0, 0, 0);
            f20011g = r0;
            c r1 = new c("FALSE", 1, 1, 1);
            f20012h = r1;
            c r3 = new c("NULL", 2, 2, 2);
            f20013i = r3;
            f20014j = new c[]{r0, r1, r3};
        }

        private c(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.f20015f = r4;
        }

        public static c a(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return f20013i;
        L12:
            return f20012h;
        L14:
            return f20011g;
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f20014j.clone();
        }

        @Override // kotlin.s0.w.d.l0.i.j.a
        public final int d() {
            return this.f20015f;
        }
    }

    static {
        r = new a();
        h r0 = new h(true);
        q = r0;
        r0.R();
    }

    private h(kotlin.s0.w.d.l0.i.e r12, kotlin.s0.w.d.l0.i.g r13) {
        this.o = -1;
        this.p = -1;
        R();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L71;
        int r7 = r12.K();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        if (r7 == 0) goto L48;
        if (r7 != 8) goto L10;
        this.f19999g |= 1;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20000h = r12.s();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L10:
        if (r7 != 16) goto L12;
        this.f19999g |= 2;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20001i = r12.s();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L12:
        if (r7 != 24) goto L14;
        int r8 = r12.n();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        c r9 = c.a(r8);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        if (r9 == null) goto L43;
        this.f19999g |= 4;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20002j = r9;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L43:
        r2.o0(r7);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r2.o0(r8);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L14:
        if (r7 != 34) goto L16;
        q.c r10 = null;
        if ((this.f19999g & 8) != 8) goto L37;
        r10 = this.f20003k.A0();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L37:
        q r11 = (q) r12.u(q.z, r13);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20003k = r11;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        if (r10 == null) goto L40;
        r10.F(r11);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20003k = r10.w();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L40:
        this.f19999g |= 8;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L16:
        if (r7 != 40) goto L18;
        this.f19999g |= 16;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        this.f20004l = r12.s();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L18:
        if (r7 == 50) goto L30;
        if (r7 != 58) goto L22;
        if ((r4 & 64) == 64) goto L27;
        this.n = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r4 = r4 | 64;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L27:
        List r14 = this.n;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        kotlin.s0.w.d.l0.i.q r15 = r12.u(r, r13);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L28:
        r14.add(r15);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        goto L4
    L22:
        if (o(r12, r2, r13, r7) == true) goto L4;
    L30:
        if ((r4 & 32) == 32) goto L32;
        this.m = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r4 = r4 | 32;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L32:
        r14 = this.m;     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
        r15 = r12.u(r, r13);     // Catch: Throwable -> L49 IOException -> L51 kotlin.s0.w.d.l0.i.k -> L54
    L48:
        r3 = true;
        goto L4
    L49:
        th = move-exception;
        if ((r4 & 32) != 32) goto L61;
        this.m = Collections.unmodifiableList(this.m);
    L61:
        if ((r4 & 64) != 64) goto L87;
        this.n = Collections.unmodifiableList(this.n);
    L87:
        r2.I();     // Catch: IOException -> L84 Throwable -> L65
    L65:
        th = move-exception;
        this.f19998f = r0.l();
        throw th;
    L64:
        this.f19998f = r0.l();
        l();
        throw th;
    L54:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L49
        throw e;     // Catch: Throwable -> L49
    L51:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r16 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L49
        r16.i(this);     // Catch: Throwable -> L49
        throw r16;     // Catch: Throwable -> L49
    L71:
        if ((r4 & 32) != 32) goto L74;
        this.m = Collections.unmodifiableList(this.m);
    L74:
        if ((r4 & 64) != 64) goto L89;
        this.n = Collections.unmodifiableList(this.n);
    L89:
        r2.I();     // Catch: IOException -> L83 Throwable -> L78
    L78:
        th = move-exception;
        this.f19998f = r0.l();
        throw th;
    L77:
        this.f19998f = r0.l();
        l();
    }

    /* synthetic */ h(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private h(kotlin.s0.w.d.l0.i.i.b r2) {
        super(r2);
        this.o = -1;
        this.p = -1;
        this.f19998f = r2.m();
    }

    /* synthetic */ h(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private h(boolean r1) {
        this.o = -1;
        this.p = -1;
        this.f19998f = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ int A(h r0, int r1) {
        r0.f19999g = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d B(h r0) {
        return r0.f19998f;
    }

    public static h F() {
        return q;
    }

    private void R() {
        this.f20000h = 0;
        this.f20001i = 0;
        this.f20002j = c.f20011g;
        this.f20003k = q.X();
        this.f20004l = 0;
        this.m = Collections.emptyList();
        this.n = Collections.emptyList();
    }

    public static b S() {
        return b.p();
    }

    public static b T(h r1) {
        b r0 = S();
        r0.z(r1);
        return r0;
    }

    static /* synthetic */ int q(h r0, int r1) {
        r0.f20000h = r1;
        return r1;
    }

    static /* synthetic */ int r(h r0, int r1) {
        r0.f20001i = r1;
        return r1;
    }

    static /* synthetic */ c s(h r0, c r1) {
        r0.f20002j = r1;
        return r1;
    }

    static /* synthetic */ q t(h r0, q r1) {
        r0.f20003k = r1;
        return r1;
    }

    static /* synthetic */ int u(h r0, int r1) {
        r0.f20004l = r1;
        return r1;
    }

    static /* synthetic */ List v(h r0) {
        return r0.m;
    }

    static /* synthetic */ List w(h r0, List r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ List y(h r0) {
        return r0.n;
    }

    static /* synthetic */ List z(h r0, List r1) {
        r0.n = r1;
        return r1;
    }

    public h C(int r1) {
        return this.m.get(r1);
    }

    public int D() {
        return this.m.size();
    }

    public c E() {
        return this.f20002j;
    }

    public int G() {
        return this.f20000h;
    }

    public q H() {
        return this.f20003k;
    }

    public int I() {
        return this.f20004l;
    }

    public h J(int r1) {
        return this.n.get(r1);
    }

    public int K() {
        return this.n.size();
    }

    public int L() {
        return this.f20001i;
    }

    public boolean M() {
        if ((this.f19999g & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean N() {
        if ((this.f19999g & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean O() {
        if ((this.f19999g & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean P() {
        if ((this.f19999g & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean Q() {
        if ((this.f19999g & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public b U() {
        return S();
    }

    public b V() {
        return T(this);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return V();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r5) {
        e();
        if ((this.f19999g & 1) != 1) goto L6;
        r5.a0(1, this.f20000h);
    L6:
        if ((this.f19999g & 2) != 2) goto L9;
        r5.a0(2, this.f20001i);
    L9:
        if ((this.f19999g & 4) != 4) goto L12;
        r5.S(3, this.f20002j.d());
    L12:
        if ((this.f19999g & 8) != 8) goto L15;
        r5.d0(4, this.f20003k);
    L15:
        if ((this.f19999g & 16) != 16) goto L17;
        r5.a0(5, this.f20004l);
    L17:
        int r0 = 0;
        int r1 = 0;
    L19:
        if (r1 >= this.m.size()) goto L22;
        r5.d0(6, this.m.get(r1));
        r1 = r1 + 1;
    L22:
        if (r0 >= this.n.size()) goto L24;
        r5.d0(7, this.n.get(r0));
        r0 = r0 + 1;
        goto L22
    L24:
        r5.i0(this.f19998f);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.p;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.f19999g & 1) != 1) goto L8;
        int r1 = kotlin.s0.w.d.l0.i.f.o(1, this.f20000h) + 0;
    L10:
        if ((this.f19999g & 2) != 2) goto L13;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(2, this.f20001i);
    L13:
        if ((this.f19999g & 4) != 4) goto L16;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.h(3, this.f20002j.d());
    L16:
        if ((this.f19999g & 8) != 8) goto L19;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(4, this.f20003k);
    L19:
        if ((this.f19999g & 16) != 16) goto L21;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.o(5, this.f20004l);
    L21:
        int r3 = 0;
    L23:
        if (r3 >= this.m.size()) goto L26;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(6, this.m.get(r3));
        r3 = r3 + 1;
    L26:
        if (r2 >= this.n.size()) goto L28;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(7, this.n.get(r2));
        r2 = r2 + 1;
        goto L26
    L28:
        int r4 = r1 + this.f19998f.size();
        this.p = r4;
        return r4;
    L8:
        r1 = 0;
        goto L10
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return U();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<h> h() {
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
        if (O() == true) goto L11;
    L14:
        int r1 = 0;
    L16:
        if (r1 >= D()) goto L22;
        if (C(r1).isInitialized() == false) goto L19;
        r1 = r1 + 1;
        goto L16
    L19:
        this.o = 0;
        return false;
    L22:
        int r2 = 0;
    L24:
        if (r2 >= K()) goto L30;
        if (J(r2).isInitialized() == false) goto L27;
        r2 = r2 + 1;
        goto L24
    L27:
        this.o = 0;
        return false;
    L30:
        this.o = 1;
        return true;
    L11:
        if (H().isInitialized() == true) goto L14;
        this.o = 0;
        return false;
    }
}

package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends kotlin.s0.w.d.l0.i.i.d<m> implements Object {
    private static final m o = null;
    public static kotlin.s0.w.d.l0.i.s<m> p;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private p f20050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private o f20051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private l f20052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<c> f20053l;
    private byte m;
    private int n;

    static class a extends kotlin.s0.w.d.l0.i.b<m> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public m m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new m(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.c<m, b> implements Object {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20054i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private p f20055j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private o f20056k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private l f20057l;
        private List<c> m;

        private b() {
            this.f20055j = p.t();
            this.f20056k = o.t();
            this.f20057l = l.K();
            this.m = Collections.emptyList();
            C();
        }

        private void B() {
            if ((this.f20054i & 8) == 8) goto L6;
            this.m = new ArrayList(this.m);
            this.f20054i |= 8;
            return;
        }

        private void C() {
        }

        static /* synthetic */ b u() {
            return z();
        }

        private static b z() {
            return new b();
        }

        public b D(m r3) {
            if (r3 != m.K()) goto L6;
            return this;
        L6:
            if (r3.R() == false) goto L9;
            H(r3.O());
        L9:
            if (r3.Q() == false) goto L12;
            G(r3.N());
        L12:
            if (r3.P() == false) goto L15;
            F(r3.M());
        L15:
            if (m.D(r3).isEmpty() == false) goto L17;
        L20:
            t(r3);
            o(m().b(m.G(r3)));
            return this;
        L17:
            if (this.m.isEmpty() == false) goto L19;
            this.m = m.D(r3);
            this.f20054i &= -9;
            goto L20
        L19:
            B();
            this.m.addAll(m.D(r3));
            goto L20
        }

        public b E(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            m r0 = null;
            m r5 = m.p.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            D(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            m r6 = (m) e.a();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            D(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }

        public b F(l r4) {
            if ((this.f20054i & 4) == 4) goto L5;
        L7:
            this.f20057l = r4;
            this.f20054i |= 4;
            return this;
        L5:
            if (this.f20057l == l.K()) goto L7;
            l.b r0 = l.b0(this.f20057l);
            r0.F(r4);
            r4 = r0.w();
            goto L7
        }

        public b G(o r4) {
            if ((this.f20054i & 2) == 2) goto L5;
        L7:
            this.f20056k = r4;
            this.f20054i |= 2;
            return this;
        L5:
            if (this.f20056k == o.t()) goto L7;
            o.b r0 = o.z(this.f20056k);
            r0.y(r4);
            r4 = r0.r();
            goto L7
        }

        public b H(p r4) {
            if ((this.f20054i & 1) == 1) goto L5;
        L7:
            this.f20055j = r4;
            this.f20054i |= 1;
            return this;
        L5:
            if (this.f20055j == p.t()) goto L7;
            p.b r0 = p.z(this.f20055j);
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
            E(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return y();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            D((m) r1);
            return this;
        }

        public m v() {
            m r1 = w();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public m w() {
            m r0 = new m(this, null);
            int r1 = this.f20054i;
            int r3 = 1;
            if ((r1 & 1) == 1) goto L6;
            r3 = 0;
        L6:
            m.A(r0, this.f20055j);
            if ((r1 & 2) != 2) goto L9;
            r3 = r3 | 2;
        L9:
            m.B(r0, this.f20056k);
            if ((r1 & 4) != 4) goto L12;
            r3 = r3 | 4;
        L12:
            m.C(r0, this.f20057l);
            if ((this.f20054i & 8) != 8) goto L15;
            this.m = Collections.unmodifiableList(this.m);
            this.f20054i &= -9;
        L15:
            m.E(r0, this.m);
            m.F(r0, r3);
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            E(r1, r2);
            return this;
        }

        public b y() {
            b r0 = z();
            r0.D(w());
            return r0;
        }
    }

    static {
        p = new a();
        m r0 = new m(true);
        o = r0;
        r0.S();
    }

    private m(kotlin.s0.w.d.l0.i.e r10, kotlin.s0.w.d.l0.i.g r11) {
        this.m = -1;
        this.n = -1;
        S();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L65;
        int r6 = r10.K();     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        if (r6 == 0) goto L45;
        o.b r8 = null;
        p.b r9 = null;
        l.b r12 = null;
        if (r6 != 10) goto L10;
        if ((this.f20049h & 1) != 1) goto L40;
        r9 = this.f20050i.B();     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
    L40:
        p r7 = (p) r10.u(p.f20093k, r11);     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        this.f20050i = r7;     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        if (r9 == null) goto L43;
        r9.y(r7);     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        this.f20050i = r9.r();     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
    L43:
        this.f20049h |= 1;     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        goto L4
    L10:
        if (r6 == 18) goto L30;
        if (r6 != 26) goto L14;
        int r13 = 4;
        if ((this.f20049h & 4) != 4) goto L25;
        r12 = this.f20052k.e0();     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
    L25:
        l r14 = (l) r10.u(l.q, r11);     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        this.f20052k = r14;     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        if (r12 == null) goto L28;
        r12.F(r14);     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        this.f20052k = r12.w();     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
    L28:
        int r15 = this.f20049h;     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
    L29:
        this.f20049h = r15 | r13;     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        goto L4
    L14:
        if (r6 != 34) goto L16;
        int r16 = (r4 == true ? 1 : 0) & 8;     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        r4 = r4;
        if (r16 == 8) goto L21;
        this.f20053l = new ArrayList();     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        r4 = (r4 == true ? 1 : 0) | 8;     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
    L21:
        this.f20053l.add((c) r10.u(c.P, r11));     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        goto L4
    L16:
        if (o(r10, r2, r11, r6) == true) goto L4;
    L30:
        r13 = 2;
        if ((this.f20049h & 2) != 2) goto L33;
        r8 = this.f20051j.B();     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
    L33:
        o r17 = (o) r10.u(o.f20069k, r11);     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        this.f20051j = r17;     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        if (r8 == null) goto L36;
        r8.y(r17);     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
        this.f20051j = r8.r();     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
    L36:
        r15 = this.f20049h;     // Catch: Throwable -> L46 IOException -> L48 kotlin.s0.w.d.l0.i.k -> L51
    L45:
        r3 = true;
        goto L4
    L46:
        th = move-exception;
        if (((r4 == true ? 1 : 0) & 8) != 8) goto L78;
        this.f20053l = Collections.unmodifiableList(this.f20053l);
    L78:
        r2.I();     // Catch: IOException -> L75 Throwable -> L59
    L59:
        th = move-exception;
        this.f20048g = r0.l();
        throw th;
    L58:
        this.f20048g = r0.l();
        l();
        throw th;
    L51:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L46
        throw e;     // Catch: Throwable -> L46
    L48:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r18 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L46
        r18.i(this);     // Catch: Throwable -> L46
        throw r18;     // Catch: Throwable -> L46
    L65:
        if (((r4 == true ? 1 : 0) & 8) != 8) goto L80;
        this.f20053l = Collections.unmodifiableList(this.f20053l);
    L80:
        r2.I();     // Catch: IOException -> L74 Throwable -> L69
    L69:
        th = move-exception;
        this.f20048g = r0.l();
        throw th;
    L68:
        this.f20048g = r0.l();
        l();
    }

    /* synthetic */ m(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private m(kotlin.s0.w.d.l0.i.i.c<m, ?> r2) {
        super(r2);
        this.m = -1;
        this.n = -1;
        this.f20048g = r2.m();
    }

    /* synthetic */ m(kotlin.s0.w.d.l0.i.i.c r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private m(boolean r1) {
        this.m = -1;
        this.n = -1;
        this.f20048g = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ p A(m r0, p r1) {
        r0.f20050i = r1;
        return r1;
    }

    static /* synthetic */ o B(m r0, o r1) {
        r0.f20051j = r1;
        return r1;
    }

    static /* synthetic */ l C(m r0, l r1) {
        r0.f20052k = r1;
        return r1;
    }

    static /* synthetic */ List D(m r0) {
        return r0.f20053l;
    }

    static /* synthetic */ List E(m r0, List r1) {
        r0.f20053l = r1;
        return r1;
    }

    static /* synthetic */ int F(m r0, int r1) {
        r0.f20049h = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d G(m r0) {
        return r0.f20048g;
    }

    public static m K() {
        return o;
    }

    private void S() {
        this.f20050i = p.t();
        this.f20051j = o.t();
        this.f20052k = l.K();
        this.f20053l = Collections.emptyList();
    }

    public static b T() {
        return b.u();
    }

    public static b U(m r1) {
        b r0 = T();
        r0.D(r1);
        return r0;
    }

    public static m W(InputStream r1, kotlin.s0.w.d.l0.i.g r2) {
        return p.a(r1, r2);
    }

    public c H(int r1) {
        return this.f20053l.get(r1);
    }

    public int I() {
        return this.f20053l.size();
    }

    public List<c> J() {
        return this.f20053l;
    }

    public m L() {
        return o;
    }

    public l M() {
        return this.f20052k;
    }

    public o N() {
        return this.f20051j;
    }

    public p O() {
        return this.f20050i;
    }

    public boolean P() {
        if ((this.f20049h & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean Q() {
        if ((this.f20049h & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean R() {
        if ((this.f20049h & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public b V() {
        return T();
    }

    public b X() {
        return U(this);
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q a() {
        return L();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return X();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r5) {
        e();
        kotlin.s0.w.d.l0.i.i.d<MessageType>.a r0 = y();
        if ((this.f20049h & 1) != 1) goto L6;
        r5.d0(1, this.f20050i);
    L6:
        if ((this.f20049h & 2) != 2) goto L9;
        r5.d0(2, this.f20051j);
    L9:
        if ((this.f20049h & 4) != 4) goto L11;
        r5.d0(3, this.f20052k);
    L11:
        int r1 = 0;
    L13:
        if (r1 >= this.f20053l.size()) goto L15;
        r5.d0(4, this.f20053l.get(r1));
        r1 = r1 + 1;
        goto L13
    L15:
        r0.a(200, r5);
        r5.i0(this.f20048g);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.n;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.f20049h & 1) != 1) goto L8;
        int r1 = kotlin.s0.w.d.l0.i.f.s(1, this.f20050i) + 0;
    L10:
        if ((this.f20049h & 2) != 2) goto L13;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(2, this.f20051j);
    L13:
        if ((this.f20049h & 4) != 4) goto L16;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(3, this.f20052k);
    L16:
        if (r2 >= this.f20053l.size()) goto L18;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(4, this.f20053l.get(r2));
        r2 = r2 + 1;
        goto L16
    L18:
        int r3 = (r1 + s()) + this.f20048g.size();
        this.n = r3;
        return r3;
    L8:
        r1 = 0;
        goto L10
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return V();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<m> h() {
        return p;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.m;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (Q() == false) goto L15;
        if (N().isInitialized() == true) goto L15;
        this.m = 0;
        return false;
    L15:
        if (P() == true) goto L17;
    L20:
        int r1 = 0;
    L22:
        if (r1 >= I()) goto L29;
        if (H(r1).isInitialized() == false) goto L25;
        r1 = r1 + 1;
        goto L22
    L25:
        this.m = 0;
        return false;
    L29:
        if (r() == true) goto L32;
        this.m = 0;
        return false;
    L32:
        this.m = 1;
        return true;
    L17:
        if (M().isInitialized() == true) goto L20;
        this.m = 0;
        return false;
    }
}

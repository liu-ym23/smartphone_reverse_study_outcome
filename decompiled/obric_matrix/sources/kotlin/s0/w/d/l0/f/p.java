package kotlin.s0.w.d.l0.f;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final p f20092j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static kotlin.s0.w.d.l0.i.s<p> f20093k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private kotlin.s0.w.d.l0.i.o f20095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte f20096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20097i;

    static class a extends kotlin.s0.w.d.l0.i.b<p> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public p m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new p(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.b<p, b> implements Object {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20098g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private kotlin.s0.w.d.l0.i.o f20099h;

        private b() {
            this.f20099h = kotlin.s0.w.d.l0.i.n.f20367g;
            w();
        }

        static /* synthetic */ b p() {
            return u();
        }

        private static b u() {
            return new b();
        }

        private void v() {
            if ((this.f20098g & 1) == 1) goto L6;
            this.f20099h = new kotlin.s0.w.d.l0.i.n(this.f20099h);
            this.f20098g |= 1;
            return;
        }

        private void w() {
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
            z(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return t();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            y((p) r1);
            return this;
        }

        public p q() {
            p r1 = r();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public p r() {
            p r0 = new p(this, null);
            if ((this.f20098g & 1) != 1) goto L5;
            this.f20099h = this.f20099h.h();
            this.f20098g &= -2;
        L5:
            p.r(r0, this.f20099h);
            return r0;
        }

        public b t() {
            b r0 = u();
            r0.y(r());
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.i.a.AbstractC0550a, kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a x(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            z(r1, r2);
            return this;
        }

        public b y(p r3) {
            if (r3 != p.t()) goto L6;
            return this;
        L6:
            if (p.q(r3).isEmpty() == false) goto L8;
        L11:
            o(m().b(p.s(r3)));
            return this;
        L8:
            if (this.f20099h.isEmpty() == false) goto L10;
            this.f20099h = p.q(r3);
            this.f20098g &= -2;
            goto L11
        L10:
            v();
            this.f20099h.addAll(p.q(r3));
            goto L11
        }

        public b z(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            p r0 = null;
            p r5 = p.f20093k.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            y(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            p r6 = (p) e.a();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            y(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }
    }

    static {
        f20093k = new a();
        p r0 = new p(true);
        f20092j = r0;
        r0.w();
    }

    private p(kotlin.s0.w.d.l0.i.e r8, kotlin.s0.w.d.l0.i.g r9) {
        this.f20096h = -1;
        this.f20097i = -1;
        w();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        boolean r4 = false;
    L3:
        if (r3 == true) goto L36;
        int r5 = r8.K();     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
        if (r5 == 0) goto L16;
        if (r5 != 10) goto L9;
        kotlin.s0.w.d.l0.i.d r6 = r8.l();     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
        if ((r4 & true) == true) goto L14;
        this.f20095g = new kotlin.s0.w.d.l0.i.n();     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
        r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
    L14:
        this.f20095g.j(r6);     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
        goto L3
    L9:
        if (o(r8, r2, r9, r5) == true) goto L3;
    L16:
        r3 = true;
        goto L3
    L17:
        th = move-exception;
        if ((r4 & true) != true) goto L51;
        this.f20095g = this.f20095g.h();
    L51:
        r2.I();     // Catch: IOException -> L46 Throwable -> L30
    L30:
        th = move-exception;
        this.f20094f = r0.l();
        throw th;
    L29:
        this.f20094f = r0.l();
        l();
        throw th;
    L22:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L19:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r10 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L17
        r10.i(this);     // Catch: Throwable -> L17
        throw r10;     // Catch: Throwable -> L17
    L36:
        if ((r4 & true) != true) goto L49;
        this.f20095g = this.f20095g.h();
    L49:
        r2.I();     // Catch: IOException -> L45 Throwable -> L40
    L40:
        th = move-exception;
        this.f20094f = r0.l();
        throw th;
    L39:
        this.f20094f = r0.l();
        l();
    }

    /* synthetic */ p(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private p(kotlin.s0.w.d.l0.i.i.b r2) {
        super(r2);
        this.f20096h = -1;
        this.f20097i = -1;
        this.f20094f = r2.m();
    }

    /* synthetic */ p(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private p(boolean r1) {
        this.f20096h = -1;
        this.f20097i = -1;
        this.f20094f = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.o q(p r0) {
        return r0.f20095g;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.o r(p r0, kotlin.s0.w.d.l0.i.o r1) {
        r0.f20095g = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d s(p r0) {
        return r0.f20094f;
    }

    public static p t() {
        return f20092j;
    }

    private void w() {
        this.f20095g = kotlin.s0.w.d.l0.i.n.f20367g;
    }

    public static b y() {
        return b.p();
    }

    public static b z(p r1) {
        b r0 = y();
        r0.y(r1);
        return r0;
    }

    public b A() {
        return y();
    }

    public b B() {
        return z(this);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return B();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r4) {
        e();
        int r0 = 0;
    L4:
        if (r0 >= this.f20095g.size()) goto L6;
        r4.O(1, this.f20095g.f(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        r4.i0(this.f20094f);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.f20097i;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.f20095g.size()) goto L9;
        r2 = r2 + kotlin.s0.w.d.l0.i.f.e(this.f20095g.f(r1));
        r1 = r1 + 1;
        goto L7
    L9:
        int r3 = ((0 + r2) + (v().size() * 1)) + this.f20094f.size();
        this.f20097i = r3;
        return r3;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return A();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<p> h() {
        return f20093k;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.f20096h;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
        return false;
    L8:
        this.f20096h = 1;
        return true;
    }

    public String u(int r1) {
        return this.f20095g.get(r1);
    }

    public kotlin.s0.w.d.l0.i.t v() {
        return this.f20095g;
    }
}

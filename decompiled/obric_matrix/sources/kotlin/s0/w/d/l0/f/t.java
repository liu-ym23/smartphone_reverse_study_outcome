package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final t f20152l = null;
    public static kotlin.s0.w.d.l0.i.s<t> m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<q> f20155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20156i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte f20157j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f20158k;

    static class a extends kotlin.s0.w.d.l0.i.b<t> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public t m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new t(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.b<t, b> implements Object {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20159g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<q> f20160h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f20161i;

        private b() {
            this.f20160h = Collections.emptyList();
            this.f20161i = -1;
            w();
        }

        static /* synthetic */ b p() {
            return u();
        }

        private static b u() {
            return new b();
        }

        private void v() {
            if ((this.f20159g & 1) == 1) goto L6;
            this.f20160h = new ArrayList(this.f20160h);
            this.f20159g |= 1;
            return;
        }

        private void w() {
        }

        public b B(int r2) {
            this.f20159g |= 2;
            this.f20161i = r2;
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
            z(r1, r2);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b k() {
            return t();
        }

        @Override // kotlin.s0.w.d.l0.i.i.b
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.i.b n(kotlin.s0.w.d.l0.i.i r1) {
            y((t) r1);
            return this;
        }

        public t q() {
            t r1 = r();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public t r() {
            t r0 = new t(this, null);
            int r1 = this.f20159g;
            int r3 = 1;
            if ((r1 & 1) != 1) goto L5;
            this.f20160h = Collections.unmodifiableList(this.f20160h);
            this.f20159g &= -2;
        L5:
            t.r(r0, this.f20160h);
            if ((r1 & 2) == 2) goto L9;
            r3 = 0;
        L9:
            t.s(r0, this.f20161i);
            t.t(r0, r3);
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

        public b y(t r3) {
            if (r3 != t.v()) goto L6;
            return this;
        L6:
            if (t.q(r3).isEmpty() == true) goto L12;
            if (this.f20160h.isEmpty() == false) goto L10;
            this.f20160h = t.q(r3);
            this.f20159g &= -2;
            goto L12
        L10:
            v();
            this.f20160h.addAll(t.q(r3));
        L12:
            if (r3.B() == false) goto L14;
            B(r3.w());
        L14:
            o(m().b(t.u(r3)));
            return this;
        }

        public b z(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            t r0 = null;
            t r5 = t.m.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            y(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            t r6 = (t) e.a();     // Catch: Throwable -> L7
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
        m = new a();
        t r0 = new t(true);
        f20152l = r0;
        r0.C();
    }

    private t(kotlin.s0.w.d.l0.i.e r8, kotlin.s0.w.d.l0.i.g r9) {
        this.f20157j = -1;
        this.f20158k = -1;
        C();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        boolean r4 = false;
    L3:
        if (r3 == true) goto L39;
        int r5 = r8.K();     // Catch: Throwable -> L20 IOException -> L22 kotlin.s0.w.d.l0.i.k -> L25
        if (r5 == 0) goto L19;
        if (r5 != 10) goto L9;
        if ((r4 & true) == true) goto L17;
        this.f20155h = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 kotlin.s0.w.d.l0.i.k -> L25
        r4 = r4 | true;     // Catch: Throwable -> L20 IOException -> L22 kotlin.s0.w.d.l0.i.k -> L25
    L17:
        this.f20155h.add((q) r8.u(q.z, r9));     // Catch: Throwable -> L20 IOException -> L22 kotlin.s0.w.d.l0.i.k -> L25
        goto L3
    L9:
        if (r5 != 16) goto L11;
        this.f20154g |= 1;     // Catch: Throwable -> L20 IOException -> L22 kotlin.s0.w.d.l0.i.k -> L25
        this.f20156i = r8.s();     // Catch: Throwable -> L20 IOException -> L22 kotlin.s0.w.d.l0.i.k -> L25
        goto L3
    L11:
        if (o(r8, r2, r9, r5) == true) goto L3;
    L19:
        r3 = true;
        goto L3
    L20:
        th = move-exception;
        if ((r4 & true) != true) goto L54;
        this.f20155h = Collections.unmodifiableList(this.f20155h);
    L54:
        r2.I();     // Catch: IOException -> L49 Throwable -> L33
    L33:
        th = move-exception;
        this.f20153f = r0.l();
        throw th;
    L32:
        this.f20153f = r0.l();
        l();
        throw th;
    L25:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L20
        throw e;     // Catch: Throwable -> L20
    L22:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r10 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L20
        r10.i(this);     // Catch: Throwable -> L20
        throw r10;     // Catch: Throwable -> L20
    L39:
        if ((r4 & true) != true) goto L51;
        this.f20155h = Collections.unmodifiableList(this.f20155h);
    L51:
        r2.I();     // Catch: IOException -> L48 Throwable -> L43
    L43:
        th = move-exception;
        this.f20153f = r0.l();
        throw th;
    L42:
        this.f20153f = r0.l();
        l();
    }

    /* synthetic */ t(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private t(kotlin.s0.w.d.l0.i.i.b r2) {
        super(r2);
        this.f20157j = -1;
        this.f20158k = -1;
        this.f20153f = r2.m();
    }

    /* synthetic */ t(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private t(boolean r1) {
        this.f20157j = -1;
        this.f20158k = -1;
        this.f20153f = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    private void C() {
        this.f20155h = Collections.emptyList();
        this.f20156i = -1;
    }

    public static b D() {
        return b.p();
    }

    public static b E(t r1) {
        b r0 = D();
        r0.y(r1);
        return r0;
    }

    static /* synthetic */ List q(t r0) {
        return r0.f20155h;
    }

    static /* synthetic */ List r(t r0, List r1) {
        r0.f20155h = r1;
        return r1;
    }

    static /* synthetic */ int s(t r0, int r1) {
        r0.f20156i = r1;
        return r1;
    }

    static /* synthetic */ int t(t r0, int r1) {
        r0.f20154g = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d u(t r0) {
        return r0.f20153f;
    }

    public static t v() {
        return f20152l;
    }

    public List<q> A() {
        return this.f20155h;
    }

    public boolean B() {
        if ((this.f20154g & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public b F() {
        return D();
    }

    public b G() {
        return E(this);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return G();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r4) {
        e();
        int r0 = 0;
    L4:
        if (r0 >= this.f20155h.size()) goto L7;
        r4.d0(1, this.f20155h.get(r0));
        r0 = r0 + 1;
        goto L4
    L7:
        if ((this.f20154g & 1) != 1) goto L9;
        r4.a0(2, this.f20156i);
    L9:
        r4.i0(this.f20153f);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.f20158k;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.f20155h.size()) goto L10;
        r2 = r2 + kotlin.s0.w.d.l0.i.f.s(1, this.f20155h.get(r1));
        r1 = r1 + 1;
        goto L7
    L10:
        if ((this.f20154g & 1) != 1) goto L12;
        r2 = r2 + kotlin.s0.w.d.l0.i.f.o(2, this.f20156i);
    L12:
        int r3 = r2 + this.f20153f.size();
        this.f20158k = r3;
        return r3;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return F();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<t> h() {
        return m;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.f20157j;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= z()) goto L16;
        if (y(r1).isInitialized() == false) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        this.f20157j = 0;
        return false;
    L16:
        this.f20157j = 1;
        return true;
    }

    public int w() {
        return this.f20156i;
    }

    public q y(int r1) {
        return this.f20155h.get(r1);
    }

    public int z() {
        return this.f20155h.size();
    }
}

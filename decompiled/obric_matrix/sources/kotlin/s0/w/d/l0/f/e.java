package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final e f19960j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static kotlin.s0.w.d.l0.i.s<e> f19961k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f19962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<f> f19963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte f19964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19965i;

    static class a extends kotlin.s0.w.d.l0.i.b<e> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public e m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new e(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.b<e, b> implements Object {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f19966g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<f> f19967h;

        private b() {
            this.f19967h = Collections.emptyList();
            w();
        }

        static /* synthetic */ b p() {
            return u();
        }

        private static b u() {
            return new b();
        }

        private void v() {
            if ((this.f19966g & 1) == 1) goto L6;
            this.f19967h = new ArrayList(this.f19967h);
            this.f19966g |= 1;
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
            y((e) r1);
            return this;
        }

        public e q() {
            e r1 = r();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public e r() {
            e r0 = new e(this, null);
            if ((this.f19966g & 1) != 1) goto L5;
            this.f19967h = Collections.unmodifiableList(this.f19967h);
            this.f19966g &= -2;
        L5:
            e.r(r0, this.f19967h);
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

        public b y(e r3) {
            if (r3 != e.t()) goto L6;
            return this;
        L6:
            if (e.q(r3).isEmpty() == false) goto L8;
        L11:
            o(m().b(e.s(r3)));
            return this;
        L8:
            if (this.f19967h.isEmpty() == false) goto L10;
            this.f19967h = e.q(r3);
            this.f19966g &= -2;
            goto L11
        L10:
            v();
            this.f19967h.addAll(e.q(r3));
            goto L11
        }

        public b z(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            e r0 = null;
            e r5 = e.f19961k.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            y(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            e r6 = (e) e.a();     // Catch: Throwable -> L7
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
        f19961k = new a();
        e r0 = new e(true);
        f19960j = r0;
        r0.w();
    }

    private e(kotlin.s0.w.d.l0.i.e r8, kotlin.s0.w.d.l0.i.g r9) {
        this.f19964h = -1;
        this.f19965i = -1;
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
        if ((r4 & true) == true) goto L14;
        this.f19963g = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
        r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
    L14:
        this.f19963g.add((f) r8.u(f.o, r9));     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
        goto L3
    L9:
        if (o(r8, r2, r9, r5) == true) goto L3;
    L16:
        r3 = true;
        goto L3
    L17:
        th = move-exception;
        if ((r4 & true) != true) goto L51;
        this.f19963g = Collections.unmodifiableList(this.f19963g);
    L51:
        r2.I();     // Catch: IOException -> L46 Throwable -> L30
    L30:
        th = move-exception;
        this.f19962f = r0.l();
        throw th;
    L29:
        this.f19962f = r0.l();
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
        if ((r4 & true) != true) goto L48;
        this.f19963g = Collections.unmodifiableList(this.f19963g);
    L48:
        r2.I();     // Catch: IOException -> L45 Throwable -> L40
    L40:
        th = move-exception;
        this.f19962f = r0.l();
        throw th;
    L39:
        this.f19962f = r0.l();
        l();
    }

    /* synthetic */ e(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private e(kotlin.s0.w.d.l0.i.i.b r2) {
        super(r2);
        this.f19964h = -1;
        this.f19965i = -1;
        this.f19962f = r2.m();
    }

    /* synthetic */ e(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private e(boolean r1) {
        this.f19964h = -1;
        this.f19965i = -1;
        this.f19962f = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ List q(e r0) {
        return r0.f19963g;
    }

    static /* synthetic */ List r(e r0, List r1) {
        r0.f19963g = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d s(e r0) {
        return r0.f19962f;
    }

    public static e t() {
        return f19960j;
    }

    private void w() {
        this.f19963g = Collections.emptyList();
    }

    public static b y() {
        return b.p();
    }

    public static b z(e r1) {
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
        if (r0 >= this.f19963g.size()) goto L6;
        r4.d0(1, this.f19963g.get(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        r4.i0(this.f19962f);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.f19965i;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.f19963g.size()) goto L9;
        r2 = r2 + kotlin.s0.w.d.l0.i.f.s(1, this.f19963g.get(r1));
        r1 = r1 + 1;
        goto L7
    L9:
        int r3 = r2 + this.f19962f.size();
        this.f19965i = r3;
        return r3;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return A();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<e> h() {
        return f19961k;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.f19964h;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= v()) goto L16;
        if (u(r1).isInitialized() == false) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        this.f19964h = 0;
        return false;
    L16:
        this.f19964h = 1;
        return true;
    }

    public f u(int r1) {
        return this.f19963g.get(r1);
    }

    public int v() {
        return this.f19963g.size();
    }
}

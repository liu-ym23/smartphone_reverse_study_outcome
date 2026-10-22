package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final w f20195j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static kotlin.s0.w.d.l0.i.s<w> f20196k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f20197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<v> f20198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte f20199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20200i;

    static class a extends kotlin.s0.w.d.l0.i.b<w> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public w m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new w(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.b<w, b> implements Object {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f20201g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<v> f20202h;

        private b() {
            this.f20202h = Collections.emptyList();
            w();
        }

        static /* synthetic */ b p() {
            return u();
        }

        private static b u() {
            return new b();
        }

        private void v() {
            if ((this.f20201g & 1) == 1) goto L6;
            this.f20202h = new ArrayList(this.f20202h);
            this.f20201g |= 1;
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
            y((w) r1);
            return this;
        }

        public w q() {
            w r1 = r();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public w r() {
            w r0 = new w(this, null);
            if ((this.f20201g & 1) != 1) goto L5;
            this.f20202h = Collections.unmodifiableList(this.f20202h);
            this.f20201g &= -2;
        L5:
            w.r(r0, this.f20202h);
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

        public b y(w r3) {
            if (r3 != w.t()) goto L6;
            return this;
        L6:
            if (w.q(r3).isEmpty() == false) goto L8;
        L11:
            o(m().b(w.s(r3)));
            return this;
        L8:
            if (this.f20202h.isEmpty() == false) goto L10;
            this.f20202h = w.q(r3);
            this.f20201g &= -2;
            goto L11
        L10:
            v();
            this.f20202h.addAll(w.q(r3));
            goto L11
        }

        public b z(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            w r0 = null;
            w r5 = w.f20196k.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            y(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            w r6 = (w) e.a();     // Catch: Throwable -> L7
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
        f20196k = new a();
        w r0 = new w(true);
        f20195j = r0;
        r0.w();
    }

    private w(kotlin.s0.w.d.l0.i.e r8, kotlin.s0.w.d.l0.i.g r9) {
        this.f20199h = -1;
        this.f20200i = -1;
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
        this.f20198g = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
        r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
    L14:
        this.f20198g.add((v) r8.u(v.q, r9));     // Catch: Throwable -> L17 IOException -> L19 kotlin.s0.w.d.l0.i.k -> L22
        goto L3
    L9:
        if (o(r8, r2, r9, r5) == true) goto L3;
    L16:
        r3 = true;
        goto L3
    L17:
        th = move-exception;
        if ((r4 & true) != true) goto L51;
        this.f20198g = Collections.unmodifiableList(this.f20198g);
    L51:
        r2.I();     // Catch: IOException -> L46 Throwable -> L30
    L30:
        th = move-exception;
        this.f20197f = r0.l();
        throw th;
    L29:
        this.f20197f = r0.l();
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
        this.f20198g = Collections.unmodifiableList(this.f20198g);
    L48:
        r2.I();     // Catch: IOException -> L45 Throwable -> L40
    L40:
        th = move-exception;
        this.f20197f = r0.l();
        throw th;
    L39:
        this.f20197f = r0.l();
        l();
    }

    /* synthetic */ w(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private w(kotlin.s0.w.d.l0.i.i.b r2) {
        super(r2);
        this.f20199h = -1;
        this.f20200i = -1;
        this.f20197f = r2.m();
    }

    /* synthetic */ w(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private w(boolean r1) {
        this.f20199h = -1;
        this.f20200i = -1;
        this.f20197f = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ List q(w r0) {
        return r0.f20198g;
    }

    static /* synthetic */ List r(w r0, List r1) {
        r0.f20198g = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d s(w r0) {
        return r0.f20197f;
    }

    public static w t() {
        return f20195j;
    }

    private void w() {
        this.f20198g = Collections.emptyList();
    }

    public static b y() {
        return b.p();
    }

    public static b z(w r1) {
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
        if (r0 >= this.f20198g.size()) goto L6;
        r4.d0(1, this.f20198g.get(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        r4.i0(this.f20197f);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.f20200i;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.f20198g.size()) goto L9;
        r2 = r2 + kotlin.s0.w.d.l0.i.f.s(1, this.f20198g.get(r1));
        r1 = r1 + 1;
        goto L7
    L9:
        int r3 = r2 + this.f20197f.size();
        this.f20200i = r3;
        return r3;
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return A();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<w> h() {
        return f20196k;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.f20199h;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
        return false;
    L8:
        this.f20199h = 1;
        return true;
    }

    public int u() {
        return this.f20198g.size();
    }

    public List<v> v() {
        return this.f20198g;
    }
}

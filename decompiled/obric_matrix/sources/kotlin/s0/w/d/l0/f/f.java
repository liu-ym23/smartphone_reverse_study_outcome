package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends kotlin.s0.w.d.l0.i.i implements kotlin.s0.w.d.l0.i.r {
    private static final f n = null;
    public static kotlin.s0.w.d.l0.i.s<f> o;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f19968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f19970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<h> f19971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f19972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d f19973k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte f19974l;
    private int m;

    static class a extends kotlin.s0.w.d.l0.i.b<f> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public f m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new f(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.b<f, b> implements Object {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f19975g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private c f19976h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List<h> f19977i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private h f19978j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private d f19979k;

        private b() {
            this.f19976h = c.f19980g;
            this.f19977i = Collections.emptyList();
            this.f19978j = h.F();
            this.f19979k = d.f19985g;
            w();
        }

        static /* synthetic */ b p() {
            return u();
        }

        private static b u() {
            return new b();
        }

        private void v() {
            if ((this.f19975g & 2) == 2) goto L6;
            this.f19977i = new ArrayList(this.f19977i);
            this.f19975g |= 2;
            return;
        }

        private void w() {
        }

        public b B(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            f r0 = null;
            f r5 = f.o.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            z(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            f r6 = (f) e.a();     // Catch: Throwable -> L7
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

        public b C(c r2) {
            Objects.requireNonNull(r2);
            this.f19975g |= 1;
            this.f19976h = r2;
            return this;
        }

        public b D(d r2) {
            Objects.requireNonNull(r2);
            this.f19975g |= 8;
            this.f19979k = r2;
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
            z((f) r1);
            return this;
        }

        public f q() {
            f r1 = r();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public f r() {
            f r0 = new f(this, null);
            int r1 = this.f19975g;
            int r3 = 1;
            if ((r1 & 1) == 1) goto L6;
            r3 = 0;
        L6:
            f.q(r0, this.f19976h);
            if ((this.f19975g & 2) != 2) goto L9;
            this.f19977i = Collections.unmodifiableList(this.f19977i);
            this.f19975g &= -3;
        L9:
            f.s(r0, this.f19977i);
            if ((r1 & 4) != 4) goto L12;
            r3 = r3 | 2;
        L12:
            f.t(r0, this.f19978j);
            if ((r1 & 8) != 8) goto L15;
            r3 = r3 | 4;
        L15:
            f.u(r0, this.f19979k);
            f.v(r0, r3);
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

        public b y(h r4) {
            if ((this.f19975g & 4) == 4) goto L5;
        L7:
            this.f19978j = r4;
            this.f19975g |= 4;
            return this;
        L5:
            if (this.f19978j == h.F()) goto L7;
            h.b r0 = h.T(this.f19978j);
            r0.z(r4);
            r4 = r0.r();
            goto L7
        }

        public b z(f r3) {
            if (r3 != f.z()) goto L6;
            return this;
        L6:
            if (r3.F() == false) goto L9;
            C(r3.C());
        L9:
            if (f.r(r3).isEmpty() == true) goto L15;
            if (this.f19977i.isEmpty() == false) goto L13;
            this.f19977i = f.r(r3);
            this.f19975g &= -3;
            goto L15
        L13:
            v();
            this.f19977i.addAll(f.r(r3));
        L15:
            if (r3.E() == false) goto L18;
            y(r3.y());
        L18:
            if (r3.G() == false) goto L20;
            D(r3.D());
        L20:
            o(m().b(f.w(r3)));
            return this;
        }
    }

    public static final enum c extends Enum<c> implements kotlin.s0.w.d.l0.i.j.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f19980g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f19981h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f19982i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ c[] f19983j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f19984f;

        static {
            c r0 = new c("RETURNS_CONSTANT", 0, 0, 0);
            f19980g = r0;
            c r1 = new c("CALLS", 1, 1, 1);
            f19981h = r1;
            c r3 = new c("RETURNS_NOT_NULL", 2, 2, 2);
            f19982i = r3;
            f19983j = new c[]{r0, r1, r3};
        }

        private c(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.f19984f = r4;
        }

        public static c a(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return f19982i;
        L12:
            return f19981h;
        L14:
            return f19980g;
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f19983j.clone();
        }

        @Override // kotlin.s0.w.d.l0.i.j.a
        public final int d() {
            return this.f19984f;
        }
    }

    public static final enum d extends Enum<d> implements kotlin.s0.w.d.l0.i.j.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f19985g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f19986h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final d f19987i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ d[] f19988j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f19989f;

        static {
            d r0 = new d("AT_MOST_ONCE", 0, 0, 0);
            f19985g = r0;
            d r1 = new d("EXACTLY_ONCE", 1, 1, 1);
            f19986h = r1;
            d r3 = new d("AT_LEAST_ONCE", 2, 2, 2);
            f19987i = r3;
            f19988j = new d[]{r0, r1, r3};
        }

        private d(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.f19989f = r4;
        }

        public static d a(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return f19987i;
        L12:
            return f19986h;
        L14:
            return f19985g;
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f19988j.clone();
        }

        @Override // kotlin.s0.w.d.l0.i.j.a
        public final int d() {
            return this.f19989f;
        }
    }

    static {
        o = new a();
        f r0 = new f(true);
        n = r0;
        r0.H();
    }

    private f(kotlin.s0.w.d.l0.i.e r10, kotlin.s0.w.d.l0.i.g r11) {
        this.f19974l = -1;
        this.m = -1;
        H();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L59;
        int r6 = r10.K();     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        if (r6 == 0) goto L39;
        if (r6 != 8) goto L10;
        int r7 = r10.n();     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        c r8 = c.a(r7);     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        if (r8 == null) goto L36;
        this.f19969g |= 1;     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        this.f19970h = r8;     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        goto L4
    L36:
        r2.o0(r6);     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
    L21:
        r2.o0(r7);     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        goto L4
    L10:
        if (r6 != 18) goto L12;
        if ((r4 & 2) == 2) goto L33;
        this.f19971i = new ArrayList();     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        r4 = r4 | 2;     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
    L33:
        this.f19971i.add((h) r10.u(h.r, r11));     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        goto L4
    L12:
        if (r6 != 26) goto L14;
        h.b r9 = null;
        if ((this.f19969g & 2) != 2) goto L26;
        r9 = this.f19972j.V();     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
    L26:
        h r12 = (h) r10.u(h.r, r11);     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        this.f19972j = r12;     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        if (r9 == null) goto L29;
        r9.z(r12);     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        this.f19972j = r9.r();     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
    L29:
        this.f19969g |= 2;     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        goto L4
    L14:
        if (r6 != 32) goto L16;
        r7 = r10.n();     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        d r13 = d.a(r7);     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        if (r13 == null) goto L20;
        this.f19969g |= 4;     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        this.f19973k = r13;     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        goto L4
    L20:
        r2.o0(r6);     // Catch: Throwable -> L40 IOException -> L42 kotlin.s0.w.d.l0.i.k -> L45
        goto L21
    L16:
        if (o(r10, r2, r11, r6) == true) goto L4;
    L39:
        r3 = true;
        goto L4
    L40:
        th = move-exception;
        if ((r4 & 2) != 2) goto L71;
        this.f19971i = Collections.unmodifiableList(this.f19971i);
    L71:
        r2.I();     // Catch: IOException -> L69 Throwable -> L53
    L53:
        th = move-exception;
        this.f19968f = r0.l();
        throw th;
    L52:
        this.f19968f = r0.l();
        l();
        throw th;
    L45:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L40
        throw e;     // Catch: Throwable -> L40
    L42:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r14 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L40
        r14.i(this);     // Catch: Throwable -> L40
        throw r14;     // Catch: Throwable -> L40
    L59:
        if ((r4 & 2) != 2) goto L73;
        this.f19971i = Collections.unmodifiableList(this.f19971i);
    L73:
        r2.I();     // Catch: IOException -> L68 Throwable -> L63
    L63:
        th = move-exception;
        this.f19968f = r0.l();
        throw th;
    L62:
        this.f19968f = r0.l();
        l();
    }

    /* synthetic */ f(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private f(kotlin.s0.w.d.l0.i.i.b r2) {
        super(r2);
        this.f19974l = -1;
        this.m = -1;
        this.f19968f = r2.m();
    }

    /* synthetic */ f(kotlin.s0.w.d.l0.i.i.b r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private f(boolean r1) {
        this.f19974l = -1;
        this.m = -1;
        this.f19968f = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    private void H() {
        this.f19970h = c.f19980g;
        this.f19971i = Collections.emptyList();
        this.f19972j = h.F();
        this.f19973k = d.f19985g;
    }

    public static b I() {
        return b.p();
    }

    public static b J(f r1) {
        b r0 = I();
        r0.z(r1);
        return r0;
    }

    static /* synthetic */ c q(f r0, c r1) {
        r0.f19970h = r1;
        return r1;
    }

    static /* synthetic */ List r(f r0) {
        return r0.f19971i;
    }

    static /* synthetic */ List s(f r0, List r1) {
        r0.f19971i = r1;
        return r1;
    }

    static /* synthetic */ h t(f r0, h r1) {
        r0.f19972j = r1;
        return r1;
    }

    static /* synthetic */ d u(f r0, d r1) {
        r0.f19973k = r1;
        return r1;
    }

    static /* synthetic */ int v(f r0, int r1) {
        r0.f19969g = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d w(f r0) {
        return r0.f19968f;
    }

    public static f z() {
        return n;
    }

    public h A(int r1) {
        return this.f19971i.get(r1);
    }

    public int B() {
        return this.f19971i.size();
    }

    public c C() {
        return this.f19970h;
    }

    public d D() {
        return this.f19973k;
    }

    public boolean E() {
        if ((this.f19969g & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean F() {
        if ((this.f19969g & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean G() {
        if ((this.f19969g & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public b K() {
        return I();
    }

    public b L() {
        return J(this);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return L();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r4) {
        e();
        if ((this.f19969g & 1) != 1) goto L5;
        r4.S(1, this.f19970h.d());
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.f19971i.size()) goto L10;
        r4.d0(2, this.f19971i.get(r0));
        r0 = r0 + 1;
        goto L7
    L10:
        if ((this.f19969g & 2) != 2) goto L13;
        r4.d0(3, this.f19972j);
    L13:
        if ((this.f19969g & 4) != 4) goto L15;
        r4.S(4, this.f19973k.d());
    L15:
        r4.i0(this.f19968f);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.m;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.f19969g & 1) != 1) goto L8;
        int r1 = kotlin.s0.w.d.l0.i.f.h(1, this.f19970h.d()) + 0;
    L10:
        if (r2 >= this.f19971i.size()) goto L13;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(2, this.f19971i.get(r2));
        r2 = r2 + 1;
        goto L10
    L13:
        if ((this.f19969g & 2) != 2) goto L16;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(3, this.f19972j);
    L16:
        if ((this.f19969g & 4) != 4) goto L18;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.h(4, this.f19973k.d());
    L18:
        int r3 = r1 + this.f19968f.size();
        this.m = r3;
        return r3;
    L8:
        r1 = 0;
        goto L10
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return K();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<f> h() {
        return o;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.f19974l;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= B()) goto L17;
        if (A(r1).isInitialized() == false) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        this.f19974l = 0;
        return false;
    L17:
        if (E() == true) goto L19;
    L22:
        this.f19974l = 1;
        return true;
    L19:
        if (y().isInitialized() == true) goto L22;
        this.f19974l = 0;
        return false;
    }

    public h y() {
        return this.f19972j;
    }
}

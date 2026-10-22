package kotlin.s0.w.d.l0.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends kotlin.s0.w.d.l0.i.i.d<d> implements Object {
    private static final d n = null;
    public static kotlin.s0.w.d.l0.i.s<d> o;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.i.d f19950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19952i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<u> f19953j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<Integer> f19954k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte f19955l;
    private int m;

    static class a extends kotlin.s0.w.d.l0.i.b<d> {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.i.s
        public /* bridge */ /* synthetic */ Object b(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2) {
            return m(r1, r2);
        }

        public d m(kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.g r3) {
            return new d(r2, r3, null);
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.i.i.c<d, b> implements Object {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f19956i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f19957j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private List<u> f19958k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private List<Integer> f19959l;

        private b() {
            this.f19957j = 6;
            this.f19958k = Collections.emptyList();
            this.f19959l = Collections.emptyList();
            D();
        }

        private void B() {
            if ((this.f19956i & 2) == 2) goto L6;
            this.f19958k = new ArrayList(this.f19958k);
            this.f19956i |= 2;
            return;
        }

        private void C() {
            if ((this.f19956i & 4) == 4) goto L6;
            this.f19959l = new ArrayList(this.f19959l);
            this.f19956i |= 4;
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

        public b E(d r3) {
            if (r3 != d.H()) goto L6;
            return this;
        L6:
            if (r3.O() == false) goto L9;
            G(r3.J());
        L9:
            if (d.B(r3).isEmpty() == true) goto L15;
            if (this.f19958k.isEmpty() == false) goto L13;
            this.f19958k = d.B(r3);
            this.f19956i &= -3;
            goto L15
        L13:
            B();
            this.f19958k.addAll(d.B(r3));
        L15:
            if (d.D(r3).isEmpty() == false) goto L17;
        L20:
            t(r3);
            o(m().b(d.G(r3)));
            return this;
        L17:
            if (this.f19959l.isEmpty() == false) goto L19;
            this.f19959l = d.D(r3);
            this.f19956i &= -5;
            goto L20
        L19:
            C();
            this.f19959l.addAll(d.D(r3));
            goto L20
        }

        public b F(kotlin.s0.w.d.l0.i.e r3, kotlin.s0.w.d.l0.i.g r4) {
            d r0 = null;
            d r5 = d.o.b(r3, r4);     // Catch: Throwable -> L7 kotlin.s0.w.d.l0.i.k -> L9
            if (r5 == null) goto L6;
            E(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            d r6 = (d) e.a();     // Catch: Throwable -> L7
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
            this.f19956i |= 1;
            this.f19957j = r2;
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
            E((d) r1);
            return this;
        }

        public d v() {
            d r1 = w();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw kotlin.s0.w.d.l0.i.a.AbstractC0550a.j(r1);
        }

        public d w() {
            d r0 = new d(this, null);
            int r2 = 1;
            if ((this.f19956i & 1) == 1) goto L6;
            r2 = 0;
        L6:
            d.A(r0, this.f19957j);
            if ((this.f19956i & 2) != 2) goto L9;
            this.f19958k = Collections.unmodifiableList(this.f19958k);
            this.f19956i &= -3;
        L9:
            d.C(r0, this.f19958k);
            if ((this.f19956i & 4) != 4) goto L12;
            this.f19959l = Collections.unmodifiableList(this.f19959l);
            this.f19956i &= -5;
        L12:
            d.E(r0, this.f19959l);
            d.F(r0, r2);
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

    static {
        o = new a();
        d r0 = new d(true);
        n = r0;
        r0.P();
    }

    private d(kotlin.s0.w.d.l0.i.e r11, kotlin.s0.w.d.l0.i.g r12) {
        this.f19955l = -1;
        this.m = -1;
        P();
        kotlin.s0.w.d.l0.i.d.b r0 = kotlin.s0.w.d.l0.i.d.t();
        kotlin.s0.w.d.l0.i.f r2 = kotlin.s0.w.d.l0.i.f.J(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L61;
        int r7 = r11.K();     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        if (r7 == 0) goto L38;
        if (r7 != 8) goto L10;
        this.f19951h |= 1;     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        this.f19952i = r11.s();     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        goto L4
    L10:
        if (r7 == 18) goto L33;
        if (r7 != 248) goto L14;
        if ((r4 & 4) == 4) goto L30;
        this.f19954k = new ArrayList();     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        r4 = r4 | 4;     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
    L30:
        List r8 = this.f19954k;     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        Object r9 = Integer.valueOf(r11.s());     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
    L31:
        r8.add(r9);     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        goto L4
    L14:
        if (r7 != 250) goto L16;
        int r10 = r11.j(r11.A());     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        if ((r4 & 4) == 4) goto L24;
        if (r11.e() <= 0) goto L24;
        this.f19954k = new ArrayList();     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        r4 = r4 | 4;     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
    L24:
        if (r11.e() <= 0) goto L26;
        this.f19954k.add(Integer.valueOf(r11.s()));     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        goto L24
    L26:
        r11.i(r10);     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        goto L4
    L16:
        if (o(r11, r2, r12, r7) == true) goto L4;
    L33:
        if ((r4 & 2) == 2) goto L35;
        this.f19953j = new ArrayList();     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        r4 = r4 | 2;     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
    L35:
        r8 = this.f19953j;     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
        r9 = r11.u(u.r, r12);     // Catch: Throwable -> L39 IOException -> L41 kotlin.s0.w.d.l0.i.k -> L44
    L38:
        r3 = true;
        goto L4
    L39:
        th = move-exception;
        if ((r4 & 2) != 2) goto L51;
        this.f19953j = Collections.unmodifiableList(this.f19953j);
    L51:
        if ((r4 & 4) != 4) goto L78;
        this.f19954k = Collections.unmodifiableList(this.f19954k);
    L78:
        r2.I();     // Catch: IOException -> L74 Throwable -> L55
    L55:
        th = move-exception;
        this.f19950g = r0.l();
        throw th;
    L54:
        this.f19950g = r0.l();
        l();
        throw th;
    L44:
        e = move-exception;
        e.i(this);     // Catch: Throwable -> L39
        throw e;     // Catch: Throwable -> L39
    L41:
        e = move-exception;
        kotlin.s0.w.d.l0.i.k r13 = new kotlin.s0.w.d.l0.i.k(e.getMessage());     // Catch: Throwable -> L39
        r13.i(this);     // Catch: Throwable -> L39
        throw r13;     // Catch: Throwable -> L39
    L61:
        if ((r4 & 2) != 2) goto L64;
        this.f19953j = Collections.unmodifiableList(this.f19953j);
    L64:
        if ((r4 & 4) != 4) goto L76;
        this.f19954k = Collections.unmodifiableList(this.f19954k);
    L76:
        r2.I();     // Catch: IOException -> L73 Throwable -> L68
    L68:
        th = move-exception;
        this.f19950g = r0.l();
        throw th;
    L67:
        this.f19950g = r0.l();
        l();
    }

    /* synthetic */ d(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.g r2, kotlin.s0.w.d.l0.f.a r3) {
        this(r1, r2);
    }

    private d(kotlin.s0.w.d.l0.i.i.c<d, ?> r2) {
        super(r2);
        this.f19955l = -1;
        this.m = -1;
        this.f19950g = r2.m();
    }

    /* synthetic */ d(kotlin.s0.w.d.l0.i.i.c r1, kotlin.s0.w.d.l0.f.a r2) {
        this(r1);
    }

    private d(boolean r1) {
        this.f19955l = -1;
        this.m = -1;
        this.f19950g = kotlin.s0.w.d.l0.i.d.f20305f;
    }

    static /* synthetic */ int A(d r0, int r1) {
        r0.f19952i = r1;
        return r1;
    }

    static /* synthetic */ List B(d r0) {
        return r0.f19953j;
    }

    static /* synthetic */ List C(d r0, List r1) {
        r0.f19953j = r1;
        return r1;
    }

    static /* synthetic */ List D(d r0) {
        return r0.f19954k;
    }

    static /* synthetic */ List E(d r0, List r1) {
        r0.f19954k = r1;
        return r1;
    }

    static /* synthetic */ int F(d r0, int r1) {
        r0.f19951h = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.i.d G(d r0) {
        return r0.f19950g;
    }

    public static d H() {
        return n;
    }

    private void P() {
        this.f19952i = 6;
        this.f19953j = Collections.emptyList();
        this.f19954k = Collections.emptyList();
    }

    public static b Q() {
        return b.u();
    }

    public static b R(d r1) {
        b r0 = Q();
        r0.E(r1);
        return r0;
    }

    public d I() {
        return n;
    }

    public int J() {
        return this.f19952i;
    }

    public u K(int r1) {
        return this.f19953j.get(r1);
    }

    public int L() {
        return this.f19953j.size();
    }

    public List<u> M() {
        return this.f19953j;
    }

    public List<Integer> N() {
        return this.f19954k;
    }

    public boolean O() {
        if ((this.f19951h & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public b S() {
        return Q();
    }

    public b T() {
        return R(this);
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q a() {
        return I();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a c() {
        return T();
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public void d(kotlin.s0.w.d.l0.i.f r6) {
        e();
        kotlin.s0.w.d.l0.i.i.d<MessageType>.a r0 = y();
        if ((this.f19951h & 1) != 1) goto L5;
        r6.a0(1, this.f19952i);
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r2 >= this.f19953j.size()) goto L10;
        r6.d0(2, this.f19953j.get(r2));
        r2 = r2 + 1;
    L10:
        if (r1 >= this.f19954k.size()) goto L12;
        r6.a0(31, this.f19954k.get(r1).intValue());
        r1 = r1 + 1;
        goto L10
    L12:
        r0.a(19000, r6);
        r6.i0(this.f19950g);
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public int e() {
        int r0 = this.m;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.f19951h & 1) != 1) goto L8;
        int r1 = kotlin.s0.w.d.l0.i.f.o(1, this.f19952i) + 0;
    L9:
        int r3 = 0;
    L11:
        if (r3 >= this.f19953j.size()) goto L13;
        r1 = r1 + kotlin.s0.w.d.l0.i.f.s(2, this.f19953j.get(r3));
        r3 = r3 + 1;
        goto L11
    L13:
        int r4 = 0;
    L15:
        if (r2 >= this.f19954k.size()) goto L17;
        r4 = r4 + kotlin.s0.w.d.l0.i.f.p(this.f19954k.get(r2).intValue());
        r2 = r2 + 1;
        goto L15
    L17:
        int r5 = (((r1 + r4) + (N().size() * 2)) + s()) + this.f19950g.size();
        this.m = r5;
        return r5;
    L8:
        r1 = 0;
        goto L9
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.i.q.a f() {
        return S();
    }

    @Override // kotlin.s0.w.d.l0.i.i, kotlin.s0.w.d.l0.i.q
    public kotlin.s0.w.d.l0.i.s<d> h() {
        return o;
    }

    @Override // kotlin.s0.w.d.l0.i.r
    public final boolean isInitialized() {
        byte r0 = this.f19955l;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= L()) goto L17;
        if (K(r1).isInitialized() == false) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        this.f19955l = 0;
        return false;
    L17:
        if (r() == true) goto L20;
        this.f19955l = 0;
        return false;
    L20:
        this.f19955l = 1;
        return true;
    }
}

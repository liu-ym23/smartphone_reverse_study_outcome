package d.b.h.a.a.g;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f13327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f13328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ThreadPoolExecutor f13329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ThreadPoolExecutor f13330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ThreadPoolExecutor f13331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f13333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f13335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f13336j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f13337k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f13338l;
    private long m;
    private long n;
    private long o;
    private boolean p;

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadPoolExecutor f13339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ThreadPoolExecutor f13340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ThreadPoolExecutor f13341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ThreadPoolExecutor f13342d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ThreadPoolExecutor f13343e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f13344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f13345g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f13346h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f13347i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f13348j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f13349k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f13350l;
        private int m;
        private boolean n;
        private int o;
        private long p;

        public b() {
            this.n = true;
        }

        static /* synthetic */ ThreadPoolExecutor a(b r0) {
            return r0.f13340b;
        }

        static /* synthetic */ ThreadPoolExecutor b(b r0) {
            return r0.f13339a;
        }

        static /* synthetic */ long c(b r2) {
            return r2.f13349k;
        }

        static /* synthetic */ long d(b r2) {
            return r2.f13350l;
        }

        static /* synthetic */ int e(b r0) {
            return r0.m;
        }

        static /* synthetic */ int f(b r0) {
            return r0.o;
        }

        static /* synthetic */ long g(b r2) {
            return r2.p;
        }

        static /* synthetic */ boolean h(b r0) {
            return r0.n;
        }

        static /* synthetic */ ThreadPoolExecutor i(b r0) {
            return r0.f13341c;
        }

        static /* synthetic */ ThreadPoolExecutor j(b r0) {
            return r0.f13342d;
        }

        static /* synthetic */ ThreadPoolExecutor k(b r0) {
            return r0.f13343e;
        }

        static /* synthetic */ int l(b r0) {
            return r0.f13344f;
        }

        static /* synthetic */ int m(b r0) {
            return r0.f13345g;
        }

        static /* synthetic */ int n(b r0) {
            return r0.f13346h;
        }

        static /* synthetic */ int o(b r0) {
            return r0.f13347i;
        }

        static /* synthetic */ long p(b r2) {
            return r2.f13348j;
        }

        public h q() {
            return new h(this, null);
        }

        public b r(long r3) {
            if (r3 <= 0) goto L7;
            this.f13348j = r3;
            return this;
        L7:
            throw new IllegalArgumentException("Api keep alive time must set > 0 when allow core thread timeout.");
        }

        public b s(int r1, int r2) {
            if (r2 <= 0) goto L10;
            if (r1 <= 0) goto L10;
            if (r1 > r2) goto L8;
            this.f13344f = r2;
            this.f13346h = r1;
            return this;
        L8:
            throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
        L10:
            throw new IllegalArgumentException("Api thread size must set > 0.");
        }

        public b t(long r3) {
            if (r3 <= 0) goto L7;
            this.f13349k = r3;
            return this;
        L7:
            throw new IllegalArgumentException("Download keep alive time must set > 0 when allow core thread timeout.");
        }

        public b u(int r1, int r2) {
            if (r2 <= 0) goto L10;
            if (r1 <= 0) goto L10;
            if (r1 > r2) goto L8;
            this.f13345g = r2;
            this.f13347i = r1;
            return this;
        L8:
            throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
        L10:
            throw new IllegalArgumentException("Download thread size must set > 0.");
        }

        public b v(boolean r1) {
            this.n = r1;
            return this;
        }

        public b w(long r3) {
            if (r3 <= 0) goto L7;
            this.f13350l = r3;
            return this;
        L7:
            throw new IllegalArgumentException("Immediate keep alive time must set > 0 when allow core thread timeout.");
        }
    }

    private h(b r7) {
        this.f13332f = 0;
        this.f13333g = 8;
        this.f13334h = 8;
        this.f13335i = 1;
        this.f13336j = 8;
        this.f13337k = 8;
        this.f13338l = 10;
        this.m = 30;
        this.n = 10;
        this.o = 10;
        this.p = true;
        if (b.a(r7) == null) goto L6;
        this.f13327a = b.a(r7);
    L6:
        if (b.b(r7) == null) goto L9;
        this.f13328b = b.b(r7);
    L9:
        if (b.i(r7) == null) goto L12;
        this.f13329c = b.i(r7);
    L12:
        if (b.j(r7) == null) goto L15;
        this.f13330d = b.j(r7);
    L15:
        if (b.k(r7) == null) goto L18;
        this.f13331e = b.k(r7);
    L18:
        if (b.l(r7) <= 0) goto L21;
        this.f13336j = b.l(r7);
    L21:
        if (b.m(r7) <= 0) goto L24;
        this.f13337k = b.m(r7);
    L24:
        if (b.n(r7) <= 0) goto L27;
        this.f13333g = b.n(r7);
    L27:
        if (b.o(r7) <= 0) goto L30;
        this.f13334h = b.o(r7);
    L30:
        if (b.p(r7) <= 0) goto L33;
        this.m = b.p(r7);
    L33:
        if (b.c(r7) <= 0) goto L36;
        this.n = b.c(r7);
    L36:
        if (b.d(r7) <= 0) goto L39;
        this.f13338l = b.d(r7);
    L39:
        if (b.e(r7) < 0) goto L42;
        this.f13332f = b.e(r7);
    L42:
        if (b.f(r7) <= 0) goto L45;
        this.f13335i = b.f(r7);
    L45:
        if (b.g(r7) <= 0) goto L47;
        this.o = b.g(r7);
    L47:
        this.p = b.h(r7);
    }

    /* synthetic */ h(b r1, a r2) {
        this(r1);
    }

    public static b q() {
        return new b();
    }

    public long a() {
        return this.m;
    }

    public int b() {
        return this.f13333g;
    }

    public int c() {
        return this.f13334h;
    }

    public int d() {
        return this.f13332f;
    }

    public int e() {
        return this.f13335i;
    }

    public long f() {
        return this.n;
    }

    public ThreadPoolExecutor g() {
        return this.f13330d;
    }

    public long h() {
        return this.f13338l;
    }

    public ThreadPoolExecutor i() {
        return this.f13327a;
    }

    public ThreadPoolExecutor j() {
        return this.f13328b;
    }

    public long k() {
        return this.o;
    }

    public ThreadPoolExecutor l() {
        return this.f13331e;
    }

    public int m() {
        return this.f13336j;
    }

    public int n() {
        return this.f13337k;
    }

    public ThreadPoolExecutor o() {
        return this.f13329c;
    }

    public boolean p() {
        return this.p;
    }

    public void r(boolean r1) {
        this.p = r1;
    }
}

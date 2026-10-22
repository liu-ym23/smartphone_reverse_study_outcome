package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes2.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f0 f6682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g0 f6683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f0 f6684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.c.c.g.d f6685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f0 f6686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g0 f6687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f0 f6688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final g0 f6689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f6690i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f6691j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f6692k;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f0 f6693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private g0 f6694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f0 f6695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d.c.c.g.d f6696d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private f0 f6697e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private g0 f6698f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private f0 f6699g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private g0 f6700h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f6701i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f6702j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f6703k;

        private b() {
        }

        /* synthetic */ b(a r1) {
            this();
        }

        static /* synthetic */ f0 a(b r0) {
            return r0.f6693a;
        }

        static /* synthetic */ g0 b(b r0) {
            return r0.f6694b;
        }

        static /* synthetic */ int c(b r0) {
            return r0.f6703k;
        }

        static /* synthetic */ f0 d(b r0) {
            return r0.f6695c;
        }

        static /* synthetic */ d.c.c.g.d e(b r0) {
            return r0.f6696d;
        }

        static /* synthetic */ f0 f(b r0) {
            return r0.f6697e;
        }

        static /* synthetic */ g0 g(b r0) {
            return r0.f6698f;
        }

        static /* synthetic */ f0 h(b r0) {
            return r0.f6699g;
        }

        static /* synthetic */ g0 i(b r0) {
            return r0.f6700h;
        }

        static /* synthetic */ String j(b r0) {
            return r0.f6701i;
        }

        static /* synthetic */ int k(b r0) {
            return r0.f6702j;
        }

        public d0 l() {
            return new d0(this, null);
        }

        public b m(d.c.c.g.d r1) {
            this.f6696d = r1;
            return this;
        }
    }

    private d0(b r2) {
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("PoolConfig()");
    L6:
        if (b.a(r2) != null) goto L8;
        f0 r0 = k.a();
    L9:
        this.f6682a = r0;
        if (b.b(r2) != null) goto L12;
        g0 r1 = a0.h();
    L13:
        this.f6683b = r1;
        if (b.d(r2) != null) goto L16;
        f0 r3 = m.b();
    L17:
        this.f6684c = r3;
        if (b.e(r2) != null) goto L20;
        d.c.c.g.d r4 = d.c.c.g.e.b();
    L21:
        this.f6685d = r4;
        if (b.f(r2) != null) goto L24;
        f0 r5 = n.a();
    L25:
        this.f6686e = r5;
        if (b.g(r2) != null) goto L28;
        g0 r6 = a0.h();
    L29:
        this.f6687f = r6;
        if (b.h(r2) != null) goto L32;
        f0 r7 = l.a();
    L33:
        this.f6688g = r7;
        if (b.i(r2) != null) goto L36;
        g0 r8 = a0.h();
    L37:
        this.f6689h = r8;
        if (b.j(r2) != null) goto L40;
        String r9 = "legacy";
    L41:
        this.f6690i = r9;
        this.f6691j = b.k(r2);
        if (b.c(r2) <= 0) goto L44;
        int r10 = b.c(r2);
    L45:
        this.f6692k = r10;
        if (d.c.i.r.b.d() == false) goto L49;
        d.c.i.r.b.b();
        return;
    L49:
        return;
    L44:
        r10 = 4194304;
        goto L45
    L40:
        r9 = b.j(r2);
        goto L41
    L36:
        r8 = b.i(r2);
        goto L37
    L32:
        r7 = b.h(r2);
        goto L33
    L28:
        r6 = b.g(r2);
        goto L29
    L24:
        r5 = b.f(r2);
        goto L25
    L20:
        r4 = b.e(r2);
        goto L21
    L16:
        r3 = b.d(r2);
        goto L17
    L12:
        r1 = b.b(r2);
        goto L13
    L8:
        r0 = b.a(r2);
        goto L9
    }

    /* synthetic */ d0(b r1, a r2) {
        this(r1);
    }

    public static b l() {
        return new b(null);
    }

    public int a() {
        return this.f6692k;
    }

    public int b() {
        return this.f6691j;
    }

    public f0 c() {
        return this.f6682a;
    }

    public g0 d() {
        return this.f6683b;
    }

    public String e() {
        return this.f6690i;
    }

    public f0 f() {
        return this.f6684c;
    }

    public f0 g() {
        return this.f6686e;
    }

    public g0 h() {
        return this.f6687f;
    }

    public d.c.c.g.d i() {
        return this.f6685d;
    }

    public f0 j() {
        return this.f6688g;
    }

    public g0 k() {
        return this.f6689h;
    }
}

package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends j1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f21120d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j1 f21121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j1 f21122c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final j1 a(j1 r2, j1 r3) {
            kotlin.n0.d.o.f(r2, "first");
            kotlin.n0.d.o.f(r3, "second");
            if (r2.f() == false) goto L6;
            return r3;
        L6:
            if (r3.f() == false) goto L9;
            return r2;
        L9:
            return new u(r2, r3, null);
        }
    }

    static {
        f21120d = new a(null);
    }

    private u(j1 r1, j1 r2) {
        this.f21121b = r1;
        this.f21122c = r2;
    }

    public /* synthetic */ u(j1 r1, j1 r2, kotlin.n0.d.g r3) {
        this(r1, r2);
    }

    public static final j1 i(j1 r1, j1 r2) {
        return f21120d.a(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public boolean a() {
        if (this.f21121b.a() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f21122c.a() == true) goto L8;
        return false;
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public boolean b() {
        if (this.f21121b.b() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f21122c.b() == true) goto L8;
        return false;
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public kotlin.s0.w.d.l0.c.o1.g d(kotlin.s0.w.d.l0.c.o1.g r2) {
        kotlin.n0.d.o.f(r2, "annotations");
        return this.f21122c.d(this.f21121b.d(r2));
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public g1 e(e0 r2) {
        kotlin.n0.d.o.f(r2, "key");
        g1 r0 = this.f21121b.e(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.f21122c.e(r2);
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public boolean f() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.n.j1
    public e0 g(e0 r2, r1 r3) {
        kotlin.n0.d.o.f(r2, "topLevelType");
        kotlin.n0.d.o.f(r3, "position");
        return this.f21122c.g(this.f21121b.g(r2, r3), r3);
    }
}

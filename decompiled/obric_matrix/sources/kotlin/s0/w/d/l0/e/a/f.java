package kotlin.s0.w.d.l0.e.a;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends h0 {
    public static final f m = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19251f = null;

        static {
            f19251f = new a();
        }

        a() {
            super(1);
        }

        public final Boolean a(kotlin.s0.w.d.l0.c.b r1) {
            kotlin.n0.d.o.f(r1, "it");
            return Boolean.valueOf(f.i(f.m, r1));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f19252f = null;

        static {
            f19252f = new b();
        }

        b() {
            super(1);
        }

        public final Boolean a(kotlin.s0.w.d.l0.c.b r1) {
            kotlin.n0.d.o.f(r1, "it");
            if ((r1 instanceof kotlin.s0.w.d.l0.c.y) == true) goto L5;
        L7:
            boolean r0 = false;
        L9:
            return Boolean.valueOf(r0);
        L5:
            if (f.i(f.m, r1) == false) goto L7;
            r0 = true;
            goto L9
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static {
        m = new f();
    }

    private f() {
    }

    public static final /* synthetic */ boolean i(f r0, kotlin.s0.w.d.l0.c.b r1) {
        return r0.j(r1);
    }

    private final boolean j(kotlin.s0.w.d.l0.c.b r1) {
        return kotlin.i0.r.J(h0.f19266a.e(), kotlin.s0.w.d.l0.e.b.v.d(r1));
    }

    public static final kotlin.s0.w.d.l0.c.y k(kotlin.s0.w.d.l0.c.y r4) {
        kotlin.n0.d.o.f(r4, "functionDescriptor");
        f r0 = m;
        kotlin.s0.w.d.l0.g.f r1 = r4.getName();
        kotlin.n0.d.o.e(r1, "functionDescriptor.name");
        if (r0.l(r1) == true) goto L6;
        return null;
    L6:
        return (kotlin.s0.w.d.l0.c.y) kotlin.s0.w.d.l0.k.t.a.c(r4, false, a.f19251f, 1, null);
    }

    public static final h0.b m(kotlin.s0.w.d.l0.c.b r5) {
        kotlin.n0.d.o.f(r5, "<this>");
        h0.a r0 = h0.f19266a;
        if (r0.d().contains(r5.getName()) == true) goto L5;
        return null;
    L5:
        kotlin.s0.w.d.l0.c.b r6 = kotlin.s0.w.d.l0.k.t.a.c(r5, false, b.f19252f, 1, null);
        if (r6 == null) goto L12;
        String r7 = kotlin.s0.w.d.l0.e.b.v.d(r6);
        if (r7 == null) goto L12;
        return r0.l(r7);
    L12:
        return null;
    }

    public final boolean l(kotlin.s0.w.d.l0.g.f r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return h0.f19266a.d().contains(r1);
    }
}

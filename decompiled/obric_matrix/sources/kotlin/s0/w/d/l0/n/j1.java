package kotlin.s0.w.d.l0.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j1 f21031a = null;

    public static final class a extends j1 {
        a() {
        }

        @Override // kotlin.s0.w.d.l0.n.j1
        public /* bridge */ /* synthetic */ g1 e(e0 r1) {
            return (g1) i(r1);
        }

        @Override // kotlin.s0.w.d.l0.n.j1
        public boolean f() {
            return true;
        }

        public Void i(e0 r1) {
            kotlin.n0.d.o.f(r1, "key");
            return null;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    public static final class b extends j1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j1 f21032b;

        b(j1 r1) {
            this.f21032b = r1;
        }

        @Override // kotlin.s0.w.d.l0.n.j1
        public boolean a() {
            return false;
        }

        @Override // kotlin.s0.w.d.l0.n.j1
        public boolean b() {
            return false;
        }

        @Override // kotlin.s0.w.d.l0.n.j1
        public kotlin.s0.w.d.l0.c.o1.g d(kotlin.s0.w.d.l0.c.o1.g r2) {
            kotlin.n0.d.o.f(r2, "annotations");
            return this.f21032b.d(r2);
        }

        @Override // kotlin.s0.w.d.l0.n.j1
        public g1 e(e0 r2) {
            kotlin.n0.d.o.f(r2, "key");
            return this.f21032b.e(r2);
        }

        @Override // kotlin.s0.w.d.l0.n.j1
        public boolean f() {
            return this.f21032b.f();
        }

        @Override // kotlin.s0.w.d.l0.n.j1
        public e0 g(e0 r2, r1 r3) {
            kotlin.n0.d.o.f(r2, "topLevelType");
            kotlin.n0.d.o.f(r3, "position");
            return this.f21032b.g(r2, r3);
        }
    }

    static {
        f21031a = new a();
    }

    public j1() {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public final l1 c() {
        l1 r1 = l1.g(this);
        kotlin.n0.d.o.e(r1, "create(this)");
        return r1;
    }

    public kotlin.s0.w.d.l0.c.o1.g d(kotlin.s0.w.d.l0.c.o1.g r1) {
        kotlin.n0.d.o.f(r1, "annotations");
        return r1;
    }

    public abstract g1 e(e0 r1);

    public boolean f() {
        return false;
    }

    public e0 g(e0 r1, r1 r2) {
        kotlin.n0.d.o.f(r1, "topLevelType");
        kotlin.n0.d.o.f(r2, "position");
        return r1;
    }

    public final j1 h() {
        return new b(this);
    }
}

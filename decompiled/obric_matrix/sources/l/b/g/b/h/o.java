package l.b.g.b.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f22144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22146d;

    protected static abstract class a<T extends a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f22147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f22148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f22149c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f22150d;

        protected a(int r4) {
            this.f22148b = 0;
            this.f22149c = 0;
            this.f22150d = 0;
            this.f22147a = r4;
        }

        static /* synthetic */ int a(a r0) {
            return r0.f22148b;
        }

        static /* synthetic */ long b(a r2) {
            return r2.f22149c;
        }

        static /* synthetic */ int c(a r0) {
            return r0.f22147a;
        }

        static /* synthetic */ int d(a r0) {
            return r0.f22150d;
        }

        protected abstract T e();

        protected T f(int r1) {
            this.f22150d = r1;
            return (T) e();
        }

        protected T g(int r1) {
            this.f22148b = r1;
            return (T) e();
        }

        protected T h(long r1) {
            this.f22149c = r1;
            return (T) e();
        }
    }

    protected o(a r3) {
        this.f22143a = a.a(r3);
        this.f22144b = a.b(r3);
        this.f22145c = a.c(r3);
        this.f22146d = a.d(r3);
    }

    public final int a() {
        return this.f22146d;
    }

    protected final int b() {
        return this.f22143a;
    }

    protected final long c() {
        return this.f22144b;
    }

    protected byte[] d() {
        byte[] r0 = new byte[32];
        l.b.h.e.c(this.f22143a, r0, 0);
        l.b.h.e.h(this.f22144b, r0, 4);
        l.b.h.e.c(this.f22145c, r0, 12);
        l.b.h.e.c(this.f22146d, r0, 28);
        return r0;
    }
}

package l.b.g.b.h;

/* JADX INFO: loaded from: classes2.dex */
final class i extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f22116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22118g;

    static /* synthetic */ class a {
    }

    protected static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f22119e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f22120f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f22121g;

        protected b() {
            super(1);
            this.f22119e = 0;
            this.f22120f = 0;
            this.f22121g = 0;
        }

        static /* synthetic */ int i(b r0) {
            return r0.f22119e;
        }

        static /* synthetic */ int j(b r0) {
            return r0.f22120f;
        }

        static /* synthetic */ int k(b r0) {
            return r0.f22121g;
        }

        @Override // l.b.g.b.h.o.a
        protected /* bridge */ /* synthetic */ o.a e() {
            m();
            return this;
        }

        protected o l() {
            return new i(this, null);
        }

        protected b m() {
            return this;
        }

        protected b n(int r1) {
            this.f22119e = r1;
            return this;
        }

        protected b o(int r1) {
            this.f22120f = r1;
            return this;
        }

        protected b p(int r1) {
            this.f22121g = r1;
            return this;
        }
    }

    private i(b r2) {
        super(r2);
        this.f22116e = b.i(r2);
        this.f22117f = b.j(r2);
        this.f22118g = b.k(r2);
    }

    /* synthetic */ i(b r1, a r2) {
        this(r1);
    }

    @Override // l.b.g.b.h.o
    protected byte[] d() {
        byte[] r0 = super.d();
        l.b.h.e.c(this.f22116e, r0, 16);
        l.b.h.e.c(this.f22117f, r0, 20);
        l.b.h.e.c(this.f22118g, r0, 24);
        return r0;
    }

    protected int e() {
        return this.f22116e;
    }

    protected int f() {
        return this.f22117f;
    }

    protected int g() {
        return this.f22118g;
    }
}

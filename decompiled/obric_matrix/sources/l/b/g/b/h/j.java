package l.b.g.b.h;

/* JADX INFO: loaded from: classes2.dex */
final class j extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f22122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22124g;

    static /* synthetic */ class a {
    }

    protected static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f22125e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f22126f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f22127g;

        protected b() {
            super(0);
            this.f22125e = 0;
            this.f22126f = 0;
            this.f22127g = 0;
        }

        static /* synthetic */ int i(b r0) {
            return r0.f22125e;
        }

        static /* synthetic */ int j(b r0) {
            return r0.f22126f;
        }

        static /* synthetic */ int k(b r0) {
            return r0.f22127g;
        }

        @Override // l.b.g.b.h.o.a
        protected /* bridge */ /* synthetic */ o.a e() {
            m();
            return this;
        }

        protected o l() {
            return new j(this, null);
        }

        protected b m() {
            return this;
        }

        protected b n(int r1) {
            this.f22126f = r1;
            return this;
        }

        protected b o(int r1) {
            this.f22127g = r1;
            return this;
        }

        protected b p(int r1) {
            this.f22125e = r1;
            return this;
        }
    }

    private j(b r2) {
        super(r2);
        this.f22122e = b.i(r2);
        this.f22123f = b.j(r2);
        this.f22124g = b.k(r2);
    }

    /* synthetic */ j(b r1, a r2) {
        this(r1);
    }

    @Override // l.b.g.b.h.o
    protected byte[] d() {
        byte[] r0 = super.d();
        l.b.h.e.c(this.f22122e, r0, 16);
        l.b.h.e.c(this.f22123f, r0, 20);
        l.b.h.e.c(this.f22124g, r0, 24);
        return r0;
    }

    protected int e() {
        return this.f22123f;
    }

    protected int f() {
        return this.f22124g;
    }

    protected int g() {
        return this.f22122e;
    }
}

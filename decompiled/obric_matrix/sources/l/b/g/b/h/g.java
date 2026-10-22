package l.b.g.b.h;

/* JADX INFO: loaded from: classes2.dex */
final class g extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f22109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22111g;

    static /* synthetic */ class a {
    }

    protected static class b extends o.a<b> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f22112e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f22113f;

        protected b() {
            super(2);
            this.f22112e = 0;
            this.f22113f = 0;
        }

        static /* synthetic */ int i(b r0) {
            return r0.f22112e;
        }

        static /* synthetic */ int j(b r0) {
            return r0.f22113f;
        }

        @Override // l.b.g.b.h.o.a
        protected /* bridge */ /* synthetic */ o.a e() {
            l();
            return this;
        }

        protected o k() {
            return new g(this, null);
        }

        protected b l() {
            return this;
        }

        protected b m(int r1) {
            this.f22112e = r1;
            return this;
        }

        protected b n(int r1) {
            this.f22113f = r1;
            return this;
        }
    }

    private g(b r2) {
        super(r2);
        this.f22109e = 0;
        this.f22110f = b.i(r2);
        this.f22111g = b.j(r2);
    }

    /* synthetic */ g(b r1, a r2) {
        this(r1);
    }

    @Override // l.b.g.b.h.o
    protected byte[] d() {
        byte[] r0 = super.d();
        l.b.h.e.c(this.f22109e, r0, 16);
        l.b.h.e.c(this.f22110f, r0, 20);
        l.b.h.e.c(this.f22111g, r0, 24);
        return r0;
    }

    protected int e() {
        return this.f22110f;
    }

    protected int f() {
        return this.f22111g;
    }
}

package d.b.u;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f14983a;

    /* JADX INFO: renamed from: d.b.u.a$a, reason: collision with other inner class name */
    class RunnableC0404a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f14984f;

        RunnableC0404a(a r1) {
            this.f14984f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f14984f).b();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f14985f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ m f14986g;

        b(a r1, c r2, m r3) {
            this.f14985f = r2;
            this.f14986g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14985f.a() == false) goto L6;
            d.b.u.w.i r0 = t.f(this.f14986g);
            this.f14985f.b(r0);
            return;
        }
    }

    private static final class c implements d.b.u.w.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f14987a;

        private c(m r1) {
            this.f14987a = true;
        }

        /* synthetic */ c(m r1, RunnableC0404a r2) {
            this(r1);
        }

        public boolean a() {
            return this.f14987a;
        }

        public void b(d.b.u.w.i r1) {
        }
    }

    a() {
        this.f14983a = new g();
    }

    static /* synthetic */ g a(a r0) {
        return r0.f14983a;
    }

    public d.b.u.w.i b(m r4) {
        c r0 = new c(r4, null);
        this.f14983a.c(new b(this, r0, r4));
        return r0;
    }

    public void c() {
        if (this.f14983a.a() == false) goto L6;
        com.bytedance.common.utility.m.a.a().submit(new RunnableC0404a(this));
        return;
    }
}

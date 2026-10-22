package d.b.b.f.e.k;

/* JADX INFO: loaded from: classes.dex */
class c extends d.b.b.f.e.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.b.o.o.a f12848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f12849c;

    class a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ d.b.b.f.e.d f12850i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ c f12851j;

        a(c r1, long r2, long r4, d.b.b.f.e.d r6) {
            this.f12851j = r1;
            this.f12850i = r6;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            c.g(this.f12851j, "cool down task run, is back?: " + c.f(this.f12851j));
            this.f12850i.f();
        }
    }

    public c(d.b.b.f.e.d r9) {
        super(r9);
        this.f12849c = false;
        this.f12848b = new a(this, h(), 0, r9);
    }

    static /* synthetic */ boolean f(c r0) {
        return r0.f12849c;
    }

    static /* synthetic */ void g(c r0, String r1) {
        r0.e(r1);
    }

    private long h() {
        if (this.f12849c == false) goto L5;
        return 1200000;
    L5:
        return 120000;
    }

    @Override // d.b.b.f.e.a, d.b.b.f.e.g
    public void a(d.b.b.f.d.c r5, boolean r6) {
        super.a(r5, r6);
        d.b.b.o.o.a r7 = this.f12848b;
        if (r7 == null) goto L5;
        r7.e(h(), 0);
    L5:
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13067g).c(this.f12848b);
    }

    @Override // d.b.b.f.e.a, d.b.b.f.e.g
    public void b(boolean r1) {
        super.b(r1);
        this.f12849c = r1;
    }

    @Override // d.b.b.f.e.g
    public d.b.b.f.e.h c() {
        return d.b.b.f.e.h.f12828i;
    }

    @Override // d.b.b.f.e.a, d.b.b.f.e.g
    public void d() {
        super.d();
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13067g).b(this.f12848b);
    }
}

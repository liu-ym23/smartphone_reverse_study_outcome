package d.b.b.f.e.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends d.b.b.f.e.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.b.b.f.d.c f12839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.b.o.o.a f12840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f12841d;

    /* JADX INFO: renamed from: d.b.b.f.e.k.a$a, reason: collision with other inner class name */
    class C0336a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f12842i;

        C0336a(a r1, long r2, long r4) {
            this.f12842i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            a.f(this.f12842i);
        }
    }

    public a(d.b.b.f.e.d r1) {
        super(r1);
    }

    static /* synthetic */ void f(a r0) {
        r0.g();
    }

    private void g() {
        if (d.b.b.f.e.b.c() == true) goto L5;
        double r0 = d.b.b.f.e.e.a();
        d.b.w.a.a.c r2 = this.f12804a.b();
        if (r2 == null) goto L12;
        boolean r3 = r2.f((float) r0);
        if (r3 == true) goto L12;
    L13:
        e("run judge process cpu usage task, is over max threshold?: " + r3 + " speed: " + r0 + ", back max speed: " + this.f12839b.c() + ", fore max speed: " + this.f12839b.d());
        if (i(r3) == false) goto L18;
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13069i).b(this.f12840c);
        return;
    L18:
        return;
    L12:
        r3 = d.b.b.f.e.b.e(this.f12839b, r0, this.f12841d);
        goto L13
    L5:
        if (j() == false) goto L17;
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13069i).b(this.f12840c);
        return;
    }

    @Override // d.b.b.f.e.a, d.b.b.f.e.g
    public void a(d.b.b.f.d.c r7, boolean r8) {
        super.a(r7, r8);
        this.f12839b = r7;
        this.f12841d = r8;
        d.b.b.o.m.b.d("APM-CPU", "enter : " + c() + " provideDetectInterval : " + h() + " isBack : " + r8);
        d.b.b.o.o.a r9 = this.f12840c;
        if (r9 != null) goto L5;
        this.f12840c = new C0336a(this, h(), h());
    L6:
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13069i).c(this.f12840c);
        return;
    L5:
        r9.e(h(), h());
        goto L6
    }

    @Override // d.b.b.f.e.a, d.b.b.f.e.g
    public void b(boolean r2) {
        super.b(r2);
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13069i).b(this.f12840c);
        this.f12804a.f();
    }

    @Override // d.b.b.f.e.a, d.b.b.f.e.g
    public void d() {
        super.d();
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13069i).b(this.f12840c);
    }

    protected abstract long h();

    protected abstract boolean i(boolean r1);

    protected abstract boolean j();
}

package d.b.b.f.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected d f12804a;

    public a(d r1) {
        this.f12804a = r1;
    }

    @Override // d.b.b.f.e.g
    public void a(d.b.b.f.d.c r1, boolean r2) {
        if (d.b.b.o.a.c() == false) goto L6;
        d.b.b.o.m.b.d("APM-CPU", "enter : " + c());
        return;
    }

    @Override // d.b.b.f.e.g
    public void b(boolean r2) {
        if (d.b.b.o.a.c() == false) goto L6;
        d.b.b.o.m.b.d("APM-CPU", "onLifeCycleChange when state is : " + c());
        return;
    }

    @Override // d.b.b.f.e.g
    public void d() {
        if (d.b.b.o.a.c() == false) goto L6;
        d.b.b.o.m.b.d("APM-CPU", "stop detect when state is : " + c());
        return;
    }

    protected void e(String r3) {
        if (d.b.b.o.a.c() == false) goto L6;
        d.b.b.o.m.b.d("APM-CPU", "[" + c() + "]: " + r3);
        return;
    }
}

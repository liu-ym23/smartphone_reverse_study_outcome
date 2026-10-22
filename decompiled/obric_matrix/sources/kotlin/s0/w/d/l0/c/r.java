package kotlin.s0.w.d.l0.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f19073a;

    public r(n1 r2) {
        kotlin.n0.d.o.f(r2, "delegate");
        this.f19073a = r2;
    }

    @Override // kotlin.s0.w.d.l0.c.u
    public n1 b() {
        return this.f19073a;
    }

    @Override // kotlin.s0.w.d.l0.c.u
    public String c() {
        return b().b();
    }

    @Override // kotlin.s0.w.d.l0.c.u
    public u f() {
        u r1 = t.j(b().d());
        kotlin.n0.d.o.e(r1, "toDescriptorVisibility(delegate.normalize())");
        return r1;
    }
}

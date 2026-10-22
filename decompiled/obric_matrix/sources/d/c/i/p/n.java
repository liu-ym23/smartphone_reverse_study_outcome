package d.c.i.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n<I, O> extends b<I> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k<O> f16354b;

    public n(k<O> r1) {
        this.f16354b = r1;
    }

    @Override // d.c.i.p.b
    protected void g() {
        this.f16354b.b();
    }

    @Override // d.c.i.p.b
    protected void h(Throwable r1) {
        this.f16354b.a(r1);
    }

    @Override // d.c.i.p.b
    protected void j(float r1) {
        this.f16354b.c(r1);
    }

    public k<O> p() {
        return this.f16354b;
    }
}

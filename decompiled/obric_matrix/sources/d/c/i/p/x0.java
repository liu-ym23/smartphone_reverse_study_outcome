package d.c.i.p;

/* JADX INFO: loaded from: classes2.dex */
public class x0<T> implements k0<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k0<T> f16470a;

    class a extends n<T, Void> {
        a(x0 r1, k r2) {
            super(r2);
        }

        @Override // d.c.i.p.b
        protected void i(T r1, int r2) {
            if (b.e(r2) == false) goto L6;
            p().d(null, r2);
            return;
        }
    }

    public x0(k0<T> r1) {
        this.f16470a = r1;
    }

    @Override // d.c.i.p.k0
    public void b(k<Void> r2, l0 r3) {
        a r0 = new a(this, r2);
        this.f16470a.b(r0, r3);
    }
}

package d.c.i.e;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    static class a implements s<d.c.b.a.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f15916a;

        a(n r1) {
            this.f15916a = r1;
        }

        @Override // d.c.i.e.s
        public /* bridge */ /* synthetic */ void a(d.c.b.a.d r1) {
            d(r1);
        }

        @Override // d.c.i.e.s
        public void b() {
            this.f15916a.i();
        }

        @Override // d.c.i.e.s
        public void c() {
            this.f15916a.l();
        }

        public void d(d.c.b.a.d r1) {
            this.f15916a.b(r1);
        }
    }

    public static p<d.c.b.a.d, d.c.i.l.c> a(h<d.c.b.a.d, d.c.i.l.c> r1, n r2) {
        r2.a(r1);
        return new p(r1, new a(r2));
    }
}

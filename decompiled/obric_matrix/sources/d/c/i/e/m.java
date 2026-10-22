package d.c.i.e;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    static class a implements s<d.c.b.a.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f15969a;

        a(n r1) {
            this.f15969a = r1;
        }

        @Override // d.c.i.e.s
        public /* bridge */ /* synthetic */ void a(d.c.b.a.d r1) {
            d(r1);
        }

        @Override // d.c.i.e.s
        public void b() {
            this.f15969a.c();
        }

        @Override // d.c.i.e.s
        public void c() {
            this.f15969a.k();
        }

        public void d(d.c.b.a.d r1) {
            this.f15969a.e(r1);
        }
    }

    public static p<d.c.b.a.d, d.c.c.g.h> a(h<d.c.b.a.d, d.c.c.g.h> r1, n r2) {
        r2.g(r1);
        return new p(r1, new a(r2));
    }
}

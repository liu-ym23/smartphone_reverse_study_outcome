package d.c.i.e;

/* JADX INFO: loaded from: classes2.dex */
public class u implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static u f15980a;

    static {
    }

    private u() {
    }

    public static synchronized u n() {
        monitor-enter(u.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f15980a != null) goto L7;
        f15980a = new u();     // Catch: Throwable -> L10
    L7:
        u r1 = f15980a;     // Catch: Throwable -> L10
        monitor-exit(u.class);
        return r1;
    }

    @Override // d.c.i.e.n
    public void a(h<?, ?> r1) {
    }

    @Override // d.c.i.e.n
    public void b(d.c.b.a.d r1) {
    }

    @Override // d.c.i.e.n
    public void c() {
    }

    @Override // d.c.i.e.n
    public void d(d.c.b.a.d r1) {
    }

    @Override // d.c.i.e.n
    public void e(d.c.b.a.d r1) {
    }

    @Override // d.c.i.e.n
    public void f() {
    }

    @Override // d.c.i.e.n
    public void g(h<?, ?> r1) {
    }

    @Override // d.c.i.e.n
    public void h() {
    }

    @Override // d.c.i.e.n
    public void i() {
    }

    @Override // d.c.i.e.n
    public void j() {
    }

    @Override // d.c.i.e.n
    public void k() {
    }

    @Override // d.c.i.e.n
    public void l() {
    }

    @Override // d.c.i.e.n
    public void m(d.c.b.a.d r1) {
    }
}

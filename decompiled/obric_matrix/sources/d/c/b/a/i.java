package d.c.b.a;

/* JADX INFO: loaded from: classes.dex */
public class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static i f15271a;

    static {
    }

    private i() {
    }

    public static synchronized i i() {
        monitor-enter(i.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f15271a != null) goto L7;
        f15271a = new i();     // Catch: Throwable -> L10
    L7:
        i r1 = f15271a;     // Catch: Throwable -> L10
        monitor-exit(i.class);
        return r1;
    }

    @Override // d.c.b.a.c
    public void a(b r1) {
    }

    @Override // d.c.b.a.c
    public void b(b r1) {
    }

    @Override // d.c.b.a.c
    public void c() {
    }

    @Override // d.c.b.a.c
    public void d(b r1) {
    }

    @Override // d.c.b.a.c
    public void e(b r1) {
    }

    @Override // d.c.b.a.c
    public void f(b r1) {
    }

    @Override // d.c.b.a.c
    public void g(b r1) {
    }

    @Override // d.c.b.a.c
    public void h(b r1) {
    }
}

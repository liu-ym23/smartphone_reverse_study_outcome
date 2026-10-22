package d.c.c.a;

/* JADX INFO: loaded from: classes.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f15363a;

    static {
    }

    private c() {
    }

    public static synchronized c b() {
        monitor-enter(c.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f15363a != null) goto L7;
        f15363a = new c();     // Catch: Throwable -> L10
    L7:
        c r1 = f15363a;     // Catch: Throwable -> L10
        monitor-exit(c.class);
        return r1;
    }

    @Override // d.c.c.a.b
    public void a(a r1) {
    }
}

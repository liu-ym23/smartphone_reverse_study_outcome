package d.c.c.g;

/* JADX INFO: loaded from: classes.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f15402a;

    static {
    }

    public e() {
    }

    public static synchronized e b() {
        monitor-enter(e.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f15402a != null) goto L7;
        f15402a = new e();     // Catch: Throwable -> L10
    L7:
        e r1 = f15402a;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r1;
    }

    @Override // d.c.c.g.d
    public void a(c r1) {
    }
}

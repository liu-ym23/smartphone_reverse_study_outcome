package d.c.b.a;

/* JADX INFO: loaded from: classes.dex */
public class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f15270a;

    static {
    }

    private h() {
    }

    public static synchronized h b() {
        monitor-enter(h.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f15270a != null) goto L7;
        f15270a = new h();     // Catch: Throwable -> L10
    L7:
        h r1 = f15270a;     // Catch: Throwable -> L10
        monitor-exit(h.class);
        return r1;
    }

    @Override // d.c.b.a.a
    public void a(a.EnumC0411a r1, Class<?> r2, String r3, Throwable r4) {
    }
}

package d.c.i.r;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f16525a;

    public interface a {
        void a(String r1);

        void b();

        boolean c();
    }

    static {
    }

    private b() {
    }

    public static void a(String r1) {
        c().a(r1);
    }

    public static void b() {
        c().b();
    }

    private static a c() {
        if (f16525a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f16525a != null) goto L9;
        f16525a = new d.c.i.r.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f16525a;
    }

    public static boolean d() {
        return c().c();
    }
}

package d.b.s.a;

/* JADX INFO: loaded from: classes.dex */
public class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f14651a;

    private b() {
        com.ss.android.i.j.k().e();
    }

    public static g a() {
        if (f14651a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f14651a != null) goto L9;
        f14651a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f14651a;
    }
}

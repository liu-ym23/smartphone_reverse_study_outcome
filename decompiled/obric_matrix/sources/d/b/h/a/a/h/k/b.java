package d.b.h.a.a.h.k;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f13409c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f13410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f13411b;

    private b() {
        this.f13411b = false;
    }

    public static b b() {
        if (f13409c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13409c != null) goto L9;
        f13409c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f13409c;
    }

    public a a() {
        return this.f13410a;
    }
}

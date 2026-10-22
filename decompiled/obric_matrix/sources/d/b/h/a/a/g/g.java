package d.b.h.a.a.g;

/* JADX INFO: loaded from: classes.dex */
public class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f13324a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile h f13325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile g f13326c;

    static {
    }

    public g() {
        this(8, 8);
    }

    @Deprecated
    public g(int r1, int r2) {
        if (f13325b != null) goto L6;
        h.b r0 = h.q();
        r0.s(8, 8);
        r0.u(8, 8);
        r0.r(30);
        r0.w(10);
        r0.t(10);
        r0.v(true);
        f13325b = r0.q();
        return;
    }

    @Deprecated
    public static g c() {
        if (f13326c != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13326c != null) goto L9;
        f13326c = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f13326c;
    }

    public static synchronized h d() {
        monitor-enter(g.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f13325b != null) goto L7;
        h.b r1 = h.q();     // Catch: Throwable -> L10
        r1.s(8, 8);     // Catch: Throwable -> L10
        r1.u(8, 8);     // Catch: Throwable -> L10
        r1.r(30);     // Catch: Throwable -> L10
        r1.w(10);     // Catch: Throwable -> L10
        r1.t(10);     // Catch: Throwable -> L10
        r1.v(true);     // Catch: Throwable -> L10
        f13325b = r1.q();     // Catch: Throwable -> L10
    L7:
        h r2 = f13325b;     // Catch: Throwable -> L10
        monitor-exit(g.class);
        return r2;
    }

    public static synchronized void e(boolean r2) {
        monitor-enter(g.class);
        f13324a = r2;     // Catch: Throwable -> L9
        if (f13325b == null) goto L7;
        f13325b.r(f13324a);     // Catch: Throwable -> L9
    L7:
        monitor-exit(g.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // d.b.h.a.a.g.e
    public synchronized void a(c r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        f.m.c(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.b.h.a.a.g.e
    public synchronized void b(c r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        f.m.d(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}

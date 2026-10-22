package d.b.b.f.e;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f12807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.b.b.f.a.c f12809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.b.b.f.a.b f12810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    private boolean f12811f;

    static /* synthetic */ class a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f12812a = null;

        static {
            f12812a = new c(null);
        }

        static /* synthetic */ c a() {
            return f12812a;
        }
    }

    private c() {
        this.f12807b = new d.b.b.f.e.k.d();
    }

    /* synthetic */ c(a r1) {
        this();
    }

    public static c c() {
        return b.a();
    }

    public d.b.b.f.a.b a() {
        return this.f12810e;
    }

    public d.b.b.f.a.c b() {
        return this.f12809d;
    }

    public synchronized boolean d() {
        monitor-enter(this);
        boolean r0 = this.f12808c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void e(long r1) {
    }

    public synchronized void f(d.b.b.f.d.c r3) {
        monitor-enter(this);
        if (r3 != null) goto L28;
        monitor-exit(this);
        return;
    L28:
    L25:
        th = move-exception;
        throw th;
    L7:
        if (d.b.b.i.c.a.A() == true) goto L13;
        if (r3.i() == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        if (this.f12811f == false) goto L20;
        if (this.f12806a == true) goto L17;
        this.f12806a = true;     // Catch: Throwable -> L25
        this.f12808c = r3.l();     // Catch: Throwable -> L25
        this.f12807b.a(r3);     // Catch: Throwable -> L25
    L17:
        monitor-exit(this);
        return;
    L20:
        if (r3.m() == false) goto L22;
        this.f12806a = true;     // Catch: Throwable -> L25
        this.f12808c = r3.l();     // Catch: Throwable -> L25
        this.f12807b.a(r3);     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L22:
        this.f12806a = false;     // Catch: Throwable -> L25
        this.f12807b.b();     // Catch: Throwable -> L25
        goto L23
    }
}

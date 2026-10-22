package d.c.i.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> implements k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16220a;

    public b() {
        this.f16220a = false;
    }

    public static boolean e(int r1) {
        if ((r1 & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean f(int r0) {
        return !e(r0);
    }

    public static int l(boolean r0) {
        return r0 ? 1 : 0;
    }

    public static boolean m(int r0, int r1) {
        if ((r0 & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean n(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static int o(int r0, int r1) {
        return r0 & (~r1);
    }

    @Override // d.c.i.p.k
    public synchronized void a(Throwable r2) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f16220a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f16220a = true;     // Catch: Throwable -> L15
        h(r2);     // Catch: Exception -> L11 Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        k(e);     // Catch: Throwable -> L15
        goto L13
    }

    @Override // d.c.i.p.k
    public synchronized void b() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f16220a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f16220a = true;     // Catch: Throwable -> L15
        g();     // Catch: Exception -> L11 Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        k(e);     // Catch: Throwable -> L15
        goto L13
    }

    @Override // d.c.i.p.k
    public synchronized void c(float r2) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f16220a == false) goto L17;
        monitor-exit(this);
        return;
    L17:
        j(r2);     // Catch: Exception -> L9 Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L9:
        e = move-exception;
        k(e);     // Catch: Throwable -> L13
        goto L11
    }

    @Override // d.c.i.p.k
    public synchronized void d(T r2, int r3) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f16220a == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f16220a = e(r3);     // Catch: Throwable -> L14
        i(r2, r3);     // Catch: Exception -> L10 Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        k(e);     // Catch: Throwable -> L14
        goto L12
    }

    protected abstract void g();

    protected abstract void h(Throwable r1);

    protected abstract void i(T r1, int r2);

    protected abstract void j(float r1);

    protected void k(Exception r2) {
        d.c.c.e.a.E(getClass(), "unhandled exception", r2);
    }
}

package d.c.i.l;

/* JADX INFO: loaded from: classes2.dex */
public class a extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d.c.i.c.a.e f16169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d.c.i.f.c f16170i;

    public a(d.c.i.c.a.e r1, d.c.i.f.c r2, d.c.h.d r3) {
        this.f16169h = r1;
        this.f16170i = r2;
        this.f16171f = r3;
    }

    @Override // d.c.i.l.c
    public boolean A() {
        return true;
    }

    public synchronized d.c.i.c.a.c E() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == false) goto L6;
        d.c.i.c.a.c r0 = null;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = this.f16169h.e();     // Catch: Throwable -> L9
        goto L7
    }

    public synchronized d.c.i.c.a.e F() {
        monitor-enter(this);
        d.c.i.c.a.e r0 = this.f16169h;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public d.c.i.f.c L() {
        return this.f16170i;
    }

    @Override // d.c.i.l.f
    public synchronized int b() {
        monitor-enter(this);
        int r0 = this.f16169h.e().a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.c.i.l.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        monitor-enter(this);
        d.c.i.c.a.e r0 = this.f16169h;     // Catch: Throwable -> L11
        if (r0 != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        this.f16169h = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        r0.a();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // d.c.i.l.f
    public synchronized int getHeight() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == false) goto L6;
        int r0 = 0;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = this.f16169h.e().getHeight();     // Catch: Throwable -> L9
        goto L7
    }

    @Override // d.c.i.l.f
    public synchronized int getWidth() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == false) goto L6;
        int r0 = 0;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = this.f16169h.e().getWidth();     // Catch: Throwable -> L9
        goto L7
    }

    @Override // d.c.i.l.c
    public synchronized boolean isClosed() {
        monitor-enter(this);
        if (this.f16169h != null) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // d.c.i.l.c
    public synchronized int x() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == false) goto L6;
        int r0 = 0;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = this.f16169h.e().k();     // Catch: Throwable -> L9
        goto L7
    }
}

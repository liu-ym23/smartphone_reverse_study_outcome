package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f84a;
    public long b;
    public long c;

    public a2() {
    }

    public synchronized void a(Object r3, long r4) {
        monitor-enter(this);
        if (r3 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.f84a = r3;     // Catch: Throwable -> L9
        this.b = System.currentTimeMillis();     // Catch: Throwable -> L9
        this.c = r4;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized Object a() {
        monitor-enter(this);
        Object r0 = this.f84a;     // Catch: Throwable -> L23
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        long r2 = this.c;     // Catch: Throwable -> L23
        if (r2 >= 0) goto L13;
        monitor-exit(this);
        return r0;
    L13:
        if (r2 != 0) goto L15;
    L20:
        this.f84a = null;     // Catch: Throwable -> L23
        monitor-exit(this);
        return null;
    L15:
        if (Math.abs(System.currentTimeMillis() - this.b) > this.c) goto L20;
        Object r1 = this.f84a;     // Catch: Throwable -> L23
        monitor-exit(this);
        return r1;
    L23:
        th = move-exception;
        throw th;
    }
}

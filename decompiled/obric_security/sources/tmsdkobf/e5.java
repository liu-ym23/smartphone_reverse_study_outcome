package tmsdkobf;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes5.dex */
public class e5 extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g5.a f172a;
    private long b;

    public e5(String r1, int r2, long r3) {
        super(r1, r2);
        this.b = r3;
    }

    private g5.a b() {
        if (this.f172a != null) goto L6;
        this.f172a = f5.c();
    L6:
        return this.f172a;
    }

    public long a() {
        return this.b;
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        b().a(this, null);
        super.run();
        b().b(this, null);
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        monitor-enter(this);
        b().c(this, null);     // Catch: Throwable -> L6
        super.start();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}

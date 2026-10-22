package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public class g5 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f212a;
    private Runnable b;
    private long c;

    public interface a {
        void a(Thread r1, Runnable r2);

        void b(Thread r1, Runnable r2);

        void c(Thread r1, Runnable r2);
    }

    public g5(ThreadGroup r1, Runnable r2, String r3, long r4) {
        super(r1, r2, r3);
        this.b = r2;
        this.c = r4;
    }

    public long a() {
        return this.c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a r0 = this.f212a;
        if (r0 == null) goto L5;
        r0.a(this, this.b);
    L5:
        super.run();
        a r1 = this.f212a;
        if (r1 == null) goto L9;
        r1.b(this, this.b);
        return;
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        monitor-enter(this);
        a r0 = this.f212a;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.c(this, this.b);     // Catch: Throwable -> L9
    L6:
        super.start();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void a(a r1) {
        this.f212a = r1;
    }
}

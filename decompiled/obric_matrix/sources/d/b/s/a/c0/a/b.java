package d.b.s.a.c0.a;

import android.os.Process;
import com.bytedance.common.utility.k;
import com.ss.android.i.j;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
class b extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BlockingQueue<e> f14678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BlockingQueue<e> f14679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f14680h;

    public b(BlockingQueue<e> r2, BlockingQueue<e> r3) {
        super("ApiLocalDispatcher-Thread");
        this.f14680h = false;
        this.f14678f = r2;
        this.f14679g = r3;
    }

    public void b() {
        this.f14680h = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
    L38:
        e r1 = this.f14678f.take();     // Catch: InterruptedException -> L35
        c r2 = null;
        if ((r1 instanceof c) == false) goto L7;
        r2 = (c) r1;
    L7:
        if (r2 == null) goto L38;
        String r3 = Thread.currentThread().getName();
        String r4 = r2.m();
        if (r2.n() == true) goto L38;
        if (k.c(r4) == true) goto L19;
        if (k.c(r3) == true) goto L19;
        Thread.currentThread().setName("ApiLocalDispatcher-" + r4);     // Catch: Throwable -> L28
    L19:
        if (j.k().g() == false) goto L22;
        d.b.s.a.a0.a.a("ApiLocalDispatcher", "run4Local " + r4 + ", queue size: " + this.f14678f.size() + " " + this.f14679g.size());     // Catch: Throwable -> L28
    L22:
        if (r2.q() == true) goto L31;
        if (r2.b() != e.a.f14691i) goto L26;
        com.bytedance.common.utility.m.c.c(r2);     // Catch: Throwable -> L28
        goto L31
    L26:
        r2.s();     // Catch: Throwable -> L28
        this.f14679g.add(r2);     // Catch: Throwable -> L28
    L31:
        if (k.c(r4) == true) goto L38;
        if (k.c(r3) == true) goto L38;
        Thread.currentThread().setName(r3);
    L28:
        th = move-exception;
        d.b.s.a.a0.a.c("ApiLocalDispatcher", "run: ", th);
    L36:
        if (this.f14680h == false) goto L38;
    }
}

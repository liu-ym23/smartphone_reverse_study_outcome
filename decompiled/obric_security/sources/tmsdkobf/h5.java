package tmsdkobf;

import android.os.Debug;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class h5 implements g5.a, d7 {
    private final ThreadGroup b;
    private final AtomicInteger c;
    private HashMap d;
    private e7 e;

    public h5() {
        this.c = new AtomicInteger(1);
        this.d = new HashMap();
        this.b = new ThreadGroup("TMS_FREE_POOL_" + d7.f147a.getAndIncrement());
    }

    public int a() {
        return this.d.size();
    }

    @Override // tmsdkobf.g5.a
    public void b(Thread r5, Runnable r6) {
        g7 r7 = (g7) this.d.remove(r5);
        if (r7 == null) goto L8;
        r7.f = System.currentTimeMillis() - r7.f;
        r7.g = Debug.threadCpuTimeNanos() - r7.g;
        e7 r4 = this.e;
        if (r4 == null) goto L9;
        r4.a(r7);
        return;
    L9:
        return;
    }

    @Override // tmsdkobf.g5.a
    public void c(Thread r3, Runnable r4) {
        g7 r5 = new g7();
        r5.f214a = 2;
        r5.b = ((g5) r3).a();
        r5.c = r3.getName();
        r5.d = r3.getPriority();
        r5.f = -1;
        r5.g = -1;
        this.d.put(r3, r5);
        e7 r6 = this.e;
        if (r6 == null) goto L6;
        r6.a(r5, a());
        return;
    }

    @Override // tmsdkobf.g5.a
    public void a(Thread r3, Runnable r4) {
        g7 r5 = (g7) this.d.get(r3);
        if (r5 == null) goto L9;
        e7 r2 = this.e;
        if (r2 == null) goto L7;
        r2.b(r5);
    L7:
        r5.f = System.currentTimeMillis();
        r5.g = Debug.threadCpuTimeNanos();
        return;
    }

    public Thread a(Runnable r7, String r8, long r9) {
        if (r8 != null) goto L4;
    L5:
        r8 = r7.getClass().getName();
    L6:
        g5 r10 = new g5(this.b, r7, "FreeThread-" + this.c.getAndIncrement() + "-" + r8, r9);
        r10.a(this);
        if (r10.isDaemon() == false) goto L10;
        r10.setDaemon(false);
    L10:
        if (r10.getPriority() == 5) goto L12;
        r10.setPriority(5);
    L12:
        return r10;
    L4:
        if (r8.length() != 0) goto L6;
        goto L5
    }

    public void a(e7 r1) {
        this.e = r1;
    }
}

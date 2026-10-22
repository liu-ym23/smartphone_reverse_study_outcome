package tmsdkobf;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class m2 implements ThreadFactory, d7 {
    private final ThreadGroup b;
    private final AtomicInteger c;
    private final String d;

    m2() {
        this.c = new AtomicInteger(1);
        this.b = new ThreadGroup("TMS-COMMON");
        this.d = "Common Thread Pool-" + d7.f147a.getAndIncrement() + "-Thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r8) {
        Thread r6 = new Thread(this.b, r8, this.d + this.c.getAndIncrement(), 0);
        if (r6.isDaemon() == false) goto L6;
        r6.setDaemon(false);
    L6:
        if (r6.getPriority() == 5) goto L8;
        r6.setPriority(5);
    L8:
        return r6;
    }
}

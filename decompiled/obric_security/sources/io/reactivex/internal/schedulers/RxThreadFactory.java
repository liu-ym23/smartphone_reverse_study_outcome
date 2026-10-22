package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    static final class RxCustomThread extends Thread implements NonBlockingThread {
        RxCustomThread(Runnable r1, String r2) {
            super(r1, r2);
        }
    }

    public RxThreadFactory(String r3) {
        this(r3, 5, false);
    }

    public RxThreadFactory(String r2, int r3) {
        this(r2, r3, false);
    }

    public RxThreadFactory(String r1, int r2, boolean r3) {
        this.prefix = r1;
        this.priority = r2;
        this.nonBlocking = r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        String r0 = this.prefix + '-' + incrementAndGet();
        if (this.nonBlocking == false) goto L5;
        Thread r1 = new RxCustomThread(r4, r0);
    L6:
        r1.setPriority(this.priority);
        r1.setDaemon(true);
        return r1;
    L5:
        r1 = new Thread(r4, r0);
        goto L6
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }
}

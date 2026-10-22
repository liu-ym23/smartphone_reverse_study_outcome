package cz.msebera.android.httpclient.impl.bootstrap;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
class ThreadFactoryImpl implements ThreadFactory {
    private final AtomicLong count;
    private final ThreadGroup group;
    private final String namePrefix;

    ThreadFactoryImpl(String r1, ThreadGroup r2) {
        this.namePrefix = r1;
        this.group = r2;
        this.count = new AtomicLong();
    }

    ThreadFactoryImpl(String r2) {
        this(r2, null);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r6) {
        return new Thread(this.group, r6, this.namePrefix + "-" + this.count.incrementAndGet());
    }
}

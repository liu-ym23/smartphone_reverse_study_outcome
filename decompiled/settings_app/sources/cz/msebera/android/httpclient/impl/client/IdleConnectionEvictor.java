package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class IdleConnectionEvictor {
    private final HttpClientConnectionManager connectionManager;
    private volatile Exception exception;
    private final long maxIdleTimeMs;
    private final long sleepTimeMs;
    private final Thread thread;
    private final ThreadFactory threadFactory;

    static class DefaultThreadFactory implements ThreadFactory {
        DefaultThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r2) {
            Thread r1 = new Thread(r2, "Connection evictor");
            r1.setDaemon(true);
            return r1;
        }
    }

    static /* synthetic */ long access$000(IdleConnectionEvictor r2) {
        return r2.sleepTimeMs;
    }

    static /* synthetic */ long access$100(IdleConnectionEvictor r2) {
        return r2.maxIdleTimeMs;
    }

    static /* synthetic */ Exception access$202(IdleConnectionEvictor r0, Exception r1) {
        r0.exception = r1;
        return r1;
    }

    public IdleConnectionEvictor(final HttpClientConnectionManager r2, ThreadFactory r3, long r4, TimeUnit r6, long r7, TimeUnit r9) {
        this.connectionManager = (HttpClientConnectionManager) Args.notNull(r2, "Connection manager");
        if (r3 != null) goto L6;
        r3 = new DefaultThreadFactory();
    L6:
        this.threadFactory = r3;
        if (r6 == null) goto L9;
        r4 = r6.toMillis(r4);
    L9:
        this.sleepTimeMs = r4;
        if (r9 == null) goto L12;
        r7 = r9.toMillis(r7);
    L12:
        this.maxIdleTimeMs = r7;
        this.thread = r3.newThread(new AnonymousClass1(this, r2));
    }

    public IdleConnectionEvictor(HttpClientConnectionManager r10, long r11, TimeUnit r13, long r14, TimeUnit r16) {
        this(r10, null, r11, r13, r14, r16);
    }

    public IdleConnectionEvictor(HttpClientConnectionManager r10, long r11, TimeUnit r13) {
        if (r11 <= 0) goto L5;
        long r3 = r11;
    L6:
        if (r13 == null) goto L8;
        TimeUnit r5 = r13;
    L9:
        this(r10, null, r3, r5, r11, r13);
        return;
    L8:
        r5 = TimeUnit.SECONDS;
        goto L9
    L5:
        r3 = 5;
        goto L6
    }

    public void start() {
        this.thread.start();
    }

    public void shutdown() {
        this.thread.interrupt();
    }

    public boolean isRunning() {
        return this.thread.isAlive();
    }

    public void awaitTermination(long r1, TimeUnit r3) throws InterruptedException {
        Thread r0 = this.thread;
        if (r3 != null) goto L6;
        r3 = TimeUnit.MILLISECONDS;
    L6:
        r0.join(r3.toMillis(r1));
    }
}

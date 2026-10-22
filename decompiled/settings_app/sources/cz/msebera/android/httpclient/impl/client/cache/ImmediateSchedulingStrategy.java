package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class ImmediateSchedulingStrategy implements SchedulingStrategy {
    private final ExecutorService executor;

    public ImmediateSchedulingStrategy(CacheConfig r9) {
        this(new ThreadPoolExecutor(r9.getAsynchronousWorkersCore(), r9.getAsynchronousWorkersMax(), r9.getAsynchronousWorkerIdleLifetimeSecs(), TimeUnit.SECONDS, new ArrayBlockingQueue(r9.getRevalidationQueueSize())));
    }

    ImmediateSchedulingStrategy(ExecutorService r1) {
        this.executor = r1;
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.SchedulingStrategy
    public void schedule(AsynchronousValidationRequest r2) {
        Args.notNull(r2, "AsynchronousValidationRequest");
        this.executor.execute(r2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.executor.shutdown();
    }

    void awaitTermination(long r1, TimeUnit r3) throws InterruptedException {
        this.executor.awaitTermination(r1, r3);
    }
}

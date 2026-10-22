package cz.msebera.android.httpclient.impl.client.cache;

import com.ttnet.org.chromium.base.TimeUtils;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class ExponentialBackOffSchedulingStrategy implements SchedulingStrategy {
    public static final long DEFAULT_BACK_OFF_RATE = 10;
    public static final long DEFAULT_INITIAL_EXPIRY_IN_MILLIS = 0;
    public static final long DEFAULT_MAX_EXPIRY_IN_MILLIS = 0;
    private final long backOffRate;
    private final ScheduledExecutorService executor;
    private final long initialExpiryInMillis;
    private final long maxExpiryInMillis;

    static {
        DEFAULT_INITIAL_EXPIRY_IN_MILLIS = TimeUnit.SECONDS.toMillis(6);
        DEFAULT_MAX_EXPIRY_IN_MILLIS = TimeUnit.SECONDS.toMillis(TimeUtils.SECONDS_PER_DAY);
    }

    public ExponentialBackOffSchedulingStrategy(CacheConfig r9) {
        this(r9, 10, DEFAULT_INITIAL_EXPIRY_IN_MILLIS, DEFAULT_MAX_EXPIRY_IN_MILLIS);
    }

    public ExponentialBackOffSchedulingStrategy(CacheConfig r9, long r10, long r12, long r14) {
        this(createThreadPoolFromCacheConfig(r9), r10, r12, r14);
    }

    private static ScheduledThreadPoolExecutor createThreadPoolFromCacheConfig(CacheConfig r1) {
        ScheduledThreadPoolExecutor r0 = new ScheduledThreadPoolExecutor(r1.getAsynchronousWorkersMax());
        r0.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        return r0;
    }

    ExponentialBackOffSchedulingStrategy(ScheduledExecutorService r2, long r3, long r5, long r7) {
        this.executor = (ScheduledExecutorService) Args.notNull(r2, "Executor");
        this.backOffRate = Args.notNegative(r3, "BackOffRate");
        this.initialExpiryInMillis = Args.notNegative(r5, "InitialExpiryInMillis");
        this.maxExpiryInMillis = Args.notNegative(r7, "MaxExpiryInMillis");
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.SchedulingStrategy
    public void schedule(AsynchronousValidationRequest r4) {
        Args.notNull(r4, "RevalidationRequest");
        long r0 = calculateDelayInMillis(r4.getConsecutiveFailedAttempts());
        this.executor.schedule(r4, r0, TimeUnit.MILLISECONDS);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.executor.shutdown();
    }

    public long getBackOffRate() {
        return this.backOffRate;
    }

    public long getInitialExpiryInMillis() {
        return this.initialExpiryInMillis;
    }

    public long getMaxExpiryInMillis() {
        return this.maxExpiryInMillis;
    }

    protected long calculateDelayInMillis(int r7) {
        if (r7 > 0) goto L4;
        return 0;
    L4:
        return Math.min((long) (this.initialExpiryInMillis * Math.pow(this.backOffRate, r7 - 1)), this.maxExpiryInMillis);
    }

    @Deprecated
    protected static <T> T checkNotNull(String r1, T r2) {
        if (r2 == null) goto L5;
        return r2;
    L5:
        throw new IllegalArgumentException(r1 + " may not be null");
    }

    @Deprecated
    protected static long checkNotNegative(String r2, long r3) {
        if (r3 < 0) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException(r2 + " may not be negative");
    }
}

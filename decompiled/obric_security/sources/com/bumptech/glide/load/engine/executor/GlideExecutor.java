package com.bumptech.glide.load.engine.executor;

import android.text.TextUtils;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class GlideExecutor implements ExecutorService {
    static final String DEFAULT_ANIMATION_EXECUTOR_NAME = "animation";
    static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final String DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    private static final long KEEP_ALIVE_TIME_MS = 0;
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String TAG = "GlideExecutor";
    private static volatile int bestThreadCount;
    private final ExecutorService delegate;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        public static final long NO_THREAD_TIMEOUT = 0;
        private int corePoolSize;
        private int maximumPoolSize;
        private String name;
        private final boolean preventNetworkOperations;
        private ThreadFactory threadFactory;
        private long threadTimeoutMillis;
        private UncaughtThrowableStrategy uncaughtThrowableStrategy;

        Builder(boolean r3) {
            this.threadFactory = new DefaultPriorityThreadFactory(null);
            this.uncaughtThrowableStrategy = UncaughtThrowableStrategy.DEFAULT;
            this.preventNetworkOperations = r3;
        }

        public Builder setThreadTimeoutMillis(long r1) {
            this.threadTimeoutMillis = r1;
            return this;
        }

        public Builder setThreadCount(int r1) {
            this.corePoolSize = r1;
            this.maximumPoolSize = r1;
            return this;
        }

        @Deprecated
        public Builder setThreadFactory(ThreadFactory r1) {
            this.threadFactory = r1;
            return this;
        }

        public Builder setUncaughtThrowableStrategy(UncaughtThrowableStrategy r1) {
            this.uncaughtThrowableStrategy = r1;
            return this;
        }

        public Builder setName(String r1) {
            this.name = r1;
            return this;
        }

        public GlideExecutor build() {
            if (TextUtils.isEmpty(this.name) == true) goto L10;
            ThreadPoolExecutor r0 = new ThreadPoolExecutor(this.corePoolSize, this.maximumPoolSize, this.threadTimeoutMillis, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.threadFactory, this.name, this.uncaughtThrowableStrategy, this.preventNetworkOperations));
            if (this.threadTimeoutMillis == 0) goto L8;
            r0.allowCoreThreadTimeOut(true);
        L8:
            return new GlideExecutor(r0);
        L10:
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.name);
        }
    }

    private static final class DefaultPriorityThreadFactory implements ThreadFactory {
        private static final int DEFAULT_PRIORITY = 9;

        private DefaultPriorityThreadFactory() {
        }

        /* synthetic */ DefaultPriorityThreadFactory(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r2) {
            return new AnonymousClass1(this, r2);
        }
    }

    private static final class DefaultThreadFactory implements ThreadFactory {
        private final ThreadFactory delegate;
        private final String name;
        final boolean preventNetworkOperations;
        private final AtomicInteger threadNum;
        final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        DefaultThreadFactory(ThreadFactory r2, String r3, UncaughtThrowableStrategy r4, boolean r5) {
            this.threadNum = new AtomicInteger();
            this.delegate = r2;
            this.name = r3;
            this.uncaughtThrowableStrategy = r4;
            this.preventNetworkOperations = r5;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r3) {
            Thread r4 = this.delegate.newThread(new AnonymousClass1(this, r3));
            r4.setName("glide-" + this.name + "-thread-" + this.threadNum.getAndIncrement());
            return r4;
        }
    }

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT = null;
        public static final UncaughtThrowableStrategy IGNORE = null;
        public static final UncaughtThrowableStrategy LOG = null;
        public static final UncaughtThrowableStrategy THROW = null;

        void handle(Throwable r1);

        static {
            IGNORE = new AnonymousClass1();
            UncaughtThrowableStrategy r0 = new AnonymousClass2();
            LOG = r0;
            THROW = new AnonymousClass3();
            DEFAULT = r0;
        }
    }

    static {
        KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10);
    }

    public static Builder newDiskCacheBuilder() {
        return new Builder(true).setThreadCount(1).setName(DEFAULT_DISK_CACHE_EXECUTOR_NAME);
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy r1) {
        return newDiskCacheBuilder().setUncaughtThrowableStrategy(r1).build();
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(int r1, String r2, UncaughtThrowableStrategy r3) {
        return newDiskCacheBuilder().setThreadCount(r1).setName(r2).setUncaughtThrowableStrategy(r3).build();
    }

    public static Builder newSourceBuilder() {
        return new Builder(false).setThreadCount(calculateBestThreadCount()).setName("source");
    }

    public static GlideExecutor newSourceExecutor() {
        return newSourceBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy r1) {
        return newSourceBuilder().setUncaughtThrowableStrategy(r1).build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(int r1, String r2, UncaughtThrowableStrategy r3) {
        return newSourceBuilder().setThreadCount(r1).setName(r2).setUncaughtThrowableStrategy(r3).build();
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(new DefaultPriorityThreadFactory(null), DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false)));
    }

    public static Builder newAnimationBuilder() {
        int r0 = calculateAnimationExecutorThreadCount();
        return new Builder(true).setThreadCount(r0).setName(DEFAULT_ANIMATION_EXECUTOR_NAME);
    }

    static int calculateAnimationExecutorThreadCount() {
        if (calculateBestThreadCount() < 4) goto L5;
        return 2;
    L5:
        return 1;
    }

    public static GlideExecutor newAnimationExecutor() {
        return newAnimationBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newAnimationExecutor(int r1, UncaughtThrowableStrategy r2) {
        return newAnimationBuilder().setThreadCount(r1).setUncaughtThrowableStrategy(r2).build();
    }

    GlideExecutor(ExecutorService r1) {
        this.delegate = r1;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r1) {
        this.delegate.execute(r1);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r1) {
        return this.delegate.submit(r1);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r1) throws InterruptedException {
        return this.delegate.invokeAll(r1);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r1, long r2, TimeUnit r4) throws InterruptedException {
        return this.delegate.invokeAll(r1, r2, r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r1) throws InterruptedException, ExecutionException {
        return (T) this.delegate.invokeAny(r1);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r1, long r2, TimeUnit r4) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.delegate.invokeAny(r1, r2, r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r1, T r2) {
        return this.delegate.submit(r1, r2);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r1) {
        return this.delegate.submit(r1);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.delegate.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r1, TimeUnit r3) throws InterruptedException {
        return this.delegate.awaitTermination(r1, r3);
    }

    public String toString() {
        return this.delegate.toString();
    }

    public static int calculateBestThreadCount() {
        if (bestThreadCount != 0) goto L6;
        bestThreadCount = Math.min(4, RuntimeCompat.availableProcessors());
    L6:
        return bestThreadCount;
    }
}

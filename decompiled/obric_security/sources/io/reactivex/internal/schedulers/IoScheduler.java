package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class IoScheduler extends Scheduler {
    static final RxThreadFactory EVICTOR_THREAD_FACTORY = null;
    private static final String EVICTOR_THREAD_NAME_PREFIX = "RxCachedWorkerPoolEvictor";
    private static final long KEEP_ALIVE_TIME = 0;
    public static final long KEEP_ALIVE_TIME_DEFAULT = 60;
    private static final TimeUnit KEEP_ALIVE_UNIT = null;
    private static final String KEY_IO_PRIORITY = "rx2.io-priority";
    private static final String KEY_KEEP_ALIVE_TIME = "rx2.io-keep-alive-time";
    static final CachedWorkerPool NONE = null;
    static final ThreadWorker SHUTDOWN_THREAD_WORKER = null;
    static final RxThreadFactory WORKER_THREAD_FACTORY = null;
    private static final String WORKER_THREAD_NAME_PREFIX = "RxCachedThreadScheduler";
    final AtomicReference<CachedWorkerPool> pool;
    final ThreadFactory threadFactory;

    static final class CachedWorkerPool implements Runnable {
        final CompositeDisposable allWorkers;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<ThreadWorker> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        CachedWorkerPool(long r8, TimeUnit r10, ThreadFactory r11) {
            if (r10 == null) goto L5;
            long r9 = r10.toNanos(r8);
        L6:
            long r4 = r9;
            this.keepAliveTime = r4;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue();
            this.allWorkers = new CompositeDisposable();
            this.threadFactory = r11;
            if (r10 == null) goto L9;
            ScheduledExecutorService r12 = Executors.newScheduledThreadPool(1, IoScheduler.EVICTOR_THREAD_FACTORY);
            ScheduledFuture<?> r13 = r12.scheduleWithFixedDelay(this, r4, r4, TimeUnit.NANOSECONDS);
        L10:
            this.evictorService = r12;
            this.evictorTask = r13;
            return;
        L9:
            r12 = null;
            r13 = null;
            goto L10
        L5:
            r9 = 0;
            goto L6
        }

        @Override // java.lang.Runnable
        public void run() {
            evictExpiredWorkers();
        }

        ThreadWorker get() {
            if (this.allWorkers.isDisposed() == false) goto L7;
            return IoScheduler.SHUTDOWN_THREAD_WORKER;
        L7:
            if (this.expiringWorkerQueue.isEmpty() == true) goto L11;
            ThreadWorker r0 = this.expiringWorkerQueue.poll();
            if (r0 == null) goto L7;
            return r0;
        L11:
            ThreadWorker r1 = new ThreadWorker(this.threadFactory);
            this.allWorkers.add(r1);
            return r1;
        }

        void release(ThreadWorker r5) {
            r5.setExpirationTime(now() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(r5);
        }

        void evictExpiredWorkers() {
            if (this.expiringWorkerQueue.isEmpty() == true) goto L12;
            long r0 = now();
            Iterator<ThreadWorker> r2 = this.expiringWorkerQueue.iterator();
        L6:
            if (r2.hasNext() == false) goto L19;
            ThreadWorker r3 = r2.next();
            if (r3.getExpirationTime() > r0) goto L20;
            if (this.expiringWorkerQueue.remove(r3) == false) goto L6;
            this.allWorkers.remove(r3);
            goto L6
        L20:
            return;
        L19:
            return;
        }

        long now() {
            return System.nanoTime();
        }

        void shutdown() {
            this.allWorkers.dispose();
            Future<?> r0 = this.evictorTask;
            if (r0 == null) goto L5;
            r0.cancel(true);
        L5:
            ScheduledExecutorService r2 = this.evictorService;
            if (r2 == null) goto L9;
            r2.shutdownNow();
            return;
        }
    }

    static final class EventLoopWorker extends Scheduler.Worker {
        final AtomicBoolean once;
        private final CachedWorkerPool pool;
        private final CompositeDisposable tasks;
        private final ThreadWorker threadWorker;

        EventLoopWorker(CachedWorkerPool r2) {
            this.once = new AtomicBoolean();
            this.pool = r2;
            this.tasks = new CompositeDisposable();
            this.threadWorker = r2.get();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            this.tasks.dispose();
            this.pool.release(this.threadWorker);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r7, long r8, TimeUnit r10) {
            if (this.tasks.isDisposed() == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.threadWorker.scheduleActual(r7, r8, r10, this.tasks);
        }
    }

    static final class ThreadWorker extends NewThreadWorker {
        private long expirationTime;

        ThreadWorker(ThreadFactory r3) {
            super(r3);
            this.expirationTime = 0;
        }

        public long getExpirationTime() {
            return this.expirationTime;
        }

        public void setExpirationTime(long r1) {
            this.expirationTime = r1;
        }
    }

    static {
        KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
        KEEP_ALIVE_TIME = Long.getLong(KEY_KEEP_ALIVE_TIME, 60).longValue();
        ThreadWorker r0 = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        SHUTDOWN_THREAD_WORKER = r0;
        r0.dispose();
        int r1 = Math.max(1, Math.min(10, Integer.getInteger(KEY_IO_PRIORITY, 5).intValue()));
        RxThreadFactory r2 = new RxThreadFactory(WORKER_THREAD_NAME_PREFIX, r1);
        WORKER_THREAD_FACTORY = r2;
        EVICTOR_THREAD_FACTORY = new RxThreadFactory(EVICTOR_THREAD_NAME_PREFIX, r1);
        CachedWorkerPool r3 = new CachedWorkerPool(0, null, r2);
        NONE = r3;
        r3.shutdown();
    }

    public IoScheduler() {
        this(WORKER_THREAD_FACTORY);
    }

    public IoScheduler(ThreadFactory r2) {
        this.threadFactory = r2;
        this.pool = new AtomicReference(NONE);
        start();
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        CachedWorkerPool r0 = new CachedWorkerPool(KEEP_ALIVE_TIME, KEEP_ALIVE_UNIT, this.threadFactory);
        if (b0$$ExternalSyntheticBackport0.m(this.pool, NONE, r0) == true) goto L6;
        r0.shutdown();
        return;
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
    L2:
        CachedWorkerPool r0 = this.pool.get();
        CachedWorkerPool r1 = NONE;
        if (r0 == r1) goto L4;
        if (b0$$ExternalSyntheticBackport0.m(this.pool, r0, r1) == false) goto L2;
        r0.shutdown();
        return;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get());
    }

    public int size() {
        return this.pool.get().allWorkers.size();
    }
}

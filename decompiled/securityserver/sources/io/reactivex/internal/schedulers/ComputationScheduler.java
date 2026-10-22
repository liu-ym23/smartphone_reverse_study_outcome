package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {
    private static final String KEY_COMPUTATION_PRIORITY = "rx2.computation-priority";
    static final String KEY_MAX_THREADS = "rx2.computation-threads";
    static final int MAX_THREADS = 0;
    static final FixedSchedulerPool NONE = null;
    static final PoolWorker SHUTDOWN_WORKER = null;
    static final RxThreadFactory THREAD_FACTORY = null;
    private static final String THREAD_NAME_PREFIX = "RxComputationThreadPool";
    final AtomicReference<FixedSchedulerPool> pool;
    final ThreadFactory threadFactory;

    public static final class EventLoopWorker extends Scheduler.Worker {
        private final ListCompositeDisposable both;
        volatile boolean disposed;
        private final PoolWorker poolWorker;
        private final ListCompositeDisposable serial;
        private final CompositeDisposable timed;

        public EventLoopWorker(PoolWorker r3) {
            this.poolWorker = r3;
            ListCompositeDisposable r4 = new ListCompositeDisposable();
            this.serial = r4;
            CompositeDisposable r0 = new CompositeDisposable();
            this.timed = r0;
            ListCompositeDisposable r1 = new ListCompositeDisposable();
            this.both = r1;
            r1.add(r4);
            r1.add(r0);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed == true) goto L6;
            this.disposed = true;
            this.both.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable r7) {
            if (this.disposed == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.poolWorker.scheduleActual(r7, 0, TimeUnit.MILLISECONDS, this.serial);
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable r7, long r8, @NonNull TimeUnit r10) {
            if (this.disposed == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.poolWorker.scheduleActual(r7, r8, r10, this.timed);
        }
    }

    public static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {
        final int cores;
        final PoolWorker[] eventLoops;
        long n;

        public FixedSchedulerPool(int r4, ThreadFactory r5) {
            this.cores = r4;
            this.eventLoops = new PoolWorker[r4];
            int r0 = 0;
        L3:
            if (r0 >= r4) goto L5;
            this.eventLoops[r0] = new PoolWorker(r5);
            r0 = r0 + 1;
            goto L3
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
        public void createWorkers(int r7, SchedulerMultiWorkerSupport.WorkerCallback r8) {
            int r0 = this.cores;
            int r1 = 0;
            if (r0 != 0) goto L6;
        L4:
            if (r1 >= r7) goto L18;
            r8.onWorker(r1, ComputationScheduler.SHUTDOWN_WORKER);
            r1 = r1 + 1;
            goto L4
        L18:
            return;
        L6:
            int r2 = ((int) this.n) % r0;
            int r3 = 0;
        L7:
            if (r3 >= r7) goto L12;
            r8.onWorker(r3, new EventLoopWorker(this.eventLoops[r2]));
            r2 = r2 + 1;
            if (r2 != r0) goto L11;
            r2 = 0;
        L11:
            r3 = r3 + 1;
            goto L7
        L12:
            this.n = r2;
        }

        public PoolWorker getEventLoop() {
            int r0 = this.cores;
            if (r0 == 0) goto L5;
            PoolWorker[] r1 = this.eventLoops;
            long r2 = this.n;
            this.n = 1 + r2;
            return r1[(int) (r2 % ((long) r0))];
        L5:
            return ComputationScheduler.SHUTDOWN_WORKER;
        }

        public void shutdown() {
            PoolWorker[] r3 = this.eventLoops;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L3
        }
    }

    public static final class PoolWorker extends NewThreadWorker {
        public PoolWorker(ThreadFactory r1) {
            super(r1);
        }
    }

    static {
        MAX_THREADS = cap(Runtime.getRuntime().availableProcessors(), Integer.getInteger(KEY_MAX_THREADS, 0).intValue());
        PoolWorker r0 = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        SHUTDOWN_WORKER = r0;
        r0.dispose();
        RxThreadFactory r3 = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_COMPUTATION_PRIORITY, 5).intValue())), true);
        THREAD_FACTORY = r3;
        FixedSchedulerPool r1 = new FixedSchedulerPool(0, r3);
        NONE = r1;
        r1.shutdown();
    }

    public ComputationScheduler() {
        this(THREAD_FACTORY);
    }

    public static int cap(int r0, int r1) {
        if (r1 <= 0) goto L7;
        if (r1 <= r0) goto L6;
        return r0;
    L6:
        return r1;
    L7:
        return r0;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get().getEventLoop());
    }

    @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
    public void createWorkers(int r2, SchedulerMultiWorkerSupport.WorkerCallback r3) {
        ObjectHelper.verifyPositive(r2, "number > 0 required");
        this.pool.get().createWorkers(r2, r3);
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable r1, long r2, TimeUnit r4) {
        return this.pool.get().getEventLoop().scheduleDirect(r1, r2, r4);
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable r8, long r9, long r11, TimeUnit r13) {
        return this.pool.get().getEventLoop().schedulePeriodicallyDirect(r8, r9, r11, r13);
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
    L2:
        FixedSchedulerPool r0 = this.pool.get();
        FixedSchedulerPool r1 = NONE;
        if (r0 == r1) goto L4;
        if (this.pool.compareAndSet(r0, r1) == false) goto L2;
        r0.shutdown();
        return;
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        FixedSchedulerPool r0 = new FixedSchedulerPool(MAX_THREADS, this.threadFactory);
        if (this.pool.compareAndSet(NONE, r0) == true) goto L6;
        r0.shutdown();
        return;
    }

    public ComputationScheduler(ThreadFactory r2) {
        this.threadFactory = r2;
        this.pool = new AtomicReference(NONE);
        start();
    }
}

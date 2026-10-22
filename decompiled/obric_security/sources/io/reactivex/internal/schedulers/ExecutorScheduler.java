package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ExecutorScheduler extends Scheduler {
    static final Scheduler HELPER = null;
    final Executor executor;
    final boolean interruptibleWorker;

    final class DelayedDispose implements Runnable {
        private final DelayedRunnable dr;
        final /* synthetic */ ExecutorScheduler this$0;

        DelayedDispose(ExecutorScheduler r1, DelayedRunnable r2) {
            this.this$0 = r1;
            this.dr = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.dr.direct.replace(this.this$0.scheduleDirect(this.dr));
        }
    }

    static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct;
        final SequentialDisposable timed;

        DelayedRunnable(Runnable r1) {
            super(r1);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable r0 = get();
            if (r0 != null) goto L11;
            return;
        L11:
            r0.run();     // Catch: Throwable -> L7
            lazySet(null);
            this.timed.lazySet(DisposableHelper.DISPOSED);
            this.direct.lazySet(DisposableHelper.DISPOSED);
            return;
        L7:
            th = move-exception;
            lazySet(null);
            this.timed.lazySet(DisposableHelper.DISPOSED);
            this.direct.lazySet(DisposableHelper.DISPOSED);
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(null) == null) goto L6;
            this.timed.dispose();
            this.direct.dispose();
            return;
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            Runnable r0 = get();
            if (r0 == null) goto L6;
            return r0;
        L6:
            return Functions.EMPTY_RUNNABLE;
        }
    }

    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        volatile boolean disposed;
        final Executor executor;
        final boolean interruptibleWorker;
        final MpscLinkedQueue<Runnable> queue;
        final CompositeDisposable tasks;
        final AtomicInteger wip;

        static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            BooleanRunnable(Runnable r1) {
                this.actual = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == false) goto L12;
                return;
            L12:
                this.actual.run();     // Catch: Throwable -> L9
                lazySet(true);
                return;
            L9:
                th = move-exception;
                lazySet(true);
                throw th;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get();
            }
        }

        static final class InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final DisposableContainer tasks;
            volatile Thread thread;

            InterruptibleRunnable(Runnable r1, DisposableContainer r2) {
                this.run = r1;
                this.tasks = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() != 0) goto L30;
                this.thread = Thread.currentThread();
                if (compareAndSet(0, 1) == true) goto L26;
                this.thread = null;
                return;
            L26:
                this.run.run();     // Catch: Throwable -> L15
                this.thread = null;
                if (compareAndSet(1, 2) == false) goto L12;
                cleanup();
                return;
            L12:
                if (get() != 3) goto L14;
                Thread.yield();
                goto L12
            L14:
                Thread.interrupted();
                return;
            L15:
                th = move-exception;
                this.thread = null;
                if (compareAndSet(1, 2) == false) goto L19;
                cleanup();
            L23:
                throw th;
            L19:
                if (get() != 3) goto L21;
                Thread.yield();
                goto L19
            L21:
                Thread.interrupted();
                goto L23
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
            L2:
                int r0 = get();
                if (r0 >= 2) goto L26;
                if (r0 == 0) goto L8;
                if (compareAndSet(1, 3) == false) goto L2;
                Thread r1 = this.thread;
                if (r1 == null) goto L15;
                r1.interrupt();
                this.thread = null;
            L15:
                set(4);
                cleanup();
                return;
            L8:
                if (compareAndSet(0, 4) == false) goto L2;
                cleanup();
                return;
            }

            void cleanup() {
                DisposableContainer r0 = this.tasks;
                if (r0 == null) goto L6;
                r0.delete(this);
                return;
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                if (get() < 2) goto L5;
                return true;
            L5:
                return false;
            }
        }

        final class SequentialDispose implements Runnable {
            private final Runnable decoratedRun;
            private final SequentialDisposable mar;
            final /* synthetic */ ExecutorWorker this$0;

            SequentialDispose(ExecutorWorker r1, SequentialDisposable r2, Runnable r3) {
                this.this$0 = r1;
                this.mar = r2;
                this.decoratedRun = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mar.replace(this.this$0.schedule(this.decoratedRun));
            }
        }

        public ExecutorWorker(Executor r2, boolean r3) {
            this.wip = new AtomicInteger();
            this.tasks = new CompositeDisposable();
            this.executor = r2;
            this.queue = new MpscLinkedQueue();
            this.interruptibleWorker = r3;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r3) {
            if (this.disposed == true) goto L5;
            Runnable r4 = RxJavaPlugins.onSchedule(r3);
            if (this.interruptibleWorker == false) goto L9;
            Disposable r0 = new InterruptibleRunnable(r4, this.tasks);
            this.tasks.add(r0);
        L10:
            this.queue.offer(r0);
            if (this.wip.getAndIncrement() == 0) goto L18;
        L17:
            return r0;
        L18:
            this.executor.execute(this);     // Catch: RejectedExecutionException -> L14
        L14:
            e = move-exception;
            this.disposed = true;
            this.queue.clear();
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        L9:
            r0 = new BooleanRunnable(r4);
            goto L10
        L5:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r5, long r6, TimeUnit r8) {
            if (r6 > 0) goto L7;
            return schedule(r5);
        L7:
            if (this.disposed == true) goto L9;
            SequentialDisposable r0 = new SequentialDisposable();
            SequentialDisposable r1 = new SequentialDisposable(r0);
            ScheduledRunnable r2 = new ScheduledRunnable(new SequentialDispose(this, r1, RxJavaPlugins.onSchedule(r5)), this.tasks);
            this.tasks.add(r2);
            Executor r7 = this.executor;
            if ((r7 instanceof ScheduledExecutorService) == true) goto L20;
            r2.setFuture(new DisposeOnCancel(ExecutorScheduler.HELPER.scheduleDirect(r2, r6, r8)));
        L18:
            r0.replace(r2);
            return r1;
        L20:
            r2.setFuture(((ScheduledExecutorService) r7).schedule(r2, r6, r8));     // Catch: RejectedExecutionException -> L14
        L14:
            e = move-exception;
            this.disposed = true;
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        L9:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed == true) goto L8;
            this.disposed = true;
            this.tasks.dispose();
            if (this.wip.getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            MpscLinkedQueue<Runnable> r0 = this.queue;
            int r1 = 1;
        L4:
            if (this.disposed == true) goto L5;
        L7:
            Runnable r2 = r0.poll();
            if (r2 == null) goto L10;
            r2.run();
            if (this.disposed == false) goto L7;
            r0.clear();
            return;
        L10:
            if (this.disposed == true) goto L11;
            r1 = this.wip.addAndGet(-r1);
            if (r1 != 0) goto L4;
            return;
        L11:
            r0.clear();
            return;
        L5:
            r0.clear();
        }
    }

    static {
        HELPER = Schedulers.single();
    }

    public ExecutorScheduler(Executor r1, boolean r2) {
        this.executor = r1;
        this.interruptibleWorker = r2;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.executor, this.interruptibleWorker);
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable r3) {
        Runnable r4 = RxJavaPlugins.onSchedule(r3);
    L13:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    L4:
        if ((this.executor instanceof ExecutorService) == false) goto L8;
        ScheduledDirectTask r0 = new ScheduledDirectTask(r4);     // Catch: RejectedExecutionException -> L13
        r0.setFuture(((ExecutorService) this.executor).submit(r0));     // Catch: RejectedExecutionException -> L13
        return r0;
    L8:
        if (this.interruptibleWorker == false) goto L11;
        ExecutorWorker.InterruptibleRunnable r1 = new ExecutorWorker.InterruptibleRunnable(r4, null);     // Catch: RejectedExecutionException -> L13
        this.executor.execute(r1);     // Catch: RejectedExecutionException -> L13
        return r1;
    L11:
        ExecutorWorker.BooleanRunnable r2 = new ExecutorWorker.BooleanRunnable(r4);     // Catch: RejectedExecutionException -> L13
        this.executor.execute(r2);     // Catch: RejectedExecutionException -> L13
        return r2;
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable r3, long r4, TimeUnit r6) {
        Runnable r5 = RxJavaPlugins.onSchedule(r3);
        if ((this.executor instanceof ScheduledExecutorService) == true) goto L11;
        DelayedRunnable r0 = new DelayedRunnable(r5);
        Disposable r2 = HELPER.scheduleDirect(new DelayedDispose(this, r0), r4, r6);
        r0.timed.replace(r2);
        return r0;
    L11:
        ScheduledDirectTask r1 = new ScheduledDirectTask(r5);     // Catch: RejectedExecutionException -> L6
        r1.setFuture(((ScheduledExecutorService) this.executor).schedule(r1, r4, r6));     // Catch: RejectedExecutionException -> L6
        return r1;
    L6:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable r9, long r10, long r12, TimeUnit r14) {
        if ((this.executor instanceof ScheduledExecutorService) == false) goto L11;
        ScheduledDirectPeriodicTask r7 = new ScheduledDirectPeriodicTask(RxJavaPlugins.onSchedule(r9));     // Catch: RejectedExecutionException -> L7
        r7.setFuture(((ScheduledExecutorService) this.executor).scheduleAtFixedRate(r7, r10, r12, r14));     // Catch: RejectedExecutionException -> L7
        return r7;
    L7:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    L11:
        return super.schedulePeriodicallyDirect(r9, r10, r12, r14);
    }
}

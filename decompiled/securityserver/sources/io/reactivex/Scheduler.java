package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = 0;

    public static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {

        @NonNull
        final Runnable decoratedRun;

        @Nullable
        Thread runner;

        @NonNull
        final Worker w;

        public DisposeTask(@NonNull Runnable r1, @NonNull Worker r2) {
            this.decoratedRun = r1;
            this.w = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.runner != Thread.currentThread()) goto L7;
            Worker r0 = this.w;
            if ((r0 instanceof NewThreadWorker) == false) goto L7;
            ((NewThreadWorker) r0).shutdown();
            return;
        L7:
            this.w.dispose();
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.decoratedRun;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            this.decoratedRun.run();     // Catch: Throwable -> L6
            dispose();
            this.runner = null;
            return;
        L6:
            th = move-exception;
            dispose();
            this.runner = null;
            throw th;
        }
    }

    public static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        volatile boolean disposed;

        @NonNull
        final Runnable run;

        @NonNull
        final Worker worker;

        public PeriodicDirectTask(@NonNull Runnable r1, @NonNull Worker r2) {
            this.run = r1;
            this.worker = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.run;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.disposed == false) goto L10;
            return;
        L10:
            this.run.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.worker.dispose();
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static abstract class Worker implements Disposable {

        public final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            long count;

            @NonNull
            final Runnable decoratedRun;
            long lastNowNanoseconds;
            final long periodInNanoseconds;

            @NonNull
            final SequentialDisposable sd;
            long startInNanoseconds;
            final /* synthetic */ Worker this$0;

            public PeriodicTask(Worker r1, @NonNull long r2, Runnable r4, @NonNull long r5, SequentialDisposable r7, long r8) {
                this.this$0 = r1;
                this.decoratedRun = r4;
                this.sd = r7;
                this.periodInNanoseconds = r8;
                this.lastNowNanoseconds = r5;
                this.startInNanoseconds = r2;
            }

            @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
            public Runnable getWrappedRunnable() {
                return this.decoratedRun;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.decoratedRun.run();
                if (this.sd.isDisposed() == true) goto L13;
                Worker r0 = this.this$0;
                TimeUnit r1 = TimeUnit.NANOSECONDS;
                long r2 = r0.now(r1);
                long r4 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
                long r6 = r2 + r4;
                long r8 = this.lastNowNanoseconds;
                if (r6 < r8) goto L10;
                long r10 = this.periodInNanoseconds;
                if (r2 >= ((r8 + r10) + r4)) goto L10;
                long r5 = this.startInNanoseconds;
                long r9 = this.count + 1;
                this.count = r9;
                long r11 = (r9 * r10) + r5;
            L11:
                this.lastNowNanoseconds = r2;
                long r12 = r11 - r2;
                this.sd.replace(this.this$0.schedule(this, r12, r1));
                return;
            L10:
                long r7 = this.periodInNanoseconds;
                r11 = r2 + r7;
                long r13 = this.count + 1;
                this.count = r13;
                this.startInNanoseconds = r11 - (r7 * r13);
                goto L11
            }
        }

        public Worker() {
        }

        public long now(@NonNull TimeUnit r3) {
            return r3.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable r4) {
            return schedule(r4, 0, TimeUnit.NANOSECONDS);
        }

        @NonNull
        public abstract Disposable schedule(@NonNull Runnable r1, long r2, @NonNull TimeUnit r4);

        @NonNull
        public Disposable schedulePeriodically(@NonNull Runnable r18, long r19, long r21, @NonNull TimeUnit r23) {
            SequentialDisposable r14 = new SequentialDisposable();
            SequentialDisposable r15 = new SequentialDisposable(r14);
            Runnable r4 = RxJavaPlugins.onSchedule(r18);
            long r8 = r23.toNanos(r21);
            long r5 = now(TimeUnit.NANOSECONDS);
            Disposable r0 = schedule(new PeriodicTask(this, r23.toNanos(r19) + r5, r4, r5, r15, r8), r19, r23);
            if (r0 != EmptyDisposable.INSTANCE) goto L5;
            return r0;
        L5:
            r14.replace(r0);
            return r15;
        }
    }

    static {
        CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());
    }

    public Scheduler() {
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    @NonNull
    public abstract Worker createWorker();

    public long now(@NonNull TimeUnit r3) {
        return r3.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable r4) {
        return scheduleDirect(r4, 0, TimeUnit.NANOSECONDS);
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable r8, long r9, long r11, @NonNull TimeUnit r13) {
        Worker r0 = createWorker();
        PeriodicDirectTask r10 = new PeriodicDirectTask(RxJavaPlugins.onSchedule(r8), r0);
        Disposable r7 = r0.schedulePeriodically(r10, r9, r11, r13);
        if (r7 != EmptyDisposable.INSTANCE) goto L5;
        return r7;
    L5:
        return r10;
    }

    public void shutdown() {
    }

    public void start() {
    }

    @NonNull
    public <S extends Scheduler & Disposable> S when(@NonNull Function<Flowable<Flowable<Completable>>, Completable> r2) {
        return new SchedulerWhen(r2, this);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable r2, long r3, @NonNull TimeUnit r5) {
        Worker r1 = createWorker();
        DisposeTask r0 = new DisposeTask(RxJavaPlugins.onSchedule(r2), r1);
        r1.schedule(r0, r3, r5);
        return r0;
    }
}

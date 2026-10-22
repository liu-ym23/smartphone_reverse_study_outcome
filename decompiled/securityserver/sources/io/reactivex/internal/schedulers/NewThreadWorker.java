package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class NewThreadWorker extends Scheduler.Worker implements Disposable {
    volatile boolean disposed;
    private final ScheduledExecutorService executor;

    public NewThreadWorker(ThreadFactory r1) {
        this.executor = SchedulerPoolFactory.create(r1);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.disposed == true) goto L6;
        this.disposed = true;
        this.executor.shutdownNow();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.Scheduler.Worker
    @NonNull
    public Disposable schedule(@NonNull Runnable r4) {
        return schedule(r4, 0, null);
    }

    @NonNull
    public ScheduledRunnable scheduleActual(Runnable r4, long r5, @NonNull TimeUnit r7, @Nullable DisposableContainer r8) {
        ScheduledRunnable r0 = new ScheduledRunnable(RxJavaPlugins.onSchedule(r4), r8);
        if (r8 == null) goto L19;
        if (r8.add(r0) == true) goto L19;
        return r0;
    L19:
        if (r5 > 0) goto L12;
        Future<?> r3 = this.executor.submit(r0);     // Catch: RejectedExecutionException -> L10
    L13:
        r0.setFuture(r3);     // Catch: RejectedExecutionException -> L10
    L18:
        return r0;
    L12:
        r3 = this.executor.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L10
    L10:
        e = move-exception;
        if (r8 == null) goto L17;
        r8.remove(r0);
    L17:
        RxJavaPlugins.onError(e);
        goto L18
    }

    public Disposable scheduleDirect(Runnable r4, long r5, TimeUnit r7) {
        ScheduledDirectTask r0 = new ScheduledDirectTask(RxJavaPlugins.onSchedule(r4));
        if (r5 > 0) goto L7;
        Future<?> r3 = this.executor.submit(r0);     // Catch: RejectedExecutionException -> L5
    L8:
        r0.setFuture(r3);     // Catch: RejectedExecutionException -> L5
        return r0;
    L7:
        r3 = this.executor.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L5
    L5:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }

    public Disposable schedulePeriodicallyDirect(Runnable r9, long r10, long r12, TimeUnit r14) {
        Runnable r11 = RxJavaPlugins.onSchedule(r9);
        if (r12 > 0) goto L14;
        InstantPeriodicTask r13 = new InstantPeriodicTask(r11, this.executor);
        if (r10 > 0) goto L9;
        Future<?> r8 = this.executor.submit(r13);     // Catch: RejectedExecutionException -> L7
    L10:
        r13.setFirst(r8);     // Catch: RejectedExecutionException -> L7
        return r13;
    L9:
        r8 = this.executor.schedule(r13, r10, r14);     // Catch: RejectedExecutionException -> L7
    L7:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    L14:
        ScheduledDirectPeriodicTask r7 = new ScheduledDirectPeriodicTask(r11);
        r7.setFuture(this.executor.scheduleAtFixedRate(r7, r10, r12, r14));     // Catch: RejectedExecutionException -> L17
        return r7;
    L17:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }

    public void shutdown() {
        if (this.disposed == true) goto L6;
        this.disposed = true;
        this.executor.shutdown();
        return;
    }

    @Override // io.reactivex.Scheduler.Worker
    @NonNull
    public Disposable schedule(@NonNull Runnable r7, long r8, @NonNull TimeUnit r10) {
        if (this.disposed == false) goto L7;
        return EmptyDisposable.INSTANCE;
    L7:
        return scheduleActual(r7, r8, r10, null);
    }
}

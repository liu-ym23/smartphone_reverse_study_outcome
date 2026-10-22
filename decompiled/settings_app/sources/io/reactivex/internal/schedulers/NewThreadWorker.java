package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class NewThreadWorker extends Scheduler.Worker implements Disposable {
    volatile boolean disposed;
    private final ScheduledExecutorService executor;

    public NewThreadWorker(ThreadFactory r1) {
        this.executor = SchedulerPoolFactory.create(r1);
    }

    @Override // io.reactivex.Scheduler.Worker
    public Disposable schedule(Runnable r4) {
        return schedule(r4, 0, null);
    }

    @Override // io.reactivex.Scheduler.Worker
    public Disposable schedule(Runnable r7, long r8, TimeUnit r10) {
        if (this.disposed == false) goto L7;
        return EmptyDisposable.INSTANCE;
    L7:
        return scheduleActual(r7, r8, r10, null);
    }

    public Disposable scheduleDirect(Runnable r4, long r5, TimeUnit r7) {
        ScheduledDirectTask r0 = new ScheduledDirectTask(RxJavaPlugins.onSchedule(r4));
        if (r5 > 0) goto L5;
        Future<?> r3 = this.executor.submit(r0);     // Catch: RejectedExecutionException -> L8
    L6:
        r0.setFuture(r3);     // Catch: RejectedExecutionException -> L8
        return r0;
    L5:
        r3 = this.executor.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }

    public Disposable schedulePeriodicallyDirect(Runnable r9, long r10, long r12, TimeUnit r14) {
        Runnable r11 = RxJavaPlugins.onSchedule(r9);
        if (r12 > 0) goto L13;
        InstantPeriodicTask r13 = new InstantPeriodicTask(r11, this.executor);
        if (r10 > 0) goto L7;
        Future<?> r8 = this.executor.submit(r13);     // Catch: RejectedExecutionException -> L10
    L8:
        r13.setFirst(r8);     // Catch: RejectedExecutionException -> L10
        return r13;
    L7:
        r8 = this.executor.schedule(r13, r10, r14);     // Catch: RejectedExecutionException -> L10
    L10:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    L13:
        ScheduledDirectPeriodicTask r7 = new ScheduledDirectPeriodicTask(r11);
        r7.setFuture(this.executor.scheduleAtFixedRate(r7, r10, r12, r14));     // Catch: RejectedExecutionException -> L16
        return r7;
    L16:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }

    public ScheduledRunnable scheduleActual(Runnable r4, long r5, TimeUnit r7, DisposableContainer r8) {
        ScheduledRunnable r0 = new ScheduledRunnable(RxJavaPlugins.onSchedule(r4), r8);
        if (r8 == null) goto L18;
        if (r8.add(r0) == true) goto L18;
        return r0;
    L18:
        if (r5 > 0) goto L10;
        Future<?> r3 = this.executor.submit(r0);     // Catch: RejectedExecutionException -> L13
    L11:
        r0.setFuture(r3);     // Catch: RejectedExecutionException -> L13
    L17:
        return r0;
    L10:
        r3 = this.executor.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L13
    L13:
        e = move-exception;
        if (r8 == null) goto L16;
        r8.remove(r0);
    L16:
        RxJavaPlugins.onError(e);
        goto L17
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.disposed == true) goto L6;
        this.disposed = true;
        this.executor.shutdownNow();
        return;
    }

    public void shutdown() {
        if (this.disposed == true) goto L6;
        this.disposed = true;
        this.executor.shutdown();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }
}

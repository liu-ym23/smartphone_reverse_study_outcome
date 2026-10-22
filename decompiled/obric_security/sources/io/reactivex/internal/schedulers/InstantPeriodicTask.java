package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
final class InstantPeriodicTask implements Callable<Void>, Disposable {
    static final FutureTask<Void> CANCELLED = null;
    final ExecutorService executor;
    final AtomicReference<Future<?>> first;
    final AtomicReference<Future<?>> rest;
    Thread runner;
    final Runnable task;

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() throws Exception {
        return call2();
    }

    static {
        CANCELLED = new FutureTask(Functions.EMPTY_RUNNABLE, null);
    }

    InstantPeriodicTask(Runnable r1, ExecutorService r2) {
        this.task = r1;
        this.first = new AtomicReference();
        this.rest = new AtomicReference();
        this.executor = r2;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() throws Exception {
        this.runner = Thread.currentThread();
        this.task.run();     // Catch: Throwable -> L5
        setRest(this.executor.submit(this));     // Catch: Throwable -> L5
        this.runner = null;     // Catch: Throwable -> L5
    L7:
        return null;
    L5:
        th = move-exception;
        this.runner = null;
        RxJavaPlugins.onError(th);
        goto L7
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        AtomicReference<Future<?>> r0 = this.first;
        FutureTask<Void> r1 = CANCELLED;
        Future<?> r2 = r0.getAndSet(r1);
        boolean r3 = true;
        if (r2 == null) goto L10;
        if (r2 == r1) goto L10;
        if (this.runner == Thread.currentThread()) goto L8;
        boolean r4 = true;
    L9:
        r2.cancel(r4);
        goto L10
    L8:
        r4 = false;
    L10:
        Future<?> r5 = this.rest.getAndSet(r1);
        if (r5 == null) goto L19;
        if (r5 != r1) goto L14;
        return;
    L14:
        if (this.runner != Thread.currentThread()) goto L17;
        r3 = false;
    L17:
        r5.cancel(r3);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.first.get() != CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    void setFirst(Future<?> r3) {
    L2:
        Future<?> r0 = this.first.get();
        if (r0 == CANCELLED) goto L5;
        if (b0$$ExternalSyntheticBackport0.m(this.first, r0, r3) == false) goto L2;
        return;
    L5:
        if (this.runner == Thread.currentThread()) goto L7;
        boolean r2 = true;
    L8:
        r3.cancel(r2);
        return;
    L7:
        r2 = false;
        goto L8
    }

    void setRest(Future<?> r3) {
    L2:
        Future<?> r0 = this.rest.get();
        if (r0 == CANCELLED) goto L5;
        if (b0$$ExternalSyntheticBackport0.m(this.rest, r0, r3) == false) goto L2;
        return;
    L5:
        if (this.runner == Thread.currentThread()) goto L7;
        boolean r2 = true;
    L8:
        r3.cancel(r2);
        return;
    L7:
        r2 = false;
        goto L8
    }
}

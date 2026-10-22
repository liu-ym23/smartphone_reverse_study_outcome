package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final ExecutionList executionList;

    public static <V> ListenableFutureTask<V> create(Callable<V> r1) {
        return new ListenableFutureTask(r1);
    }

    public static <V> ListenableFutureTask<V> create(Runnable r1, @ParametricNullness V r2) {
        return new ListenableFutureTask(r1, r2);
    }

    ListenableFutureTask(Callable<V> r1) {
        super(r1);
        this.executionList = new ExecutionList();
    }

    ListenableFutureTask(Runnable r1, @ParametricNullness V r2) {
        super(r1, r2);
        this.executionList = new ExecutionList();
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r1, Executor r2) {
        this.executionList.add(r1, r2);
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    @ParametricNullness
    public V get(long r6, TimeUnit r8) throws TimeoutException, InterruptedException, ExecutionException {
        long r0 = r8.toNanos(r6);
        if (r0 > 2147483647999999999L) goto L7;
        return (V) super.get(r6, r8);
    L7:
        return (V) super.get(Math.min(r0, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        this.executionList.execute();
    }
}

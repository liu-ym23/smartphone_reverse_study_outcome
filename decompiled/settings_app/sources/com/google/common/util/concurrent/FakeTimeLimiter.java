package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class FakeTimeLimiter implements TimeLimiter {
    public FakeTimeLimiter() {
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T r1, Class<T> r2, long r3, TimeUnit r5) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r5);
        return r1;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T callWithTimeout(Callable<T> r1, long r2, TimeUnit r4) throws ExecutionException {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r4);
        return r1.call();
    L8:
        e = move-exception;
        throw new ExecutionError(e);
    L14:
        e = move-exception;
        throw new UncheckedExecutionException(e);
    L11:
        e = move-exception;
        throw new ExecutionException(e);
    L5:
        th = move-exception;
        throw new ExecutionException(th);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T callUninterruptiblyWithTimeout(Callable<T> r1, long r2, TimeUnit r4) throws ExecutionException {
        return (T) callWithTimeout(r1, r2, r4);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable r1, long r2, TimeUnit r4) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r4);
        r1.run();     // Catch: Throwable -> L5 Error -> L8 RuntimeException -> L11
        return;
    L8:
        e = move-exception;
        throw new ExecutionError(e);
    L11:
        e = move-exception;
        throw new UncheckedExecutionException(e);
    L5:
        th = move-exception;
        throw new UncheckedExecutionException(th);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable r1, long r2, TimeUnit r4) {
        runWithTimeout(r1, r2, r4);
    }
}

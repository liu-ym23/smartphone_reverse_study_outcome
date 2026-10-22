package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use FakeTimeLimiter")
@ElementTypesAreNonnullByDefault
public interface TimeLimiter {
    <T> T callUninterruptiblyWithTimeout(Callable<T> r1, long r2, TimeUnit r4) throws TimeoutException, ExecutionException;

    <T> T callWithTimeout(Callable<T> r1, long r2, TimeUnit r4) throws TimeoutException, InterruptedException, ExecutionException;

    <T> T newProxy(T r1, Class<T> r2, long r3, TimeUnit r5);

    void runUninterruptiblyWithTimeout(Runnable r1, long r2, TimeUnit r4) throws TimeoutException;

    void runWithTimeout(Runnable r1, long r2, TimeUnit r4) throws TimeoutException, InterruptedException;

    default <T> T newProxy(T r7, Class<T> r8, Duration r9) {
        return (T) newProxy(r7, r8, Internal.toNanosSaturated(r9), TimeUnit.NANOSECONDS);
    }

    default <T> T callWithTimeout(Callable<T> r3, Duration r4) throws TimeoutException, InterruptedException, ExecutionException {
        return (T) callWithTimeout(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    default <T> T callUninterruptiblyWithTimeout(Callable<T> r3, Duration r4) throws TimeoutException, ExecutionException {
        return (T) callUninterruptiblyWithTimeout(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    default void runWithTimeout(Runnable r3, Duration r4) throws TimeoutException, InterruptedException {
        runWithTimeout(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    default void runUninterruptiblyWithTimeout(Runnable r3, Duration r4) throws TimeoutException {
        runUninterruptiblyWithTimeout(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }
}

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Uninterruptibles {
    public static void awaitUninterruptibly(CountDownLatch r1) {
        boolean r0 = false;
    L12:
        r1.await();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r0 == false) goto L15;
        Thread.currentThread().interrupt();
        return;
    L15:
        return;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    public static boolean awaitUninterruptibly(CountDownLatch r2, Duration r3) {
        return awaitUninterruptibly(r2, Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public static boolean awaitUninterruptibly(CountDownLatch r3, long r4, TimeUnit r6) {
        boolean r0 = false;
        long r5 = r6.toNanos(r4);     // Catch: Throwable -> L12
        long r1 = System.nanoTime() + r5;
    L18:
        boolean r7 = r3.await(r5, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r0 == false) goto L8;
        Thread.currentThread().interrupt();
    L8:
        return r7;
    L9:
        r0 = true;
        r5 = r1 - System.nanoTime();
    L12:
        th = move-exception;
        if (r0 == false) goto L15;
        Thread.currentThread().interrupt();
    L15:
        throw th;
    }

    public static boolean awaitUninterruptibly(Condition r2, Duration r3) {
        return awaitUninterruptibly(r2, Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public static boolean awaitUninterruptibly(Condition r3, long r4, TimeUnit r6) {
        boolean r0 = false;
        long r5 = r6.toNanos(r4);     // Catch: Throwable -> L12
        long r1 = System.nanoTime() + r5;
    L18:
        boolean r7 = r3.await(r5, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r0 == false) goto L8;
        Thread.currentThread().interrupt();
    L8:
        return r7;
    L9:
        r0 = true;
        r5 = r1 - System.nanoTime();
    L12:
        th = move-exception;
        if (r0 == false) goto L15;
        Thread.currentThread().interrupt();
    L15:
        throw th;
    }

    public static void joinUninterruptibly(Thread r1) {
        boolean r0 = false;
    L12:
        r1.join();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r0 == false) goto L15;
        Thread.currentThread().interrupt();
        return;
    L15:
        return;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    public static void joinUninterruptibly(Thread r2, Duration r3) {
        joinUninterruptibly(r2, Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public static void joinUninterruptibly(Thread r3, long r4, TimeUnit r6) {
        Preconditions.checkNotNull(r3);
        boolean r0 = false;
        long r5 = r6.toNanos(r4);     // Catch: Throwable -> L12
        long r1 = System.nanoTime() + r5;
    L18:
        TimeUnit.NANOSECONDS.timedJoin(r3, r5);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r0 == false) goto L21;
        Thread.currentThread().interrupt();
        return;
    L21:
        return;
    L9:
        r0 = true;
        r5 = r1 - System.nanoTime();
    L12:
        th = move-exception;
        if (r0 == false) goto L15;
        Thread.currentThread().interrupt();
    L15:
        throw th;
    }

    @ParametricNullness
    public static <V> V getUninterruptibly(Future<V> r1) throws ExecutionException {
        boolean r0 = false;
    L12:
        V r2 = r1.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r0 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r2;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    @ParametricNullness
    public static <V> V getUninterruptibly(Future<V> r2, Duration r3) throws ExecutionException, TimeoutException {
        return (V) getUninterruptibly(r2, Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    @ParametricNullness
    public static <V> V getUninterruptibly(Future<V> r3, long r4, TimeUnit r6) throws ExecutionException, TimeoutException {
        boolean r0 = false;
        long r5 = r6.toNanos(r4);     // Catch: Throwable -> L12
        long r1 = System.nanoTime() + r5;
    L18:
        V r7 = r3.get(r5, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r0 == false) goto L8;
        Thread.currentThread().interrupt();
    L8:
        return r7;
    L9:
        r0 = true;
        r5 = r1 - System.nanoTime();
    L12:
        th = move-exception;
        if (r0 == false) goto L15;
        Thread.currentThread().interrupt();
    L15:
        throw th;
    }

    public static <E> E takeUninterruptibly(BlockingQueue<E> r1) {
        boolean r0 = false;
    L12:
        E r2 = r1.take();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r0 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r2;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    public static <E> void putUninterruptibly(BlockingQueue<E> r1, E r2) {
        boolean r0 = false;
    L12:
        r1.put(r2);     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r0 == false) goto L15;
        Thread.currentThread().interrupt();
        return;
    L15:
        return;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    public static void sleepUninterruptibly(Duration r2) {
        sleepUninterruptibly(Internal.toNanosSaturated(r2), TimeUnit.NANOSECONDS);
    }

    public static void sleepUninterruptibly(long r3, TimeUnit r5) {
        boolean r0 = false;
        long r4 = r5.toNanos(r3);     // Catch: Throwable -> L12
        long r1 = System.nanoTime() + r4;
    L18:
        TimeUnit.NANOSECONDS.sleep(r4);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r0 == false) goto L21;
        Thread.currentThread().interrupt();
        return;
    L21:
        return;
    L9:
        r0 = true;
        r4 = r1 - System.nanoTime();
    L12:
        th = move-exception;
        if (r0 == false) goto L15;
        Thread.currentThread().interrupt();
    L15:
        throw th;
    }

    public static boolean tryAcquireUninterruptibly(Semaphore r2, Duration r3) {
        return tryAcquireUninterruptibly(r2, Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public static boolean tryAcquireUninterruptibly(Semaphore r1, long r2, TimeUnit r4) {
        return tryAcquireUninterruptibly(r1, 1, r2, r4);
    }

    public static boolean tryAcquireUninterruptibly(Semaphore r2, int r3, Duration r4) {
        return tryAcquireUninterruptibly(r2, r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    public static boolean tryAcquireUninterruptibly(Semaphore r3, int r4, long r5, TimeUnit r7) {
        boolean r0 = false;
        long r6 = r7.toNanos(r5);     // Catch: Throwable -> L12
        long r1 = System.nanoTime() + r6;
    L18:
        boolean r8 = r3.tryAcquire(r4, r6, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r0 == false) goto L8;
        Thread.currentThread().interrupt();
    L8:
        return r8;
    L9:
        r0 = true;
        r6 = r1 - System.nanoTime();
    L12:
        th = move-exception;
        if (r0 == false) goto L15;
        Thread.currentThread().interrupt();
    L15:
        throw th;
    }

    public static boolean tryLockUninterruptibly(Lock r2, Duration r3) {
        return tryLockUninterruptibly(r2, Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public static boolean tryLockUninterruptibly(Lock r3, long r4, TimeUnit r6) {
        boolean r0 = false;
        long r5 = r6.toNanos(r4);     // Catch: Throwable -> L12
        long r1 = System.nanoTime() + r5;
    L18:
        boolean r7 = r3.tryLock(r5, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r0 == false) goto L8;
        Thread.currentThread().interrupt();
    L8:
        return r7;
    L9:
        r0 = true;
        r5 = r1 - System.nanoTime();
    L12:
        th = move-exception;
        if (r0 == false) goto L15;
        Thread.currentThread().interrupt();
    L15:
        throw th;
    }

    public static void awaitTerminationUninterruptibly(ExecutorService r3) {
        Verify.verify(awaitTerminationUninterruptibly(r3, Long.MAX_VALUE, TimeUnit.NANOSECONDS));
    }

    public static boolean awaitTerminationUninterruptibly(ExecutorService r2, Duration r3) {
        return awaitTerminationUninterruptibly(r2, Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS);
    }

    public static boolean awaitTerminationUninterruptibly(ExecutorService r3, long r4, TimeUnit r6) {
        boolean r0 = false;
        long r5 = r6.toNanos(r4);     // Catch: Throwable -> L12
        long r1 = System.nanoTime() + r5;
    L18:
        boolean r7 = r3.awaitTermination(r5, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r0 == false) goto L8;
        Thread.currentThread().interrupt();
    L8:
        return r7;
    L9:
        r0 = true;
        r5 = r1 - System.nanoTime();
    L12:
        th = move-exception;
        if (r0 == false) goto L15;
        Thread.currentThread().interrupt();
    L15:
        throw th;
    }

    private Uninterruptibles() {
    }
}

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class RateLimiter {

    @CheckForNull
    private volatile Object mutexDoNotUseDirectly;
    private final SleepingStopwatch stopwatch;

    static abstract class SleepingStopwatch {
        protected abstract long readMicros();

        protected abstract void sleepMicrosUninterruptibly(long r1);

        protected SleepingStopwatch() {
        }

        public static SleepingStopwatch createFromSystemTimer() {
            return new AnonymousClass1();
        }
    }

    abstract double doGetRate();

    abstract void doSetRate(double r1, long r3);

    abstract long queryEarliestAvailable(long r1);

    abstract long reserveEarliestAvailable(int r1, long r2);

    public static RateLimiter create(double r1) {
        return create(r1, SleepingStopwatch.createFromSystemTimer());
    }

    static RateLimiter create(double r3, SleepingStopwatch r5) {
        SmoothRateLimiter.SmoothBursty r0 = new SmoothRateLimiter.SmoothBursty(r5, 1.0d);
        r0.setRate(r3);
        return r0;
    }

    public static RateLimiter create(double r2, Duration r4) {
        return create(r2, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    public static RateLimiter create(double r10, long r12, TimeUnit r14) {
        if (r12 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "warmupPeriod must not be negative: %s", r12);
        return create(r10, r12, r14, 3.0d, SleepingStopwatch.createFromSystemTimer());
    L5:
        r0 = false;
        goto L6
    }

    static RateLimiter create(double r8, long r10, TimeUnit r12, double r13, SleepingStopwatch r15) {
        SmoothRateLimiter.SmoothWarmingUp r7 = new SmoothRateLimiter.SmoothWarmingUp(r15, r10, r12, r13);
        r7.setRate(r8);
        return r7;
    }

    private Object mutex() {
        Object r0 = this.mutexDoNotUseDirectly;
        if (r0 != null) goto L13;
        monitor-enter(this);
        r0 = this.mutexDoNotUseDirectly;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = new Object();     // Catch: Throwable -> L10
        this.mutexDoNotUseDirectly = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }

    RateLimiter(SleepingStopwatch r1) {
        this.stopwatch = (SleepingStopwatch) Preconditions.checkNotNull(r1);
    }

    public final void setRate(double r4) {
        if (r4 > 0.0d) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "rate must be positive");
        Object r1 = mutex();
        monitor-enter(r1);
        doSetRate(r4, this.stopwatch.readMicros());     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L5:
        if (Double.isNaN(r4) == true) goto L7;
        r0 = true;
        goto L8
    }

    public final double getRate() {
        Object r0 = mutex();
        monitor-enter(r0);
        double r1 = doGetRate();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public double acquire() {
        return acquire(1);
    }

    public double acquire(int r5) {
        long r0 = reserve(r5);
        this.stopwatch.sleepMicrosUninterruptibly(r0);
        return (r0 * 1.0d) / TimeUnit.SECONDS.toMicros(1);
    }

    final long reserve(int r4) {
        checkPermits(r4);
        Object r0 = mutex();
        monitor-enter(r0);
        long r3 = reserveAndGetWaitLength(r4, this.stopwatch.readMicros());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean tryAcquire(Duration r4) {
        return tryAcquire(1, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    public boolean tryAcquire(long r2, TimeUnit r4) {
        return tryAcquire(1, r2, r4);
    }

    public boolean tryAcquire(int r4) {
        return tryAcquire(r4, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int r3, Duration r4) {
        return tryAcquire(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    public boolean tryAcquire(int r3, long r4, TimeUnit r6) {
        long r5 = Math.max(r6.toMicros(r4), 0);
        checkPermits(r3);
        Object r7 = mutex();
        monitor-enter(r7);
        long r0 = this.stopwatch.readMicros();     // Catch: Throwable -> L13
        if (canAcquire(r0, r5) == true) goto L9;
        monitor-exit(r7);     // Catch: Throwable -> L13
        return false;
    L9:
        long r8 = reserveAndGetWaitLength(r3, r0);     // Catch: Throwable -> L13
        monitor-exit(r7);     // Catch: Throwable -> L13
        this.stopwatch.sleepMicrosUninterruptibly(r8);
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    private boolean canAcquire(long r3, long r5) {
        if ((queryEarliestAvailable(r3) - r5) > r3) goto L5;
        return true;
    L5:
        return false;
    }

    final long reserveAndGetWaitLength(int r1, long r2) {
        return Math.max(reserveEarliestAvailable(r1, r2) - r2, 0);
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[]{Double.valueOf(getRate())});
    }

    private static void checkPermits(int r2) {
        if (r2 <= 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "Requested permits (%s) must be positive", r2);
        return;
    L4:
        r0 = false;
        goto L5
    }
}

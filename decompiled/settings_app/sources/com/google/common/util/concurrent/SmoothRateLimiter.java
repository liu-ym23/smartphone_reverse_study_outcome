package com.google.common.util.concurrent;

import com.google.common.math.LongMath;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class SmoothRateLimiter extends RateLimiter {
    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.SmoothRateLimiter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long storedPermitsToWaitTime(double r1, double r3) {
            return 0;
        }

        SmoothBursty(RateLimiter.SleepingStopwatch r2, double r3) {
            super(r2, null);
            this.maxBurstSeconds = r3;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void doSetRate(double r3, double r5) {
            double r6 = this.maxPermits;
            this.maxPermits = this.maxBurstSeconds * r3;
            if (r6 != Double.POSITIVE_INFINITY) goto L5;
            this.storedPermits = this.maxPermits;
            return;
        L5:
            double r4 = 0.0d;
            if (r6 == 0.0d) goto L9;
            r4 = (this.storedPermits * this.maxPermits) / r6;
        L9:
            this.storedPermits = r4;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }
    }

    static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        SmoothWarmingUp(RateLimiter.SleepingStopwatch r2, long r3, TimeUnit r5, double r6) {
            super(r2, null);
            this.warmupPeriodMicros = r5.toMicros(r3);
            this.coldFactor = r6;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void doSetRate(double r9, double r11) {
            double r10 = this.maxPermits;
            double r0 = this.coldFactor * r11;
            long r2 = this.warmupPeriodMicros;
            double r4 = (r2 * 0.5d) / r11;
            this.thresholdPermits = r4;
            this.maxPermits = r4 + ((r2 * 2.0d) / (r11 + r0));
            this.slope = (r0 - r11) / (this.maxPermits - this.thresholdPermits);
            if (r10 != Double.POSITIVE_INFINITY) goto L6;
            this.storedPermits = 0.0d;
            return;
        L6:
            if (r10 != 0.0d) goto L8;
            double r12 = this.maxPermits;
        L9:
            this.storedPermits = r12;
            return;
        L8:
            r12 = (this.storedPermits * this.maxPermits) / r10;
            goto L9
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long storedPermitsToWaitTime(double r5, double r7) {
            double r6 = r5 - this.thresholdPermits;
            if (r6 <= 0.0d) goto L5;
            double r0 = Math.min(r6, r7);
            long r8 = (long) (((permitsToTime(r6) + permitsToTime(r6 - r0)) * r0) / 2.0d);
            r7 = r7 - r0;
        L7:
            return r8 + ((long) (this.stableIntervalMicros * r7));
        L5:
            r8 = 0;
            goto L7
        }

        private double permitsToTime(double r5) {
            return this.stableIntervalMicros + (r5 * this.slope);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double coolDownIntervalMicros() {
            return this.warmupPeriodMicros / this.maxPermits;
        }
    }

    abstract double coolDownIntervalMicros();

    abstract void doSetRate(double r1, double r3);

    abstract long storedPermitsToWaitTime(double r1, double r3);

    /* synthetic */ SmoothRateLimiter(RateLimiter.SleepingStopwatch r1, AnonymousClass1 r2) {
        this(r1);
    }

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch r3) {
        super(r3);
        this.nextFreeTicketMicros = 0;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final void doSetRate(double r3, long r5) {
        resync(r5);
        double r6 = TimeUnit.SECONDS.toMicros(1) / r3;
        this.stableIntervalMicros = r6;
        doSetRate(r3, r6);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final double doGetRate() {
        return TimeUnit.SECONDS.toMicros(1) / this.stableIntervalMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long queryEarliestAvailable(long r1) {
        return this.nextFreeTicketMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long reserveEarliestAvailable(int r9, long r10) {
        resync(r10);
        long r11 = this.nextFreeTicketMicros;
        double r0 = r9;
        double r2 = Math.min(r0, this.storedPermits);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, storedPermitsToWaitTime(this.storedPermits, r2) + ((long) ((r0 - r2) * this.stableIntervalMicros)));
        this.storedPermits -= r2;
        return r11;
    }

    void resync(long r7) {
        long r0 = this.nextFreeTicketMicros;
        if (r7 <= r0) goto L6;
        this.storedPermits = Math.min(this.maxPermits, this.storedPermits + ((r7 - r0) / coolDownIntervalMicros()));
        this.nextFreeTicketMicros = r7;
        return;
    }
}

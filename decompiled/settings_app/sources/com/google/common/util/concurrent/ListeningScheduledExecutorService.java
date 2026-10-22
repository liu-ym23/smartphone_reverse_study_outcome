package com.google.common.util.concurrent;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public interface ListeningScheduledExecutorService extends ScheduledExecutorService, ListeningExecutorService {
    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture<?> schedule(Runnable r1, long r2, TimeUnit r4);

    @Override // java.util.concurrent.ScheduledExecutorService
    <V> ListenableScheduledFuture<V> schedule(Callable<V> r1, long r2, TimeUnit r4);

    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable r1, long r2, long r4, TimeUnit r6);

    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable r1, long r2, long r4, TimeUnit r6);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ default ScheduledFuture schedule(Runnable r1, long r2, TimeUnit r4) {
        return schedule(r1, r2, r4);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ default ScheduledFuture schedule(Callable r1, long r2, TimeUnit r4) {
        return schedule(r1, r2, r4);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ default ScheduledFuture scheduleAtFixedRate(Runnable r1, long r2, long r4, TimeUnit r6) {
        return scheduleAtFixedRate(r1, r2, r4, r6);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ default ScheduledFuture scheduleWithFixedDelay(Runnable r1, long r2, long r4, TimeUnit r6) {
        return scheduleWithFixedDelay(r1, r2, r4, r6);
    }

    default ListenableScheduledFuture<?> schedule(Runnable r3, Duration r4) {
        return schedule(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    default <V> ListenableScheduledFuture<V> schedule(Callable<V> r3, Duration r4) {
        return schedule(r3, Internal.toNanosSaturated(r4), TimeUnit.NANOSECONDS);
    }

    default ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable r8, Duration r9, Duration r10) {
        return scheduleAtFixedRate(r8, Internal.toNanosSaturated(r9), Internal.toNanosSaturated(r10), TimeUnit.NANOSECONDS);
    }

    default ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable r8, Duration r9, Duration r10) {
        return scheduleWithFixedDelay(r8, Internal.toNanosSaturated(r9), Internal.toNanosSaturated(r10), TimeUnit.NANOSECONDS);
    }
}

package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class WrappingScheduledExecutorService extends WrappingExecutorService implements ScheduledExecutorService {
    final ScheduledExecutorService delegate;

    protected WrappingScheduledExecutorService(ScheduledExecutorService r1) {
        super(r1);
        this.delegate = r1;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> schedule(Runnable r2, long r3, TimeUnit r5) {
        return this.delegate.schedule(wrapTask(r2), r3, r5);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final <V> ScheduledFuture<V> schedule(Callable<V> r2, long r3, TimeUnit r5) {
        return this.delegate.schedule(wrapTask(r2), r3, r5);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable r8, long r9, long r11, TimeUnit r13) {
        return this.delegate.scheduleAtFixedRate(wrapTask(r8), r9, r11, r13);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable r8, long r9, long r11, TimeUnit r13) {
        return this.delegate.scheduleWithFixedDelay(wrapTask(r8), r9, r11, r13);
    }
}

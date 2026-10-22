package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class ImmediateFuture<V> implements ListenableFuture<V> {
    static final ListenableFuture<?> NULL = null;
    private static final Logger log = null;

    @ParametricNullness
    private final V value;

    static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {
        ImmediateCancelledFuture() {
            cancel(false);
        }
    }

    static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
        ImmediateFailedFuture(Throwable r1) {
            setException(r1);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r1) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    static {
        NULL = new ImmediateFuture(null);
        log = Logger.getLogger(ImmediateFuture.class.getName());
    }

    ImmediateFuture(@ParametricNullness V r1) {
        this.value = r1;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r5, Executor r6) {
        Preconditions.checkNotNull(r5, "Runnable was null.");
        Preconditions.checkNotNull(r6, "Executor was null.");
        r6.execute(r5);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        Logger r0 = log;
        Level r1 = Level.SEVERE;
        String r7 = String.valueOf(r5);
        String r8 = String.valueOf(r6);
        r0.log(r1, new StringBuilder((String.valueOf(r7).length() + 57) + String.valueOf(r8).length()).append("RuntimeException while executing runnable ").append(r7).append(" with executor ").append(r8).toString(), e);
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get() {
        return this.value;
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get(long r1, TimeUnit r3) throws ExecutionException {
        Preconditions.checkNotNull(r3);
        return get();
    }

    public String toString() {
        String r0 = super.toString();
        String r3 = String.valueOf(this.value);
        return new StringBuilder((String.valueOf(r0).length() + 27) + String.valueOf(r3).length()).append(r0).append("[status=SUCCESS, result=[").append(r3).append("]]").toString();
    }
}

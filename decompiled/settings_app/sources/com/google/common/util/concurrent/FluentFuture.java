package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use FluentFuture.from(Futures.immediate*Future) or SettableFuture")
@ElementTypesAreNonnullByDefault
public abstract class FluentFuture<V> extends GwtFluentFutureCatchingSpecialization<V> {

    static abstract class TrustedFuture<V> extends FluentFuture<V> implements AbstractFuture.Trusted<V> {
        TrustedFuture() {
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @ParametricNullness
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @ParametricNullness
        public final V get(long r1, TimeUnit r3) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(r1, r3);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable r1, Executor r2) {
            super.addListener(r1, r2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean r1) {
            return super.cancel(r1);
        }
    }

    FluentFuture() {
    }

    public static <V> FluentFuture<V> from(ListenableFuture<V> r1) {
        if ((r1 instanceof FluentFuture) == false) goto L6;
        return (FluentFuture) r1;
    L6:
        return new ForwardingFluentFuture(r1);
    }

    @Deprecated
    public static <V> FluentFuture<V> from(FluentFuture<V> r0) {
        return (FluentFuture) Preconditions.checkNotNull(r0);
    }

    public final <X extends Throwable> FluentFuture<V> catching(Class<X> r1, Function<? super X, ? extends V> r2, Executor r3) {
        return (FluentFuture) Futures.catching(this, r1, r2, r3);
    }

    public final <X extends Throwable> FluentFuture<V> catchingAsync(Class<X> r1, AsyncFunction<? super X, ? extends V> r2, Executor r3) {
        return (FluentFuture) Futures.catchingAsync(this, r1, r2, r3);
    }

    public final FluentFuture<V> withTimeout(Duration r3, ScheduledExecutorService r4) {
        return withTimeout(Internal.toNanosSaturated(r3), TimeUnit.NANOSECONDS, r4);
    }

    public final FluentFuture<V> withTimeout(long r1, TimeUnit r3, ScheduledExecutorService r4) {
        return (FluentFuture) Futures.withTimeout(this, r1, r3, r4);
    }

    public final <T> FluentFuture<T> transformAsync(AsyncFunction<? super V, T> r1, Executor r2) {
        return (FluentFuture) Futures.transformAsync(this, r1, r2);
    }

    public final <T> FluentFuture<T> transform(Function<? super V, T> r1, Executor r2) {
        return (FluentFuture) Futures.transform(this, r1, r2);
    }

    public final void addCallback(FutureCallback<? super V> r1, Executor r2) {
        Futures.addCallback(this, r1, r2);
    }
}

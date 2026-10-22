package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class ParallelReduce<T, R> extends ParallelFlowable<R> {
    final Callable<R> initialSupplier;
    final BiFunction<R, ? super T, R> reducer;
    final ParallelFlowable<? extends T> source;

    public static final class ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        private static final long serialVersionUID = 8200530050639449080L;
        R accumulator;
        boolean done;
        final BiFunction<R, ? super T, R> reducer;

        public ParallelReduceSubscriber(Subscriber<? super R> r1, R r2, BiFunction<R, ? super T, R> r3) {
            super(r1);
            this.accumulator = r2;
            this.reducer = r3;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            R r0 = this.accumulator;
            this.accumulator = null;
            complete(r0);
            return;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.accumulator = null;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.done == true) goto L11;
            this.accumulator = (R) ObjectHelper.requireNonNull(this.reducer.apply(this.accumulator, r3), "The reducer returned a null value");
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
            return;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }
    }

    public ParallelReduce(ParallelFlowable<? extends T> r1, Callable<R> r2, BiFunction<R, ? super T, R> r3) {
        this.source = r1;
        this.initialSupplier = r2;
        this.reducer = r3;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    public void reportError(Subscriber<?>[] r3, Throwable r4) {
        int r2 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r2) goto L5;
        EmptySubscription.error(r4, r3[r0]);
        r0 = r0 + 1;
        goto L3
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] r8) {
        if (validate(r8) == true) goto L5;
        return;
    L5:
        int r0 = r8.length;
        Subscriber<? super Object>[] r1 = new Subscriber[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        Object r3 = ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initialSupplier returned a null value");     // Catch: Throwable -> L9
        r1[r2] = new ParallelReduceSubscriber(r8[r2], r3, this.reducer);
        r2 = r2 + 1;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        reportError(r8, th);
        return;
    L12:
        this.source.subscribe(r1);
    }
}

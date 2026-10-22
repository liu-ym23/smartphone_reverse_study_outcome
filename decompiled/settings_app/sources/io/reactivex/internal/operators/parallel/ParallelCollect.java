package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelCollect<T, C> extends ParallelFlowable<C> {
    final BiConsumer<? super C, ? super T> collector;
    final Callable<? extends C> initialCollection;
    final ParallelFlowable<? extends T> source;

    static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;
        C collection;
        final BiConsumer<? super C, ? super T> collector;
        boolean done;

        ParallelCollectSubscriber(Subscriber<? super C> r1, C r2, BiConsumer<? super C, ? super T> r3) {
            super(r1);
            this.collection = r2;
            this.collector = r3;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.done == false) goto L10;
            return;
        L10:
            this.collector.accept(this.collection, r3);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.collection = null;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            C r0 = this.collection;
            this.collection = null;
            complete(r0);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }

    public ParallelCollect(ParallelFlowable<? extends T> r1, Callable<? extends C> r2, BiConsumer<? super C, ? super T> r3) {
        this.source = r1;
        this.initialCollection = r2;
        this.collector = r3;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super C>[] r8) {
        if (validate(r8) == true) goto L5;
        return;
    L5:
        int r0 = r8.length;
        Subscriber<? super Object>[] r1 = new Subscriber[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        Object r3 = ObjectHelper.requireNonNull(this.initialCollection.call(), "The initialSupplier returned a null value");     // Catch: Throwable -> L9
        r1[r2] = new ParallelCollectSubscriber(r8[r2], r3, this.collector);
        r2 = r2 + 1;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        reportError(r8, th);
        return;
    L12:
        this.source.subscribe(r1);
    }

    void reportError(Subscriber<?>[] r3, Throwable r4) {
        int r2 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r2) goto L5;
        EmptySubscription.error(r4, r3[r0]);
        r0 = r0 + 1;
        goto L3
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }
}

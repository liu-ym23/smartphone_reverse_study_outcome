package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableReduce<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiFunction<T, T, T> reducer;

    static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        final BiFunction<T, T, T> reducer;
        Subscription upstream;

        ReduceSubscriber(Subscriber<? super T> r1, BiFunction<T, T, T> r2) {
            super(r1);
            this.reducer = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.upstream != SubscriptionHelper.CANCELLED) goto L5;
            return;
        L5:
            T r0 = this.value;
            if (r0 != null) goto L13;
            this.value = r3;
            return;
        L13:
            this.value = (T) ObjectHelper.requireNonNull(this.reducer.apply(r0, r3), "The reducer returned a null value");     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            if (this.upstream != SubscriptionHelper.CANCELLED) goto L6;
            RxJavaPlugins.onError(r3);
            return;
        L6:
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError(r3);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.upstream != SubscriptionHelper.CANCELLED) goto L5;
            return;
        L5:
            this.upstream = SubscriptionHelper.CANCELLED;
            T r0 = this.value;
            if (r0 == null) goto L8;
            complete(r0);
            return;
        L8:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }
    }

    public FlowableReduce(Flowable<T> r1, BiFunction<T, T, T> r2) {
        super(r1);
        this.reducer = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r3) {
        this.source.subscribe(new ReduceSubscriber(r3, this.reducer));
    }
}

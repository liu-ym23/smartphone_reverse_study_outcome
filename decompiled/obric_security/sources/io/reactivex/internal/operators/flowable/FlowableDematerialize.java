package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableDematerialize<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Notification<R>> selector;

    static final class DematerializeSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super R> downstream;
        final Function<? super T, ? extends Notification<R>> selector;
        Subscription upstream;

        DematerializeSubscriber(Subscriber<? super R> r1, Function<? super T, ? extends Notification<R>> r2) {
            this.downstream = r1;
            this.selector = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.done == true) goto L5;
            Notification r3 = (Notification) ObjectHelper.requireNonNull(this.selector.apply(r2), "The selector returned a null Notification");     // Catch: Throwable -> L19
            if (r3.isOnError() == false) goto L15;
            this.upstream.cancel();
            onError(r3.getError());
            return;
        L15:
            if (r3.isOnComplete() == false) goto L17;
            this.upstream.cancel();
            onComplete();
            return;
        L17:
            this.downstream.onNext((Object) r3.getValue());
            return;
        L19:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
            return;
        L5:
            if ((r2 instanceof Notification) == false) goto L24;
            Notification r4 = (Notification) r2;
            if (r4.isOnError() == false) goto L25;
            RxJavaPlugins.onError(r4.getError());
            return;
        L25:
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }
    }

    public FlowableDematerialize(Flowable<T> r1, Function<? super T, ? extends Notification<R>> r2) {
        super(r1);
        this.selector = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r3) {
        this.source.subscribe(new DematerializeSubscriber(r3, this.selector));
    }
}

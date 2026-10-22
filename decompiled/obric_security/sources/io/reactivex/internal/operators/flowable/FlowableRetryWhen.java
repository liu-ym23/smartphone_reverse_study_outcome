package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableRetryWhen<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Flowable<Throwable>, ? extends Publisher<?>> handler;

    static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        RetryWhenSubscriber(Subscriber<? super T> r1, FlowableProcessor<Throwable> r2, Subscription r3) {
            super(r1, r2, r3);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            again(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.receiver.cancel();
            this.downstream.onComplete();
        }
    }

    public FlowableRetryWhen(Flowable<T> r1, Function<? super Flowable<Throwable>, ? extends Publisher<?>> r2) {
        super(r1);
        this.handler = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r5) {
        SerializedSubscriber r0 = new SerializedSubscriber(r5);
        FlowableProcessor<T> r1 = UnicastProcessor.create(8).toSerialized();
        Publisher r2 = (Publisher) ObjectHelper.requireNonNull(this.handler.apply(r1), "handler returned a null Publisher");     // Catch: Throwable -> L6
        FlowableRepeatWhen.WhenReceiver r3 = new FlowableRepeatWhen.WhenReceiver(this.source);
        RetryWhenSubscriber r4 = new RetryWhenSubscriber(r0, r1, r3);
        r3.subscriber = r4;
        r5.onSubscribe(r4);
        r2.subscribe(r3);
        r3.onNext(0);
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r5);
    }
}

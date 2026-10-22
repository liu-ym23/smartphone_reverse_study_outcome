package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends T> other;

    static final class SwitchIfEmptySubscriber<T> implements FlowableSubscriber<T> {
        final SubscriptionArbiter arbiter;
        final Subscriber<? super T> downstream;
        boolean empty;
        final Publisher<? extends T> other;

        SwitchIfEmptySubscriber(Subscriber<? super T> r1, Publisher<? extends T> r2) {
            this.downstream = r1;
            this.other = r2;
            this.empty = true;
            this.arbiter = new SubscriptionArbiter(false);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r1) {
            this.arbiter.setSubscription(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.empty == false) goto L5;
            this.empty = false;
        L5:
            this.downstream.onNext(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.empty == false) goto L5;
            this.empty = false;
            this.other.subscribe(this);
            return;
        L5:
            this.downstream.onComplete();
        }
    }

    public FlowableSwitchIfEmpty(Flowable<T> r1, Publisher<? extends T> r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r3) {
        SwitchIfEmptySubscriber r0 = new SwitchIfEmptySubscriber(r3, this.other);
        r3.onSubscribe(r0.arbiter);
        this.source.subscribe(r0);
    }
}

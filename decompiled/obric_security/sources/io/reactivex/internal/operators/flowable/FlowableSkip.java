package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {
    final long n;

    static final class SkipSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> downstream;
        long remaining;
        Subscription upstream;

        SkipSubscriber(Subscriber<? super T> r1, long r2) {
            this.downstream = r1;
            this.remaining = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            long r0 = this.remaining;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(r0);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            long r0 = this.remaining;
            if (r0 == 0) goto L5;
            this.remaining = r0 - 1;
            return;
        L5:
            this.downstream.onNext(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
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

    public FlowableSkip(Flowable<T> r1, long r2) {
        super(r1);
        this.n = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r5) {
        this.source.subscribe(new SkipSubscriber(r5, this.n));
    }
}

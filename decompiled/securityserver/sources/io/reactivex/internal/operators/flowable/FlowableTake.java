package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {
    final long limit;

    public static final class TakeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5636543848937116287L;
        boolean done;
        final Subscriber<? super T> downstream;
        final long limit;
        long remaining;
        Subscription upstream;

        public TakeSubscriber(Subscriber<? super T> r1, long r2) {
            this.downstream = r1;
            this.limit = r2;
            this.remaining = r2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.downstream.onComplete();
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == true) goto L5;
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(r2);
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r7) {
            if (this.done == true) goto L14;
            long r0 = this.remaining;
            long r2 = r0 - 1;
            this.remaining = r2;
            if (r0 > 0) goto L7;
            return;
        L7:
            if (r2 != 0) goto L9;
            boolean r1 = true;
        L10:
            this.downstream.onNext(r7);
            if (r1 == false) goto L16;
            this.upstream.cancel();
            onComplete();
            return;
        L16:
            return;
        L9:
            r1 = false;
            goto L10
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r5) {
            if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L9;
            this.upstream = r5;
            if (this.limit != 0) goto L7;
            r5.cancel();
            this.done = true;
            EmptySubscription.complete(this.downstream);
            return;
        L7:
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r3) {
            if (SubscriptionHelper.validate(r3) == true) goto L6;
            return;
        L6:
            if (get() == false) goto L8;
        L13:
            this.upstream.request(r3);
            return;
        L8:
            if (compareAndSet(false, true) == false) goto L13;
            if (r3 < this.limit) goto L13;
            this.upstream.request(Long.MAX_VALUE);
        }
    }

    public FlowableTake(Flowable<T> r1, long r2) {
        super(r1);
        this.limit = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r5) {
        this.source.subscribe(new TakeSubscriber(r5, this.limit));
    }
}

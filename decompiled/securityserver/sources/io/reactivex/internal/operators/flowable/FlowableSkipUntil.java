package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableSkipUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<U> other;

    public static final class SkipUntilMainSubscriber<T> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6270983465606289181L;
        final Subscriber<? super T> downstream;
        final AtomicThrowable error;
        volatile boolean gate;
        final SkipUntilMainSubscriber<T>.OtherSubscriber other;
        final AtomicLong requested;
        final AtomicReference<Subscription> upstream;

        public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -5592042965931999169L;
            final /* synthetic */ SkipUntilMainSubscriber this$0;

            public OtherSubscriber(SkipUntilMainSubscriber r1) {
                this.this$0 = r1;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                this.this$0.gate = true;
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable r3) {
                SubscriptionHelper.cancel(this.this$0.upstream);
                SkipUntilMainSubscriber r2 = this.this$0;
                HalfSerializer.onError(r2.downstream, r3, r2, r2.error);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object r2) {
                this.this$0.gate = true;
                get().cancel();
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription r3) {
                SubscriptionHelper.setOnce(this, r3, Long.MAX_VALUE);
            }
        }

        public SkipUntilMainSubscriber(Subscriber<? super T> r1) {
            this.downstream = r1;
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
            this.other = new OtherSubscriber(this);
            this.error = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            SubscriptionHelper.cancel(this.other);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (tryOnNext(r3) == true) goto L6;
            this.upstream.get().request(1);
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r2);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r3) {
            if (this.gate == false) goto L6;
            HalfSerializer.onNext(this.downstream, r3, this, this.error);
            return true;
        L6:
            return false;
        }
    }

    public FlowableSkipUntil(Flowable<T> r1, Publisher<U> r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r3) {
        SkipUntilMainSubscriber r0 = new SkipUntilMainSubscriber(r3);
        r3.onSubscribe(r0);
        this.other.subscribe(r0.other);
        this.source.subscribe(r0);
    }
}

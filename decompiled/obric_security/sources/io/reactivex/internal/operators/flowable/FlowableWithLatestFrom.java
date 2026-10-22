package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableWithLatestFrom<T, U, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final Publisher<? extends U> other;

    final class FlowableWithLatestSubscriber implements FlowableSubscriber<U> {
        final /* synthetic */ FlowableWithLatestFrom this$0;
        private final WithLatestFromSubscriber<T, U, R> wlf;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        FlowableWithLatestSubscriber(FlowableWithLatestFrom r1, WithLatestFromSubscriber<T, U, R> r2) {
            this.this$0 = r1;
            this.wlf = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (this.wlf.setOther(r3) == false) goto L6;
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U r1) {
            this.wlf.lazySet(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.wlf.otherError(r1);
        }
    }

    static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -312246233408980075L;
        final BiFunction<? super T, ? super U, ? extends R> combiner;
        final Subscriber<? super R> downstream;
        final AtomicReference<Subscription> other;
        final AtomicLong requested;
        final AtomicReference<Subscription> upstream;

        WithLatestFromSubscriber(Subscriber<? super R> r2, BiFunction<? super T, ? super U, ? extends R> r3) {
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
            this.other = new AtomicReference();
            this.downstream = r2;
            this.combiner = r3;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (tryOnNext(r3) == true) goto L6;
            this.upstream.get().request(1);
            return;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T r4) {
            U r0 = get();
            if (r0 != null) goto L10;
        L9:
            return false;
        L10:
            Object r5 = ObjectHelper.requireNonNull(this.combiner.apply(r4, r0), "The combiner returned a null value");     // Catch: Throwable -> L7
            this.downstream.onNext(r5);
            return true;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            this.downstream.onError(th);
            goto L9
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        public boolean setOther(Subscription r1) {
            return SubscriptionHelper.setOnce(this.other, r1);
        }

        public void otherError(Throwable r2) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(r2);
        }
    }

    public FlowableWithLatestFrom(Flowable<T> r1, BiFunction<? super T, ? super U, ? extends R> r2, Publisher<? extends U> r3) {
        super(r1);
        this.combiner = r2;
        this.other = r3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r3) {
        SerializedSubscriber r0 = new SerializedSubscriber(r3);
        WithLatestFromSubscriber r4 = new WithLatestFromSubscriber(r0, this.combiner);
        r0.onSubscribe(r4);
        this.other.subscribe(new FlowableWithLatestSubscriber(this, r4));
        this.source.subscribe(r4);
    }
}

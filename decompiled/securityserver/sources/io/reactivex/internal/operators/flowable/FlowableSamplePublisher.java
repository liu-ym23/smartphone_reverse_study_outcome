package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableSamplePublisher<T> extends Flowable<T> {
    final boolean emitLast;
    final Publisher<?> other;
    final Publisher<T> source;

    public static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        public SampleMainEmitLast(Subscriber<? super T> r1, Publisher<?> r2) {
            super(r1, r2);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void completion() {
            this.done = true;
            if (this.wip.getAndIncrement() != 0) goto L6;
            emit();
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void run() {
            if (this.wip.getAndIncrement() != 0) goto L10;
        L4:
            boolean r0 = this.done;
            emit();
            if (r0 == true) goto L6;
            if (this.wip.decrementAndGet() != 0) goto L4;
            return;
        L6:
            this.downstream.onComplete();
            return;
        }
    }

    public static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(Subscriber<? super T> r1, Publisher<?> r2) {
            super(r1, r2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void completion() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        public void run() {
            emit();
        }
    }

    public static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3517602651313910099L;
        final Subscriber<? super T> downstream;
        final AtomicReference<Subscription> other;
        final AtomicLong requested;
        final Publisher<?> sampler;
        Subscription upstream;

        public SamplePublisherSubscriber(Subscriber<? super T> r2, Publisher<?> r3) {
            this.requested = new AtomicLong();
            this.other = new AtomicReference();
            this.downstream = r2;
            this.sampler = r3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            this.upstream.cancel();
        }

        public void complete() {
            this.upstream.cancel();
            completion();
        }

        public abstract void completion();

        public void emit() {
            T r0 = getAndSet(null);
            if (r0 != null) goto L5;
            return;
        L5:
            if (this.requested.get() == 0) goto L7;
            this.downstream.onNext(r0);
            BackpressureHelper.produced(this.requested, 1);
            return;
        L7:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }

        public void error(Throwable r2) {
            this.upstream.cancel();
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            completion();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            lazySet(r1);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L8;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            if (this.other.get() != null) goto L9;
            this.sampler.subscribe(new SamplerSubscriber(this));
            r3.request(Long.MAX_VALUE);
            return;
        L9:
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            return;
        }

        public abstract void run();

        public void setOther(Subscription r3) {
            SubscriptionHelper.setOnce(this.other, r3, Long.MAX_VALUE);
        }
    }

    public static final class SamplerSubscriber<T> implements FlowableSubscriber<Object> {
        final SamplePublisherSubscriber<T> parent;

        public SamplerSubscriber(SamplePublisherSubscriber<T> r1) {
            this.parent = r1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.complete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.parent.error(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r1) {
            this.parent.run();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r1) {
            this.parent.setOther(r1);
        }
    }

    public FlowableSamplePublisher(Publisher<T> r1, Publisher<?> r2, boolean r3) {
        this.source = r1;
        this.other = r2;
        this.emitLast = r3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r3) {
        SerializedSubscriber r0 = new SerializedSubscriber(r3);
        if (this.emitLast == false) goto L5;
        this.source.subscribe(new SampleMainEmitLast(r0, this.other));
        return;
    L5:
        this.source.subscribe(new SampleMainNoLast(r0, this.other));
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 163080509307634843L;
        volatile boolean cancelled;
        final AtomicReference<T> current;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        Throwable error;
        final AtomicLong requested;
        Subscription upstream;

        BackpressureLatestSubscriber(Subscriber<? super T> r2) {
            this.requested = new AtomicLong();
            this.current = new AtomicReference();
            this.downstream = r2;
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
        public void onNext(T r2) {
            this.current.lazySet(r2);
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.current.lazySet(null);
            return;
        L9:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super T> r0 = this.downstream;
            AtomicLong r1 = this.requested;
            AtomicReference<T> r2 = this.current;
            int r4 = 1;
        L6:
            long r7 = 0;
        L7:
            boolean r10 = false;
            if (r7 == r1.get()) goto L20;
            boolean r9 = this.done;
            T r11 = r2.getAndSet(null);
            if (r11 != null) goto L12;
            boolean r12 = true;
        L14:
            if (checkTerminated(r9, r12, r0, r2) == true) goto L15;
            if (r12 == true) goto L20;
            r0.onNext(r11);
            r7 = r7 + 1;
            goto L7
        L15:
            return;
        L12:
            r12 = false;
        L20:
            if (r7 != r1.get()) goto L28;
            boolean r13 = this.done;
            if (r2.get() != null) goto L25;
            r10 = true;
        L25:
            if (checkTerminated(r13, r10, r0, r2) == false) goto L28;
            return;
        L28:
            if (r7 == 0) goto L30;
            BackpressureHelper.produced(r1, r7);
        L30:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L6;
        }

        boolean checkTerminated(boolean r4, boolean r5, Subscriber<?> r6, AtomicReference<T> r7) {
            if (this.cancelled == false) goto L6;
            r7.lazySet(null);
            return true;
        L6:
            if (r4 == false) goto L14;
            Throwable r3 = this.error;
            if (r3 == null) goto L11;
            r7.lazySet(null);
            r6.onError(r3);
            return true;
        L11:
            if (r5 == false) goto L16;
            r6.onComplete();
            return true;
        L16:
            return false;
        L14:
            return false;
        }
    }

    public FlowableOnBackpressureLatest(Flowable<T> r1) {
        super(r1);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r2) {
        this.source.subscribe(new BackpressureLatestSubscriber(r2));
    }
}

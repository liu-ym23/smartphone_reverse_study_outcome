package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableThrottleLatest<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean emitLast;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        final boolean emitLast;
        long emitted;
        Throwable error;
        final AtomicReference<T> latest;
        final AtomicLong requested;
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        Subscription upstream;
        final Scheduler.Worker worker;

        ThrottleLatestSubscriber(Subscriber<? super T> r1, long r2, TimeUnit r4, Scheduler.Worker r5, boolean r6) {
            this.downstream = r1;
            this.timeout = r2;
            this.unit = r4;
            this.worker = r5;
            this.emitLast = r6;
            this.latest = new AtomicReference();
            this.requested = new AtomicLong();
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
            this.latest.set(r2);
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
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.latest.lazySet(null);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            AtomicReference<T> r0 = this.latest;
            AtomicLong r1 = this.requested;
            Subscriber<? super T> r2 = this.downstream;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            boolean r5 = this.done;
            if (r5 == false) goto L17;
            if (this.error == null) goto L17;
            r0.lazySet(null);
            r2.onError(this.error);
            this.worker.dispose();
            return;
        L17:
            if (r0.get() != null) goto L19;
            boolean r7 = true;
        L21:
            if (r5 == true) goto L22;
            if (r7 == true) goto L34;
            if (this.timerRunning == false) goto L44;
            if (this.timerFired == true) goto L44;
        L41:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L44:
            T r6 = r0.getAndSet(null);
            long r8 = this.emitted;
            if (r8 == r1.get()) goto L47;
            r2.onNext(r6);
            this.emitted = r8 + 1;
            this.timerFired = false;
            this.timerRunning = true;
            this.worker.schedule(this, this.timeout, this.unit);
            goto L7
        L47:
            this.upstream.cancel();
            r2.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            this.worker.dispose();
            return;
        L34:
            if (this.timerFired == false) goto L41;
            this.timerRunning = false;
            this.timerFired = false;
            goto L41
        L22:
            if (r7 == false) goto L24;
        L29:
            r0.lazySet(null);
            r2.onComplete();
        L30:
            this.worker.dispose();
            return;
        L24:
            if (this.emitLast == false) goto L29;
            T r3 = r0.getAndSet(null);
            long r9 = this.emitted;
            if (r9 == r1.get()) goto L28;
            this.emitted = r9 + 1;
            r2.onNext(r3);
            r2.onComplete();
            goto L30
        L28:
            r2.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
            goto L30
        L19:
            r7 = false;
            goto L21
        L8:
            r0.lazySet(null);
        }
    }

    public FlowableThrottleLatest(Flowable<T> r1, long r2, TimeUnit r4, Scheduler r5, boolean r6) {
        super(r1);
        this.timeout = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.emitLast = r6;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r10) {
        this.source.subscribe(new ThrottleLatestSubscriber(r10, this.timeout, this.unit, this.scheduler.createWorker(), this.emitLast));
    }
}

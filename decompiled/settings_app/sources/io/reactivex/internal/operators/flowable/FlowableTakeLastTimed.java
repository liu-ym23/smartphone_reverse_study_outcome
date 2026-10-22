package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableTakeLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final long count;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        Subscription upstream;

        TakeLastTimedSubscriber(Subscriber<? super T> r2, long r3, long r5, TimeUnit r7, Scheduler r8, int r9, boolean r10) {
            this.requested = new AtomicLong();
            this.downstream = r2;
            this.count = r3;
            this.time = r5;
            this.unit = r7;
            this.scheduler = r8;
            this.queue = new SpscLinkedArrayQueue(r9);
            this.delayError = r10;
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
        public void onNext(T r5) {
            SpscLinkedArrayQueue<Object> r0 = this.queue;
            long r1 = this.scheduler.now(this.unit);
            r0.offer(Long.valueOf(r1), r5);
            trim(r1, r0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r4) {
            if (this.delayError == false) goto L5;
            trim(this.scheduler.now(this.unit), this.queue);
        L5:
            this.error = r4;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            trim(this.scheduler.now(this.unit), this.queue);
            this.done = true;
            drain();
        }

        void trim(long r10, SpscLinkedArrayQueue<Object> r12) {
            long r0 = this.time;
            long r2 = this.count;
            if (r2 != Long.MAX_VALUE) goto L5;
            boolean r9 = true;
        L7:
            if (r12.isEmpty() == true) goto L14;
            if (((Long) r12.peek()).longValue() < (r10 - r0)) goto L13;
            if (r9 == true) goto L21;
            if ((r12.size() >> 1) > r2) goto L13;
            return;
        L21:
            return;
        L13:
            r12.poll();
            r12.poll();
            goto L7
        L14:
            return;
        L5:
            r9 = false;
            goto L7
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
            this.queue.clear();
            return;
        L9:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super T> r0 = this.downstream;
            SpscLinkedArrayQueue<Object> r1 = this.queue;
            boolean r2 = this.delayError;
            int r4 = 1;
        L7:
            if (this.done == true) goto L9;
        L25:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L9:
            if (checkTerminated(r1.isEmpty(), r0, r2) == true) goto L10;
            long r5 = this.requested.get();
            long r9 = 0;
        L13:
            if (r1.peek() != null) goto L15;
            boolean r11 = true;
        L17:
            if (checkTerminated(r11, r0, r2) == true) goto L18;
            if (r5 == r9) goto L22;
            r1.poll();
            r0.onNext(r1.poll());
            r9 = r9 + 1;
            goto L13
        L22:
            if (r9 == 0) goto L25;
            BackpressureHelper.produced(this.requested, r9);
            goto L25
        L18:
            return;
        L15:
            r11 = false;
            goto L17
        }

        boolean checkTerminated(boolean r3, Subscriber<? super T> r4, boolean r5) {
            if (this.cancelled == false) goto L6;
            this.queue.clear();
            return true;
        L6:
            if (r5 == false) goto L13;
            if (r3 == false) goto L20;
            Throwable r2 = this.error;
            if (r2 == null) goto L11;
            r4.onError(r2);
        L12:
            return true;
        L11:
            r4.onComplete();
            goto L12
        L20:
            return false;
        L13:
            Throwable r6 = this.error;
            if (r6 == null) goto L17;
            this.queue.clear();
            r4.onError(r6);
            return true;
        L17:
            if (r3 == false) goto L22;
            r4.onComplete();
            return true;
        L22:
            return false;
        }
    }

    public FlowableTakeLastTimed(Flowable<T> r1, long r2, long r4, TimeUnit r6, Scheduler r7, int r8, boolean r9) {
        super(r1);
        this.count = r2;
        this.time = r4;
        this.unit = r6;
        this.scheduler = r7;
        this.bufferSize = r8;
        this.delayError = r9;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r13) {
        this.source.subscribe(new TakeLastTimedSubscriber(r13, this.count, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}

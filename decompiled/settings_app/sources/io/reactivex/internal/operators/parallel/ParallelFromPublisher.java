package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {
    final int parallelism;
    final int prefetch;
    final Publisher<? extends T> source;

    static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        SimpleQueue<T> queue;
        final AtomicLongArray requests;
        int sourceMode;
        final AtomicInteger subscriberCount;
        final Subscriber<? super T>[] subscribers;
        Subscription upstream;

        final class RailSubscription implements Subscription {
            final int j;
            final int m;
            final /* synthetic */ ParallelDispatcher this$0;

            RailSubscription(ParallelDispatcher r1, int r2, int r3) {
                this.this$0 = r1;
                this.j = r2;
                this.m = r3;
            }

            @Override // org.reactivestreams.Subscription
            public void request(long r8) {
                if (SubscriptionHelper.validate(r8) == false) goto L17;
                AtomicLongArray r0 = this.this$0.requests;
            L5:
                long r3 = r0.get(this.j);
                if (r3 == Long.MAX_VALUE) goto L7;
                long r5 = BackpressureHelper.addCap(r3, r8);
                if (r0.compareAndSet(this.j, r3, r5) == false) goto L5;
                if (this.this$0.subscriberCount.get() != this.m) goto L18;
                this.this$0.drain();
                return;
            L18:
                return;
            L7:
                return;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                AtomicLongArray r1 = this.this$0.requests;
                int r0 = this.m;
                if (r1.compareAndSet(this.j + r0, 0, 1) == false) goto L6;
                ParallelDispatcher r2 = this.this$0;
                int r7 = this.m;
                r2.cancel(r7 + r7);
                return;
            }
        }

        ParallelDispatcher(Subscriber<? super T>[] r4, int r5) {
            this.subscriberCount = new AtomicInteger();
            this.subscribers = r4;
            this.prefetch = r5;
            this.limit = r5 - (r5 >> 2);
            int r6 = r4.length;
            int r0 = r6 + r6;
            AtomicLongArray r7 = new AtomicLongArray(r0 + 1);
            this.requests = r7;
            r7.lazySet(r0, r6);
            this.emissions = new long[r6];
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L16;
            this.upstream = r4;
            if ((r4 instanceof QueueSubscription) == false) goto L14;
            QueueSubscription r0 = (QueueSubscription) r4;
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = r1;
            this.queue = r0;
            this.done = true;
            setupSubscribers();
            drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            setupSubscribers();
            r4.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            setupSubscribers();
            r4.request(this.prefetch);
            return;
        }

        void setupSubscribers() {
            Subscriber<? super T>[] r0 = this.subscribers;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            if (this.cancelled == true) goto L6;
            int r4 = r2 + 1;
            this.subscriberCount.lazySet(r4);
            r0[r2].onSubscribe(new RailSubscription(this, r2, r1));
            r2 = r4;
            goto L3
        L6:
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.sourceMode == 0) goto L5;
        L8:
            drain();
            return;
        L5:
            if (this.queue.offer(r2) == true) goto L8;
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue is full?"));
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

        void cancel(int r5) {
            if (this.requests.decrementAndGet(r5) != 0) goto L8;
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        void drainAsync() {
            SimpleQueue<T> r0 = this.queue;
            Subscriber<? super T>[] r2 = this.subscribers;
            AtomicLongArray r3 = this.requests;
            long[] r4 = this.emissions;
            int r5 = r4.length;
            int r6 = this.index;
            int r7 = this.produced;
            int r9 = 1;
        L3:
            int r10 = 0;
            int r11 = 0;
        L5:
            if (this.cancelled == true) goto L6;
            boolean r12 = this.done;
            if (r12 == false) goto L16;
            Throwable r13 = this.error;
            if (r13 == null) goto L16;
            r0.clear();
            int r1 = r2.length;
        L13:
            if (r10 >= r1) goto L15;
            r2[r10].onError(r13);
            r10 = r10 + 1;
            goto L13
        L15:
            return;
        L16:
            boolean r14 = r0.isEmpty();
            if (r12 == false) goto L23;
            if (r14 == false) goto L23;
            int r8 = r2.length;
        L20:
            if (r10 >= r8) goto L22;
            r2[r10].onComplete();
            r10 = r10 + 1;
            goto L20
        L22:
            return;
        L23:
            if (r14 == true) goto L46;
            long r15 = r3.get(r6);
            long r16 = r4[r6];
            if (r15 != r16) goto L28;
        L41:
            r11 = r11 + 1;
        L42:
            r6 = r6 + 1;
            if (r6 != r5) goto L45;
            r6 = 0;
        L45:
            if (r11 != r5) goto L5;
        L28:
            if (r3.get(r5 + r6) != 0) goto L41;
            T r17 = r0.poll();     // Catch: Throwable -> L36
            if (r17 == null) goto L46;
            r2[r6].onNext(r17);
            r4[r6] = r16 + 1;
            r7 = r7 + 1;
            if (r7 != this.limit) goto L35;
            this.upstream.request(r7);
            r7 = 0;
        L35:
            r11 = 0;
        L36:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            int r18 = r2.length;
        L38:
            if (r10 >= r18) goto L40;
            r2[r10].onError(th);
            r10 = r10 + 1;
            goto L38
        L40:
            return;
        L46:
            int r19 = get();
            if (r19 == r9) goto L48;
            r9 = r19;
            goto L3
        L48:
            this.index = r6;
            this.produced = r7;
            r9 = addAndGet(-r9);
            if (r9 != 0) goto L3;
            return;
        L6:
            r0.clear();
        }

        void drainSync() {
            SimpleQueue<T> r0 = this.queue;
            Subscriber<? super T>[] r2 = this.subscribers;
            AtomicLongArray r3 = this.requests;
            long[] r4 = this.emissions;
            int r5 = r4.length;
            int r6 = this.index;
            int r8 = 1;
        L3:
            int r9 = 0;
            int r10 = 0;
        L5:
            if (this.cancelled == true) goto L6;
            if (r0.isEmpty() == true) goto L10;
            long r11 = r3.get(r6);
            long r13 = r4[r6];
            if (r11 != r13) goto L17;
        L30:
            r10 = r10 + 1;
        L31:
            r6 = r6 + 1;
            if (r6 != r5) goto L34;
            r6 = 0;
        L34:
            if (r10 != r5) goto L5;
            int r12 = get();
            if (r12 == r8) goto L37;
            r8 = r12;
            goto L3
        L37:
            this.index = r6;
            r8 = addAndGet(-r8);
            if (r8 != 0) goto L3;
            return;
        L17:
            if (r3.get(r5 + r6) != 0) goto L30;
            T r14 = r0.poll();     // Catch: Throwable -> L25
            if (r14 == null) goto L20;
            r2[r6].onNext(r14);
            r4[r6] = r13 + 1;
            r10 = 0;
            goto L31
        L20:
            int r1 = r2.length;
        L21:
            if (r9 >= r1) goto L23;
            r2[r9].onComplete();
            r9 = r9 + 1;
            goto L21
        L23:
            return;
        L25:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            int r7 = r2.length;
        L27:
            if (r9 >= r7) goto L29;
            r2[r9].onError(th);
            r9 = r9 + 1;
            goto L27
        L29:
            return;
        L10:
            int r15 = r2.length;
        L11:
            if (r9 >= r15) goto L13;
            r2[r9].onComplete();
            r9 = r9 + 1;
            goto L11
        L13:
            return;
        L6:
            r0.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.sourceMode != 1) goto L8;
            drainSync();
            return;
        L8:
            drainAsync();
        }
    }

    public ParallelFromPublisher(Publisher<? extends T> r1, int r2, int r3) {
        this.source = r1;
        this.parallelism = r2;
        this.prefetch = r3;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.parallelism;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] r3) {
        if (validate(r3) == true) goto L5;
        return;
    L5:
        this.source.subscribe(new ParallelDispatcher(r3, this.prefetch));
    }
}

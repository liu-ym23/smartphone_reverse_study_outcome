package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Action onOverflow;
    final boolean unbounded;

    public static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final Subscriber<? super T> downstream;
        Throwable error;
        final Action onOverflow;
        boolean outputFused;
        final SimplePlainQueue<T> queue;
        final AtomicLong requested;
        Subscription upstream;

        public BackpressureBufferSubscriber(Subscriber<? super T> r2, int r3, boolean r4, boolean r5, Action r6) {
            this.requested = new AtomicLong();
            this.downstream = r2;
            this.onOverflow = r6;
            this.delayError = r5;
            if (r4 == false) goto L5;
            SimplePlainQueue<T> r7 = new SpscLinkedArrayQueue(r3);
        L6:
            this.queue = r7;
            return;
        L5:
            r7 = new SpscArrayQueue(r3);
            goto L6
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

        public boolean checkTerminated(boolean r3, boolean r4, Subscriber<? super T> r5) {
            if (this.cancelled == false) goto L6;
            this.queue.clear();
            return true;
        L6:
            if (r3 == true) goto L8;
            return false;
        L8:
            if (this.delayError == false) goto L15;
            if (r4 == false) goto L24;
            Throwable r2 = this.error;
            if (r2 == null) goto L13;
            r5.onError(r2);
        L14:
            return true;
        L13:
            r5.onComplete();
            goto L14
        L24:
            return false;
        L15:
            Throwable r6 = this.error;
            if (r6 == null) goto L19;
            this.queue.clear();
            r5.onError(r6);
            return true;
        L19:
            if (r4 == false) goto L25;
            r5.onComplete();
            return true;
        L25:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        public void drain() {
            if (getAndIncrement() != 0) goto L32;
            SimplePlainQueue<T> r0 = this.queue;
            Subscriber<? super T> r1 = this.downstream;
            int r3 = 1;
        L6:
            if (checkTerminated(this.done, r0.isEmpty(), r1) == true) goto L7;
            long r4 = this.requested.get();
            long r8 = 0;
        L10:
            if (r8 == r4) goto L21;
            boolean r11 = this.done;
            T r12 = r0.poll();
            if (r12 != null) goto L14;
            boolean r13 = true;
        L16:
            if (checkTerminated(r11, r13, r1) == true) goto L17;
            if (r13 == true) goto L21;
            r1.onNext(r12);
            r8 = r8 + 1;
            goto L10
        L17:
            return;
        L14:
            r13 = false;
        L21:
            if (r8 != r4) goto L26;
            if (checkTerminated(this.done, r0.isEmpty(), r1) == false) goto L26;
            return;
        L26:
            if (r8 != 0) goto L28;
        L30:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L6;
            return;
        L28:
            if (r4 == Long.MAX_VALUE) goto L30;
            this.requested.addAndGet(-r8);
            goto L30
        L7:
            return;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (this.outputFused == false) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.error = r2;
            this.done = true;
            if (this.outputFused == false) goto L5;
            this.downstream.onError(r2);
            return;
        L5:
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.queue.offer(r2) == true) goto L12;
            this.upstream.cancel();
            MissingBackpressureException r3 = new MissingBackpressureException("Buffer is full");
            this.onOverflow.run();     // Catch: Throwable -> L7
        L9:
            onError(r3);
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r3.initCause(th);
            goto L9
        L12:
            if (this.outputFused == false) goto L14;
            this.downstream.onNext(null);
            return;
        L14:
            drain();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            return this.queue.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (this.outputFused == false) goto L5;
            return;
        L5:
            if (SubscriptionHelper.validate(r2) == false) goto L9;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }
    }

    public FlowableOnBackpressureBuffer(Flowable<T> r1, int r2, boolean r3, boolean r4, Action r5) {
        super(r1);
        this.bufferSize = r2;
        this.unbounded = r3;
        this.delayError = r4;
        this.onOverflow = r5;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r9) {
        this.source.subscribe(new BackpressureBufferSubscriber(r9, this.bufferSize, this.unbounded, this.delayError, this.onOverflow));
    }
}

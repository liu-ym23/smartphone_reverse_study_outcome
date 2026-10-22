package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class ParallelJoin<T> extends Flowable<T> {
    final boolean delayErrors;
    final int prefetch;
    final ParallelFlowable<? extends T> source;

    public static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile SimplePlainQueue<T> queue;

        public JoinInnerSubscriber(JoinSubscriptionBase<T> r1, int r2) {
            this.parent = r1;
            this.prefetch = r2;
            this.limit = r2 - (r2 >> 2);
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        public SimplePlainQueue<T> getQueue() {
            SimplePlainQueue<T> r0 = this.queue;
            if (r0 != null) goto L6;
            SpscArrayQueue r1 = new SpscArrayQueue(this.prefetch);
            this.queue = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.parent.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            this.parent.onNext(this, r2);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this, r3, this.prefetch);
        }

        public void request(long r3) {
            long r0 = this.produced + r3;
            if (r0 < this.limit) goto L5;
            this.produced = 0;
            get().request(r0);
            return;
        L5:
            this.produced = r0;
        }

        public void requestOne() {
            long r0 = this.produced + 1;
            if (r0 != this.limit) goto L5;
            this.produced = 0;
            get().request(r0);
            return;
        L5:
            this.produced = r0;
        }
    }

    public static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        public JoinSubscription(Subscriber<? super T> r1, int r2, int r3) {
            super(r1, r2, r3);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            drainLoop();
        }

        public void drainLoop() {
            JoinInnerSubscriber<T>[] r1 = this.subscribers;
            int r2 = r1.length;
            Subscriber<? super T> r3 = this.downstream;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
            long r10 = 0;
        L5:
            if (r10 == r6) goto L36;
            if (this.cancelled == true) goto L8;
            Throwable r12 = this.errors.get();
            if (r12 != null) goto L12;
            if (this.done.get() != 0) goto L17;
            boolean r13 = true;
        L18:
            int r14 = 0;
            boolean r15 = true;
        L20:
            if (r14 >= r1.length) goto L30;
            JoinInnerSubscriber<T> r4 = r1[r14];
            SimplePlainQueue<T> r16 = r4.queue;
            if (r16 == null) goto L29;
            T r17 = r16.poll();
            if (r17 == null) goto L29;
            r3.onNext(r17);
            r4.requestOne();
            r10 = r10 + 1;
            if (r10 == r6) goto L36;
            r15 = false;
        L29:
            r14 = r14 + 1;
            goto L20
        L30:
            if (r13 == false) goto L34;
            if (r15 == false) goto L34;
            r3.onComplete();
            return;
        L34:
            if (r15 == false) goto L5;
        L17:
            r13 = false;
            goto L18
        L12:
            cleanup();
            r3.onError(r12);
            return;
        L8:
            cleanup();
            return;
        L36:
            if (r10 != r6) goto L63;
            if (this.cancelled == true) goto L39;
            Throwable r7 = this.errors.get();
            if (r7 != null) goto L43;
            if (this.done.get() != 0) goto L48;
            boolean r8 = true;
        L49:
            int r18 = 0;
        L50:
            if (r18 >= r2) goto L57;
            SimplePlainQueue<T> r19 = r1[r18].queue;
            if (r19 == null) goto L56;
            if (r19.isEmpty() == true) goto L56;
            boolean r110 = false;
        L58:
            if (r8 == false) goto L63;
            if (r110 == false) goto L63;
            r3.onComplete();
            return;
        L56:
            r18 = r18 + 1;
            goto L50
        L57:
            r110 = true;
            goto L58
        L48:
            r8 = false;
            goto L49
        L43:
            cleanup();
            r3.onError(r7);
            return;
        L39:
            cleanup();
            return;
        L63:
            if (r10 != 0) goto L65;
        L67:
            int r9 = get();
            if (r9 != r5) goto L72;
            r9 = addAndGet(-r5);
            if (r9 != 0) goto L72;
            return;
        L72:
            r5 = r9;
            goto L3
        L65:
            if (r6 == Long.MAX_VALUE) goto L67;
            this.requested.addAndGet(-r10);
            goto L67
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable r3) {
            if (this.errors.compareAndSet(null, r3) == false) goto L6;
            cancelAll();
            drain();
            return;
        L6:
            if (r3 == this.errors.get()) goto L10;
            RxJavaPlugins.onError(r3);
            return;
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> r7, T r8) {
            if (get() != 0) goto L23;
            if (compareAndSet(0, 1) == false) goto L23;
            if (this.requested.get() == 0) goto L13;
            this.downstream.onNext(r8);
            if (this.requested.get() == Long.MAX_VALUE) goto L11;
            this.requested.decrementAndGet();
        L11:
            r7.request(1);
        L20:
            if (decrementAndGet() != 0) goto L29;
            return;
        L29:
            drainLoop();
            return;
        L13:
            if (r7.getQueue().offer(r8) == true) goto L20;
            cancelAll();
            MissingBackpressureException r9 = new MissingBackpressureException("Queue full?!");
            if (this.errors.compareAndSet(null, r9) == false) goto L17;
            this.downstream.onError(r9);
            return;
        L17:
            RxJavaPlugins.onError(r9);
            return;
        L23:
            if (r7.getQueue().offer(r8) == true) goto L27;
            cancelAll();
            onError(new MissingBackpressureException("Queue full?!"));
            return;
        L27:
            if (getAndIncrement() == 0) goto L29;
        }
    }

    public static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        volatile boolean cancelled;
        final AtomicInteger done;
        final Subscriber<? super T> downstream;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final JoinInnerSubscriber<T>[] subscribers;

        public JoinSubscriptionBase(Subscriber<? super T> r3, int r4, int r5) {
            this.errors = new AtomicThrowable();
            this.requested = new AtomicLong();
            this.done = new AtomicInteger();
            this.downstream = r3;
            JoinInnerSubscriber<T>[] r6 = new JoinInnerSubscriber[r4];
            int r0 = 0;
        L3:
            if (r0 >= r4) goto L5;
            r6[r0] = new JoinInnerSubscriber(this, r5);
            r0 = r0 + 1;
            goto L3
        L5:
            this.subscribers = r6;
            this.done.lazySet(r4);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() != 0) goto L9;
            cleanup();
            return;
        L9:
            return;
        }

        public void cancelAll() {
            JoinInnerSubscriber<T>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L3
        }

        public void cleanup() {
            JoinInnerSubscriber<T>[] r4 = this.subscribers;
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r4[r1].queue = null;
            r1 = r1 + 1;
            goto L3
        }

        public abstract void drain();

        public abstract void onComplete();

        public abstract void onError(Throwable r1);

        public abstract void onNext(JoinInnerSubscriber<T> r1, T r2);

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }
    }

    public static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        public JoinSubscriptionDelayError(Subscriber<? super T> r1, int r2, int r3) {
            super(r1, r2, r3);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            drainLoop();
        }

        public void drainLoop() {
            JoinInnerSubscriber<T>[] r1 = this.subscribers;
            int r2 = r1.length;
            Subscriber<? super T> r3 = this.downstream;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
            long r10 = 0;
        L5:
            if (r10 == r6) goto L34;
            if (this.cancelled == true) goto L8;
            if (this.done.get() != 0) goto L13;
            boolean r12 = true;
        L14:
            int r14 = 0;
            boolean r15 = true;
        L15:
            if (r14 >= r2) goto L25;
            JoinInnerSubscriber<T> r4 = r1[r14];
            SimplePlainQueue<T> r13 = r4.queue;
            if (r13 == null) goto L24;
            T r16 = r13.poll();
            if (r16 == null) goto L24;
            r3.onNext(r16);
            r4.requestOne();
            r10 = r10 + 1;
            if (r10 == r6) goto L34;
            r15 = false;
        L24:
            r14 = r14 + 1;
            goto L15
        L25:
            if (r12 == false) goto L32;
            if (r15 == false) goto L32;
            if (this.errors.get() == null) goto L30;
            r3.onError(this.errors.terminate());
            return;
        L30:
            r3.onComplete();
            return;
        L32:
            if (r15 == false) goto L5;
        L13:
            r12 = false;
            goto L14
        L8:
            cleanup();
            return;
        L34:
            if (r10 != r6) goto L60;
            if (this.cancelled == true) goto L37;
            if (this.done.get() != 0) goto L42;
            boolean r7 = true;
        L43:
            int r17 = 0;
        L44:
            if (r17 >= r2) goto L51;
            SimplePlainQueue<T> r18 = r1[r17].queue;
            if (r18 == null) goto L50;
            if (r18.isEmpty() == true) goto L50;
            boolean r19 = false;
        L52:
            if (r7 == false) goto L60;
            if (r19 == false) goto L60;
            if (this.errors.get() == null) goto L57;
            r3.onError(this.errors.terminate());
            return;
        L57:
            r3.onComplete();
            return;
        L50:
            r17 = r17 + 1;
            goto L44
        L51:
            r19 = true;
            goto L52
        L42:
            r7 = false;
            goto L43
        L37:
            cleanup();
            return;
        L60:
            if (r10 != 0) goto L62;
        L64:
            int r8 = get();
            if (r8 != r5) goto L69;
            r8 = addAndGet(-r5);
            if (r8 != 0) goto L69;
            return;
        L69:
            r5 = r8;
            goto L3
        L62:
            if (r6 == Long.MAX_VALUE) goto L64;
            this.requested.addAndGet(-r10);
            goto L64
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable r2) {
            this.errors.addThrowable(r2);
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> r7, T r8) {
            if (get() != 0) goto L20;
            if (compareAndSet(0, 1) == false) goto L20;
            if (this.requested.get() == 0) goto L13;
            this.downstream.onNext(r8);
            if (this.requested.get() == Long.MAX_VALUE) goto L11;
            this.requested.decrementAndGet();
        L11:
            r7.request(1);
        L17:
            if (decrementAndGet() != 0) goto L27;
            return;
        L27:
            drainLoop();
            return;
        L13:
            if (r7.getQueue().offer(r8) == true) goto L17;
            r7.cancel();
            this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
            this.done.decrementAndGet();
            drainLoop();
            return;
        L20:
            if (r7.getQueue().offer(r8) == true) goto L25;
            if (r7.cancel() == false) goto L25;
            this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
            this.done.decrementAndGet();
        L25:
            if (getAndIncrement() == 0) goto L27;
        }
    }

    public ParallelJoin(ParallelFlowable<? extends T> r1, int r2, boolean r3) {
        this.source = r1;
        this.prefetch = r2;
        this.delayErrors = r3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r4) {
        if (this.delayErrors == false) goto L5;
        JoinSubscriptionBase r0 = new JoinSubscriptionDelayError(r4, this.source.parallelism(), this.prefetch);
    L6:
        r4.onSubscribe(r0);
        this.source.subscribe(r0.subscribers);
        return;
    L5:
        r0 = new JoinSubscription(r4, this.source.parallelism(), this.prefetch);
        goto L6
    }
}

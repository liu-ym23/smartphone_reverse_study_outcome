package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean delayError;
    final int prefetch;
    final Scheduler scheduler;

    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        final AtomicLong requested;
        int sourceMode;
        Subscription upstream;
        final Scheduler.Worker worker;

        abstract void runAsync();

        abstract void runBackfused();

        abstract void runSync();

        BaseObserveOnSubscriber(Scheduler.Worker r1, boolean r2, int r3) {
            this.worker = r1;
            this.delayError = r2;
            this.prefetch = r3;
            this.requested = new AtomicLong();
            this.limit = r3 - (r3 >> 2);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T r3) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.sourceMode != 2) goto L10;
            trySchedule();
            return;
        L10:
            if (this.queue.offer(r3) == true) goto L12;
            this.upstream.cancel();
            this.error = new MissingBackpressureException("Queue is full?!");
            this.done = true;
        L12:
            trySchedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.error = r2;
            this.done = true;
            trySchedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            trySchedule();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            trySchedule();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        }

        final void trySchedule() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            this.worker.schedule(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.outputFused == false) goto L6;
            runBackfused();
            return;
        L6:
            if (this.sourceMode != 1) goto L8;
            runSync();
            return;
        L8:
            runAsync();
        }

        final boolean checkTerminated(boolean r3, boolean r4, Subscriber<?> r5) {
            if (this.cancelled == false) goto L6;
            clear();
            return true;
        L6:
            if (r3 == true) goto L8;
            return false;
        L8:
            if (this.delayError == false) goto L16;
            if (r4 == false) goto L25;
            this.cancelled = true;
            Throwable r6 = this.error;
            if (r6 == null) goto L13;
            r5.onError(r6);
        L14:
            this.worker.dispose();
            return true;
        L13:
            r5.onComplete();
            goto L14
        L25:
            return false;
        L16:
            Throwable r7 = this.error;
            if (r7 == null) goto L20;
            this.cancelled = true;
            clear();
            r5.onError(r7);
            this.worker.dispose();
            return true;
        L20:
            if (r4 == false) goto L26;
            this.cancelled = true;
            r5.onComplete();
            this.worker.dispose();
            return true;
        L26:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        long consumed;
        final ConditionalSubscriber<? super T> downstream;

        ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> r1, Scheduler.Worker r2, boolean r3, int r4) {
            super(r2, r3, r4);
            this.downstream = r1;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L16;
            this.upstream = r4;
            if ((r4 instanceof QueueSubscription) == false) goto L14;
            QueueSubscription r0 = (QueueSubscription) r4;
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = 1;
            this.queue = r0;
            this.done = true;
            this.downstream.onSubscribe(this);
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = 2;
            this.queue = r0;
            this.downstream.onSubscribe(this);
            r4.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            r4.request(this.prefetch);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            ConditionalSubscriber<? super T> r0 = this.downstream;
            SimpleQueue<T> r1 = this.queue;
            long r2 = this.produced;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
        L5:
            if (r2 == r6) goto L20;
            T r8 = r1.poll();     // Catch: Throwable -> L16
            if (this.cancelled == true) goto L9;
            if (r8 == null) goto L11;
            if (r0.tryOnNext(r8) == false) goto L5;
            r2 = r2 + 1;
            goto L5
        L11:
            this.cancelled = true;
            r0.onComplete();
            this.worker.dispose();
            return;
        L9:
            return;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            this.upstream.cancel();
            r0.onError(th);
            this.worker.dispose();
            return;
        L20:
            if (this.cancelled == true) goto L21;
            if (r1.isEmpty() == true) goto L24;
            int r7 = get();
            if (r5 == r7) goto L28;
            r5 = r7;
            goto L3
        L28:
            this.produced = r2;
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L3;
            return;
        L24:
            this.cancelled = true;
            r0.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            ConditionalSubscriber<? super T> r0 = this.downstream;
            SimpleQueue<T> r1 = this.queue;
            long r2 = this.produced;
            long r4 = this.consumed;
            int r7 = 1;
        L3:
            long r8 = this.requested.get();
        L5:
            if (r2 == r8) goto L25;
            boolean r11 = this.done;
            T r12 = r1.poll();     // Catch: Throwable -> L22
            if (r12 != null) goto L10;
            boolean r13 = true;
        L12:
            if (checkTerminated(r11, r13, r0) == true) goto L13;
            if (r13 == true) goto L25;
            if (r0.tryOnNext(r12) == false) goto L19;
            r2 = r2 + 1;
        L19:
            r4 = r4 + 1;
            if (r4 != this.limit) goto L5;
            this.upstream.request(r4);
            r4 = 0;
            goto L5
        L13:
            return;
        L10:
            r13 = false;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            this.upstream.cancel();
            r1.clear();
            r0.onError(th);
            this.worker.dispose();
            return;
        L25:
            if (r2 == r8) goto L27;
        L29:
            int r9 = get();
            if (r7 == r9) goto L31;
            r7 = r9;
            goto L3
        L31:
            this.produced = r2;
            this.consumed = r4;
            r7 = addAndGet(-r7);
            if (r7 != 0) goto L3;
            return;
        L27:
            if (checkTerminated(this.done, r1.isEmpty(), r0) == false) goto L29;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int r1 = 1;
        L4:
            if (this.cancelled == true) goto L5;
            boolean r2 = this.done;
            this.downstream.onNext(null);
            if (r2 == true) goto L8;
            r1 = addAndGet(-r1);
            if (r1 != 0) goto L4;
            return;
        L8:
            this.cancelled = true;
            Throwable r0 = this.error;
            if (r0 == null) goto L11;
            this.downstream.onError(r0);
        L12:
            this.worker.dispose();
            return;
        L11:
            this.downstream.onComplete();
            goto L12
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T r0 = this.queue.poll();
            if (r0 != null) goto L5;
        L10:
            return r0;
        L5:
            if (this.sourceMode == 1) goto L10;
            long r1 = this.consumed + 1;
            if (r1 != this.limit) goto L9;
            this.consumed = 0;
            this.upstream.request(r1);
            goto L10
        L9:
            this.consumed = r1;
            goto L10
        }
    }

    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final Subscriber<? super T> downstream;

        ObserveOnSubscriber(Subscriber<? super T> r1, Scheduler.Worker r2, boolean r3, int r4) {
            super(r2, r3, r4);
            this.downstream = r1;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L16;
            this.upstream = r4;
            if ((r4 instanceof QueueSubscription) == false) goto L14;
            QueueSubscription r0 = (QueueSubscription) r4;
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = 1;
            this.queue = r0;
            this.done = true;
            this.downstream.onSubscribe(this);
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = 2;
            this.queue = r0;
            this.downstream.onSubscribe(this);
            r4.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            r4.request(this.prefetch);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            Subscriber<? super T> r0 = this.downstream;
            SimpleQueue<T> r1 = this.queue;
            long r2 = this.produced;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
        L5:
            if (r2 == r6) goto L18;
            T r8 = r1.poll();     // Catch: Throwable -> L14
            if (this.cancelled == true) goto L9;
            if (r8 == null) goto L11;
            r0.onNext(r8);
            r2 = r2 + 1;
            goto L5
        L11:
            this.cancelled = true;
            r0.onComplete();
            this.worker.dispose();
            return;
        L9:
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            this.upstream.cancel();
            r0.onError(th);
            this.worker.dispose();
            return;
        L18:
            if (this.cancelled == true) goto L19;
            if (r1.isEmpty() == true) goto L22;
            int r7 = get();
            if (r5 == r7) goto L26;
            r5 = r7;
            goto L3
        L26:
            this.produced = r2;
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L3;
            return;
        L22:
            this.cancelled = true;
            r0.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            Subscriber<? super T> r0 = this.downstream;
            SimpleQueue<T> r1 = this.queue;
            long r2 = this.produced;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
        L5:
            if (r2 == r6) goto L25;
            boolean r9 = this.done;
            T r10 = r1.poll();     // Catch: Throwable -> L22
            if (r10 != null) goto L10;
            boolean r11 = true;
        L12:
            if (checkTerminated(r9, r11, r0) == true) goto L13;
            if (r11 == true) goto L25;
            r0.onNext(r10);
            r2 = r2 + 1;
            if (r2 != this.limit) goto L5;
            if (r6 == Long.MAX_VALUE) goto L21;
            r6 = this.requested.addAndGet(-r2);
        L21:
            this.upstream.request(r2);
            r2 = 0;
            goto L5
        L13:
            return;
        L10:
            r11 = false;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            this.upstream.cancel();
            r1.clear();
            r0.onError(th);
            this.worker.dispose();
            return;
        L25:
            if (r2 == r6) goto L27;
        L29:
            int r7 = get();
            if (r5 == r7) goto L31;
            r5 = r7;
            goto L3
        L31:
            this.produced = r2;
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L3;
            return;
        L27:
            if (checkTerminated(this.done, r1.isEmpty(), r0) == false) goto L29;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int r1 = 1;
        L4:
            if (this.cancelled == true) goto L5;
            boolean r2 = this.done;
            this.downstream.onNext(null);
            if (r2 == true) goto L8;
            r1 = addAndGet(-r1);
            if (r1 != 0) goto L4;
            return;
        L8:
            this.cancelled = true;
            Throwable r0 = this.error;
            if (r0 == null) goto L11;
            this.downstream.onError(r0);
        L12:
            this.worker.dispose();
            return;
        L11:
            this.downstream.onComplete();
            goto L12
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T r0 = this.queue.poll();
            if (r0 != null) goto L5;
        L10:
            return r0;
        L5:
            if (this.sourceMode == 1) goto L10;
            long r1 = this.produced + 1;
            if (r1 != this.limit) goto L9;
            this.produced = 0;
            this.upstream.request(r1);
            goto L10
        L9:
            this.produced = r1;
            goto L10
        }
    }

    public FlowableObserveOn(Flowable<T> r1, Scheduler r2, boolean r3, int r4) {
        super(r1);
        this.scheduler = r2;
        this.delayError = r3;
        this.prefetch = r4;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r5) {
        Scheduler.Worker r0 = this.scheduler.createWorker();
        if ((r5 instanceof ConditionalSubscriber) == false) goto L5;
        this.source.subscribe(new ObserveOnConditionalSubscriber((ConditionalSubscriber) r5, r0, this.delayError, this.prefetch));
        return;
    L5:
        this.source.subscribe(new ObserveOnSubscriber(r5, r0, this.delayError, this.prefetch));
    }
}

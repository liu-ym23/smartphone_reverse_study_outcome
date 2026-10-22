package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelRunOn<T> extends ParallelFlowable<T> {
    final int prefetch;
    final Scheduler scheduler;
    final ParallelFlowable<? extends T> source;

    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final SpscArrayQueue<T> queue;
        final AtomicLong requested;
        Subscription upstream;
        final Scheduler.Worker worker;

        BaseRunOnSubscriber(int r2, SpscArrayQueue<T> r3, Scheduler.Worker r4) {
            this.requested = new AtomicLong();
            this.prefetch = r2;
            this.queue = r3;
            this.limit = r2 - (r2 >> 2);
            this.worker = r4;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T r2) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.queue.offer(r2) == true) goto L9;
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue is full?!"));
            return;
        L9:
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.error = r2;
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            schedule();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            schedule();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        final void schedule() {
            if (getAndIncrement() != 0) goto L6;
            this.worker.schedule(this);
            return;
        }
    }

    final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {
        final Subscriber<T>[] parents;
        final Subscriber<? super T>[] subscribers;
        final /* synthetic */ ParallelRunOn this$0;

        MultiWorkerCallback(ParallelRunOn r1, Subscriber<? super T>[] r2, Subscriber<T>[] r3) {
            this.this$0 = r1;
            this.subscribers = r2;
            this.parents = r3;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
        public void onWorker(int r3, Scheduler.Worker r4) {
            this.this$0.createSubscriber(r3, this.subscribers, this.parents, r4);
        }
    }

    static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final ConditionalSubscriber<? super T> downstream;

        RunOnConditionalSubscriber(ConditionalSubscriber<? super T> r1, int r2, SpscArrayQueue<T> r3, Scheduler.Worker r4) {
            super(r2, r3, r4);
            this.downstream = r1;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(this.prefetch);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r1 = this.consumed;
            SpscArrayQueue<T> r2 = this.queue;
            ConditionalSubscriber<? super T> r3 = this.downstream;
            int r4 = this.limit;
            int r6 = 1;
        L3:
            long r7 = this.requested.get();
            long r11 = 0;
        L5:
            if (r11 == r7) goto L32;
            if (this.cancelled == true) goto L8;
            boolean r14 = this.done;
            if (r14 == false) goto L16;
            Throwable r15 = this.error;
            if (r15 == null) goto L16;
            r2.clear();
            r3.onError(r15);
            this.worker.dispose();
            return;
        L16:
            T r16 = r2.poll();
            if (r16 != null) goto L19;
            boolean r17 = true;
        L20:
            if (r14 == false) goto L24;
            if (r17 == false) goto L24;
            r3.onComplete();
            this.worker.dispose();
            return;
        L24:
            if (r17 == true) goto L32;
            if (r3.tryOnNext(r16) == false) goto L29;
            r11 = r11 + 1;
        L29:
            r1 = r1 + 1;
            if (r1 != r4) goto L5;
            this.upstream.request(r1);
            r1 = 0;
            goto L5
        L19:
            r17 = false;
            goto L20
        L8:
            r2.clear();
            return;
        L32:
            if (r11 != r7) goto L48;
            if (this.cancelled == true) goto L35;
            if (this.done == false) goto L48;
            Throwable r13 = this.error;
            if (r13 != null) goto L41;
            if (r2.isEmpty() == false) goto L48;
            r3.onComplete();
            this.worker.dispose();
            return;
        L41:
            r2.clear();
            r3.onError(r13);
            this.worker.dispose();
            return;
        L35:
            r2.clear();
            return;
        L48:
            if (r11 != 0) goto L50;
        L52:
            int r8 = get();
            if (r8 == r6) goto L54;
            r6 = r8;
            goto L3
        L54:
            this.consumed = r1;
            r6 = addAndGet(-r6);
            if (r6 != 0) goto L3;
            return;
        L50:
            if (r7 == Long.MAX_VALUE) goto L52;
            this.requested.addAndGet(-r11);
            goto L52
        }
    }

    static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final Subscriber<? super T> downstream;

        RunOnSubscriber(Subscriber<? super T> r1, int r2, SpscArrayQueue<T> r3, Scheduler.Worker r4) {
            super(r2, r3, r4);
            this.downstream = r1;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(this.prefetch);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r1 = this.consumed;
            SpscArrayQueue<T> r2 = this.queue;
            Subscriber<? super T> r3 = this.downstream;
            int r4 = this.limit;
            int r6 = 1;
        L3:
            long r7 = this.requested.get();
            long r11 = 0;
        L5:
            if (r11 == r7) goto L29;
            if (this.cancelled == true) goto L8;
            boolean r14 = this.done;
            if (r14 == false) goto L16;
            Throwable r15 = this.error;
            if (r15 == null) goto L16;
            r2.clear();
            r3.onError(r15);
            this.worker.dispose();
            return;
        L16:
            T r16 = r2.poll();
            if (r16 != null) goto L19;
            boolean r17 = true;
        L20:
            if (r14 == false) goto L24;
            if (r17 == false) goto L24;
            r3.onComplete();
            this.worker.dispose();
            return;
        L24:
            if (r17 == true) goto L29;
            r3.onNext(r16);
            r11 = r11 + 1;
            r1 = r1 + 1;
            if (r1 != r4) goto L5;
            this.upstream.request(r1);
            r1 = 0;
            goto L5
        L19:
            r17 = false;
            goto L20
        L8:
            r2.clear();
            return;
        L29:
            if (r11 != r7) goto L45;
            if (this.cancelled == true) goto L32;
            if (this.done == false) goto L45;
            Throwable r13 = this.error;
            if (r13 != null) goto L38;
            if (r2.isEmpty() == false) goto L45;
            r3.onComplete();
            this.worker.dispose();
            return;
        L38:
            r2.clear();
            r3.onError(r13);
            this.worker.dispose();
            return;
        L32:
            r2.clear();
            return;
        L45:
            if (r11 != 0) goto L47;
        L49:
            int r8 = get();
            if (r8 == r6) goto L51;
            r6 = r8;
            goto L3
        L51:
            this.consumed = r1;
            r6 = addAndGet(-r6);
            if (r6 != 0) goto L3;
            return;
        L47:
            if (r7 == Long.MAX_VALUE) goto L49;
            this.requested.addAndGet(-r11);
            goto L49
        }
    }

    public ParallelRunOn(ParallelFlowable<? extends T> r1, Scheduler r2, int r3) {
        this.source = r1;
        this.scheduler = r2;
        this.prefetch = r3;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] r5) {
        if (validate(r5) == true) goto L5;
        return;
    L5:
        int r0 = r5.length;
        Subscriber<T>[] r1 = new Subscriber[r0];
        Object r2 = this.scheduler;
        if ((r2 instanceof SchedulerMultiWorkerSupport) == false) goto L8;
        ((SchedulerMultiWorkerSupport) r2).createWorkers(r0, new MultiWorkerCallback(this, r5, r1));
    L11:
        this.source.subscribe(r1);
        return;
    L8:
        int r3 = 0;
    L9:
        if (r3 >= r0) goto L11;
        createSubscriber(r3, r5, r1, this.scheduler.createWorker());
        r3 = r3 + 1;
        goto L9
    }

    void createSubscriber(int r3, Subscriber<? super T>[] r4, Subscriber<T>[] r5, Scheduler.Worker r6) {
        Subscriber<? super T> r7 = r4[r3];
        SpscArrayQueue r0 = new SpscArrayQueue(this.prefetch);
        if ((r7 instanceof ConditionalSubscriber) == false) goto L5;
        r5[r3] = new RunOnConditionalSubscriber((ConditionalSubscriber) r7, this.prefetch, r0, r6);
        return;
    L5:
        r5[r3] = new RunOnSubscriber(r7, this.prefetch, r0, r6);
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableWindow<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long size;
    final long skip;

    static final class WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        final int bufferSize;
        final Subscriber<? super Flowable<T>> downstream;
        long index;
        final AtomicBoolean once;
        final long size;
        Subscription upstream;
        UnicastProcessor<T> window;

        WindowExactSubscriber(Subscriber<? super Flowable<T>> r2, long r3, int r5) {
            super(1);
            this.downstream = r2;
            this.size = r3;
            this.once = new AtomicBoolean();
            this.bufferSize = r5;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r8) {
            long r0 = this.index;
            UnicastProcessor<T> r2 = this.window;
            if (r0 != 0) goto L5;
            getAndIncrement();
            r2 = UnicastProcessor.create(this.bufferSize, this);
            this.window = r2;
            this.downstream.onNext(r2);
        L5:
            long r1 = r0 + 1;
            r2.onNext(r8);
            if (r1 != this.size) goto L8;
            this.index = 0;
            this.window = null;
            r2.onComplete();
            return;
        L8:
            this.index = r1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            UnicastProcessor<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onError(r3);
        L5:
            this.downstream.onError(r3);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onComplete();
        L5:
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r3) {
            if (SubscriptionHelper.validate(r3) == false) goto L6;
            long r4 = BackpressureHelper.multiplyCap(this.size, r3);
            this.upstream.request(r4);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            run();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() != 0) goto L6;
            this.upstream.cancel();
            return;
        }
    }

    static final class WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final Subscriber<? super Flowable<T>> downstream;
        Throwable error;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        long produced;
        final SpscLinkedArrayQueue<UnicastProcessor<T>> queue;
        final AtomicLong requested;
        final long size;
        final long skip;
        Subscription upstream;
        final ArrayDeque<UnicastProcessor<T>> windows;
        final AtomicInteger wip;

        WindowOverlapSubscriber(Subscriber<? super Flowable<T>> r2, long r3, long r5, int r7) {
            super(1);
            this.downstream = r2;
            this.size = r3;
            this.skip = r5;
            this.queue = new SpscLinkedArrayQueue(r7);
            this.windows = new ArrayDeque();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = r7;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r9) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.index;
            if (r0 == 0) goto L8;
        L10:
            long r1 = r0 + 1;
            Iterator<UnicastProcessor<T>> r6 = this.windows.iterator();
        L12:
            if (r6.hasNext() == false) goto L14;
            r6.next().onNext(r9);
            goto L12
        L14:
            long r7 = this.produced + 1;
            if (r7 != this.size) goto L19;
            this.produced = r7 - this.skip;
            UnicastProcessor<T> r10 = this.windows.poll();
            if (r10 == null) goto L21;
            r10.onComplete();
        L21:
            if (r1 != this.skip) goto L23;
            this.index = 0;
            return;
        L23:
            this.index = r1;
            return;
        L19:
            this.produced = r7;
            goto L21
        L8:
            if (this.cancelled == true) goto L10;
            getAndIncrement();
            UnicastProcessor<T> r4 = UnicastProcessor.create(this.bufferSize, this);
            this.windows.offer(r4);
            this.queue.offer(r4);
            drain();
            goto L10
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r3);
            return;
        L6:
            Iterator<UnicastProcessor<T>> r0 = this.windows.iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            r0.next().onError(r3);
            goto L8
        L10:
            this.windows.clear();
            this.error = r3;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            Iterator<UnicastProcessor<T>> r0 = this.windows.iterator();
        L7:
            if (r0.hasNext() == false) goto L9;
            r0.next().onComplete();
            goto L7
        L9:
            this.windows.clear();
            this.done = true;
            drain();
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super Flowable<T>> r0 = this.downstream;
            SpscLinkedArrayQueue<UnicastProcessor<T>> r1 = this.queue;
            int r3 = 1;
        L6:
            long r4 = this.requested.get();
            long r8 = 0;
        L8:
            if (r8 == r4) goto L19;
            boolean r11 = this.done;
            UnicastProcessor<T> r12 = r1.poll();
            if (r12 != null) goto L12;
            boolean r13 = true;
        L14:
            if (checkTerminated(r11, r13, r0, r1) == true) goto L15;
            if (r13 == true) goto L19;
            r0.onNext(r12);
            r8 = r8 + 1;
            goto L8
        L15:
            return;
        L12:
            r13 = false;
        L19:
            if (r8 != r4) goto L24;
            if (checkTerminated(this.done, r1.isEmpty(), r0, r1) == false) goto L24;
            return;
        L24:
            if (r8 != 0) goto L26;
        L28:
            r3 = this.wip.addAndGet(-r3);
            if (r3 != 0) goto L6;
            return;
        L26:
            if (r4 == Long.MAX_VALUE) goto L28;
            this.requested.addAndGet(-r8);
            goto L28
        }

        boolean checkTerminated(boolean r3, boolean r4, Subscriber<?> r5, SpscLinkedArrayQueue<?> r6) {
            if (this.cancelled == false) goto L6;
            r6.clear();
            return true;
        L6:
            if (r3 == false) goto L14;
            Throwable r2 = this.error;
            if (r2 == null) goto L11;
            r6.clear();
            r5.onError(r2);
            return true;
        L11:
            if (r4 == false) goto L16;
            r5.onComplete();
            return true;
        L16:
            return false;
        L14:
            return false;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r5) {
            if (SubscriptionHelper.validate(r5) == false) goto L12;
            BackpressureHelper.add(this.requested, r5);
            if (this.firstRequest.get() == false) goto L7;
        L9:
            long r6 = BackpressureHelper.multiplyCap(this.skip, r5);
            this.upstream.request(r6);
        L10:
            drain();
            return;
        L7:
            if (this.firstRequest.compareAndSet(false, true) == false) goto L9;
            long r7 = BackpressureHelper.multiplyCap(this.skip, r5 - 1);
            long r8 = BackpressureHelper.addCap(this.size, r7);
            this.upstream.request(r8);
            goto L10
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true) == false) goto L6;
            run();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() != 0) goto L6;
            this.upstream.cancel();
            return;
        }
    }

    static final class WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        final int bufferSize;
        final Subscriber<? super Flowable<T>> downstream;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        final long size;
        final long skip;
        Subscription upstream;
        UnicastProcessor<T> window;

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> r2, long r3, long r5, int r7) {
            super(1);
            this.downstream = r2;
            this.size = r3;
            this.skip = r5;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = r7;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r8) {
            long r0 = this.index;
            UnicastProcessor<T> r2 = this.window;
            if (r0 != 0) goto L5;
            getAndIncrement();
            r2 = UnicastProcessor.create(this.bufferSize, this);
            this.window = r2;
            this.downstream.onNext(r2);
        L5:
            long r1 = r0 + 1;
            if (r2 == null) goto L9;
            r2.onNext(r8);
        L9:
            if (r1 != this.size) goto L12;
            this.window = null;
            r2.onComplete();
        L12:
            if (r1 != this.skip) goto L14;
            this.index = 0;
            return;
        L14:
            this.index = r1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            UnicastProcessor<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onError(r3);
        L5:
            this.downstream.onError(r3);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onComplete();
        L5:
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r7) {
            if (SubscriptionHelper.validate(r7) == true) goto L5;
            return;
        L5:
            if (this.firstRequest.get() == false) goto L7;
        L9:
            long r8 = BackpressureHelper.multiplyCap(this.skip, r7);
            this.upstream.request(r8);
            return;
        L7:
            if (this.firstRequest.compareAndSet(false, true) == false) goto L9;
            long r9 = BackpressureHelper.addCap(BackpressureHelper.multiplyCap(this.size, r7), BackpressureHelper.multiplyCap(this.skip - this.size, r7 - 1));
            this.upstream.request(r9);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            run();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() != 0) goto L6;
            this.upstream.cancel();
            return;
        }
    }

    public FlowableWindow(Flowable<T> r1, long r2, long r4, int r6) {
        super(r1);
        this.size = r2;
        this.skip = r4;
        this.bufferSize = r6;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> r10) {
        long r0 = this.skip;
        long r2 = this.size;
        if (r0 != r2) goto L6;
        this.source.subscribe(new WindowExactSubscriber(r10, this.size, this.bufferSize));
        return;
    L6:
        if (r0 <= r2) goto L8;
        this.source.subscribe(new WindowSkipSubscriber(r10, this.size, this.skip, this.bufferSize));
        return;
    L8:
        this.source.subscribe(new WindowOverlapSubscriber(r10, this.size, this.skip, this.bufferSize));
    }
}

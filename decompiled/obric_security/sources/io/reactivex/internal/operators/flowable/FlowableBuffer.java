package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
    final Callable<C> bufferSupplier;
    final int size;
    final int skip;

    static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final int size;
        Subscription upstream;

        PublisherBufferExactSubscriber(Subscriber<? super C> r1, int r2, Callable<C> r3) {
            this.downstream = r1;
            this.size = r2;
            this.bufferSupplier = r3;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r4) {
            if (SubscriptionHelper.validate(r4) == false) goto L6;
            this.upstream.request(BackpressureHelper.multiplyCap(r4, this.size));
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.done == false) goto L5;
            return;
        L5:
            C r0 = this.buffer;
            if (r0 == null) goto L17;
        L12:
            r0.add(r3);
            int r4 = this.index + 1;
            if (r4 != this.size) goto L15;
            this.index = 0;
            this.buffer = null;
            this.downstream.onNext(r0);
            return;
        L15:
            this.index = r4;
            return;
        L17:
            r0 = (C) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L9
            this.buffer = r0;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            C r0 = this.buffer;
            if (r0 != null) goto L8;
        L10:
            this.downstream.onComplete();
            return;
        L8:
            if (r0.isEmpty() == true) goto L10;
            this.downstream.onNext(r0);
            goto L10
        }
    }

    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;
        final Callable<C> bufferSupplier;
        final ArrayDeque<C> buffers;
        volatile boolean cancelled;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final AtomicBoolean once;
        long produced;
        final int size;
        final int skip;
        Subscription upstream;

        PublisherBufferOverlappingSubscriber(Subscriber<? super C> r1, int r2, int r3, Callable<C> r4) {
            this.downstream = r1;
            this.size = r2;
            this.skip = r3;
            this.bufferSupplier = r4;
            this.once = new AtomicBoolean();
            this.buffers = new ArrayDeque();
        }

        @Override // io.reactivex.functions.BooleanSupplier
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r8) {
            if (SubscriptionHelper.validate(r8) == true) goto L5;
            return;
        L5:
            if (QueueDrainHelper.postCompleteRequest(r8, this.downstream, this.buffers, this, this) == false) goto L8;
            return;
        L8:
            if (this.once.get() == false) goto L10;
        L12:
            this.upstream.request(BackpressureHelper.multiplyCap(this.skip, r8));
            return;
        L10:
            if (this.once.compareAndSet(false, true) == false) goto L12;
            this.upstream.request(BackpressureHelper.addCap(this.size, BackpressureHelper.multiplyCap(this.skip, r8 - 1)));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
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
            if (this.done == false) goto L5;
            return;
        L5:
            ArrayDeque<C> r0 = this.buffers;
            int r1 = this.index;
            int r2 = r1 + 1;
            if (r1 == 0) goto L26;
        L12:
            C r3 = r0.peek();
            if (r3 != null) goto L15;
        L17:
            Iterator<C> r4 = r0.iterator();
        L19:
            if (r4.hasNext() == false) goto L22;
            r4.next().add(r8);
            goto L19
        L22:
            if (r2 != this.skip) goto L24;
            r2 = 0;
        L24:
            this.index = r2;
            return;
        L15:
            if ((r3.size() + 1) != this.size) goto L17;
            r0.poll();
            r3.add(r8);
            this.produced++;
            this.downstream.onNext(r3);
            goto L17
        L26:
            r0.offer((C) ((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer")));
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.buffers.clear();
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            long r0 = this.produced;
            if (r0 == 0) goto L8;
            BackpressureHelper.produced(this, r0);
        L8:
            QueueDrainHelper.postComplete(this.downstream, this.buffers, this, this);
        }
    }

    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final int size;
        final int skip;
        Subscription upstream;

        PublisherBufferSkipSubscriber(Subscriber<? super C> r1, int r2, int r3, Callable<C> r4) {
            this.downstream = r1;
            this.size = r2;
            this.skip = r3;
            this.bufferSupplier = r4;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r7) {
            if (SubscriptionHelper.validate(r7) == true) goto L5;
            return;
        L5:
            if (get() == 0) goto L7;
        L9:
            this.upstream.request(BackpressureHelper.multiplyCap(this.skip, r7));
            return;
        L7:
            if (compareAndSet(0, 1) == false) goto L9;
            this.upstream.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(r7, this.size), BackpressureHelper.multiplyCap(this.skip - this.size, r7 - 1)));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r4) {
            if (this.done == false) goto L5;
            return;
        L5:
            C r0 = this.buffer;
            int r1 = this.index;
            int r2 = r1 + 1;
            if (r1 == 0) goto L21;
        L12:
            if (r0 == null) goto L17;
            r0.add(r4);
            if (r0.size() != this.size) goto L17;
            this.buffer = null;
            this.downstream.onNext(r0);
        L17:
            if (r2 != this.skip) goto L19;
            r2 = 0;
        L19:
            this.index = r2;
            return;
        L21:
            r0 = (C) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L9
            this.buffer = r0;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.buffer = null;
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            C r0 = this.buffer;
            this.buffer = null;
            if (r0 == null) goto L8;
            this.downstream.onNext(r0);
        L8:
            this.downstream.onComplete();
        }
    }

    public FlowableBuffer(Flowable<T> r1, int r2, int r3, Callable<C> r4) {
        super(r1);
        this.size = r2;
        this.skip = r3;
        this.bufferSupplier = r4;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super C> r5) {
        int r0 = this.size;
        int r1 = this.skip;
        if (r0 != r1) goto L5;
        this.source.subscribe(new PublisherBufferExactSubscriber(r5, this.size, this.bufferSupplier));
        return;
    L5:
        if (r1 <= r0) goto L7;
        this.source.subscribe(new PublisherBufferSkipSubscriber(r5, this.size, this.skip, this.bufferSupplier));
        return;
    L7:
        this.source.subscribe(new PublisherBufferOverlappingSubscriber(r5, this.size, this.skip, this.bufferSupplier));
    }
}

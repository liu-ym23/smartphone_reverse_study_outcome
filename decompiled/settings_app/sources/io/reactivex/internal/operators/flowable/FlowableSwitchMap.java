package io.reactivex.internal.operators.flowable;

import adcpeJava.adcpe.Constants;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;

    static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final SwitchMapSubscriber<T, R> parent;
        volatile SimpleQueue<R> queue;

        SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> r1, long r2, int r4) {
            this.parent = r1;
            this.index = r2;
            this.bufferSize = r4;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.setOnce(this, r4) == true) goto L5;
            return;
        L5:
            if ((r4 instanceof QueueSubscription) == false) goto L14;
            QueueSubscription r0 = (QueueSubscription) r4;
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.fusionMode = r1;
            this.queue = r0;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.fusionMode = r1;
            this.queue = r0;
            r4.request(this.bufferSize);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.bufferSize);
            r4.request(this.bufferSize);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r6) {
            SwitchMapSubscriber<T, R> r0 = this.parent;
            if (this.index == r0.unique) goto L5;
            return;
        L5:
            if (this.fusionMode == 0) goto L7;
        L10:
            r0.drain();
            return;
        L7:
            if (this.queue.offer(r6) == true) goto L10;
            onError(new MissingBackpressureException("Queue full?!"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r6) {
            SwitchMapSubscriber<T, R> r0 = this.parent;
            if (this.index == r0.unique) goto L5;
        L10:
            RxJavaPlugins.onError(r6);
            return;
        L5:
            if (r0.error.addThrowable(r6) == false) goto L10;
            if (r0.delayErrors == true) goto L9;
            r0.upstream.cancel();
            r0.done = true;
        L9:
            this.done = true;
            r0.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SwitchMapSubscriber<T, R> r0 = this.parent;
            if (this.index != r0.unique) goto L6;
            this.done = true;
            r0.drain();
            return;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void request(long r3) {
            if (this.fusionMode == 1) goto L6;
            get().request(r3);
            return;
        }
    }

    static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final SwitchMapInnerSubscriber<Object, Object> CANCELLED = null;
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> active;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicThrowable error;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final AtomicLong requested;
        volatile long unique;
        Subscription upstream;

        static {
            SwitchMapInnerSubscriber<Object, Object> r0 = new SwitchMapInnerSubscriber(null, -1, 1);
            CANCELLED = r0;
            r0.cancel();
        }

        SwitchMapSubscriber(Subscriber<? super R> r2, Function<? super T, ? extends Publisher<? extends R>> r3, int r4, boolean r5) {
            this.active = new AtomicReference();
            this.requested = new AtomicLong();
            this.downstream = r2;
            this.mapper = r3;
            this.bufferSize = r4;
            this.delayErrors = r5;
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r5) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.unique + 1;
            this.unique = r0;
            SwitchMapInnerSubscriber<T, R> r2 = this.active.get();
            if (r2 == null) goto L20;
            r2.cancel();
        L20:
            Publisher r6 = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(r5), "The publisher returned is null");     // Catch: Throwable -> L17
            SwitchMapInnerSubscriber<T, R> r3 = new SwitchMapInnerSubscriber(this, r0, this.bufferSize);
        L10:
            SwitchMapInnerSubscriber<T, R> r1 = this.active.get();
            if (r1 == CANCELLED) goto L25;
            if (this.active.compareAndSet(r1, r3) == false) goto L10;
            r6.subscribe(r3);
            return;
        L25:
            return;
        L17:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L5;
        L10:
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.error.addThrowable(r2) == false) goto L10;
            if (this.delayErrors == true) goto L9;
            disposeInner();
        L9:
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r3) {
            if (SubscriptionHelper.validate(r3) == false) goto L9;
            BackpressureHelper.add(this.requested, r3);
            if (this.unique != 0) goto L7;
            this.upstream.request(Long.MAX_VALUE);
            return;
        L7:
            drain();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.upstream.cancel();
            disposeInner();
            return;
        }

        void disposeInner() {
            SwitchMapInnerSubscriber<T, R> r0 = this.active.get();
            SwitchMapInnerSubscriber<Object, Object> r1 = CANCELLED;
            if (r0 == r1) goto L9;
            SwitchMapInnerSubscriber<T, R> r2 = this.active.getAndSet((SwitchMapInnerSubscriber<T, R>) r1);
            if (r2 == r1) goto L10;
            if (r2 == null) goto L11;
            r2.cancel();
            return;
        L11:
            return;
        L10:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super R> r2 = this.downstream;
            int r4 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (this.done == true) goto L13;
        L29:
            SwitchMapInnerSubscriber<T, R> r6 = this.active.get();
            if (r6 == null) goto L32;
            SimpleQueue<R> r7 = r6.queue;
        L33:
            if (r7 == null) goto L89;
            if (r6.done == false) goto L48;
            if (this.delayErrors == false) goto L39;
            if (r7.isEmpty() == false) goto L48;
            this.active.compareAndSet(r6, null);
            goto L7
        L39:
            if (this.error.get() != null) goto L40;
            if (r7.isEmpty() == false) goto L48;
            this.active.compareAndSet(r6, null);
            goto L7
        L40:
            disposeInner();
            r2.onError(this.error.terminate());
            return;
        L48:
            long r8 = this.requested.get();
            long r12 = 0;
        L49:
            boolean r14 = false;
            if (r12 == r8) goto L80;
            if (this.cancelled == true) goto L53;
            boolean r0 = r6.done;
            Constants r15 = r7.poll();     // Catch: Throwable -> L57
        L59:
            if (r15 != null) goto L61;
            boolean r16 = true;
        L63:
            if (r6 != this.active.get()) goto L64;
            if (r0 == true) goto L67;
        L76:
            if (r16 == true) goto L80;
            r2.onNext(r15);
            r12 = r12 + 1;
            goto L49
        L67:
            if (this.delayErrors == false) goto L69;
            if (r16 == false) goto L76;
            this.active.compareAndSet(r6, null);
            goto L64
        L69:
            if (this.error.get() != null) goto L70;
            if (r16 == false) goto L76;
            this.active.compareAndSet(r6, null);
            goto L64
        L70:
            r2.onError(this.error.terminate());
            return;
        L64:
            r14 = true;
            goto L80
        L61:
            r16 = false;
        L57:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r6.cancel();
            this.error.addThrowable(th);
            r15 = null;
            r0 = true;
            goto L59
        L53:
            return;
        L80:
            if (r12 != 0) goto L82;
        L87:
            if (r14 == false) goto L89;
        L82:
            if (this.cancelled == true) goto L87;
            if (r8 == Long.MAX_VALUE) goto L86;
            this.requested.addAndGet(-r12);
        L86:
            r6.request(r12);
        L89:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L32:
            r7 = null;
            goto L33
        L13:
            if (this.delayErrors == false) goto L22;
            if (this.active.get() != null) goto L29;
            if (this.error.get() == null) goto L19;
            r2.onError(this.error.terminate());
            return;
        L19:
            r2.onComplete();
            return;
        L22:
            if (this.error.get() != null) goto L23;
            if (this.active.get() != null) goto L29;
            r2.onComplete();
            return;
        L23:
            disposeInner();
            r2.onError(this.error.terminate());
            return;
        L8:
            this.active.lazySet(null);
        }
    }

    public FlowableSwitchMap(Flowable<T> r1, Function<? super T, ? extends Publisher<? extends R>> r2, int r3, boolean r4) {
        super(r1);
        this.mapper = r2;
        this.bufferSize = r3;
        this.delayErrors = r4;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r5) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, r5, this.mapper) == false) goto L5;
        return;
    L5:
        this.source.subscribe(new SwitchMapSubscriber(r5, this.mapper, this.bufferSize, this.delayErrors));
    }
}

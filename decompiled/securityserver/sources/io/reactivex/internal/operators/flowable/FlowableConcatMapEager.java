package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    public static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final AtomicLong requested;
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
        Subscription upstream;

        public ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> r1, Function<? super T, ? extends Publisher<? extends R>> r2, int r3, int r4, ErrorMode r5) {
            this.downstream = r1;
            this.mapper = r2;
            this.maxConcurrency = r3;
            this.prefetch = r4;
            this.errorMode = r5;
            this.subscribers = new SpscLinkedArrayQueue(Math.min(r4, r3));
            this.errors = new AtomicThrowable();
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            this.upstream.cancel();
            drainAndCancel();
        }

        public void cancelAll() {
            InnerQueuedSubscriber<R> r0 = this.current;
            this.current = null;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            InnerQueuedSubscriber<R> r1 = this.subscribers.poll();
            if (r1 == null) goto L8;
            r1.cancel();
            goto L5
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            InnerQueuedSubscriber<R> r0 = this.current;
            Subscriber<? super R> r2 = this.downstream;
            ErrorMode r3 = this.errorMode;
            int r5 = 1;
        L6:
            long r6 = this.requested.get();
            if (r0 == null) goto L9;
            r0 = r0;
        L25:
            if (r0 == null) goto L72;
            SimpleQueue<R> r11 = r0.queue();
            if (r11 == null) goto L72;
            long r12 = 0;
        L29:
            int r16 = r5;
            if (r12 == r6) goto L55;
            if (this.cancelled == true) goto L33;
            if (r3 == ErrorMode.IMMEDIATE) goto L38;
        L41:
            boolean r1 = r0.isDone();
            R r9 = r11.poll();     // Catch: Throwable -> L52
            if (r9 != null) goto L45;
            boolean r10 = true;
        L46:
            if (r1 == false) goto L49;
            if (r10 == false) goto L49;
            this.current = null;
            this.upstream.request(1);
            r0 = null;
            boolean r4 = true;
        L56:
            if (r12 == r6) goto L58;
        L71:
            long r7 = 0;
        L74:
            if (r12 != r7) goto L76;
        L78:
            if (r4 == true) goto L79;
            r5 = addAndGet(-r16);
            if (r5 != 0) goto L6;
            return;
        L79:
            r5 = r16;
            goto L6
        L76:
            if (r6 == Long.MAX_VALUE) goto L78;
            this.requested.addAndGet(-r12);
            goto L78
        L58:
            if (this.cancelled == true) goto L59;
            if (r3 == ErrorMode.IMMEDIATE) goto L64;
        L67:
            boolean r13 = r0.isDone();
            boolean r14 = r11.isEmpty();
            if (r13 == false) goto L71;
            if (r14 == false) goto L71;
            this.current = null;
            this.upstream.request(1);
            r0 = null;
            r4 = true;
            goto L71
        L64:
            if (this.errors.get() == null) goto L67;
            this.current = null;
            r0.cancel();
            cancelAll();
            r2.onError(this.errors.terminate());
            return;
        L59:
            cancelAll();
            return;
        L49:
            if (r10 == true) goto L55;
            r2.onNext(r9);
            r12 = r12 + 1;
            r0.requestOne();
            r5 = r16;
            goto L29
        L45:
            r10 = false;
        L52:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.current = null;
            r0.cancel();
            cancelAll();
            r2.onError(th);
            return;
        L38:
            if (this.errors.get() == null) goto L41;
            this.current = null;
            r0.cancel();
            cancelAll();
            r2.onError(this.errors.terminate());
            return;
        L33:
            cancelAll();
            return;
        L55:
            r4 = false;
        L72:
            r16 = r5;
            r4 = false;
            r7 = 0;
            r12 = 0;
            goto L74
        L9:
            if (r3 != ErrorMode.END) goto L11;
        L14:
            boolean r8 = this.done;
            r0 = this.subscribers.poll();
            if (r8 == false) goto L22;
            if (r0 != null) goto L22;
            Throwable r15 = this.errors.terminate();
            if (r15 == null) goto L20;
            r2.onError(r15);
            return;
        L20:
            r2.onComplete();
            return;
        L22:
            if (r0 == null) goto L25;
            this.current = r0;
            goto L25
        L11:
            if (this.errors.get() == null) goto L14;
            cancelAll();
            r2.onError(this.errors.terminate());
        }

        public void drainAndCancel() {
            if (getAndIncrement() != 0) goto L6;
        L4:
            cancelAll();
            if (decrementAndGet() != 0) goto L4;
            return;
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerComplete(InnerQueuedSubscriber<R> r1) {
            r1.setDone();
            drain();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerError(InnerQueuedSubscriber<R> r2, Throwable r3) {
            if (this.errors.addThrowable(r3) == false) goto L8;
            r2.setDone();
            if (this.errorMode == ErrorMode.END) goto L7;
            this.upstream.cancel();
        L7:
            drain();
            return;
        L8:
            RxJavaPlugins.onError(r3);
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerNext(InnerQueuedSubscriber<R> r2, R r3) {
            if (r2.queue().offer(r3) == false) goto L5;
            drain();
            return;
        L5:
            r2.cancel();
            innerError(r2, new MissingBackpressureException());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            Publisher r4 = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(r3), "The mapper returned a null Publisher");     // Catch: Throwable -> L10
            InnerQueuedSubscriber<R> r0 = new InnerQueuedSubscriber(this, this.prefetch);
            if (this.cancelled == false) goto L6;
            return;
        L6:
            this.subscribers.offer(r0);
            r4.subscribe(r0);
            if (this.cancelled == false) goto L15;
            r0.cancel();
            drainAndCancel();
            return;
        L15:
            return;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L10;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            int r2 = this.maxConcurrency;
            if (r2 != Integer.MAX_VALUE) goto L7;
            long r0 = Long.MAX_VALUE;
        L8:
            r3.request(r0);
            return;
        L7:
            r0 = r2;
            goto L8
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }
    }

    public FlowableConcatMapEager(Flowable<T> r1, Function<? super T, ? extends Publisher<? extends R>> r2, int r3, int r4, ErrorMode r5) {
        super(r1);
        this.mapper = r2;
        this.maxConcurrency = r3;
        this.prefetch = r4;
        this.errorMode = r5;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> r9) {
        this.source.subscribe(new ConcatMapEagerDelayErrorSubscriber(r9, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableZip<T, R> extends Flowable<R> {
    final int bufferSize;
    final boolean delayError;
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final Subscriber<? super R> downstream;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final Function<? super Object[], ? extends R> zipper;

        ZipCoordinator(Subscriber<? super R> r1, Function<? super Object[], ? extends R> r2, int r3, int r4, boolean r5) {
            this.downstream = r1;
            this.zipper = r2;
            this.delayErrors = r5;
            ZipSubscriber<T, R>[] r6 = new ZipSubscriber[r3];
            int r7 = 0;
        L3:
            if (r7 >= r3) goto L5;
            r6[r7] = new ZipSubscriber(this, r4);
            r7 = r7 + 1;
            goto L3
        L5:
            this.current = new Object[r3];
            this.subscribers = r6;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        void subscribe(Publisher<? extends T>[] r5, int r6) {
            ZipSubscriber<T, R>[] r0 = this.subscribers;
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L12;
            if (this.cancelled == true) goto L18;
            if (this.delayErrors == true) goto L11;
            if (this.errors.get() == null) goto L11;
            return;
        L11:
            r5[r1].subscribe(r0[r1]);
            r1 = r1 + 1;
            goto L3
        L18:
            return;
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
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            cancelAll();
            return;
        }

        void error(ZipSubscriber<T, R> r2, Throwable r3) {
            if (this.errors.addThrowable(r3) == false) goto L5;
            r2.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        void cancelAll() {
            ZipSubscriber<T, R>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L3
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super R> r2 = this.downstream;
            ZipSubscriber<T, R>[] r3 = this.subscribers;
            int r4 = r3.length;
            Object[] r5 = this.current;
            int r7 = 1;
        L6:
            long r8 = this.requested.get();
            long r12 = 0;
        L8:
            if (r8 == r12) goto L53;
            if (this.cancelled == true) goto L11;
            if (this.delayErrors == false) goto L15;
        L18:
            boolean r0 = false;
            int r6 = 0;
        L19:
            if (r6 >= r4) goto L46;
            ZipSubscriber<T, R> r10 = r3[r6];
            if (r5[r6] != null) goto L45;
            boolean r11 = r10.done;     // Catch: Throwable -> L39
            SimpleQueue<T> r13 = r10.queue;     // Catch: Throwable -> L39
            if (r13 == null) goto L25;
            T r14 = r13.poll();     // Catch: Throwable -> L39
        L26:
            if (r14 != null) goto L28;
            boolean r17 = true;
        L29:
            if (r11 == false) goto L36;
            if (r17 == false) goto L36;
            cancelAll();     // Catch: Throwable -> L39
            if (this.errors.get() == null) goto L34;
            r2.onError(this.errors.terminate());     // Catch: Throwable -> L39
            return;
        L34:
            r2.onComplete();     // Catch: Throwable -> L39
            return;
        L36:
            if (r17 == true) goto L44;
            r5[r6] = r14;     // Catch: Throwable -> L39
        L44:
            r0 = true;
            goto L45
        L28:
            r17 = false;
            goto L29
        L25:
            r14 = null;
        L39:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.errors.addThrowable(th);
            if (this.delayErrors == true) goto L44;
            cancelAll();
            r2.onError(this.errors.terminate());
            return;
        L45:
            r6 = r6 + 1;
            goto L19
        L46:
            if (r0 == true) goto L53;
            r2.onNext((Object) ObjectHelper.requireNonNull(this.zipper.apply(r5.clone()), "The zipper returned a null value"));
            r12 = r12 + 1;
            Arrays.fill(r5, null);
        L50:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancelAll();
            this.errors.addThrowable(th);
            r2.onError(this.errors.terminate());
            return;
        L15:
            if (this.errors.get() == null) goto L18;
            cancelAll();
            r2.onError(this.errors.terminate());
            return;
        L11:
            return;
        L53:
            if (r8 != r12) goto L91;
            if (this.cancelled == true) goto L56;
            if (this.delayErrors == false) goto L60;
        L63:
            int r9 = 0;
        L64:
            if (r9 >= r4) goto L91;
            ZipSubscriber<T, R> r1 = r3[r9];
            if (r5[r9] != null) goto L89;
            boolean r15 = r1.done;     // Catch: Throwable -> L84
            SimpleQueue<T> r16 = r1.queue;     // Catch: Throwable -> L84
            if (r16 == null) goto L70;
            T r18 = r16.poll();     // Catch: Throwable -> L84
        L71:
            if (r18 != null) goto L73;
            boolean r19 = true;
        L74:
            if (r15 == false) goto L81;
            if (r19 == false) goto L81;
            cancelAll();     // Catch: Throwable -> L84
            if (this.errors.get() == null) goto L79;
            r2.onError(this.errors.terminate());     // Catch: Throwable -> L84
            return;
        L79:
            r2.onComplete();     // Catch: Throwable -> L84
            return;
        L81:
            if (r19 == true) goto L89;
            r5[r9] = r18;     // Catch: Throwable -> L84
            goto L89
        L73:
            r19 = false;
            goto L74
        L70:
            r18 = null;
        L84:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.errors.addThrowable(th);
            if (this.delayErrors == true) goto L89;
            cancelAll();
            r2.onError(this.errors.terminate());
            return;
        L89:
            r9 = r9 + 1;
            goto L64
        L60:
            if (this.errors.get() == null) goto L63;
            cancelAll();
            r2.onError(this.errors.terminate());
            return;
        L56:
            return;
        L91:
            if (r12 == 0) goto L98;
            int r20 = r3.length;
            int r21 = 0;
        L93:
            if (r21 >= r20) goto L96;
            r3[r21].request(r12);
            r21 = r21 + 1;
            goto L93
        L96:
            if (r8 == Long.MAX_VALUE) goto L98;
            this.requested.addAndGet(-r12);
        L98:
            r7 = addAndGet(-r7);
            if (r7 != 0) goto L6;
        }
    }

    static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        int sourceMode;

        ZipSubscriber(ZipCoordinator<T, R> r1, int r2) {
            this.parent = r1;
            this.prefetch = r2;
            this.limit = r2 - (r2 >> 2);
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
            this.sourceMode = r1;
            this.queue = r0;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            r4.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            r4.request(this.prefetch);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.sourceMode == 2) goto L5;
            this.queue.offer(r3);
        L5:
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.parent.error(this, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r3) {
            if (this.sourceMode == 1) goto L9;
            long r0 = this.produced + r3;
            if (r0 < this.limit) goto L7;
            this.produced = 0;
            get().request(r0);
            return;
        L7:
            this.produced = r0;
            return;
        }
    }

    public FlowableZip(Publisher<? extends T>[] r1, Iterable<? extends Publisher<? extends T>> r2, Function<? super Object[], ? extends R> r3, int r4, boolean r5) {
        this.sources = r1;
        this.sourcesIterable = r2;
        this.zipper = r3;
        this.bufferSize = r4;
        this.delayError = r5;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> r10) {
        Publisher<? extends T>[] r0 = this.sources;
        if (r0 != null) goto L11;
        r0 = new Publisher[8];
        Iterator<? extends Publisher<? extends T>> r1 = this.sourcesIterable.iterator();
        int r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L12;
        Publisher<? extends T> r4 = r1.next();
        if (r3 != r0.length) goto L10;
        Publisher<? extends T>[] r5 = new Publisher[(r3 >> 2) + r3];
        System.arraycopy(r0, 0, r5, 0, r3);
        r0 = r5;
    L10:
        r0[r3] = r4;
        r3 = r3 + 1;
    L12:
        int r7 = r3;
        if (r7 != 0) goto L16;
        EmptySubscription.complete(r10);
        return;
    L16:
        ZipCoordinator r8 = new ZipCoordinator(r10, this.zipper, r7, this.bufferSize, this.delayError);
        r10.onSubscribe(r8);
        r8.subscribe(r0, r7);
        return;
    L11:
        r3 = r0.length;
        goto L12
    }
}

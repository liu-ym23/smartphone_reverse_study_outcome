package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableWindowBoundarySupplier<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int capacityHint;
    final Callable<? extends Publisher<B>> other;

    public static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, B> parent;

        public WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> r1) {
            this.parent = r1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.parent.innerComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.parent.innerError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B r1) {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            dispose();
            this.parent.innerNext(this);
        }
    }

    public static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        static final WindowBoundaryInnerSubscriber<Object, Object> BOUNDARY_DISPOSED = null;
        static final Object NEXT_WINDOW = null;
        private static final long serialVersionUID = 2233020065421370272L;
        final AtomicReference<WindowBoundaryInnerSubscriber<T, B>> boundarySubscriber;
        final int capacityHint;
        volatile boolean done;
        final Subscriber<? super Flowable<T>> downstream;
        long emitted;
        final AtomicThrowable errors;
        final Callable<? extends Publisher<B>> other;
        final MpscLinkedQueue<Object> queue;
        final AtomicLong requested;
        final AtomicBoolean stopWindows;
        Subscription upstream;
        UnicastProcessor<T> window;
        final AtomicInteger windows;

        static {
            BOUNDARY_DISPOSED = new WindowBoundaryInnerSubscriber(null);
            NEXT_WINDOW = new Object();
        }

        public WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> r1, int r2, Callable<? extends Publisher<B>> r3) {
            this.downstream = r1;
            this.capacityHint = r2;
            this.boundarySubscriber = new AtomicReference();
            this.windows = new AtomicInteger(1);
            this.queue = new MpscLinkedQueue();
            this.errors = new AtomicThrowable();
            this.stopWindows = new AtomicBoolean();
            this.other = r3;
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
            disposeBoundary();
            if (this.windows.decrementAndGet() != 0) goto L9;
            this.upstream.cancel();
            return;
        L9:
            return;
        }

        public void disposeBoundary() {
            AtomicReference<WindowBoundaryInnerSubscriber<T, B>> r1 = this.boundarySubscriber;
            WindowBoundaryInnerSubscriber<Object, Object> r0 = BOUNDARY_DISPOSED;
            WindowBoundaryInnerSubscriber<T, B> r2 = r1.getAndSet((WindowBoundaryInnerSubscriber<T, B>) r0);
            if (r2 == null) goto L7;
            if (r2 == r0) goto L8;
            r2.dispose();
            return;
        L8:
            return;
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super Flowable<T>> r0 = this.downstream;
            MpscLinkedQueue<Object> r1 = this.queue;
            AtomicThrowable r2 = this.errors;
            long r3 = this.emitted;
            int r6 = 1;
        L7:
            if (this.windows.get() == 0) goto L8;
            UnicastProcessor<T> r7 = this.window;
            boolean r9 = this.done;
            if (r9 == true) goto L13;
        L19:
            Object r10 = r1.poll();
            if (r10 != null) goto L22;
            boolean r11 = true;
        L23:
            if (r9 == false) goto L34;
            if (r11 == false) goto L34;
            Throwable r4 = r2.terminate();
            if (r4 != null) goto L30;
            if (r7 == null) goto L29;
            this.window = null;
            r7.onComplete();
        L29:
            r0.onComplete();
            return;
        L30:
            if (r7 == null) goto L32;
            this.window = null;
            r7.onError(r4);
        L32:
            r0.onError(r4);
            return;
        L34:
            if (r11 == true) goto L35;
            if (r10 != NEXT_WINDOW) goto L40;
            if (r7 == null) goto L44;
            this.window = null;
            r7.onComplete();
        L44:
            if (this.stopWindows.get() == true) goto L7;
            if (r3 != this.requested.get()) goto L47;
            this.upstream.cancel();
            disposeBoundary();
            r2.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
            this.done = true;
            goto L7
        L47:
            UnicastProcessor<T> r8 = UnicastProcessor.create(this.capacityHint, this);
            this.window = r8;
            this.windows.getAndIncrement();
            Publisher r12 = (Publisher) ObjectHelper.requireNonNull(this.other.call(), "The other Callable returned a null Publisher");     // Catch: Throwable -> L52
            WindowBoundaryInnerSubscriber<T, B> r13 = new WindowBoundaryInnerSubscriber(this);
            if (this.boundarySubscriber.compareAndSet(null, r13) == false) goto L7;
            r12.subscribe(r13);
            r3 = r3 + 1;
            r0.onNext(r8);
        L52:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2.addThrowable(th);
            this.done = true;
            goto L7
        L40:
            r7.onNext((T) r10);
            goto L7
        L35:
            this.emitted = r3;
            r6 = addAndGet(-r6);
            if (r6 != 0) goto L7;
            return;
        L22:
            r11 = false;
            goto L23
        L13:
            if (r2.get() == null) goto L19;
            r1.clear();
            Throwable r5 = r2.terminate();
            if (r7 == null) goto L17;
            this.window = null;
            r7.onError(r5);
        L17:
            r0.onError(r5);
            return;
        L8:
            r1.clear();
            this.window = null;
        }

        public void innerComplete() {
            this.upstream.cancel();
            this.done = true;
            drain();
        }

        public void innerError(Throwable r2) {
            this.upstream.cancel();
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        public void innerNext(WindowBoundaryInnerSubscriber<T, B> r3) {
            this.boundarySubscriber.compareAndSet(r3, null);
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            disposeBoundary();
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            disposeBoundary();
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            this.queue.offer(NEXT_WINDOW);
            drain();
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            BackpressureHelper.add(this.requested, r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() != 0) goto L6;
            this.upstream.cancel();
            return;
        }
    }

    public FlowableWindowBoundarySupplier(Flowable<T> r1, Callable<? extends Publisher<B>> r2, int r3) {
        super(r1);
        this.other = r2;
        this.capacityHint = r3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> r4) {
        WindowBoundaryMainSubscriber r0 = new WindowBoundaryMainSubscriber(r4, this.capacityHint, this.other);
        this.source.subscribe(r0);
    }
}

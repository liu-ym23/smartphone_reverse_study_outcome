package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final Function<? super B, ? extends Publisher<V>> close;
    final Publisher<B> open;

    static final class OperatorWindowBoundaryCloseSubscriber<T, V> extends DisposableSubscriber<V> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, ?, V> parent;
        final UnicastProcessor<T> w;

        OperatorWindowBoundaryCloseSubscriber(WindowBoundaryMainSubscriber<T, ?, V> r1, UnicastProcessor<T> r2) {
            this.parent = r1;
            this.w = r2;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(V r1) {
            cancel();
            onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.parent.error(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.parent.close(this);
        }
    }

    static final class OperatorWindowBoundaryOpenSubscriber<T, B> extends DisposableSubscriber<B> {
        final WindowBoundaryMainSubscriber<T, B, ?> parent;

        OperatorWindowBoundaryOpenSubscriber(WindowBoundaryMainSubscriber<T, B, ?> r1) {
            this.parent = r1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B r1) {
            this.parent.open(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.parent.error(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.onComplete();
        }
    }

    static final class WindowBoundaryMainSubscriber<T, B, V> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final AtomicReference<Disposable> boundary;
        final int bufferSize;
        final Function<? super B, ? extends Publisher<V>> close;
        final Publisher<B> open;
        final CompositeDisposable resources;
        final AtomicBoolean stopWindows;
        Subscription upstream;
        final AtomicLong windows;
        final List<UnicastProcessor<T>> ws;

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public boolean accept(Subscriber<? super Flowable<T>> r1, Object r2) {
            return false;
        }

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> r2, Publisher<B> r3, Function<? super B, ? extends Publisher<V>> r4, int r5) {
            super(r2, new MpscLinkedQueue());
            this.boundary = new AtomicReference();
            AtomicLong r6 = new AtomicLong();
            this.windows = r6;
            this.stopWindows = new AtomicBoolean();
            this.open = r3;
            this.close = r4;
            this.bufferSize = r5;
            this.resources = new CompositeDisposable();
            this.ws = new ArrayList();
            r6.lazySet(1);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L11;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            if (this.stopWindows.get() == false) goto L7;
            return;
        L7:
            OperatorWindowBoundaryOpenSubscriber r0 = new OperatorWindowBoundaryOpenSubscriber(this);
            if (this.boundary.compareAndSet(null, r0) == false) goto L12;
            r4.request(Long.MAX_VALUE);
            this.open.subscribe(r0);
            return;
        L12:
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (fastEnter() == false) goto L14;
            Iterator<UnicastProcessor<T>> r0 = this.ws.iterator();
        L9:
            if (r0.hasNext() == false) goto L12;
            r0.next().onNext(r3);
            goto L9
        L12:
            if (leave(-1) != 0) goto L17;
            return;
        L17:
            drainLoop();
            return;
        L14:
            this.queue.offer((U) NotificationLite.next(r3));
            if (enter() == true) goto L17;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r5) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r5);
            return;
        L6:
            this.error = r5;
            this.done = true;
            if (enter() == false) goto L10;
            drainLoop();
        L10:
            if (this.windows.decrementAndGet() != 0) goto L12;
            this.resources.dispose();
        L12:
            this.downstream.onError(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            if (enter() == false) goto L9;
            drainLoop();
        L9:
            if (this.windows.decrementAndGet() != 0) goto L11;
            this.resources.dispose();
        L11:
            this.downstream.onComplete();
        }

        void error(Throwable r2) {
            this.upstream.cancel();
            this.resources.dispose();
            DisposableHelper.dispose(this.boundary);
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            requested(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
            DisposableHelper.dispose(this.boundary);
            if (this.windows.decrementAndGet() != 0) goto L9;
            this.upstream.cancel();
            return;
        L9:
            return;
        }

        void dispose() {
            this.resources.dispose();
            DisposableHelper.dispose(this.boundary);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            SimpleQueue r0 = this.queue;
            Subscriber<? super V> r1 = this.downstream;
            List<UnicastProcessor<T>> r2 = this.ws;
            int r4 = 1;
        L3:
            boolean r5 = this.done;
            Object r6 = r0.poll();
            if (r6 != null) goto L6;
            boolean r7 = true;
        L7:
            if (r5 == false) goto L21;
            if (r7 == false) goto L21;
            dispose();
            Throwable r11 = this.error;
            if (r11 == null) goto L15;
            Iterator<UnicastProcessor<T>> r3 = r2.iterator();
        L13:
            if (r3.hasNext() == false) goto L19;
            r3.next().onError(r11);
        L19:
            r2.clear();
            return;
        L15:
            Iterator<UnicastProcessor<T>> r12 = r2.iterator();
        L17:
            if (r12.hasNext() == false) goto L19;
            r12.next().onComplete();
        L21:
            if (r7 == true) goto L22;
            if ((r6 instanceof WindowOperation) == true) goto L27;
            Iterator<UnicastProcessor<T>> r8 = r2.iterator();
        L52:
            if (r8.hasNext() == false) goto L3;
            r8.next().onNext(NotificationLite.getValue(r6));
            goto L52
        L27:
            WindowOperation r9 = (WindowOperation) r6;
            if (r9.w != null) goto L30;
            if (this.stopWindows.get() == true) goto L3;
            UnicastProcessor<T> r10 = UnicastProcessor.create(this.bufferSize);
            long r13 = requested();
            if (r13 != 0) goto L40;
            cancel();
            r1.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
            goto L3
        L40:
            r2.add(r10);
            r1.onNext(r10);
            if (r13 == Long.MAX_VALUE) goto L54;
            produced(1);
        L54:
            Publisher r14 = (Publisher) ObjectHelper.requireNonNull(this.close.apply(r9.open), "The publisher supplied is null");     // Catch: Throwable -> L47
            OperatorWindowBoundaryCloseSubscriber r15 = new OperatorWindowBoundaryCloseSubscriber(this, r10);
            if (this.resources.add(r15) == false) goto L3;
            this.windows.getAndIncrement();
            r14.subscribe(r15);
        L47:
            th = move-exception;
            cancel();
            r1.onError(th);
            goto L3
        L30:
            if (r2.remove(r9.w) == false) goto L3;
            r9.w.onComplete();
            if (this.windows.decrementAndGet() != 0) goto L3;
            dispose();
            return;
        L22:
            r4 = leave(-r4);
            if (r4 != 0) goto L3;
            return;
        L6:
            r7 = false;
            goto L7
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void open(B r4) {
            this.queue.offer((U) new WindowOperation(null, r4));
            if (enter() == false) goto L6;
            drainLoop();
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void close(OperatorWindowBoundaryCloseSubscriber<T, V> r4) {
            this.resources.delete(r4);
            this.queue.offer((U) new WindowOperation(r4.w, null));
            if (enter() == false) goto L6;
            drainLoop();
            return;
        }
    }

    static final class WindowOperation<T, B> {
        final B open;
        final UnicastProcessor<T> w;

        WindowOperation(UnicastProcessor<T> r1, B r2) {
            this.w = r1;
            this.open = r2;
        }
    }

    public FlowableWindowBoundarySelector(Flowable<T> r1, Publisher<B> r2, Function<? super B, ? extends Publisher<V>> r3, int r4) {
        super(r1);
        this.open = r2;
        this.close = r3;
        this.bufferSize = r4;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> r5) {
        this.source.subscribe(new WindowBoundaryMainSubscriber(new SerializedSubscriber(r5), this.open, this.close, this.bufferSize));
    }
}

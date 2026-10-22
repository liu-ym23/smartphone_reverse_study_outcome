package io.reactivex.internal.operators.flowable;

import adcpeJava.adcpe.Constants;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableFlatMapSingle<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayErrors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final int maxConcurrency;

    static final class FlatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final boolean delayErrors;
        final Subscriber<? super R> downstream;
        final AtomicThrowable errors;
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;
        final int maxConcurrency;
        final AtomicReference<SpscLinkedArrayQueue<R>> queue;
        final AtomicLong requested;
        final CompositeDisposable set;
        Subscription upstream;

        final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;
            final /* synthetic */ FlatMapSingleSubscriber this$0;

            InnerObserver(FlatMapSingleSubscriber r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r2) {
                this.this$0.innerSuccess(this, r2);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable r2) {
                this.this$0.innerError(this, r2);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        FlatMapSingleSubscriber(Subscriber<? super R> r1, Function<? super T, ? extends SingleSource<? extends R>> r2, boolean r3, int r4) {
            this.downstream = r1;
            this.mapper = r2;
            this.delayErrors = r3;
            this.maxConcurrency = r4;
            this.requested = new AtomicLong();
            this.set = new CompositeDisposable();
            this.errors = new AtomicThrowable();
            this.active = new AtomicInteger(1);
            this.queue = new AtomicReference();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L9;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            int r2 = this.maxConcurrency;
            if (r2 != Integer.MAX_VALUE) goto L7;
            r3.request(Long.MAX_VALUE);
            return;
        L7:
            r3.request(r2);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            SingleSource r4 = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(r3), "The mapper returned a null SingleSource");     // Catch: Throwable -> L9
            this.active.getAndIncrement();
            InnerObserver r0 = new InnerObserver(this);
            if (this.cancelled == false) goto L6;
            return;
        L6:
            if (this.set.add(r0) == false) goto L15;
            r4.subscribe(r0);
            return;
        L15:
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.active.decrementAndGet();
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            this.set.dispose();
        L7:
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }

        void innerSuccess(FlatMapSingleSubscriber<T, R>.InnerObserver r5, R r6) {
            this.set.delete(r5);
            if (get() != 0) goto L34;
            boolean r7 = false;
            if (compareAndSet(0, 1) == false) goto L34;
            if (this.active.decrementAndGet() != 0) goto L10;
            r7 = true;
        L10:
            if (this.requested.get() == 0) goto L24;
            this.downstream.onNext(r6);
            SpscLinkedArrayQueue<R> r8 = this.queue.get();
            if (r7 == false) goto L21;
            if (r8 != null) goto L15;
        L16:
            Throwable r9 = this.errors.terminate();
            if (r9 == null) goto L19;
            this.downstream.onError(r9);
            return;
        L19:
            this.downstream.onComplete();
            return;
        L15:
            if (r8.isEmpty() == true) goto L16;
        L21:
            BackpressureHelper.produced(this.requested, 1);
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L29;
            this.upstream.request(1);
        L29:
            if (decrementAndGet() != 0) goto L41;
            return;
        L41:
            drainLoop();
            return;
        L24:
            SpscLinkedArrayQueue<R> r10 = getOrCreateQueue();
            monitor-enter(r10);
            r10.offer(r6);     // Catch: Throwable -> L31
            monitor-exit(r10);     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            throw th;
        L34:
            SpscLinkedArrayQueue<R> r11 = getOrCreateQueue();
            monitor-enter(r11);
            r11.offer(r6);     // Catch: Throwable -> L43
            monitor-exit(r11);     // Catch: Throwable -> L43
            this.active.decrementAndGet();
            if (getAndIncrement() == 0) goto L41;
            return;
        L43:
            th = move-exception;
            throw th;
        }

        SpscLinkedArrayQueue<R> getOrCreateQueue() {
        L2:
            SpscLinkedArrayQueue<R> r0 = this.queue.get();
            if (r0 != null) goto L4;
            SpscLinkedArrayQueue<R> r1 = new SpscLinkedArrayQueue(Flowable.bufferSize());
            if (this.queue.compareAndSet(null, r1) == false) goto L2;
            return r1;
        L4:
            return r0;
        }

        void innerError(FlatMapSingleSubscriber<T, R>.InnerObserver r3, Throwable r4) {
            this.set.delete(r3);
            if (this.errors.addThrowable(r4) == true) goto L5;
            RxJavaPlugins.onError(r4);
            return;
        L5:
            if (this.delayErrors == true) goto L8;
            this.upstream.cancel();
            this.set.dispose();
        L10:
            this.active.decrementAndGet();
            drain();
            return;
        L8:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L10;
            this.upstream.request(1);
            goto L10
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        void clear() {
            SpscLinkedArrayQueue<R> r0 = this.queue.get();
            if (r0 == null) goto L6;
            r0.clear();
            return;
        }

        void drainLoop() {
            Subscriber<? super R> r1 = this.downstream;
            AtomicInteger r2 = this.active;
            AtomicReference<SpscLinkedArrayQueue<R>> r3 = this.queue;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
            long r10 = 0;
        L4:
            boolean r13 = false;
            if (r10 == r6) goto L37;
            if (this.cancelled == true) goto L8;
            if (this.delayErrors == true) goto L17;
            if (this.errors.get() == null) goto L17;
            Throwable r4 = this.errors.terminate();
            clear();
            r1.onError(r4);
            return;
        L17:
            if (r2.get() != 0) goto L19;
            boolean r14 = true;
        L20:
            SpscLinkedArrayQueue<R> r15 = r3.get();
            if (r15 == null) goto L23;
            Constants r16 = r15.poll();
        L24:
            if (r16 != null) goto L26;
            boolean r17 = true;
        L27:
            if (r14 == false) goto L34;
            if (r17 == false) goto L34;
            Throwable r0 = this.errors.terminate();
            if (r0 == null) goto L32;
            r1.onError(r0);
            return;
        L32:
            r1.onComplete();
            return;
        L34:
            if (r17 == true) goto L37;
            r1.onNext(r16);
            r10 = r10 + 1;
            goto L4
        L26:
            r17 = false;
            goto L27
        L23:
            r16 = null;
            goto L24
        L19:
            r14 = false;
            goto L20
        L8:
            clear();
            return;
        L37:
            if (r10 != r6) goto L65;
            if (this.cancelled == true) goto L40;
            if (this.delayErrors == true) goto L49;
            if (this.errors.get() == null) goto L49;
            Throwable r7 = this.errors.terminate();
            clear();
            r1.onError(r7);
            return;
        L49:
            if (r2.get() != 0) goto L51;
            boolean r8 = true;
        L52:
            SpscLinkedArrayQueue<R> r9 = r3.get();
            if (r9 != null) goto L55;
        L56:
            r13 = true;
        L57:
            if (r8 == false) goto L65;
            if (r13 == false) goto L65;
            Throwable r11 = this.errors.terminate();
            if (r11 == null) goto L62;
            r1.onError(r11);
            return;
        L62:
            r1.onComplete();
            return;
        L55:
            if (r9.isEmpty() == false) goto L57;
        L51:
            r8 = false;
            goto L52
        L40:
            clear();
            return;
        L65:
            if (r10 == 0) goto L69;
            BackpressureHelper.produced(this.requested, r10);
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L69;
            this.upstream.request(r10);
        L69:
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L3;
        }
    }

    public FlowableFlatMapSingle(Flowable<T> r1, Function<? super T, ? extends SingleSource<? extends R>> r2, boolean r3, int r4) {
        super(r1);
        this.mapper = r2;
        this.delayErrors = r3;
        this.maxConcurrency = r4;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r5) {
        this.source.subscribe(new FlatMapSingleSubscriber(r5, this.mapper, this.delayErrors, this.maxConcurrency));
    }
}

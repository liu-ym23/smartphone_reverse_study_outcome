package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final int prefetch;
    final Flowable<T> source;

    static final class ConcatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        long emitted;
        final ErrorMode errorMode;
        final AtomicThrowable errors;
        final ConcatMapMaybeObserver<R> inner;
        R item;
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        final int prefetch;
        final SimplePlainQueue<T> queue;
        final AtomicLong requested;
        volatile int state;
        Subscription upstream;

        static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapMaybeSubscriber<?, R> parent;

            ConcatMapMaybeObserver(ConcatMapMaybeSubscriber<?, R> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.replace(this, r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r1) {
                this.parent.innerSuccess(r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable r1) {
                this.parent.innerError(r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        ConcatMapMaybeSubscriber(Subscriber<? super R> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, int r3, ErrorMode r4) {
            this.downstream = r1;
            this.mapper = r2;
            this.prefetch = r3;
            this.errorMode = r4;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
            this.inner = new ConcatMapMaybeObserver(this);
            this.queue = new SpscArrayQueue(r3);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(this.prefetch);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.queue.offer(r2) == true) goto L6;
            this.upstream.cancel();
            onError(new MissingBackpressureException("queue full?!"));
            return;
        L6:
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
            this.inner.dispose();
        L7:
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            BackpressureHelper.add(this.requested, r2);
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.inner.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            this.item = null;
            return;
        }

        void innerSuccess(R r1) {
            this.item = r1;
            this.state = 2;
            drain();
        }

        void innerComplete() {
            this.state = 0;
            drain();
        }

        void innerError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.errorMode == ErrorMode.END) goto L7;
            this.upstream.cancel();
        L7:
            this.state = 0;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super R> r0 = this.downstream;
            ErrorMode r1 = this.errorMode;
            SimplePlainQueue<T> r2 = this.queue;
            AtomicThrowable r3 = this.errors;
            AtomicLong r4 = this.requested;
            int r5 = this.prefetch;
            int r6 = r5 - (r5 >> 1);
            int r7 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            int r8 = this.state;
            if (r3.get() == null) goto L19;
            if (r1 == ErrorMode.IMMEDIATE) goto L16;
            if (r1 != ErrorMode.BOUNDARY) goto L19;
            if (r8 != 0) goto L19;
        L16:
            r2.clear();
            this.item = null;
            r0.onError(r3.terminate());
            return;
        L19:
            if (r8 == 0) goto L20;
            if (r8 != 2) goto L47;
            long r11 = this.emitted;
            if (r11 == r4.get()) goto L47;
            R r9 = this.item;
            this.item = null;
            r0.onNext(r9);
            this.emitted = r11 + 1;
            this.state = 0;
        L47:
            r7 = addAndGet(-r7);
            if (r7 != 0) goto L7;
            return;
        L20:
            boolean r10 = this.done;
            T r12 = r2.poll();
            if (r12 != null) goto L23;
            boolean r13 = true;
        L24:
            if (r10 == false) goto L31;
            if (r13 == false) goto L31;
            Throwable r15 = r3.terminate();
            if (r15 != null) goto L29;
            r0.onComplete();
            return;
        L29:
            r0.onError(r15);
            return;
        L31:
            if (r13 == true) goto L47;
            int r14 = this.consumed + 1;
            if (r14 != r6) goto L36;
            this.consumed = 0;
            this.upstream.request(r6);
        L50:
            MaybeSource r16 = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(r12), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L39
            this.state = 1;
            r16.subscribe(this.inner);
        L39:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            r2.clear();
            r3.addThrowable(th);
            r0.onError(r3.terminate());
            return;
        L36:
            this.consumed = r14;
            goto L50
        L23:
            r13 = false;
            goto L24
        L8:
            r2.clear();
            this.item = null;
            goto L47
        }
    }

    public FlowableConcatMapMaybe(Flowable<T> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, ErrorMode r3, int r4) {
        this.source = r1;
        this.mapper = r2;
        this.errorMode = r3;
        this.prefetch = r4;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r5) {
        this.source.subscribe(new ConcatMapMaybeSubscriber(r5, this.mapper, this.prefetch, this.errorMode));
    }
}

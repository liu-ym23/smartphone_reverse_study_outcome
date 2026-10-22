package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, ? extends Publisher<U>> debounceSelector;

    static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;
        final Function<? super T, ? extends Publisher<U>> debounceSelector;
        final AtomicReference<Disposable> debouncer;
        boolean done;
        final Subscriber<? super T> downstream;
        volatile long index;
        Subscription upstream;

        static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {
            boolean done;
            final long index;
            final AtomicBoolean once;
            final DebounceSubscriber<T, U> parent;
            final T value;

            DebounceInnerSubscriber(DebounceSubscriber<T, U> r2, long r3, T r5) {
                this.once = new AtomicBoolean();
                this.parent = r2;
                this.index = r3;
                this.value = r5;
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(U r1) {
                if (this.done == false) goto L5;
                return;
            L5:
                this.done = true;
                cancel();
                emit();
            }

            void emit() {
                if (this.once.compareAndSet(false, true) == false) goto L6;
                this.parent.emit(this.index, this.value);
                return;
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable r2) {
                if (this.done == false) goto L6;
                RxJavaPlugins.onError(r2);
                return;
            L6:
                this.done = true;
                this.parent.onError(r2);
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (this.done == false) goto L5;
                return;
            L5:
                this.done = true;
                emit();
            }
        }

        DebounceSubscriber(Subscriber<? super T> r2, Function<? super T, ? extends Publisher<U>> r3) {
            this.debouncer = new AtomicReference();
            this.downstream = r2;
            this.debounceSelector = r3;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r6) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.index + 1;
            this.index = r0;
            Disposable r2 = this.debouncer.get();
            if (r2 == null) goto L16;
            r2.dispose();
        L16:
            Publisher r3 = (Publisher) ObjectHelper.requireNonNull(this.debounceSelector.apply(r6), "The publisher supplied is null");     // Catch: Throwable -> L13
            DebounceInnerSubscriber r4 = new DebounceInnerSubscriber(this, r0, r6);
            if (b0$$ExternalSyntheticBackport0.m(this.debouncer, r2, r4) == false) goto L18;
            r3.subscribe(r4);
            return;
        L18:
            return;
        L13:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            Disposable r0 = this.debouncer.get();
            if (DisposableHelper.isDisposed(r0) == true) goto L12;
            DebounceInnerSubscriber r1 = (DebounceInnerSubscriber) r0;
            if (r1 == null) goto L10;
            r1.emit();
        L10:
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onComplete();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this, r2);
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this.debouncer);
        }

        void emit(long r3, T r5) {
            if (r3 == this.index) goto L5;
            return;
        L5:
            if (get() == 0) goto L7;
            this.downstream.onNext(r5);
            BackpressureHelper.produced(this, 1);
            return;
        L7:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }
    }

    public FlowableDebounce(Flowable<T> r1, Function<? super T, ? extends Publisher<U>> r2) {
        super(r1);
        this.debounceSelector = r2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r4) {
        this.source.subscribe(new DebounceSubscriber(new SerializedSubscriber(r4), this.debounceSelector));
    }
}

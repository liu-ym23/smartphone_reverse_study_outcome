package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableGenerate<T, S> extends Flowable<T> {
    final Consumer<? super S> disposeState;
    final BiFunction<S, Emitter<T>, S> generator;
    final Callable<S> stateSupplier;

    static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;
        volatile boolean cancelled;
        final Consumer<? super S> disposeState;
        final Subscriber<? super T> downstream;
        final BiFunction<S, ? super Emitter<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        GeneratorSubscription(Subscriber<? super T> r1, BiFunction<S, ? super Emitter<T>, S> r2, Consumer<? super S> r3, S r4) {
            this.downstream = r1;
            this.generator = r2;
            this.disposeState = r3;
            this.state = r4;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == true) goto L6;
            return;
        L6:
            if (BackpressureHelper.add(this, r10) == 0) goto L8;
            return;
        L8:
            S r0 = this.state;
            BiFunction<S, ? super Emitter<T>, S> r1 = this.generator;
        L9:
            long r4 = 0;
        L11:
            if (r4 != r10) goto L13;
            r10 = get();
            if (r4 != r10) goto L11;
            this.state = r0;
            r10 = addAndGet(-r4);
            if (r10 != 0) goto L9;
            return;
        L13:
            if (this.cancelled == true) goto L14;
            this.hasNext = false;
            r0 = r1.apply(r0, this);     // Catch: Throwable -> L23
            if (this.terminate == true) goto L20;
            r4 = r4 + 1;
            goto L11
        L20:
            this.cancelled = true;
            this.state = null;
            dispose(r0);
            return;
        L23:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            this.state = null;
            onError(th);
            dispose(r0);
            return;
        L14:
            this.state = null;
            dispose(r0);
        }

        private void dispose(S r1) {
            this.disposeState.accept(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            if (BackpressureHelper.add(this, 1) != 0) goto L9;
            S r0 = this.state;
            this.state = null;
            dispose(r0);
            return;
        L9:
            return;
        }

        @Override // io.reactivex.Emitter
        public void onNext(T r2) {
            if (this.terminate == false) goto L5;
            return;
        L5:
            if (this.hasNext == false) goto L7;
            onError(new IllegalStateException("onNext already called in this generate turn"));
            return;
        L7:
            if (r2 != null) goto L9;
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        L9:
            this.hasNext = true;
            this.downstream.onNext(r2);
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable r2) {
            if (this.terminate == false) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (r2 != null) goto L7;
            r2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L7:
            this.terminate = true;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.terminate == true) goto L6;
            this.terminate = true;
            this.downstream.onComplete();
            return;
        }
    }

    public FlowableGenerate(Callable<S> r1, BiFunction<S, Emitter<T>, S> r2, Consumer<? super S> r3) {
        this.stateSupplier = r1;
        this.generator = r2;
        this.disposeState = r3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r4) {
        S r0 = this.stateSupplier.call();     // Catch: Throwable -> L5
        r4.onSubscribe(new GeneratorSubscription(r4, this.generator, this.disposeState, r0));
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r4);
    }
}

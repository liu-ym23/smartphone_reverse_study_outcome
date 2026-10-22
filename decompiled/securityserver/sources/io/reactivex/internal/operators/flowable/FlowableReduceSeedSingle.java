package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableReduceSeedSingle<T, R> extends Single<R> {
    final BiFunction<R, ? super T, R> reducer;
    final R seed;
    final Publisher<T> source;

    public static final class ReduceSeedObserver<T, R> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super R> downstream;
        final BiFunction<R, ? super T, R> reducer;
        Subscription upstream;
        R value;

        public ReduceSeedObserver(SingleObserver<? super R> r1, BiFunction<R, ? super T, R> r2, R r3) {
            this.downstream = r1;
            this.value = r3;
            this.reducer = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.upstream != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            R r0 = this.value;
            if (r0 == null) goto L6;
            this.value = null;
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onSuccess(r0);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.value == null) goto L5;
            this.value = null;
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError(r2);
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            R r0 = this.value;
            if (r0 == null) goto L11;
            this.value = (R) ObjectHelper.requireNonNull(this.reducer.apply(r0, r3), "The reducer returned a null value");     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }
    }

    public FlowableReduceSeedSingle(Publisher<T> r1, R r2, BiFunction<R, ? super T, R> r3) {
        this.source = r1;
        this.seed = r2;
        this.reducer = r3;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> r4) {
        this.source.subscribe(new ReduceSeedObserver(r4, this.reducer, this.seed));
    }
}

package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeFlatMapPublisher<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final MaybeSource<T> source;

    public static final class FlatMapPublisherSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = -8948264376121066672L;
        final Subscriber<? super R> downstream;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final AtomicLong requested;
        Disposable upstream;

        public FlatMapPublisherSubscriber(Subscriber<? super R> r1, Function<? super T, ? extends Publisher<? extends R>> r2) {
            this.downstream = r1;
            this.mapper = r2;
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r2) {
            ((Publisher) ObjectHelper.requireNonNull(this.mapper.apply(r2), "The mapper returned a null Publisher")).subscribe(this);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this, this.requested, r2);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, r2);
        }
    }

    public MaybeFlatMapPublisher(MaybeSource<T> r1, Function<? super T, ? extends Publisher<? extends R>> r2) {
        this.source = r1;
        this.mapper = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> r3) {
        this.source.subscribe(new FlatMapPublisherSubscriber(r3, this.mapper));
    }
}

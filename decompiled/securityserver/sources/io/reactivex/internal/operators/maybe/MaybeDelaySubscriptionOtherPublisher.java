package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> other;

    public static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 706635022205076709L;
        final MaybeObserver<? super T> downstream;

        public DelayMaybeObserver(MaybeObserver<? super T> r1) {
            this.downstream = r1;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }
    }

    public static final class OtherSubscriber<T> implements FlowableSubscriber<Object>, Disposable {
        final DelayMaybeObserver<T> main;
        MaybeSource<T> source;
        Subscription upstream;

        public OtherSubscriber(MaybeObserver<? super T> r2, MaybeSource<T> r3) {
            this.main = new DelayMaybeObserver(r2);
            this.source = r3;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
            DisposableHelper.dispose(this.main);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.main.get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscription r0 = this.upstream;
            SubscriptionHelper r1 = SubscriptionHelper.CANCELLED;
            if (r0 == r1) goto L6;
            this.upstream = r1;
            subscribeNext();
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            Subscription r0 = this.upstream;
            SubscriptionHelper r1 = SubscriptionHelper.CANCELLED;
            if (r0 == r1) goto L5;
            this.upstream = r1;
            this.main.downstream.onError(r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r2) {
            Subscription r3 = this.upstream;
            SubscriptionHelper r0 = SubscriptionHelper.CANCELLED;
            if (r3 == r0) goto L6;
            r3.cancel();
            this.upstream = r0;
            subscribeNext();
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.main.downstream.onSubscribe(this);
            r3.request(Long.MAX_VALUE);
            return;
        }

        public void subscribeNext() {
            MaybeSource<T> r0 = this.source;
            this.source = null;
            r0.subscribe(this.main);
        }
    }

    public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> r1, Publisher<U> r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> r3) {
        this.other.subscribe(new OtherSubscriber(r3, this.source));
    }
}

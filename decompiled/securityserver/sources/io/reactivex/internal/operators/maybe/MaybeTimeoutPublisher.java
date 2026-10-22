package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeTimeoutPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final MaybeSource<? extends T> fallback;
    final Publisher<U> other;

    public static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 8663801314800248617L;
        final MaybeObserver<? super T> downstream;

        public TimeoutFallbackMaybeObserver(MaybeObserver<? super T> r1) {
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

    public static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -5955289211445418871L;
        final MaybeObserver<? super T> downstream;
        final MaybeSource<? extends T> fallback;
        final TimeoutOtherMaybeObserver<T, U> other;
        final TimeoutFallbackMaybeObserver<T> otherObserver;

        public TimeoutMainMaybeObserver(MaybeObserver<? super T> r2, MaybeSource<? extends T> r3) {
            this.downstream = r2;
            this.other = new TimeoutOtherMaybeObserver(this);
            this.fallback = r3;
            if (r3 == null) goto L5;
            TimeoutFallbackMaybeObserver<T> r4 = new TimeoutFallbackMaybeObserver(r2);
        L6:
            this.otherObserver = r4;
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.other);
            TimeoutFallbackMaybeObserver<T> r1 = this.otherObserver;
            if (r1 == null) goto L6;
            DisposableHelper.dispose(r1);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            DisposableHelper r0 = DisposableHelper.DISPOSED;
            if (getAndSet(r0) == r0) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r3) {
            SubscriptionHelper.cancel(this.other);
            DisposableHelper r0 = DisposableHelper.DISPOSED;
            if (getAndSet(r0) == r0) goto L5;
            this.downstream.onError(r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r3) {
            SubscriptionHelper.cancel(this.other);
            DisposableHelper r0 = DisposableHelper.DISPOSED;
            if (getAndSet(r0) == r0) goto L6;
            this.downstream.onSuccess(r3);
            return;
        }

        public void otherComplete() {
            if (DisposableHelper.dispose(this) == false) goto L9;
            MaybeSource<? extends T> r0 = this.fallback;
            if (r0 != null) goto L7;
            this.downstream.onError(new TimeoutException());
            return;
        L7:
            r0.subscribe(this.otherObserver);
            return;
        }

        public void otherError(Throwable r2) {
            if (DisposableHelper.dispose(this) == false) goto L5;
            this.downstream.onError(r2);
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }
    }

    public static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 8663801314800248617L;
        final TimeoutMainMaybeObserver<T, U> parent;

        public TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> r1) {
            this.parent = r1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.parent.otherError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r1) {
            get().cancel();
            this.parent.otherComplete();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this, r3, Long.MAX_VALUE);
        }
    }

    public MaybeTimeoutPublisher(MaybeSource<T> r1, Publisher<U> r2, MaybeSource<? extends T> r3) {
        super(r1);
        this.other = r2;
        this.fallback = r3;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> r3) {
        TimeoutMainMaybeObserver r0 = new TimeoutMainMaybeObserver(r3, this.fallback);
        r3.onSubscribe(r0);
        this.other.subscribe(r0.other);
        this.source.subscribe(r0);
    }
}

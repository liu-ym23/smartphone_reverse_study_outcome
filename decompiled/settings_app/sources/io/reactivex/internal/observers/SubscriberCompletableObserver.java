package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {
    final Subscriber<? super T> subscriber;
    Disposable upstream;

    @Override // org.reactivestreams.Subscription
    public void request(long r1) {
    }

    public SubscriberCompletableObserver(Subscriber<? super T> r1) {
        this.subscriber = r1;
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        this.subscriber.onComplete();
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable r1) {
        this.subscriber.onError(r1);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r2) {
        if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
        this.upstream = r2;
        this.subscriber.onSubscribe(this);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.dispose();
    }
}

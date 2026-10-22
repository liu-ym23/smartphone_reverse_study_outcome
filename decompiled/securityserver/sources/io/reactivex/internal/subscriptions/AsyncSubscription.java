package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class AsyncSubscription extends AtomicLong implements Subscription, Disposable {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<Subscription> actual;
    final AtomicReference<Disposable> resource;

    public AsyncSubscription() {
        this.resource = new AtomicReference();
        this.actual = new AtomicReference();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.actual.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean replaceResource(Disposable r1) {
        return DisposableHelper.replace(this.resource, r1);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r2) {
        SubscriptionHelper.deferredRequest(this.actual, this, r2);
    }

    public boolean setResource(Disposable r1) {
        return DisposableHelper.set(this.resource, r1);
    }

    public void setSubscription(Subscription r2) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, r2);
    }

    public AsyncSubscription(Disposable r1) {
        this();
        this.resource.lazySet(r1);
    }
}

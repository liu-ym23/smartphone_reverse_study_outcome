package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ResourceSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    private final AtomicLong missedRequested;
    private final ListCompositeDisposable resources;
    private final AtomicReference<Subscription> upstream;

    public ResourceSubscriber() {
        this.upstream = new AtomicReference();
        this.resources = new ListCompositeDisposable();
        this.missedRequested = new AtomicLong();
    }

    public final void add(Disposable r2) {
        ObjectHelper.requireNonNull(r2, "resource is null");
        this.resources.add(r2);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (SubscriptionHelper.cancel(this.upstream) == false) goto L6;
        this.resources.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.upstream.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public void onStart() {
        request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription r6) {
        if (EndConsumerHelper.setOnce(this.upstream, r6, getClass()) == false) goto L9;
        long r3 = this.missedRequested.getAndSet(0);
        if (r3 == 0) goto L7;
        r6.request(r3);
    L7:
        onStart();
        return;
    }

    public final void request(long r2) {
        SubscriptionHelper.deferredRequest(this.upstream, this.missedRequested, r2);
    }
}

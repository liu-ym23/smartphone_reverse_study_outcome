package io.reactivex.internal.subscribers;

import a.a;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    final AtomicBoolean once;
    final AtomicLong requested;
    final AtomicReference<Subscription> upstream;

    public StrictSubscriber(Subscriber<? super T> r1) {
        this.downstream = r1;
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
        this.once = new AtomicBoolean();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.done == true) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        HalfSerializer.onComplete(this.downstream, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r3) {
        this.done = true;
        HalfSerializer.onError(this.downstream, r3, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r3) {
        HalfSerializer.onNext(this.downstream, r3, this, this.error);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r4) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        this.downstream.onSubscribe(this);
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r4);
        return;
    L5:
        r4.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r3) {
        if (r3 > 0) goto L5;
        cancel();
        onError(new IllegalArgumentException(a.h("§3.9 violated: positive request amount required but it was ", r3)));
        return;
    L5:
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r3);
    }
}

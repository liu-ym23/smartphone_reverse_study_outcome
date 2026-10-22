package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasicFuseableSubscriber<T, R> implements FlowableSubscriber<T>, QueueSubscription<R> {
    protected boolean done;
    protected final Subscriber<? super R> downstream;
    protected QueueSubscription<T> qs;
    protected int sourceMode;
    protected Subscription upstream;

    public BasicFuseableSubscriber(Subscriber<? super R> r1) {
        this.downstream = r1;
    }

    public void afterDownstream() {
    }

    public boolean beforeDownstream() {
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();
    }

    public void clear() {
        this.qs.clear();
    }

    public final void fail(Throwable r2) {
        Exceptions.throwIfFatal(r2);
        this.upstream.cancel();
        onError(r2);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r1) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r2) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r2);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r2);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription r2) {
        if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L11;
        this.upstream = r2;
        if ((r2 instanceof QueueSubscription) == false) goto L8;
        this.qs = (QueueSubscription) r2;
    L8:
        if (beforeDownstream() == false) goto L12;
        this.downstream.onSubscribe(this);
        afterDownstream();
        return;
    L12:
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r1) {
        this.upstream.request(r1);
    }

    public final int transitiveBoundaryFusion(int r3) {
        QueueSubscription<T> r0 = this.qs;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if ((r3 & 4) != 0) goto L12;
        int r4 = r0.requestFusion(r3);
        if (r4 == 0) goto L9;
        this.sourceMode = r4;
    L9:
        return r4;
    L12:
        return 0;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r1, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}

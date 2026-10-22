package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final InnerQueuedSubscriberSupport<T> parent;
    final int prefetch;
    long produced;
    volatile SimpleQueue<T> queue;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> r1, int r2) {
        this.parent = r1;
        this.prefetch = r2;
        this.limit = r2 - (r2 >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r2) {
        this.parent.innerError(this, r2);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r2) {
        if (this.fusionMode != 0) goto L5;
        this.parent.innerNext(this, r2);
        return;
    L5:
        this.parent.drain();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r4) {
        if (SubscriptionHelper.setOnce(this, r4) == true) goto L5;
        return;
    L5:
        if ((r4 instanceof QueueSubscription) == false) goto L14;
        QueueSubscription r0 = (QueueSubscription) r4;
        int r1 = r0.requestFusion(3);
        if (r1 != 1) goto L11;
        this.fusionMode = r1;
        this.queue = r0;
        this.done = true;
        this.parent.innerComplete(this);
        return;
    L11:
        if (r1 != 2) goto L14;
        this.fusionMode = r1;
        this.queue = r0;
        QueueDrainHelper.request(r4, this.prefetch);
        return;
    L14:
        this.queue = QueueDrainHelper.createQueue(this.prefetch);
        QueueDrainHelper.request(r4, this.prefetch);
    }

    public SimpleQueue<T> queue() {
        return this.queue;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r3) {
        if (this.fusionMode == 1) goto L9;
        long r0 = this.produced + r3;
        if (r0 < this.limit) goto L7;
        this.produced = 0;
        get().request(r0);
        return;
    L7:
        this.produced = r0;
        return;
    }

    public void requestOne() {
        if (this.fusionMode == 1) goto L9;
        long r0 = this.produced + 1;
        if (r0 != this.limit) goto L7;
        this.produced = 0;
        get().request(r0);
        return;
    L7:
        this.produced = r0;
        return;
    }

    public void setDone() {
        this.done = true;
    }
}

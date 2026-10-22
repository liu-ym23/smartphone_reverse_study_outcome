package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockingSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    public static final Object TERMINATED = null;
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    static {
        TERMINATED = new Object();
    }

    public BlockingSubscriber(Queue<Object> r1) {
        this.queue = r1;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r1) {
        if (SubscriptionHelper.setOnce(this, r1) == false) goto L6;
        this.queue.offer(NotificationLite.subscription(this));
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r1) {
        this.queue.offer(NotificationLite.next(r1));
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r1) {
        this.queue.offer(NotificationLite.error(r1));
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r1) {
        get().request(r1);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (SubscriptionHelper.cancel(this) == false) goto L6;
        this.queue.offer(TERMINATED);
        return;
    }

    public boolean isCancelled() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }
}

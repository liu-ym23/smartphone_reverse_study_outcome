package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final Subscriber<? super T> subscriber;
    final T value;

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r1) {
        return r1 & 1;
    }

    public ScalarSubscription(Subscriber<? super T> r1, T r2) {
        this.subscriber = r1;
        this.value = r2;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r1) {
        if (SubscriptionHelper.validate(r1) == true) goto L6;
        return;
    L6:
        if (compareAndSet(0, 1) == false) goto L11;
        Subscriber<? super T> r2 = this.subscriber;
        r2.onNext(this.value);
        if (get() == 2) goto L12;
        r2.onComplete();
        return;
    L12:
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        lazySet(2);
    }

    public boolean isCancelled() {
        if (get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T r1) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T r1, T r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public T poll() {
        if (get() != 0) goto L6;
        lazySet(1);
        return this.value;
    L6:
        return null;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (get() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        lazySet(1);
    }
}

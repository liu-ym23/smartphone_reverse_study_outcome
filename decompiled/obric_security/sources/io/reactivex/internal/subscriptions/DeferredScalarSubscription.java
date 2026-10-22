package io.reactivex.internal.subscriptions;

import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    static final int CANCELLED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    protected final Subscriber<? super T> downstream;
    protected T value;

    public DeferredScalarSubscription(Subscriber<? super T> r1) {
        this.downstream = r1;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long r1) {
        if (SubscriptionHelper.validate(r1) == false) goto L19;
    L4:
        int r2 = get();
        if ((r2 & (-2)) != 0) goto L6;
        if (r2 == 1) goto L10;
        if (compareAndSet(0, 2) == false) goto L4;
        return;
    L10:
        if (compareAndSet(1, 3) == false) goto L24;
        T r3 = this.value;
        if (r3 == null) goto L25;
        this.value = null;
        Subscriber<? super T> r4 = this.downstream;
        r4.onNext(r3);
        if (get() == 4) goto L26;
        r4.onComplete();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L6:
        return;
    }

    public final void complete(T r4) {
        int r0 = get();
    L4:
        if (r0 == 8) goto L5;
        if ((r0 & (-3)) != 0) goto L11;
        if (r0 == 2) goto L14;
        this.value = r4;
        if (compareAndSet(0, 1) == true) goto L20;
        r0 = get();
        if (r0 != 4) goto L4;
        this.value = null;
        return;
    L20:
        return;
    L14:
        lazySet(3);
        Subscriber<? super T> r1 = this.downstream;
        r1.onNext(r4);
        if (get() == 4) goto L32;
        r1.onComplete();
        return;
    L32:
        return;
    L11:
        return;
    L5:
        this.value = r4;
        lazySet(16);
        Subscriber<? super T> r2 = this.downstream;
        r2.onNext(r4);
        if (get() == 4) goto L31;
        r2.onComplete();
        return;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int requestFusion(int r2) {
        if ((r2 & 2) == 0) goto L6;
        lazySet(8);
        return 2;
    L6:
        return 0;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final T poll() {
        if (get() != 16) goto L6;
        lazySet(32);
        T r0 = this.value;
        this.value = null;
        return r0;
    L6:
        return null;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        if (get() == 16) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    public final boolean isCancelled() {
        if (get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean tryCancel() {
        if (getAndSet(4) == 4) goto L5;
        return true;
    L5:
        return false;
    }
}

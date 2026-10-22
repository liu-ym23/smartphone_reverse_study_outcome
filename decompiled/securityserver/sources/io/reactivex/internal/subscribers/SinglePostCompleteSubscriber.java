package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final Subscriber<? super R> downstream;
    protected long produced;
    protected Subscription upstream;
    protected R value;

    public SinglePostCompleteSubscriber(Subscriber<? super R> r1) {
        this.downstream = r1;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public final void complete(R r9) {
        long r0 = this.produced;
        if (r0 == 0) goto L5;
        BackpressureHelper.produced(this, r0);
    L5:
        long r1 = get();
        if ((r1 & COMPLETE_MASK) != 0) goto L7;
        if ((r1 & REQUEST_MASK) != 0) goto L11;
        this.value = r9;
        if (compareAndSet(0, COMPLETE_MASK) == true) goto L15;
        this.value = null;
        goto L5
    L15:
        return;
    L11:
        lazySet(-9223372036854775807L);
        this.downstream.onNext(r9);
        this.downstream.onComplete();
        return;
    L7:
        onDrop(r9);
    }

    public void onDrop(R r1) {
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r2) {
        if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
        this.upstream = r2;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long r9) {
        if (SubscriptionHelper.validate(r9) == false) goto L16;
    L4:
        long r0 = get();
        if ((r0 & COMPLETE_MASK) != 0) goto L7;
        if (compareAndSet(r0, BackpressureHelper.addCap(r0, r9)) == false) goto L4;
        this.upstream.request(r9);
        return;
    L7:
        if (compareAndSet(COMPLETE_MASK, -9223372036854775807L) == false) goto L17;
        this.downstream.onNext(this.value);
        this.downstream.onComplete();
        return;
    L17:
        return;
    }
}

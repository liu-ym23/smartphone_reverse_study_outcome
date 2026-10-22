package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableNever extends Flowable<Object> {
    public static final Flowable<Object> INSTANCE = null;

    static {
        INSTANCE = new FlowableNever();
    }

    private FlowableNever() {
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Object> r1) {
        r1.onSubscribe(EmptySubscription.INSTANCE);
    }
}

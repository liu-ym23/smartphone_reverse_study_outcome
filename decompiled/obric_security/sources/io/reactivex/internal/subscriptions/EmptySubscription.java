package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final enum EmptySubscription extends Enum<EmptySubscription> implements QueueSubscription<Object> {
    private static final /* synthetic */ EmptySubscription[] $VALUES = null;
    public static final EmptySubscription INSTANCE = null;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        return null;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r1) {
        return r1 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    private EmptySubscription(String r1, int r2) {
        super(r1, r2);
    }

    public static EmptySubscription valueOf(String r1) {
        return (EmptySubscription) Enum.valueOf(EmptySubscription.class, r1);
    }

    public static EmptySubscription[] values() {
        return (EmptySubscription[]) $VALUES.clone();
    }

    static {
        EmptySubscription r0 = new EmptySubscription("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new EmptySubscription[]{r0};
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r1) {
        SubscriptionHelper.validate(r1);
    }

    public static void error(Throwable r1, Subscriber<?> r2) {
        r2.onSubscribe(INSTANCE);
        r2.onError(r1);
    }

    public static void complete(Subscriber<?> r1) {
        r1.onSubscribe(INSTANCE);
        r1.onComplete();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r1) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r1, Object r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}

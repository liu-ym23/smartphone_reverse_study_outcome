package io.reactivex.internal.subscribers;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    public BlockingLastSubscriber() {
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r1) {
        this.value = r1;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r2) {
        this.value = null;
        this.error = r2;
        countDown();
    }
}

package org.reactivestreams;

/* JADX INFO: loaded from: classes2.dex */
public interface Subscriber<T> {
    void onComplete();

    void onError(Throwable r1);

    void onNext(T r1);

    void onSubscribe(Subscription r1);
}

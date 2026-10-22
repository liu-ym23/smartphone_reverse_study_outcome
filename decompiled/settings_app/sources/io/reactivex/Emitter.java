package io.reactivex;

/* JADX INFO: loaded from: classes5.dex */
public interface Emitter<T> {
    void onComplete();

    void onError(Throwable r1);

    void onNext(T r1);
}

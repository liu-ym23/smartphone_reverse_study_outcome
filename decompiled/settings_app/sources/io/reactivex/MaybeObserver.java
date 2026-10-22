package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes5.dex */
public interface MaybeObserver<T> {
    void onComplete();

    void onError(Throwable r1);

    void onSubscribe(Disposable r1);

    void onSuccess(T r1);
}

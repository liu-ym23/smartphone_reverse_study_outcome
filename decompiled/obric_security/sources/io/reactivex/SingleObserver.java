package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public interface SingleObserver<T> {
    void onError(Throwable r1);

    void onSubscribe(Disposable r1);

    void onSuccess(T r1);
}

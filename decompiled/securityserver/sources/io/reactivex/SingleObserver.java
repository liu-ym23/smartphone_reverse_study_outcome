package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes2.dex */
public interface SingleObserver<T> {
    void onError(@NonNull Throwable r1);

    void onSubscribe(@NonNull Disposable r1);

    void onSuccess(@NonNull T r1);
}

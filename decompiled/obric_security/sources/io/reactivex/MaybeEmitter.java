package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

/* JADX INFO: loaded from: classes3.dex */
public interface MaybeEmitter<T> {
    boolean isDisposed();

    void onComplete();

    void onError(Throwable r1);

    void onSuccess(T r1);

    void setCancellable(Cancellable r1);

    void setDisposable(Disposable r1);

    boolean tryOnError(Throwable r1);
}

package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

/* JADX INFO: loaded from: classes2.dex */
public interface MaybeEmitter<T> {
    boolean isDisposed();

    void onComplete();

    void onError(@NonNull Throwable r1);

    void onSuccess(@NonNull T r1);

    void setCancellable(@Nullable Cancellable r1);

    void setDisposable(@Nullable Disposable r1);

    boolean tryOnError(@NonNull Throwable r1);
}

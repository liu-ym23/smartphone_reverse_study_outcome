package io.reactivex;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface Emitter<T> {
    void onComplete();

    void onError(@NonNull Throwable r1);

    void onNext(@NonNull T r1);
}

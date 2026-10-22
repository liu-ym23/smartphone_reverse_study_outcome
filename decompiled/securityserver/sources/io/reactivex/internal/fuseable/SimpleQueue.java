package io.reactivex.internal.fuseable;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(@NonNull T r1);

    boolean offer(@NonNull T r1, @NonNull T r2);

    @Nullable
    T poll();
}

package io.reactivex.functions;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface Function3<T1, T2, T3, R> {
    @NonNull
    R apply(@NonNull T1 r1, @NonNull T2 r2, @NonNull T3 r3);
}

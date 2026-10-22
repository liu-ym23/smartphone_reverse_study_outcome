package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GroupedObservable<K, T> extends Observable<T> {
    final K key;

    public GroupedObservable(@Nullable K r1) {
        this.key = r1;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}

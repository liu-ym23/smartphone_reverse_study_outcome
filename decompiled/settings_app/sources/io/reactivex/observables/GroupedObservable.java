package io.reactivex.observables;

import io.reactivex.Observable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class GroupedObservable<K, T> extends Observable<T> {
    final K key;

    protected GroupedObservable(K r1) {
        this.key = r1;
    }

    public K getKey() {
        return this.key;
    }
}

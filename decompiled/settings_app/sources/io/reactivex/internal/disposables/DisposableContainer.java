package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes5.dex */
public interface DisposableContainer {
    boolean add(Disposable r1);

    boolean delete(Disposable r1);

    boolean remove(Disposable r1);
}

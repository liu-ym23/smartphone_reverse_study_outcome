package io.reactivex.internal.util;

import io.reactivex.Observer;

/* JADX INFO: loaded from: classes5.dex */
public interface ObservableQueueDrain<T, U> {
    void accept(Observer<? super U> r1, T r2);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int r1);
}

package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleFromUnsafeSource<T> extends Single<T> {
    final SingleSource<T> source;

    public SingleFromUnsafeSource(SingleSource<T> r1) {
        this.source = r1;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> r1) {
        this.source.subscribe(r1);
    }
}

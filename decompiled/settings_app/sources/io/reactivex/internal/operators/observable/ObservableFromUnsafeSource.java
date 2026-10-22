package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableFromUnsafeSource<T> extends Observable<T> {
    final ObservableSource<T> source;

    public ObservableFromUnsafeSource(ObservableSource<T> r1) {
        this.source = r1;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r1) {
        this.source.subscribe(r1);
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.ScalarCallable;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {
    private final T value;

    public ObservableJust(T r1) {
        this.value = r1;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.value;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r2) {
        ObservableScalarXMap.ScalarDisposable r0 = new ObservableScalarXMap.ScalarDisposable(r2, this.value);
        r2.onSubscribe(r0);
        r0.run();
    }
}

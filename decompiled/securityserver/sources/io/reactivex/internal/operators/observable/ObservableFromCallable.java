package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {
    final Callable<? extends T> callable;

    public ObservableFromCallable(Callable<? extends T> r1) {
        this.callable = r1;
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        return (T) ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        DeferredScalarDisposable r0 = new DeferredScalarDisposable(r3);
        r3.onSubscribe(r0);
        if (r0.isDisposed() == false) goto L14;
        return;
    L14:
        r0.complete(ObjectHelper.requireNonNull(this.callable.call(), "Callable returned null"));
        return;
    L8:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r0.isDisposed() == true) goto L12;
        r3.onError(th);
        return;
    L12:
        RxJavaPlugins.onError(th);
    }
}

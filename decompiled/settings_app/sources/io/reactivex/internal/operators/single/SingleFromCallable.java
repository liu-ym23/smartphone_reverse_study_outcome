package io.reactivex.internal.operators.single;

import adcpeJava.adcpe.Constants;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleFromCallable<T> extends Single<T> {
    final Callable<? extends T> callable;

    public SingleFromCallable(Callable<? extends T> r1) {
        this.callable = r1;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        Disposable r0 = Disposables.empty();
        r3.onSubscribe(r0);
        if (r0.isDisposed() == false) goto L16;
        return;
    L16:
        Constants r2 = (Object) ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value");
        if (r0.isDisposed() == true) goto L18;
        r3.onSuccess(r2);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r0.isDisposed() == true) goto L14;
        r3.onError(th);
        return;
    L14:
        RxJavaPlugins.onError(th);
    }
}

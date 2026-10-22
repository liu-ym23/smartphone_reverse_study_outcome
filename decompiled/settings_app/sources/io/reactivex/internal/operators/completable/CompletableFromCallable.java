package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableFromCallable extends Completable {
    final Callable<?> callable;

    public CompletableFromCallable(Callable<?> r1) {
        this.callable = r1;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r2) {
        Disposable r0 = Disposables.empty();
        r2.onSubscribe(r0);
        this.callable.call();     // Catch: Throwable -> L8
        if (r0.isDisposed() == true) goto L16;
        r2.onComplete();
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r0.isDisposed() == true) goto L12;
        r2.onError(th);
        return;
    L12:
        RxJavaPlugins.onError(th);
    }
}

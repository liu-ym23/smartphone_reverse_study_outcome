package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {
    final Callable<? extends T> callable;

    public MaybeFromCallable(Callable<? extends T> r1) {
        this.callable = r1;
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        return this.callable.call();
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> r3) {
        Disposable r0 = Disposables.empty();
        r3.onSubscribe(r0);
        if (r0.isDisposed() == true) goto L18;
        T r2 = this.callable.call();     // Catch: Throwable -> L10
        if (r0.isDisposed() == true) goto L19;
        if (r2 != null) goto L9;
        r3.onComplete();
        return;
    L9:
        r3.onSuccess(r2);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r0.isDisposed() == true) goto L14;
        r3.onError(th);
        return;
    L14:
        RxJavaPlugins.onError(th);
        return;
    }
}

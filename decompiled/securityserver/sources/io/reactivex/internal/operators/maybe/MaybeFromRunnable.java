package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeFromRunnable<T> extends Maybe<T> implements Callable<T> {
    final Runnable runnable;

    public MaybeFromRunnable(Runnable r1) {
        this.runnable = r1;
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        this.runnable.run();
        return null;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> r3) {
        Disposable r0 = Disposables.empty();
        r3.onSubscribe(r0);
        if (r0.isDisposed() == true) goto L16;
        this.runnable.run();     // Catch: Throwable -> L8
        if (r0.isDisposed() == true) goto L17;
        r3.onComplete();
        return;
    L17:
        return;
    L8:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r0.isDisposed() == true) goto L12;
        r3.onError(th);
        return;
    L12:
        RxJavaPlugins.onError(th);
        return;
    }
}

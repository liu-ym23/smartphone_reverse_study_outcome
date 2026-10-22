package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeFromAction<T> extends Maybe<T> implements Callable<T> {
    final Action action;

    public MaybeFromAction(Action r1) {
        this.action = r1;
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        this.action.run();
        return null;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> r3) {
        Disposable r0 = Disposables.empty();
        r3.onSubscribe(r0);
        if (r0.isDisposed() == true) goto L16;
        this.action.run();     // Catch: Throwable -> L8
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

package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableErrorSupplier extends Completable {
    final Callable<? extends Throwable> errorSupplier;

    public CompletableErrorSupplier(Callable<? extends Throwable> r1) {
        this.errorSupplier = r1;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r2) {
        th = (Throwable) ObjectHelper.requireNonNull(this.errorSupplier.call(), "The error returned is null");     // Catch: Throwable -> L4
    L6:
        EmptyDisposable.error(th, r2);
        return;
    L4:
        th = th;
        Exceptions.throwIfFatal(th);
        goto L6
    }
}

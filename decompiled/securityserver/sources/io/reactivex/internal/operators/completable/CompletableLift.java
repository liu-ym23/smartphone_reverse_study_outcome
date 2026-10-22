package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOperator;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableLift extends Completable {
    final CompletableOperator onLift;
    final CompletableSource source;

    public CompletableLift(CompletableSource r1, CompletableOperator r2) {
        this.source = r1;
        this.onLift = r2;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r2) {
        CompletableObserver r3 = this.onLift.apply(r2);     // Catch: Throwable -> L4 NullPointerException -> L6
        this.source.subscribe(r3);     // Catch: Throwable -> L4 NullPointerException -> L6
    L13:
        return;
    L6:
        e = move-exception;
        throw e;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }
}

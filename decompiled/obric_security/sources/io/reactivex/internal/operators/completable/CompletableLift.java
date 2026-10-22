package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOperator;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableLift extends Completable {
    final CompletableOperator onLift;
    final CompletableSource source;

    public CompletableLift(CompletableSource r1, CompletableOperator r2) {
        this.source = r1;
        this.onLift = r2;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r2) {
        CompletableObserver r3 = this.onLift.apply(r2);     // Catch: Throwable -> L4 NullPointerException -> L7
        this.source.subscribe(r3);     // Catch: Throwable -> L4 NullPointerException -> L7
    L11:
        return;
    L7:
        e = move-exception;
        throw e;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }
}

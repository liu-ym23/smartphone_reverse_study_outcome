package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOperator;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleLift<T, R> extends Single<R> {
    final SingleOperator<? extends R, ? super T> onLift;
    final SingleSource<T> source;

    public SingleLift(SingleSource<T> r1, SingleOperator<? extends R, ? super T> r2) {
        this.source = r1;
        this.onLift = r2;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super R> r3) {
        SingleObserver<? super T> r0 = (SingleObserver) ObjectHelper.requireNonNull(this.onLift.apply(r3), "The onLift returned a null SingleObserver");     // Catch: Throwable -> L5
        this.source.subscribe(r0);
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r3);
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableLift<R, T> extends AbstractObservableWithUpstream<T, R> {
    final ObservableOperator<? extends R, ? super T> operator;

    public ObservableLift(ObservableSource<T> r1, ObservableOperator<? extends R, ? super T> r2) {
        super(r1);
        this.operator = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> r3) {
        this.source.subscribe((Observer) ObjectHelper.requireNonNull(this.operator.apply(r3), "Operator " + this.operator + " returned a null Observer"));
        return;
    L9:
        e = move-exception;
        throw e;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        NullPointerException r4 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r4.initCause(th);
        throw r4;
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableLift<R, T> extends AbstractFlowableWithUpstream<T, R> {
    final FlowableOperator<? extends R, ? super T> operator;

    public FlowableLift(Flowable<T> r1, FlowableOperator<? extends R, ? super T> r2) {
        super(r1);
        this.operator = r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> r3) {
        Subscriber<? super Object> r4 = this.operator.apply(r3);     // Catch: Throwable -> L7 NullPointerException -> L9
        if (r4 == null) goto L12;
        this.source.subscribe(r4);     // Catch: Throwable -> L7 NullPointerException -> L9
        return;
    L12:
        throw new NullPointerException("Operator " + this.operator + " returned a null Subscriber");     // Catch: Throwable -> L7 NullPointerException -> L9
    L9:
        e = move-exception;
        throw e;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        NullPointerException r5 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r5.initCause(th);
        throw r5;
    }
}

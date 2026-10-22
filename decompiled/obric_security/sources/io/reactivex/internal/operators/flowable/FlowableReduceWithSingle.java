package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableReduceWithSingle<T, R> extends Single<R> {
    final BiFunction<R, ? super T, R> reducer;
    final Callable<R> seedSupplier;
    final Publisher<T> source;

    public FlowableReduceWithSingle(Publisher<T> r1, Callable<R> r2, BiFunction<R, ? super T, R> r3) {
        this.source = r1;
        this.seedSupplier = r2;
        this.reducer = r3;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super R> r4) {
        Object r0 = ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seedSupplier returned a null value");     // Catch: Throwable -> L5
        this.source.subscribe(new FlowableReduceSeedSingle.ReduceSeedObserver(r4, this.reducer, r0));
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r4);
    }
}

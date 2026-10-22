package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableFromCallable<T> extends Flowable<T> implements Callable<T> {
    final Callable<? extends T> callable;

    public FlowableFromCallable(Callable<? extends T> r1) {
        this.callable = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r3) {
        DeferredScalarSubscription r0 = new DeferredScalarSubscription(r3);
        r3.onSubscribe(r0);
        r0.complete(ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value"));
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r0.isCancelled() == false) goto L10;
        RxJavaPlugins.onError(th);
        return;
    L10:
        r3.onError(th);
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value");
    }
}

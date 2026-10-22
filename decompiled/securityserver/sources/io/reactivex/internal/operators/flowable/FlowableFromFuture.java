package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowableFromFuture<T> extends Flowable<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public FlowableFromFuture(Future<? extends T> r1, long r2, TimeUnit r4) {
        this.future = r1;
        this.timeout = r2;
        this.unit = r4;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> r6) {
        DeferredScalarSubscription r0 = new DeferredScalarSubscription(r6);
        r6.onSubscribe(r0);
        TimeUnit r1 = this.unit;     // Catch: Throwable -> L6
        if (r1 == null) goto L8;
        T r5 = this.future.get(this.timeout, r1);     // Catch: Throwable -> L6
    L9:
        if (r5 != null) goto L11;
        r6.onError(new NullPointerException("The future returned null"));
        return;
    L11:
        r0.complete(r5);
        return;
    L8:
        r5 = this.future.get();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r0.isCancelled() == true) goto L19;
        r6.onError(th);
        return;
    }
}

package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFromFuture<T> extends Maybe<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public MaybeFromFuture(Future<? extends T> r1, long r2, TimeUnit r4) {
        this.future = r1;
        this.timeout = r2;
        this.unit = r4;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> r6) {
        Disposable r0 = Disposables.empty();
        r6.onSubscribe(r0);
        if (r0.isDisposed() == true) goto L22;
        long r1 = this.timeout;     // Catch: Throwable -> L13
        if (r1 > 0) goto L7;
        T r5 = this.future.get();     // Catch: Throwable -> L13
    L9:
        if (r0.isDisposed() == true) goto L23;
        if (r5 != null) goto L12;
        r6.onComplete();
        return;
    L12:
        r6.onSuccess(r5);
        return;
    L23:
        return;
    L7:
        r5 = this.future.get(r1, this.unit);     // Catch: Throwable -> L13
    L13:
        th = th;
        if ((th instanceof ExecutionException) == false) goto L17;
        th = th.getCause();
    L17:
        Exceptions.throwIfFatal(th);
        if (r0.isDisposed() == true) goto L26;
        r6.onError(th);
        return;
    L26:
        return;
    }
}

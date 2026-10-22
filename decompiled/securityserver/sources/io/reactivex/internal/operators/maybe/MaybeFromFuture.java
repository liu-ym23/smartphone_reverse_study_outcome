package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
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
    public void subscribeActual(MaybeObserver<? super T> r6) {
        Disposable r0 = Disposables.empty();
        r6.onSubscribe(r0);
        if (r0.isDisposed() == true) goto L23;
        long r1 = this.timeout;     // Catch: Throwable -> L7
        if (r1 > 0) goto L9;
        T r5 = this.future.get();     // Catch: Throwable -> L7
    L11:
        if (r0.isDisposed() == true) goto L24;
        if (r5 != null) goto L14;
        r6.onComplete();
        return;
    L14:
        r6.onSuccess(r5);
        return;
    L24:
        return;
    L9:
        r5 = this.future.get(r1, this.unit);     // Catch: Throwable -> L7
    L7:
        th = th;
        if ((th instanceof ExecutionException) == false) goto L18;
        th = th.getCause();
    L18:
        Exceptions.throwIfFatal(th);
        if (r0.isDisposed() == true) goto L27;
        r6.onError(th);
        return;
    L27:
        return;
    }
}

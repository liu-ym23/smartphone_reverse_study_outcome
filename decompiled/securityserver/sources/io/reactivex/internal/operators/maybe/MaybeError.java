package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeError<T> extends Maybe<T> {
    final Throwable error;

    public MaybeError(Throwable r1) {
        this.error = r1;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> r2) {
        r2.onSubscribe(Disposables.disposed());
        r2.onError(this.error);
    }
}

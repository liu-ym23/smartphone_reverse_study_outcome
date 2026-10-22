package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DefaultObserver<T> implements Observer<T> {
    private Disposable upstream;

    public DefaultObserver() {
    }

    public final void cancel() {
        Disposable r0 = this.upstream;
        this.upstream = DisposableHelper.DISPOSED;
        r0.dispose();
    }

    public void onStart() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(@NonNull Disposable r3) {
        if (EndConsumerHelper.validate(this.upstream, r3, getClass()) == false) goto L6;
        this.upstream = r3;
        onStart();
        return;
    }
}

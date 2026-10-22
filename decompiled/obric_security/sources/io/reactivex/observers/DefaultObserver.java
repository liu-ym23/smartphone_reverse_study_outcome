package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DefaultObserver<T> implements Observer<T> {
    private Disposable upstream;

    protected void onStart() {
    }

    public DefaultObserver() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r3) {
        if (EndConsumerHelper.validate(this.upstream, r3, getClass()) == false) goto L6;
        this.upstream = r3;
        onStart();
        return;
    }

    protected final void cancel() {
        Disposable r0 = this.upstream;
        this.upstream = DisposableHelper.DISPOSED;
        r0.dispose();
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -8612022020200669122L;
    final Observer<? super T> downstream;
    final AtomicReference<Disposable> upstream;

    public ObserverResourceWrapper(Observer<? super T> r2) {
        this.upstream = new AtomicReference();
        this.downstream = r2;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r2) {
        if (DisposableHelper.setOnce(this.upstream, r2) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.Observer
    public void onNext(T r1) {
        this.downstream.onNext(r1);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r1) {
        dispose();
        this.downstream.onError(r1);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.upstream.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    public void setResource(Disposable r1) {
        DisposableHelper.set(this, r1);
    }
}

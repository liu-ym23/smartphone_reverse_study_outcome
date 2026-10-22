package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = 4943102778943297569L;
    final BiConsumer<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(BiConsumer<? super T, ? super Throwable> r1) {
        this.onCallback = r1;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r2) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.accept(null, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r2, th}));
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r1) {
        DisposableHelper.setOnce(this, r1);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r2) {
        lazySet(DisposableHelper.DISPOSED);     // Catch: Throwable -> L4
        this.onCallback.accept(r2, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }
}

package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes2.dex */
public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> downstream;
    final Action onDispose;
    final Consumer<? super Disposable> onSubscribe;
    Disposable upstream;

    public DisposableLambdaObserver(Observer<? super T> r1, Consumer<? super Disposable> r2, Action r3) {
        this.downstream = r1;
        this.onSubscribe = r2;
        this.onDispose = r3;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Disposable r0 = this.upstream;
        DisposableHelper r1 = DisposableHelper.DISPOSED;
        if (r0 == r1) goto L13;
        this.upstream = r1;
        this.onDispose.run();     // Catch: Throwable -> L7
    L9:
        r0.dispose();
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        goto L9
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Disposable r0 = this.upstream;
        DisposableHelper r1 = DisposableHelper.DISPOSED;
        if (r0 == r1) goto L6;
        this.upstream = r1;
        this.downstream.onComplete();
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r3) {
        Disposable r0 = this.upstream;
        DisposableHelper r1 = DisposableHelper.DISPOSED;
        if (r0 == r1) goto L5;
        this.upstream = r1;
        this.downstream.onError(r3);
        return;
    L5:
        RxJavaPlugins.onError(r3);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r1) {
        this.downstream.onNext(r1);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r2) {
        this.onSubscribe.accept(r2);     // Catch: Throwable -> L7
        if (DisposableHelper.validate(this.upstream, r2) == false) goto L12;
        this.upstream = r2;
        this.downstream.onSubscribe(this);
        return;
    L12:
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r2.dispose();
        this.upstream = DisposableHelper.DISPOSED;
        EmptyDisposable.error(th, this.downstream);
    }
}

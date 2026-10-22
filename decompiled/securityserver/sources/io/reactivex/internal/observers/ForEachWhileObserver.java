package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Predicate<? super T> onNext;

    public ForEachWhileObserver(Predicate<? super T> r1, Consumer<? super Throwable> r2, Action r3) {
        this.onNext = r1;
        this.onError = r2;
        this.onComplete = r3;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.onComplete.run();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r2) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r2);
        return;
    L6:
        this.done = true;
        this.onError.accept(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r2, th}));
    }

    @Override // io.reactivex.Observer
    public void onNext(T r2) {
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.onNext.test(r2) == true) goto L14;
        dispose();
        onComplete();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        dispose();
        onError(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r1) {
        DisposableHelper.setOnce(this, r1);
    }
}

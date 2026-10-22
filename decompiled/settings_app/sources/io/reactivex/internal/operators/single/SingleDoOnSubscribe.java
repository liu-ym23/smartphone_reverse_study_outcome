package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleDoOnSubscribe<T> extends Single<T> {
    final Consumer<? super Disposable> onSubscribe;
    final SingleSource<T> source;

    static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {
        boolean done;
        final SingleObserver<? super T> downstream;
        final Consumer<? super Disposable> onSubscribe;

        DoOnSubscribeSingleObserver(SingleObserver<? super T> r1, Consumer<? super Disposable> r2) {
            this.downstream = r1;
            this.onSubscribe = r2;
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r3) {
            this.onSubscribe.accept(r3);     // Catch: Throwable -> L5
            this.downstream.onSubscribe(r3);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.done = true;
            r3.dispose();
            EmptyDisposable.error(th, this.downstream);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r2) {
            if (this.done == false) goto L5;
            return;
        L5:
            this.downstream.onSuccess(r2);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.downstream.onError(r2);
        }
    }

    public SingleDoOnSubscribe(SingleSource<T> r1, Consumer<? super Disposable> r2) {
        this.source = r1;
        this.onSubscribe = r2;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new DoOnSubscribeSingleObserver(r3, this.onSubscribe));
    }
}

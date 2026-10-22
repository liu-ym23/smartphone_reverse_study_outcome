package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableToSingle<T> extends Single<T> {
    final T completionValue;
    final Callable<? extends T> completionValueSupplier;
    final CompletableSource source;

    public final class ToSingle implements CompletableObserver {
        private final SingleObserver<? super T> observer;
        final /* synthetic */ CompletableToSingle this$0;

        public ToSingle(CompletableToSingle r1, SingleObserver<? super T> r2) {
            this.this$0 = r1;
            this.observer = r2;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            CompletableToSingle r0 = this.this$0;
            Callable<? extends T> r1 = r0.completionValueSupplier;
            if (r1 != null) goto L14;
            T r2 = r0.completionValue;
        L10:
            if (r2 != null) goto L12;
            this.observer.onError(new NullPointerException("The value supplied is null"));
            return;
        L12:
            this.observer.onSuccess(r2);
            return;
        L14:
            r2 = r1.call();     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.observer.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r1) {
            this.observer.onError(r1);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            this.observer.onSubscribe(r1);
        }
    }

    public CompletableToSingle(CompletableSource r1, Callable<? extends T> r2, T r3) {
        this.source = r1;
        this.completionValue = r3;
        this.completionValueSupplier = r2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new ToSingle(this, r3));
    }
}

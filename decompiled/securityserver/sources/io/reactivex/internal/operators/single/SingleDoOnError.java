package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleDoOnError<T> extends Single<T> {
    final Consumer<? super Throwable> onError;
    final SingleSource<T> source;

    public final class DoOnError implements SingleObserver<T> {
        private final SingleObserver<? super T> downstream;
        final /* synthetic */ SingleDoOnError this$0;

        public DoOnError(SingleDoOnError r1, SingleObserver<? super T> r2) {
            this.this$0 = r1;
            this.downstream = r2;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r3) {
            this.this$0.onError.accept(r3);     // Catch: Throwable -> L4
        L6:
            this.downstream.onError(r3);
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r3 = new CompositeException(new Throwable[]{r3, th});
            goto L6
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            this.downstream.onSubscribe(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }
    }

    public SingleDoOnError(SingleSource<T> r1, Consumer<? super Throwable> r2) {
        this.source = r1;
        this.onError = r2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new DoOnError(this, r3));
    }
}

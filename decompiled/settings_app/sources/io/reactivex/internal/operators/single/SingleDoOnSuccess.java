package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleDoOnSuccess<T> extends Single<T> {
    final Consumer<? super T> onSuccess;
    final SingleSource<T> source;

    final class DoOnSuccess implements SingleObserver<T> {
        final SingleObserver<? super T> downstream;
        final /* synthetic */ SingleDoOnSuccess this$0;

        DoOnSuccess(SingleDoOnSuccess r1, SingleObserver<? super T> r2) {
            this.this$0 = r1;
            this.downstream = r2;
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            this.downstream.onSubscribe(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r2) {
            this.this$0.onSuccess.accept(r2);     // Catch: Throwable -> L5
            this.downstream.onSuccess(r2);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }
    }

    public SingleDoOnSuccess(SingleSource<T> r1, Consumer<? super T> r2) {
        this.source = r1;
        this.onSuccess = r2;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new DoOnSuccess(this, r3));
    }
}

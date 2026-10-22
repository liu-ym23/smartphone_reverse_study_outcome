package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleDoOnTerminate<T> extends Single<T> {
    final Action onTerminate;
    final SingleSource<T> source;

    final class DoOnTerminate implements SingleObserver<T> {
        final SingleObserver<? super T> downstream;
        final /* synthetic */ SingleDoOnTerminate this$0;

        DoOnTerminate(SingleDoOnTerminate r1, SingleObserver<? super T> r2) {
            this.this$0 = r1;
            this.downstream = r2;
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            this.downstream.onSubscribe(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r2) {
            this.this$0.onTerminate.run();     // Catch: Throwable -> L5
            this.downstream.onSuccess(r2);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r5) {
            this.this$0.onTerminate.run();     // Catch: Throwable -> L4
        L6:
            this.downstream.onError(r5);
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r5 = new CompositeException(new Throwable[]{r5, th});
            goto L6
        }
    }

    public SingleDoOnTerminate(SingleSource<T> r1, Action r2) {
        this.source = r1;
        this.onTerminate = r2;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new DoOnTerminate(this, r3));
    }
}

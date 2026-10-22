package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleContains<T> extends Single<Boolean> {
    final BiPredicate<Object, Object> comparer;
    final SingleSource<T> source;
    final Object value;

    final class ContainsSingleObserver implements SingleObserver<T> {
        private final SingleObserver<? super Boolean> downstream;
        final /* synthetic */ SingleContains this$0;

        ContainsSingleObserver(SingleContains r1, SingleObserver<? super Boolean> r2) {
            this.this$0 = r1;
            this.downstream = r2;
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            this.downstream.onSubscribe(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r3) {
            boolean r4 = this.this$0.comparer.test(r3, this.this$0.value);     // Catch: Throwable -> L5
            this.downstream.onSuccess(Boolean.valueOf(r4));
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

    public SingleContains(SingleSource<T> r1, Object r2, BiPredicate<Object, Object> r3) {
        this.source = r1;
        this.value = r2;
        this.comparer = r3;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Boolean> r3) {
        this.source.subscribe(new ContainsSingleObserver(this, r3));
    }
}

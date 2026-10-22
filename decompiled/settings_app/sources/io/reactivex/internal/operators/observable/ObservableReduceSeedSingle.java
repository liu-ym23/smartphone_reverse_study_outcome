package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableReduceSeedSingle<T, R> extends Single<R> {
    final BiFunction<R, ? super T, R> reducer;
    final R seed;
    final ObservableSource<T> source;

    static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {
        final SingleObserver<? super R> downstream;
        final BiFunction<R, ? super T, R> reducer;
        Disposable upstream;
        R value;

        ReduceSeedObserver(SingleObserver<? super R> r1, BiFunction<R, ? super T, R> r2, R r3) {
            this.downstream = r1;
            this.value = r3;
            this.reducer = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            R r0 = this.value;
            if (r0 == null) goto L11;
            this.value = (R) ObjectHelper.requireNonNull(this.reducer.apply(r0, r3), "The reducer returned a null value");     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.value == null) goto L5;
            this.value = null;
            this.downstream.onError(r2);
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            R r0 = this.value;
            if (r0 == null) goto L6;
            this.value = null;
            this.downstream.onSuccess(r0);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }

    public ObservableReduceSeedSingle(ObservableSource<T> r1, R r2, BiFunction<R, ? super T, R> r3) {
        this.source = r1;
        this.seed = r2;
        this.reducer = r3;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super R> r4) {
        this.source.subscribe(new ReduceSeedObserver(r4, this.reducer, this.seed));
    }
}

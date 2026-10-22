package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleMap<T, R> extends Single<R> {
    final Function<? super T, ? extends R> mapper;
    final SingleSource<? extends T> source;

    public static final class MapSingleObserver<T, R> implements SingleObserver<T> {
        final Function<? super T, ? extends R> mapper;
        final SingleObserver<? super R> t;

        public MapSingleObserver(SingleObserver<? super R> r1, Function<? super T, ? extends R> r2) {
            this.t = r1;
            this.mapper = r2;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r1) {
            this.t.onError(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            this.t.onSubscribe(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r2) {
            Object r3 = ObjectHelper.requireNonNull(this.mapper.apply(r2), "The mapper function returned a null value.");     // Catch: Throwable -> L5
            this.t.onSuccess(r3);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            onError(th);
        }
    }

    public SingleMap(SingleSource<? extends T> r1, Function<? super T, ? extends R> r2) {
        this.source = r1;
        this.mapper = r2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> r3) {
        this.source.subscribe(new MapSingleObserver(r3, this.mapper));
    }
}

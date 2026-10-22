package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleFlatMap<T, R> extends Single<R> {
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final SingleSource<? extends T> source;

    static final class SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 3258103020495908596L;
        final SingleObserver<? super R> downstream;
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;

        static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
            final SingleObserver<? super R> downstream;
            final AtomicReference<Disposable> parent;

            FlatMapSingleObserver(AtomicReference<Disposable> r1, SingleObserver<? super R> r2) {
                this.parent = r1;
                this.downstream = r2;
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.replace(this.parent, r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r1) {
                this.downstream.onSuccess(r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable r1) {
                this.downstream.onError(r1);
            }
        }

        SingleFlatMapCallback(SingleObserver<? super R> r1, Function<? super T, ? extends SingleSource<? extends R>> r2) {
            this.downstream = r1;
            this.mapper = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            if (DisposableHelper.setOnce(this, r1) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r3) {
            SingleSource r4 = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(r3), "The single returned by the mapper is null");     // Catch: Throwable -> L7
            if (isDisposed() == true) goto L12;
            r4.subscribe(new FlatMapSingleObserver(this, this.downstream));
            return;
        L12:
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }
    }

    public SingleFlatMap(SingleSource<? extends T> r1, Function<? super T, ? extends SingleSource<? extends R>> r2) {
        this.mapper = r2;
        this.source = r1;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super R> r3) {
        this.source.subscribe(new SingleFlatMapCallback(r3, this.mapper));
    }
}

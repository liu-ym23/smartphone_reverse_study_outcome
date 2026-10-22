package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeFlatMapSingle<T, R> extends Single<R> {
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final MaybeSource<T> source;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4827726964688405508L;
        final SingleObserver<? super R> downstream;
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;

        public FlatMapMaybeObserver(SingleObserver<? super R> r1, Function<? super T, ? extends SingleSource<? extends R>> r2) {
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

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onError(new NoSuchElementException());
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r1) {
            if (DisposableHelper.setOnce(this, r1) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r3) {
            SingleSource r4 = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(r3), "The mapper returned a null SingleSource");     // Catch: Throwable -> L7
            if (isDisposed() == true) goto L12;
            r4.subscribe(new FlatMapSingleObserver(this, this.downstream));
            return;
        L12:
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            onError(th);
        }
    }

    public static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
        final SingleObserver<? super R> downstream;
        final AtomicReference<Disposable> parent;

        public FlatMapSingleObserver(AtomicReference<Disposable> r1, SingleObserver<? super R> r2) {
            this.parent = r1;
            this.downstream = r2;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.replace(this.parent, r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(R r1) {
            this.downstream.onSuccess(r1);
        }
    }

    public MaybeFlatMapSingle(MaybeSource<T> r1, Function<? super T, ? extends SingleSource<? extends R>> r2) {
        this.source = r1;
        this.mapper = r2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> r3) {
        this.source.subscribe(new FlatMapMaybeObserver(r3, this.mapper));
    }
}

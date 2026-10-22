package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatMapBiSelector<T, U, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends U>> mapper;
    final BiFunction<? super T, ? super U, ? extends R> resultSelector;

    static final class FlatMapBiMainObserver<T, U, R> implements MaybeObserver<T>, Disposable {
        final InnerObserver<T, U, R> inner;
        final Function<? super T, ? extends MaybeSource<? extends U>> mapper;

        static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            final MaybeObserver<? super R> downstream;
            final BiFunction<? super T, ? super U, ? extends R> resultSelector;
            T value;

            InnerObserver(MaybeObserver<? super R> r1, BiFunction<? super T, ? super U, ? extends R> r2) {
                this.downstream = r1;
                this.resultSelector = r2;
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(U r3) {
                T r0 = this.value;
                this.value = null;
                Object r4 = ObjectHelper.requireNonNull(this.resultSelector.apply(r0, r3), "The resultSelector returned a null value");     // Catch: Throwable -> L6
                this.downstream.onSuccess(r4);
                return;
            L6:
                th = move-exception;
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable r1) {
                this.downstream.onError(r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.downstream.onComplete();
            }
        }

        FlatMapBiMainObserver(MaybeObserver<? super R> r2, Function<? super T, ? extends MaybeSource<? extends U>> r3, BiFunction<? super T, ? super U, ? extends R> r4) {
            this.inner = new InnerObserver(r2, r4);
            this.mapper = r3;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.inner);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.inner.get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.setOnce(this.inner, r2) == false) goto L6;
            this.inner.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r4) {
            MaybeSource r0 = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(r4), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L7
            if (DisposableHelper.replace(this.inner, null) == false) goto L12;
            this.inner.value = r4;
            r0.subscribe(this.inner);
            return;
        L12:
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.inner.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r1) {
            this.inner.downstream.onError(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.inner.downstream.onComplete();
        }
    }

    public MaybeFlatMapBiSelector(MaybeSource<T> r1, Function<? super T, ? extends MaybeSource<? extends U>> r2, BiFunction<? super T, ? super U, ? extends R> r3) {
        super(r1);
        this.mapper = r2;
        this.resultSelector = r3;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super R> r4) {
        this.source.subscribe(new FlatMapBiMainObserver(r4, this.mapper, this.resultSelector));
    }
}

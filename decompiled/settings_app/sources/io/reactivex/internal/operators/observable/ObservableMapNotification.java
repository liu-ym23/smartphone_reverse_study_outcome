package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {
    final Callable<? extends ObservableSource<? extends R>> onCompleteSupplier;
    final Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper;

    static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super ObservableSource<? extends R>> downstream;
        final Callable<? extends ObservableSource<? extends R>> onCompleteSupplier;
        final Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper;
        final Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper;
        Disposable upstream;

        MapNotificationObserver(Observer<? super ObservableSource<? extends R>> r1, Function<? super T, ? extends ObservableSource<? extends R>> r2, Function<? super Throwable, ? extends ObservableSource<? extends R>> r3, Callable<? extends ObservableSource<? extends R>> r4) {
            this.downstream = r1;
            this.onNextMapper = r2;
            this.onErrorMapper = r3;
            this.onCompleteSupplier = r4;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
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

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            ObservableSource r3 = (ObservableSource) ObjectHelper.requireNonNull(this.onNextMapper.apply(r2), "The onNext ObservableSource returned is null");     // Catch: Throwable -> L5
            this.downstream.onNext(r3);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r5) {
            this.downstream.onNext((ObservableSource) ObjectHelper.requireNonNull(this.onErrorMapper.apply(r5), "The onError ObservableSource returned is null"));
            this.downstream.onComplete();
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ObservableSource r0 = (ObservableSource) ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onComplete ObservableSource returned is null");     // Catch: Throwable -> L5
            this.downstream.onNext(r0);
            this.downstream.onComplete();
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }
    }

    public ObservableMapNotification(ObservableSource<T> r1, Function<? super T, ? extends ObservableSource<? extends R>> r2, Function<? super Throwable, ? extends ObservableSource<? extends R>> r3, Callable<? extends ObservableSource<? extends R>> r4) {
        super(r1);
        this.onNextMapper = r2;
        this.onErrorMapper = r3;
        this.onCompleteSupplier = r4;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super ObservableSource<? extends R>> r5) {
        this.source.subscribe(new MapNotificationObserver(r5, this.onNextMapper, this.onErrorMapper, this.onCompleteSupplier));
    }
}

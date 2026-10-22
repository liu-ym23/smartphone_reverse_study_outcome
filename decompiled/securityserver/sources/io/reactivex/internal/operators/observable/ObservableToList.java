package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> collectionSupplier;

    public static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        U collection;
        final Observer<? super U> downstream;
        Disposable upstream;

        public ToListObserver(Observer<? super U> r1, U r2) {
            this.downstream = r1;
            this.collection = r2;
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
        public void onComplete() {
            U r0 = this.collection;
            this.collection = null;
            this.downstream.onNext(r0);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.collection = null;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.collection.add(r1);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public ObservableToList(ObservableSource<T> r1, int r2) {
        super(r1);
        this.collectionSupplier = Functions.createArrayList(r2);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> r3) {
        Collection r0 = (Collection) ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L5
        this.source.subscribe(new ToListObserver(r3, r0));
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r3);
    }

    public ObservableToList(ObservableSource<T> r1, Callable<U> r2) {
        super(r1);
        this.collectionSupplier = r2;
    }
}

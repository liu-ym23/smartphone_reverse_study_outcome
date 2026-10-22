package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {
    final Callable<? extends Collection<? super K>> collectionSupplier;
    final Function<? super T, K> keySelector;

    static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {
        final Collection<? super K> collection;
        final Function<? super T, K> keySelector;

        DistinctObserver(Observer<? super T> r1, Function<? super T, K> r2, Collection<? super K> r3) {
            super(r1);
            this.keySelector = r2;
            this.collection = r3;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.sourceMode == 0) goto L15;
            this.downstream.onNext(null);
            return;
        L15:
            Object r0 = ObjectHelper.requireNonNull(this.keySelector.apply(r3), "The keySelector returned a null key");     // Catch: Throwable -> L10
            if (this.collection.add(r0) == false) goto L17;
            this.downstream.onNext((Object) r3);
            return;
        L17:
            return;
        L10:
            th = move-exception;
            fail(th);
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            this.done = true;
            this.collection.clear();
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.Observer
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.collection.clear();
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
        L2:
            T r0 = this.qd.poll();
            if (r0 == null) goto L6;
            if (this.collection.add((Object) ObjectHelper.requireNonNull(this.keySelector.apply(r0), "The keySelector returned a null key")) == false) goto L2;
        L6:
            return r0;
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.collection.clear();
            super.clear();
        }
    }

    public ObservableDistinct(ObservableSource<T> r1, Function<? super T, K> r2, Callable<? extends Collection<? super K>> r3) {
        super(r1);
        this.keySelector = r2;
        this.collectionSupplier = r3;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r4) {
        Collection r0 = (Collection) ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L5
        this.source.subscribe(new DistinctObserver(r4, this.keySelector, r0));
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r4);
    }
}

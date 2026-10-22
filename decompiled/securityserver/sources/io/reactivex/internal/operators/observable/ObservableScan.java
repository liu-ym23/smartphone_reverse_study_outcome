package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {
    final BiFunction<T, T, T> accumulator;

    public static final class ScanObserver<T> implements Observer<T>, Disposable {
        final BiFunction<T, T, T> accumulator;
        boolean done;
        final Observer<? super T> downstream;
        Disposable upstream;
        T value;

        public ScanObserver(Observer<? super T> r1, BiFunction<T, T, T> r2) {
            this.downstream = r1;
            this.accumulator = r2;
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
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // io.reactivex.Observer
        public void onNext(T r4) {
            if (this.done == false) goto L5;
            return;
        L5:
            Observer<? super T> r0 = this.downstream;
            T r1 = this.value;
            if (r1 != null) goto L14;
            this.value = r4;
            r0.onNext(r4);
            return;
        L14:
            ?? r5 = (T) ObjectHelper.requireNonNull(this.accumulator.apply(r1, r4), "The value returned by the accumulator is null");
            this.value = r5;
            r0.onNext(r5);
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public ObservableScan(ObservableSource<T> r1, BiFunction<T, T, T> r2) {
        super(r1);
        this.accumulator = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        this.source.subscribe(new ScanObserver(r3, this.accumulator));
    }
}

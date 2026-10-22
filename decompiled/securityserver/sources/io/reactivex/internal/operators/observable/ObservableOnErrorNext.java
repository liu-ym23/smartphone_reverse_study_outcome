package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {
    final boolean allowFatal;
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;

    public static final class OnErrorNextObserver<T> implements Observer<T> {
        final boolean allowFatal;
        final SequentialDisposable arbiter;
        boolean done;
        final Observer<? super T> downstream;
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;
        boolean once;

        public OnErrorNextObserver(Observer<? super T> r1, Function<? super Throwable, ? extends ObservableSource<? extends T>> r2, boolean r3) {
            this.downstream = r1;
            this.nextSupplier = r2;
            this.allowFatal = r3;
            this.arbiter = new SequentialDisposable();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.once = true;
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            if (this.once == true) goto L5;
            this.once = true;
            if (this.allowFatal == true) goto L13;
        L25:
            ObservableSource<? extends T> r0 = this.nextSupplier.apply(r3);     // Catch: Throwable -> L22
            if (r0 != null) goto L20;
            NullPointerException r1 = new NullPointerException("Observable is null");
            r1.initCause(r3);
            this.downstream.onError(r1);
            return;
        L20:
            r0.subscribe(this);
            return;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r3, th}));
            return;
        L13:
            if ((r3 instanceof Exception) == true) goto L25;
            this.downstream.onError(r3);
            return;
        L5:
            if (this.done == false) goto L8;
            RxJavaPlugins.onError(r3);
            return;
        L8:
            this.downstream.onError(r3);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.done == false) goto L5;
            return;
        L5:
            this.downstream.onNext(r2);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            this.arbiter.replace(r1);
        }
    }

    public ObservableOnErrorNext(ObservableSource<T> r1, Function<? super Throwable, ? extends ObservableSource<? extends T>> r2, boolean r3) {
        super(r1);
        this.nextSupplier = r2;
        this.allowFatal = r3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r4) {
        OnErrorNextObserver r0 = new OnErrorNextObserver(r4, this.nextSupplier, this.allowFatal);
        r4.onSubscribe(r0.arbiter);
        this.source.subscribe(r0);
    }
}

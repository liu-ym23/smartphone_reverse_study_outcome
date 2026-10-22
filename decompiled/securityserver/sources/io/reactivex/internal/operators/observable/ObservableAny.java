package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableAny<T> extends AbstractObservableWithUpstream<T, Boolean> {
    final Predicate<? super T> predicate;

    public static final class AnyObserver<T> implements Observer<T>, Disposable {
        boolean done;
        final Observer<? super Boolean> downstream;
        final Predicate<? super T> predicate;
        Disposable upstream;

        public AnyObserver(Observer<? super Boolean> r1, Predicate<? super T> r2) {
            this.downstream = r1;
            this.predicate = r2;
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
            if (this.done == true) goto L6;
            this.done = true;
            this.downstream.onNext(Boolean.FALSE);
            this.downstream.onComplete();
            return;
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

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.done == false) goto L12;
            return;
        L12:
            if (this.predicate.test(r2) == false) goto L14;
            this.done = true;
            this.upstream.dispose();
            this.downstream.onNext(Boolean.TRUE);
            this.downstream.onComplete();
            return;
        L14:
            return;
        L9:
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

    public ObservableAny(ObservableSource<T> r1, Predicate<? super T> r2) {
        super(r1);
        this.predicate = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Boolean> r3) {
        this.source.subscribe(new AnyObserver(r3, this.predicate));
    }
}

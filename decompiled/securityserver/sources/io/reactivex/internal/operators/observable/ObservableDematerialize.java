package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableDematerialize<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends Notification<R>> selector;

    public static final class DematerializeObserver<T, R> implements Observer<T>, Disposable {
        boolean done;
        final Observer<? super R> downstream;
        final Function<? super T, ? extends Notification<R>> selector;
        Disposable upstream;

        public DematerializeObserver(Observer<? super R> r1, Function<? super T, ? extends Notification<R>> r2) {
            this.downstream = r1;
            this.selector = r2;
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.done == true) goto L5;
            Notification r3 = (Notification) ObjectHelper.requireNonNull(this.selector.apply(r2), "The selector returned a null Notification");     // Catch: Throwable -> L19
            if (r3.isOnError() == false) goto L15;
            this.upstream.dispose();
            onError(r3.getError());
            return;
        L15:
            if (r3.isOnComplete() == false) goto L17;
            this.upstream.dispose();
            onComplete();
            return;
        L17:
            this.downstream.onNext((Object) r3.getValue());
            return;
        L19:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
            return;
        L5:
            if ((r2 instanceof Notification) == false) goto L24;
            Notification r4 = (Notification) r2;
            if (r4.isOnError() == false) goto L25;
            RxJavaPlugins.onError(r4.getError());
            return;
        L25:
            return;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public ObservableDematerialize(ObservableSource<T> r1, Function<? super T, ? extends Notification<R>> r2) {
        super(r1);
        this.selector = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> r3) {
        this.source.subscribe(new DematerializeObserver(r3, this.selector));
    }
}

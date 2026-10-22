package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {

    public static final class MaterializeObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Notification<T>> downstream;
        Disposable upstream;

        public MaterializeObserver(Observer<? super Notification<T>> r1) {
            this.downstream = r1;
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
            Notification r0 = Notification.createOnComplete();
            this.downstream.onNext(r0);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            Notification r3 = Notification.createOnError(r2);
            this.downstream.onNext(r3);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.downstream.onNext(Notification.createOnNext(r1));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public ObservableMaterialize(ObservableSource<T> r1) {
        super(r1);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Notification<T>> r2) {
        this.source.subscribe(new MaterializeObserver(r2));
    }
}

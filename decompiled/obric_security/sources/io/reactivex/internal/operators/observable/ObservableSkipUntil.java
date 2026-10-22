package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSkipUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> other;

    final class SkipUntil implements Observer<U> {
        final ArrayCompositeDisposable frc;
        final SerializedObserver<T> serial;
        final SkipUntilObserver<T> sus;
        final /* synthetic */ ObservableSkipUntil this$0;
        Disposable upstream;

        SkipUntil(ObservableSkipUntil r1, ArrayCompositeDisposable r2, SkipUntilObserver<T> r3, SerializedObserver<T> r4) {
            this.this$0 = r1;
            this.frc = r2;
            this.sus = r3;
            this.serial = r4;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.frc.setResource(1, r2);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(U r1) {
            this.upstream.dispose();
            this.sus.notSkipping = true;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.frc.dispose();
            this.serial.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.sus.notSkipping = true;
        }
    }

    static final class SkipUntilObserver<T> implements Observer<T> {
        final Observer<? super T> downstream;
        final ArrayCompositeDisposable frc;
        volatile boolean notSkipping;
        boolean notSkippingLocal;
        Disposable upstream;

        SkipUntilObserver(Observer<? super T> r1, ArrayCompositeDisposable r2) {
            this.downstream = r1;
            this.frc = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.frc.setResource(0, r2);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.notSkippingLocal == false) goto L6;
            this.downstream.onNext(r2);
            return;
        L6:
            if (this.notSkipping == false) goto L10;
            this.notSkippingLocal = true;
            this.downstream.onNext(r2);
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.frc.dispose();
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.frc.dispose();
            this.downstream.onComplete();
        }
    }

    public ObservableSkipUntil(ObservableSource<T> r1, ObservableSource<U> r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r5) {
        SerializedObserver r0 = new SerializedObserver(r5);
        ArrayCompositeDisposable r6 = new ArrayCompositeDisposable(2);
        r0.onSubscribe(r6);
        SkipUntilObserver r1 = new SkipUntilObserver(r0, r6);
        this.other.subscribe(new SkipUntil(this, r6, r1, r0));
        this.source.subscribe(r1);
    }
}

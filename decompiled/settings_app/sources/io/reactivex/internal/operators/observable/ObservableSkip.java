package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {
    final long n;

    static final class SkipObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> downstream;
        long remaining;
        Disposable upstream;

        SkipObserver(Observer<? super T> r1, long r2) {
            this.downstream = r1;
            this.remaining = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r5) {
            long r0 = this.remaining;
            if (r0 == 0) goto L5;
            this.remaining = r0 - 1;
            return;
        L5:
            this.downstream.onNext(r5);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }

    public ObservableSkip(ObservableSource<T> r1, long r2) {
        super(r1);
        this.n = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r5) {
        this.source.subscribe(new SkipObserver(r5, this.n));
    }
}

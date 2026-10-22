package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {
    final long limit;

    static final class TakeObserver<T> implements Observer<T>, Disposable {
        boolean done;
        final Observer<? super T> downstream;
        long remaining;
        Disposable upstream;

        TakeObserver(Observer<? super T> r1, long r2) {
            this.downstream = r1;
            this.remaining = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r5) {
            if (DisposableHelper.validate(this.upstream, r5) == false) goto L9;
            this.upstream = r5;
            if (this.remaining != 0) goto L7;
            this.done = true;
            r5.dispose();
            EmptyDisposable.complete(this.downstream);
            return;
        L7:
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r7) {
            if (this.done == true) goto L14;
            long r0 = this.remaining;
            long r2 = r0 - 1;
            this.remaining = r2;
            if (r0 > 0) goto L7;
            return;
        L7:
            if (r2 != 0) goto L9;
            boolean r1 = true;
        L10:
            this.downstream.onNext(r7);
            if (r1 == false) goto L16;
            onComplete();
            return;
        L16:
            return;
        L9:
            r1 = false;
            goto L10
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.upstream.dispose();
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.upstream.dispose();
            this.downstream.onComplete();
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
    }

    public ObservableTake(ObservableSource<T> r1, long r2) {
        super(r1);
        this.limit = r2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r5) {
        this.source.subscribe(new TakeObserver(r5, this.limit));
    }
}

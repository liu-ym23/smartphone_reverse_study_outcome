package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {
    final MaybeSource<? extends T> other;

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;
        final Observer<? super T> downstream;
        boolean inMaybe;
        MaybeSource<? extends T> other;

        ConcatWithObserver(Observer<? super T> r1, MaybeSource<? extends T> r2) {
            this.downstream = r1;
            this.other = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            if (DisposableHelper.setOnce(this, r1) == true) goto L5;
            return;
        L5:
            if (this.inMaybe == true) goto L9;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r2) {
            this.downstream.onNext(r2);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.inMaybe == false) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            this.inMaybe = true;
            DisposableHelper.replace(this, null);
            MaybeSource<? extends T> r1 = this.other;
            this.other = null;
            r1.subscribe(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    public ObservableConcatWithMaybe(Observable<T> r1, MaybeSource<? extends T> r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r3) {
        this.source.subscribe(new ConcatWithObserver(r3, this.other));
    }
}

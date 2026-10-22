package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final CompletableSource other;

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;
        final Observer<? super T> downstream;
        boolean inCompletable;
        CompletableSource other;

        ConcatWithObserver(Observer<? super T> r1, CompletableSource r2) {
            this.downstream = r1;
            this.other = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            if (DisposableHelper.setOnce(this, r1) == true) goto L5;
            return;
        L5:
            if (this.inCompletable == true) goto L9;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.inCompletable == false) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            this.inCompletable = true;
            DisposableHelper.replace(this, null);
            CompletableSource r1 = this.other;
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

    public ObservableConcatWithCompletable(Observable<T> r1, CompletableSource r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r3) {
        this.source.subscribe(new ConcatWithObserver(r3, this.other));
    }
}

package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableAndThenObservable<R> extends Observable<R> {
    final ObservableSource<? extends R> other;
    final CompletableSource source;

    public static final class AndThenObservableObserver<R> extends AtomicReference<Disposable> implements Observer<R>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;
        final Observer<? super R> downstream;
        ObservableSource<? extends R> other;

        public AndThenObservableObserver(Observer<? super R> r1, ObservableSource<? extends R> r2) {
            this.other = r2;
            this.downstream = r1;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ObservableSource<? extends R> r0 = this.other;
            if (r0 != null) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            this.other = null;
            r0.subscribe(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.replace(this, r1);
        }
    }

    public CompletableAndThenObservable(CompletableSource r1, ObservableSource<? extends R> r2) {
        this.source = r1;
        this.other = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> r3) {
        AndThenObservableObserver r0 = new AndThenObservableObserver(r3, this.other);
        r3.onSubscribe(r0);
        this.source.subscribe(r0);
    }
}

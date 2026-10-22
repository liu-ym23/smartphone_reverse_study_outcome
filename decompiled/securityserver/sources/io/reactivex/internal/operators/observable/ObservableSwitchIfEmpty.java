package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends T> other;

    public static final class SwitchIfEmptyObserver<T> implements Observer<T> {
        final SequentialDisposable arbiter;
        final Observer<? super T> downstream;
        boolean empty;
        final ObservableSource<? extends T> other;

        public SwitchIfEmptyObserver(Observer<? super T> r1, ObservableSource<? extends T> r2) {
            this.downstream = r1;
            this.other = r2;
            this.empty = true;
            this.arbiter = new SequentialDisposable();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.empty == false) goto L5;
            this.empty = false;
            this.other.subscribe(this);
            return;
        L5:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.empty == false) goto L5;
            this.empty = false;
        L5:
            this.downstream.onNext(r2);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            this.arbiter.update(r1);
        }
    }

    public ObservableSwitchIfEmpty(ObservableSource<T> r1, ObservableSource<? extends T> r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        SwitchIfEmptyObserver r0 = new SwitchIfEmptyObserver(r3, this.other);
        r3.onSubscribe(r0.arbiter);
        this.source.subscribe(r0);
    }
}

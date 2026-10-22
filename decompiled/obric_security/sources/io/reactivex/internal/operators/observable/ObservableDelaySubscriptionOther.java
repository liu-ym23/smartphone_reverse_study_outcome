package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {
    final ObservableSource<? extends T> main;
    final ObservableSource<U> other;

    final class DelayObserver implements Observer<U> {
        final Observer<? super T> child;
        boolean done;
        final SequentialDisposable serial;
        final /* synthetic */ ObservableDelaySubscriptionOther this$0;

        final class OnComplete implements Observer<T> {
            final /* synthetic */ DelayObserver this$1;

            OnComplete(DelayObserver r1) {
                this.this$1 = r1;
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable r1) {
                this.this$1.serial.update(r1);
            }

            @Override // io.reactivex.Observer
            public void onNext(T r1) {
                this.this$1.child.onNext(r1);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable r1) {
                this.this$1.child.onError(r1);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                this.this$1.child.onComplete();
            }
        }

        DelayObserver(ObservableDelaySubscriptionOther r1, SequentialDisposable r2, Observer<? super T> r3) {
            this.this$0 = r1;
            this.serial = r2;
            this.child = r3;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            this.serial.update(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(U r1) {
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.child.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.this$0.main.subscribe(new OnComplete(this));
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> r1, ObservableSource<U> r2) {
        this.main = r1;
        this.other = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        SequentialDisposable r0 = new SequentialDisposable();
        r3.onSubscribe(r0);
        DelayObserver r1 = new DelayObserver(this, r0, r3);
        this.other.subscribe(r1);
    }
}

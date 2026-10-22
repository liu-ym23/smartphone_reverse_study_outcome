package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends U> other;

    static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1418547743690811973L;
        final Observer<? super T> downstream;
        final AtomicThrowable error;
        final TakeUntilMainObserver<T, U>.OtherObserver otherObserver;
        final AtomicReference<Disposable> upstream;

        final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -8693423678067375039L;
            final /* synthetic */ TakeUntilMainObserver this$0;

            OtherObserver(TakeUntilMainObserver r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.Observer
            public void onNext(U r1) {
                DisposableHelper.dispose(this);
                this.this$0.otherComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable r1) {
                this.this$0.otherError(r1);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                this.this$0.otherComplete();
            }
        }

        TakeUntilMainObserver(Observer<? super T> r1) {
            this.downstream = r1;
            this.upstream = new AtomicReference();
            this.otherObserver = new OtherObserver(this);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.upstream, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            HalfSerializer.onNext(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            DisposableHelper.dispose(this.otherObserver);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        void otherError(Throwable r3) {
            DisposableHelper.dispose(this.upstream);
            HalfSerializer.onError(this.downstream, r3, this, this.error);
        }

        void otherComplete() {
            DisposableHelper.dispose(this.upstream);
            HalfSerializer.onComplete(this.downstream, this, this.error);
        }
    }

    public ObservableTakeUntil(ObservableSource<T> r1, ObservableSource<? extends U> r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        TakeUntilMainObserver r0 = new TakeUntilMainObserver(r3);
        r3.onSubscribe(r0);
        this.other.subscribe(r0.otherObserver);
        this.source.subscribe(r0);
    }
}

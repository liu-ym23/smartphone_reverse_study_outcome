package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableRetryBiPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    final BiPredicate<? super Integer, ? super Throwable> predicate;

    public static final class RetryBiObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Observer<? super T> downstream;
        final BiPredicate<? super Integer, ? super Throwable> predicate;
        int retries;
        final ObservableSource<? extends T> source;
        final SequentialDisposable upstream;

        public RetryBiObserver(Observer<? super T> r1, BiPredicate<? super Integer, ? super Throwable> r2, SequentialDisposable r3, ObservableSource<? extends T> r4) {
            this.downstream = r1;
            this.upstream = r3;
            this.source = r4;
            this.predicate = r2;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            BiPredicate<? super Integer, ? super Throwable> r0 = this.predicate;     // Catch: Throwable -> L8
            int r1 = this.retries + 1;     // Catch: Throwable -> L8
            this.retries = r1;     // Catch: Throwable -> L8
            if (r0.test(Integer.valueOf(r1), r3) == true) goto L6;
            this.downstream.onError(r3);
            return;
        L6:
            subscribeNext();
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r3, th}));
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            this.upstream.replace(r1);
        }

        public void subscribeNext() {
            if (getAndIncrement() != 0) goto L10;
            int r0 = 1;
        L6:
            if (this.upstream.isDisposed() == true) goto L7;
            this.source.subscribe(this);
            r0 = addAndGet(-r0);
            if (r0 != 0) goto L6;
            return;
        L7:
            return;
        }
    }

    public ObservableRetryBiPredicate(Observable<T> r1, BiPredicate<? super Integer, ? super Throwable> r2) {
        super(r1);
        this.predicate = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r4) {
        SequentialDisposable r0 = new SequentialDisposable();
        r4.onSubscribe(r0);
        new RetryBiObserver(r4, this.predicate, r0, this.source).subscribeNext();
    }
}

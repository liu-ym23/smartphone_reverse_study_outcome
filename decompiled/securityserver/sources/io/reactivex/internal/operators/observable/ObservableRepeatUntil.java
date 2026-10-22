package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableRepeatUntil<T> extends AbstractObservableWithUpstream<T, T> {
    final BooleanSupplier until;

    public static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Observer<? super T> downstream;
        final ObservableSource<? extends T> source;
        final BooleanSupplier stop;
        final SequentialDisposable upstream;

        public RepeatUntilObserver(Observer<? super T> r1, BooleanSupplier r2, SequentialDisposable r3, ObservableSource<? extends T> r4) {
            this.downstream = r1;
            this.upstream = r3;
            this.source = r4;
            this.stop = r2;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.stop.getAsBoolean() == false) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            subscribeNext();
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
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
            if (getAndIncrement() != 0) goto L7;
            int r0 = 1;
        L5:
            this.source.subscribe(this);
            r0 = addAndGet(-r0);
            if (r0 != 0) goto L5;
            return;
        }
    }

    public ObservableRepeatUntil(Observable<T> r1, BooleanSupplier r2) {
        super(r1);
        this.until = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r4) {
        SequentialDisposable r0 = new SequentialDisposable();
        r4.onSubscribe(r0);
        new RepeatUntilObserver(r4, this.until, r0, this.source).subscribeNext();
    }
}

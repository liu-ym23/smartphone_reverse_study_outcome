package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {
    final Scheduler scheduler;
    final TimeUnit unit;

    static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Timed<T>> downstream;
        long lastTime;
        final Scheduler scheduler;
        final TimeUnit unit;
        Disposable upstream;

        TimeIntervalObserver(Observer<? super Timed<T>> r1, TimeUnit r2, Scheduler r3) {
            this.downstream = r1;
            this.scheduler = r3;
            this.unit = r2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r3) {
            if (DisposableHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.lastTime = this.scheduler.now(this.unit);
            this.downstream.onSubscribe(this);
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

        @Override // io.reactivex.Observer
        public void onNext(T r5) {
            long r0 = this.scheduler.now(this.unit);
            long r2 = this.lastTime;
            this.lastTime = r0;
            long r1 = r0 - r2;
            this.downstream.onNext(new Timed(r5, r1, this.unit));
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }
    }

    public ObservableTimeInterval(ObservableSource<T> r1, TimeUnit r2, Scheduler r3) {
        super(r1);
        this.scheduler = r3;
        this.unit = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Timed<T>> r4) {
        this.source.subscribe(new TimeIntervalObserver(r4, this.unit, this.scheduler));
    }
}

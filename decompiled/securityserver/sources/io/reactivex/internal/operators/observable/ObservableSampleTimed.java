package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final boolean emitLast;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    public static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        public SampleTimedEmitLast(Observer<? super T> r1, long r2, TimeUnit r4, Scheduler r5) {
            super(r1, r2, r4, r5);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        public void complete() {
            emit();
            if (this.wip.decrementAndGet() != 0) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() != 2) goto L8;
            emit();
            if (this.wip.decrementAndGet() != 0) goto L9;
            this.downstream.onComplete();
            return;
        L9:
            return;
        }
    }

    public static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public SampleTimedNoLast(Observer<? super T> r1, long r2, TimeUnit r4, Scheduler r5) {
            super(r1, r2, r4, r5);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        public void complete() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    public static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> downstream;
        final long period;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer;
        final TimeUnit unit;
        Disposable upstream;

        public SampleTimedObserver(Observer<? super T> r2, long r3, TimeUnit r5, Scheduler r6) {
            this.timer = new AtomicReference();
            this.downstream = r2;
            this.period = r3;
            this.unit = r5;
            this.scheduler = r6;
        }

        public void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        public abstract void complete();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancelTimer();
            this.upstream.dispose();
        }

        public void emit() {
            T r0 = getAndSet(null);
            if (r0 == null) goto L6;
            this.downstream.onNext(r0);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            cancelTimer();
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            lazySet(r1);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r8) {
            if (DisposableHelper.validate(this.upstream, r8) == false) goto L6;
            this.upstream = r8;
            this.downstream.onSubscribe(this);
            Scheduler r0 = this.scheduler;
            long r4 = this.period;
            Disposable r9 = r0.schedulePeriodicallyDirect(this, r4, r4, this.unit);
            DisposableHelper.replace(this.timer, r9);
            return;
        }
    }

    public ObservableSampleTimed(ObservableSource<T> r1, long r2, TimeUnit r4, Scheduler r5, boolean r6) {
        super(r1);
        this.period = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.emitLast = r6;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r8) {
        SerializedObserver r1 = new SerializedObserver(r8);
        if (this.emitLast == false) goto L5;
        this.source.subscribe(new SampleTimedEmitLast(r1, this.period, this.unit, this.scheduler));
        return;
    L5:
        this.source.subscribe(new SampleTimedNoLast(r1, this.period, this.unit, this.scheduler));
    }
}

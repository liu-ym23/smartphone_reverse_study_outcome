package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableTimer extends Observable<Long> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final Observer<? super Long> downstream;

        public TimerObserver(Observer<? super Long> r1) {
            this.downstream = r1;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed() == true) goto L6;
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
            return;
        }

        public void setResource(Disposable r1) {
            DisposableHelper.trySet(this, r1);
        }
    }

    public ObservableTimer(long r1, TimeUnit r3, Scheduler r4) {
        this.delay = r1;
        this.unit = r3;
        this.scheduler = r4;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Long> r4) {
        TimerObserver r0 = new TimerObserver(r4);
        r4.onSubscribe(r0);
        r0.setResource(this.scheduler.scheduleDirect(r0, this.delay, this.unit));
    }
}

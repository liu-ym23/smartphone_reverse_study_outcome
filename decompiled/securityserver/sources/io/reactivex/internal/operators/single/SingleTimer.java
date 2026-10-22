package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleTimer extends Single<Long> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        final SingleObserver<? super Long> downstream;

        public TimerDisposable(SingleObserver<? super Long> r1) {
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

        @Override // java.lang.Runnable
        public void run() {
            this.downstream.onSuccess(0L);
        }

        public void setFuture(Disposable r1) {
            DisposableHelper.replace(this, r1);
        }
    }

    public SingleTimer(long r1, TimeUnit r3, Scheduler r4) {
        this.delay = r1;
        this.unit = r3;
        this.scheduler = r4;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Long> r4) {
        TimerDisposable r0 = new TimerDisposable(r4);
        r4.onSubscribe(r0);
        r0.setFuture(this.scheduler.scheduleDirect(r0, this.delay, this.unit));
    }
}

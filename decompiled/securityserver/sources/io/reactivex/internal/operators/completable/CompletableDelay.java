package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableDelay extends Completable {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final CompletableSource source;
    final TimeUnit unit;

    public static final class Delay extends AtomicReference<Disposable> implements CompletableObserver, Runnable, Disposable {
        private static final long serialVersionUID = 465972761105851022L;
        final long delay;
        final boolean delayError;
        final CompletableObserver downstream;
        Throwable error;
        final Scheduler scheduler;
        final TimeUnit unit;

        public Delay(CompletableObserver r1, long r2, TimeUnit r4, Scheduler r5, boolean r6) {
            this.downstream = r1;
            this.delay = r2;
            this.unit = r4;
            this.scheduler = r5;
            this.delayError = r6;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this, this.delay, this.unit));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r4) {
            this.error = r4;
            Scheduler r5 = this.scheduler;
            if (this.delayError == false) goto L5;
            long r0 = this.delay;
        L6:
            DisposableHelper.replace(this, r5.scheduleDirect(this, r0, this.unit));
            return;
        L5:
            r0 = 0;
            goto L6
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            if (DisposableHelper.setOnce(this, r1) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable r0 = this.error;
            this.error = null;
            if (r0 == null) goto L5;
            this.downstream.onError(r0);
            return;
        L5:
            this.downstream.onComplete();
        }
    }

    public CompletableDelay(CompletableSource r1, long r2, TimeUnit r4, Scheduler r5, boolean r6) {
        this.source = r1;
        this.delay = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.delayError = r6;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r10) {
        this.source.subscribe(new Delay(r10, this.delay, this.unit, this.scheduler, this.delayError));
    }
}

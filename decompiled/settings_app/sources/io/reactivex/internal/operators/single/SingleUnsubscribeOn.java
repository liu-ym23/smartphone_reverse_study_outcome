package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleUnsubscribeOn<T> extends Single<T> {
    final Scheduler scheduler;
    final SingleSource<T> source;

    static final class UnsubscribeOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final SingleObserver<? super T> downstream;
        Disposable ds;
        final Scheduler scheduler;

        UnsubscribeOnSingleObserver(SingleObserver<? super T> r1, Scheduler r2) {
            this.downstream = r1;
            this.scheduler = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable r0 = getAndSet(DisposableHelper.DISPOSED);
            if (r0 == DisposableHelper.DISPOSED) goto L6;
            this.ds = r0;
            this.scheduler.scheduleDirect(this);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.ds.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            if (DisposableHelper.setOnce(this, r1) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }
    }

    public SingleUnsubscribeOn(SingleSource<T> r1, Scheduler r2) {
        this.source = r1;
        this.scheduler = r2;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new UnsubscribeOnSingleObserver(r3, this.scheduler));
    }
}

package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleUnsubscribeOn<T> extends Single<T> {
    final Scheduler scheduler;
    final SingleSource<T> source;

    public static final class UnsubscribeOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final SingleObserver<? super T> downstream;
        Disposable ds;
        final Scheduler scheduler;

        public UnsubscribeOnSingleObserver(SingleObserver<? super T> r1, Scheduler r2) {
            this.downstream = r1;
            this.scheduler = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper r0 = DisposableHelper.DISPOSED;
            Disposable r1 = getAndSet(r0);
            if (r1 == r0) goto L6;
            this.ds = r1;
            this.scheduler.scheduleDirect(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
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

        @Override // java.lang.Runnable
        public void run() {
            this.ds.dispose();
        }
    }

    public SingleUnsubscribeOn(SingleSource<T> r1, Scheduler r2) {
        this.source = r1;
        this.scheduler = r2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> r3) {
        this.source.subscribe(new UnsubscribeOnSingleObserver(r3, this.scheduler));
    }
}

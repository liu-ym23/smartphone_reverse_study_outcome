package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleTimeout<T> extends Single<T> {
    final SingleSource<? extends T> other;
    final Scheduler scheduler;
    final SingleSource<T> source;
    final long timeout;
    final TimeUnit unit;

    public static final class TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {
        private static final long serialVersionUID = 37497744973048446L;
        final SingleObserver<? super T> downstream;
        final TimeoutFallbackObserver<T> fallback;
        SingleSource<? extends T> other;
        final AtomicReference<Disposable> task;
        final long timeout;
        final TimeUnit unit;

        public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            final SingleObserver<? super T> downstream;

            public TimeoutFallbackObserver(SingleObserver<? super T> r1) {
                this.downstream = r1;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable r1) {
                this.downstream.onError(r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T r1) {
                this.downstream.onSuccess(r1);
            }
        }

        public TimeoutMainObserver(SingleObserver<? super T> r1, SingleSource<? extends T> r2, long r3, TimeUnit r5) {
            this.downstream = r1;
            this.other = r2;
            this.timeout = r3;
            this.unit = r5;
            this.task = new AtomicReference();
            if (r2 == null) goto L5;
            this.fallback = new TimeoutFallbackObserver(r1);
            return;
        L5:
            this.fallback = null;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.task);
            TimeoutFallbackObserver<T> r1 = this.fallback;
            if (r1 == null) goto L6;
            DisposableHelper.dispose(r1);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r3) {
            Disposable r0 = get();
            DisposableHelper r1 = DisposableHelper.DISPOSED;
            if (r0 != r1) goto L5;
        L7:
            RxJavaPlugins.onError(r3);
            return;
        L5:
            if (compareAndSet(r0, r1) == false) goto L7;
            DisposableHelper.dispose(this.task);
            this.downstream.onError(r3);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r3) {
            Disposable r0 = get();
            DisposableHelper r1 = DisposableHelper.DISPOSED;
            if (r0 != r1) goto L5;
            return;
        L5:
            if (compareAndSet(r0, r1) == false) goto L9;
            DisposableHelper.dispose(this.task);
            this.downstream.onSuccess(r3);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            Disposable r0 = get();
            DisposableHelper r1 = DisposableHelper.DISPOSED;
            if (r0 != r1) goto L5;
            return;
        L5:
            if (compareAndSet(r0, r1) == false) goto L14;
            if (r0 == null) goto L8;
            r0.dispose();
        L8:
            SingleSource<? extends T> r2 = this.other;
            if (r2 != null) goto L11;
            this.downstream.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.timeout, this.unit)));
            return;
        L11:
            this.other = null;
            r2.subscribe(this.fallback);
            return;
        }
    }

    public SingleTimeout(SingleSource<T> r1, long r2, TimeUnit r4, Scheduler r5, SingleSource<? extends T> r6) {
        this.source = r1;
        this.timeout = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.other = r6;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> r8) {
        TimeoutMainObserver r6 = new TimeoutMainObserver(r8, this.other, this.timeout, this.unit);
        r8.onSubscribe(r6);
        DisposableHelper.replace(r6.task, this.scheduler.scheduleDirect(r6, this.timeout, this.unit));
        this.source.subscribe(r6);
    }
}

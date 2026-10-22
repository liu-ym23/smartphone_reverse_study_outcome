package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public static final class DelayObserver<T> implements Observer<T>, Disposable {
        final long delay;
        final boolean delayError;
        final Observer<? super T> downstream;
        final TimeUnit unit;
        Disposable upstream;
        final Scheduler.Worker w;

        public final class OnComplete implements Runnable {
            final /* synthetic */ DelayObserver this$0;

            public OnComplete(DelayObserver r1) {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.downstream.onComplete();     // Catch: Throwable -> L5
                this.this$0.w.dispose();
                return;
            L5:
                th = move-exception;
                this.this$0.w.dispose();
                throw th;
            }
        }

        public final class OnError implements Runnable {
            final /* synthetic */ DelayObserver this$0;
            private final Throwable throwable;

            public OnError(DelayObserver r1, Throwable r2) {
                this.this$0 = r1;
                this.throwable = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.downstream.onError(this.throwable);     // Catch: Throwable -> L5
                this.this$0.w.dispose();
                return;
            L5:
                th = move-exception;
                this.this$0.w.dispose();
                throw th;
            }
        }

        public final class OnNext implements Runnable {
            private final T t;
            final /* synthetic */ DelayObserver this$0;

            public OnNext(DelayObserver r1, T r2) {
                this.this$0 = r1;
                this.t = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.downstream.onNext(this.t);
            }
        }

        public DelayObserver(Observer<? super T> r1, long r2, TimeUnit r4, Scheduler.Worker r5, boolean r6) {
            this.downstream = r1;
            this.delay = r2;
            this.unit = r4;
            this.w = r5;
            this.delayError = r6;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.w.schedule(new OnComplete(this), this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r5) {
            Scheduler.Worker r0 = this.w;
            OnError r1 = new OnError(this, r5);
            if (this.delayError == false) goto L5;
            long r2 = this.delay;
        L6:
            r0.schedule(r1, r2, this.unit);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        @Override // io.reactivex.Observer
        public void onNext(T r5) {
            this.w.schedule(new OnNext(this, r5), this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public ObservableDelay(ObservableSource<T> r1, long r2, TimeUnit r4, Scheduler r5, boolean r6) {
        super(r1);
        this.delay = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.delayError = r6;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r9) {
        if (this.delayError == false) goto L5;
        Observer<? super T> r2 = r9;
    L6:
        Scheduler.Worker r6 = this.scheduler.createWorker();
        this.source.subscribe(new DelayObserver(r2, this.delay, this.unit, r6, this.delayError));
        return;
    L5:
        r2 = new SerializedObserver(r9);
        goto L6
    }
}

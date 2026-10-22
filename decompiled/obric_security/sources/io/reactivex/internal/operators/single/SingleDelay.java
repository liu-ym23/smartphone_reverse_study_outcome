package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleDelay<T> extends Single<T> {
    final boolean delayError;
    final Scheduler scheduler;
    final SingleSource<? extends T> source;
    final long time;
    final TimeUnit unit;

    final class Delay implements SingleObserver<T> {
        final SingleObserver<? super T> downstream;
        private final SequentialDisposable sd;
        final /* synthetic */ SingleDelay this$0;

        final class OnError implements Runnable {
            private final Throwable e;
            final /* synthetic */ Delay this$1;

            OnError(Delay r1, Throwable r2) {
                this.this$1 = r1;
                this.e = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$1.downstream.onError(this.e);
            }
        }

        final class OnSuccess implements Runnable {
            final /* synthetic */ Delay this$1;
            private final T value;

            OnSuccess(Delay r1, T r2) {
                this.this$1 = r1;
                this.value = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$1.downstream.onSuccess(this.value);
            }
        }

        Delay(SingleDelay r1, SequentialDisposable r2, SingleObserver<? super T> r3) {
            this.this$0 = r1;
            this.sd = r2;
            this.downstream = r3;
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            this.sd.replace(r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r6) {
            this.sd.replace(this.this$0.scheduler.scheduleDirect(new OnSuccess(this, r6), this.this$0.time, this.this$0.unit));
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r6) {
            SequentialDisposable r0 = this.sd;
            Scheduler r1 = this.this$0.scheduler;
            OnError r2 = new OnError(this, r6);
            if (this.this$0.delayError == false) goto L5;
            long r3 = this.this$0.time;
        L6:
            r0.replace(r1.scheduleDirect(r2, r3, this.this$0.unit));
            return;
        L5:
            r3 = 0;
            goto L6
        }
    }

    public SingleDelay(SingleSource<? extends T> r1, long r2, TimeUnit r4, Scheduler r5, boolean r6) {
        this.source = r1;
        this.time = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.delayError = r6;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r4) {
        SequentialDisposable r0 = new SequentialDisposable();
        r4.onSubscribe(r0);
        this.source.subscribe(new Delay(this, r0, r4));
    }
}

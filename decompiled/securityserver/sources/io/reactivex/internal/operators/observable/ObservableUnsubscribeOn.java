package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableUnsubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler scheduler;

    public static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1015244841293359600L;
        final Observer<? super T> downstream;
        final Scheduler scheduler;
        Disposable upstream;

        public final class DisposeTask implements Runnable {
            final /* synthetic */ UnsubscribeObserver this$0;

            public DisposeTask(UnsubscribeObserver r1) {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.this$0.upstream.dispose();
            }
        }

        public UnsubscribeObserver(Observer<? super T> r1, Scheduler r2) {
            this.downstream = r1;
            this.scheduler = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true) == false) goto L6;
            this.scheduler.scheduleDirect(new DisposeTask(this));
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (get() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (get() == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (get() == true) goto L6;
            this.downstream.onNext(r2);
            return;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public ObservableUnsubscribeOn(ObservableSource<T> r1, Scheduler r2) {
        super(r1);
        this.scheduler = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        this.source.subscribe(new UnsubscribeObserver(r3, this.scheduler));
    }
}

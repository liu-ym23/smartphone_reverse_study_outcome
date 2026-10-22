package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler scheduler;

    public static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8094547886072529208L;
        final Observer<? super T> downstream;
        final AtomicReference<Disposable> upstream;

        public SubscribeOnObserver(Observer<? super T> r1) {
            this.downstream = r1;
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.upstream, r1);
        }

        public void setDisposable(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }
    }

    public final class SubscribeTask implements Runnable {
        private final SubscribeOnObserver<T> parent;
        final /* synthetic */ ObservableSubscribeOn this$0;

        public SubscribeTask(ObservableSubscribeOn r1, SubscribeOnObserver<T> r2) {
            this.this$0 = r1;
            this.parent = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.source.subscribe(this.parent);
        }
    }

    public ObservableSubscribeOn(ObservableSource<T> r1, Scheduler r2) {
        super(r1);
        this.scheduler = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r3) {
        SubscribeOnObserver r0 = new SubscribeOnObserver(r3);
        r3.onSubscribe(r0);
        r0.setDisposable(this.scheduler.scheduleDirect(new SubscribeTask(this, r0)));
    }
}

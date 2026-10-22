package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCollect<T, U> extends AbstractObservableWithUpstream<T, U> {
    final BiConsumer<? super U, ? super T> collector;
    final Callable<? extends U> initialSupplier;

    public static final class CollectObserver<T, U> implements Observer<T>, Disposable {
        final BiConsumer<? super U, ? super T> collector;
        boolean done;
        final Observer<? super U> downstream;
        final U u;
        Disposable upstream;

        public CollectObserver(Observer<? super U> r1, U r2, BiConsumer<? super U, ? super T> r3) {
            this.downstream = r1;
            this.collector = r3;
            this.u = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onNext(this.u);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            if (this.done == false) goto L10;
            return;
        L10:
            this.collector.accept(this.u, r3);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public ObservableCollect(ObservableSource<T> r1, Callable<? extends U> r2, BiConsumer<? super U, ? super T> r3) {
        super(r1);
        this.initialSupplier = r2;
        this.collector = r3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> r4) {
        Object r0 = ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initialSupplier returned a null value");     // Catch: Throwable -> L5
        this.source.subscribe(new CollectObserver(r4, r0, this.collector));
        return;
    L5:
        th = move-exception;
        EmptyDisposable.error(th, r4);
    }
}

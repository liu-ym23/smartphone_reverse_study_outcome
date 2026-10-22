package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    final T defaultValue;
    final boolean errorOnFewer;
    final long index;

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        long count;
        final T defaultValue;
        boolean done;
        final Observer<? super T> downstream;
        final boolean errorOnFewer;
        final long index;
        Disposable upstream;

        ElementAtObserver(Observer<? super T> r1, long r2, T r4, boolean r5) {
            this.downstream = r1;
            this.index = r2;
            this.defaultValue = r4;
            this.errorOnFewer = r5;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
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
        public void onNext(T r5) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.count;
            if (r0 != this.index) goto L9;
            this.done = true;
            this.upstream.dispose();
            this.downstream.onNext(r5);
            this.downstream.onComplete();
            return;
        L9:
            this.count = r0 + 1;
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
        public void onComplete() {
            if (this.done == true) goto L13;
            this.done = true;
            T r0 = this.defaultValue;
            if (r0 == null) goto L7;
        L9:
            if (r0 == null) goto L11;
            this.downstream.onNext(r0);
        L11:
            this.downstream.onComplete();
            return;
        L7:
            if (this.errorOnFewer == false) goto L9;
            this.downstream.onError(new NoSuchElementException());
            return;
        }
    }

    public ObservableElementAt(ObservableSource<T> r1, long r2, T r4, boolean r5) {
        super(r1);
        this.index = r2;
        this.defaultValue = r4;
        this.errorOnFewer = r5;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r9) {
        this.source.subscribe(new ElementAtObserver(r9, this.index, this.defaultValue, this.errorOnFewer));
    }
}

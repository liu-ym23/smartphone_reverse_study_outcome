package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableAmb<T> extends Observable<T> {
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    public static final class AmbCoordinator<T> implements Disposable {
        final Observer<? super T> downstream;
        final AmbInnerObserver<T>[] observers;
        final AtomicInteger winner;

        public AmbCoordinator(Observer<? super T> r2, int r3) {
            this.winner = new AtomicInteger();
            this.downstream = r2;
            this.observers = new AmbInnerObserver[r3];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.winner.get() == (-1)) goto L7;
            this.winner.lazySet(-1);
            AmbInnerObserver<T>[] r3 = this.observers;
            int r0 = r3.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.winner.get() != (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public void subscribe(ObservableSource<? extends T>[] r8) {
            AmbInnerObserver<T>[] r0 = this.observers;
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            int r5 = r3 + 1;
            r0[r3] = new AmbInnerObserver(this, r5, this.downstream);
            r3 = r5;
            goto L3
        L5:
            this.winner.lazySet(0);
            this.downstream.onSubscribe(this);
        L6:
            if (r2 >= r1) goto L11;
            if (this.winner.get() != 0) goto L9;
            r8[r2].subscribe(r0[r2]);
            r2 = r2 + 1;
            goto L6
        L9:
            return;
        }

        public boolean win(int r5) {
            int r0 = this.winner.get();
            int r2 = 0;
            if (r0 == 0) goto L5;
            if (r0 != r5) goto L17;
            return true;
        L17:
            return false;
        L5:
            if (this.winner.compareAndSet(0, r5) == false) goto L13;
            AmbInnerObserver<T>[] r4 = this.observers;
            int r1 = r4.length;
        L7:
            if (r2 >= r1) goto L12;
            int r3 = r2 + 1;
            if (r3 == r5) goto L11;
            r4[r2].dispose();
        L11:
            r2 = r3;
            goto L7
        L12:
            return true;
        L13:
            return false;
        }
    }

    public static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final Observer<? super T> downstream;
        final int index;
        final AmbCoordinator<T> parent;
        boolean won;

        public AmbInnerObserver(AmbCoordinator<T> r1, int r2, Observer<? super T> r3) {
            this.parent = r1;
            this.index = r2;
            this.downstream = r3;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.won == false) goto L6;
            this.downstream.onComplete();
            return;
        L6:
            if (this.parent.win(this.index) == false) goto L10;
            this.won = true;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            if (this.won == false) goto L6;
            this.downstream.onError(r3);
            return;
        L6:
            if (this.parent.win(this.index) == false) goto L8;
            this.won = true;
            this.downstream.onError(r3);
            return;
        L8:
            RxJavaPlugins.onError(r3);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r3) {
            if (this.won == false) goto L6;
            this.downstream.onNext(r3);
            return;
        L6:
            if (this.parent.win(this.index) == false) goto L8;
            this.won = true;
            this.downstream.onNext(r3);
            return;
        L8:
            get().dispose();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] r1, Iterable<? extends ObservableSource<? extends T>> r2) {
        this.sources = r1;
        this.sourcesIterable = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r6) {
        ObservableSource<? extends T>[] r0 = this.sources;
        if (r0 != null) goto L21;
        r0 = new Observable[8];
        Iterator<? extends ObservableSource<? extends T>> r5 = this.sourcesIterable.iterator();     // Catch: Throwable -> L12
        int r2 = 0;
    L7:
        if (r5.hasNext() == false) goto L22;
        ObservableSource<? extends T> r3 = r5.next();     // Catch: Throwable -> L12
        if (r3 == null) goto L10;
        if (r2 != r0.length) goto L17;
        ObservableSource<? extends T>[] r4 = new ObservableSource[(r2 >> 2) + r2];     // Catch: Throwable -> L12
        System.arraycopy(r0, 0, r4, 0, r2);     // Catch: Throwable -> L12
        r0 = r4;
    L17:
        int r7 = r2 + 1;     // Catch: Throwable -> L12
        r0[r2] = r3;     // Catch: Throwable -> L12
        r2 = r7;
        goto L7
    L10:
        EmptyDisposable.error(new NullPointerException("One of the sources is null"), r6);     // Catch: Throwable -> L12
        return;
    L22:
        if (r2 != 0) goto L26;
        EmptyDisposable.complete(r6);
        return;
    L26:
        if (r2 != 1) goto L29;
        r0[0].subscribe(r6);
        return;
    L29:
        new AmbCoordinator(r6, r2).subscribe(r0);
        return;
    L12:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r6);
        return;
    L21:
        r2 = r0.length;
        goto L22
    }
}

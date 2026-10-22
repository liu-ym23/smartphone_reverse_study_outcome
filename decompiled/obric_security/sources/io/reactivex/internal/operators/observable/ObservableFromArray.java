package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableFromArray<T> extends Observable<T> {
    final T[] array;

    static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {
        final T[] array;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        boolean fusionMode;
        int index;

        FromArrayDisposable(Observer<? super T> r1, T[] r2) {
            this.downstream = r1;
            this.array = r2;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 1) == 0) goto L6;
            this.fusionMode = true;
            return 1;
        L6:
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            int r0 = this.index;
            T[] r1 = this.array;
            if (r0 == r1.length) goto L6;
            this.index = r0 + 1;
            return (T) ObjectHelper.requireNonNull(r1[r0], "The array element is null");
        L6:
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (this.index != this.array.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.index = this.array.length;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        void run() {
            T[] r0 = this.array;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L12;
            if (isDisposed() == true) goto L12;
            T r3 = r0[r2];
            if (r3 == null) goto L8;
            this.downstream.onNext(r3);
            r2 = r2 + 1;
            goto L3
        L8:
            this.downstream.onError(new NullPointerException("The element at index " + r2 + " is null"));
            return;
        L12:
            if (isDisposed() == true) goto L18;
            this.downstream.onComplete();
            return;
        }
    }

    public ObservableFromArray(T[] r1) {
        this.array = r1;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r2) {
        FromArrayDisposable r0 = new FromArrayDisposable(r2, this.array);
        r2.onSubscribe(r0);
        if (r0.fusionMode == false) goto L5;
        return;
    L5:
        r0.run();
    }
}

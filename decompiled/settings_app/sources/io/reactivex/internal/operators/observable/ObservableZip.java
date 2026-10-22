package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableZip<T, R> extends Observable<R> {
    final int bufferSize;
    final boolean delayError;
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final Observer<? super R> downstream;
        final ZipObserver<T, R>[] observers;
        final T[] row;
        final Function<? super Object[], ? extends R> zipper;

        ZipCoordinator(Observer<? super R> r1, Function<? super Object[], ? extends R> r2, int r3, boolean r4) {
            this.downstream = r1;
            this.zipper = r2;
            this.observers = new ZipObserver[r3];
            this.row = (T[]) new Object[r3];
            this.delayError = r4;
        }

        public void subscribe(ObservableSource<? extends T>[] r6, int r7) {
            ZipObserver<T, R>[] r0 = this.observers;
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            r0[r3] = new ZipObserver(this, r7);
            r3 = r3 + 1;
            goto L3
        L5:
            lazySet(0);
            this.downstream.onSubscribe(this);
        L6:
            if (r2 >= r1) goto L11;
            if (this.cancelled == true) goto L9;
            r6[r2].subscribe(r0[r2]);
            r2 = r2 + 1;
            goto L6
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() != 0) goto L9;
            clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancel() {
            clear();
            cancelSources();
        }

        void cancelSources() {
            ZipObserver<T, R>[] r3 = this.observers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L3
        }

        void clear() {
            ZipObserver<T, R>[] r3 = this.observers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].queue.clear();
            r1 = r1 + 1;
            goto L3
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            ZipObserver<T, R>[] r0 = this.observers;
            Observer<? super R> r8 = this.downstream;
            T[] r9 = this.row;
            boolean r10 = this.delayError;
            int r12 = 1;
        L6:
            int r13 = r0.length;
            int r15 = 0;
            int r16 = 0;
            int r17 = 0;
        L7:
            if (r15 >= r13) goto L28;
            ZipObserver<T, R> r6 = r0[r15];
            if (r9[r17] != null) goto L21;
            boolean r2 = r6.done;
            T r18 = r6.queue.poll();
            if (r18 != null) goto L13;
            boolean r19 = true;
        L15:
            if (checkTerminated(r2, r19, r8, r10, r6) == true) goto L16;
            if (r19 == true) goto L19;
            r9[r17] = r18;
        L27:
            r17 = r17 + 1;
            r15 = r15 + 1;
            goto L7
        L19:
            r16 = r16 + 1;
            goto L27
        L16:
            return;
        L13:
            r19 = false;
            goto L15
        L21:
            if (r6.done == false) goto L27;
            if (r10 == true) goto L27;
            Throwable r1 = r6.error;
            if (r1 == null) goto L27;
            this.cancelled = true;
            cancel();
            r8.onError(r1);
            return;
        L28:
            if (r16 != 0) goto L29;
            r8.onNext((Object) ObjectHelper.requireNonNull(this.zipper.apply(r9.clone()), "The zipper returned a null value"));
            Arrays.fill(r9, null);
        L34:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancel();
            r8.onError(th);
            return;
        L29:
            r12 = addAndGet(-r12);
            if (r12 != 0) goto L6;
        }

        boolean checkTerminated(boolean r3, boolean r4, Observer<? super R> r5, boolean r6, ZipObserver<?, ?> r7) {
            if (this.cancelled == false) goto L6;
            cancel();
            return true;
        L6:
            if (r3 == false) goto L21;
            if (r6 == false) goto L14;
            if (r4 == false) goto L23;
            Throwable r8 = r7.error;
            this.cancelled = true;
            cancel();
            if (r8 == null) goto L12;
            r5.onError(r8);
        L13:
            return true;
        L12:
            r5.onComplete();
            goto L13
        L23:
            return false;
        L14:
            Throwable r9 = r7.error;
            if (r9 == null) goto L18;
            this.cancelled = true;
            cancel();
            r5.onError(r9);
            return true;
        L18:
            if (r4 == false) goto L24;
            this.cancelled = true;
            cancel();
            r5.onComplete();
            return true;
        L24:
            return false;
        L21:
            return false;
        }
    }

    static final class ZipObserver<T, R> implements Observer<T> {
        volatile boolean done;
        Throwable error;
        final ZipCoordinator<T, R> parent;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicReference<Disposable> upstream;

        ZipObserver(ZipCoordinator<T, R> r2, int r3) {
            this.upstream = new AtomicReference();
            this.parent = r2;
            this.queue = new SpscLinkedArrayQueue(r3);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this.upstream, r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            this.queue.offer(r2);
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void dispose() {
            DisposableHelper.dispose(this.upstream);
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] r1, Iterable<? extends ObservableSource<? extends T>> r2, Function<? super Object[], ? extends R> r3, int r4, boolean r5) {
        this.sources = r1;
        this.sourcesIterable = r2;
        this.zipper = r3;
        this.bufferSize = r4;
        this.delayError = r5;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> r7) {
        ObservableSource<? extends T>[] r0 = this.sources;
        if (r0 != null) goto L11;
        r0 = new Observable[8];
        Iterator<? extends ObservableSource<? extends T>> r1 = this.sourcesIterable.iterator();
        int r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L12;
        ObservableSource<? extends T> r4 = r1.next();
        if (r3 != r0.length) goto L10;
        ObservableSource<? extends T>[] r5 = new ObservableSource[(r3 >> 2) + r3];
        System.arraycopy(r0, 0, r5, 0, r3);
        r0 = r5;
    L10:
        r0[r3] = r4;
        r3 = r3 + 1;
    L12:
        if (r3 != 0) goto L15;
        EmptyDisposable.complete(r7);
        return;
    L15:
        new ZipCoordinator(r7, this.zipper, r3, this.delayError).subscribe(r0, this.bufferSize);
        return;
    L11:
        r3 = r0.length;
        goto L12
    }
}

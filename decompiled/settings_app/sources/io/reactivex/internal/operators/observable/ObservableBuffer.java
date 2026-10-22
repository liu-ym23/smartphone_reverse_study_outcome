package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int count;
    final int skip;

    static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        U buffer;
        final Callable<U> bufferSupplier;
        final int count;
        final Observer<? super U> downstream;
        int size;
        Disposable upstream;

        BufferExactObserver(Observer<? super U> r1, int r2, Callable<U> r3) {
            this.downstream = r1;
            this.count = r2;
            this.bufferSupplier = r3;
        }

        boolean createBuffer() {
            this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "Empty buffer supplied");
            return true;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.buffer = null;
            Disposable r1 = this.upstream;
            if (r1 != null) goto L9;
            EmptyDisposable.error(th, this.downstream);
            return false;
        L9:
            r1.dispose();
            this.downstream.onError(th);
            return false;
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
        public void onNext(T r3) {
            U r0 = this.buffer;
            if (r0 == null) goto L8;
            r0.add(r3);
            int r4 = this.size + 1;
            this.size = r4;
            if (r4 < this.count) goto L9;
            this.downstream.onNext(r0);
            this.size = 0;
            createBuffer();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.buffer = null;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U r0 = this.buffer;
            if (r0 == null) goto L9;
            this.buffer = null;
            if (r0.isEmpty() == true) goto L7;
            this.downstream.onNext(r0);
        L7:
            this.downstream.onComplete();
            return;
        }
    }

    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8223395059921494546L;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers;
        final int count;
        final Observer<? super U> downstream;
        long index;
        final int skip;
        Disposable upstream;

        BufferSkipObserver(Observer<? super U> r1, int r2, int r3, Callable<U> r4) {
            this.downstream = r1;
            this.count = r2;
            this.skip = r3;
            this.bufferSupplier = r4;
            this.buffers = new ArrayDeque();
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
            long r0 = this.index;
            this.index = 1 + r0;
            if ((r0 % ((long) this.skip)) == 0) goto L16;
        L9:
            Iterator<U> r1 = this.buffers.iterator();
        L11:
            if (r1.hasNext() == false) goto L15;
            U r2 = r1.next();
            r2.add(r5);
            if (this.count > r2.size()) goto L11;
            r1.remove();
            this.downstream.onNext(r2);
            goto L11
        L15:
            return;
        L16:
            Collection r3 = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L6
            this.buffers.offer((U) r3);
        L6:
            th = move-exception;
            this.buffers.clear();
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            this.buffers.clear();
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        L3:
            if (this.buffers.isEmpty() == true) goto L5;
            this.downstream.onNext(this.buffers.poll());
            goto L3
        L5:
            this.downstream.onComplete();
        }
    }

    public ObservableBuffer(ObservableSource<T> r1, int r2, int r3, Callable<U> r4) {
        super(r1);
        this.count = r2;
        this.skip = r3;
        this.bufferSupplier = r4;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> r5) {
        if (this.skip != this.count) goto L7;
        BufferExactObserver r0 = new BufferExactObserver(r5, this.count, this.bufferSupplier);
        if (r0.createBuffer() == false) goto L9;
        this.source.subscribe(r0);
        return;
    L9:
        return;
    L7:
        this.source.subscribe(new BufferSkipObserver(r5, this.count, this.skip, this.bufferSupplier));
    }
}

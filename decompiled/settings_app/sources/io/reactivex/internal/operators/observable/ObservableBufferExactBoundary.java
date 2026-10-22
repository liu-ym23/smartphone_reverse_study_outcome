package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    final ObservableSource<B> boundary;
    final Callable<U> bufferSupplier;

    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        final BufferExactBoundaryObserver<T, U, B> parent;

        BufferBoundaryObserver(BufferExactBoundaryObserver<T, U, B> r1) {
            this.parent = r1;
        }

        @Override // io.reactivex.Observer
        public void onNext(B r1) {
            this.parent.next();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.parent.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.onComplete();
        }
    }

    static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        final ObservableSource<B> boundary;
        U buffer;
        final Callable<U> bufferSupplier;
        Disposable other;
        Disposable upstream;

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer r1, Object r2) {
            accept(r1, (Collection) r2);
        }

        BufferExactBoundaryObserver(Observer<? super U> r2, Callable<U> r3, ObservableSource<B> r4) {
            super(r2, new MpscLinkedQueue());
            this.bufferSupplier = r3;
            this.boundary = r4;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r3) {
            if (DisposableHelper.validate(this.upstream, r3) == false) goto L14;
            this.upstream = r3;
            this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
            BufferBoundaryObserver r4 = new BufferBoundaryObserver(this);
            this.other = r4;
            this.downstream.onSubscribe(this);
            if (this.cancelled == true) goto L15;
            this.boundary.subscribe(r4);
            return;
        L15:
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            r3.dispose();
            EmptyDisposable.error(th, this.downstream);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L10
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L7:
            r0.add(r2);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            dispose();
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            monitor-enter(this);
            U r0 = this.buffer;     // Catch: Throwable -> L13
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            this.buffer = null;     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            this.queue.offer(r0);
            this.done = true;
            if (enter() == false) goto L17;
            QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this, this);
            return;
        L17:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.other.dispose();
            this.upstream.dispose();
            if (enter() == false) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void next() {
            U r0 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");     // Catch: Throwable -> L15
            monitor-enter(this);
            U r1 = this.buffer;     // Catch: Throwable -> L12
            if (r1 != null) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L8:
            this.buffer = r0;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            fastPathEmit(r1, false, this);
            return;
        L12:
            th = move-exception;
            throw th;
        L15:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.downstream.onError(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void accept(Observer<? super U> r1, U r2) {
            this.downstream.onNext((Object) r2);
        }
    }

    public ObservableBufferExactBoundary(ObservableSource<T> r1, ObservableSource<B> r2, Callable<U> r3) {
        super(r1);
        this.boundary = r2;
        this.bufferSupplier = r3;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> r4) {
        this.source.subscribe(new BufferExactBoundaryObserver(new SerializedObserver(r4), this.bufferSupplier, this.boundary));
    }
}

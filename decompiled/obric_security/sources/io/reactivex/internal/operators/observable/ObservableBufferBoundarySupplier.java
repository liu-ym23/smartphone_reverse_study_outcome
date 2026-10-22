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
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    final Callable<? extends ObservableSource<B>> boundarySupplier;
    final Callable<U> bufferSupplier;

    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        boolean once;
        final BufferBoundarySupplierObserver<T, U, B> parent;

        BufferBoundaryObserver(BufferBoundarySupplierObserver<T, U, B> r1) {
            this.parent = r1;
        }

        @Override // io.reactivex.Observer
        public void onNext(B r1) {
            if (this.once == false) goto L5;
            return;
        L5:
            this.once = true;
            dispose();
            this.parent.next();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.once == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.once = true;
            this.parent.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.once == false) goto L5;
            return;
        L5:
            this.once = true;
            this.parent.next();
        }
    }

    static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        final Callable<? extends ObservableSource<B>> boundarySupplier;
        U buffer;
        final Callable<U> bufferSupplier;
        final AtomicReference<Disposable> other;
        Disposable upstream;

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer r1, Object r2) {
            accept(r1, (Collection) r2);
        }

        BufferBoundarySupplierObserver(Observer<? super U> r2, Callable<U> r3, Callable<? extends ObservableSource<B>> r4) {
            super(r2, new MpscLinkedQueue());
            this.other = new AtomicReference();
            this.bufferSupplier = r3;
            this.boundarySupplier = r4;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r5) {
            if (DisposableHelper.validate(this.upstream, r5) == false) goto L21;
            this.upstream = r5;
            Observer<? super V> r0 = this.downstream;
            this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
            ObservableSource r2 = (ObservableSource) ObjectHelper.requireNonNull(this.boundarySupplier.call(), "The boundary ObservableSource supplied is null");     // Catch: Throwable -> L11
            BufferBoundaryObserver r6 = new BufferBoundaryObserver(this);
            this.other.set(r6);
            r0.onSubscribe(this);
            if (this.cancelled == true) goto L22;
            r2.subscribe(r6);
            return;
        L22:
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            r5.dispose();
            EmptyDisposable.error(th, r0);
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            r5.dispose();
            EmptyDisposable.error(th, r0);
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
            this.upstream.dispose();
            disposeOther();
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

        void disposeOther() {
            DisposableHelper.dispose(this.other);
        }

        void next() {
            U r0 = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");     // Catch: Throwable -> L21
            ObservableSource r1 = (ObservableSource) ObjectHelper.requireNonNull(this.boundarySupplier.call(), "The boundary ObservableSource supplied is null");     // Catch: Throwable -> L18
            BufferBoundaryObserver r2 = new BufferBoundaryObserver(this);
            if (DisposableHelper.replace(this.other, r2) == false) goto L17;
            monitor-enter(this);
            U r3 = this.buffer;     // Catch: Throwable -> L14
            if (r3 != null) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L11:
            this.buffer = r0;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            r1.subscribe(r2);
            fastPathEmit(r3, false, this);
            return;
        L14:
            th = move-exception;
            throw th;
        L17:
            return;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            this.upstream.dispose();
            this.downstream.onError(th);
            return;
        L21:
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

    public ObservableBufferBoundarySupplier(ObservableSource<T> r1, Callable<? extends ObservableSource<B>> r2, Callable<U> r3) {
        super(r1);
        this.boundarySupplier = r2;
        this.bufferSupplier = r3;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> r4) {
        this.source.subscribe(new BufferBoundarySupplierObserver(new SerializedObserver(r4), this.bufferSupplier, this.boundarySupplier));
    }
}

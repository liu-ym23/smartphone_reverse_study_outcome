package io.reactivex.internal.operators.observable;

import adcpeJava.adcpe.Ciphertext;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final int bufferSize;
    final ErrorMode delayErrors;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable error;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final DelayErrorInnerObserver<R> observer;
        SimpleQueue<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        Disposable upstream;

        static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final Observer<? super R> downstream;
            final ConcatMapDelayErrorObserver<?, R> parent;

            DelayErrorInnerObserver(Observer<? super R> r1, ConcatMapDelayErrorObserver<?, R> r2) {
                this.downstream = r1;
                this.parent = r2;
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable r1) {
                DisposableHelper.replace(this, r1);
            }

            @Override // io.reactivex.Observer
            public void onNext(R r1) {
                this.downstream.onNext(r1);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable r2) {
                ConcatMapDelayErrorObserver<?, R> r1 = this.parent;
                if (r1.error.addThrowable(r2) == true) goto L5;
                RxJavaPlugins.onError(r2);
                return;
            L5:
                if (r1.tillTheEnd == true) goto L7;
                r1.upstream.dispose();
            L7:
                r1.active = false;
                r1.drain();
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> r1 = this.parent;
                r1.active = false;
                r1.drain();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        ConcatMapDelayErrorObserver(Observer<? super R> r1, Function<? super T, ? extends ObservableSource<? extends R>> r2, int r3, boolean r4) {
            this.downstream = r1;
            this.mapper = r2;
            this.bufferSize = r3;
            this.tillTheEnd = r4;
            this.error = new AtomicThrowable();
            this.observer = new DelayErrorInnerObserver(r1, this);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r3) {
            if (DisposableHelper.validate(this.upstream, r3) == false) goto L16;
            this.upstream = r3;
            if ((r3 instanceof QueueDisposable) == false) goto L14;
            QueueDisposable r4 = (QueueDisposable) r3;
            int r0 = r4.requestFusion(3);
            if (r0 != 1) goto L11;
            this.sourceMode = r0;
            this.queue = r4;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
        L11:
            if (r0 != 2) goto L14;
            this.sourceMode = r0;
            this.queue = r4;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new SpscLinkedArrayQueue(this.bufferSize);
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.sourceMode != 0) goto L5;
            this.queue.offer(r2);
        L5:
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.dispose();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super R> r0 = this.downstream;
            SimpleQueue<T> r1 = this.queue;
            AtomicThrowable r2 = this.error;
        L7:
            if (this.active == true) goto L49;
            if (this.cancelled == true) goto L10;
            if (this.tillTheEnd == false) goto L15;
        L18:
            boolean r3 = this.done;
            T r5 = r1.poll();     // Catch: Throwable -> L45
            if (r5 != null) goto L22;
            boolean r6 = true;
        L23:
            if (r3 == false) goto L30;
            if (r6 == false) goto L30;
            this.cancelled = true;
            Throwable r7 = r2.terminate();
            if (r7 == null) goto L28;
            r0.onError(r7);
            return;
        L28:
            r0.onComplete();
            return;
        L30:
            if (r6 == true) goto L49;
            ObservableSource r4 = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(r5), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L42
            if ((r4 instanceof Callable) == false) goto L41;
            Ciphertext r8 = (Object) ((Callable) r4).call();
            if (r8 == null) goto L7;
            if (this.cancelled == true) goto L7;
            r0.onNext(r8);
        L39:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2.addThrowable(th);
            goto L7
        L41:
            this.active = true;
            r4.subscribe(this.observer);
        L42:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            this.upstream.dispose();
            r1.clear();
            r2.addThrowable(th);
            r0.onError(r2.terminate());
            return;
        L22:
            r6 = false;
        L45:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            this.upstream.dispose();
            r2.addThrowable(th);
            r0.onError(r2.terminate());
            return;
        L15:
            if (r2.get() == null) goto L18;
            r1.clear();
            this.cancelled = true;
            r0.onError(r2.terminate());
            return;
        L10:
            r1.clear();
            return;
        L49:
            if (decrementAndGet() != 0) goto L7;
        }
    }

    static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final Observer<? super U> downstream;
        int fusionMode;
        final InnerObserver<U> inner;
        final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        SimpleQueue<T> queue;
        Disposable upstream;

        static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final Observer<? super U> downstream;
            final SourceObserver<?, ?> parent;

            InnerObserver(Observer<? super U> r1, SourceObserver<?, ?> r2) {
                this.downstream = r1;
                this.parent = r2;
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable r1) {
                DisposableHelper.replace(this, r1);
            }

            @Override // io.reactivex.Observer
            public void onNext(U r1) {
                this.downstream.onNext(r1);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable r2) {
                this.parent.dispose();
                this.downstream.onError(r2);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        SourceObserver(Observer<? super U> r1, Function<? super T, ? extends ObservableSource<? extends U>> r2, int r3) {
            this.downstream = r1;
            this.mapper = r2;
            this.bufferSize = r3;
            this.inner = new InnerObserver(r1, this);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r3) {
            if (DisposableHelper.validate(this.upstream, r3) == false) goto L16;
            this.upstream = r3;
            if ((r3 instanceof QueueDisposable) == false) goto L14;
            QueueDisposable r4 = (QueueDisposable) r3;
            int r0 = r4.requestFusion(3);
            if (r0 != 1) goto L11;
            this.fusionMode = r0;
            this.queue = r4;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
        L11:
            if (r0 != 2) goto L14;
            this.fusionMode = r0;
            this.queue = r4;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new SpscLinkedArrayQueue(this.bufferSize);
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.fusionMode != 0) goto L8;
            this.queue.offer(r2);
        L8:
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            dispose();
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            drain();
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.upstream.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.disposed == true) goto L7;
            if (this.active == true) goto L31;
            boolean r0 = this.done;
            T r1 = this.queue.poll();     // Catch: Throwable -> L27
            if (r1 != null) goto L16;
            boolean r3 = true;
        L17:
            if (r0 == false) goto L21;
            if (r3 == false) goto L21;
            this.disposed = true;
            this.downstream.onComplete();
            return;
        L21:
            if (r3 == true) goto L31;
            ObservableSource r2 = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(r1), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L24
            this.active = true;
            r2.subscribe(this.inner);
        L24:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.queue.clear();
            this.downstream.onError(th);
            return;
        L16:
            r3 = false;
        L27:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.queue.clear();
            this.downstream.onError(th);
            return;
        L31:
            if (decrementAndGet() != 0) goto L6;
            return;
        L7:
            this.queue.clear();
        }
    }

    public ObservableConcatMap(ObservableSource<T> r1, Function<? super T, ? extends ObservableSource<? extends U>> r2, int r3, ErrorMode r4) {
        super(r1);
        this.mapper = r2;
        this.delayErrors = r4;
        this.bufferSize = Math.max(8, r3);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> r6) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, r6, this.mapper) == false) goto L6;
        return;
    L6:
        if (this.delayErrors != ErrorMode.IMMEDIATE) goto L8;
        SerializedObserver r0 = new SerializedObserver(r6);
        this.source.subscribe(new SourceObserver(r0, this.mapper, this.bufferSize));
        return;
    L8:
        ObservableSource<T> r1 = this.source;
        Function<? super T, ? extends ObservableSource<? extends U>> r2 = this.mapper;
        int r3 = this.bufferSize;
        if (this.delayErrors != ErrorMode.END) goto L11;
        boolean r5 = true;
    L12:
        r1.subscribe(new ConcatMapDelayErrorObserver(r6, r2, r3, r5));
        return;
    L11:
        r5 = false;
        goto L12
    }
}

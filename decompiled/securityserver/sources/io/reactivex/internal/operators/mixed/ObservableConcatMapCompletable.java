package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
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
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableConcatMapCompletable<T> extends Completable {
    final ErrorMode errorMode;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int prefetch;
    final Observable<T> source;

    public static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        volatile boolean disposed;
        volatile boolean done;
        final CompletableObserver downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors;
        final ConcatMapInnerObserver inner;
        final Function<? super T, ? extends CompletableSource> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        Disposable upstream;

        public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            final ConcatMapCompletableObserver<?> parent;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver<?> r1) {
                this.parent = r1;
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable r1) {
                this.parent.innerError(r1);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.replace(this, r1);
            }
        }

        public ConcatMapCompletableObserver(CompletableObserver r1, Function<? super T, ? extends CompletableSource> r2, ErrorMode r3, int r4) {
            this.downstream = r1;
            this.mapper = r2;
            this.errorMode = r3;
            this.prefetch = r4;
            this.errors = new AtomicThrowable();
            this.inner = new ConcatMapInnerObserver(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            return;
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            AtomicThrowable r0 = this.errors;
            ErrorMode r1 = this.errorMode;
        L7:
            if (this.disposed == true) goto L8;
            if (this.active == true) goto L38;
            if (r1 == ErrorMode.BOUNDARY) goto L15;
        L18:
            boolean r2 = this.done;
            T r4 = this.queue.poll();     // Catch: Throwable -> L23
            if (r4 == null) goto L25;
            CompletableSource r5 = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(r4), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L23
            boolean r6 = false;
        L26:
            if (r2 == false) goto L33;
            if (r6 == false) goto L33;
            this.disposed = true;
            Throwable r3 = r0.terminate();
            if (r3 == null) goto L31;
            this.downstream.onError(r3);
            return;
        L31:
            this.downstream.onComplete();
            return;
        L33:
            if (r6 == true) goto L38;
            this.active = true;
            r5.subscribe(this.inner);
            goto L38
        L25:
            r5 = null;
            r6 = true;
        L23:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.disposed = true;
            this.queue.clear();
            this.upstream.dispose();
            r0.addThrowable(th);
            this.downstream.onError(r0.terminate());
            return;
        L15:
            if (r0.get() == null) goto L18;
            this.disposed = true;
            this.queue.clear();
            this.downstream.onError(r0.terminate());
            return;
        L38:
            if (decrementAndGet() != 0) goto L7;
            return;
        L8:
            this.queue.clear();
        }

        public void innerComplete() {
            this.active = false;
            drain();
        }

        public void innerError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
            this.disposed = true;
            this.upstream.dispose();
            Throwable r3 = this.errors.terminate();
            if (r3 == ExceptionHelper.TERMINATED) goto L10;
            this.downstream.onError(r3);
        L10:
            if (getAndIncrement() != 0) goto L15;
            this.queue.clear();
            return;
        L15:
            return;
        L12:
            this.active = false;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            if (this.errors.addThrowable(r3) == true) goto L5;
            RxJavaPlugins.onError(r3);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
            this.disposed = true;
            this.inner.dispose();
            Throwable r4 = this.errors.terminate();
            if (r4 == ExceptionHelper.TERMINATED) goto L10;
            this.downstream.onError(r4);
        L10:
            if (getAndIncrement() != 0) goto L15;
            this.queue.clear();
            return;
        L15:
            return;
        L12:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (r2 == null) goto L4;
            this.queue.offer(r2);
        L4:
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r3) {
            if (DisposableHelper.validate(this.upstream, r3) == false) goto L16;
            this.upstream = r3;
            if ((r3 instanceof QueueDisposable) == false) goto L14;
            QueueDisposable r4 = (QueueDisposable) r3;
            int r0 = r4.requestFusion(3);
            if (r0 != 1) goto L11;
            this.queue = r4;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
        L11:
            if (r0 != 2) goto L14;
            this.queue = r4;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new SpscLinkedArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public ObservableConcatMapCompletable(Observable<T> r1, Function<? super T, ? extends CompletableSource> r2, ErrorMode r3, int r4) {
        this.source = r1;
        this.mapper = r2;
        this.errorMode = r3;
        this.prefetch = r4;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r5) {
        if (ScalarXMapZHelper.tryAsCompletable(this.source, this.mapper, r5) == true) goto L6;
        this.source.subscribe(new ConcatMapCompletableObserver(r5, this.mapper, this.errorMode, this.prefetch));
        return;
    }
}

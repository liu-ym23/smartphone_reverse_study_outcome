package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatMapMaybe<T, R> extends Observable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final int prefetch;
    final Observable<T> source;

    static final class ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        volatile boolean done;
        final Observer<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors;
        final ConcatMapMaybeObserver<R> inner;
        R item;
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        final SimplePlainQueue<T> queue;
        volatile int state;
        Disposable upstream;

        static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapMaybeMainObserver<?, R> parent;

            ConcatMapMaybeObserver(ConcatMapMaybeMainObserver<?, R> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.replace(this, r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r1) {
                this.parent.innerSuccess(r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable r1) {
                this.parent.innerError(r1);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        ConcatMapMaybeMainObserver(Observer<? super R> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, int r3, ErrorMode r4) {
            this.downstream = r1;
            this.mapper = r2;
            this.errorMode = r4;
            this.errors = new AtomicThrowable();
            this.inner = new ConcatMapMaybeObserver(this);
            this.queue = new SpscLinkedArrayQueue(r3);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
            this.inner.dispose();
        L7:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            this.item = null;
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void innerSuccess(R r1) {
            this.item = r1;
            this.state = 2;
            drain();
        }

        void innerComplete() {
            this.state = 0;
            drain();
        }

        void innerError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.errorMode == ErrorMode.END) goto L7;
            this.upstream.dispose();
        L7:
            this.state = 0;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super R> r0 = this.downstream;
            ErrorMode r1 = this.errorMode;
            SimplePlainQueue<T> r2 = this.queue;
            AtomicThrowable r3 = this.errors;
            int r5 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            int r6 = this.state;
            if (r3.get() != null) goto L12;
        L18:
            boolean r8 = false;
            if (r6 == 0) goto L20;
            if (r6 != 2) goto L40;
            R r7 = this.item;
            this.item = null;
            r0.onNext(r7);
            this.state = 0;
        L40:
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L7;
            return;
        L20:
            boolean r9 = this.done;
            T r10 = r2.poll();
            if (r10 != null) goto L23;
            r8 = true;
        L23:
            if (r9 == false) goto L30;
            if (r8 == false) goto L30;
            Throwable r11 = r3.terminate();
            if (r11 != null) goto L28;
            r0.onComplete();
            return;
        L28:
            r0.onError(r11);
            return;
        L30:
            if (r8 == true) goto L40;
            MaybeSource r12 = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(r10), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L34
            this.state = 1;
            r12.subscribe(this.inner);
        L34:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            r2.clear();
            r3.addThrowable(th);
            r0.onError(r3.terminate());
            return;
        L12:
            if (r1 == ErrorMode.IMMEDIATE) goto L16;
            if (r1 != ErrorMode.BOUNDARY) goto L18;
            if (r6 != 0) goto L18;
        L16:
            r2.clear();
            this.item = null;
            r0.onError(r3.terminate());
            return;
        L8:
            r2.clear();
            this.item = null;
            goto L40
        }
    }

    public ObservableConcatMapMaybe(Observable<T> r1, Function<? super T, ? extends MaybeSource<? extends R>> r2, ErrorMode r3, int r4) {
        this.source = r1;
        this.mapper = r2;
        this.errorMode = r3;
        this.prefetch = r4;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> r5) {
        if (ScalarXMapZHelper.tryAsMaybe(this.source, this.mapper, r5) == true) goto L6;
        this.source.subscribe(new ConcatMapMaybeMainObserver(r5, this.mapper, this.prefetch, this.errorMode));
        return;
    }
}

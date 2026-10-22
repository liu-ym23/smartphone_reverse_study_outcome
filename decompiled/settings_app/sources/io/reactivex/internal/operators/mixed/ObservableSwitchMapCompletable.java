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
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSwitchMapCompletable<T> extends Completable {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final Observable<T> source;

    static final class SwitchMapCompletableObserver<T> implements Observer<T>, Disposable {
        static final SwitchMapInnerObserver INNER_DISPOSED = null;
        final boolean delayErrors;
        volatile boolean done;
        final CompletableObserver downstream;
        final AtomicThrowable errors;
        final AtomicReference<SwitchMapInnerObserver> inner;
        final Function<? super T, ? extends CompletableSource> mapper;
        Disposable upstream;

        static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            final SwitchMapCompletableObserver<?> parent;

            SwitchMapInnerObserver(SwitchMapCompletableObserver<?> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable r2) {
                this.parent.innerError(this, r2);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete(this);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        static {
            INNER_DISPOSED = new SwitchMapInnerObserver(null);
        }

        SwitchMapCompletableObserver(CompletableObserver r1, Function<? super T, ? extends CompletableSource> r2, boolean r3) {
            this.downstream = r1;
            this.mapper = r2;
            this.delayErrors = r3;
            this.errors = new AtomicThrowable();
            this.inner = new AtomicReference();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r4) {
            CompletableSource r5 = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(r4), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L13
            SwitchMapInnerObserver r0 = new SwitchMapInnerObserver(this);
        L4:
            SwitchMapInnerObserver r1 = this.inner.get();
            if (r1 == INNER_DISPOSED) goto L21;
            if (this.inner.compareAndSet(r1, r0) == false) goto L4;
            if (r1 == null) goto L11;
            r1.dispose();
        L11:
            r5.subscribe(r0);
            return;
        L21:
            return;
        L13:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.delayErrors == false) goto L7;
            onComplete();
            return;
        L7:
            disposeInner();
            Throwable r3 = this.errors.terminate();
            if (r3 == ExceptionHelper.TERMINATED) goto L13;
            this.downstream.onError(r3);
            return;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            if (this.inner.get() != null) goto L9;
            Throwable r0 = this.errors.terminate();
            if (r0 != null) goto L7;
            this.downstream.onComplete();
            return;
        L7:
            this.downstream.onError(r0);
            return;
        }

        void disposeInner() {
            AtomicReference<SwitchMapInnerObserver> r1 = this.inner;
            SwitchMapInnerObserver r0 = INNER_DISPOSED;
            SwitchMapInnerObserver r2 = r1.getAndSet(r0);
            if (r2 == null) goto L7;
            if (r2 == r0) goto L8;
            r2.dispose();
            return;
        L8:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            disposeInner();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.inner.get() != INNER_DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        void innerError(SwitchMapInnerObserver r3, Throwable r4) {
            if (this.inner.compareAndSet(r3, null) == true) goto L5;
        L15:
            RxJavaPlugins.onError(r4);
            return;
        L5:
            if (this.errors.addThrowable(r4) == false) goto L15;
            if (this.delayErrors == true) goto L9;
            dispose();
            Throwable r5 = this.errors.terminate();
            if (r5 == ExceptionHelper.TERMINATED) goto L19;
            this.downstream.onError(r5);
            return;
        L19:
            return;
        L9:
            if (this.done == false) goto L17;
            Throwable r6 = this.errors.terminate();
            this.downstream.onError(r6);
            return;
        }

        void innerComplete(SwitchMapInnerObserver r3) {
            if (this.inner.compareAndSet(r3, null) == true) goto L5;
            return;
        L5:
            if (this.done == false) goto L12;
            Throwable r4 = this.errors.terminate();
            if (r4 != null) goto L9;
            this.downstream.onComplete();
            return;
        L9:
            this.downstream.onError(r4);
            return;
        }
    }

    public ObservableSwitchMapCompletable(Observable<T> r1, Function<? super T, ? extends CompletableSource> r2, boolean r3) {
        this.source = r1;
        this.mapper = r2;
        this.delayErrors = r3;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r4) {
        if (ScalarXMapZHelper.tryAsCompletable(this.source, this.mapper, r4) == true) goto L6;
        this.source.subscribe(new SwitchMapCompletableObserver(r4, this.mapper, this.delayErrors));
        return;
    }
}

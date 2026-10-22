package io.reactivex.internal.operators.observable;

import a.a.a.a.a.b.b;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final Observer<? super T> observer;
        final T value;

        public ScalarDisposable(Observer<? super T> r1, T r2) {
            this.observer = r1;
            this.value = r2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T r1) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T r1, T r2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            if (get() != 1) goto L6;
            lazySet(3);
            return this.value;
        L6:
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (get() != 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != 3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 1) == 0) goto L6;
            lazySet(1);
            return 1;
        L6:
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0) goto L5;
            return;
        L5:
            if (compareAndSet(0, 2) == false) goto L11;
            this.observer.onNext(this.value);
            if (get() != 2) goto L12;
            lazySet(3);
            this.observer.onComplete();
            return;
        L12:
            return;
        }
    }

    static final class ScalarXMapObservable<T, R> extends Observable<R> {
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final T value;

        ScalarXMapObservable(T r1, Function<? super T, ? extends ObservableSource<? extends R>> r2) {
            this.value = r1;
            this.mapper = r2;
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super R> r2) {
            ObservableSource r1 = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L15
            if ((r1 instanceof Callable) == true) goto L20;
            r1.subscribe(r2);
            return;
        L20:
            Object r3 = ((Callable) r1).call();     // Catch: Throwable -> L10
            if (r3 != null) goto L9;
            EmptyDisposable.complete(r2);
            return;
        L9:
            ScalarDisposable r0 = new ScalarDisposable(r2, r3);
            r2.onSubscribe(r0);
            r0.run();
            return;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, r2);
            return;
        L15:
            th = move-exception;
            EmptyDisposable.error(th, r2);
        }
    }

    private ObservableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean tryScalarXMapSubscribe(ObservableSource<T> r1, Observer<? super R> r2, Function<? super T, ? extends ObservableSource<? extends R>> r3) {
        if ((r1 instanceof Callable) == true) goto L34;
        return false;
    L34:
        b.a r4 = (Object) ((Callable) r1).call();
        if (r4 != null) goto L30;
        EmptyDisposable.complete(r2);
        return true;
    L30:
        ObservableSource r5 = (ObservableSource) ObjectHelper.requireNonNull(r3.apply(r4), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L22
        if ((r5 instanceof Callable) == true) goto L32;
        r5.subscribe(r2);
    L21:
        return true;
    L32:
        Object r6 = ((Callable) r5).call();     // Catch: Throwable -> L17
        if (r6 != null) goto L16;
        EmptyDisposable.complete(r2);
        return true;
    L16:
        ScalarDisposable r7 = new ScalarDisposable(r2, r6);
        r2.onSubscribe(r7);
        r7.run();
    L17:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r2);
        return true;
    L22:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r2);
        return true;
    L25:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r2);
        return true;
    }

    public static <T, U> Observable<U> scalarXMap(T r1, Function<? super T, ? extends ObservableSource<? extends U>> r2) {
        return RxJavaPlugins.onAssembly(new ScalarXMapObservable(r1, r2));
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, ? extends ObservableSource<U>> debounceSelector;

    static final class DebounceObserver<T, U> implements Observer<T>, Disposable {
        final Function<? super T, ? extends ObservableSource<U>> debounceSelector;
        final AtomicReference<Disposable> debouncer;
        boolean done;
        final Observer<? super T> downstream;
        volatile long index;
        Disposable upstream;

        static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {
            boolean done;
            final long index;
            final AtomicBoolean once;
            final DebounceObserver<T, U> parent;
            final T value;

            DebounceInnerObserver(DebounceObserver<T, U> r2, long r3, T r5) {
                this.once = new AtomicBoolean();
                this.parent = r2;
                this.index = r3;
                this.value = r5;
            }

            @Override // io.reactivex.Observer
            public void onNext(U r1) {
                if (this.done == false) goto L5;
                return;
            L5:
                this.done = true;
                dispose();
                emit();
            }

            void emit() {
                if (this.once.compareAndSet(false, true) == false) goto L6;
                this.parent.emit(this.index, this.value);
                return;
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable r2) {
                if (this.done == false) goto L6;
                RxJavaPlugins.onError(r2);
                return;
            L6:
                this.done = true;
                this.parent.onError(r2);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (this.done == false) goto L5;
                return;
            L5:
                this.done = true;
                emit();
            }
        }

        DebounceObserver(Observer<? super T> r2, Function<? super T, ? extends ObservableSource<U>> r3) {
            this.debouncer = new AtomicReference();
            this.downstream = r2;
            this.debounceSelector = r3;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r6) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.index + 1;
            this.index = r0;
            Disposable r2 = this.debouncer.get();
            if (r2 == null) goto L16;
            r2.dispose();
        L16:
            ObservableSource r3 = (ObservableSource) ObjectHelper.requireNonNull(this.debounceSelector.apply(r6), "The ObservableSource supplied is null");     // Catch: Throwable -> L13
            DebounceInnerObserver r4 = new DebounceInnerObserver(this, r0, r6);
            if (b0$$ExternalSyntheticBackport0.m(this.debouncer, r2, r4) == false) goto L18;
            r3.subscribe(r4);
            return;
        L18:
            return;
        L13:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r2) {
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            Disposable r0 = this.debouncer.get();
            if (r0 == DisposableHelper.DISPOSED) goto L12;
            DebounceInnerObserver r1 = (DebounceInnerObserver) r0;
            if (r1 == null) goto L10;
            r1.emit();
        L10:
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this.debouncer);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        void emit(long r3, T r5) {
            if (r3 != this.index) goto L6;
            this.downstream.onNext(r5);
            return;
        }
    }

    public ObservableDebounce(ObservableSource<T> r1, Function<? super T, ? extends ObservableSource<U>> r2) {
        super(r1);
        this.debounceSelector = r2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r4) {
        this.source.subscribe(new DebounceObserver(new SerializedObserver(r4), this.debounceSelector));
    }
}

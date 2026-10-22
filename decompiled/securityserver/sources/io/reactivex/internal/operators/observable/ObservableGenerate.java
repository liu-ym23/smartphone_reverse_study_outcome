package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableGenerate<T, S> extends Observable<T> {
    final Consumer<? super S> disposeState;
    final BiFunction<S, Emitter<T>, S> generator;
    final Callable<S> stateSupplier;

    public static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {
        volatile boolean cancelled;
        final Consumer<? super S> disposeState;
        final Observer<? super T> downstream;
        final BiFunction<S, ? super Emitter<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        public GeneratorDisposable(Observer<? super T> r1, BiFunction<S, ? super Emitter<T>, S> r2, Consumer<? super S> r3, S r4) {
            this.downstream = r1;
            this.generator = r2;
            this.disposeState = r3;
            this.state = r4;
        }

        private void dispose(S r1) {
            this.disposeState.accept(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.terminate == true) goto L6;
            this.terminate = true;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable r2) {
            if (this.terminate == false) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (r2 != null) goto L7;
            r2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L7:
            this.terminate = true;
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T r2) {
            if (this.terminate == false) goto L5;
            return;
        L5:
            if (this.hasNext == false) goto L7;
            onError(new IllegalStateException("onNext already called in this generate turn"));
            return;
        L7:
            if (r2 != null) goto L9;
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        L9:
            this.hasNext = true;
            this.downstream.onNext(r2);
        }

        public void run() {
            S r0 = this.state;
            if (this.cancelled == false) goto L6;
            this.state = null;
            dispose(r0);
            return;
        L6:
            BiFunction<S, ? super Emitter<T>, S> r1 = this.generator;
        L8:
            if (this.cancelled == true) goto L9;
            this.hasNext = false;
            r0 = r1.apply(r0, this);     // Catch: Throwable -> L17
            if (this.terminate == false) goto L8;
            this.cancelled = true;
            this.state = null;
            dispose(r0);
            return;
        L17:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.state = null;
            this.cancelled = true;
            onError(th);
            dispose(r0);
            return;
        L9:
            this.state = null;
            dispose(r0);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
        }
    }

    public ObservableGenerate(Callable<S> r1, BiFunction<S, Emitter<T>, S> r2, Consumer<? super S> r3) {
        this.stateSupplier = r1;
        this.generator = r2;
        this.disposeState = r3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r4) {
        S r0 = this.stateSupplier.call();     // Catch: Throwable -> L5
        GeneratorDisposable r1 = new GeneratorDisposable(r4, this.generator, this.disposeState, r0);
        r4.onSubscribe(r1);
        r1.run();
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r4);
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes2.dex */
public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {
    final Action onAfterTerminate;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;

    public static final class DoOnEachObserver<T> implements Observer<T>, Disposable {
        boolean done;
        final Observer<? super T> downstream;
        final Action onAfterTerminate;
        final Action onComplete;
        final Consumer<? super Throwable> onError;
        final Consumer<? super T> onNext;
        Disposable upstream;

        public DoOnEachObserver(Observer<? super T> r1, Consumer<? super T> r2, Consumer<? super Throwable> r3, Action r4, Action r5) {
            this.downstream = r1;
            this.onNext = r2;
            this.onError = r3;
            this.onComplete = r4;
            this.onAfterTerminate = r5;
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
        public void onComplete() {
            if (this.done == false) goto L15;
            return;
        L15:
            this.onComplete.run();     // Catch: Throwable -> L12
            this.done = true;
            this.downstream.onComplete();
            this.onAfterTerminate.run();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L12:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r3) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r3);
            return;
        L6:
            this.done = true;
            this.onError.accept(r3);     // Catch: Throwable -> L9
        L11:
            this.downstream.onError(r3);
            this.onAfterTerminate.run();     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r3 = new CompositeException(new Throwable[]{r3, th});
            goto L11
        }

        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            if (this.done == false) goto L11;
            return;
        L11:
            this.onNext.accept(r2);     // Catch: Throwable -> L8
            this.downstream.onNext(r2);
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public ObservableDoOnEach(ObservableSource<T> r1, Consumer<? super T> r2, Consumer<? super Throwable> r3, Action r4, Action r5) {
        super(r1);
        this.onNext = r2;
        this.onError = r3;
        this.onComplete = r4;
        this.onAfterTerminate = r5;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r9) {
        this.source.subscribe(new DoOnEachObserver(r9, this.onNext, this.onError, this.onComplete, this.onAfterTerminate));
    }
}

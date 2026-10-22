package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableUsing<R> extends Completable {
    final Function<? super R, ? extends CompletableSource> completableFunction;
    final Consumer<? super R> disposer;
    final boolean eager;
    final Callable<R> resourceSupplier;

    static final class UsingObserver<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -674404550052917487L;
        final Consumer<? super R> disposer;
        final CompletableObserver downstream;
        final boolean eager;
        Disposable upstream;

        UsingObserver(CompletableObserver r1, R r2, Consumer<? super R> r3, boolean r4) {
            super(r2);
            this.downstream = r1;
            this.disposer = r3;
            this.eager = r4;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            disposeResourceAfter();
        }

        void disposeResourceAfter() {
            Object r0 = getAndSet(this);
            if (r0 == this) goto L11;
            this.disposer.accept(r0);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r5) {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager == false) goto L11;
            Object r0 = getAndSet(this);
            if (r0 != this) goto L15;
            return;
        L15:
            this.disposer.accept(r0);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r5 = new CompositeException(new Throwable[]{r5, th});
        L11:
            this.downstream.onError(r5);
            if (this.eager == true) goto L17;
            disposeResourceAfter();
            return;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager == false) goto L11;
            Object r0 = getAndSet(this);
            if (r0 == this) goto L17;
            this.disposer.accept(r0);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            return;
        L17:
            return;
        L11:
            this.downstream.onComplete();
            if (this.eager == true) goto L18;
            disposeResourceAfter();
            return;
        }
    }

    public CompletableUsing(Callable<R> r1, Function<? super R, ? extends CompletableSource> r2, Consumer<? super R> r3, boolean r4) {
        this.resourceSupplier = r1;
        this.completableFunction = r2;
        this.disposer = r3;
        this.eager = r4;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r5) {
        R r0 = this.resourceSupplier.call();     // Catch: Throwable -> L21
        ((CompletableSource) ObjectHelper.requireNonNull(this.completableFunction.apply(r0), "The completableFunction returned a null CompletableSource")).subscribe(new UsingObserver(r5, r0, this.disposer, this.eager));
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (this.eager == true) goto L30;
    L14:
        EmptyDisposable.error(th, r5);
        if (this.eager == true) goto L32;
        this.disposer.accept(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        return;
    L32:
        return;
    L30:
        this.disposer.accept(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(new CompositeException(new Throwable[]{th, th}), r5);
        return;
    L21:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r5);
    }
}

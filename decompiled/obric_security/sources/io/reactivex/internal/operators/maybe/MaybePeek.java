package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {
    final Action onAfterTerminate;
    final Action onCompleteCall;
    final Action onDisposeCall;
    final Consumer<? super Throwable> onErrorCall;
    final Consumer<? super Disposable> onSubscribeCall;
    final Consumer<? super T> onSuccessCall;

    static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> downstream;
        final MaybePeek<T> parent;
        Disposable upstream;

        MaybePeekObserver(MaybeObserver<? super T> r1, MaybePeek<T> r2) {
            this.downstream = r1;
            this.parent = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.parent.onDisposeCall.run();     // Catch: Throwable -> L4
        L6:
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            goto L6
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable r2) {
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L11;
            this.parent.onSubscribeCall.accept(r2);     // Catch: Throwable -> L6
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, this.downstream);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r3) {
            if (this.upstream != DisposableHelper.DISPOSED) goto L11;
            return;
        L11:
            this.parent.onSuccessCall.accept(r3);     // Catch: Throwable -> L8
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onSuccess(r3);
            onAfterTerminate();
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            onErrorInner(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r3) {
            if (this.upstream != DisposableHelper.DISPOSED) goto L6;
            RxJavaPlugins.onError(r3);
            return;
        L6:
            onErrorInner(r3);
        }

        void onErrorInner(Throwable r5) {
            this.parent.onErrorCall.accept(r5);     // Catch: Throwable -> L4
        L6:
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(r5);
            onAfterTerminate();
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r5 = new CompositeException(new Throwable[]{r5, th});
            goto L6
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.upstream != DisposableHelper.DISPOSED) goto L11;
            return;
        L11:
            this.parent.onCompleteCall.run();     // Catch: Throwable -> L8
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onComplete();
            onAfterTerminate();
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            onErrorInner(th);
        }

        void onAfterTerminate() {
            this.parent.onAfterTerminate.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    public MaybePeek(MaybeSource<T> r1, Consumer<? super Disposable> r2, Consumer<? super T> r3, Consumer<? super Throwable> r4, Action r5, Action r6, Action r7) {
        super(r1);
        this.onSubscribeCall = r2;
        this.onSuccessCall = r3;
        this.onErrorCall = r4;
        this.onCompleteCall = r5;
        this.onAfterTerminate = r6;
        this.onDisposeCall = r7;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> r3) {
        this.source.subscribe(new MaybePeekObserver(r3, this));
    }
}

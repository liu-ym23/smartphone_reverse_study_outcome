package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletablePeek extends Completable {
    final Action onAfterTerminate;
    final Action onComplete;
    final Action onDispose;
    final Consumer<? super Throwable> onError;
    final Consumer<? super Disposable> onSubscribe;
    final Action onTerminate;
    final CompletableSource source;

    public final class CompletableObserverImplementation implements CompletableObserver, Disposable {
        final CompletableObserver downstream;
        final /* synthetic */ CompletablePeek this$0;
        Disposable upstream;

        public CompletableObserverImplementation(CompletablePeek r1, CompletableObserver r2) {
            this.this$0 = r1;
            this.downstream = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.this$0.onDispose.run();     // Catch: Throwable -> L4
        L6:
            this.upstream.dispose();
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            goto L6
        }

        public void doAfter() {
            this.this$0.onAfterTerminate.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.upstream != DisposableHelper.DISPOSED) goto L11;
            return;
        L11:
            this.this$0.onComplete.run();     // Catch: Throwable -> L8
            this.this$0.onTerminate.run();     // Catch: Throwable -> L8
            this.downstream.onComplete();
            doAfter();
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r3) {
            if (this.upstream != DisposableHelper.DISPOSED) goto L12;
            RxJavaPlugins.onError(r3);
            return;
        L12:
            this.this$0.onError.accept(r3);     // Catch: Throwable -> L8
            this.this$0.onTerminate.run();     // Catch: Throwable -> L8
        L10:
            this.downstream.onError(r3);
            doAfter();
            return;
        L8:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r3 = new CompositeException(new Throwable[]{r3, th});
            goto L10
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r2) {
            this.this$0.onSubscribe.accept(r2);     // Catch: Throwable -> L7
            if (DisposableHelper.validate(this.upstream, r2) == false) goto L12;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        L12:
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r2.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, this.downstream);
        }
    }

    public CompletablePeek(CompletableSource r1, Consumer<? super Disposable> r2, Consumer<? super Throwable> r3, Action r4, Action r5, Action r6, Action r7) {
        this.source = r1;
        this.onSubscribe = r2;
        this.onError = r3;
        this.onComplete = r4;
        this.onTerminate = r5;
        this.onAfterTerminate = r6;
        this.onDispose = r7;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r3) {
        this.source.subscribe(new CompletableObserverImplementation(this, r3));
    }
}

package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableCreate extends Completable {
    final CompletableOnSubscribe source;

    public static final class Emitter extends AtomicReference<Disposable> implements CompletableEmitter, Disposable {
        private static final long serialVersionUID = -2467358622224974244L;
        final CompletableObserver downstream;

        public Emitter(CompletableObserver r1) {
            this.downstream = r1;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.CompletableEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableEmitter
        public void onComplete() {
            Disposable r0 = get();
            DisposableHelper r1 = DisposableHelper.DISPOSED;
            if (r0 == r1) goto L13;
            Disposable r2 = getAndSet(r1);
            if (r2 == r1) goto L16;
            this.downstream.onComplete();     // Catch: Throwable -> L9
            if (r2 == null) goto L17;
            r2.dispose();
            return;
        L17:
            return;
        L9:
            th = move-exception;
            if (r2 == null) goto L12;
            r2.dispose();
        L12:
            throw th;
        L16:
            return;
        }

        @Override // io.reactivex.CompletableEmitter
        public void onError(Throwable r1) {
            if (tryOnError(r1) == true) goto L6;
            RxJavaPlugins.onError(r1);
            return;
        }

        @Override // io.reactivex.CompletableEmitter
        public void setCancellable(Cancellable r2) {
            setDisposable(new CancellableDisposable(r2));
        }

        @Override // io.reactivex.CompletableEmitter
        public void setDisposable(Disposable r1) {
            DisposableHelper.set(this, r1);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return Emitter.class.getSimpleName() + "{" + super.toString() + "}";
        }

        @Override // io.reactivex.CompletableEmitter
        public boolean tryOnError(Throwable r3) {
            if (r3 != null) goto L4;
            r3 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        L4:
            Disposable r0 = get();
            DisposableHelper r1 = DisposableHelper.DISPOSED;
            if (r0 == r1) goto L17;
            Disposable r2 = getAndSet(r1);
            if (r2 == r1) goto L22;
            this.downstream.onError(r3);     // Catch: Throwable -> L13
            if (r2 == null) goto L21;
            r2.dispose();
            return true;
        L21:
            return true;
        L13:
            th = move-exception;
            if (r2 == null) goto L16;
            r2.dispose();
        L16:
            throw th;
        L22:
            return false;
        L17:
            return false;
        }
    }

    public CompletableCreate(CompletableOnSubscribe r1) {
        this.source = r1;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r2) {
        Emitter r0 = new Emitter(r2);
        r2.onSubscribe(r0);
        this.source.subscribe(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r0.onError(th);
    }
}

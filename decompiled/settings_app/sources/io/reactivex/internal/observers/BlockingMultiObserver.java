package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {
    volatile boolean cancelled;
    Throwable error;
    Disposable upstream;
    T value;

    public BlockingMultiObserver() {
        super(1);
    }

    void dispose() {
        this.cancelled = true;
        Disposable r1 = this.upstream;
        if (r1 == null) goto L6;
        r1.dispose();
        return;
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r1) {
        this.upstream = r1;
        if (this.cancelled == false) goto L6;
        r1.dispose();
        return;
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r1) {
        this.value = r1;
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r1) {
        this.error = r1;
        countDown();
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        countDown();
    }

    public T blockingGet() {
        if (getCount() != 0) goto L15;
    L9:
        Throwable r0 = this.error;
        if (r0 != null) goto L14;
        return this.value;
    L14:
        throw ExceptionHelper.wrapOrThrow(r0);
    L15:
        BlockingHelper.verifyNonBlocking();     // Catch: InterruptedException -> L6
        await();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        dispose();
        throw ExceptionHelper.wrapOrThrow(e);
    }

    public T blockingGet(T r5) {
        if (getCount() != 0) goto L17;
    L9:
        Throwable r0 = this.error;
        if (r0 != null) goto L16;
        T r4 = this.value;
        if (r4 != null) goto L14;
        return r5;
    L14:
        return r4;
    L16:
        throw ExceptionHelper.wrapOrThrow(r0);
    L17:
        BlockingHelper.verifyNonBlocking();     // Catch: InterruptedException -> L6
        await();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        dispose();
        throw ExceptionHelper.wrapOrThrow(e);
    }

    public Throwable blockingGetError() {
        if (getCount() == 0) goto L10;
        BlockingHelper.verifyNonBlocking();     // Catch: InterruptedException -> L6
        await();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        dispose();
        return e;
    L10:
        return this.error;
    }

    public Throwable blockingGetError(long r5, TimeUnit r7) {
        if (getCount() == 0) goto L13;
        BlockingHelper.verifyNonBlocking();     // Catch: InterruptedException -> L9
        if (await(r5, r7) == true) goto L13;
        dispose();     // Catch: InterruptedException -> L9
        throw ExceptionHelper.wrapOrThrow(new TimeoutException(ExceptionHelper.timeoutMessage(r5, r7)));     // Catch: InterruptedException -> L9
    L9:
        e = move-exception;
        dispose();
        throw ExceptionHelper.wrapOrThrow(e);
    L13:
        return this.error;
    }

    public boolean blockingAwait(long r5, TimeUnit r7) {
        if (getCount() != 0) goto L18;
    L12:
        Throwable r4 = this.error;
        if (r4 != null) goto L17;
        return true;
    L17:
        throw ExceptionHelper.wrapOrThrow(r4);
    L18:
        BlockingHelper.verifyNonBlocking();     // Catch: InterruptedException -> L9
        if (await(r5, r7) == true) goto L12;
        dispose();     // Catch: InterruptedException -> L9
        return false;
    L9:
        e = move-exception;
        dispose();
        throw ExceptionHelper.wrapOrThrow(e);
    }
}

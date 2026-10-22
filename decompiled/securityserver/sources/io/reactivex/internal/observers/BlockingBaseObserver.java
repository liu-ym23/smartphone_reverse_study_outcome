package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {
    volatile boolean cancelled;
    Throwable error;
    Disposable upstream;
    T value;

    public BlockingBaseObserver() {
        super(1);
    }

    public final T blockingGet() {
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

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.cancelled = true;
        Disposable r1 = this.upstream;
        if (r1 == null) goto L6;
        r1.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r1) {
        this.upstream = r1;
        if (this.cancelled == false) goto L6;
        r1.dispose();
        return;
    }
}

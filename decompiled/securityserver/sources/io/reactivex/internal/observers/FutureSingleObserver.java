package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class FutureSingleObserver<T> extends CountDownLatch implements SingleObserver<T>, Future<T>, Disposable {
    Throwable error;
    final AtomicReference<Disposable> upstream;
    T value;

    public FutureSingleObserver() {
        super(1);
        this.upstream = new AtomicReference();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r3) {
    L2:
        Disposable r4 = this.upstream.get();
        if (r4 == this) goto L13;
        DisposableHelper r0 = DisposableHelper.DISPOSED;
        if (r4 == r0) goto L19;
        if (this.upstream.compareAndSet(r4, r0) == false) goto L2;
        if (r4 == null) goto L11;
        r4.dispose();
    L11:
        countDown();
        return true;
    L19:
        return false;
    L13:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() {
        if (getCount() == 0) goto L6;
        BlockingHelper.verifyNonBlocking();
        await();
    L6:
        if (isCancelled() == true) goto L14;
        Throwable r0 = this.error;
        if (r0 != null) goto L12;
        return this.value;
    L12:
        throw new ExecutionException(r0);
    L14:
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        if (getCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r3) {
    L2:
        Disposable r0 = this.upstream.get();
        if (r0 == DisposableHelper.DISPOSED) goto L4;
        this.error = r3;
        if (this.upstream.compareAndSet(r0, this) == false) goto L2;
        countDown();
        return;
    L4:
        RxJavaPlugins.onError(r3);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r1) {
        DisposableHelper.setOnce(this.upstream, r1);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r3) {
        Disposable r0 = this.upstream.get();
        if (r0 != DisposableHelper.DISPOSED) goto L5;
        return;
    L5:
        this.value = r3;
        this.upstream.compareAndSet(r0, this);
        countDown();
    }

    @Override // java.util.concurrent.Future
    public T get(long r5, TimeUnit r7) {
        if (getCount() == 0) goto L10;
        BlockingHelper.verifyNonBlocking();
        if (await(r5, r7) == true) goto L10;
        throw new TimeoutException(ExceptionHelper.timeoutMessage(r5, r7));
    L10:
        if (isCancelled() == true) goto L18;
        Throwable r6 = this.error;
        if (r6 != null) goto L16;
        return this.value;
    L16:
        throw new ExecutionException(r6);
    L18:
        throw new CancellationException();
    }
}

package io.reactivex.android;

import android.os.Looper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MainThreadDisposable implements Disposable {
    private final AtomicBoolean unsubscribed;

    public MainThreadDisposable() {
        this.unsubscribed = new AtomicBoolean();
    }

    public static void verifyMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.unsubscribed.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        onDispose();
        return;
    L7:
        AndroidSchedulers.mainThread().scheduleDirect(new AnonymousClass1(this));
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.unsubscribed.get();
    }

    public abstract void onDispose();
}

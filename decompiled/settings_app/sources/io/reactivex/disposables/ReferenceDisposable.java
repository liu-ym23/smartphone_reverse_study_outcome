package io.reactivex.disposables;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    protected abstract void onDisposed(T r1);

    ReferenceDisposable(T r2) {
        super(ObjectHelper.requireNonNull(r2, "value is null"));
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (get() == null) goto L8;
        T r0 = getAndSet(null);
        if (r0 == null) goto L9;
        onDisposed(r0);
        return;
    L9:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }
}

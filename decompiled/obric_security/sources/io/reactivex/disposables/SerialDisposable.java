package io.reactivex.disposables;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class SerialDisposable implements Disposable {
    final AtomicReference<Disposable> resource;

    public SerialDisposable() {
        this.resource = new AtomicReference();
    }

    public SerialDisposable(Disposable r2) {
        this.resource = new AtomicReference(r2);
    }

    public boolean set(Disposable r1) {
        return DisposableHelper.set(this.resource, r1);
    }

    public boolean replace(Disposable r1) {
        return DisposableHelper.replace(this.resource, r1);
    }

    public Disposable get() {
        Disposable r1 = this.resource.get();
        if (r1 == DisposableHelper.DISPOSED) goto L5;
        return r1;
    L5:
        return Disposables.disposed();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.resource);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.resource.get());
    }
}

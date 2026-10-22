package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes2.dex */
final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    public RunnableDisposable(Runnable r1) {
        super(r1);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public /* bridge */ /* synthetic */ void onDisposed(@NonNull Runnable r1) {
        onDisposed2(r1);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    public void onDisposed2(@NonNull Runnable r1) {
        r1.run();
    }
}

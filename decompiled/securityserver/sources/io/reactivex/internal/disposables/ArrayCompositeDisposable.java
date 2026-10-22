package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<Disposable> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int r1) {
        super(r1);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        int r0 = 0;
        if (get(0) == DisposableHelper.DISPOSED) goto L13;
        int r1 = length();
    L5:
        if (r0 >= r1) goto L19;
        Disposable r2 = get(r0);
        DisposableHelper r3 = DisposableHelper.DISPOSED;
        if (r2 == r3) goto L12;
        Disposable r4 = getAndSet(r0, r3);
        if (r4 == r3) goto L12;
        if (r4 == null) goto L12;
        r4.dispose();
    L12:
        r0 = r0 + 1;
        goto L5
    L19:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get(0) != DisposableHelper.DISPOSED) goto L6;
        return true;
    L6:
        return false;
    }

    public Disposable replaceResource(int r3, Disposable r4) {
    L2:
        Disposable r0 = get(r3);
        if (r0 == DisposableHelper.DISPOSED) goto L4;
        if (compareAndSet(r3, r0, r4) == false) goto L2;
        return r0;
    L4:
        r4.dispose();
        return null;
    }

    public boolean setResource(int r3, Disposable r4) {
    L2:
        Disposable r0 = get(r3);
        if (r0 == DisposableHelper.DISPOSED) goto L4;
        if (compareAndSet(r3, r0, r4) == false) goto L2;
        if (r0 == null) goto L15;
        r0.dispose();
        return true;
    L15:
        return true;
    L4:
        r4.dispose();
        return false;
    }
}

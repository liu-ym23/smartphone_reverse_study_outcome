package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes4.dex */
public final enum DisposableHelper extends Enum<DisposableHelper> implements Disposable {
    private static final /* synthetic */ DisposableHelper[] $VALUES = null;
    public static final DisposableHelper DISPOSED = null;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    private DisposableHelper(String r1, int r2) {
        super(r1, r2);
    }

    public static DisposableHelper valueOf(String r1) {
        return (DisposableHelper) Enum.valueOf(DisposableHelper.class, r1);
    }

    public static DisposableHelper[] values() {
        return (DisposableHelper[]) $VALUES.clone();
    }

    static {
        DisposableHelper r0 = new DisposableHelper("DISPOSED", 0);
        DISPOSED = r0;
        $VALUES = new DisposableHelper[]{r0};
    }

    public static boolean isDisposed(Disposable r1) {
        if (r1 != DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean set(AtomicReference<Disposable> r2, Disposable r3) {
    L2:
        Disposable r0 = r2.get();
        if (r0 == DISPOSED) goto L4;
        if (b0$$ExternalSyntheticBackport0.m(r2, r0, r3) == false) goto L2;
        if (r0 == null) goto L18;
        r0.dispose();
        return true;
    L18:
        return true;
    L4:
        if (r3 == null) goto L17;
        r3.dispose();
        return false;
    L17:
        return false;
    }

    public static boolean setOnce(AtomicReference<Disposable> r1, Disposable r2) {
        ObjectHelper.requireNonNull(r2, "d is null");
        if (b0$$ExternalSyntheticBackport0.m(r1, null, r2) == true) goto L9;
        r2.dispose();
        if (r1.get() == DISPOSED) goto L11;
        reportDisposableSet();
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static boolean replace(AtomicReference<Disposable> r2, Disposable r3) {
    L2:
        Disposable r0 = r2.get();
        if (r0 == DISPOSED) goto L4;
        if (b0$$ExternalSyntheticBackport0.m(r2, r0, r3) == false) goto L2;
        return true;
    L4:
        if (r3 == null) goto L15;
        r3.dispose();
        return false;
    L15:
        return false;
    }

    public static boolean dispose(AtomicReference<Disposable> r2) {
        Disposable r0 = r2.get();
        DisposableHelper r1 = DISPOSED;
        if (r0 == r1) goto L10;
        Disposable r3 = r2.getAndSet(r1);
        if (r3 == r1) goto L13;
        if (r3 == null) goto L12;
        r3.dispose();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean validate(Disposable r1, Disposable r2) {
        if (r2 != null) goto L6;
        RxJavaPlugins.onError(new NullPointerException("next is null"));
        return false;
    L6:
        if (r1 == null) goto L9;
        r2.dispose();
        reportDisposableSet();
        return false;
    L9:
        return true;
    }

    public static void reportDisposableSet() {
        RxJavaPlugins.onError(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean trySet(AtomicReference<Disposable> r1, Disposable r2) {
        if (b0$$ExternalSyntheticBackport0.m(r1, null, r2) == false) goto L5;
        return true;
    L5:
        if (r1.get() != DISPOSED) goto L11;
        r2.dispose();
        return false;
    L11:
        return false;
    }
}

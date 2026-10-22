package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {
    public final Throwable e;
    public final String f;

    public MissingMainCoroutineDispatcher(String r1, Throwable r2) {
        this.e = r2;
        this.f = r1;
    }

    @Override // kotlinx.coroutines.Delay
    public final void e(long r1, CancellableContinuationImpl r3) {
        n();
        throw null;
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle h(long r1, Runnable r3, CoroutineContext r4) {
        n();
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void j(CoroutineContext r1, Runnable r2) {
        n();
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean l() {
        n();
        throw null;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public final MainCoroutineDispatcher m() {
        return this;
    }

    public final void n() {
        Throwable r0 = this.e;
        if (r0 == null) goto L13;
        String r2 = this.f;
        if (r2 == null) goto L9;
        String r3 = ". ".concat(r2);
        if (r3 == null) goto L9;
    L11:
        throw new IllegalStateException("Module with the Main dispatcher had failed to initialize".concat(r3), r0);
    L9:
        r3 = "";
        goto L11
    L13:
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        StringBuilder r0 = new StringBuilder("Dispatchers.Main[missing");
        Throwable r3 = this.e;
        if (r3 == null) goto L5;
        String r4 = ", cause=" + r3;
    L6:
        r0.append(r4);
        r0.append(']');
        return r0.toString();
    L5:
        r4 = "";
        goto L6
    }
}

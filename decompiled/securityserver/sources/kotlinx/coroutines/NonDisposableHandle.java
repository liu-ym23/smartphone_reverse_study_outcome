package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public final class NonDisposableHandle implements DisposableHandle, ChildHandle {
    public static final NonDisposableHandle b = null;

    static {
        b = new NonDisposableHandle();
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean i(Throwable r1) {
        return false;
    }

    public final String toString() {
        return "NonDisposableHandle";
    }
}

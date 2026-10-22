package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class ExecutorCoroutineDispatcherBase extends ExecutorCoroutineDispatcher implements Delay {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // kotlinx.coroutines.Delay
    public final void e(long r1, CancellableContinuationImpl r3) {
        DefaultExecutor.m.e(r1, r3);
    }

    public final boolean equals(Object r1) {
        if ((r1 instanceof ExecutorCoroutineDispatcherBase) == false) goto L5;
        ((ExecutorCoroutineDispatcherBase) r1).getClass();
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle h(long r1, Runnable r3, CoroutineContext r4) {
        return DefaultExecutor.m.h(r1, r3, r4);
    }

    public final int hashCode() {
        return System.identityHashCode(null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void j(CoroutineContext r1, Runnable r2) {
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        throw null;
    }
}

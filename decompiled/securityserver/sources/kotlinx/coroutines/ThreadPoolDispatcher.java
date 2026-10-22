package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ThreadPoolDispatcher extends ExecutorCoroutineDispatcherBase {
    public static final /* synthetic */ int e = 0;

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.ExecutorService");
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "ThreadPoolDispatcher[0, null]";
    }
}

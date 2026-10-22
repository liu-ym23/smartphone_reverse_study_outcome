package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DefaultScheduler extends ExperimentalCoroutineDispatcher {
    public static final CoroutineDispatcher f = null;
    public static final DefaultScheduler i = null;

    static {
        DefaultScheduler r0 = new DefaultScheduler();
        i = r0;
        int r2 = SystemPropsKt.a();
        if (64 < r2) goto L6;
        r2 = 64;
    L6:
        f = new LimitingDispatcher(r0, SystemPropsKt.d("kotlinx.coroutines.io.parallelism", r2, 0, 0, 12));
    }

    @Override // kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.Default";
    }
}

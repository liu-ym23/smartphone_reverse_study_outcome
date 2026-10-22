package kotlinx.coroutines;

import a.a;
import kotlin.Metadata;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class TimeoutCoroutine<U, T extends U> extends ScopeCoroutine<T> implements Runnable {
    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport
    public final String j0() {
        return a.o(new StringBuilder(), super.j0(), "(timeMillis=0)");
    }

    @Override // java.lang.Runnable
    public final void run() {
        O(new TimeoutCancellationException("Timed out waiting for 0 ms", this));
    }
}

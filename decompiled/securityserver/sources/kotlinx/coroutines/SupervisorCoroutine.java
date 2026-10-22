package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SupervisorCoroutine<T> extends ScopeCoroutine<T> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean S(Throwable r1) {
        return false;
    }
}

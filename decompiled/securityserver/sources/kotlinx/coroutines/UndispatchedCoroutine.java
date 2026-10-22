package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.JobSupport
    public final void N(Object r3) {
        Continuation r2 = this.f;
        Object r4 = CompletionStateKt.a(r3, r2);
        CoroutineContext r0 = r2.getContext();
        Object r1 = ThreadContextKt.c(r0, null);
        r2.k(r4);     // Catch: Throwable -> L6
        ThreadContextKt.a(r0, r1);
        return;
    L6:
        th = move-exception;
        ThreadContextKt.a(r0, r1);
        throw th;
    }
}

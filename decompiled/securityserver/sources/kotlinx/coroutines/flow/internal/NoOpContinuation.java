package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class NoOpContinuation implements Continuation<Object> {
    public static final NoOpContinuation b = null;

    static {
        b = new NoOpContinuation();
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.b;
    }

    @Override // kotlin.coroutines.Continuation
    public final void k(Object r1) {
    }
}

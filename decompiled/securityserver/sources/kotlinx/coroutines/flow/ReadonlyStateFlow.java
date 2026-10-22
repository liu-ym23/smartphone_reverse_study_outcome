package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ReadonlyStateFlow<T> implements StateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r1, Continuation r2) {
        throw null;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow b(CoroutineContext r2, int r3, BufferOverflow r4) {
        boolean r0 = DebugKt.f370a;
        if (r3 < 0) goto L7;
        if (1 < r3) goto L7;
    L9:
        if (r4 != BufferOverflow.c) goto L12;
        return this;
    L12:
        return SharedFlowKt.b(this, r2, r3, r4);
    L7:
        if (r3 != (-2)) goto L12;
        goto L9
    }
}

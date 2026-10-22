package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ReadonlySharedFlow<T> implements SharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r1, Continuation r2) {
        throw null;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow b(CoroutineContext r1, int r2, BufferOverflow r3) {
        return SharedFlowKt.b(this, r1, r2, r3);
    }
}

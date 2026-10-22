package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChannelFlowOperatorImpl<T> extends ChannelFlowOperator<T, T> {
    public ChannelFlowOperatorImpl(int r2, int r3, CoroutineContext r4, BufferOverflow r5, Flow r6) {
        if ((r3 & 2) == 0) goto L6;
        r4 = EmptyCoroutineContext.b;
    L6:
        if ((r3 & 4) == 0) goto L9;
        r2 = -3;
    L9:
        if ((r3 & 8) == 0) goto L11;
        r5 = BufferOverflow.b;
    L11:
        super(r6, r4, r2, r5);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow e(CoroutineContext r2, int r3, BufferOverflow r4) {
        return new ChannelFlowOperatorImpl(this.f, r2, r3, r4);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public final Object g(FlowCollector r1, Continuation r2) {
        Object r0 = this.f.a(r1, r2);
        if (r0 != CoroutineSingletons.b) goto L6;
        return r0;
    L6:
        return Unit.f330a;
    }
}

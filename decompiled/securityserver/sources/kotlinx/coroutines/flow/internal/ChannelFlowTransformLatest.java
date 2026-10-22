package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {
    public final Function3 i;

    public ChannelFlowTransformLatest(Function3 r1, Flow r2, CoroutineContext r3, int r4, BufferOverflow r5) {
        super(r2, r3, r4, r5);
        this.i = r1;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow e(CoroutineContext r8, int r9, BufferOverflow r10) {
        return new ChannelFlowTransformLatest(this.i, this.f, r8, r9, r10);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public final Object g(FlowCollector r3, Continuation r4) {
        boolean r0 = DebugKt.f370a;
        ChannelFlowTransformLatest$flowCollect$3 r1 = new ChannelFlowTransformLatest$flowCollect$3(this, r3, null);
        FlowCoroutine r2 = new FlowCoroutine(r4, r4.getContext());
        Object r5 = UndispatchedKt.b(r2, r2, r1);
        if (r5 != CoroutineSingletons.b) goto L6;
        return r5;
    L6:
        return Unit.f330a;
    }
}

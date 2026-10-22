package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1 implements Flow<Object> {
    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r13, Continuation r14) {
        CoroutineContext r12 = r14.getContext();
        Job.Key r15 = Job.g;
        CoroutineContext r3 = r12.v(r15);
        if (r3.f(r15) != null) goto L24;
        if (r3.equals(EmptyCoroutineContext.b) == false) goto L7;
        ChannelFlowOperatorImpl r11 = null;
    L8:
        BufferOverflow r10 = BufferOverflow.b;
        int r7 = 0;
        if ((r11 instanceof FusibleFlow) == false) goto L20;
        ChannelFlowOperatorImpl r16 = r11;
        EmptyCoroutineContext r17 = null;
        if ((true & true) == false) goto L14;
        r17 = EmptyCoroutineContext.b;
    L14:
        if ((1 & 2) == 0) goto L17;
        r7 = -3;
    L17:
        if ((1 & 4) == 0) goto L19;
        r10 = BufferOverflow.b;
    L19:
        r16.b(r17, r7, r10);
    L22:
        throw null;
    L20:
        new ChannelFlowOperatorImpl(0, 2, null, r10, r11);
        goto L22
    L7:
        r11 = new ChannelFlowOperatorImpl(0, 12, r3, null, null);
        goto L8
    L24:
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + r3).toString());
    }
}

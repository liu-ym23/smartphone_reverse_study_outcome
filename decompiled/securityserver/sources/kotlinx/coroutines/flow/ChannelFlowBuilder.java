package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class ChannelFlowBuilder<T> extends ChannelFlow<T> {
    public final Function2 f;

    public ChannelFlowBuilder(Function2 r1, CoroutineContext r2, int r3, BufferOverflow r4) {
        super(r2, r3, r4);
        this.f = r1;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object d(ProducerScope r1, Continuation r2) {
        Object r0 = this.f.mo7invoke(r1, r2);
        if (r0 != CoroutineSingletons.b) goto L6;
        return r0;
    L6:
        return Unit.f330a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow e(CoroutineContext r2, int r3, BufferOverflow r4) {
        return new ChannelFlowBuilder(this.f, r2, r3, r4);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String toString() {
        return "block[" + this.f + "] -> " + super.toString();
    }
}

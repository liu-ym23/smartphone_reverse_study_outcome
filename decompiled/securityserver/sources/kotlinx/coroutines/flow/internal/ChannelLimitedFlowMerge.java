package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {
    public final Iterable f;

    public ChannelLimitedFlowMerge(Iterable r1, CoroutineContext r2, int r3, BufferOverflow r4) {
        super(r2, r3, r4);
        this.f = r1;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object d(ProducerScope r4, Continuation r5) {
        SendingCollector r6 = new SendingCollector(r4);
        Iterator<T> r3 = this.f.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        BuildersKt.a(r4, null, new ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1((Flow) r3.next(), null, r4, r6), 3);
        goto L4
    L7:
        return Unit.f330a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow e(CoroutineContext r2, int r3, BufferOverflow r4) {
        return new ChannelLimitedFlowMerge(this.f, r2, r3, r4);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ReceiveChannel f(CoroutineScope r5) {
        Function2 r0 = new ChannelFlow$collectToFun$1(this, null);
        AbstractChannel r1 = ChannelKt.a(this.c, null, 6);
        FlowProduceCoroutine r6 = new FlowProduceCoroutine(CoroutineContextKt.a(r5, this.b), r1);
        r6.y0(CoroutineStart.e, r6, r0);
        return r6;
    }
}

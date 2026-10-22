package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {
    public final Flow f;
    public final int i;

    public ChannelFlowMerge(int r1, int r2, CoroutineContext r3, BufferOverflow r4, Flow r5) {
        super(r3, r2, r4);
        this.f = r5;
        this.i = r1;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String c() {
        return "concurrency=" + this.i;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object d(ProducerScope r5, Continuation r6) {
        Semaphore r0 = SemaphoreKt.a(this.i);
        SendingCollector r1 = new SendingCollector(r5);
        ChannelFlowMerge$collectTo$$inlined$collect$1 r3 = new ChannelFlowMerge$collectTo$$inlined$collect$1((Job) r6.getContext().f(Job.g), r0, r5, r1);
        Object r4 = this.f.a(r3, r6);
        if (r4 != CoroutineSingletons.b) goto L6;
        return r4;
    L6:
        return Unit.f330a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow e(CoroutineContext r8, int r9, BufferOverflow r10) {
        Flow r5 = this.f;
        return new ChannelFlowMerge(this.i, r9, r8, r10, r5);
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

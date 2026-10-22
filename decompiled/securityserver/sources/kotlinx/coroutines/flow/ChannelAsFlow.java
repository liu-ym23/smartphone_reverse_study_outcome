package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ChannelAsFlow<T> extends ChannelFlow<T> {
    public static final AtomicIntegerFieldUpdater j = null;
    private volatile int consumed;
    public final ReceiveChannel f;
    public final boolean i;

    static {
        j = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed");
    }

    public ChannelAsFlow(ReceiveChannel r1, boolean r2, CoroutineContext r3, int r4, BufferOverflow r5) {
        super(r3, r4, r5);
        this.f = r1;
        this.i = r2;
        this.consumed = 0;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r4, Continuation r5) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        if (this.c != (-3)) goto L7;
        g();
        Object r3 = FlowKt__ChannelsKt.a(r4, this.f, this.i, r5);
        if (r3 != r0) goto L11;
        return r3;
    L11:
        return Unit.f330a;
    L7:
        Object r6 = super.a(r4, r5);
        if (r6 != r0) goto L11;
        return r6;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String c() {
        return "channel=" + this.f;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object d(ProducerScope r2, Continuation r3) {
        Object r1 = FlowKt__ChannelsKt.a(new SendingCollector(r2), this.f, this.i, r3);
        if (r1 != CoroutineSingletons.b) goto L6;
        return r1;
    L6:
        return Unit.f330a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow e(CoroutineContext r8, int r9, BufferOverflow r10) {
        return new ChannelAsFlow(this.f, this.i, r8, r9, r10);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ReceiveChannel f(CoroutineScope r3) {
        g();
        if (this.c != (-3)) goto L6;
        return this.f;
    L6:
        return super.f(r3);
    }

    public final void g() {
        if (this.i == false) goto L12;
        boolean r1 = true;
        if (j.getAndSet(this, 1) == 0) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L11;
        return;
    L11:
        throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
    }
}

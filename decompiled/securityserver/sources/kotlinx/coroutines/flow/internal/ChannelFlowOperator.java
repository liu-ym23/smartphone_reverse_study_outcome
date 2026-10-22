package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    public final Flow f;

    public ChannelFlowOperator(Flow r1, CoroutineContext r2, int r3, BufferOverflow r4) {
        super(r2, r3, r4);
        this.f = r1;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r7, Continuation r8) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        Unit r1 = Unit.f330a;
        if (this.c != (-3)) goto L24;
        CoroutineContext r2 = r8.getContext();
        CoroutineContext r3 = r2.i(this.b);
        if (Intrinsics.a(r3, r2) == false) goto L9;
        Object r6 = g(r7, r8);
        if (r6 == r0) goto L28;
        return r1;
    L28:
        return r6;
    L9:
        ContinuationInterceptor.Key r4 = ContinuationInterceptor.Key.f336a;
        if (Intrinsics.a((ContinuationInterceptor) r3.f(r4), (ContinuationInterceptor) r2.f(r4)) == false) goto L24;
        CoroutineContext r5 = r8.getContext();
        if ((r7 instanceof SendingCollector) == false) goto L15;
    L18:
        ChannelFlowOperator$collectWithContextUndispatched$2 r9 = new ChannelFlowOperator$collectWithContextUndispatched$2(this, null);
        r6 = ChannelFlowKt.a(r3, r7, ThreadContextKt.b(r3), r9, r8);
        if (r6 == r0) goto L22;
        r6 = r1;
    L22:
        if (r6 == r0) goto L28;
        return r1;
    L15:
        if ((r7 instanceof NopCollector) == true) goto L18;
        r7 = new UndispatchedContextCollector(r7, r5);
    L24:
        r6 = super.a(r7, r8);
        if (r6 == r0) goto L28;
        return r1;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object d(ProducerScope r2, Continuation r3) {
        Object r1 = g(new SendingCollector(r2), r3);
        if (r1 != CoroutineSingletons.b) goto L6;
        return r1;
    L6:
        return Unit.f330a;
    }

    public abstract Object g(FlowCollector r1, Continuation r2);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String toString() {
        return this.f + " -> " + super.toString();
    }
}

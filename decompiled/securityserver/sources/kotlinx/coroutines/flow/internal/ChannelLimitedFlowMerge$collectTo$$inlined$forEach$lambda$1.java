package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public CoroutineScope i;
    public CoroutineScope j;
    public int k;
    public final /* synthetic */ Flow l;
    public final /* synthetic */ ProducerScope m;
    public final /* synthetic */ SendingCollector n;

    public ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1(Flow r1, Continuation r2, ProducerScope r3, SendingCollector r4) {
        this.l = r1;
        this.m = r3;
        this.n = r4;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r4, Continuation r5) {
        ProducerScope r1 = this.m;
        SendingCollector r2 = this.n;
        ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1 r0 = new ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1(this.l, r5, r1, r2);
        r0.i = (CoroutineScope) r4;
        return r0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r4) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.k;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.b(r4);
    L12:
        return Unit.f330a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r4);
        this.j = this.i;
        this.k = 1;
        if (this.l.a(this.n, this) != r0) goto L12;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelLimitedFlowMerge$collectTo$$inlined$forEach$lambda$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

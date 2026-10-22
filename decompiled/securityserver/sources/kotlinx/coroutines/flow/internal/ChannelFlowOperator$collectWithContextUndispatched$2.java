package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {164}, m = "invokeSuspend")
final class ChannelFlowOperator$collectWithContextUndispatched$2 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    public FlowCollector i;
    public FlowCollector j;
    public int k;
    public final /* synthetic */ ChannelFlowOperator l;

    public ChannelFlowOperator$collectWithContextUndispatched$2(ChannelFlowOperator r1, Continuation r2) {
        this.l = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r2, Continuation r3) {
        ChannelFlowOperator$collectWithContextUndispatched$2 r0 = new ChannelFlowOperator$collectWithContextUndispatched$2(this.l, r3);
        r0.i = (FlowCollector) r2;
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
        FlowCollector r5 = this.i;
        this.j = r5;
        this.k = 1;
        if (this.l.g(r5, this) != r0) goto L12;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelFlowOperator$collectWithContextUndispatched$2) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

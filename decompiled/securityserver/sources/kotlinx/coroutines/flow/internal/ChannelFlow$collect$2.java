package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {135}, m = "invokeSuspend")
final class ChannelFlow$collect$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public CoroutineScope i;
    public CoroutineScope j;
    public int k;
    public final /* synthetic */ ChannelFlow l;
    public final /* synthetic */ FlowCollector m;

    public ChannelFlow$collect$2(ChannelFlow r1, FlowCollector r2, Continuation r3) {
        this.l = r1;
        this.m = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r3, Continuation r4) {
        ChannelFlow$collect$2 r0 = new ChannelFlow$collect$2(this.l, this.m, r4);
        r0.i = (CoroutineScope) r3;
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
        CoroutineScope r5 = this.i;
        ReceiveChannel r2 = this.l.f(r5);
        this.j = r5;
        this.k = 1;
        if (FlowKt.b(this.m, r2, this) != r0) goto L12;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelFlow$collect$2) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

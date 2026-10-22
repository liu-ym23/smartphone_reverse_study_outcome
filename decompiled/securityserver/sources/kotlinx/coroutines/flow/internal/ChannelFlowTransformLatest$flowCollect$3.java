package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {101}, m = "invokeSuspend")
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public CoroutineScope i;
    public CoroutineScope j;
    public Flow k;
    public int l;
    public final /* synthetic */ ChannelFlowTransformLatest m;
    public final /* synthetic */ FlowCollector n;

    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest r1, FlowCollector r2, Continuation r3) {
        this.m = r1;
        this.n = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r3, Continuation r4) {
        ChannelFlowTransformLatest$flowCollect$3 r0 = new ChannelFlowTransformLatest$flowCollect$3(this.m, this.n, r4);
        r0.i = (CoroutineScope) r3;
        return r0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r6) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.l;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.b(r6);
    L12:
        return Unit.f330a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r6);
        CoroutineScope r7 = this.i;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.b = null;
        Flow r3 = this.m.f;
        ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 r4 = new ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1(this, r7, r2);
        this.j = r7;
        this.k = r3;
        this.l = 1;
        if (r3.a(r4, this) != r0) goto L12;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelFlowTransformLatest$flowCollect$3) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

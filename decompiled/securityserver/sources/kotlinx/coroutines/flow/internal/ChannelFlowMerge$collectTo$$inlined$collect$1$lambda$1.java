package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public CoroutineScope i;
    public CoroutineScope j;
    public int k;
    public final /* synthetic */ Flow l;
    public final /* synthetic */ ChannelFlowMerge$collectTo$$inlined$collect$1 m;

    public ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(Flow r1, Continuation r2, ChannelFlowMerge$collectTo$$inlined$collect$1 r3) {
        this.l = r1;
        this.m = r3;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r3, Continuation r4) {
        ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1 r0 = new ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(this.l, r4, this.m);
        r0.i = (CoroutineScope) r3;
        return r0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r6) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.k;
        ChannelFlowMerge$collectTo$$inlined$collect$1 r3 = this.m;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.b(r6);     // Catch: Throwable -> L7
    L15:
        r3.c.release();
        return Unit.f330a;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.b(r6);
        CoroutineScope r7 = this.i;
        Flow r2 = this.l;     // Catch: Throwable -> L7
        SendingCollector r4 = r3.f;     // Catch: Throwable -> L7
        this.j = r7;     // Catch: Throwable -> L7
        this.k = 1;     // Catch: Throwable -> L7
        if (r2.a(r4, this) != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        r3.c.release();
        throw th;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

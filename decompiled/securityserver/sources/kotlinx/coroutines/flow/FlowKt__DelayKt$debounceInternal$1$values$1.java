package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", l = {352}, m = "invokeSuspend")
final class FlowKt__DelayKt$debounceInternal$1$values$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public ProducerScope j;
    public Flow k;
    public int l;
    public final /* synthetic */ FlowKt__DelayKt$debounceInternal$1 m;

    public FlowKt__DelayKt$debounceInternal$1$values$1(FlowKt__DelayKt$debounceInternal$1 r1, Continuation r2) {
        this.m = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r2, Continuation r3) {
        FlowKt__DelayKt$debounceInternal$1$values$1 r0 = new FlowKt__DelayKt$debounceInternal$1$values$1(this.m, r3);
        r0.i = (ProducerScope) r2;
        return r0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r5) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.l;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.b(r5);
    L12:
        return Unit.f330a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r5);
        final ProducerScope r6 = this.i;
        Flow r2 = this.m.r;
        FlowCollector<Object> r3 = new FlowKt__DelayKt$debounceInternal$1$values$1$invokeSuspend$$inlined$collect$1(r6);
        this.j = r6;
        this.k = r2;
        this.l = 1;
        if (r2.a(r3, this) != r0) goto L12;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((FlowKt__DelayKt$debounceInternal$1$values$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

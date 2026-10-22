package kotlinx.coroutines.flow;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", l = {TypedValues.AttributesType.TYPE_PATH_ROTATE, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 319}, m = "invokeSuspend")
final class FlowKt__DelayKt$fixedPeriodTicker$3 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public ProducerScope j;
    public int k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    public FlowKt__DelayKt$fixedPeriodTicker$3(long r1, long r3, Continuation r5) {
        this.l = r1;
        this.m = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r8, Continuation r9) {
        FlowKt__DelayKt$fixedPeriodTicker$3 r6 = new FlowKt__DelayKt$fixedPeriodTicker$3(this.l, this.m, r9);
        r6.i = (ProducerScope) r8;
        return r6;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0051 -> B:15:0x0036). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r7) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.k;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ProducerScope r2 = this.j;
        ResultKt.b(r7);
    L18:
        this.j = r2;
        this.k = 3;
        if (DelayKt.a(this.m, this) == r0) goto L20;
    L15:
        SendChannel r8 = r2.getChannel();
        Unit r4 = Unit.f330a;
        this.j = r2;
        this.k = 2;
        if (r8.I(r4, this) != r0) goto L18;
        return r0;
    L20:
        return r0;
    L11:
        r2 = this.j;
        ResultKt.b(r7);
        goto L15
    L12:
        ResultKt.b(r7);
        r2 = this.i;
        this.j = r2;
        this.k = 1;
        if (DelayKt.a(this.l, this) != r0) goto L15;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        ((FlowKt__DelayKt$fixedPeriodTicker$3) f(r1, (Continuation) r2)).i(Unit.f330a);
        return CoroutineSingletons.b;
    }
}

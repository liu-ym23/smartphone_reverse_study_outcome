package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__LimitKt$collectWhile$collector$1 implements FlowCollector<Object> {
    public final /* synthetic */ Function2 b;

    public FlowKt__LimitKt$collectWhile$collector$1() {
        this.b = null;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r5, Continuation r6) {
        if ((r6 instanceof FlowKt__LimitKt$collectWhile$collector$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$collectWhile$collector$1$emit$1 r0 = (FlowKt__LimitKt$collectWhile$collector$1$emit$1) r6;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        FlowKt__LimitKt$collectWhile$collector$1 this = r0.k;
        ResultKt.b(r7);
    L18:
        if (((Boolean) r7).booleanValue() == false) goto L22;
        return Unit.f330a;
    L22:
        throw new AbortFlowException(this);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r7);
        r0.k = this;
        r0.l = r5;
        r0.i = 1;
        r7 = this.b.mo7invoke(r5, r0);
        if (r7 != r2) goto L18;
        return r2;
    L7:
        r0 = new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, r6);
        goto L8
    }
}

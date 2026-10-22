package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", l = {138}, m = "collectWhile")
public final class FlowKt__LimitKt$collectWhile$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Flow j;
    public Function2 k;
    public FlowKt__LimitKt$collectWhile$collector$1 l;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r4) {
        this.f = r4;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L11;
        FlowKt__LimitKt$collectWhile$collector$1 r3 = this.l;
        ResultKt.b(r4);     // Catch: AbortFlowException -> L8
    L20:
        return Unit.f330a;
    L8:
        AbortFlowException e = e;
    L18:
        if (e.b == r3) goto L20;
        throw e;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.b(r4);
        FlowKt__LimitKt$collectWhile$collector$1 r5 = new FlowKt__LimitKt$collectWhile$collector$1();
        this.l = r5;     // Catch: AbortFlowException -> L15
        this.i = 1;     // Catch: AbortFlowException -> L15
        throw null;
    L15:
        e = move-exception;
        e = e;
        r3 = r5;
        goto L18
    }
}

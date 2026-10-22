package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", l = {73}, m = "emitAbort$FlowKt__LimitKt")
final class FlowKt__LimitKt$emitAbort$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public FlowCollector j;
    public Object k;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r3) {
        this.f = r3;
        this.i |= Integer.MIN_VALUE;
        if ((this instanceof FlowKt__LimitKt$emitAbort$1) == false) goto L7;
        int r4 = this.i;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        this.i = r4 - Integer.MIN_VALUE;
    L8:
        Object r5 = this.f;
        int r0 = this.i;
        if (r0 == 0) goto L15;
        if (r0 != 1) goto L12;
        FlowCollector r2 = this.j;
        ResultKt.b(r5);
        throw new AbortFlowException(r2);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.b(r5);
        this.j = null;
        this.i = 1;
        throw null;
    L7:
        FlowKt__LimitKt$emitAbort$1 this = new FlowKt__LimitKt$emitAbort$1(this);
        goto L8
    }
}

package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {227}, m = "firstOrNull")
final class FlowKt__ReduceKt$firstOrNull$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Flow j;
    public Function2 k;
    public Ref.ObjectRef l;
    public Flow m;
    public FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 n;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r5) {
        this.f = r5;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L11;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r1 = this.n;
        Ref.ObjectRef r4 = this.l;
        ResultKt.b(r5);     // Catch: AbortFlowException -> L8
    L20:
        return r4.b;
    L8:
        AbortFlowException e = e;
    L18:
        if (e.b == r1) goto L20;
        throw e;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.b(r5);
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.b = null;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r2 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(r6);
        this.l = r6;     // Catch: AbortFlowException -> L15
        this.n = r2;     // Catch: AbortFlowException -> L15
        this.i = 1;     // Catch: AbortFlowException -> L15
        throw null;
    L15:
        e = move-exception;
        r1 = r2;
        e = e;
        r4 = r6;
        goto L18
    }
}

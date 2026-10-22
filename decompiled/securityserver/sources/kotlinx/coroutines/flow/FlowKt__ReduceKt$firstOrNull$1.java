package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {212}, m = "firstOrNull")
final class FlowKt__ReduceKt$firstOrNull$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Flow j;
    public Ref.ObjectRef k;
    public Flow l;
    public FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1 m;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r5) {
        this.f = r5;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L11;
        ?? r1 = this.m;
        Ref.ObjectRef r4 = this.k;
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
        final Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.b = null;
        ?? r2 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1(r6);
        this.k = r6;     // Catch: AbortFlowException -> L15
        this.m = r2;     // Catch: AbortFlowException -> L15
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

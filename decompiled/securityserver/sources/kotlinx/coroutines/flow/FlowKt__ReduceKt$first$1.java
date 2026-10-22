package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {182}, m = "first")
final class FlowKt__ReduceKt$first$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Flow j;
    public Ref.ObjectRef k;
    public Flow l;
    public FlowKt__ReduceKt$first$$inlined$collectWhile$1 m;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r6) {
        this.f = r6;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        Symbol r1 = NullSurrogateKt.f403a;
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L11;
        ?? r2 = this.m;
        Ref.ObjectRef r5 = this.k;
        ResultKt.b(r6);     // Catch: AbortFlowException -> L8
    L19:
        Object r7 = r5.b;
        if (r7 == r1) goto L23;
        return r7;
    L23:
        throw new NoSuchElementException("Expected at least one element");
    L8:
        AbortFlowException e = e;
    L18:
        if (e.b == r2) goto L19;
        throw e;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.b(r6);
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.b = r1;
        r2 = new FlowKt__ReduceKt$first$$inlined$collectWhile$1(r8);
        this.k = r8;     // Catch: AbortFlowException -> L15
        this.m = r2;     // Catch: AbortFlowException -> L15
        this.i = 1;     // Catch: AbortFlowException -> L15
        throw null;
    L15:
        e = move-exception;
        e = e;
        r5 = r8;
        goto L18
    }
}

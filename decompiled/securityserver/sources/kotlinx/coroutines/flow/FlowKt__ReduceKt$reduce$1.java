package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {148}, m = "reduce")
final class FlowKt__ReduceKt$reduce$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Flow j;
    public Function3 k;
    public Ref.ObjectRef l;
    public Flow m;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r4) {
        this.f = r4;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        Symbol r1 = NullSurrogateKt.f403a;
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L11;
        Ref.ObjectRef r3 = this.l;
        ResultKt.b(r4);
        Object r5 = r3.b;
        if (r5 == r1) goto L9;
        return r5;
    L9:
        throw new NoSuchElementException("Empty flow can't be reduced");
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.b(r4);
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.b = r1;
        this.l = r6;
        this.i = 1;
        throw null;
    }
}

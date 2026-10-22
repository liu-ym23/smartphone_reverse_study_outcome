package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {197}, m = "first")
final class FlowKt__ReduceKt$first$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Flow j;
    public Function2 k;
    public Ref.ObjectRef l;
    public Flow m;
    public FlowKt__ReduceKt$first$$inlined$collectWhile$2 n;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r6) {
        this.f = r6;
        this.i |= Integer.MIN_VALUE;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 r7 = null;
        Function2 r8 = null;
        if ((this instanceof FlowKt__ReduceKt$first$3) == false) goto L7;
        int r0 = this.i;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        this.i = r0 - Integer.MIN_VALUE;
    L8:
        Object r1 = this.f;
        Object r2 = CoroutineSingletons.b;
        int r3 = this.i;
        Object r4 = NullSurrogateKt.f403a;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 r9 = this.n;
        Ref.ObjectRef r5 = this.l;
        Function2 r10 = this.k;
        ResultKt.b(r1);     // Catch: AbortFlowException -> L14
    L27:
        r8 = r10;
    L28:
        r2 = r5.b;
        if (r2 == r4) goto L32;
    L30:
        return r2;
    L32:
        throw new NoSuchElementException("Expected at least one element matching the predicate " + r8);
    L14:
        AbortFlowException e = e;
    L26:
        if (e.b == r9) goto L27;
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.b(r1);
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.b = r4;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 r12 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(null, r11);
        this.k = null;     // Catch: AbortFlowException -> L23
        this.l = r11;     // Catch: AbortFlowException -> L23
        this.n = r12;     // Catch: AbortFlowException -> L23
        this.i = 1;     // Catch: AbortFlowException -> L23
        if (r7.a(r12, this) == r2) goto L30;
        r5 = r11;
    L23:
        e = move-exception;
        r5 = r11;
        e = e;
        r10 = null;
        r9 = r12;
    L7:
        FlowKt__ReduceKt$first$3 this = new FlowKt__ReduceKt$first$3(this);
        goto L8
    }
}

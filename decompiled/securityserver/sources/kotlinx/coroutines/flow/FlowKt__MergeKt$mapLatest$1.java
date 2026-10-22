package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {214, 214}, m = "invokeSuspend")
final class FlowKt__MergeKt$mapLatest$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> {
    public FlowCollector i;
    public Object j;
    public FlowCollector k;
    public Object l;
    public FlowCollector m;
    public int n;
    public final /* synthetic */ Function2 o;

    public FlowKt__MergeKt$mapLatest$1(Function2 r1, Continuation r2) {
        this.o = r1;
        super(3, r2);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object b(Object r2, Object r3, Object r4) {
        Function2 r1 = this.o;
        FlowKt__MergeKt$mapLatest$1 r0 = new FlowKt__MergeKt$mapLatest$1(r1, (Continuation) r4);
        r0.i = (FlowCollector) r2;
        r0.j = r3;
        return r0.i(Unit.f330a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r7) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.n;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.b(r7);
    L18:
        return Unit.f330a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        FlowCollector r2 = this.m;
        Object r3 = this.l;
        FlowCollector r4 = this.k;
        ResultKt.b(r7);
    L14:
        this.k = r4;
        this.l = r3;
        this.n = 2;
        if (r2.d(r7, this) != r0) goto L18;
        return r0;
    L10:
        ResultKt.b(r7);
        r2 = this.i;
        Object r8 = this.j;
        this.k = r2;
        this.l = r8;
        this.m = r2;
        this.n = 1;
        Object r5 = this.o.mo7invoke(r8, this);
        if (r5 != r0) goto L13;
        return r0;
    L13:
        r4 = r2;
        r3 = r8;
        r7 = r5;
        goto L14
    }
}

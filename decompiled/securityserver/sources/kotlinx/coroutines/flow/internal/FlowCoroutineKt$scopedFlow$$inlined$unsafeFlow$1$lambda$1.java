package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public CoroutineScope i;
    public CoroutineScope j;
    public int k;
    public final /* synthetic */ FlowCollector l;
    public final /* synthetic */ FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1 m;

    public FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1(FlowCollector r1, Continuation r2, FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1 r3) {
        this.l = r1;
        this.m = r3;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r3, Continuation r4) {
        FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1 r0 = new FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1(this.l, r4, this.m);
        r0.i = (CoroutineScope) r3;
        return r0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r3) {
        int r0 = this.k;
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L8;
        ResultKt.b(r3);
        return Unit.f330a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.b(r3);
        CoroutineScope r4 = this.i;
        this.m.getClass();
        this.j = r4;
        this.k = 1;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1 r0 = (FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1$lambda$1) f(r1, (Continuation) r2);
        Unit r3 = Unit.f330a;
        r0.i(r3);
        return r3;
    }
}

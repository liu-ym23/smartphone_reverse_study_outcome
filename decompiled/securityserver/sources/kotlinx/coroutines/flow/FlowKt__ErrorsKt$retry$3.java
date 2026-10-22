package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", l = {124}, m = "invokeSuspend")
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements Function4<FlowCollector<Object>, Throwable, Long, Continuation<? super Boolean>, Object> {
    public FlowCollector i;
    public Throwable j;
    public long k;
    public FlowCollector l;
    public int m;
    public final /* synthetic */ long n;
    public final /* synthetic */ Function2 o;

    public FlowKt__ErrorsKt$retry$3(long r1, Function2 r3, Continuation r4) {
        this.n = r1;
        this.o = r3;
        super(4, r4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r8) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.m;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.b(r8);
    L14:
        if (((Boolean) r8).booleanValue() == true) goto L18;
    L16:
        r2 = false;
    L18:
        return Boolean.valueOf(r2);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r8);
        FlowCollector r9 = this.i;
        Throwable r3 = this.j;
        if (this.k >= this.n) goto L16;
        this.l = r9;
        this.m = 1;
        r8 = this.o.mo7invoke(r3, this);
        if (r8 != r0) goto L14;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object r5, Object r6, Object r7, Object r8) {
        long r0 = ((Number) r7).longValue();
        long r2 = this.n;
        Function2 r4 = this.o;
        FlowKt__ErrorsKt$retry$3 r9 = new FlowKt__ErrorsKt$retry$3(r2, r4, (Continuation) r8);
        r9.i = (FlowCollector) r5;
        r9.j = (Throwable) r6;
        r9.k = r0;
        return r9.i(Unit.f330a);
    }
}

package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6", f = "Errors.kt", l = {}, m = "invokeSuspend")
final class FlowKt__ErrorsKt$retry$6 extends SuspendLambda implements Function4<FlowCollector<Object>, Throwable, Long, Continuation<? super Boolean>, Object> {
    public FlowCollector i;
    public Throwable j;
    public long k;
    public final /* synthetic */ int l;
    public final /* synthetic */ Function1 m;

    public FlowKt__ErrorsKt$retry$6(int r1, Function1 r2, Continuation r3) {
        this.l = r1;
        this.m = r2;
        super(4, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r4) {
        ResultKt.b(r4);
        Throwable r5 = this.j;
        long r0 = this.k;
        if (((Boolean) this.m.invoke(r5)).booleanValue() == true) goto L5;
    L7:
        boolean r3 = false;
    L9:
        return Boolean.valueOf(r3);
    L5:
        if (r0 >= this.l) goto L7;
        r3 = true;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object r4, Object r5, Object r6, Object r7) {
        long r0 = ((Number) r6).longValue();
        int r2 = this.l;
        Function1 r3 = this.m;
        FlowKt__ErrorsKt$retry$6 r8 = new FlowKt__ErrorsKt$retry$6(r2, r3, (Continuation) r7);
        r8.i = (FlowCollector) r4;
        r8.j = (Throwable) r5;
        r8.k = r0;
        return r8.i(Unit.f330a);
    }
}

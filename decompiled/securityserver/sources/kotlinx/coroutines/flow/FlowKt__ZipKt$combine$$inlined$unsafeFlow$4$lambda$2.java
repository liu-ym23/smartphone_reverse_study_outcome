package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2", f = "Zip.kt", l = {292, 292}, m = "invokeSuspend")
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {
    public FlowCollector i;
    public Object[] j;
    public FlowCollector k;
    public Object[] l;
    public FlowCollector m;
    public int n;
    public final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$4 o;

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2(Continuation r1, FlowKt__ZipKt$combine$$inlined$unsafeFlow$4 r2) {
        this.o = r2;
        super(3, r1);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object b(Object r2, Object r3, Object r4) {
        FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2 r0 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2((Continuation) r4, this.o);
        r0.i = (FlowCollector) r2;
        r0.j = (Object[]) r3;
        return r0.i(Unit.f330a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r6) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.n;
        if (r1 != 0) goto L5;
        ResultKt.b(r6);
        FlowCollector r7 = this.i;
        Object[] r2 = this.j;
        this.o.getClass();
        this.k = r7;
        this.l = r2;
        this.m = r7;
        this.n = 1;
        throw null;
    L5:
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.b(r6);
    L14:
        return Unit.f330a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        FlowCollector r3 = this.m;
        Object[] r4 = this.l;
        FlowCollector r5 = this.k;
        ResultKt.b(r6);
        this.k = r5;
        this.l = r4;
        this.n = 2;
        if (r3.d(r6, this) != r0) goto L14;
        return r0;
    }
}

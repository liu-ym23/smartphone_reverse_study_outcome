package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", l = {306}, m = "invokeSuspend")
final class FlowKt__MigrationKt$onErrorReturn$2 extends SuspendLambda implements Function3<FlowCollector<Object>, Throwable, Continuation<? super Unit>, Object> {
    public FlowCollector i;
    public Throwable j;
    public FlowCollector k;
    public int l;
    public final /* synthetic */ Function1 m;
    public final /* synthetic */ Object n;

    public FlowKt__MigrationKt$onErrorReturn$2(Object r1, Continuation r2, Function1 r3) {
        this.m = r3;
        this.n = r1;
        super(3, r2);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object b(Object r3, Object r4, Object r5) {
        Function1 r1 = this.m;
        Object r2 = this.n;
        FlowKt__MigrationKt$onErrorReturn$2 r0 = new FlowKt__MigrationKt$onErrorReturn$2(r2, (Continuation) r5, r1);
        r0.i = (FlowCollector) r3;
        r0.j = (Throwable) r4;
        return r0.i(Unit.f330a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r5) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.l;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.b(r5);
    L14:
        return Unit.f330a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r5);
        FlowCollector r6 = this.i;
        Throwable r2 = this.j;
        if (((Boolean) this.m.invoke(r2)).booleanValue() == false) goto L15;
        this.k = r6;
        this.l = 1;
        if (r6.d(this.n, this) != r0) goto L14;
        return r0;
    L15:
        throw r2;
    }
}

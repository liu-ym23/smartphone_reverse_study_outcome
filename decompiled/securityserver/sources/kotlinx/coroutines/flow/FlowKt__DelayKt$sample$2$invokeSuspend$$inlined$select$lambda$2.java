package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    public Unit i;
    public Object j;
    public int k;
    public final /* synthetic */ Ref.ObjectRef l;
    public final /* synthetic */ ReceiveChannel m;
    public final /* synthetic */ Ref.ObjectRef n;
    public final /* synthetic */ FlowCollector o;

    public FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2(Continuation r1, Ref.ObjectRef r2, ReceiveChannel r3, Ref.ObjectRef r4, FlowCollector r5) {
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        super(2, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r8, Continuation r9) {
        Ref.ObjectRef r4 = this.n;
        FlowCollector r5 = this.o;
        FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2 r6 = new FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2(r9, this.l, this.m, r4, r5);
        r6.i = (Unit) r8;
        return r6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r6) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.k;
        Unit r2 = Unit.f330a;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.b(r6);
    L17:
        return r2;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r6);
        Ref.ObjectRef r7 = this.n;
        Object r3 = r7.b;
        if (r3 == null) goto L17;
        Object r4 = null;
        r7.b = null;
        if (r3 == NullSurrogateKt.f403a) goto L14;
        r4 = r3;
    L14:
        this.j = r3;
        this.k = 1;
        if (this.o.d(r4, this) != r0) goto L17;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

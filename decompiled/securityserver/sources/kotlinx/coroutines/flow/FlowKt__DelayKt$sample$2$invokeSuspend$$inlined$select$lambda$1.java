package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    public Object i;
    public final /* synthetic */ Ref.ObjectRef j;
    public final /* synthetic */ ReceiveChannel k;
    public final /* synthetic */ Ref.ObjectRef l;
    public final /* synthetic */ FlowCollector m;

    public FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1(Continuation r1, Ref.ObjectRef r2, ReceiveChannel r3, Ref.ObjectRef r4, FlowCollector r5) {
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        super(2, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r8, Continuation r9) {
        Ref.ObjectRef r4 = this.l;
        FlowCollector r5 = this.m;
        FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1 r6 = new FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1(r9, this.j, this.k, r4, r5);
        r6.i = r8;
        return r6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r2) {
        ResultKt.b(r2);
        Object r3 = this.i;
        Ref.ObjectRef r0 = this.l;
        if (r3 != null) goto L5;
        ChildCancelledException r4 = new ChildCancelledException();
        this.k.a(r4);
        r0.b = NullSurrogateKt.c;
    L7:
        return Unit.f330a;
    L5:
        r0.b = r3;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1 r0 = (FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1) f(r1, (Continuation) r2);
        Unit r3 = Unit.f330a;
        r0.i(r3);
        return r3;
    }
}

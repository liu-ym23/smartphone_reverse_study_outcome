package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public int i;
    public final /* synthetic */ Ref.ObjectRef j;
    public final /* synthetic */ Ref.LongRef k;
    public final /* synthetic */ FlowCollector l;
    public final /* synthetic */ Ref.ObjectRef m;

    public FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1(Continuation r1, Ref.ObjectRef r2, Ref.LongRef r3, FlowCollector r4, Ref.ObjectRef r5) {
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        super(1, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation h(Continuation r8) {
        FlowCollector r4 = this.l;
        Ref.ObjectRef r5 = this.m;
        return new FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1(r8, this.j, this.k, r4, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r6) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.i;
        Ref.ObjectRef r3 = this.j;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.b(r6);
    L14:
        r3.b = null;
        return Unit.f330a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r6);
        Symbol r7 = NullSurrogateKt.f403a;
        Object r2 = r3.b;
        if (r2 != r7) goto L11;
        r2 = null;
    L11:
        this.i = 1;
        if (this.l.d(r2, this) != r0) goto L14;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        return ((FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1) h((Continuation) r1)).i(Unit.f330a);
    }
}

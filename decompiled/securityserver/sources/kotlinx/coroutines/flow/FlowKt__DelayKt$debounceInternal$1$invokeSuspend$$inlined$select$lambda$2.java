package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    public Object i;
    public Object j;
    public int k;
    public final /* synthetic */ Ref.ObjectRef l;
    public final /* synthetic */ Ref.LongRef m;
    public final /* synthetic */ FlowCollector n;
    public final /* synthetic */ Ref.ObjectRef o;

    public FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2(Continuation r1, Ref.ObjectRef r2, Ref.LongRef r3, FlowCollector r4, Ref.ObjectRef r5) {
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        super(2, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r8, Continuation r9) {
        FlowCollector r4 = this.n;
        Ref.ObjectRef r5 = this.o;
        FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2 r6 = new FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2(r9, this.l, this.m, r4, r5);
        r6.i = r8;
        return r6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r6) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.k;
        Ref.ObjectRef r3 = this.l;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.b(r6);
    L18:
        r3.b = NullSurrogateKt.c;
    L21:
        return Unit.f330a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r6);
        Object r7 = this.i;
        if (r7 != null) goto L19;
        Object r2 = r3.b;
        if (r2 == null) goto L18;
        if (r2 != NullSurrogateKt.f403a) goto L15;
        r2 = null;
    L15:
        this.j = r7;
        this.k = 1;
        if (this.n.d(r2, this) != r0) goto L18;
        return r0;
    L19:
        r3.b = r7;
        goto L21
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

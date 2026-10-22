package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", l = {210}, m = "invokeSuspend")
final class StartedLazily$command$1 extends SuspendLambda implements Function2<FlowCollector<? super SharingCommand>, Continuation<? super Unit>, Object> {
    public FlowCollector i;
    public FlowCollector j;
    public StateFlow k;
    public int l;
    public final /* synthetic */ StateFlow m;

    public StartedLazily$command$1(StateFlow r1, Continuation r2) {
        this.m = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r2, Continuation r3) {
        StartedLazily$command$1 r0 = new StartedLazily$command$1(this.m, r3);
        r0.i = (FlowCollector) r2;
        return r0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r5) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.l;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.b(r5);
    L12:
        return Unit.f330a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r5);
        FlowCollector r6 = this.i;
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        r2.b = false;
        StartedLazily$command$1$invokeSuspend$$inlined$collect$1 r3 = new StartedLazily$command$1$invokeSuspend$$inlined$collect$1(r6, r2);
        this.j = r6;
        StateFlow r7 = this.m;
        this.k = r7;
        this.l = 1;
        if (r7.a(r3, this) != r0) goto L12;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((StartedLazily$command$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

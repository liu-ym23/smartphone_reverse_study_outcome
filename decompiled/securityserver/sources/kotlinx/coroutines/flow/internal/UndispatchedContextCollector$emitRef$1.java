package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", l = {224}, m = "invokeSuspend")
final class UndispatchedContextCollector$emitRef$1 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    public Object i;
    public Object j;
    public int k;
    public final /* synthetic */ FlowCollector l;

    public UndispatchedContextCollector$emitRef$1(FlowCollector r1, Continuation r2) {
        this.l = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r2, Continuation r3) {
        UndispatchedContextCollector$emitRef$1 r0 = new UndispatchedContextCollector$emitRef$1(this.l, r3);
        r0.i = r2;
        return r0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r4) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.k;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.b(r4);
    L12:
        return Unit.f330a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r4);
        Object r5 = this.i;
        this.j = r5;
        this.k = 1;
        if (this.l.d(r5, this) != r0) goto L12;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((UndispatchedContextCollector$emitRef$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

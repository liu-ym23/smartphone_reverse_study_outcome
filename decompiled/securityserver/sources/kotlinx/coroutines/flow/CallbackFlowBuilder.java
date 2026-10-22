package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class CallbackFlowBuilder<T> extends ChannelFlowBuilder<T> {
    public final Function2 i;

    public CallbackFlowBuilder(Function2 r1, CoroutineContext r2, int r3, BufferOverflow r4) {
        super(r1, r2, r3, r4);
        this.i = r1;
    }

    @Override // kotlinx.coroutines.flow.ChannelFlowBuilder, kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object d(ProducerScope r5, Continuation r6) {
        if ((r6 instanceof CallbackFlowBuilder$collectTo$1) == false) goto L7;
        CallbackFlowBuilder$collectTo$1 r0 = (CallbackFlowBuilder$collectTo$1) r6;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = r0.l;
        ResultKt.b(r7);
    L18:
        if (r5.J() == false) goto L22;
        return Unit.f330a;
    L22:
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r7);
        r0.k = this;
        r0.l = r5;
        r0.i = 1;
        if (super.d(r5, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new CallbackFlowBuilder$collectTo$1(this, r6);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.ChannelFlowBuilder, kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow e(CoroutineContext r2, int r3, BufferOverflow r4) {
        return new CallbackFlowBuilder(this.i, r2, r3, r4);
    }
}

package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$flatMap$1", f = "Channels.common.kt", l = {1286, 1287, 1287}, m = "invokeSuspend")
final class ChannelsKt__Channels_commonKt$flatMap$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public Object j;
    public ChannelIterator k;
    public int l;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r9) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.l;
        if (r1 != 0) goto L5;
        ResultKt.b(r9);
        throw null;
    L5:
        if (r1 != 1) goto L7;
        ChannelIterator r2 = (ChannelIterator) this.j;
        ProducerScope r5 = this.i;
        ResultKt.b(r9);
    L21:
        if (((Boolean) r9).booleanValue() == false) goto L23;
        Object r10 = r2.next();
        this.i = r5;
        this.j = r10;
        this.k = r2;
        this.l = 2;
        throw null;
    L23:
        return Unit.f330a;
    L7:
        if (r1 == 2) goto L12;
        if (r1 != 3) goto L11;
        r2 = this.k;
        r5 = this.i;
        ResultKt.b(r9);
    L16:
        this.i = r5;
        this.j = r2;
        this.l = 1;
        r9 = r2.a(this);
        if (r9 != r0) goto L21;
        return r0;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r2 = this.k;
        Object r6 = this.j;
        ProducerScope r7 = this.i;
        ResultKt.b(r9);
        this.i = r7;
        this.j = r6;
        this.k = r2;
        this.l = 3;
        if (ChannelsKt.b((ReceiveChannel) r9, r7, this) != r0) goto L15;
        return r0;
    L15:
        r5 = r7;
        goto L16
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelsKt__Channels_commonKt$flatMap$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

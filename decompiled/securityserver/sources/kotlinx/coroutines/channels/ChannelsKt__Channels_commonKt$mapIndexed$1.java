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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$mapIndexed$1", f = "Channels.common.kt", l = {1418, 1419, 1419}, m = "invokeSuspend")
final class ChannelsKt__Channels_commonKt$mapIndexed$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public Object j;
    public ChannelIterator k;
    public ProducerScope l;
    public int m;
    public int n;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r11) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.n;
        if (r1 != 0) goto L5;
        ResultKt.b(r11);
        throw null;
    L5:
        if (r1 != 1) goto L7;
        ChannelIterator r2 = (ChannelIterator) this.j;
        int r5 = this.m;
        ProducerScope r6 = this.i;
        ResultKt.b(r11);
    L21:
        if (((Boolean) r11).booleanValue() == false) goto L23;
        Object r12 = r2.next();
        new Integer(r5);
        this.i = r6;
        this.m = r5 + 1;
        this.j = r12;
        this.k = r2;
        this.l = r6;
        this.n = 2;
        throw null;
    L23:
        return Unit.f330a;
    L7:
        if (r1 == 2) goto L12;
        if (r1 != 3) goto L11;
        r2 = this.k;
        r5 = this.m;
        r6 = this.i;
        ResultKt.b(r11);
    L16:
        this.i = r6;
        this.m = r5;
        this.j = r2;
        this.n = 1;
        r11 = r2.a(this);
        if (r11 != r0) goto L21;
        return r0;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ProducerScope r3 = this.l;
        ChannelIterator r7 = this.k;
        Object r8 = this.j;
        int r9 = this.m;
        ProducerScope r10 = this.i;
        ResultKt.b(r11);
        this.i = r10;
        this.m = r9;
        this.j = r8;
        this.k = r7;
        this.n = 3;
        if (r3.I(r11, this) != r0) goto L15;
        return r0;
    L15:
        r2 = r7;
        r5 = r9;
        r6 = r10;
        goto L16
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelsKt__Channels_commonKt$mapIndexed$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

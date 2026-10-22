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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$filterIndexed$1", f = "Channels.common.kt", l = {769, 770, 770}, m = "invokeSuspend")
final class ChannelsKt__Channels_commonKt$filterIndexed$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public Object j;
    public ChannelIterator k;
    public int l;
    public int m;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r10) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.m;
        if (r1 != 0) goto L5;
        ResultKt.b(r10);
        throw null;
    L5:
        if (r1 != 1) goto L7;
        ChannelIterator r2 = (ChannelIterator) this.j;
        int r7 = this.l;
        ProducerScope r8 = this.i;
        ResultKt.b(r10);
    L24:
        if (((Boolean) r10).booleanValue() == false) goto L26;
        Object r11 = r2.next();
        new Integer(r7);
        this.i = r8;
        this.l = r7 + 1;
        this.j = r11;
        this.k = r2;
        this.m = 2;
        throw null;
    L26:
        return Unit.f330a;
    L7:
        if (r1 == 2) goto L12;
        if (r1 != 3) goto L11;
        r2 = this.k;
        int r5 = this.l;
        ProducerScope r6 = this.i;
        ResultKt.b(r10);
    L18:
        r7 = r5;
        r8 = r6;
    L19:
        this.i = r8;
        this.l = r7;
        this.j = r2;
        this.m = 1;
        r10 = r2.a(this);
        if (r10 != r0) goto L24;
        return r0;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r2 = this.k;
        Object r9 = this.j;
        r7 = this.l;
        r8 = this.i;
        ResultKt.b(r10);
        if (((Boolean) r10).booleanValue() == false) goto L19;
        this.i = r8;
        this.l = r7;
        this.j = r9;
        this.k = r2;
        this.m = 3;
        if (r8.I(r9, this) != r0) goto L17;
        return r0;
    L17:
        r5 = r7;
        r6 = r8;
        goto L18
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelsKt__Channels_commonKt$filterIndexed$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$take$1", f = "Channels.common.kt", l = {989, 990}, m = "invokeSuspend")
final class ChannelsKt__Channels_commonKt$take$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public Object j;
    public ChannelIterator k;
    public int l;
    public int m;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0045 -> B:16:0x0048). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r8) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.m;
        Unit r2 = Unit.f330a;
        if (r1 != 0) goto L5;
        ResultKt.b(r8);
        throw null;
    L5:
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ChannelIterator r3 = this.k;
        int r5 = this.l;
        ProducerScope r6 = this.i;
        ResultKt.b(r8);
    L16:
        r5 = r5 - 1;
        if (r5 != 0) goto L19;
        return r2;
    L19:
        this.i = r6;
        this.l = r5;
        this.j = r3;
        this.m = 1;
        r8 = r3.a(this);
        if (r8 != r0) goto L12;
        return r0;
    L12:
        if (((Boolean) r8).booleanValue() == false) goto L22;
        Object r9 = r3.next();
        this.i = r6;
        this.l = r5;
        this.j = r9;
        this.k = r3;
        this.m = 2;
        if (r6.I(r9, this) != r0) goto L16;
        return r0;
    L22:
        return r2;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r3 = (ChannelIterator) this.j;
        r5 = this.l;
        r6 = this.i;
        ResultKt.b(r8);
        goto L12
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelsKt__Channels_commonKt$take$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

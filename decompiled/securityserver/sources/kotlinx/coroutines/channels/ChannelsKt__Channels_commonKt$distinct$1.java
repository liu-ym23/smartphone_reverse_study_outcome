package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$distinct$1", f = "Channels.common.kt", l = {}, m = "invokeSuspend")
final class ChannelsKt__Channels_commonKt$distinct$1 extends SuspendLambda implements Function2<Object, Continuation<Object>, Object> {
    public Object i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r2, Continuation r3) {
        ChannelsKt__Channels_commonKt$distinct$1 r1 = new ChannelsKt__Channels_commonKt$distinct$1(2, r3);
        r1.i = r2;
        return r1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r1) {
        ResultKt.b(r1);
        return this.i;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        ChannelsKt__Channels_commonKt$distinct$1 r0 = (ChannelsKt__Channels_commonKt$distinct$1) f(r1, (Continuation) r2);
        ResultKt.b(Unit.f330a);
        return r0.i;
    }
}

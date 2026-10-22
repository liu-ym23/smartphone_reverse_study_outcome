package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$withIndex$1", f = "Channels.common.kt", l = {1653, 1654}, m = "invokeSuspend")
final class ChannelsKt__Channels_commonKt$withIndex$1 extends SuspendLambda implements Function2<ProducerScope<? super IndexedValue<Object>>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public Object j;
    public ChannelIterator k;
    public int l;
    public int m;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004d -> B:17:0x004e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r9) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.m;
        if (r1 != 0) goto L5;
        ResultKt.b(r9);
        throw null;
    L5:
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ChannelIterator r2 = this.k;
        int r4 = this.l;
        ProducerScope r5 = this.i;
        ResultKt.b(r9);
    L17:
        this.i = r5;
        this.l = r4;
        this.j = r2;
        this.m = 1;
        r9 = r2.a(this);
        if (r9 != r0) goto L12;
        return r0;
    L12:
        if (((Boolean) r9).booleanValue() == false) goto L21;
        Object r10 = r2.next();
        int r7 = r4 + 1;
        IndexedValue r6 = new IndexedValue(r4, r10);
        this.i = r5;
        this.l = r7;
        this.j = r10;
        this.k = r2;
        this.m = 2;
        if (r5.I(r6, this) != r0) goto L16;
        return r0;
    L16:
        r4 = r7;
        goto L17
    L21:
        return Unit.f330a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r2 = (ChannelIterator) this.j;
        r4 = this.l;
        r5 = this.i;
        ResultKt.b(r9);
        goto L12
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelsKt__Channels_commonKt$withIndex$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

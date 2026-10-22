package kotlinx.coroutines.channels;

import androidx.core.view.PointerIconCompat;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$takeWhile$1", f = "Channels.common.kt", l = {PointerIconCompat.TYPE_NO_DROP, PointerIconCompat.TYPE_ALL_SCROLL, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW}, m = "invokeSuspend")
final class ChannelsKt__Channels_commonKt$takeWhile$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public Object j;
    public ChannelIterator k;
    public int l;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r10) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.l;
        Unit r2 = Unit.f330a;
        if (r1 != 0) goto L5;
        ResultKt.b(r10);
        throw null;
    L5:
        if (r1 != 1) goto L7;
        ChannelIterator r3 = (ChannelIterator) this.j;
        ProducerScope r6 = this.i;
        ResultKt.b(r10);
    L24:
        if (((Boolean) r10).booleanValue() == true) goto L26;
        return r2;
    L26:
        Object r11 = r3.next();
        this.i = r6;
        this.j = r11;
        this.k = r3;
        this.l = 2;
        throw null;
    L7:
        if (r1 == 2) goto L12;
        if (r1 != 3) goto L11;
        r3 = this.k;
        r6 = this.i;
        ResultKt.b(r10);
    L19:
        this.i = r6;
        this.j = r3;
        this.l = 1;
        r10 = r3.a(this);
        if (r10 != r0) goto L24;
        return r0;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r3 = this.k;
        Object r7 = this.j;
        ProducerScope r8 = this.i;
        ResultKt.b(r10);
        if (((Boolean) r10).booleanValue() == true) goto L15;
        return r2;
    L15:
        this.i = r8;
        this.j = r7;
        this.k = r3;
        this.l = 3;
        if (r8.I(r7, this) != r0) goto L18;
        return r0;
    L18:
        r6 = r8;
        goto L19
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelsKt__Channels_commonKt$takeWhile$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

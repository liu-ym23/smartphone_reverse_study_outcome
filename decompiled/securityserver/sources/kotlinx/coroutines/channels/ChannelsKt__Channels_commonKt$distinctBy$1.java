package kotlinx.coroutines.channels;

import java.util.HashSet;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$distinctBy$1", f = "Channels.common.kt", l = {1695, 1696, 1698}, m = "invokeSuspend")
final class ChannelsKt__Channels_commonKt$distinctBy$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public HashSet j;
    public Object k;
    public ChannelIterator l;
    public Object m;
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
        new HashSet();
        throw null;
    L5:
        if (r1 != 1) goto L7;
        ChannelIterator r2 = (ChannelIterator) this.k;
        HashSet r7 = this.j;
        ProducerScope r8 = this.i;
        ResultKt.b(r11);
    L24:
        if (((Boolean) r11).booleanValue() == false) goto L26;
        Object r12 = r2.next();
        this.i = r8;
        this.j = r7;
        this.k = r12;
        this.l = r2;
        this.n = 2;
        throw null;
    L26:
        return Unit.f330a;
    L7:
        if (r1 == 2) goto L12;
        if (r1 != 3) goto L11;
        Object r3 = this.m;
        ChannelIterator r5 = this.l;
        HashSet r6 = this.j;
        ProducerScope r9 = this.i;
        ResultKt.b(r11);
        r11 = r3;
    L18:
        r6.add(r11);
        r2 = r5;
        r8 = r9;
        r7 = r6;
    L19:
        this.i = r8;
        this.j = r7;
        this.k = r2;
        this.n = 1;
        r11 = r2.a(this);
        if (r11 != r0) goto L24;
        return r0;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r2 = this.l;
        Object r10 = this.k;
        r7 = this.j;
        r8 = this.i;
        ResultKt.b(r11);
        if (r7.contains(r11) == true) goto L19;
        this.i = r8;
        this.j = r7;
        this.k = r10;
        this.l = r2;
        this.m = r11;
        this.n = 3;
        if (r8.I(r10, this) != r0) goto L17;
        return r0;
    L17:
        r5 = r2;
        r6 = r7;
        r9 = r8;
        goto L18
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelsKt__Channels_commonKt$distinctBy$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

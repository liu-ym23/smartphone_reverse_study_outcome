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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1", f = "Channels.common.kt", l = {2196, 1395, 1395}, m = "invokeSuspend")
final class ChannelsKt__Channels_commonKt$map$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public ReceiveChannel j;
    public Object k;
    public ReceiveChannel l;
    public Throwable m;
    public ReceiveChannel n;
    public ChannelIterator o;
    public Object p;
    public Object q;
    public int r;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x008e: INVOKE (r6 I:kotlinx.coroutines.channels.ReceiveChannel), (r10 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:30:0x008e */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r11) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.r;
        if (r1 != 0) goto L34;
        ResultKt.b(r11);
        throw null;
    L34:
        if (r1 != 1) goto L7;
        ChannelIterator r2 = this.o;
        Throwable r5 = this.m;
        ReceiveChannel r6 = this.l;
        ResultKt.b(r11);     // Catch: Throwable -> L13
    L23:
        if (((Boolean) r11).booleanValue() == true) goto L26;
        ChannelsKt.a(r6, r5);
        return Unit.f330a;
    L26:
        r2.next();     // Catch: Throwable -> L13
        throw null;     // Catch: Throwable -> L13
    L7:
        if (r1 == 2) goto L17;
        if (r1 != 3) goto L16;
        r2 = this.o;
        ReceiveChannel r4 = this.n;
        r5 = this.m;
        r6 = this.l;
        ChannelsKt__Channels_commonKt$map$1 r7 = (ChannelsKt__Channels_commonKt$map$1) this.k;
        ReceiveChannel r8 = this.j;
        ProducerScope r9 = this.i;
        ResultKt.b(r11);     // Catch: Throwable -> L13
        this.i = r9;     // Catch: Throwable -> L13
        this.j = r8;     // Catch: Throwable -> L13
        this.k = r7;     // Catch: Throwable -> L13
        this.l = r6;     // Catch: Throwable -> L13
        this.m = r5;     // Catch: Throwable -> L13
        this.n = r4;     // Catch: Throwable -> L13
        this.o = r2;     // Catch: Throwable -> L13
        this.r = 1;     // Catch: Throwable -> L13
        r11 = r2.a(r7);     // Catch: Throwable -> L13
        if (r11 != r0) goto L23;
        return r0;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Object r3 = this.q;
        Object r10 = this.p;
        ChannelIterator r12 = this.o;
        ReceiveChannel r13 = this.n;
        Throwable r14 = this.m;
        ReceiveChannel r15 = this.l;
        ChannelsKt__Channels_commonKt$map$1 r16 = (ChannelsKt__Channels_commonKt$map$1) this.k;
        ReceiveChannel r17 = this.j;
        ProducerScope r18 = this.i;
        ResultKt.b(r11);     // Catch: Throwable -> L13
        this.i = r18;     // Catch: Throwable -> L13
        this.j = r17;     // Catch: Throwable -> L13
        this.k = r16;     // Catch: Throwable -> L13
        this.l = r15;     // Catch: Throwable -> L13
        this.m = r14;     // Catch: Throwable -> L13
        this.n = r13;     // Catch: Throwable -> L13
        this.o = r12;     // Catch: Throwable -> L13
        this.p = r10;     // Catch: Throwable -> L13
        this.q = r3;     // Catch: Throwable -> L13
        this.r = 3;     // Catch: Throwable -> L13
        throw null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        ChannelsKt.a(r6, th);
        throw th;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelsKt__Channels_commonKt$map$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

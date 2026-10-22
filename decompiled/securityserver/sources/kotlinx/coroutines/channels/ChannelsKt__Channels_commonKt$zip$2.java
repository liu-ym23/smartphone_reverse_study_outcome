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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2", f = "Channels.common.kt", l = {2196, 2186, 2188}, m = "invokeSuspend")
final class ChannelsKt__Channels_commonKt$zip$2 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public ChannelIterator j;
    public ReceiveChannel k;
    public Object l;
    public ReceiveChannel m;
    public Throwable n;
    public ReceiveChannel o;
    public ChannelIterator p;
    public Object q;
    public Object r;
    public int s;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008b -> B:28:0x008d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r13) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.s;
        if (r1 != 0) goto L43;
        ResultKt.b(r13);
        throw null;
    L43:
        if (r1 == 1) goto L19;
        if (r1 != 2) goto L8;
        ChannelIterator r2 = this.p;
        ReceiveChannel r5 = this.o;
        Throwable r6 = this.n;
        ReceiveChannel r7 = this.m;
        ChannelsKt__Channels_commonKt$zip$2 r8 = (ChannelsKt__Channels_commonKt$zip$2) this.l;
        ReceiveChannel r9 = this.k;
        ChannelIterator r10 = this.j;
        ProducerScope r11 = this.i;
        ResultKt.b(r13);     // Catch: Throwable -> L12
    L27:
        if (((Boolean) r13).booleanValue() == true) goto L31;
    L28:
        this.i = r11;     // Catch: Throwable -> L12
        this.j = r10;     // Catch: Throwable -> L12
        this.k = r9;     // Catch: Throwable -> L12
        this.l = r8;     // Catch: Throwable -> L12
        this.m = r7;     // Catch: Throwable -> L12
        this.n = r6;     // Catch: Throwable -> L12
        this.o = r5;     // Catch: Throwable -> L12
        this.p = r2;     // Catch: Throwable -> L12
        this.s = 1;     // Catch: Throwable -> L12
        r13 = r2.a(r8);     // Catch: Throwable -> L12
        if (r13 != r0) goto L22;
        return r0;
    L22:
        if (((Boolean) r13).booleanValue() == false) goto L33;
        Object r14 = r2.next();     // Catch: Throwable -> L12
        this.i = r11;     // Catch: Throwable -> L12
        this.j = r10;     // Catch: Throwable -> L12
        this.k = r9;     // Catch: Throwable -> L12
        this.l = r8;     // Catch: Throwable -> L12
        this.m = r7;     // Catch: Throwable -> L12
        this.n = r6;     // Catch: Throwable -> L12
        this.o = r5;     // Catch: Throwable -> L12
        this.p = r2;     // Catch: Throwable -> L12
        this.q = r14;     // Catch: Throwable -> L12
        this.r = r14;     // Catch: Throwable -> L12
        this.s = 2;     // Catch: Throwable -> L12
        r13 = r10.a(this);     // Catch: Throwable -> L12
        if (r13 != r0) goto L27;
        return r0;
    L33:
        ChannelsKt.a(r7, r6);
        return Unit.f330a;
    L31:
        r10.next();     // Catch: Throwable -> L12
        throw null;     // Catch: Throwable -> L12
    L8:
        if (r1 != 3) goto L15;
        r2 = this.p;
        r5 = this.o;
        r6 = this.n;
        r7 = this.m;
        r8 = (ChannelsKt__Channels_commonKt$zip$2) this.l;
        r9 = this.k;
        r10 = this.j;
        r11 = this.i;
        ResultKt.b(r13);     // Catch: Throwable -> L12
        goto L28
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r2 = this.p;
        r5 = this.o;
        r6 = this.n;
        r7 = this.m;
        r8 = (ChannelsKt__Channels_commonKt$zip$2) this.l;
        r9 = this.k;
        r10 = this.j;
        r11 = this.i;
        ResultKt.b(r13);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        ChannelsKt.a(r7, th);
        throw th;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((ChannelsKt__Channels_commonKt$zip$2) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}

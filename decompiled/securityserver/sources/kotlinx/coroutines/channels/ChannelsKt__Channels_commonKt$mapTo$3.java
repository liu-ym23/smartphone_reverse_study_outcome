package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2783, 1632}, m = "mapTo")
public final class ChannelsKt__Channels_commonKt$mapTo$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public SendChannel k;
    public Function1 l;
    public ReceiveChannel m;
    public ReceiveChannel n;
    public Throwable o;
    public ReceiveChannel p;
    public ChannelIterator q;
    public Object r;
    public Object s;

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0097: INVOKE (r6 I:kotlinx.coroutines.channels.ReceiveChannel), (r12 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:30:0x0097 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006f -> B:21:0x0072). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r13) {
        this.f = r13;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r13);
        throw null;     // Catch: Throwable -> L10
    L5:
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L13;
        ChannelIterator r2 = this.q;
        ReceiveChannel r4 = this.p;
        Throwable r5 = this.o;
        ReceiveChannel r6 = this.n;
        ReceiveChannel r7 = this.m;
        Function1 r8 = this.l;
        SendChannel r9 = this.k;
        ReceiveChannel r10 = this.j;
        ResultKt.b(r13);     // Catch: Throwable -> L10
    L21:
        this.j = r10;     // Catch: Throwable -> L10
        this.k = r9;     // Catch: Throwable -> L10
        this.l = r8;     // Catch: Throwable -> L10
        this.m = r7;     // Catch: Throwable -> L10
        this.n = r6;     // Catch: Throwable -> L10
        this.o = r5;     // Catch: Throwable -> L10
        this.p = r4;     // Catch: Throwable -> L10
        this.q = r2;     // Catch: Throwable -> L10
        this.i = 1;     // Catch: Throwable -> L10
        r13 = r2.a(this);     // Catch: Throwable -> L10
        if (r13 != r1) goto L17;
        return r1;
    L17:
        if (((Boolean) r13).booleanValue() == false) goto L24;
        Object r14 = r2.next();     // Catch: Throwable -> L10
        Object r11 = r8.invoke(r14);     // Catch: Throwable -> L10
        this.j = r10;     // Catch: Throwable -> L10
        this.k = r9;     // Catch: Throwable -> L10
        this.l = r8;     // Catch: Throwable -> L10
        this.m = r7;     // Catch: Throwable -> L10
        this.n = r6;     // Catch: Throwable -> L10
        this.o = r5;     // Catch: Throwable -> L10
        this.p = r4;     // Catch: Throwable -> L10
        this.q = r2;     // Catch: Throwable -> L10
        this.r = r14;     // Catch: Throwable -> L10
        this.s = r14;     // Catch: Throwable -> L10
        this.i = 2;     // Catch: Throwable -> L10
        if (r9.I(r11, this) != r1) goto L21;
        return r1;
    L24:
        ChannelsKt.a(r6, r5);
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        r2 = this.q;
        r4 = this.p;
        r5 = this.o;
        r6 = this.n;
        r7 = this.m;
        r8 = this.l;
        r9 = this.k;
        r10 = this.j;
        ResultKt.b(r13);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        ChannelsKt.a(r6, th);
        throw th;
    }
}

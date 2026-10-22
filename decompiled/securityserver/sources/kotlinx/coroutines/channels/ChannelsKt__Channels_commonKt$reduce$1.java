package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2030, 2032}, m = "reduce")
public final class ChannelsKt__Channels_commonKt$reduce$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Function2 k;
    public ReceiveChannel l;
    public Throwable m;
    public ReceiveChannel n;
    public ChannelIterator o;
    public Object p;

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x008d: INVOKE (r6 I:kotlinx.coroutines.channels.ReceiveChannel), (r9 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:33:0x008d */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:21:0x0068). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r10) {
        this.f = r10;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r10);
        throw null;     // Catch: Throwable -> L10
    L5:
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L13;
        Object r2 = this.p;
        ChannelIterator r3 = this.o;
        ReceiveChannel r4 = this.n;
        Throwable r5 = this.m;
        ReceiveChannel r6 = this.l;
        Function2 r7 = this.k;
        ReceiveChannel r8 = this.j;
        ResultKt.b(r10);     // Catch: Throwable -> L10
    L22:
        if (((Boolean) r10).booleanValue() == false) goto L25;
        r2 = r7.mo7invoke(r2, r3.next());     // Catch: Throwable -> L10
    L18:
        this.j = r8;     // Catch: Throwable -> L10
        this.k = r7;     // Catch: Throwable -> L10
        this.l = r6;     // Catch: Throwable -> L10
        this.m = r5;     // Catch: Throwable -> L10
        this.n = r4;     // Catch: Throwable -> L10
        this.o = r3;     // Catch: Throwable -> L10
        this.p = r2;     // Catch: Throwable -> L10
        this.i = 2;     // Catch: Throwable -> L10
        r10 = r3.a(this);     // Catch: Throwable -> L10
        if (r10 != r1) goto L22;
        return r1;
    L25:
        ChannelsKt.a(r6, r5);
        return r2;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ChannelIterator r9 = this.o;
        ReceiveChannel r11 = this.n;
        Throwable r12 = this.m;
        r6 = this.l;
        Function2 r13 = this.k;
        ReceiveChannel r14 = this.j;
        ResultKt.b(r10);     // Catch: Throwable -> L10
        if (((Boolean) r10).booleanValue() == false) goto L28;
        r8 = r14;
        r7 = r13;
        r5 = r12;
        r4 = r11;
        r3 = r9;
        r2 = r9.next();     // Catch: Throwable -> L10
        goto L18
    L28:
        throw new UnsupportedOperationException("Empty channel can't be reduced.");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        ChannelsKt.a(r6, th);
        throw th;
    }
}

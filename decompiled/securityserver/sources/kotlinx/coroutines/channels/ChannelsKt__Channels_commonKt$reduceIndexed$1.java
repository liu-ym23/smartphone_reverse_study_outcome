package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2057, 2060}, m = "reduceIndexed")
public final class ChannelsKt__Channels_commonKt$reduceIndexed$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Function3 k;
    public ReceiveChannel l;
    public Throwable m;
    public ReceiveChannel n;
    public ChannelIterator o;
    public Object p;
    public int q;

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0099: INVOKE (r7 I:kotlinx.coroutines.channels.ReceiveChannel), (r11 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:33:0x0099 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x006a -> B:21:0x006d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r12) {
        this.f = r12;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 == 0) goto L29;
        int r2 = 1;
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L13;
        Object r3 = this.p;
        r2 = this.q;
        ChannelIterator r4 = this.o;
        ReceiveChannel r5 = this.n;
        Throwable r6 = this.m;
        ReceiveChannel r7 = this.l;
        Function3 r8 = this.k;
        ReceiveChannel r9 = this.j;
        ResultKt.b(r12);     // Catch: Throwable -> L10
    L22:
        if (((Boolean) r12).booleanValue() == false) goto L25;
        Integer r13 = new Integer(r2);     // Catch: Throwable -> L10
        r2 = r2 + 1;     // Catch: Throwable -> L10
        r3 = r8.b(r13, r3, r4.next());     // Catch: Throwable -> L10
    L18:
        this.j = r9;     // Catch: Throwable -> L10
        this.k = r8;     // Catch: Throwable -> L10
        this.l = r7;     // Catch: Throwable -> L10
        this.m = r6;     // Catch: Throwable -> L10
        this.n = r5;     // Catch: Throwable -> L10
        this.o = r4;     // Catch: Throwable -> L10
        this.q = r2;     // Catch: Throwable -> L10
        this.p = r3;     // Catch: Throwable -> L10
        this.i = 2;     // Catch: Throwable -> L10
        r12 = r4.a(this);     // Catch: Throwable -> L10
        if (r12 != r1) goto L22;
        return r1;
    L25:
        ChannelsKt.a(r7, r6);
        return r3;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ChannelIterator r10 = this.o;
        ReceiveChannel r11 = this.n;
        Throwable r14 = this.m;
        r7 = this.l;
        Function3 r15 = this.k;
        ReceiveChannel r16 = this.j;
        ResultKt.b(r12);     // Catch: Throwable -> L10
        if (((Boolean) r12).booleanValue() == false) goto L28;
        r9 = r16;
        r8 = r15;
        r6 = r14;
        r5 = r11;
        r4 = r10;
        r3 = r10.next();     // Catch: Throwable -> L10
        goto L18
    L28:
        throw new UnsupportedOperationException("Empty channel can't be reduced.");     // Catch: Throwable -> L10
    L29:
        ResultKt.b(r12);
        throw null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        ChannelsKt.a(r7, th);
        throw th;
    }
}

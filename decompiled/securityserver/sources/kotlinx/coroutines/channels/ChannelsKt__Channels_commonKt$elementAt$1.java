package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2223}, m = "elementAt")
final class ChannelsKt__Channels_commonKt$elementAt$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public ReceiveChannel k;
    public ReceiveChannel l;
    public Throwable m;
    public ReceiveChannel n;
    public ChannelIterator o;
    public int p;
    public int q;

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0086: INVOKE (r7 I:kotlinx.coroutines.channels.ReceiveChannel), (r12 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:28:0x0086 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r13) {
        this.f = r13;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r13);
        throw null;     // Catch: Throwable -> L18
    L5:
        if (r0 != 1) goto L23;
        int r2 = this.q;
        ChannelIterator r4 = this.o;
        ReceiveChannel r5 = this.n;
        Throwable r6 = this.m;
        ReceiveChannel r7 = this.l;
        ReceiveChannel r8 = this.k;
        int r9 = this.p;
        ReceiveChannel r10 = this.j;
        ResultKt.b(r13);     // Catch: Throwable -> L18
    L9:
        if (((Boolean) r13).booleanValue() == false) goto L20;
        Object r14 = r4.next();     // Catch: Throwable -> L18
        int r11 = r2 + 1;
        if (r9 == r2) goto L13;
        this.j = r10;     // Catch: Throwable -> L18
        this.p = r9;     // Catch: Throwable -> L18
        this.k = r8;     // Catch: Throwable -> L18
        this.l = r7;     // Catch: Throwable -> L18
        this.m = r6;     // Catch: Throwable -> L18
        this.n = r5;     // Catch: Throwable -> L18
        this.o = r4;     // Catch: Throwable -> L18
        this.q = r11;     // Catch: Throwable -> L18
        this.i = 1;     // Catch: Throwable -> L18
        r13 = r4.a(this);     // Catch: Throwable -> L18
        if (r13 == r1) goto L36;
        r2 = r11;
        goto L9
    L36:
        return r1;
    L13:
        ChannelsKt.a(r7, r6);
        return r14;
    L20:
        new Integer(r9);     // Catch: Throwable -> L18
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r9 + '.');     // Catch: Throwable -> L18
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        ChannelsKt.a(r7, th);
        throw th;
    }
}

package kotlinx.coroutines.channels;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2612}, m = "toMap")
final class ChannelsKt__Channels_commonKt$toMap$2 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Map k;
    public ReceiveChannel l;
    public ReceiveChannel m;
    public Throwable n;
    public ReceiveChannel o;
    public ChannelIterator p;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0064: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r10 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:23:0x0064 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r11) {
        this.f = r11;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r11);
        throw null;     // Catch: Throwable -> L13
    L5:
        if (r0 != 1) goto L18;
        ChannelIterator r2 = this.p;
        ReceiveChannel r3 = this.o;
        Throwable r4 = this.n;
        ReceiveChannel r5 = this.m;
        ReceiveChannel r6 = this.l;
        Map r7 = this.k;
        ReceiveChannel r8 = this.j;
        ResultKt.b(r11);     // Catch: Throwable -> L13
    L9:
        if (((Boolean) r11).booleanValue() == false) goto L15;
        Pair r12 = (Pair) r2.next();     // Catch: Throwable -> L13
        r7.put(r12.b, r12.c);     // Catch: Throwable -> L13
        this.j = r8;     // Catch: Throwable -> L13
        this.k = r7;     // Catch: Throwable -> L13
        this.l = r6;     // Catch: Throwable -> L13
        this.m = r5;     // Catch: Throwable -> L13
        this.n = r4;     // Catch: Throwable -> L13
        this.o = r3;     // Catch: Throwable -> L13
        this.p = r2;     // Catch: Throwable -> L13
        this.i = 1;     // Catch: Throwable -> L13
        r11 = r2.a(this);     // Catch: Throwable -> L13
        if (r11 != r1) goto L9;
        return r1;
    L15:
        ChannelsKt.a(r5, r4);
        return r7;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        ChannelsKt.a(r5, th);
        throw th;
    }
}

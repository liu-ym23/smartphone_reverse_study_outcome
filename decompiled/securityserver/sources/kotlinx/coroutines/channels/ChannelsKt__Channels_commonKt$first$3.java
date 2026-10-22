package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2290}, m = "first")
public final class ChannelsKt__Channels_commonKt$first$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Function1 k;
    public ReceiveChannel l;
    public ReceiveChannel m;
    public Throwable n;
    public ReceiveChannel o;
    public ChannelIterator p;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0072: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r10 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:26:0x0072 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r11) {
        this.f = r11;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r11);
        throw null;     // Catch: Throwable -> L16
    L5:
        if (r0 != 1) goto L21;
        ChannelIterator r2 = this.p;
        ReceiveChannel r3 = this.o;
        Throwable r4 = this.n;
        ReceiveChannel r5 = this.m;
        ReceiveChannel r6 = this.l;
        Function1 r7 = this.k;
        ReceiveChannel r8 = this.j;
        ResultKt.b(r11);     // Catch: Throwable -> L16
    L9:
        if (((Boolean) r11).booleanValue() == false) goto L18;
        Object r12 = r2.next();     // Catch: Throwable -> L16
        if (((Boolean) r7.invoke(r12)).booleanValue() == true) goto L12;
        this.j = r8;     // Catch: Throwable -> L16
        this.k = r7;     // Catch: Throwable -> L16
        this.l = r6;     // Catch: Throwable -> L16
        this.m = r5;     // Catch: Throwable -> L16
        this.n = r4;     // Catch: Throwable -> L16
        this.o = r3;     // Catch: Throwable -> L16
        this.p = r2;     // Catch: Throwable -> L16
        this.i = 1;     // Catch: Throwable -> L16
        r11 = r2.a(this);     // Catch: Throwable -> L16
        if (r11 != r1) goto L9;
        return r1;
    L12:
        ChannelsKt.a(r5, r4);
        return r12;
    L18:
        ChannelsKt.a(r5, r4);
        throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        ChannelsKt.a(r5, th);
        throw th;
    }
}

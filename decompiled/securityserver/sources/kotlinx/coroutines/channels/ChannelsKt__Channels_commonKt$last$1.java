package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {467, 470}, m = "last")
final class ChannelsKt__Channels_commonKt$last$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public ReceiveChannel k;
    public Throwable l;
    public ReceiveChannel m;
    public ChannelIterator n;
    public Object o;

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0082: INVOKE (r6 I:kotlinx.coroutines.channels.ReceiveChannel), (r8 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:33:0x0082 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005e -> B:21:0x0061). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r9) {
        this.f = r9;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r9);
        throw null;     // Catch: Throwable -> L10
    L5:
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L13;
        Object r2 = this.o;
        ChannelIterator r3 = this.n;
        ReceiveChannel r4 = this.m;
        Throwable r5 = this.l;
        ReceiveChannel r6 = this.k;
        ReceiveChannel r7 = this.j;
        ResultKt.b(r9);     // Catch: Throwable -> L10
    L22:
        if (((Boolean) r9).booleanValue() == false) goto L25;
        r2 = r3.next();     // Catch: Throwable -> L10
    L18:
        this.j = r7;     // Catch: Throwable -> L10
        this.k = r6;     // Catch: Throwable -> L10
        this.l = r5;     // Catch: Throwable -> L10
        this.m = r4;     // Catch: Throwable -> L10
        this.n = r3;     // Catch: Throwable -> L10
        this.o = r2;     // Catch: Throwable -> L10
        this.i = 2;     // Catch: Throwable -> L10
        r9 = r3.a(this);     // Catch: Throwable -> L10
        if (r9 != r1) goto L22;
        return r1;
    L25:
        ChannelsKt.a(r6, r5);
        return r2;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ChannelIterator r8 = this.n;
        ReceiveChannel r10 = this.m;
        Throwable r11 = this.l;
        r6 = this.k;
        ReceiveChannel r12 = this.j;
        ResultKt.b(r9);     // Catch: Throwable -> L10
        if (((Boolean) r9).booleanValue() == false) goto L28;
        r7 = r12;
        r5 = r11;
        r4 = r10;
        r3 = r8;
        r2 = r8.next();     // Catch: Throwable -> L10
        goto L18
    L28:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        ChannelsKt.a(r6, th);
        throw th;
    }
}

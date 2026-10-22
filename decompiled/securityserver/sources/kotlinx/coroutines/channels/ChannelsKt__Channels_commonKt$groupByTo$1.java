package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2668}, m = "groupByTo")
public final class ChannelsKt__Channels_commonKt$groupByTo$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Map k;
    public Function1 l;
    public ReceiveChannel m;
    public ReceiveChannel n;
    public Throwable o;
    public ReceiveChannel p;
    public ChannelIterator q;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0077: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r12 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:26:0x0077 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r13) {
        this.f = r13;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r13);
        throw null;     // Catch: Throwable -> L13
    L5:
        if (r0 != 1) goto L21;
        ChannelIterator r2 = this.q;
        ReceiveChannel r3 = this.p;
        Throwable r4 = this.o;
        ReceiveChannel r5 = this.n;
        ReceiveChannel r6 = this.m;
        Function1 r7 = this.l;
        Map r8 = this.k;
        ReceiveChannel r9 = this.j;
        ResultKt.b(r13);     // Catch: Throwable -> L13
    L9:
        if (((Boolean) r13).booleanValue() == false) goto L18;
        Object r14 = r2.next();     // Catch: Throwable -> L13
        Object r10 = r7.invoke(r14);     // Catch: Throwable -> L13
        Object r11 = r8.get(r10);     // Catch: Throwable -> L13
        if (r11 != null) goto L15;
        r11 = new ArrayList();     // Catch: Throwable -> L13
        r8.put(r10, r11);     // Catch: Throwable -> L13
    L15:
        ((List) r11).add(r14);     // Catch: Throwable -> L13
        this.j = r9;     // Catch: Throwable -> L13
        this.k = r8;     // Catch: Throwable -> L13
        this.l = r7;     // Catch: Throwable -> L13
        this.m = r6;     // Catch: Throwable -> L13
        this.n = r5;     // Catch: Throwable -> L13
        this.o = r4;     // Catch: Throwable -> L13
        this.p = r3;     // Catch: Throwable -> L13
        this.q = r2;     // Catch: Throwable -> L13
        this.i = 1;     // Catch: Throwable -> L13
        r13 = r2.a(this);     // Catch: Throwable -> L13
        if (r13 != r1) goto L9;
        return r1;
    L18:
        ChannelsKt.a(r5, r4);
        return r8;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        ChannelsKt.a(r5, th);
        throw th;
    }
}

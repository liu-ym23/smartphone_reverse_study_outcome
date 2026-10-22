package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2623}, m = "groupBy")
public final class ChannelsKt__Channels_commonKt$groupBy$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Function1 k;
    public ReceiveChannel l;
    public Map m;
    public ReceiveChannel n;
    public ReceiveChannel o;
    public Throwable p;
    public ReceiveChannel q;
    public ChannelIterator r;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0080: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r13 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:26:0x0080 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r14) {
        this.f = r14;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r14);
        new LinkedHashMap();
        throw null;     // Catch: Throwable -> L13
    L5:
        if (r0 != 1) goto L21;
        ChannelIterator r2 = this.r;
        ReceiveChannel r3 = this.q;
        Throwable r4 = this.p;
        ReceiveChannel r5 = this.o;
        ReceiveChannel r6 = this.n;
        Map r7 = this.m;
        ReceiveChannel r8 = this.l;
        Function1 r9 = this.k;
        ReceiveChannel r10 = this.j;
        ResultKt.b(r14);     // Catch: Throwable -> L13
    L9:
        if (((Boolean) r14).booleanValue() == false) goto L18;
        Object r15 = r2.next();     // Catch: Throwable -> L13
        Object r11 = r9.invoke(r15);     // Catch: Throwable -> L13
        Object r12 = r7.get(r11);     // Catch: Throwable -> L13
        if (r12 != null) goto L15;
        r12 = new ArrayList();     // Catch: Throwable -> L13
        r7.put(r11, r12);     // Catch: Throwable -> L13
    L15:
        ((List) r12).add(r15);     // Catch: Throwable -> L13
        this.j = r10;     // Catch: Throwable -> L13
        this.k = r9;     // Catch: Throwable -> L13
        this.l = r8;     // Catch: Throwable -> L13
        this.m = r7;     // Catch: Throwable -> L13
        this.n = r6;     // Catch: Throwable -> L13
        this.o = r5;     // Catch: Throwable -> L13
        this.p = r4;     // Catch: Throwable -> L13
        this.q = r3;     // Catch: Throwable -> L13
        this.r = r2;     // Catch: Throwable -> L13
        this.i = 1;     // Catch: Throwable -> L13
        r14 = r2.a(this);     // Catch: Throwable -> L13
        if (r14 != r1) goto L9;
        return r1;
    L18:
        ChannelsKt.a(r5, r4);
        return r7;
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

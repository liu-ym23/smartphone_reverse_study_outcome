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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2646}, m = "groupBy")
public final class ChannelsKt__Channels_commonKt$groupBy$2 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Function1 k;
    public Function1 l;
    public ReceiveChannel m;
    public Map n;
    public ReceiveChannel o;
    public ReceiveChannel p;
    public Throwable q;
    public ReceiveChannel r;
    public ChannelIterator s;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0088: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r14 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:26:0x0088 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r15) {
        this.f = r15;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r15);
        new LinkedHashMap();
        throw null;     // Catch: Throwable -> L13
    L5:
        if (r0 != 1) goto L21;
        ChannelIterator r2 = this.s;
        ReceiveChannel r3 = this.r;
        Throwable r4 = this.q;
        ReceiveChannel r5 = this.p;
        ReceiveChannel r6 = this.o;
        Map r7 = this.n;
        ReceiveChannel r8 = this.m;
        Function1 r9 = this.l;
        Function1 r10 = this.k;
        ReceiveChannel r11 = this.j;
        ResultKt.b(r15);     // Catch: Throwable -> L13
    L9:
        if (((Boolean) r15).booleanValue() == false) goto L18;
        Object r16 = r2.next();     // Catch: Throwable -> L13
        Object r12 = r10.invoke(r16);     // Catch: Throwable -> L13
        Object r13 = r7.get(r12);     // Catch: Throwable -> L13
        if (r13 != null) goto L15;
        r13 = new ArrayList();     // Catch: Throwable -> L13
        r7.put(r12, r13);     // Catch: Throwable -> L13
    L15:
        ((List) r13).add(r9.invoke(r16));     // Catch: Throwable -> L13
        this.j = r11;     // Catch: Throwable -> L13
        this.k = r10;     // Catch: Throwable -> L13
        this.l = r9;     // Catch: Throwable -> L13
        this.m = r8;     // Catch: Throwable -> L13
        this.n = r7;     // Catch: Throwable -> L13
        this.o = r6;     // Catch: Throwable -> L13
        this.p = r5;     // Catch: Throwable -> L13
        this.q = r4;     // Catch: Throwable -> L13
        this.r = r3;     // Catch: Throwable -> L13
        this.s = r2;     // Catch: Throwable -> L13
        this.i = 1;     // Catch: Throwable -> L13
        r15 = r2.a(this);     // Catch: Throwable -> L13
        if (r15 != r1) goto L9;
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

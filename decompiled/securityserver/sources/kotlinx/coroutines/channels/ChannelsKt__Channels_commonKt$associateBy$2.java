package kotlinx.coroutines.channels;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2549}, m = "associateBy")
public final class ChannelsKt__Channels_commonKt$associateBy$2 extends ContinuationImpl {
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

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0077: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r13 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:23:0x0077 */
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
        if (r0 != 1) goto L18;
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
        ResultKt.b(r14);     // Catch: Throwable -> L13
    L9:
        if (((Boolean) r14).booleanValue() == false) goto L15;
        Object r15 = r2.next();     // Catch: Throwable -> L13
        r7.put(r10.invoke(r15), r9.invoke(r15));     // Catch: Throwable -> L13
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
        r14 = r2.a(this);     // Catch: Throwable -> L13
        if (r14 != r1) goto L9;
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

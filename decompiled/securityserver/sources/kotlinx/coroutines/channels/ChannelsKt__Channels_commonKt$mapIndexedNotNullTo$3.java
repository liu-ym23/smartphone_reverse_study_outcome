package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2720, 1483}, m = "mapIndexedNotNullTo")
public final class ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public SendChannel k;
    public Function2 l;
    public ReceiveChannel m;
    public Ref.IntRef n;
    public ReceiveChannel o;
    public ReceiveChannel p;
    public Throwable q;
    public ReceiveChannel r;
    public ChannelIterator s;
    public Object t;
    public Object u;
    public Object v;
    public Object w;

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00d6: INVOKE (r8 I:kotlinx.coroutines.channels.ReceiveChannel), (r1 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:34:0x00d5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0099 -> B:24:0x009d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009c -> B:24:0x009d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r18) {
        Object r1 = r18;
        this.f = r1;
        int r2 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r2;
        CoroutineSingletons r3 = CoroutineSingletons.b;
        if (r2 != 0) goto L5;
        ResultKt.b(r18);
        new Ref.IntRef().b = 0;
        throw null;     // Catch: Throwable -> L10
    L5:
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L13;
        ChannelIterator r4 = this.s;
        ReceiveChannel r6 = this.r;
        Throwable r7 = this.q;
        ReceiveChannel r8 = this.p;
        ReceiveChannel r9 = this.o;
        Ref.IntRef r10 = this.n;
        ReceiveChannel r11 = this.m;
        Function2 r12 = this.l;
        SendChannel r13 = this.k;
        ReceiveChannel r14 = this.j;
        ResultKt.b(r18);     // Catch: Throwable -> L10
        char r5 = 2;
    L24:
        this.j = r14;     // Catch: Throwable -> L10
        this.k = r13;     // Catch: Throwable -> L10
        this.l = r12;     // Catch: Throwable -> L10
        this.m = r11;     // Catch: Throwable -> L10
        this.n = r10;     // Catch: Throwable -> L10
        this.o = r9;     // Catch: Throwable -> L10
        this.p = r8;     // Catch: Throwable -> L10
        this.q = r7;     // Catch: Throwable -> L10
        this.r = r6;     // Catch: Throwable -> L10
        this.s = r4;     // Catch: Throwable -> L10
        this.i = 1;     // Catch: Throwable -> L10
        Object r15 = r4.a(this);     // Catch: Throwable -> L10
        if (r15 == r3) goto L40;
        r1 = r15;
    L17:
        if (((Boolean) r1).booleanValue() == false) goto L28;
        Object r16 = r4.next();     // Catch: Throwable -> L10
        int r17 = r10.b;     // Catch: Throwable -> L10
        r10.b = r17 + 1;     // Catch: Throwable -> L10
        new IndexedValue(r17, r16);     // Catch: Throwable -> L10
        Object r19 = r12.mo7invoke(new Integer(r17), r16);     // Catch: Throwable -> L10
        if (r19 == null) goto L23;
        this.j = r14;     // Catch: Throwable -> L10
        this.k = r13;     // Catch: Throwable -> L10
        this.l = r12;     // Catch: Throwable -> L10
        this.m = r11;     // Catch: Throwable -> L10
        this.n = r10;     // Catch: Throwable -> L10
        this.o = r9;     // Catch: Throwable -> L10
        this.p = r8;     // Catch: Throwable -> L10
        this.q = r7;     // Catch: Throwable -> L10
        this.r = r6;     // Catch: Throwable -> L10
        this.s = r4;     // Catch: Throwable -> L10
        this.t = r16;     // Catch: Throwable -> L10
        this.u = r16;     // Catch: Throwable -> L10
        this.v = r16;     // Catch: Throwable -> L10
        this.w = r19;     // Catch: Throwable -> L10
        r5 = 2;
        this.i = 2;     // Catch: Throwable -> L10
        if (r13.I(r19, this) != r3) goto L24;
        return r3;
    L23:
        r5 = 2;
        goto L24
    L28:
        ChannelsKt.a(r8, r7);
        return r13;
    L40:
        return r3;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        r4 = this.s;
        r6 = this.r;
        r7 = this.q;
        r8 = this.p;
        r9 = this.o;
        r10 = this.n;
        r11 = this.m;
        r12 = this.l;
        r13 = this.k;
        r14 = this.j;
        ResultKt.b(r18);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        ChannelsKt.a(r8, th);
        throw th;
    }
}

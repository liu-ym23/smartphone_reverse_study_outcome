package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2743, 1531}, m = "mapIndexedTo")
public final class ChannelsKt__Channels_commonKt$mapIndexedTo$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public SendChannel k;
    public Function2 l;
    public Ref.IntRef m;
    public ReceiveChannel n;
    public ReceiveChannel o;
    public Throwable p;
    public ReceiveChannel q;
    public ChannelIterator r;
    public Object s;
    public Object t;

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00b3: INVOKE (r6 I:kotlinx.coroutines.channels.ReceiveChannel), (r14 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:30:0x00b3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0081 -> B:21:0x0084). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r15) {
        this.f = r15;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r15);
        new Ref.IntRef().b = 0;
        throw null;     // Catch: Throwable -> L10
    L5:
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L13;
        ChannelIterator r2 = this.r;
        ReceiveChannel r4 = this.q;
        Throwable r5 = this.p;
        ReceiveChannel r6 = this.o;
        ReceiveChannel r7 = this.n;
        Ref.IntRef r8 = this.m;
        Function2 r9 = this.l;
        SendChannel r10 = this.k;
        ReceiveChannel r11 = this.j;
        ResultKt.b(r15);     // Catch: Throwable -> L10
    L21:
        this.j = r11;     // Catch: Throwable -> L10
        this.k = r10;     // Catch: Throwable -> L10
        this.l = r9;     // Catch: Throwable -> L10
        this.m = r8;     // Catch: Throwable -> L10
        this.n = r7;     // Catch: Throwable -> L10
        this.o = r6;     // Catch: Throwable -> L10
        this.p = r5;     // Catch: Throwable -> L10
        this.q = r4;     // Catch: Throwable -> L10
        this.r = r2;     // Catch: Throwable -> L10
        this.i = 1;     // Catch: Throwable -> L10
        r15 = r2.a(this);     // Catch: Throwable -> L10
        if (r15 != r1) goto L17;
        return r1;
    L17:
        if (((Boolean) r15).booleanValue() == false) goto L24;
        Object r16 = r2.next();     // Catch: Throwable -> L10
        int r12 = r8.b;     // Catch: Throwable -> L10
        r8.b = r12 + 1;     // Catch: Throwable -> L10
        Object r13 = r9.mo7invoke(new Integer(r12), r16);     // Catch: Throwable -> L10
        this.j = r11;     // Catch: Throwable -> L10
        this.k = r10;     // Catch: Throwable -> L10
        this.l = r9;     // Catch: Throwable -> L10
        this.m = r8;     // Catch: Throwable -> L10
        this.n = r7;     // Catch: Throwable -> L10
        this.o = r6;     // Catch: Throwable -> L10
        this.p = r5;     // Catch: Throwable -> L10
        this.q = r4;     // Catch: Throwable -> L10
        this.r = r2;     // Catch: Throwable -> L10
        this.s = r16;     // Catch: Throwable -> L10
        this.t = r16;     // Catch: Throwable -> L10
        this.i = 2;     // Catch: Throwable -> L10
        if (r10.I(r13, this) != r1) goto L21;
        return r1;
    L24:
        ChannelsKt.a(r6, r5);
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        r2 = this.r;
        r4 = this.q;
        r5 = this.p;
        r6 = this.o;
        r7 = this.n;
        r8 = this.m;
        r9 = this.l;
        r10 = this.k;
        r11 = this.j;
        ResultKt.b(r15);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        ChannelsKt.a(r6, th);
        throw th;
    }
}

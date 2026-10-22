package kotlinx.coroutines.channels;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2733}, m = "mapIndexedTo")
public final class ChannelsKt__Channels_commonKt$mapIndexedTo$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Collection k;
    public Function2 l;
    public Ref.IntRef m;
    public ReceiveChannel n;
    public ReceiveChannel o;
    public Throwable p;
    public ReceiveChannel q;
    public ChannelIterator r;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x007d: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r13 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:23:0x007d */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r14) {
        this.f = r14;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r14);
        new Ref.IntRef().b = 0;
        throw null;     // Catch: Throwable -> L13
    L5:
        if (r0 != 1) goto L18;
        ChannelIterator r2 = this.r;
        ReceiveChannel r3 = this.q;
        Throwable r4 = this.p;
        ReceiveChannel r5 = this.o;
        ReceiveChannel r6 = this.n;
        Ref.IntRef r7 = this.m;
        Function2 r8 = this.l;
        Collection r9 = this.k;
        ReceiveChannel r10 = this.j;
        ResultKt.b(r14);     // Catch: Throwable -> L13
    L9:
        if (((Boolean) r14).booleanValue() == false) goto L15;
        Object r15 = r2.next();     // Catch: Throwable -> L13
        int r11 = r7.b;     // Catch: Throwable -> L13
        r7.b = r11 + 1;     // Catch: Throwable -> L13
        r9.add(r8.mo7invoke(new Integer(r11), r15));     // Catch: Throwable -> L13
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
    L15:
        ChannelsKt.a(r5, r4);
        return r9;
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

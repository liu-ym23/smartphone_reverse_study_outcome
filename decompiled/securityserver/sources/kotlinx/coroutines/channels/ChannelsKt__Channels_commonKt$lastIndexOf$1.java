package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2366}, m = "lastIndexOf")
final class ChannelsKt__Channels_commonKt$lastIndexOf$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Object k;
    public Ref.IntRef l;
    public Ref.IntRef m;
    public ReceiveChannel n;
    public ReceiveChannel o;
    public Throwable p;
    public ReceiveChannel q;
    public ChannelIterator r;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0089: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r11 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:26:0x0089 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r12) {
        this.f = r12;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r12);
        new Ref.IntRef().b = -1;
        new Ref.IntRef().b = 0;
        throw null;     // Catch: Throwable -> L13
    L5:
        if (r0 != 1) goto L21;
        ChannelIterator r2 = this.r;
        ReceiveChannel r3 = this.q;
        Throwable r4 = this.p;
        ReceiveChannel r5 = this.o;
        ReceiveChannel r6 = this.n;
        Ref.IntRef r7 = this.m;
        Ref.IntRef r8 = this.l;
        Object r9 = this.k;
        ReceiveChannel r10 = this.j;
        ResultKt.b(r12);     // Catch: Throwable -> L13
    L9:
        if (((Boolean) r12).booleanValue() == false) goto L18;
        if (Intrinsics.a(r9, r2.next()) == false) goto L15;
        r8.b = r7.b;     // Catch: Throwable -> L13
    L15:
        r7.b++;     // Catch: Throwable -> L13
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
        r12 = r2.a(this);     // Catch: Throwable -> L13
        if (r12 != r1) goto L9;
        return r1;
    L18:
        ChannelsKt.a(r5, r4);
        return new Integer(r8.b);
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

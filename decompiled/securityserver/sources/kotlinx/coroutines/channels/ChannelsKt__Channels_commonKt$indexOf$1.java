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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2318}, m = "indexOf")
final class ChannelsKt__Channels_commonKt$indexOf$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Object k;
    public Ref.IntRef l;
    public ReceiveChannel m;
    public ReceiveChannel n;
    public Throwable o;
    public ReceiveChannel p;
    public ChannelIterator q;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0082: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r10 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:27:0x0082 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r11) {
        this.f = r11;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r11);
        new Ref.IntRef().b = 0;
        throw null;     // Catch: Throwable -> L14
    L5:
        if (r0 != 1) goto L22;
        ChannelIterator r2 = this.q;
        ReceiveChannel r3 = this.p;
        Throwable r4 = this.o;
        ReceiveChannel r5 = this.n;
        ReceiveChannel r6 = this.m;
        Ref.IntRef r7 = this.l;
        Object r8 = this.k;
        ReceiveChannel r9 = this.j;
        ResultKt.b(r11);     // Catch: Throwable -> L14
    L9:
        if (((Boolean) r11).booleanValue() == false) goto L19;
        if (Intrinsics.a(r8, r2.next()) == true) goto L12;
        r7.b++;     // Catch: Throwable -> L14
        this.j = r9;     // Catch: Throwable -> L14
        this.k = r8;     // Catch: Throwable -> L14
        this.l = r7;     // Catch: Throwable -> L14
        this.m = r6;     // Catch: Throwable -> L14
        this.n = r5;     // Catch: Throwable -> L14
        this.o = r4;     // Catch: Throwable -> L14
        this.p = r3;     // Catch: Throwable -> L14
        this.q = r2;     // Catch: Throwable -> L14
        this.i = 1;     // Catch: Throwable -> L14
        r11 = r2.a(this);     // Catch: Throwable -> L14
        if (r11 != r1) goto L9;
        return r1;
    L12:
        Integer r10 = new Integer(r7.b);     // Catch: Throwable -> L14
        ChannelsKt.a(r5, r4);
        return r10;
    L19:
        ChannelsKt.a(r5, r4);
        return new Integer(-1);
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        ChannelsKt.a(r5, th);
        throw th;
    }
}

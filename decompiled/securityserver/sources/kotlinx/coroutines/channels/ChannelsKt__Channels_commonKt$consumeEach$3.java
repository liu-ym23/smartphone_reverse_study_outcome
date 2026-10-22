package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {175}, m = "consumeEach")
public final class ChannelsKt__Channels_commonKt$consumeEach$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Function1 k;
    public ReceiveChannel l;
    public Throwable m;
    public ReceiveChannel n;
    public ChannelIterator o;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x005b: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r8 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:24:0x005b */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r9) {
        this.f = r9;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        Object r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r9);
        throw null;     // Catch: Throwable -> L13
    L5:
        if (r0 != 1) goto L19;
        ChannelIterator r2 = this.o;
        ReceiveChannel r3 = this.n;
        Throwable r4 = this.m;
        ReceiveChannel r5 = this.l;
        Function1 r6 = this.k;
        ReceiveChannel r7 = this.j;
        ResultKt.b(r9);     // Catch: Throwable -> L13
    L9:
        if (((Boolean) r9).booleanValue() == false) goto L15;
        r6.invoke(r2.next());     // Catch: Throwable -> L13
        this.j = r7;     // Catch: Throwable -> L13
        this.k = r6;     // Catch: Throwable -> L13
        this.l = r5;     // Catch: Throwable -> L13
        this.m = r4;     // Catch: Throwable -> L13
        this.n = r3;     // Catch: Throwable -> L13
        this.o = r2;     // Catch: Throwable -> L13
        this.i = 1;     // Catch: Throwable -> L13
        r9 = r2.a(this);     // Catch: Throwable -> L13
        if (r9 != r1) goto L9;
    L17:
        return r1;
    L15:
        r1 = Unit.f330a;     // Catch: Throwable -> L13
        ChannelsKt.a(r5, r4);
        goto L17
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        ChannelsKt.a(r5, th);
        throw th;
    }
}

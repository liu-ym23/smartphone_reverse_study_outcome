package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2470, 886}, m = "filterNotNullTo")
final class ChannelsKt__Channels_commonKt$filterNotNullTo$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public SendChannel k;
    public ReceiveChannel l;
    public ReceiveChannel m;
    public Throwable n;
    public ReceiveChannel o;
    public ChannelIterator p;
    public Object q;
    public Object r;

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x008d: INVOKE (r6 I:kotlinx.coroutines.channels.ReceiveChannel), (r10 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:32:0x008d */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:23:0x006a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:23:0x006a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r11) {
        this.f = r11;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r11);
        throw null;     // Catch: Throwable -> L10
    L5:
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L13;
        ChannelIterator r2 = this.p;
        ReceiveChannel r4 = this.o;
        Throwable r5 = this.n;
        ReceiveChannel r6 = this.m;
        ReceiveChannel r7 = this.l;
        SendChannel r8 = this.k;
        ReceiveChannel r9 = this.j;
        ResultKt.b(r11);     // Catch: Throwable -> L10
    L23:
        this.j = r9;     // Catch: Throwable -> L10
        this.k = r8;     // Catch: Throwable -> L10
        this.l = r7;     // Catch: Throwable -> L10
        this.m = r6;     // Catch: Throwable -> L10
        this.n = r5;     // Catch: Throwable -> L10
        this.o = r4;     // Catch: Throwable -> L10
        this.p = r2;     // Catch: Throwable -> L10
        this.i = 1;     // Catch: Throwable -> L10
        r11 = r2.a(this);     // Catch: Throwable -> L10
        if (r11 != r1) goto L17;
        return r1;
    L17:
        if (((Boolean) r11).booleanValue() == false) goto L26;
        Object r12 = r2.next();     // Catch: Throwable -> L10
        if (r12 == null) goto L23;
        this.j = r9;     // Catch: Throwable -> L10
        this.k = r8;     // Catch: Throwable -> L10
        this.l = r7;     // Catch: Throwable -> L10
        this.m = r6;     // Catch: Throwable -> L10
        this.n = r5;     // Catch: Throwable -> L10
        this.o = r4;     // Catch: Throwable -> L10
        this.p = r2;     // Catch: Throwable -> L10
        this.q = r12;     // Catch: Throwable -> L10
        this.r = r12;     // Catch: Throwable -> L10
        this.i = 2;     // Catch: Throwable -> L10
        if (r8.I(r12, this) != r1) goto L23;
        return r1;
    L26:
        ChannelsKt.a(r6, r5);
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        r2 = this.p;
        r4 = this.o;
        r5 = this.n;
        r6 = this.m;
        r7 = this.l;
        r8 = this.k;
        r9 = this.j;
        ResultKt.b(r11);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        ChannelsKt.a(r6, th);
        throw th;
    }
}

package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {543, 546}, m = "lastOrNull")
final class ChannelsKt__Channels_commonKt$lastOrNull$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public ReceiveChannel k;
    public Throwable l;
    public ReceiveChannel m;
    public ChannelIterator n;
    public Object o;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0062 -> B:22:0x0065). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r9) {
        this.f = r9;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        ReceiveChannel r2 = null;
        if (r0 != 0) goto L35;
        ResultKt.b(r9);
        throw null;     // Catch: Throwable -> L30
    L30:
        th = th;
    L39:
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        ChannelsKt.a(r2, th);
        throw th;
    L35:
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L13;
        Object r3 = this.o;
        ChannelIterator r4 = this.n;
        ReceiveChannel r5 = this.m;
        Throwable r6 = this.l;
        ReceiveChannel r7 = this.k;
        ReceiveChannel r8 = this.j;
        ResultKt.b(r9);     // Catch: Throwable -> L10
    L22:
        if (((Boolean) r9).booleanValue() == false) goto L26;
        r3 = r4.next();     // Catch: Throwable -> L10
    L19:
        this.j = r8;     // Catch: Throwable -> L10
        this.k = r7;     // Catch: Throwable -> L10
        this.l = r6;     // Catch: Throwable -> L10
        this.m = r5;     // Catch: Throwable -> L10
        this.n = r4;     // Catch: Throwable -> L10
        this.o = r3;     // Catch: Throwable -> L10
        this.i = 2;     // Catch: Throwable -> L10
        r9 = r4.a(this);     // Catch: Throwable -> L10
        if (r9 != r1) goto L22;
        return r1;
    L26:
        ChannelsKt.a(r7, r6);
        return r3;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ChannelIterator r10 = this.n;
        r5 = this.m;
        r6 = this.l;
        r7 = this.k;
        r8 = this.j;
        ResultKt.b(r9);     // Catch: Throwable -> L10
        if (((Boolean) r9).booleanValue() == true) goto L18;
        ChannelsKt.a(r7, r6);
        return null;
    L18:
        r4 = r10;
        r3 = r10.next();     // Catch: Throwable -> L10
    L10:
        th = th;
        r2 = r7;
        goto L39
    }
}

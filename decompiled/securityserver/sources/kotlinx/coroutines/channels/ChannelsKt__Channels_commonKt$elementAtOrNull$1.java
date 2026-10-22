package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {257}, m = "elementAtOrNull")
final class ChannelsKt__Channels_commonKt$elementAtOrNull$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public ReceiveChannel k;
    public Throwable l;
    public ReceiveChannel m;
    public ChannelIterator n;
    public int o;
    public int p;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r12) {
        this.f = r12;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        ReceiveChannel r2 = null;
        if (r0 != 0) goto L5;
        ResultKt.b(r12);
        throw null;     // Catch: Throwable -> L26
    L26:
        th = th;
    L35:
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        ChannelsKt.a(r2, th);
        throw th;
    L5:
        if (r0 != 1) goto L23;
        ChannelIterator r3 = this.n;
        int r4 = this.p;
        ReceiveChannel r5 = this.m;
        Throwable r6 = this.l;
        ReceiveChannel r7 = this.k;
        int r8 = this.o;
        ReceiveChannel r9 = this.j;
        ResultKt.b(r12);     // Catch: Throwable -> L18
    L9:
        if (((Boolean) r12).booleanValue() == false) goto L20;
        Object r13 = r3.next();     // Catch: Throwable -> L18
        int r10 = r4 + 1;
        if (r8 == r4) goto L13;
        this.j = r9;     // Catch: Throwable -> L18
        this.o = r8;     // Catch: Throwable -> L18
        this.k = r7;     // Catch: Throwable -> L18
        this.l = r6;     // Catch: Throwable -> L18
        this.m = r5;     // Catch: Throwable -> L18
        this.p = r10;     // Catch: Throwable -> L18
        this.n = r3;     // Catch: Throwable -> L18
        this.i = 1;     // Catch: Throwable -> L18
        r12 = r3.a(this);     // Catch: Throwable -> L18
        if (r12 == r1) goto L41;
        r4 = r10;
        goto L9
    L41:
        return r1;
    L13:
        ChannelsKt.a(r7, r6);
        return r13;
    L20:
        ChannelsKt.a(r7, r6);
        return null;
    L18:
        th = th;
        r2 = r7;
        goto L35
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

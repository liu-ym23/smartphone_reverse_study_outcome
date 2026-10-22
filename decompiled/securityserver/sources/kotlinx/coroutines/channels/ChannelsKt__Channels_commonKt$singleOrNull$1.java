package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {642, 645}, m = "singleOrNull")
final class ChannelsKt__Channels_commonKt$singleOrNull$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public ReceiveChannel k;
    public Throwable l;
    public ReceiveChannel m;
    public ChannelIterator n;
    public Object o;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r9) {
        this.f = r9;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        ReceiveChannel r2 = null;
        if (r0 != 0) goto L5;
        ResultKt.b(r9);
        throw null;     // Catch: Throwable -> L32
    L32:
        th = th;
    L43:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        ChannelsKt.a(r2, th);
        throw th;
    L5:
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L13;
        Object r3 = this.o;
        Throwable r4 = this.l;
        ReceiveChannel r8 = this.k;
        ResultKt.b(r9);     // Catch: Throwable -> L10
        Throwable r5 = r4;
        Object r6 = r3;
    L23:
        if (((Boolean) r9).booleanValue() == false) goto L26;
        ChannelsKt.a(r8, r5);
    L45:
        return null;
    L26:
        ChannelsKt.a(r8, r5);
        return r6;
    L10:
        th = th;
        r2 = r8;
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ChannelIterator r7 = this.n;
        ReceiveChannel r10 = this.m;
        r5 = this.l;
        ReceiveChannel r11 = this.k;
        ReceiveChannel r12 = this.j;
        ResultKt.b(r9);     // Catch: Throwable -> L28
        if (((Boolean) r9).booleanValue() == true) goto L19;
        ChannelsKt.a(r11, r5);
        goto L45
    L19:
        Object r13 = r7.next();     // Catch: Throwable -> L28
        this.j = r12;     // Catch: Throwable -> L28
        this.k = r11;     // Catch: Throwable -> L28
        this.l = r5;     // Catch: Throwable -> L28
        this.m = r10;     // Catch: Throwable -> L28
        this.n = r7;     // Catch: Throwable -> L28
        this.o = r13;     // Catch: Throwable -> L28
        this.i = 2;     // Catch: Throwable -> L28
        Object r14 = r7.a(this);     // Catch: Throwable -> L28
        if (r14 == r1) goto L46;
        r6 = r13;
        r9 = r14;
        r8 = r11;
        goto L23
    L46:
        return r1;
    L28:
        th = th;
        r2 = r11;
        goto L43
    }
}

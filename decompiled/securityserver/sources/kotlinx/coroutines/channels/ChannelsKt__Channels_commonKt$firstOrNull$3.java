package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2308}, m = "firstOrNull")
public final class ChannelsKt__Channels_commonKt$firstOrNull$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Function1 k;
    public ReceiveChannel l;
    public ReceiveChannel m;
    public Throwable n;
    public ReceiveChannel o;
    public ChannelIterator p;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r12) {
        this.f = r12;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        ReceiveChannel r2 = null;
        if (r0 != 0) goto L5;
        ResultKt.b(r12);
        throw null;     // Catch: Throwable -> L24
    L24:
        th = th;
    L33:
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        ChannelsKt.a(r2, th);
        throw th;
    L5:
        if (r0 != 1) goto L21;
        ChannelIterator r3 = this.p;
        ReceiveChannel r4 = this.o;
        Throwable r5 = this.n;
        ReceiveChannel r6 = this.m;
        ReceiveChannel r7 = this.l;
        Function1 r8 = this.k;
        ReceiveChannel r9 = this.j;
        ResultKt.b(r12);     // Catch: Throwable -> L16
    L9:
        if (((Boolean) r12).booleanValue() == false) goto L18;
        Object r13 = r3.next();     // Catch: Throwable -> L16
        if (((Boolean) r8.invoke(r13)).booleanValue() == true) goto L12;
        this.j = r9;     // Catch: Throwable -> L16
        this.k = r8;     // Catch: Throwable -> L16
        this.l = r7;     // Catch: Throwable -> L16
        this.m = r6;     // Catch: Throwable -> L16
        this.n = r5;     // Catch: Throwable -> L16
        this.o = r4;     // Catch: Throwable -> L16
        this.p = r3;     // Catch: Throwable -> L16
        this.i = 1;     // Catch: Throwable -> L16
        r12 = r3.a(this);     // Catch: Throwable -> L16
        if (r12 != r1) goto L9;
        return r1;
    L12:
        ChannelsKt.a(r6, r5);
        return r13;
    L18:
        ChannelsKt.a(r6, r5);
        return null;
    L16:
        th = th;
        r2 = r6;
        goto L33
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

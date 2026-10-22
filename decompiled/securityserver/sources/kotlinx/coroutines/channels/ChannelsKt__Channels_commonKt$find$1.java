package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2252}, m = "find")
public final class ChannelsKt__Channels_commonKt$find$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Function1 k;
    public ReceiveChannel l;
    public ReceiveChannel m;
    public ReceiveChannel n;
    public Throwable o;
    public ReceiveChannel p;
    public ChannelIterator q;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r13) {
        this.f = r13;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        ReceiveChannel r2 = null;
        if (r0 != 0) goto L5;
        ResultKt.b(r13);
        throw null;     // Catch: Throwable -> L24
    L24:
        th = th;
    L29:
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        ChannelsKt.a(r2, th);
        throw th;
    L5:
        if (r0 != 1) goto L21;
        ChannelIterator r3 = this.q;
        ReceiveChannel r4 = this.p;
        Throwable r5 = this.o;
        ReceiveChannel r6 = this.n;
        ReceiveChannel r7 = this.m;
        ReceiveChannel r8 = this.l;
        Function1 r9 = this.k;
        ReceiveChannel r10 = this.j;
        ResultKt.b(r13);     // Catch: Throwable -> L16
    L9:
        if (((Boolean) r13).booleanValue() == false) goto L18;
        Object r14 = r3.next();     // Catch: Throwable -> L16
        if (((Boolean) r9.invoke(r14)).booleanValue() == true) goto L12;
        this.j = r10;     // Catch: Throwable -> L16
        this.k = r9;     // Catch: Throwable -> L16
        this.l = r8;     // Catch: Throwable -> L16
        this.m = r7;     // Catch: Throwable -> L16
        this.n = r6;     // Catch: Throwable -> L16
        this.o = r5;     // Catch: Throwable -> L16
        this.p = r4;     // Catch: Throwable -> L16
        this.q = r3;     // Catch: Throwable -> L16
        this.i = 1;     // Catch: Throwable -> L16
        r13 = r3.a(this);     // Catch: Throwable -> L16
        if (r13 != r1) goto L9;
        return r1;
    L12:
        ChannelsKt.a(r6, r5);
        return r14;
    L18:
        ChannelsKt.a(r6, r5);
        return null;
    L16:
        th = th;
        r2 = r6;
        goto L29
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {86}, m = "consumeEach")
public final class ChannelsKt__Channels_commonKt$consumeEach$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public BroadcastChannel j;
    public Function1 k;
    public BroadcastChannel l;
    public ReceiveChannel m;
    public ReceiveChannel n;
    public ChannelIterator o;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r10) {
        this.f = r10;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        Object r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r10);
        throw null;
    L5:
        if (r0 != 1) goto L21;
        ChannelIterator r2 = this.o;
        ReceiveChannel r4 = this.n;
        ReceiveChannel r5 = this.m;
        BroadcastChannel r6 = this.l;
        Function1 r7 = this.k;
        BroadcastChannel r8 = this.j;
        ResultKt.b(r10);     // Catch: Throwable -> L13
    L9:
        if (((Boolean) r10).booleanValue() == false) goto L15;
        r7.invoke(r2.next());     // Catch: Throwable -> L13
        this.j = r8;     // Catch: Throwable -> L13
        this.k = r7;     // Catch: Throwable -> L13
        this.l = r6;     // Catch: Throwable -> L13
        this.m = r5;     // Catch: Throwable -> L13
        this.n = r4;     // Catch: Throwable -> L13
        this.o = r2;     // Catch: Throwable -> L13
        this.i = 1;     // Catch: Throwable -> L13
        r10 = r2.a(this);     // Catch: Throwable -> L13
        if (r10 != r1) goto L9;
    L17:
        return r1;
    L15:
        r1 = Unit.f330a;     // Catch: Throwable -> L13
        r5.a(null);
    L13:
        th = move-exception;
        r5.a(null);
        throw th;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

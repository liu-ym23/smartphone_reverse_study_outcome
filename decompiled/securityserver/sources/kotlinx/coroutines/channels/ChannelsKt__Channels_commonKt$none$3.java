package kotlinx.coroutines.channels;

import io.reactivex.annotations.SchedulerSupport;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2901}, m = SchedulerSupport.NONE)
public final class ChannelsKt__Channels_commonKt$none$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Function1 k;
    public ReceiveChannel l;
    public ReceiveChannel m;
    public Throwable n;
    public ReceiveChannel o;
    public ChannelIterator p;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x006e: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r9 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:27:0x006e */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r10) {
        this.f = r10;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r10);
        throw null;     // Catch: Throwable -> L17
    L5:
        if (r0 != 1) goto L22;
        ChannelIterator r2 = this.p;
        ReceiveChannel r3 = this.o;
        Throwable r4 = this.n;
        ReceiveChannel r5 = this.m;
        ReceiveChannel r6 = this.l;
        Function1 r7 = this.k;
        ReceiveChannel r8 = this.j;
        ResultKt.b(r10);     // Catch: Throwable -> L17
    L9:
        if (((Boolean) r10).booleanValue() == false) goto L19;
        if (((Boolean) r7.invoke(r2.next())).booleanValue() == true) goto L12;
        this.j = r8;     // Catch: Throwable -> L17
        this.k = r7;     // Catch: Throwable -> L17
        this.l = r6;     // Catch: Throwable -> L17
        this.m = r5;     // Catch: Throwable -> L17
        this.n = r4;     // Catch: Throwable -> L17
        this.o = r3;     // Catch: Throwable -> L17
        this.p = r2;     // Catch: Throwable -> L17
        this.i = 1;     // Catch: Throwable -> L17
        r10 = r2.a(this);     // Catch: Throwable -> L17
        if (r10 != r1) goto L9;
        return r1;
    L12:
        Boolean r9 = Boolean.FALSE;     // Catch: Throwable -> L17
        ChannelsKt.a(r5, r4);
        return r9;
    L19:
        ChannelsKt.a(r5, r4);
        return Boolean.TRUE;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        ChannelsKt.a(r5, th);
        throw th;
    }
}

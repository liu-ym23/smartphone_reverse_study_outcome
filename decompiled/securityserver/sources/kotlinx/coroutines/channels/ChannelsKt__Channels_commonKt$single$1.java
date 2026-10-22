package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {590, 593}, m = "single")
final class ChannelsKt__Channels_commonKt$single$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public ReceiveChannel k;
    public Throwable l;
    public ReceiveChannel m;
    public ChannelIterator n;
    public Object o;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlin.coroutines.Continuation, kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$single$1] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r8) {
        this.f = r8;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        Object r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r8);
        throw null;     // Catch: Throwable -> L10
    L5:
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L13;
        Object r2 = this.o;
        Throwable r3 = this.l;
        ReceiveChannel r7 = this.k;
        ResultKt.b(r8);     // Catch: Throwable -> L10
        Throwable r4 = r3;
        r1 = r2;
    L22:
        if (((Boolean) r8).booleanValue() == true) goto L26;
        ChannelsKt.a(r7, r4);
    L24:
        return r1;
    L26:
        throw new IllegalArgumentException("ReceiveChannel has more than one element.");     // Catch: Throwable -> L10
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ChannelIterator r5 = this.n;
        ReceiveChannel r6 = this.m;
        r4 = this.l;
        ReceiveChannel r9 = this.k;
        ReceiveChannel r10 = this.j;
        ResultKt.b(r8);     // Catch: Throwable -> L27
        if (((Boolean) r8).booleanValue() == false) goto L30;
        Object r11 = r5.next();     // Catch: Throwable -> L27
        this.j = r10;     // Catch: Throwable -> L27
        this.k = r9;     // Catch: Throwable -> L27
        this.l = r4;     // Catch: Throwable -> L27
        this.m = r6;     // Catch: Throwable -> L27
        this.n = r5;     // Catch: Throwable -> L27
        this.o = r11;     // Catch: Throwable -> L27
        this.i = 2;     // Catch: Throwable -> L27
        Object r12 = r5.a(this);     // Catch: Throwable -> L27
        if (r12 == r1) goto L24;
        r1 = r11;
        r8 = r12;
        r7 = r9;
        goto L22
    L30:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L27
    L27:
        th = th;
        ChannelsKt__Channels_commonKt$single$1 this = r9;
    L37:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        ChannelsKt.a(this, th);
        throw th;
    L10:
        th = th;
        goto L37
    }
}

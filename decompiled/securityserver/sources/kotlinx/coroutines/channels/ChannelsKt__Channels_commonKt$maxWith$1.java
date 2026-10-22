package kotlinx.coroutines.channels;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {1912, 1914}, m = "maxWith")
final class ChannelsKt__Channels_commonKt$maxWith$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Comparator k;
    public ReceiveChannel l;
    public Throwable m;
    public ReceiveChannel n;
    public ChannelIterator o;
    public Object p;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:23:0x006b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r11) {
        this.f = r11;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        ReceiveChannel r2 = null;
        if (r0 != 0) goto L39;
        ResultKt.b(r11);
        throw null;     // Catch: Throwable -> L32
    L32:
        th = th;
    L41:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        ChannelsKt.a(r2, th);
        throw th;
    L39:
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L13;
        Object r3 = this.p;
        ChannelIterator r4 = this.o;
        ReceiveChannel r5 = this.n;
        Throwable r6 = this.m;
        ReceiveChannel r7 = this.l;
        Comparator r8 = this.k;
        ReceiveChannel r9 = this.j;
        ResultKt.b(r11);     // Catch: Throwable -> L10
    L23:
        if (((Boolean) r11).booleanValue() == false) goto L28;
        Object r12 = r4.next();     // Catch: Throwable -> L10
        if (r8.compare(r3, r12) < 0) goto L19;
    L20:
        this.j = r9;     // Catch: Throwable -> L10
        this.k = r8;     // Catch: Throwable -> L10
        this.l = r7;     // Catch: Throwable -> L10
        this.m = r6;     // Catch: Throwable -> L10
        this.n = r5;     // Catch: Throwable -> L10
        this.o = r4;     // Catch: Throwable -> L10
        this.p = r3;     // Catch: Throwable -> L10
        this.i = 2;     // Catch: Throwable -> L10
        r11 = r4.a(this);     // Catch: Throwable -> L10
        if (r11 != r1) goto L23;
        return r1;
    L19:
        r3 = r12;
        goto L20
    L28:
        ChannelsKt.a(r7, r6);
        return r3;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ChannelIterator r10 = this.o;
        r5 = this.n;
        r6 = this.m;
        r7 = this.l;
        r8 = this.k;
        r9 = this.j;
        ResultKt.b(r11);     // Catch: Throwable -> L10
        if (((Boolean) r11).booleanValue() == true) goto L18;
        ChannelsKt.a(r7, r6);
        return null;
    L18:
        r12 = r10.next();     // Catch: Throwable -> L10
        r4 = r10;
    L10:
        th = th;
        r2 = r7;
        goto L41
    }
}

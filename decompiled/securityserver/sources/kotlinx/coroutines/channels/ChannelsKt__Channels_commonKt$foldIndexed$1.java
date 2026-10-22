package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2851}, m = "foldIndexed")
public final class ChannelsKt__Channels_commonKt$foldIndexed$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Object k;
    public Function3 l;
    public Ref.IntRef m;
    public Ref.ObjectRef n;
    public ReceiveChannel o;
    public ReceiveChannel p;
    public Throwable q;
    public ReceiveChannel r;
    public ChannelIterator s;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x008a: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r14 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:23:0x008a */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r15) {
        this.f = r15;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r15);
        new Ref.IntRef().b = 0;
        new Ref.ObjectRef().b = null;
        throw null;     // Catch: Throwable -> L13
    L5:
        if (r0 != 1) goto L18;
        ChannelIterator r2 = this.s;
        ReceiveChannel r3 = this.r;
        Throwable r4 = this.q;
        ReceiveChannel r5 = this.p;
        ReceiveChannel r6 = this.o;
        Ref.ObjectRef r7 = this.n;
        Ref.IntRef r8 = this.m;
        Function3 r9 = this.l;
        Object r10 = this.k;
        ReceiveChannel r11 = this.j;
        ResultKt.b(r15);     // Catch: Throwable -> L13
    L9:
        if (((Boolean) r15).booleanValue() == false) goto L15;
        Object r16 = r2.next();     // Catch: Throwable -> L13
        int r12 = r8.b;     // Catch: Throwable -> L13
        r8.b = r12 + 1;     // Catch: Throwable -> L13
        r7.b = r9.b(new Integer(r12), r7.b, r16);     // Catch: Throwable -> L13
        this.j = r11;     // Catch: Throwable -> L13
        this.k = r10;     // Catch: Throwable -> L13
        this.l = r9;     // Catch: Throwable -> L13
        this.m = r8;     // Catch: Throwable -> L13
        this.n = r7;     // Catch: Throwable -> L13
        this.o = r6;     // Catch: Throwable -> L13
        this.p = r5;     // Catch: Throwable -> L13
        this.q = r4;     // Catch: Throwable -> L13
        this.r = r3;     // Catch: Throwable -> L13
        this.s = r2;     // Catch: Throwable -> L13
        this.i = 1;     // Catch: Throwable -> L13
        r15 = r2.a(this);     // Catch: Throwable -> L13
        if (r15 != r1) goto L9;
        return r1;
    L15:
        ChannelsKt.a(r5, r4);
        return r7.b;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        ChannelsKt.a(r5, th);
        throw th;
    }
}

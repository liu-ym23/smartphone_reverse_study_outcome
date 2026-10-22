package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2402}, m = "single")
public final class ChannelsKt__Channels_commonKt$single$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Function1 k;
    public Ref.ObjectRef l;
    public Ref.BooleanRef m;
    public ReceiveChannel n;
    public ReceiveChannel o;
    public Throwable p;
    public ReceiveChannel q;
    public ChannelIterator r;

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x009c: INVOKE (r5 I:kotlinx.coroutines.channels.ReceiveChannel), (r12 I:java.lang.Throwable) STATIC call: kotlinx.coroutines.channels.ChannelsKt.a(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void A[MD:(kotlinx.coroutines.channels.ReceiveChannel, java.lang.Throwable):void (m)], block:B:34:0x009c */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r13) {
        this.f = r13;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r13);
        new Ref.ObjectRef().b = null;
        new Ref.BooleanRef().b = false;
        throw null;     // Catch: Throwable -> L15
    L5:
        if (r0 != 1) goto L29;
        ChannelIterator r2 = this.r;
        ReceiveChannel r3 = this.q;
        Throwable r4 = this.p;
        ReceiveChannel r5 = this.o;
        ReceiveChannel r6 = this.n;
        Ref.BooleanRef r7 = this.m;
        Ref.ObjectRef r8 = this.l;
        Function1 r9 = this.k;
        ReceiveChannel r10 = this.j;
        ResultKt.b(r13);     // Catch: Throwable -> L15
    L9:
        if (((Boolean) r13).booleanValue() == false) goto L22;
        Object r14 = r2.next();     // Catch: Throwable -> L15
        if (((Boolean) r9.invoke(r14)).booleanValue() == true) goto L13;
    L19:
        this.j = r10;     // Catch: Throwable -> L15
        this.k = r9;     // Catch: Throwable -> L15
        this.l = r8;     // Catch: Throwable -> L15
        this.m = r7;     // Catch: Throwable -> L15
        this.n = r6;     // Catch: Throwable -> L15
        this.o = r5;     // Catch: Throwable -> L15
        this.p = r4;     // Catch: Throwable -> L15
        this.q = r3;     // Catch: Throwable -> L15
        this.r = r2;     // Catch: Throwable -> L15
        this.i = 1;     // Catch: Throwable -> L15
        r13 = r2.a(this);     // Catch: Throwable -> L15
        if (r13 != r1) goto L9;
        return r1;
    L13:
        if (r7.b == true) goto L18;
        r8.b = r14;     // Catch: Throwable -> L15
        r7.b = true;     // Catch: Throwable -> L15
        goto L19
    L18:
        throw new IllegalArgumentException("ReceiveChannel contains more than one matching element.");     // Catch: Throwable -> L15
    L22:
        ChannelsKt.a(r5, r4);
        if (r7.b == false) goto L27;
        return r8.b;
    L27:
        throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        ChannelsKt.a(r5, th);
        throw th;
    }
}

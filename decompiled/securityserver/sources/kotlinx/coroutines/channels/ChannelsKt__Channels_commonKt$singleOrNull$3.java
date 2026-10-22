package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2420}, m = "singleOrNull")
public final class ChannelsKt__Channels_commonKt$singleOrNull$3 extends ContinuationImpl {
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r14) {
        this.f = r14;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        ReceiveChannel r2 = null;
        if (r0 != 0) goto L5;
        ResultKt.b(r14);
        new Ref.ObjectRef().b = null;
        new Ref.BooleanRef().b = false;
        throw null;     // Catch: Throwable -> L31
    L31:
        th = th;
    L38:
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        ChannelsKt.a(r2, th);
        throw th;
    L5:
        if (r0 != 1) goto L28;
        ChannelIterator r3 = this.r;
        ReceiveChannel r4 = this.q;
        Throwable r5 = this.p;
        ReceiveChannel r6 = this.o;
        ReceiveChannel r7 = this.n;
        Ref.BooleanRef r8 = this.m;
        Ref.ObjectRef r9 = this.l;
        Function1 r10 = this.k;
        ReceiveChannel r11 = this.j;
        ResultKt.b(r14);     // Catch: Throwable -> L17
    L8:
        if (((Boolean) r14).booleanValue() == false) goto L22;
        Object r15 = r3.next();     // Catch: Throwable -> L17
        if (((Boolean) r10.invoke(r15)).booleanValue() == true) goto L13;
    L19:
        this.j = r11;     // Catch: Throwable -> L17
        this.k = r10;     // Catch: Throwable -> L17
        this.l = r9;     // Catch: Throwable -> L17
        this.m = r8;     // Catch: Throwable -> L17
        this.n = r7;     // Catch: Throwable -> L17
        this.o = r6;     // Catch: Throwable -> L17
        this.p = r5;     // Catch: Throwable -> L17
        this.q = r4;     // Catch: Throwable -> L17
        this.r = r3;     // Catch: Throwable -> L17
        this.i = 1;     // Catch: Throwable -> L17
        r14 = r3.a(this);     // Catch: Throwable -> L17
        if (r14 != r1) goto L8;
        return r1;
    L13:
        if (r8.b == true) goto L14;
        r9.b = r15;     // Catch: Throwable -> L17
        r8.b = true;     // Catch: Throwable -> L17
        goto L19
    L14:
        ChannelsKt.a(r6, r5);
    L46:
        return null;
    L22:
        ChannelsKt.a(r6, r5);
        if (r8.b == false) goto L46;
        return r9.b;
    L17:
        th = th;
        r2 = r6;
        goto L38
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

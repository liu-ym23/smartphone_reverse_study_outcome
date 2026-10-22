package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {355}, m = "firstOrNull")
final class ChannelsKt__Channels_commonKt$firstOrNull$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r4) {
        this.f = r4;
        int r1 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r1;
        if (r1 != 0) goto L5;
        ResultKt.b(r4);
        throw null;     // Catch: Throwable -> L12
    L5:
        if (r1 != 1) goto L15;
        ResultKt.b(r4);     // Catch: Throwable -> L12
        if (((Boolean) r4).booleanValue() == true) goto L11;
        throw null;
    L11:
        throw null;     // Catch: Throwable -> L12
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        ChannelsKt.a(null, th);
        throw th;
    }
}

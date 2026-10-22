package kotlinx.coroutines.channels;

import io.reactivex.annotations.SchedulerSupport;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {1991}, m = SchedulerSupport.NONE)
final class ChannelsKt__Channels_commonKt$none$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r4) {
        this.f = r4;
        int r1 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r1;
        if (r1 != 0) goto L5;
        ResultKt.b(r4);
        throw null;     // Catch: Throwable -> L9
    L5:
        if (r1 != 1) goto L12;
        ResultKt.b(r4);     // Catch: Throwable -> L9
        ((Boolean) r4).booleanValue();     // Catch: Throwable -> L9
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        ChannelsKt.a(null, th);
        throw th;
    }
}

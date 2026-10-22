package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {50, 61}, m = "emitAllImpl$FlowKt__ChannelsKt")
final class FlowKt__ChannelsKt$emitAllImpl$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public FlowCollector j;
    public ReceiveChannel k;
    public Throwable l;
    public Object m;
    public boolean n;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r2) {
        this.f = r2;
        this.i |= Integer.MIN_VALUE;
        return FlowKt__ChannelsKt.a(null, null, false, this);
    }
}

package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {2592, 1167}, m = "toChannel")
final class ChannelsKt__Channels_commonKt$toChannel$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public SendChannel k;
    public ReceiveChannel l;
    public ReceiveChannel m;
    public Throwable n;
    public ReceiveChannel o;
    public ChannelIterator p;
    public Object q;
    public Object r;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r2) {
        this.f = r2;
        this.i |= Integer.MIN_VALUE;
        return ChannelsKt.b(null, null, this);
    }
}

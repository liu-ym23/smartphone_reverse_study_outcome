package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", l = {458}, m = "next")
final class ChannelIterator$next0$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ChannelIterator j;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r3) {
        this.f = r3;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L12;
        ChannelIterator r2 = this.j;
        ResultKt.b(r3);
        if (((Boolean) r3).booleanValue() == false) goto L10;
        return r2.next();
    L10:
        throw new ClosedReceiveChannelException("Channel was closed");
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.b(r3);
        this.j = null;
        this.i = 1;
        throw null;
    }
}

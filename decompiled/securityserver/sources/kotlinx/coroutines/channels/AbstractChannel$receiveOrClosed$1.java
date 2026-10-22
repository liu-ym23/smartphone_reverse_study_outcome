package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", l = {624}, m = "receiveOrClosed-ZYPwvRU")
final class AbstractChannel$receiveOrClosed$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public final /* synthetic */ AbstractChannel j;
    public Object k;

    public AbstractChannel$receiveOrClosed$1(AbstractChannel r1, Continuation r2) {
        this.j = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r2) {
        this.f = r2;
        this.i |= Integer.MIN_VALUE;
        return this.j.G(this);
    }
}

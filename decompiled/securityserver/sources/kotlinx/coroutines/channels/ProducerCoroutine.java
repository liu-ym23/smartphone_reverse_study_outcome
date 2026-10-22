package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class ProducerCoroutine<E> extends ChannelCoroutine<E> implements ProducerScope<E> {
    @Override // kotlinx.coroutines.channels.ProducerScope
    public final SendChannel getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void v0(Throwable r2, boolean r3) {
        if (this.f.z(r2) == true) goto L7;
        if (r3 == true) goto L8;
        CoroutineExceptionHandlerKt.a(this.c, r2);
        return;
    L8:
        return;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void w0(Object r1) {
        Unit r2 = (Unit) r1;
        this.f.z(null);
    }
}

package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectClause2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class LazyActorCoroutine<E> extends ActorCoroutine<E> implements SelectClause2<E, SendChannel<? super E>> {
    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public final Object I(Object r1, Continuation r2) {
        start();
        Object r0 = this.f.I(r1, r2);
        if (r0 != CoroutineSingletons.b) goto L6;
        return r0;
    L6:
        return Unit.f330a;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void x0() {
        CancellableKt.a(null, this);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public final boolean z(Throwable r2) {
        boolean r3 = this.f.z(r2);
        start();
        return r3;
    }
}

package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.intrinsics.CancellableKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class LazyBroadcastCoroutine<E> extends BroadcastCoroutine<E> {
    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void x0() {
        CancellableKt.a(null, this);
    }
}

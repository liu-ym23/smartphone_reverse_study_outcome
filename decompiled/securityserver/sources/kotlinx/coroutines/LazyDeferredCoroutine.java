package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.intrinsics.CancellableKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class LazyDeferredCoroutine<T> extends DeferredCoroutine<T> {
    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void x0() {
        CancellableKt.a(null, this);
    }
}

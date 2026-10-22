package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    public final Continuation f;

    public LazyStandaloneCoroutine(CoroutineContext r2, Function2 r3) {
        super(r2, false);
        this.f = IntrinsicsKt.a(this, this, r3);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void x0() {
        CancellableKt.a(this.f, this);
    }
}

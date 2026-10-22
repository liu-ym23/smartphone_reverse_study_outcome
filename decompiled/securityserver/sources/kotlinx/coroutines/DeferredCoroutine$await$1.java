package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.DeferredCoroutine", f = "Builders.common.kt", l = {101}, m = "await$suspendImpl")
final class DeferredCoroutine$await$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r2) {
        this.f = r2;
        this.i |= Integer.MIN_VALUE;
        int r1 = DeferredCoroutine.f;
        throw null;
    }
}

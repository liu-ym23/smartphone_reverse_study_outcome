package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class DebugProbesImpl$dumpCoroutinesSynchronized$1$2 extends Lambda implements Function1<DebugProbesImpl.CoroutineOwner<?>, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        ConcurrentWeakMap r0 = DebugProbesImpl.f393a;
        ((DebugProbesImpl.CoroutineOwner) r1).getClass();
        throw null;
    }
}

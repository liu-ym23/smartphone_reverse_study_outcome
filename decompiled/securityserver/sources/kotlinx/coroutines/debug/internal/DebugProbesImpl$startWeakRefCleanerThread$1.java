package kotlinx.coroutines.debug.internal;

import java.lang.ref.Reference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class DebugProbesImpl$startWeakRefCleanerThread$1 extends Lambda implements Function0<Unit> {
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ConcurrentWeakMap r4 = DebugProbesImpl.c;
        if (r4.b == null) goto L19;
    L20:
        Reference r0 = r4.b.remove();     // Catch: InterruptedException -> L16
        if (r0 == null) goto L15;
        HashedWeakRef r1 = (HashedWeakRef) r0;     // Catch: InterruptedException -> L16
        ConcurrentWeakMap.Core r2 = (ConcurrentWeakMap.Core) r4.core;     // Catch: InterruptedException -> L16
        r2.getClass();     // Catch: InterruptedException -> L16
        int r3 = (r1.f394a * (-1640531527)) >>> r2.f390a;     // Catch: InterruptedException -> L16
    L7:
        HashedWeakRef r5 = (HashedWeakRef) r2.c.get(r3);     // Catch: InterruptedException -> L16
        if (r5 == null) goto L20;
        if (r5 == r1) goto L10;
        if (r3 != 0) goto L13;
        r3 = r2.e;     // Catch: InterruptedException -> L16
    L13:
        r3 = r3 - 1;     // Catch: InterruptedException -> L16
        goto L7
    L10:
        r2.c(r3);     // Catch: InterruptedException -> L16
        goto L20
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");     // Catch: InterruptedException -> L16
    L16:
        Thread.currentThread().interrupt();
        return Unit.f330a;
    L19:
        throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
    }
}

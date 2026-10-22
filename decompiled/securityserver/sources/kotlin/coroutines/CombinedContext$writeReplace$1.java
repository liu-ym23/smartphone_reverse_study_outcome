package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class CombinedContext$writeReplace$1 extends Lambda implements Function2<Unit, CoroutineContext.Element, Unit> {
    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        Intrinsics.f((Unit) r1, "<anonymous parameter 0>");
        Intrinsics.f((CoroutineContext.Element) r2, "element");
        throw null;
    }
}

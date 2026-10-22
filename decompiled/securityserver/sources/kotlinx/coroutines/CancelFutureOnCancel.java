package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class CancelFutureOnCancel extends CancelHandler {
    @Override // kotlinx.coroutines.CancelHandlerBase
    public final void c(Throwable r1) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        c((Throwable) r1);
        return Unit.f330a;
    }

    public final String toString() {
        throw null;
    }
}

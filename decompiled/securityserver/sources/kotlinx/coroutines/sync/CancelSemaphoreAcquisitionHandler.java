package kotlinx.coroutines.sync;

import a.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class CancelSemaphoreAcquisitionHandler extends CancelHandler {
    public final SemaphoreSegment b;
    public final int c;

    public CancelSemaphoreAcquisitionHandler(SemaphoreSegment r1, int r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public final void c(Throwable r3) {
        SemaphoreSegment r4 = this.b;
        r4.getClass();
        Symbol r0 = SemaphoreKt.e;
        r4.e.set(this.c, r0);
        if (Segment.f424d.incrementAndGet(r4) == SemaphoreKt.f) goto L5;
        return;
    L5:
        if (r4.c() == true) goto L9;
        r4.d();
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        c((Throwable) r1);
        return Unit.f330a;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("CancelSemaphoreAcquisitionHandler[");
        r0.append(this.b);
        r0.append(", ");
        return a.l(r0, this.c, ']');
    }
}

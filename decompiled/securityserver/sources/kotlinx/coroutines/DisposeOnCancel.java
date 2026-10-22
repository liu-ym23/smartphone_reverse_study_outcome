package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class DisposeOnCancel extends CancelHandler {
    public final DisposableHandle b;

    public DisposeOnCancel(DisposableHandle r1) {
        this.b = r1;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public final void c(Throwable r1) {
        this.b.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        c((Throwable) r1);
        return Unit.f330a;
    }

    public final String toString() {
        return "DisposeOnCancel[" + this.b + ']';
    }
}

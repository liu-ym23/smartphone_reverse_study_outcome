package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class InvokeOnCancel extends CancelHandler {
    public final Function1 b;

    public InvokeOnCancel(Function1 r1) {
        this.b = r1;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public final void c(Throwable r1) {
        this.b.invoke(r1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        c((Throwable) r1);
        return Unit.f330a;
    }

    public final String toString() {
        return "InvokeOnCancel[" + this.b.getClass().getSimpleName() + '@' + DebugStringsKt.a(this) + ']';
    }
}

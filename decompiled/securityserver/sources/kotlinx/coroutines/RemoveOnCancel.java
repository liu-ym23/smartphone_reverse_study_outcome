package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class RemoveOnCancel extends BeforeResumeCancelHandler {
    public final LockFreeLinkedListNode b;

    public RemoveOnCancel(LockFreeLinkedListNode r1) {
        this.b = r1;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public final void c(Throwable r1) {
        this.b.G();
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
        c((Throwable) r1);
        return Unit.f330a;
    }

    public final String toString() {
        return "RemoveOnCancel[" + this.b + ']';
    }
}

package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SendElementWithUndeliveredHandler<E> extends SendElement<E> {
    public final Function1 j;

    public SendElementWithUndeliveredHandler(Object r1, CancellableContinuationImpl r2, Function1 r3) {
        super(r1, r2);
        this.j = r3;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final boolean G() {
        if (super.G() == true) goto L6;
        return false;
    L6:
        O();
        return true;
    }

    @Override // kotlinx.coroutines.channels.Send
    public final void O() {
        CoroutineContext r0 = this.i.getContext();
        UndeliveredElementException r3 = OnUndeliveredElementKt.b(this.j, this.f, null);
        if (r3 == null) goto L6;
        CoroutineExceptionHandlerKt.a(r0, r3);
        return;
    }
}

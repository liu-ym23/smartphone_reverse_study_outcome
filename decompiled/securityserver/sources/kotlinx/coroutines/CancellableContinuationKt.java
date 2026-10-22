package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CancellableContinuationKt {
    public static final CancellableContinuationImpl a(Continuation r3) {
        if ((r3 instanceof DispatchedContinuation) == false) goto L5;
        CancellableContinuationImpl r0 = ((DispatchedContinuation) r3).l();
        if (r0 == null) goto L15;
        if (r0.z() == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L15;
        return r0;
    L15:
        return new CancellableContinuationImpl(2, r3);
    L5:
        return new CancellableContinuationImpl(2, r3);
    }

    public static final void b(CancellableContinuationImpl r1, LockFreeLinkedListNode r2) {
        r1.u(new RemoveOnCancel(r2));
    }
}

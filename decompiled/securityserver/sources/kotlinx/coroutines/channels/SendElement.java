package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class SendElement<E> extends Send {
    public final Object f;
    public final CancellableContinuation i;

    public SendElement(Object r1, CancellableContinuationImpl r2) {
        this.f = r1;
        this.i = r2;
    }

    @Override // kotlinx.coroutines.channels.Send
    public final void K() {
        this.i.g();
    }

    @Override // kotlinx.coroutines.channels.Send
    public final Object L() {
        return this.f;
    }

    @Override // kotlinx.coroutines.channels.Send
    public final void M(Closed r1) {
        Result.Failure r2 = ResultKt.a(r1.Q());
        this.i.k(r2);
    }

    @Override // kotlinx.coroutines.channels.Send
    public final Symbol N(LockFreeLinkedListNode.PrepareOp r4) {
        Unit r0 = Unit.f330a;
        if (r4 == null) goto L5;
        LockFreeLinkedListNode.AbstractAtomicDesc r2 = r4.c;
    L7:
        if (this.i.c(r0, r2) == null) goto L13;
        boolean r3 = DebugKt.f370a;
        if (r4 == null) goto L12;
        r4.d();
    L12:
        return CancellableContinuationImplKt.f361a;
    L13:
        return null;
    L5:
        r2 = null;
        goto L7
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        return getClass().getSimpleName() + '@' + DebugStringsKt.a(this) + '(' + this.f + ')';
    }
}

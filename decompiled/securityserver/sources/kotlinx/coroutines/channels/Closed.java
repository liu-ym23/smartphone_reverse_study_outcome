package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Closed<E> extends Send implements ReceiveOrClosed<E> {
    public final Throwable f;

    public Closed(Throwable r1) {
        this.f = r1;
    }

    @Override // kotlinx.coroutines.channels.Send
    public final void K() {
    }

    @Override // kotlinx.coroutines.channels.Send
    public final Object L() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.Send
    public final void M(Closed r1) {
        boolean r0 = DebugKt.f370a;
    }

    @Override // kotlinx.coroutines.channels.Send
    public final Symbol N(LockFreeLinkedListNode.PrepareOp r1) {
        Symbol r0 = CancellableContinuationImplKt.f361a;
        if (r1 == null) goto L5;
        r1.d();
    L5:
        return r0;
    }

    public final Throwable P() {
        Throwable r1 = this.f;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return new ClosedReceiveChannelException("Channel was closed");
    }

    public final Throwable Q() {
        Throwable r1 = this.f;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return new ClosedSendChannelException("Channel was closed");
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public final Object f() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public final void o(Object r1) {
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public final Symbol r(Object r1, LockFreeLinkedListNode.PrepareOp r2) {
        Symbol r0 = CancellableContinuationImplKt.f361a;
        if (r2 == null) goto L5;
        r2.d();
    L5:
        return r0;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        return "Closed@" + DebugStringsKt.a(this) + '[' + this.f + ']';
    }
}

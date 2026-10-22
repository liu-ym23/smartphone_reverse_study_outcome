package kotlinx.coroutines.channels;

import d.b;
import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class LinkedListChannel<E> extends AbstractChannel<E> {
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean h() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean i() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final Object k(Object r6) {
    L2:
        Object r0 = super.k(r6);
        Symbol r1 = AbstractChannelKt.b;
        if (r0 == r1) goto L4;
        if (r0 != AbstractChannelKt.c) goto L20;
        LockFreeLinkedListHead r2 = this.b;
        AbstractSendChannel.SendBuffered r3 = new AbstractSendChannel.SendBuffered(r6);
    L8:
        LockFreeLinkedListNode r4 = r2.C();
        if ((r4 instanceof ReceiveOrClosed) == true) goto L10;
        if (r4.t(r3, r2) == false) goto L8;
        ReceiveOrClosed r5 = null;
    L14:
        if (r5 == null) goto L15;
        if ((r5 instanceof Closed) == false) goto L2;
        return r5;
    L15:
        return r1;
    L10:
        r5 = (ReceiveOrClosed) r4;
        goto L14
    L20:
        if ((r0 instanceof Closed) == false) goto L23;
        return r0;
    L23:
        throw new IllegalStateException(b.a(r0, "Invalid offerInternal result ").toString());
    L4:
        return r1;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean r() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean t() {
        return true;
    }
}
